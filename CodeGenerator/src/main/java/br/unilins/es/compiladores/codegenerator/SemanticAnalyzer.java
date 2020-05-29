package br.unilins.es.compiladores.codegenerator;

import br.unilins.es.compiladores.codegenerator.TabelaDeSimbolos.TipoLang;

public class SemanticAnalyzer extends LangGrammarBaseVisitor<Void> {
    TabelaDeSimbolos tabela;

    @Override
    public Void visitPrograma(LangGrammarParser.ProgramaContext ctx) {
        tabela = new TabelaDeSimbolos();
        return super.visitPrograma(ctx);
    }

    @Override
    public Void visitDeclaracao(LangGrammarParser.DeclaracaoContext ctx) {
        String nomeVar = ctx.VARIAVEL().getText();
        String strTipoVar = ctx.TIPO_VAR().getText();
        TipoLang tipoVar = TipoLang.INVALIDO;
        switch (strTipoVar) {
            case "INTEIRO":
                tipoVar = TipoLang.INTEIRO;
                break;
            case "REAL":
                tipoVar = TipoLang.REAL;
                break;
            default:
                break;
        }

        if (tabela.existe(nomeVar)) {
            LangSemanticUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " já existe");
        } else {
            tabela.adicionar(nomeVar, tipoVar);
        }

        return super.visitDeclaracao(ctx);
    }

    @Override
    public Void visitComandoAtribuicao(LangGrammarParser.ComandoAtribuicaoContext ctx) {
        TipoLang tipoExpressao = LangSemanticUtils.verificarTipo(tabela, ctx.expressaoAritmetica());
        if (tipoExpressao != TipoLang.INVALIDO) {
            String nomeVar = ctx.VARIAVEL().getText();
            if (!tabela.existe(nomeVar)) {
                LangSemanticUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " não foi declarada antes do uso");
            } else {
                TipoLang tipoVariavel = LangSemanticUtils.verificarTipo(tabela, nomeVar);
                if (tipoVariavel != tipoExpressao) {
                    LangSemanticUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Tipo da variável " + nomeVar + " não é compatível com o tipo da expressão");
                }
            }
        }
        return super.visitComandoAtribuicao(ctx);
    }

    @Override
    public Void visitComandoEntrada(LangGrammarParser.ComandoEntradaContext ctx) {
        String nomeVar = ctx.VARIAVEL().getText();
        if (!tabela.existe(nomeVar)) {
            LangSemanticUtils.adicionarErroSemantico(ctx.VARIAVEL().getSymbol(), "Variável " + nomeVar + " não foi declarada antes do uso");
        }
        return super.visitComandoEntrada(ctx);
    }
    @Override
    public Void visitExpressaoAritmetica(LangGrammarParser.ExpressaoAritmeticaContext ctx) {
        LangSemanticUtils.verificarTipo(tabela, ctx);
        return super.visitExpressaoAritmetica(ctx);
    }
}