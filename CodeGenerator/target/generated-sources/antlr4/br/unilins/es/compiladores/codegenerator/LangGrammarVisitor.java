// Generated from br\u005Cunilins\es\compiladores\codegenerator\LangGrammar.g4 by ANTLR 4.8
package br.unilins.es.compiladores.codegenerator;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LangGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LangGrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LangGrammarParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(LangGrammarParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoAritmetica(LangGrammarParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#termoAritmetico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermoAritmetico(LangGrammarParser.TermoAritmeticoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFatorAritmetico(LangGrammarParser.FatorAritmeticoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressaoRelacional(LangGrammarParser.ExpressaoRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#termoRelacional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermoRelacional(LangGrammarParser.TermoRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#comando}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComando(LangGrammarParser.ComandoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoAtribuicao(LangGrammarParser.ComandoAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#comandoEntrada}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoEntrada(LangGrammarParser.ComandoEntradaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#comandoSaida}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoSaida(LangGrammarParser.ComandoSaidaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#comandoCondicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoCondicao(LangGrammarParser.ComandoCondicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandoRepeticao(LangGrammarParser.ComandoRepeticaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LangGrammarParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubAlgoritmo(LangGrammarParser.SubAlgoritmoContext ctx);
}