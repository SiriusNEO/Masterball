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
		RULE_funcDef = 3, RULE_funcDefArgs = 4, RULE_funcCallArgs = 5, RULE_builtinType = 6, 
		RULE_varDefType = 7, RULE_newExpSizeDeclaration = 8, RULE_newExpType = 9, 
		RULE_varDefBody = 10, RULE_varDefSingle = 11, RULE_suite = 12, RULE_varDefStmt = 13, 
		RULE_ifStmt = 14, RULE_whileStmt = 15, RULE_forInit = 16, RULE_forStmt = 17, 
		RULE_returnStmt = 18, RULE_controlStmt = 19, RULE_pureStmt = 20, RULE_suiteStmt = 21, 
		RULE_statement = 22, RULE_prefixOps = 23, RULE_postfixOps = 24, RULE_unaryOps = 25, 
		RULE_shiftOps = 26, RULE_mulLevelOps = 27, RULE_addLevelOps = 28, RULE_compareOps = 29, 
		RULE_equalOps = 30, RULE_expression = 31, RULE_atom = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"mxStarCode", "classDef", "classConstructorDef", "funcDef", "funcDefArgs", 
			"funcCallArgs", "builtinType", "varDefType", "newExpSizeDeclaration", 
			"newExpType", "varDefBody", "varDefSingle", "suite", "varDefStmt", "ifStmt", 
			"whileStmt", "forInit", "forStmt", "returnStmt", "controlStmt", "pureStmt", 
			"suiteStmt", "statement", "prefixOps", "postfixOps", "unaryOps", "shiftOps", 
			"mulLevelOps", "addLevelOps", "compareOps", "equalOps", "expression", 
			"atom"
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
		public TerminalNode EOF() { return getToken(MxStarParser.EOF, 0); }
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
			setState(74);
			match(EOF);
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
			setState(76);
			match(ClassKw);
			setState(77);
			match(Identifier);
			setState(78);
			match(LeftBrace);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << Identifier))) != 0)) {
				{
				setState(82);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(79);
					classConstructorDef();
					}
					break;
				case 2:
					{
					setState(80);
					varDefStmt();
					}
					break;
				case 3:
					{
					setState(81);
					funcDef();
					}
					break;
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(RightBrace);
			setState(88);
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
			setState(90);
			match(Identifier);
			setState(91);
			match(LeftParen);
			setState(92);
			match(RightParen);
			setState(93);
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
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
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
			setState(95);
			varDefType(0);
			setState(96);
			match(Identifier);
			setState(97);
			match(LeftParen);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << Identifier))) != 0)) {
				{
				setState(98);
				funcDefArgs();
				}
			}

			setState(101);
			match(RightParen);
			setState(102);
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
			setState(104);
			varDefType(0);
			setState(105);
			match(Identifier);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(106);
				match(Comma);
				setState(107);
				varDefType(0);
				setState(108);
				match(Identifier);
				}
				}
				setState(114);
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
		enterRule(_localctx, 10, RULE_funcCallArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(LeftParen);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(116);
				expression(0);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(117);
					match(Comma);
					setState(118);
					expression(0);
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(126);
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

	public static class BuiltinTypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(MxStarParser.IntType, 0); }
		public TerminalNode StringType() { return getToken(MxStarParser.StringType, 0); }
		public TerminalNode BoolType() { return getToken(MxStarParser.BoolType, 0); }
		public TerminalNode VoidType() { return getToken(MxStarParser.VoidType, 0); }
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
		enterRule(_localctx, 12, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType))) != 0)) ) {
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

	public static class VarDefTypeContext extends ParserRuleContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public List<TerminalNode> LeftBracket() { return getTokens(MxStarParser.LeftBracket); }
		public TerminalNode LeftBracket(int i) {
			return getToken(MxStarParser.LeftBracket, i);
		}
		public List<TerminalNode> RightBracket() { return getTokens(MxStarParser.RightBracket); }
		public TerminalNode RightBracket(int i) {
			return getToken(MxStarParser.RightBracket, i);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_varDefType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case BoolType:
			case StringType:
			case VoidType:
				{
				setState(131);
				builtinType();
				}
				break;
			case Identifier:
				{
				setState(132);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarDefTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varDefType);
					setState(135);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(138); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(136);
							match(LeftBracket);
							setState(137);
							match(RightBracket);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(140); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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

	public static class NewExpSizeDeclarationContext extends ParserRuleContext {
		public TerminalNode LeftBracket() { return getToken(MxStarParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxStarParser.RightBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NewExpSizeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpSizeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExpSizeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExpSizeDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExpSizeDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpSizeDeclarationContext newExpSizeDeclaration() throws RecognitionException {
		NewExpSizeDeclarationContext _localctx = new NewExpSizeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_newExpSizeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(LeftBracket);
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(148);
				expression(0);
				}
			}

			setState(151);
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

	public static class NewExpTypeContext extends ParserRuleContext {
		public BuiltinTypeContext builtinType() {
			return getRuleContext(BuiltinTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public NewExpTypeContext newExpType() {
			return getRuleContext(NewExpTypeContext.class,0);
		}
		public List<NewExpSizeDeclarationContext> newExpSizeDeclaration() {
			return getRuleContexts(NewExpSizeDeclarationContext.class);
		}
		public NewExpSizeDeclarationContext newExpSizeDeclaration(int i) {
			return getRuleContext(NewExpSizeDeclarationContext.class,i);
		}
		public NewExpTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNewExpType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNewExpType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNewExpType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewExpTypeContext newExpType() throws RecognitionException {
		return newExpType(0);
	}

	private NewExpTypeContext newExpType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		NewExpTypeContext _localctx = new NewExpTypeContext(_ctx, _parentState);
		NewExpTypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_newExpType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case BoolType:
			case StringType:
			case VoidType:
				{
				setState(154);
				builtinType();
				}
				break;
			case Identifier:
				{
				setState(155);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new NewExpTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_newExpType);
					setState(158);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(160); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(159);
							newExpSizeDeclaration();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(162); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(168);
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
		public List<VarDefSingleContext> varDefSingle() {
			return getRuleContexts(VarDefSingleContext.class);
		}
		public VarDefSingleContext varDefSingle(int i) {
			return getRuleContext(VarDefSingleContext.class,i);
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
		enterRule(_localctx, 20, RULE_varDefBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			varDefType(0);
			setState(170);
			varDefSingle();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(171);
				match(Comma);
				setState(172);
				varDefSingle();
				}
				}
				setState(177);
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

	public static class VarDefSingleContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode AssignOp() { return getToken(MxStarParser.AssignOp, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarDefSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDefSingle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDefSingle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDefSingle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDefSingle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefSingleContext varDefSingle() throws RecognitionException {
		VarDefSingleContext _localctx = new VarDefSingleContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDefSingle);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(Identifier);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssignOp) {
				{
				setState(179);
				match(AssignOp);
				setState(180);
				expression(0);
				}
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
		enterRule(_localctx, 24, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(LeftBrace);
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << SemiColon) | (1L << LeftBrace) | (1L << LambdaStartSymbol) | (1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << IfKw) | (1L << ForKw) | (1L << WhileKw) | (1L << BreakKw) | (1L << ContinueKw) | (1L << ReturnKw) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(184);
				statement();
				}
				}
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(190);
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
		enterRule(_localctx, 26, RULE_varDefStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			varDefBody();
			setState(193);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ElseKw() { return getToken(MxStarParser.ElseKw, 0); }
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
		enterRule(_localctx, 28, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			match(IfKw);
			setState(196);
			match(LeftParen);
			setState(197);
			expression(0);
			setState(198);
			match(RightParen);
			setState(199);
			statement();
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(200);
				match(ElseKw);
				setState(201);
				statement();
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WhileKw() { return getToken(MxStarParser.WhileKw, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 30, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(WhileKw);
			setState(205);
			match(LeftParen);
			setState(206);
			expression(0);
			setState(207);
			match(RightParen);
			setState(208);
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
		enterRule(_localctx, 32, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(210);
				varDefBody();
				}
				break;
			case 2:
				{
				setState(211);
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
		enterRule(_localctx, 34, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			match(ForKw);
			setState(215);
			match(LeftParen);
			setState(217);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(216);
				forInit();
				}
			}

			setState(219);
			match(SemiColon);
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(220);
				((ForStmtContext)_localctx).forCondition = expression(0);
				}
			}

			setState(223);
			match(SemiColon);
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(224);
				((ForStmtContext)_localctx).forIncr = expression(0);
				}
			}

			setState(227);
			match(RightParen);
			setState(228);
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
		enterRule(_localctx, 36, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(ReturnKw);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(231);
				expression(0);
				}
			}

			setState(234);
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
		enterRule(_localctx, 38, RULE_controlStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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

	public static class PureStmtContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PureStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pureStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPureStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPureStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPureStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PureStmtContext pureStmt() throws RecognitionException {
		PureStmtContext _localctx = new PureStmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pureStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << LambdaStartSymbol) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(238);
				expression(0);
				}
			}

			setState(241);
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

	public static class SuiteStmtContext extends ParserRuleContext {
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
		}
		public SuiteStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suiteStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuiteStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuiteStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSuiteStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuiteStmtContext suiteStmt() throws RecognitionException {
		SuiteStmtContext _localctx = new SuiteStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_suiteStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
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

	public static class StatementContext extends ParserRuleContext {
		public SuiteStmtContext suiteStmt() {
			return getRuleContext(SuiteStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public ControlStmtContext controlStmt() {
			return getRuleContext(ControlStmtContext.class,0);
		}
		public VarDefStmtContext varDefStmt() {
			return getRuleContext(VarDefStmtContext.class,0);
		}
		public PureStmtContext pureStmt() {
			return getRuleContext(PureStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_statement);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(245);
				suiteStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(246);
				ifStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(247);
				whileStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248);
				forStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				returnStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				controlStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(251);
				varDefStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(252);
				pureStmt();
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

	public static class PrefixOpsContext extends ParserRuleContext {
		public TerminalNode IncrementOp() { return getToken(MxStarParser.IncrementOp, 0); }
		public TerminalNode DecrementOp() { return getToken(MxStarParser.DecrementOp, 0); }
		public PrefixOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrefixOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrefixOps(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrefixOps(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixOpsContext prefixOps() throws RecognitionException {
		PrefixOpsContext _localctx = new PrefixOpsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_prefixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
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
			setState(257);
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
			setState(259);
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
			setState(261);
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
			setState(263);
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
			setState(265);
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
			setState(267);
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
			setState(269);
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
	public static class AtomExpContext extends ExpressionContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AtomExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAtomExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAtomExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExpContext extends ExpressionContext {
		public PrefixOpsContext prefixOps() {
			return getRuleContext(PrefixOpsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixExpContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class MemberExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MemberOp() { return getToken(MxStarParser.MemberOp, 0); }
		public MemberExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMemberExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMemberExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMemberExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExpContext extends ExpressionContext {
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
		public BinaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBinaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBinaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBinaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AssignOp() { return getToken(MxStarParser.AssignOp, 0); }
		public AssignExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAssignExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAssignExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAssignExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryExpContext extends ExpressionContext {
		public UnaryOpsContext unaryOps() {
			return getRuleContext(UnaryOpsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitUnaryExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitUnaryExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewExpContext extends ExpressionContext {
		public TerminalNode NewKw() { return getToken(MxStarParser.NewKw, 0); }
		public NewExpTypeContext newExpType() {
			return getRuleContext(NewExpTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public NewExpContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class LambdaExpContext extends ExpressionContext {
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
		public LambdaExpContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class ParenExpContext extends ExpressionContext {
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public ParenExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParenExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParenExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParenExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncCallExpContext extends ExpressionContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public FuncCallArgsContext funcCallArgs() {
			return getRuleContext(FuncCallArgsContext.class,0);
		}
		public FuncCallExpContext(ExpressionContext ctx) { copyFrom(ctx); }
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
	public static class PostfixExpContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PostfixOpsContext postfixOps() {
			return getRuleContext(PostfixOpsContext.class,0);
		}
		public PostfixExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPostfixExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPostfixExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPostfixExp(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IndexExpContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LeftBracket() { return getToken(MxStarParser.LeftBracket, 0); }
		public TerminalNode RightBracket() { return getToken(MxStarParser.RightBracket, 0); }
		public IndexExpContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIndexExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIndexExp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIndexExp(this);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new AtomExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(272);
				atom();
				}
				break;
			case 2:
				{
				_localctx = new ParenExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(LeftParen);
				setState(274);
				expression(0);
				setState(275);
				match(RightParen);
				}
				break;
			case 3:
				{
				_localctx = new FuncCallExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(Identifier);
				setState(278);
				funcCallArgs();
				}
				break;
			case 4:
				{
				_localctx = new LambdaExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(279);
				match(LambdaStartSymbol);
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LeftParen) {
					{
					setState(280);
					match(LeftParen);
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << Identifier))) != 0)) {
						{
						setState(281);
						funcDefArgs();
						}
					}

					setState(284);
					match(RightParen);
					}
				}

				setState(287);
				match(LambdaArrowSymbol);
				setState(288);
				suite();
				setState(289);
				funcCallArgs();
				}
				break;
			case 5:
				{
				_localctx = new PrefixExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				prefixOps();
				setState(292);
				expression(14);
				}
				break;
			case 6:
				{
				_localctx = new UnaryExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(294);
				unaryOps();
				setState(295);
				expression(13);
				}
				break;
			case 7:
				{
				_localctx = new NewExpContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(297);
				match(NewKw);
				setState(298);
				newExpType(0);
				setState(301);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(299);
					match(LeftParen);
					setState(300);
					match(RightParen);
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(355);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(353);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MemberExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(305);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(306);
						match(MemberOp);
						setState(307);
						expression(19);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(308);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(309);
						shiftOps();
						setState(310);
						expression(12);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(312);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(313);
						mulLevelOps();
						setState(314);
						expression(11);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(316);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(317);
						addLevelOps();
						setState(318);
						expression(10);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(320);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(321);
						compareOps();
						setState(322);
						expression(9);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(324);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(325);
						equalOps();
						setState(326);
						expression(8);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(328);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(329);
						match(BitAndOp);
						setState(330);
						expression(7);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(331);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(332);
						match(BitXorOp);
						setState(333);
						expression(6);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(334);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(335);
						match(BitOrOp);
						setState(336);
						expression(5);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(337);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(338);
						match(LogicAndOp);
						setState(339);
						expression(4);
						}
						break;
					case 11:
						{
						_localctx = new BinaryExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(340);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(341);
						match(LogicOrOp);
						setState(342);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new AssignExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(343);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(344);
						match(AssignOp);
						setState(345);
						expression(1);
						}
						break;
					case 13:
						{
						_localctx = new IndexExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(346);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(347);
						match(LeftBracket);
						setState(348);
						expression(0);
						setState(349);
						match(RightBracket);
						}
						break;
					case 14:
						{
						_localctx = new PostfixExpContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(351);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(352);
						postfixOps();
						}
						break;
					}
					} 
				}
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode IntegerConstant() { return getToken(MxStarParser.IntegerConstant, 0); }
		public TerminalNode StringConstant() { return getToken(MxStarParser.StringConstant, 0); }
		public TerminalNode FalseConstant() { return getToken(MxStarParser.FalseConstant, 0); }
		public TerminalNode TrueConstant() { return getToken(MxStarParser.TrueConstant, 0); }
		public TerminalNode NullConstant() { return getToken(MxStarParser.NullConstant, 0); }
		public TerminalNode ThisPointer() { return getToken(MxStarParser.ThisPointer, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return varDefType_sempred((VarDefTypeContext)_localctx, predIndex);
		case 9:
			return newExpType_sempred((NewExpTypeContext)_localctx, predIndex);
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
	private boolean newExpType_sempred(NewExpTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 18);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		case 13:
			return precpred(_ctx, 1);
		case 14:
			return precpred(_ctx, 19);
		case 15:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u016b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3U\n\3\f\3\16\3X\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\5\3\5\5\5f\n\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6q\n\6\f\6"+
		"\16\6t\13\6\3\7\3\7\3\7\3\7\7\7z\n\7\f\7\16\7}\13\7\5\7\177\n\7\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\t\5\t\u0088\n\t\3\t\3\t\3\t\6\t\u008d\n\t\r\t\16"+
		"\t\u008e\7\t\u0091\n\t\f\t\16\t\u0094\13\t\3\n\3\n\5\n\u0098\n\n\3\n\3"+
		"\n\3\13\3\13\3\13\5\13\u009f\n\13\3\13\3\13\6\13\u00a3\n\13\r\13\16\13"+
		"\u00a4\7\13\u00a7\n\13\f\13\16\13\u00aa\13\13\3\f\3\f\3\f\3\f\7\f\u00b0"+
		"\n\f\f\f\16\f\u00b3\13\f\3\r\3\r\3\r\5\r\u00b8\n\r\3\16\3\16\7\16\u00bc"+
		"\n\16\f\16\16\16\u00bf\13\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u00cd\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\5\22\u00d7\n\22\3\23\3\23\3\23\5\23\u00dc\n\23\3\23\3\23\5\23\u00e0"+
		"\n\23\3\23\3\23\5\23\u00e4\n\23\3\23\3\23\3\23\3\24\3\24\5\24\u00eb\n"+
		"\24\3\24\3\24\3\25\3\25\3\26\5\26\u00f2\n\26\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0100\n\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\5!\u011d\n!\3!\5!\u0120\n!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\5!\u0130\n!\5!\u0132\n!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0164\n!\f!\16!\u0167"+
		"\13!\3\"\3\"\3\"\2\5\20\24@#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \""+
		"$&(*,.\60\62\64\668:<>@B\2\f\3\2&)\3\2\61\62\3\2\30\31\5\2\3\4\20\20\26"+
		"\26\3\2\21\22\3\2\5\7\3\2\3\4\3\2\b\13\3\2\f\r\6\2*,\66\66;<AA\2\u0182"+
		"\2I\3\2\2\2\4N\3\2\2\2\6\\\3\2\2\2\ba\3\2\2\2\nj\3\2\2\2\fu\3\2\2\2\16"+
		"\u0082\3\2\2\2\20\u0087\3\2\2\2\22\u0095\3\2\2\2\24\u009e\3\2\2\2\26\u00ab"+
		"\3\2\2\2\30\u00b4\3\2\2\2\32\u00b9\3\2\2\2\34\u00c2\3\2\2\2\36\u00c5\3"+
		"\2\2\2 \u00ce\3\2\2\2\"\u00d6\3\2\2\2$\u00d8\3\2\2\2&\u00e8\3\2\2\2(\u00ee"+
		"\3\2\2\2*\u00f1\3\2\2\2,\u00f5\3\2\2\2.\u00ff\3\2\2\2\60\u0101\3\2\2\2"+
		"\62\u0103\3\2\2\2\64\u0105\3\2\2\2\66\u0107\3\2\2\28\u0109\3\2\2\2:\u010b"+
		"\3\2\2\2<\u010d\3\2\2\2>\u010f\3\2\2\2@\u0131\3\2\2\2B\u0168\3\2\2\2D"+
		"H\5\4\3\2EH\5\b\5\2FH\5\34\17\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2"+
		"\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\2\2\3M\3\3\2\2\2NO\7\65"+
		"\2\2OP\7;\2\2PV\7!\2\2QU\5\6\4\2RU\5\34\17\2SU\5\b\5\2TQ\3\2\2\2TR\3\2"+
		"\2\2TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\""+
		"\2\2Z[\7\37\2\2[\5\3\2\2\2\\]\7;\2\2]^\7\35\2\2^_\7\36\2\2_`\5\32\16\2"+
		"`\7\3\2\2\2ab\5\20\t\2bc\7;\2\2ce\7\35\2\2df\5\n\6\2ed\3\2\2\2ef\3\2\2"+
		"\2fg\3\2\2\2gh\7\36\2\2hi\5\32\16\2i\t\3\2\2\2jk\5\20\t\2kr\7;\2\2lm\7"+
		" \2\2mn\5\20\t\2no\7;\2\2oq\3\2\2\2pl\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3"+
		"\2\2\2s\13\3\2\2\2tr\3\2\2\2u~\7\35\2\2v{\5@!\2wx\7 \2\2xz\5@!\2yw\3\2"+
		"\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\177\3\2\2\2}{\3\2\2\2~v\3\2\2\2~\177"+
		"\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\7\36\2\2\u0081\r\3\2\2\2\u0082"+
		"\u0083\t\2\2\2\u0083\17\3\2\2\2\u0084\u0085\b\t\1\2\u0085\u0088\5\16\b"+
		"\2\u0086\u0088\7;\2\2\u0087\u0084\3\2\2\2\u0087\u0086\3\2\2\2\u0088\u0092"+
		"\3\2\2\2\u0089\u008c\f\3\2\2\u008a\u008b\7\33\2\2\u008b\u008d\7\34\2\2"+
		"\u008c\u008a\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f"+
		"\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0089\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\21\3\2\2\2\u0094\u0092\3\2\2"+
		"\2\u0095\u0097\7\33\2\2\u0096\u0098\5@!\2\u0097\u0096\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\34\2\2\u009a\23\3\2\2\2\u009b"+
		"\u009c\b\13\1\2\u009c\u009f\5\16\b\2\u009d\u009f\7;\2\2\u009e\u009b\3"+
		"\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a8\3\2\2\2\u00a0\u00a2\f\3\2\2\u00a1"+
		"\u00a3\5\22\n\2\u00a2\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a2\3"+
		"\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a0\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\25\3\2\2"+
		"\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\5\20\t\2\u00ac\u00b1\5\30\r\2\u00ad"+
		"\u00ae\7 \2\2\u00ae\u00b0\5\30\r\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\3\2"+
		"\2\2\u00b1\u00af\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\27\3\2\2\2\u00b3\u00b1"+
		"\3\2\2\2\u00b4\u00b7\7;\2\2\u00b5\u00b6\7\27\2\2\u00b6\u00b8\5@!\2\u00b7"+
		"\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\31\3\2\2\2\u00b9\u00bd\7!\2\2"+
		"\u00ba\u00bc\5.\30\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00c0\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00c1\7\"\2\2\u00c1\33\3\2\2\2\u00c2\u00c3\5\26\f\2\u00c3\u00c4\7\37"+
		"\2\2\u00c4\35\3\2\2\2\u00c5\u00c6\7-\2\2\u00c6\u00c7\7\35\2\2\u00c7\u00c8"+
		"\5@!\2\u00c8\u00c9\7\36\2\2\u00c9\u00cc\5.\30\2\u00ca\u00cb\7.\2\2\u00cb"+
		"\u00cd\5.\30\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\37\3\2\2"+
		"\2\u00ce\u00cf\7\60\2\2\u00cf\u00d0\7\35\2\2\u00d0\u00d1\5@!\2\u00d1\u00d2"+
		"\7\36\2\2\u00d2\u00d3\5.\30\2\u00d3!\3\2\2\2\u00d4\u00d7\5\26\f\2\u00d5"+
		"\u00d7\5@!\2\u00d6\u00d4\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7#\3\2\2\2\u00d8"+
		"\u00d9\7/\2\2\u00d9\u00db\7\35\2\2\u00da\u00dc\5\"\22\2\u00db\u00da\3"+
		"\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00df\7\37\2\2\u00de"+
		"\u00e0\5@!\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2"+
		"\2\u00e1\u00e3\7\37\2\2\u00e2\u00e4\5@!\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4"+
		"\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\7\36\2\2\u00e6\u00e7\5.\30\2"+
		"\u00e7%\3\2\2\2\u00e8\u00ea\7\63\2\2\u00e9\u00eb\5@!\2\u00ea\u00e9\3\2"+
		"\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ed\7\37\2\2\u00ed"+
		"\'\3\2\2\2\u00ee\u00ef\t\3\2\2\u00ef)\3\2\2\2\u00f0\u00f2\5@!\2\u00f1"+
		"\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f4\7\37"+
		"\2\2\u00f4+\3\2\2\2\u00f5\u00f6\5\32\16\2\u00f6-\3\2\2\2\u00f7\u0100\5"+
		",\27\2\u00f8\u0100\5\36\20\2\u00f9\u0100\5 \21\2\u00fa\u0100\5$\23\2\u00fb"+
		"\u0100\5&\24\2\u00fc\u0100\5(\25\2\u00fd\u0100\5\34\17\2\u00fe\u0100\5"+
		"*\26\2\u00ff\u00f7\3\2\2\2\u00ff\u00f8\3\2\2\2\u00ff\u00f9\3\2\2\2\u00ff"+
		"\u00fa\3\2\2\2\u00ff\u00fb\3\2\2\2\u00ff\u00fc\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u00fe\3\2\2\2\u0100/\3\2\2\2\u0101\u0102\t\4\2\2\u0102\61\3"+
		"\2\2\2\u0103\u0104\t\4\2\2\u0104\63\3\2\2\2\u0105\u0106\t\5\2\2\u0106"+
		"\65\3\2\2\2\u0107\u0108\t\6\2\2\u0108\67\3\2\2\2\u0109\u010a\t\7\2\2\u010a"+
		"9\3\2\2\2\u010b\u010c\t\b\2\2\u010c;\3\2\2\2\u010d\u010e\t\t\2\2\u010e"+
		"=\3\2\2\2\u010f\u0110\t\n\2\2\u0110?\3\2\2\2\u0111\u0112\b!\1\2\u0112"+
		"\u0132\5B\"\2\u0113\u0114\7\35\2\2\u0114\u0115\5@!\2\u0115\u0116\7\36"+
		"\2\2\u0116\u0132\3\2\2\2\u0117\u0118\7;\2\2\u0118\u0132\5\f\7\2\u0119"+
		"\u011f\7$\2\2\u011a\u011c\7\35\2\2\u011b\u011d\5\n\6\2\u011c\u011b\3\2"+
		"\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\7\36\2\2\u011f"+
		"\u011a\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0122\7%"+
		"\2\2\u0122\u0123\5\32\16\2\u0123\u0124\5\f\7\2\u0124\u0132\3\2\2\2\u0125"+
		"\u0126\5\60\31\2\u0126\u0127\5@!\20\u0127\u0132\3\2\2\2\u0128\u0129\5"+
		"\64\33\2\u0129\u012a\5@!\17\u012a\u0132\3\2\2\2\u012b\u012c\7\64\2\2\u012c"+
		"\u012f\5\24\13\2\u012d\u012e\7\35\2\2\u012e\u0130\7\36\2\2\u012f\u012d"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0132\3\2\2\2\u0131\u0111\3\2\2\2\u0131"+
		"\u0113\3\2\2\2\u0131\u0117\3\2\2\2\u0131\u0119\3\2\2\2\u0131\u0125\3\2"+
		"\2\2\u0131\u0128\3\2\2\2\u0131\u012b\3\2\2\2\u0132\u0165\3\2\2\2\u0133"+
		"\u0134\f\24\2\2\u0134\u0135\7\32\2\2\u0135\u0164\5@!\25\u0136\u0137\f"+
		"\r\2\2\u0137\u0138\5\66\34\2\u0138\u0139\5@!\16\u0139\u0164\3\2\2\2\u013a"+
		"\u013b\f\f\2\2\u013b\u013c\58\35\2\u013c\u013d\5@!\r\u013d\u0164\3\2\2"+
		"\2\u013e\u013f\f\13\2\2\u013f\u0140\5:\36\2\u0140\u0141\5@!\f\u0141\u0164"+
		"\3\2\2\2\u0142\u0143\f\n\2\2\u0143\u0144\5<\37\2\u0144\u0145\5@!\13\u0145"+
		"\u0164\3\2\2\2\u0146\u0147\f\t\2\2\u0147\u0148\5> \2\u0148\u0149\5@!\n"+
		"\u0149\u0164\3\2\2\2\u014a\u014b\f\b\2\2\u014b\u014c\7\23\2\2\u014c\u0164"+
		"\5@!\t\u014d\u014e\f\7\2\2\u014e\u014f\7\25\2\2\u014f\u0164\5@!\b\u0150"+
		"\u0151\f\6\2\2\u0151\u0152\7\24\2\2\u0152\u0164\5@!\7\u0153\u0154\f\5"+
		"\2\2\u0154\u0155\7\16\2\2\u0155\u0164\5@!\6\u0156\u0157\f\4\2\2\u0157"+
		"\u0158\7\17\2\2\u0158\u0164\5@!\5\u0159\u015a\f\3\2\2\u015a\u015b\7\27"+
		"\2\2\u015b\u0164\5@!\3\u015c\u015d\f\25\2\2\u015d\u015e\7\33\2\2\u015e"+
		"\u015f\5@!\2\u015f\u0160\7\34\2\2\u0160\u0164\3\2\2\2\u0161\u0162\f\21"+
		"\2\2\u0162\u0164\5\62\32\2\u0163\u0133\3\2\2\2\u0163\u0136\3\2\2\2\u0163"+
		"\u013a\3\2\2\2\u0163\u013e\3\2\2\2\u0163\u0142\3\2\2\2\u0163\u0146\3\2"+
		"\2\2\u0163\u014a\3\2\2\2\u0163\u014d\3\2\2\2\u0163\u0150\3\2\2\2\u0163"+
		"\u0153\3\2\2\2\u0163\u0156\3\2\2\2\u0163\u0159\3\2\2\2\u0163\u015c\3\2"+
		"\2\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165"+
		"\u0166\3\2\2\2\u0166A\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\t\13\2\2"+
		"\u0169C\3\2\2\2\"GITVer{~\u0087\u008e\u0092\u0097\u009e\u00a4\u00a8\u00b1"+
		"\u00b7\u00bd\u00cc\u00d6\u00db\u00df\u00e3\u00ea\u00f1\u00ff\u011c\u011f"+
		"\u012f\u0131\u0163\u0165";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}