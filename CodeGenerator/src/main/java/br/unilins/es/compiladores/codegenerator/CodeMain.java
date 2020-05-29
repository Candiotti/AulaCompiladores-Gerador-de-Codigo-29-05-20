package br.unilins.es.compiladores.codegenerator;

import br.unilins.es.compiladores.codegenerator.LangGrammarParser.ProgramaContext;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class CodeMain {
     public static void main(String args[]) throws IOException {
        CharStream cs = CharStreams.fromFileName(args[0]);
        LangGrammarLexer lexer = new LangGrammarLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        LangGrammarParser parser = new LangGrammarParser(tokens);
        ProgramaContext arvore = parser.programa();
        SemanticAnalyzer sa = new SemanticAnalyzer();
        sa.visitPrograma(arvore);
        LangSemanticUtils.errosSemanticos.forEach((s) -> System.out.println(s));
        
        if(LangSemanticUtils.errosSemanticos.isEmpty()) {
            LangGeradorC lgc = new LangGeradorC();
            lgc.visitPrograma(arvore);
            try(PrintWriter pw = new PrintWriter(args[1])) {
                pw.print(lgc.saida.toString());
            }
            
            LangGeradorPcodigo lgp = new LangGeradorPcodigo();
            String pcod = lgp.visitPrograma(arvore);
            try(PrintWriter pw = new PrintWriter(args[2])) {
                pw.print(pcod);
            }
        }
    }
}
