package br.unilins.es.compiladores.codegenerator;

import br.unilins.es.compiladores.codegenerator.TabelaDeSimbolos.TipoLang;

    // ESSA CLASSE CONVERTE O PROGRAMA NA LINGUAGEM DESENVOLVIDA EM UM EQUIVALENTE
    // EM LINGUAGEM C, DANDO NO FINAL, O MESMO RESULTADO INDEPENDENTE DO ALGORITMO
    // DESDE QUE AS REGRAS DA GRAMATICA SEJAM RESPEITADAS.

public class LangGeradorC extends LangGrammarBaseVisitor<Void> {
    StringBuilder saida;
    TabelaDeSimbolos tabela;

    public LangGeradorC() {
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
    }

    @Override
    //INSERE A ESTRUTURA BÁSICA E AS IMPORTAÇÕES NECESSÁRIAS DA LINGUAGEM C
    public Void visitPrograma(LangGrammarParser.ProgramaContext ctx) {
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        saida.append("\n");
        ctx.declaracao().forEach(dec -> visitDeclaracao(dec));
        saida.append("\n");
        saida.append("int main() {\n");
        ctx.comando().forEach(cmd -> visitComando(cmd));
        saida.append("}\n");
        return null;
    }

    @Override
    // CONVERTE A ESTRUTURA TIPO_VAR DA LINGUAGEM PARA O EQUIVALENTE EM LINGUAGEM C
    public Void visitDeclaracao(LangGrammarParser.DeclaracaoContext ctx) {
        String nomeVar = ctx.VARIAVEL().getText();
        String strTipoVar = ctx.TIPO_VAR().getText();
        TabelaDeSimbolos.TipoLang tipoVar = TabelaDeSimbolos.TipoLang.INVALIDO;
        switch (strTipoVar) {
            case "INTEIRO":
                tipoVar = TabelaDeSimbolos.TipoLang.INTEIRO;
                strTipoVar = "int";
                break;
            case "REAL":
                tipoVar = TabelaDeSimbolos.TipoLang.REAL;
                strTipoVar = "float";
                break;
            default:
                break;
        }
        tabela.adicionar(nomeVar, tipoVar);
        saida.append(strTipoVar + " " + nomeVar + ";\n");
        return null;
    }

    @Override
    // INSERE O OPERADOR DE ATRIBUIÇÃO DA LINGUAGEM DESENVOLVIDA NO EQUIVALENTE EM LINGUAGEM C
    // NO CASO É A MESMA COISA, O CARACTERE "="
    public Void visitComandoAtribuicao(LangGrammarParser.ComandoAtribuicaoContext ctx) {
        saida.append(ctx.VARIAVEL().getText() + " = ");
        visitExpressaoAritmetica(ctx.expressaoAritmetica());
        saida.append(";\n");
        return null;
    }

    @Override
    // CONVERTE A ESTRUTURA BÁSICA DO LAÇO CONDICIONAL NO EQUIVALENTE EM LINGUAGEM C
    public Void visitComandoCondicao(LangGrammarParser.ComandoCondicaoContext ctx) {
        saida.append("if(");
        visitExpressaoRelacional(ctx.expressaoRelacional());
        saida.append(")\n");
        visitComando(ctx.comando(0));
        if (ctx.comando().size() > 1) {
            saida.append("else\n");
            visitComando(ctx.comando(1));
        }
        return null;
    }

    @Override
    //CONVERTE O COMANDO DE LEITURA DE INSERÇÃO DE DADOS DA LINGUAGEM DESENVOLVIDA
    //NO EQUIVALENTE EM LINGUAGEM EM C
    public Void visitComandoEntrada(LangGrammarParser.ComandoEntradaContext ctx) {
        String nomeVar = ctx.VARIAVEL().getText();
        TipoLang tipoVariavel = LangSemanticUtils.verificarTipo(tabela, nomeVar);
        String aux = "";
        switch (tipoVariavel) {
            case INTEIRO:
                aux = "%d";
                break;
            case REAL:
                aux = "%f";
                break;
        }
        saida.append("scanf(\"" + aux + "\", &" + nomeVar + ");\n");
        return null;
    }

    @Override
    // CONVERTE A ESTRUTURA DE REPETIÇÃO BÁSICA DA LINGUAGEM DESENVOLVIDA
    // NO EQUIVALENTE EM LINGUAGEM C
    public Void visitComandoRepeticao(LangGrammarParser.ComandoRepeticaoContext ctx) {
        saida.append("while(");
        visitExpressaoRelacional(ctx.expressaoRelacional());
        saida.append(")\n");
        visitComando(ctx.comando());
        return null;
    }

