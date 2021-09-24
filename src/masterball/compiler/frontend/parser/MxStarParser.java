// Generated from src/masterball/compiler/frontend/parser/MxStar.g4 by ANTLR 4.7.2

    package masterball.compiler.frontend.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AddOp=1, SubOp=2, MulOp=3, DivOp=4, ModOp=5, GreaterOp=6, LessOp=7, GreaterEqualOp=8, 
		LessEqualOp=9, NotEqualOp=10, EqualOp=11, LogicAndOp=12, LogicOrOp=13, 
		LogicNotOp=14, ArithShiftLeftOp=15, ArithShiftRightOp=16, BitAndOp=17, 
		BitOrOp=18, BitXorOp=19, BitNotOp=20, AssignOp=21, IncrementOp=22, DecrementOp=23, 
		MemberOp=24, LeftBracket=25, RightBracket=26, LeftParen=27, RightParen=28, 
		SemiColon=29, Comma=30, LeftBrace=31, RightBrace=32, QuoteOp=33, LambdaStartSymbol=34, 
		LambdaArrowSymbol=35, IntType=36, BoolType=37, StringType=38, VoidType=39, 
		NullConstant=40, TrueConstant=41, FalseConstant=42, IfKw=43, ElseKw=44, 
		ForKw=45, WhileKw=46, BreakKw=47, ContinueKw=48, ReturnKw=49, NewKw=50, 
		ClassKw=51, ThisPointer=52, WhitespaceEater=53, NewlineEater=54, LineCommentEater=55, 
		BlockCommentEater=56, Identifier=57, IntegerConstant=58, EscapeEnter=59, 
		EscapeBackslash=60, EscapeQuote=61, StringContent=62, StringConstant=63;
	public static final int
		RULE_mxStarCode = 0, RULE_classDef = 1, RULE_classConstructorDef = 2, 
		RULE_funcDef = 3, RULE_funcDefArgs = 4, RULE_funcRetType = 5, RULE_funcCallExp = 6, 
		RULE_funcCallArgs = 7, RULE_lambdaExp = 8, RULE_builtinType = 9, RULE_arrayType = 10, 
		RULE_varDefType = 11, RULE_varDefBody = 12, RULE_suite = 13, RULE_varDefStmt = 14, 
		RULE_ifStmt = 15, RULE_whileStmt = 16, RULE_forInit = 17, RULE_forStmt = 18, 
		RULE_returnStmt = 19, RULE_controlStmt = 20, RULE_statement = 21, RULE_newExp = 22, 
		RULE_prefixExp = 23, RULE_postfixOps = 24, RULE_unaryOps = 25, RULE_shiftOps = 26, 
		RULE_mulLevelOps = 27, RULE_addLevelOps = 28, RULE_compareOps = 29, RULE_equalOps = 30, 
		RULE_expression = 31, RULE_atom = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"mxStarCode", "classDef", "classConstructorDef", "funcDef", "funcDefArgs", 
			"funcRetType", "funcCallExp", "funcCallArgs", "lambdaExp", "builtinType", 
			"arrayType", "varDefType", "varDefBody", "suite", "varDefStmt", "ifStmt", 
			"whileStmt", "forInit", "forStmt", "returnStmt", "controlStmt", "statement", 
			"newExp", "prefixExp", "postfixOps", "unaryOps", "shiftOps", "mulLevelOps", 
			"addLevelOps", "compareOps", "equalOps", "expression", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'>'", "'<'", "'>='", "'<='", 
			"'!='", "'=='", "'&&'", "'||'", "'!'", "'<<'", "'>>'", "'&'", "'|'", 
			"'^'", "'~'", "'='", "'++'", "'--'", "'.'", "'['", "']'", "'('", "')'", 
			"';'", "','", "'{'", "'}'", "'\"'", "'[&]'", "'->'", "'int'", "'bool'", 
			"'string'", "'void'", "'null'", "'true'", "'false'", "'if'", "'else'", 
			"'for'", "'while'", "'break'", "'continue'", "'return'", "'new'", "'class'", 
			"'this'", null, null, null, null, null, null, "'\\n'", "'\\\\'", "'\\\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AddOp", "SubOp", "MulOp", "DivOp", "ModOp", "GreaterOp", "LessOp", 
			"GreaterEqualOp", "LessEqualOp", "NotEqualOp", "EqualOp", "LogicAndOp", 
			"LogicOrOp", "LogicNotOp", "ArithShiftLeftOp", "ArithShiftRightOp", "BitAndOp", 
			"BitOrOp", "BitXorOp", "BitNotOp", "AssignOp", "IncrementOp", "DecrementOp", 
			"MemberOp", "LeftBracket", "RightBracket", "LeftParen", "RightParen", 
			"SemiColon", "Comma", "LeftBrace", "RightBrace", "QuoteOp", "LambdaStartSymbol", 
			"LambdaArrowSymbol", "IntType", "BoolType", "StringType", "VoidType", 
			"NullConstant", "TrueConstant", "FalseConstant", "IfKw", "ElseKw", "ForKw", 
			"WhileKw", "BreakKw", "ContinueKw", "ReturnKw", "NewKw", "ClassKw", "ThisPointer", 
			"WhitespaceEater", "NewlineEater", "LineCommentEater", "BlockCommentEater", 
			"Identifier", "IntegerConstant", "EscapeEnter", "EscapeBackslash", "EscapeQuote", 
			"StringContent", "StringConstant"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MxStarCodeContext extends ParserRuleContext {
		public List<ClassDefContext> classDef() {
			return getRuleContexts(ClassDefContext.class);
		}
		public ClassDefContext classDef(int i) {
			return getRuleContext(ClassDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public List<VarDefStmtContext> varDefStmt() {
			return getRuleContexts(VarDefStmtContext.class);
		}
		public VarDefStmtContext varDefStmt(int i) {
			return getRuleContext(VarDefStmtContext.class,i);
		}
		public MxStarCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mxStarCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMxStarCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMxStarCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMxStarCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MxStarCodeContext mxStarCode() throws RecognitionException {
		MxStarCodeContext _localctx = new MxStarCodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mxStarCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << ClassKw) | (1L << Identifier))) != 0)) {
				{
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(66);
					classDef();
					}
					break;
				case 2:
					{
					setState(67);
					funcDef();
					}
					break;
				case 3:
					{
					setState(68);
					varDefStmt();
					}
					break;
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode ClassKw() { return getToken(MxStarParser.ClassKw, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode LeftBrace() { return getToken(MxStarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxStarParser.RightBrace, 0); }
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public List<ClassConstructorDefContext> classConstructorDef() {
			return getRuleContexts(ClassConstructorDefContext.class);
		}
		public ClassConstructorDefContext classConstructorDef(int i) {
			return getRuleContext(ClassConstructorDefContext.class,i);
		}
		public List<VarDefStmtContext> varDefStmt() {
			return getRuleContexts(VarDefStmtContext.class);
		}
		public VarDefStmtContext varDefStmt(int i) {
			return getRuleContext(VarDefStmtContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(ClassKw);
			setState(75);
			match(Identifier);
			setState(76);
			match(LeftBrace);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << Identifier))) != 0)) {
				{
				setState(80);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(77);
					classConstructorDef();
					}
					break;
				case 2:
					{
					setState(78);
					varDefStmt();
					}
					break;
				case 3:
					{
					setState(79);
					funcDef();
					}
					break;
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(RightBrace);
			setState(86);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassConstructorDefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public ClassConstructorDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstructorDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassConstructorDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassConstructorDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassConstructorDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassConstructorDefContext classConstructorDef() throws RecognitionException {
		ClassConstructorDefContext _localctx = new ClassConstructorDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classConstructorDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(Identifier);
			setState(89);
			match(LeftParen);
			setState(90);
			match(RightParen);
			setState(91);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefContext extends ParserRuleContext {
		public FuncRetTypeContext funcRetType() {
			return getRuleContext(FuncRetTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public FuncDefArgsContext funcDefArgs() {
			return getRuleContext(FuncDefArgsContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			funcRetType();
			setState(94);
			match(Identifier);
			setState(95);
			match(LeftParen);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << Identifier))) != 0)) {
				{
				setState(96);
				funcDefArgs();
				}
			}

			setState(99);
			match(RightParen);
			setState(100);
			suite();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDefArgsContext extends ParserRuleContext {
		public List<VarDefTypeContext> varDefType() {
			return getRuleContexts(VarDefTypeContext.class);
		}
		public VarDefTypeContext varDefType(int i) {
			return getRuleContext(VarDefTypeContext.class,i);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxStarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxStarParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxStarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxStarParser.Comma, i);
		}
		public FuncDefArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDefArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncDefArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncDefArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncDefArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefArgsContext funcDefArgs() throws RecognitionException {
		FuncDefArgsContext _localctx = new FuncDefArgsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcDefArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			varDefType(0);
			setState(103);
			match(Identifier);
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(104);
				match(Comma);
				setState(105);
				varDefType(0);
				setState(106);
				match(Identifier);
				}
				}
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncRetTypeContext extends ParserRuleContext {
		public TerminalNode VoidType() { return getToken(MxStarParser.VoidType, 0); }
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public FuncRetTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcRetType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncRetType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncRetType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncRetType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncRetTypeContext funcRetType() throws RecognitionException {
		FuncRetTypeContext _localctx = new FuncRetTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcRetType);
		try {
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VoidType:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(VoidType);
				}
				break;
			case IntType:
			case BoolType:
			case StringType:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				varDefType(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallExpContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public FuncCallArgsContext funcCallArgs() {
			return getRuleContext(FuncCallArgsContext.class,0);
		}
		public FuncCallExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncCallExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncCallExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncCallExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallExpContext funcCallExp() throws RecognitionException {
		FuncCallExpContext _localctx = new FuncCallExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcCallExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(Identifier);
			setState(118);
			funcCallArgs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallArgsContext extends ParserRuleContext {
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxStarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxStarParser.Comma, i);
		}
		public FuncCallArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCallArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncCallArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncCallArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncCallArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallArgsContext funcCallArgs() throws RecognitionException {
		FuncCallArgsContext _localctx = new FuncCallArgsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_funcCallArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(LeftParen);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(121);
				expression(0);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(122);
					match(Comma);
					setState(123);
					expression(0);
					}
					}
					setState(128);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(131);
			match(RightParen);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaExpContext extends ParserRuleContext {
		public TerminalNode LambdaStartSymbol() { return getToken(MxStarParser.LambdaStartSymbol, 0); }
		public TerminalNode LambdaArrowSymbol() { return getToken(MxStarParser.LambdaArrowSymbol, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public FuncCallArgsContext funcCallArgs() {
			return getRuleContext(FuncCallArgsContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public FuncDefArgsContext funcDefArgs() {
			return getRuleContext(FuncDefArgsContext.class,0);
		}
		public LambdaExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLambdaExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLambdaExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLambdaExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaExpContext lambdaExp() throws RecognitionException {
		LambdaExpContext _localctx = new LambdaExpContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lambdaExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LambdaStartSymbol);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LeftParen) {
				{
				setState(134);
				match(LeftParen);
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << Identifier))) != 0)) {
					{
					setState(135);
					funcDefArgs();
					}
				}

				setState(138);
				match(RightParen);
				}
			}

			setState(141);
			match(LambdaArrowSymbol);
			setState(142);
			suite();
			setState(143);
			funcCallArgs();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltinTypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(MxStarParser.IntType, 0); }
		public TerminalNode StringType() { return getToken(MxStarParser.StringType, 0); }
		public TerminalNode BoolType() { return getToken(MxStarParser.BoolType, 0); }
		public BuiltinTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtinType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBuiltinType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBuiltinType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBuiltinType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(MxStarParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxStarParser.RightBracket, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(LeftBracket);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(148);
				expression(0);
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
			match(RightBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefTypeContext extends ParserRuleContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public List<ArrayTypeContext> arrayType() {
			return getRuleContexts(ArrayTypeContext.class);
		}
		public ArrayTypeContext arrayType(int i) {
			return getRuleContext(ArrayTypeContext.class,i);
		}
		public VarDefTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefTypeContext varDefType() throws RecognitionException {
		return varDefType(0);
	}

	private VarDefTypeContext varDefType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarDefTypeContext _localctx = new VarDefTypeContext(_ctx, _parentState);
		VarDefTypeContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_varDefType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case BoolType:
			case StringType:
				{
				setState(157);
				builtinType();
				}
				break;
			case Identifier:
				{
				setState(158);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarDefTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varDefType);
					setState(161);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(163); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(162);
							arrayType();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(165); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class VarDefBodyContext extends ParserRuleContext {
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxStarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxStarParser.Identifier, i);
		}
		public List<TerminalNode> AssignOp() { return getTokens(MxStarParser.AssignOp); }
		public TerminalNode AssignOp(int i) {
			return getToken(MxStarParser.AssignOp, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MxStarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxStarParser.Comma, i);
		}
		public VarDefBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefBodyContext varDefBody() throws RecognitionException {
		VarDefBodyContext _localctx = new VarDefBodyContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varDefBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			varDefType(0);
			setState(173);
			match(Identifier);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssignOp) {
				{
				setState(174);
				match(AssignOp);
				setState(175);
				expression(0);
				}
			}

			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(178);
				match(Comma);
				setState(179);
				match(Identifier);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AssignOp) {
					{
					setState(180);
					match(AssignOp);
					setState(181);
					expression(0);
					}
				}

				}
				}
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxStarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxStarParser.RightBrace, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public SuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSuite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(LeftBrace);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << SemiColon) | (1L << LeftBrace) | (1L << LambdaStartSymbol) | (1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << IfKw) | (1L << ForKw) | (1L << WhileKw) | (1L << BreakKw) | (1L << ContinueKw) | (1L << ReturnKw) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(190);
				statement();
				}
				}
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(196);
			match(RightBrace);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDefStmtContext extends ParserRuleContext {
		public VarDefBodyContext varDefBody() {
			return getRuleContext(VarDefBodyContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public VarDefStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefStmtContext varDefStmt() throws RecognitionException {
		VarDefStmtContext _localctx = new VarDefStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_varDefStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			varDefBody();
			setState(199);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public TerminalNode IfKw() { return getToken(MxStarParser.IfKw, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(IfKw);
			setState(202);
			match(LeftParen);
			setState(203);
			expression(0);
			setState(204);
			match(RightParen);
			setState(205);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WhileKw() { return getToken(MxStarParser.WhileKw, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(WhileKw);
			setState(208);
			match(LeftParen);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(209);
				expression(0);
				}
			}

			setState(212);
			match(RightParen);
			setState(213);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForInitContext extends ParserRuleContext {
		public VarDefBodyContext varDefBody() {
			return getRuleContext(VarDefBodyContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForInit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(215);
				varDefBody();
				}
				break;
			case 2:
				{
				setState(216);
				expression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForStmtContext extends ParserRuleContext {
		public ExpressionContext forCondition;
		public ExpressionContext forIncr;
		public TerminalNode ForKw() { return getToken(MxStarParser.ForKw, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(MxStarParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(MxStarParser.SemiColon, i);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(ForKw);
			setState(220);
			match(LeftParen);
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(221);
				forInit();
				}
			}

			setState(224);
			match(SemiColon);
			setState(226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(225);
				((ForStmtContext)_localctx).forCondition = expression(0);
				}
			}

			setState(228);
			match(SemiColon);
			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(229);
				((ForStmtContext)_localctx).forIncr = expression(0);
				}
			}

			setState(232);
			match(RightParen);
			setState(233);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStmtContext extends ParserRuleContext {
		public TerminalNode ReturnKw() { return getToken(MxStarParser.ReturnKw, 0); }
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterReturnStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitReturnStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitReturnStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(ReturnKw);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(236);
				expression(0);
				}
			}

			setState(239);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ControlStmtContext extends ParserRuleContext {
		public TerminalNode BreakKw() { return getToken(MxStarParser.BreakKw, 0); }
		public TerminalNode ContinueKw() { return getToken(MxStarParser.ContinueKw, 0); }
		public ControlStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterControlStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitControlStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitControlStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStmtContext controlStmt() throws RecognitionException {
		ControlStmtContext _localctx = new ControlStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_controlStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==BreakKw || _la==ContinueKw) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BlockStmtLContext extends StatementContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public BlockStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBlockStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBlockStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBlockStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStmtLContext extends StatementContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIfStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIfStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIfStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStmtLContext extends StatementContext {
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ReturnStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterReturnStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitReturnStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitReturnStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDefStmtLContext extends StatementContext {
		public VarDefStmtContext varDefStmt() {
			return getRuleContext(VarDefStmtContext.class,0);
		}
		public VarDefStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStmtLContext extends StatementContext {
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ForStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStmtLContext extends StatementContext {
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public WhileStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhileStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhileStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhileStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ControlStmtLContext extends StatementContext {
		public ControlStmtContext controlStmt() {
			return getRuleContext(ControlStmtContext.class,0);
		}
		public ControlStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterControlStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitControlStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitControlStmtL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PureStmtLContext extends StatementContext {
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PureStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPureStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPureStmtL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPureStmtL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		int _la;
		try {
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new BlockStmtLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				suite();
				}
				break;
			case 2:
				_localctx = new IfStmtLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(244);
				ifStmt();
				}
				break;
			case 3:
				_localctx = new WhileStmtLContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(245);
				whileStmt();
				}
				break;
			case 4:
				_localctx = new ForStmtLContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(246);
				forStmt();
				}
				break;
			case 5:
				_localctx = new ReturnStmtLContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(247);
				returnStmt();
				}
				break;
			case 6:
				_localctx = new ControlStmtLContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(248);
				controlStmt();
				}
				break;
			case 7:
				_localctx = new VarDefStmtLContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(249);
				varDefStmt();
				}
				break;
			case 8:
				_localctx = new PureStmtLContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
					{
					setState(250);
					expression(0);
					}
				}

				setState(253);
				match(SemiColon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpContext extends ParserRuleContext {
		public TerminalNode NewKw() { return getToken(MxStarParser.NewKw, 0); }
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public NewExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpContext newExp() throws RecognitionException {
		NewExpContext _localctx = new NewExpContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_newExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(NewKw);
			setState(257);
			varDefType(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrefixExpContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IncrementOp() { return getToken(MxStarParser.IncrementOp, 0); }
		public TerminalNode DecrementOp() { return getToken(MxStarParser.DecrementOp, 0); }
		public PrefixExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrefixExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrefixExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrefixExp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixExpContext prefixExp() throws RecognitionException {
		PrefixExpContext _localctx = new PrefixExpContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_prefixExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_la = _input.LA(1);
			if ( !(_la==IncrementOp || _la==DecrementOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(260);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixOpsContext extends ParserRuleContext {
		public TerminalNode IncrementOp() { return getToken(MxStarParser.IncrementOp, 0); }
		public TerminalNode DecrementOp() { return getToken(MxStarParser.DecrementOp, 0); }
		public PostfixOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPostfixOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPostfixOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPostfixOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixOpsContext postfixOps() throws RecognitionException {
		PostfixOpsContext _localctx = new PostfixOpsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_postfixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_la = _input.LA(1);
			if ( !(_la==IncrementOp || _la==DecrementOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryOpsContext extends ParserRuleContext {
		public TerminalNode BitNotOp() { return getToken(MxStarParser.BitNotOp, 0); }
		public TerminalNode LogicNotOp() { return getToken(MxStarParser.LogicNotOp, 0); }
		public TerminalNode AddOp() { return getToken(MxStarParser.AddOp, 0); }
		public TerminalNode SubOp() { return getToken(MxStarParser.SubOp, 0); }
		public UnaryOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterUnaryOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitUnaryOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitUnaryOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryOpsContext unaryOps() throws RecognitionException {
		UnaryOpsContext _localctx = new UnaryOpsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unaryOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShiftOpsContext extends ParserRuleContext {
		public TerminalNode ArithShiftLeftOp() { return getToken(MxStarParser.ArithShiftLeftOp, 0); }
		public TerminalNode ArithShiftRightOp() { return getToken(MxStarParser.ArithShiftRightOp, 0); }
		public ShiftOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterShiftOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitShiftOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitShiftOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftOpsContext shiftOps() throws RecognitionException {
		ShiftOpsContext _localctx = new ShiftOpsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_shiftOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			_la = _input.LA(1);
			if ( !(_la==ArithShiftLeftOp || _la==ArithShiftRightOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulLevelOpsContext extends ParserRuleContext {
		public TerminalNode MulOp() { return getToken(MxStarParser.MulOp, 0); }
		public TerminalNode DivOp() { return getToken(MxStarParser.DivOp, 0); }
		public TerminalNode ModOp() { return getToken(MxStarParser.ModOp, 0); }
		public MulLevelOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulLevelOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMulLevelOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMulLevelOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMulLevelOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulLevelOpsContext mulLevelOps() throws RecognitionException {
		MulLevelOpsContext _localctx = new MulLevelOpsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_mulLevelOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MulOp) | (1L << DivOp) | (1L << ModOp))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddLevelOpsContext extends ParserRuleContext {
		public TerminalNode AddOp() { return getToken(MxStarParser.AddOp, 0); }
		public TerminalNode SubOp() { return getToken(MxStarParser.SubOp, 0); }
		public AddLevelOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addLevelOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAddLevelOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAddLevelOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAddLevelOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddLevelOpsContext addLevelOps() throws RecognitionException {
		AddLevelOpsContext _localctx = new AddLevelOpsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_addLevelOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			_la = _input.LA(1);
			if ( !(_la==AddOp || _la==SubOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CompareOpsContext extends ParserRuleContext {
		public TerminalNode GreaterOp() { return getToken(MxStarParser.GreaterOp, 0); }
		public TerminalNode GreaterEqualOp() { return getToken(MxStarParser.GreaterEqualOp, 0); }
		public TerminalNode LessOp() { return getToken(MxStarParser.LessOp, 0); }
		public TerminalNode LessEqualOp() { return getToken(MxStarParser.LessEqualOp, 0); }
		public CompareOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compareOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCompareOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCompareOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCompareOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareOpsContext compareOps() throws RecognitionException {
		CompareOpsContext _localctx = new CompareOpsContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_compareOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GreaterOp) | (1L << LessOp) | (1L << GreaterEqualOp) | (1L << LessEqualOp))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualOpsContext extends ParserRuleContext {
		public TerminalNode EqualOp() { return getToken(MxStarParser.EqualOp, 0); }
		public TerminalNode NotEqualOp() { return getToken(MxStarParser.NotEqualOp, 0); }
		public EqualOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEqualOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEqualOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitEqualOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualOpsContext equalOps() throws RecognitionException {
		EqualOpsContext _localctx = new EqualOpsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_equalOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !(_la==NotEqualOp || _la==EqualOp) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MemberExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MemberOp() { return getToken(MxStarParser.MemberOp, 0); }
		public MemberExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMemberExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMemberExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMemberExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SingleAtomLContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public SingleAtomLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSingleAtomL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSingleAtomL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSingleAtomL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostfixExpLContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PostfixOpsContext postfixOps() {
			return getRuleContext(PostfixOpsContext.class,0);
		}
		public PostfixExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPostfixExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPostfixExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPostfixExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(MxStarParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxStarParser.RightBracket, 0); }
		public IndexExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIndexExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIndexExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIndexExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExpLContext extends ExpressionContext {
		public PrefixExpContext prefixExp() {
			return getRuleContext(PrefixExpContext.class,0);
		}
		public PrefixExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrefixExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrefixExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrefixExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AssignOp() { return getToken(MxStarParser.AssignOp, 0); }
		public AssignExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAssignExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAssignExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAssignExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExpLContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public ParenExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParenExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParenExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParenExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpLContext extends ExpressionContext {
		public UnaryOpsContext unaryOps() {
			return getRuleContext(UnaryOpsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterUnaryExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitUnaryExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitUnaryExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpLContext extends ExpressionContext {
		public NewExpContext newExp() {
			return getRuleContext(NewExpContext.class,0);
		}
		public NewExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallExpLContext extends ExpressionContext {
		public FuncCallExpContext funcCallExp() {
			return getRuleContext(FuncCallExpContext.class,0);
		}
		public FuncCallExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncCallExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncCallExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncCallExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LambdaExpLContext extends ExpressionContext {
		public LambdaExpContext lambdaExp() {
			return getRuleContext(LambdaExpContext.class,0);
		}
		public LambdaExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLambdaExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLambdaExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitLambdaExpL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ShiftOpsContext shiftOps() {
			return getRuleContext(ShiftOpsContext.class,0);
		}
		public MulLevelOpsContext mulLevelOps() {
			return getRuleContext(MulLevelOpsContext.class,0);
		}
		public AddLevelOpsContext addLevelOps() {
			return getRuleContext(AddLevelOpsContext.class,0);
		}
		public CompareOpsContext compareOps() {
			return getRuleContext(CompareOpsContext.class,0);
		}
		public EqualOpsContext equalOps() {
			return getRuleContext(EqualOpsContext.class,0);
		}
		public TerminalNode BitAndOp() { return getToken(MxStarParser.BitAndOp, 0); }
		public TerminalNode BitXorOp() { return getToken(MxStarParser.BitXorOp, 0); }
		public TerminalNode BitOrOp() { return getToken(MxStarParser.BitOrOp, 0); }
		public TerminalNode LogicAndOp() { return getToken(MxStarParser.LogicAndOp, 0); }
		public TerminalNode LogicOrOp() { return getToken(MxStarParser.LogicOrOp, 0); }
		public BinaryExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBinaryExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBinaryExpL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBinaryExpL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new SingleAtomLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(277);
				atom();
				}
				break;
			case 2:
				{
				_localctx = new ParenExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(278);
				match(LeftParen);
				setState(279);
				expression(0);
				setState(280);
				match(RightParen);
				}
				break;
			case 3:
				{
				_localctx = new FuncCallExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				funcCallExp();
				}
				break;
			case 4:
				{
				_localctx = new LambdaExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				lambdaExp();
				}
				break;
			case 5:
				{
				_localctx = new PrefixExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				prefixExp();
				}
				break;
			case 6:
				{
				_localctx = new UnaryExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				unaryOps();
				setState(286);
				expression(13);
				}
				break;
			case 7:
				{
				_localctx = new NewExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				newExp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new MemberExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(291);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(292);
						match(MemberOp);
						setState(293);
						expression(19);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(294);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(295);
						shiftOps();
						setState(296);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(298);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(299);
						mulLevelOps();
						setState(300);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(302);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(303);
						addLevelOps();
						setState(304);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(306);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(307);
						compareOps();
						setState(308);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(310);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(311);
						equalOps();
						setState(312);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(314);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(315);
						match(BitAndOp);
						setState(316);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(317);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(318);
						match(BitXorOp);
						setState(319);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(321);
						match(BitOrOp);
						setState(322);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(323);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(324);
						match(LogicAndOp);
						setState(325);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(326);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(327);
						match(LogicOrOp);
						setState(328);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new AssignExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(329);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(330);
						match(AssignOp);
						setState(331);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new IndexExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(332);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(333);
						match(LeftBracket);
						setState(334);
						expression(0);
						setState(335);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new PostfixExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(337);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(338);
						postfixOps();
						}
						break;
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FalseLContext extends AtomContext {
		public TerminalNode FalseConstant() { return getToken(MxStarParser.FalseConstant, 0); }
		public FalseLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFalseL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFalseL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFalseL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullLContext extends AtomContext {
		public TerminalNode NullConstant() { return getToken(MxStarParser.NullConstant, 0); }
		public NullLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNullL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNullL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNullL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueLContext extends AtomContext {
		public TerminalNode TrueConstant() { return getToken(MxStarParser.TrueConstant, 0); }
		public TrueLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterTrueL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitTrueL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitTrueL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntLContext extends AtomContext {
		public TerminalNode IntegerConstant() { return getToken(MxStarParser.IntegerConstant, 0); }
		public IntLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIntL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIntL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIntL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLContext extends AtomContext {
		public TerminalNode StringConstant() { return getToken(MxStarParser.StringConstant, 0); }
		public StringLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterStringL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitStringL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitStringL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisLContext extends AtomContext {
		public TerminalNode ThisPointer() { return getToken(MxStarParser.ThisPointer, 0); }
		public ThisLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterThisL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitThisL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitThisL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierLContext extends AtomContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public IdentifierLContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIdentifierL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIdentifierL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIdentifierL(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_atom);
		try {
			setState(351);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new IdentifierLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(344);
				match(Identifier);
				}
				break;
			case IntegerConstant:
				_localctx = new IntLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(345);
				match(IntegerConstant);
				}
				break;
			case StringConstant:
				_localctx = new StringLContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(346);
				match(StringConstant);
				}
				break;
			case FalseConstant:
				_localctx = new FalseLContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(347);
				match(FalseConstant);
				}
				break;
			case TrueConstant:
				_localctx = new TrueLContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(348);
				match(TrueConstant);
				}
				break;
			case NullConstant:
				_localctx = new NullLContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(349);
				match(NullConstant);
				}
				break;
			case ThisPointer:
				_localctx = new ThisLContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(350);
				match(ThisPointer);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 11:
			return varDefType_sempred((VarDefTypeContext)_localctx, predIndex);
		case 31:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean varDefType_sempred(VarDefTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		case 13:
			return precpred(_ctx, 19);
		case 14:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u0164\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\7\3S\n\3\f\3\16\3V\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5"+
		"\3\5\5\5d\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6o\n\6\f\6\16\6r\13"+
		"\6\3\7\3\7\5\7v\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\7\t\177\n\t\f\t\16\t\u0082"+
		"\13\t\5\t\u0084\n\t\3\t\3\t\3\n\3\n\3\n\5\n\u008b\n\n\3\n\5\n\u008e\n"+
		"\n\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\7\f\u0098\n\f\f\f\16\f\u009b\13\f"+
		"\3\f\3\f\3\r\3\r\3\r\5\r\u00a2\n\r\3\r\3\r\6\r\u00a6\n\r\r\r\16\r\u00a7"+
		"\7\r\u00aa\n\r\f\r\16\r\u00ad\13\r\3\16\3\16\3\16\3\16\5\16\u00b3\n\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00b9\n\16\7\16\u00bb\n\16\f\16\16\16\u00be"+
		"\13\16\3\17\3\17\7\17\u00c2\n\17\f\17\16\17\u00c5\13\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\5\22\u00d5\n\22"+
		"\3\22\3\22\3\22\3\23\3\23\5\23\u00dc\n\23\3\24\3\24\3\24\5\24\u00e1\n"+
		"\24\3\24\3\24\5\24\u00e5\n\24\3\24\3\24\5\24\u00e9\n\24\3\24\3\24\3\24"+
		"\3\25\3\25\5\25\u00f0\n\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\5\27\u00fe\n\27\3\27\5\27\u0101\n\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u0124\n!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!"+
		"\u0156\n!\f!\16!\u0159\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u0162\n\"\3"+
		"\"\2\4\30@#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@B\2\13\3\2&(\3\2\61\62\3\2\30\31\5\2\3\4\20\20\26\26\3\2\21\22\3"+
		"\2\5\7\3\2\3\4\3\2\b\13\3\2\f\r\2\u017f\2I\3\2\2\2\4L\3\2\2\2\6Z\3\2\2"+
		"\2\b_\3\2\2\2\nh\3\2\2\2\fu\3\2\2\2\16w\3\2\2\2\20z\3\2\2\2\22\u0087\3"+
		"\2\2\2\24\u0093\3\2\2\2\26\u0095\3\2\2\2\30\u00a1\3\2\2\2\32\u00ae\3\2"+
		"\2\2\34\u00bf\3\2\2\2\36\u00c8\3\2\2\2 \u00cb\3\2\2\2\"\u00d1\3\2\2\2"+
		"$\u00db\3\2\2\2&\u00dd\3\2\2\2(\u00ed\3\2\2\2*\u00f3\3\2\2\2,\u0100\3"+
		"\2\2\2.\u0102\3\2\2\2\60\u0105\3\2\2\2\62\u0108\3\2\2\2\64\u010a\3\2\2"+
		"\2\66\u010c\3\2\2\28\u010e\3\2\2\2:\u0110\3\2\2\2<\u0112\3\2\2\2>\u0114"+
		"\3\2\2\2@\u0123\3\2\2\2B\u0161\3\2\2\2DH\5\4\3\2EH\5\b\5\2FH\5\36\20\2"+
		"GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\3\3\2\2"+
		"\2KI\3\2\2\2LM\7\65\2\2MN\7;\2\2NT\7!\2\2OS\5\6\4\2PS\5\36\20\2QS\5\b"+
		"\5\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2\2UW\3\2"+
		"\2\2VT\3\2\2\2WX\7\"\2\2XY\7\37\2\2Y\5\3\2\2\2Z[\7;\2\2[\\\7\35\2\2\\"+
		"]\7\36\2\2]^\5\34\17\2^\7\3\2\2\2_`\5\f\7\2`a\7;\2\2ac\7\35\2\2bd\5\n"+
		"\6\2cb\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\36\2\2fg\5\34\17\2g\t\3\2\2\2h"+
		"i\5\30\r\2ip\7;\2\2jk\7 \2\2kl\5\30\r\2lm\7;\2\2mo\3\2\2\2nj\3\2\2\2o"+
		"r\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\13\3\2\2\2rp\3\2\2\2sv\7)\2\2tv\5\30\r"+
		"\2us\3\2\2\2ut\3\2\2\2v\r\3\2\2\2wx\7;\2\2xy\5\20\t\2y\17\3\2\2\2z\u0083"+
		"\7\35\2\2{\u0080\5@!\2|}\7 \2\2}\177\5@!\2~|\3\2\2\2\177\u0082\3\2\2\2"+
		"\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3"+
		"\2\2\2\u0083{\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086"+
		"\7\36\2\2\u0086\21\3\2\2\2\u0087\u008d\7$\2\2\u0088\u008a\7\35\2\2\u0089"+
		"\u008b\5\n\6\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\u008e\7\36\2\2\u008d\u0088\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\u0090\7%\2\2\u0090\u0091\5\34\17\2\u0091\u0092\5"+
		"\20\t\2\u0092\23\3\2\2\2\u0093\u0094\t\2\2\2\u0094\25\3\2\2\2\u0095\u0099"+
		"\7\33\2\2\u0096\u0098\5@!\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009c\u009d\7\34\2\2\u009d\27\3\2\2\2\u009e\u009f\b\r\1\2\u009f\u00a2"+
		"\5\24\13\2\u00a0\u00a2\7;\2\2\u00a1\u009e\3\2\2\2\u00a1\u00a0\3\2\2\2"+
		"\u00a2\u00ab\3\2\2\2\u00a3\u00a5\f\3\2\2\u00a4\u00a6\5\26\f\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\u00aa\3\2\2\2\u00a9\u00a3\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2"+
		"\2\2\u00ab\u00ac\3\2\2\2\u00ac\31\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00af"+
		"\5\30\r\2\u00af\u00b2\7;\2\2\u00b0\u00b1\7\27\2\2\u00b1\u00b3\5@!\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00bc\3\2\2\2\u00b4\u00b5\7 "+
		"\2\2\u00b5\u00b8\7;\2\2\u00b6\u00b7\7\27\2\2\u00b7\u00b9\5@!\2\u00b8\u00b6"+
		"\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b4\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\33\3\2\2"+
		"\2\u00be\u00bc\3\2\2\2\u00bf\u00c3\7!\2\2\u00c0\u00c2\5,\27\2\u00c1\u00c0"+
		"\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c6\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\7\"\2\2\u00c7\35\3\2\2"+
		"\2\u00c8\u00c9\5\32\16\2\u00c9\u00ca\7\37\2\2\u00ca\37\3\2\2\2\u00cb\u00cc"+
		"\7-\2\2\u00cc\u00cd\7\35\2\2\u00cd\u00ce\5@!\2\u00ce\u00cf\7\36\2\2\u00cf"+
		"\u00d0\5,\27\2\u00d0!\3\2\2\2\u00d1\u00d2\7\60\2\2\u00d2\u00d4\7\35\2"+
		"\2\u00d3\u00d5\5@!\2\u00d4\u00d3\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6"+
		"\3\2\2\2\u00d6\u00d7\7\36\2\2\u00d7\u00d8\5,\27\2\u00d8#\3\2\2\2\u00d9"+
		"\u00dc\5\32\16\2\u00da\u00dc\5@!\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2"+
		"\2\2\u00dc%\3\2\2\2\u00dd\u00de\7/\2\2\u00de\u00e0\7\35\2\2\u00df\u00e1"+
		"\5$\23\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"\u00e4\7\37\2\2\u00e3\u00e5\5@!\2\u00e4\u00e3\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\7\37\2\2\u00e7\u00e9\5@!\2\u00e8"+
		"\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\7\36"+
		"\2\2\u00eb\u00ec\5,\27\2\u00ec\'\3\2\2\2\u00ed\u00ef\7\63\2\2\u00ee\u00f0"+
		"\5@!\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1"+
		"\u00f2\7\37\2\2\u00f2)\3\2\2\2\u00f3\u00f4\t\3\2\2\u00f4+\3\2\2\2\u00f5"+
		"\u0101\5\34\17\2\u00f6\u0101\5 \21\2\u00f7\u0101\5\"\22\2\u00f8\u0101"+
		"\5&\24\2\u00f9\u0101\5(\25\2\u00fa\u0101\5*\26\2\u00fb\u0101\5\36\20\2"+
		"\u00fc\u00fe\5@!\2\u00fd\u00fc\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff"+
		"\3\2\2\2\u00ff\u0101\7\37\2\2\u0100\u00f5\3\2\2\2\u0100\u00f6\3\2\2\2"+
		"\u0100\u00f7\3\2\2\2\u0100\u00f8\3\2\2\2\u0100\u00f9\3\2\2\2\u0100\u00fa"+
		"\3\2\2\2\u0100\u00fb\3\2\2\2\u0100\u00fd\3\2\2\2\u0101-\3\2\2\2\u0102"+
		"\u0103\7\64\2\2\u0103\u0104\5\30\r\2\u0104/\3\2\2\2\u0105\u0106\t\4\2"+
		"\2\u0106\u0107\5@!\2\u0107\61\3\2\2\2\u0108\u0109\t\4\2\2\u0109\63\3\2"+
		"\2\2\u010a\u010b\t\5\2\2\u010b\65\3\2\2\2\u010c\u010d\t\6\2\2\u010d\67"+
		"\3\2\2\2\u010e\u010f\t\7\2\2\u010f9\3\2\2\2\u0110\u0111\t\b\2\2\u0111"+
		";\3\2\2\2\u0112\u0113\t\t\2\2\u0113=\3\2\2\2\u0114\u0115\t\n\2\2\u0115"+
		"?\3\2\2\2\u0116\u0117\b!\1\2\u0117\u0124\5B\"\2\u0118\u0119\7\35\2\2\u0119"+
		"\u011a\5@!\2\u011a\u011b\7\36\2\2\u011b\u0124\3\2\2\2\u011c\u0124\5\16"+
		"\b\2\u011d\u0124\5\22\n\2\u011e\u0124\5\60\31\2\u011f\u0120\5\64\33\2"+
		"\u0120\u0121\5@!\17\u0121\u0124\3\2\2\2\u0122\u0124\5.\30\2\u0123\u0116"+
		"\3\2\2\2\u0123\u0118\3\2\2\2\u0123\u011c\3\2\2\2\u0123\u011d\3\2\2\2\u0123"+
		"\u011e\3\2\2\2\u0123\u011f\3\2\2\2\u0123\u0122\3\2\2\2\u0124\u0157\3\2"+
		"\2\2\u0125\u0126\f\24\2\2\u0126\u0127\7\32\2\2\u0127\u0156\5@!\25\u0128"+
		"\u0129\f\r\2\2\u0129\u012a\5\66\34\2\u012a\u012b\5@!\16\u012b\u0156\3"+
		"\2\2\2\u012c\u012d\f\f\2\2\u012d\u012e\58\35\2\u012e\u012f\5@!\r\u012f"+
		"\u0156\3\2\2\2\u0130\u0131\f\13\2\2\u0131\u0132\5:\36\2\u0132\u0133\5"+
		"@!\f\u0133\u0156\3\2\2\2\u0134\u0135\f\n\2\2\u0135\u0136\5<\37\2\u0136"+
		"\u0137\5@!\13\u0137\u0156\3\2\2\2\u0138\u0139\f\t\2\2\u0139\u013a\5> "+
		"\2\u013a\u013b\5@!\n\u013b\u0156\3\2\2\2\u013c\u013d\f\b\2\2\u013d\u013e"+
		"\7\23\2\2\u013e\u0156\5@!\t\u013f\u0140\f\7\2\2\u0140\u0141\7\25\2\2\u0141"+
		"\u0156\5@!\b\u0142\u0143\f\6\2\2\u0143\u0144\7\24\2\2\u0144\u0156\5@!"+
		"\7\u0145\u0146\f\5\2\2\u0146\u0147\7\16\2\2\u0147\u0156\5@!\6\u0148\u0149"+
		"\f\4\2\2\u0149\u014a\7\17\2\2\u014a\u0156\5@!\5\u014b\u014c\f\3\2\2\u014c"+
		"\u014d\7\27\2\2\u014d\u0156\5@!\3\u014e\u014f\f\25\2\2\u014f\u0150\7\33"+
		"\2\2\u0150\u0151\5@!\2\u0151\u0152\7\34\2\2\u0152\u0156\3\2\2\2\u0153"+
		"\u0154\f\21\2\2\u0154\u0156\5\62\32\2\u0155\u0125\3\2\2\2\u0155\u0128"+
		"\3\2\2\2\u0155\u012c\3\2\2\2\u0155\u0130\3\2\2\2\u0155\u0134\3\2\2\2\u0155"+
		"\u0138\3\2\2\2\u0155\u013c\3\2\2\2\u0155\u013f\3\2\2\2\u0155\u0142\3\2"+
		"\2\2\u0155\u0145\3\2\2\2\u0155\u0148\3\2\2\2\u0155\u014b\3\2\2\2\u0155"+
		"\u014e\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158A\3\2\2\2\u0159\u0157\3\2\2\2\u015a\u0162"+
		"\7;\2\2\u015b\u0162\7<\2\2\u015c\u0162\7A\2\2\u015d\u0162\7,\2\2\u015e"+
		"\u0162\7+\2\2\u015f\u0162\7*\2\2\u0160\u0162\7\66\2\2\u0161\u015a\3\2"+
		"\2\2\u0161\u015b\3\2\2\2\u0161\u015c\3\2\2\2\u0161\u015d\3\2\2\2\u0161"+
		"\u015e\3\2\2\2\u0161\u015f\3\2\2\2\u0161\u0160\3\2\2\2\u0162C\3\2\2\2"+
		"!GIRTcpu\u0080\u0083\u008a\u008d\u0099\u00a1\u00a7\u00ab\u00b2\u00b8\u00bc"+
		"\u00c3\u00d4\u00db\u00e0\u00e4\u00e8\u00ef\u00fd\u0100\u0123\u0155\u0157"+
		"\u0161";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}