// Generated from br\u005Cunilins\es\compiladores\codegenerator\LangGrammar.g4 by ANTLR 4.8
package br.unilins.es.compiladores.codegenerator;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LangGrammarParser}.
 */
public interface LangGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LangGrammarParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LangGrammarParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(LangGrammarParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(LangGrammarParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoAritmetica(LangGrammarParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#expressaoAritmetica}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoAritmetica(LangGrammarParser.ExpressaoAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#termoAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterTermoAritmetico(LangGrammarParser.TermoAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#termoAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitTermoAritmetico(LangGrammarParser.TermoAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 */
	void enterFatorAritmetico(LangGrammarParser.FatorAritmeticoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#fatorAritmetico}.
	 * @param ctx the parse tree
	 */
	void exitFatorAritmetico(LangGrammarParser.FatorAritmeticoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterExpressaoRelacional(LangGrammarParser.ExpressaoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#expressaoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitExpressaoRelacional(LangGrammarParser.ExpressaoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#termoRelacional}.
	 * @param ctx the parse tree
	 */
	void enterTermoRelacional(LangGrammarParser.TermoRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#termoRelacional}.
	 * @param ctx the parse tree
	 */
	void exitTermoRelacional(LangGrammarParser.TermoRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void enterComando(LangGrammarParser.ComandoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#comando}.
	 * @param ctx the parse tree
	 */
	void exitComando(LangGrammarParser.ComandoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterComandoAtribuicao(LangGrammarParser.ComandoAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#comandoAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitComandoAtribuicao(LangGrammarParser.ComandoAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void enterComandoEntrada(LangGrammarParser.ComandoEntradaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#comandoEntrada}.
	 * @param ctx the parse tree
	 */
	void exitComandoEntrada(LangGrammarParser.ComandoEntradaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void enterComandoSaida(LangGrammarParser.ComandoSaidaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#comandoSaida}.
	 * @param ctx the parse tree
	 */
	void exitComandoSaida(LangGrammarParser.ComandoSaidaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#comandoCondicao}.
	 * @param ctx the parse tree
	 */
	void enterComandoCondicao(LangGrammarParser.ComandoCondicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#comandoCondicao}.
	 * @param ctx the parse tree
	 */
	void exitComandoCondicao(LangGrammarParser.ComandoCondicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 */
	void enterComandoRepeticao(LangGrammarParser.ComandoRepeticaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#comandoRepeticao}.
	 * @param ctx the parse tree
	 */
	void exitComandoRepeticao(LangGrammarParser.ComandoRepeticaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LangGrammarParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 */
	void enterSubAlgoritmo(LangGrammarParser.SubAlgoritmoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LangGrammarParser#subAlgoritmo}.
	 * @param ctx the parse tree
	 */
	void exitSubAlgoritmo(LangGrammarParser.SubAlgoritmoContext ctx);
}