    @Override
    //ESTRUTURA O COMANDO IMPRIMIR DA LINGUAGEM DESENVOLVIDA NO EQUIVALENTE
    //EM LINGUAGEM C
    public Void visitComandoSaida(LangGrammarParser.ComandoSaidaContext ctx) {
        if (ctx.CADEIA() != null) {
            String aux = ctx.CADEIA().getText();
            aux = aux.substring(1, aux.length() - 1);
            saida.append("printf(\"" + aux + "\\n\");\n");
        } else {
            TipoLang tipoExpressao = LangSemanticUtils.verificarTipo(tabela, ctx.expressaoAritmetica());
            String aux = "";
            switch (tipoExpressao) {
                case INTEIRO:
                    aux = "%d";
                    break;
                case REAL:
                    aux = "%f";
                    break;
            }
            saida.append("printf(\"" + aux + "\\n\",");
            visitExpressaoAritmetica(ctx.expressaoAritmetica());
            saida.append(");\n");
        }
        return null;
    }

    @Override
    //
    public Void visitSubAlgoritmo(LangGrammarParser.SubAlgoritmoContext ctx) {
        saida.append("{\n");
        ctx.comando().forEach(cmd -> visitComando(cmd));
        saida.append("}\n");
        return null;
    }

    @Override
    //ESTRUTURA A EXPRESSAO ARITMETICA DA LINGUAGEM NO EQUIVALENTE EM LINGUAGEM C
    public Void visitExpressaoAritmetica(LangGrammarParser.ExpressaoAritmeticaContext ctx) {
        visitTermoAritmetico(ctx.termoAritmetico(0));
        for (int i = 0; i < ctx.OP_ARIT1().size(); i++) {
            saida.append(" " + ctx.OP_ARIT1(i).getText() + " ");
            visitTermoAritmetico(ctx.termoAritmetico(i + 1));
        }
        return null;
    }

    @Override
    //
    public Void visitTermoAritmetico(LangGrammarParser.TermoAritmeticoContext ctx) {
        visitFatorAritmetico(ctx.fatorAritmetico(0));
        for (int i = 0; i < ctx.OP_ARIT2().size(); i++) {
            saida.append(" " + ctx.OP_ARIT2(i).getText() + " ");
            visitFatorAritmetico(ctx.fatorAritmetico(i + 1));
        }
        return null;
    }

    @Override
    // REPRESENTA AS VARIAVEIS NO LOCAL ADEQUADO, REALIZANDO AS OPERAÇÕES COM
    // O TIPO DE VARIAVEL CERTO
    public Void visitFatorAritmetico(LangGrammarParser.FatorAritmeticoContext ctx) {
        if (ctx.NUMINT() != null) {
            saida.append(ctx.NUMINT().getText());
        } else if (ctx.NUMREAL() != null) {
            saida.append(ctx.NUMREAL().getText());
        } else if (ctx.VARIAVEL() != null) {
            saida.append(ctx.VARIAVEL().getText());
        } else {
            saida.append("(");
            visitExpressaoAritmetica(ctx.expressaoAritmetica());
            saida.append(")");
        }
        return null;
    }

    @Override
    // CONVERTE OS OPERADORES RELACIONAIS DA LINGUAGEM DESENVOLVIDA NO EQUIVALENTE
    // EM LINGUAGEM C
    public Void visitExpressaoRelacional(LangGrammarParser.ExpressaoRelacionalContext ctx) {
        visitTermoRelacional(ctx.termoRelacional(0));
        for (int i = 0; i < ctx.OP_BOOL().size(); i++) {
            String aux = null;
            if (ctx.OP_BOOL(i).getText().equals("E")) {
                aux = "&&";
            } else {
                aux = "||";
            }
            saida.append(" " + aux + " ");
            visitTermoRelacional(ctx.termoRelacional(i + 1));
        }
        return null;
    }

    @Override
    // CONVERTE TERMOS RELACIONAIS DA LINGUAGEM DESENVOLVIDA NO EQUIVALENTE
    // DA LINGUAGEM C
    public Void visitTermoRelacional(LangGrammarParser.TermoRelacionalContext ctx) {
        if (ctx.expressaoRelacional() != null) {
            saida.append("(");
            visitExpressaoRelacional(ctx.expressaoRelacional());
            saida.append(")");
        } else {
            visitExpressaoAritmetica(ctx.expressaoAritmetica(0));
            String aux = ctx.OP_REL().getText();
            if (aux.equals("<>")) {
                aux = "!=";
            } else if (aux.equals("=")) {
                aux = "==";
            }
            saida.append(" " + aux + " ");
            visitExpressaoAritmetica(ctx.expressaoAritmetica(1));
        }
        return null;
    }
}
