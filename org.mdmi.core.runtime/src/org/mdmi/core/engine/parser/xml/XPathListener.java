/*
 * MDIX - Model Driven Message Interoperability Runtime.
 * ...
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

// Generated from XPath.g4 by ANTLR 4.2
package org.mdmi.core.engine.parser.xml;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XPathParser}.
 */
@SuppressWarnings("deprecation")
public interface XPathListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XPathParser#andExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterAndExpr(@NotNull XPathParser.AndExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#andExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitAndExpr(@NotNull XPathParser.AndExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#nCName}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterNCName(@NotNull XPathParser.NCNameContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#nCName}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitNCName(@NotNull XPathParser.NCNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#nodeTest}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterNodeTest(@NotNull XPathParser.NodeTestContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#nodeTest}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitNodeTest(@NotNull XPathParser.NodeTestContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#predicate}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterPredicate(@NotNull XPathParser.PredicateContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#predicate}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitPredicate(@NotNull XPathParser.PredicateContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#qName}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterQName(@NotNull XPathParser.QNameContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#qName}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitQName(@NotNull XPathParser.QNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#expr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterExpr(@NotNull XPathParser.ExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#expr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitExpr(@NotNull XPathParser.ExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#functionCall}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterFunctionCall(@NotNull XPathParser.FunctionCallContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#functionCall}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitFunctionCall(@NotNull XPathParser.FunctionCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#filterExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterFilterExpr(@NotNull XPathParser.FilterExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#filterExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitFilterExpr(@NotNull XPathParser.FilterExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#absoluteLocationPathNoroot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterAbsoluteLocationPathNoroot(@NotNull XPathParser.AbsoluteLocationPathNorootContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#absoluteLocationPathNoroot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitAbsoluteLocationPathNoroot(@NotNull XPathParser.AbsoluteLocationPathNorootContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#axisSpecifier}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterAxisSpecifier(@NotNull XPathParser.AxisSpecifierContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#axisSpecifier}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitAxisSpecifier(@NotNull XPathParser.AxisSpecifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#primaryExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterPrimaryExpr(@NotNull XPathParser.PrimaryExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#primaryExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitPrimaryExpr(@NotNull XPathParser.PrimaryExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#equalityExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterEqualityExpr(@NotNull XPathParser.EqualityExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#equalityExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitEqualityExpr(@NotNull XPathParser.EqualityExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#unionExprNoRoot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterUnionExprNoRoot(@NotNull XPathParser.UnionExprNoRootContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#unionExprNoRoot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitUnionExprNoRoot(@NotNull XPathParser.UnionExprNoRootContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#pathExprNoRoot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterPathExprNoRoot(@NotNull XPathParser.PathExprNoRootContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#pathExprNoRoot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitPathExprNoRoot(@NotNull XPathParser.PathExprNoRootContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#additiveExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterAdditiveExpr(@NotNull XPathParser.AdditiveExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#additiveExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitAdditiveExpr(@NotNull XPathParser.AdditiveExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#multiplicativeExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterMultiplicativeExpr(@NotNull XPathParser.MultiplicativeExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#multiplicativeExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitMultiplicativeExpr(@NotNull XPathParser.MultiplicativeExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#main}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterMain(@NotNull XPathParser.MainContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#main}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitMain(@NotNull XPathParser.MainContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#orExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterOrExpr(@NotNull XPathParser.OrExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#orExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitOrExpr(@NotNull XPathParser.OrExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#locationPath}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterLocationPath(@NotNull XPathParser.LocationPathContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#locationPath}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitLocationPath(@NotNull XPathParser.LocationPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#relationalExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterRelationalExpr(@NotNull XPathParser.RelationalExprContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#relationalExpr}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitRelationalExpr(@NotNull XPathParser.RelationalExprContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#unaryExprNoRoot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterUnaryExprNoRoot(@NotNull XPathParser.UnaryExprNoRootContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#unaryExprNoRoot}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitUnaryExprNoRoot(@NotNull XPathParser.UnaryExprNoRootContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#abbreviatedStep}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterAbbreviatedStep(@NotNull XPathParser.AbbreviatedStepContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#abbreviatedStep}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitAbbreviatedStep(@NotNull XPathParser.AbbreviatedStepContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#nameTest}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterNameTest(@NotNull XPathParser.NameTestContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#nameTest}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitNameTest(@NotNull XPathParser.NameTestContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#relativeLocationPath}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterRelativeLocationPath(@NotNull XPathParser.RelativeLocationPathContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#relativeLocationPath}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitRelativeLocationPath(@NotNull XPathParser.RelativeLocationPathContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#functionName}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterFunctionName(@NotNull XPathParser.FunctionNameContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#functionName}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitFunctionName(@NotNull XPathParser.FunctionNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#variableReference}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterVariableReference(@NotNull XPathParser.VariableReferenceContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#variableReference}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitVariableReference(@NotNull XPathParser.VariableReferenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link XPathParser#step}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void enterStep(@NotNull XPathParser.StepContext ctx);

	/**
	 * Exit a parse tree produced by {@link XPathParser#step}.
	 *
	 * @param ctx
	 *            the parse tree
	 */
	void exitStep(@NotNull XPathParser.StepContext ctx);
}
