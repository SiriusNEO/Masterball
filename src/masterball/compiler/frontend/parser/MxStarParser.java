// Generated from src/masterball/compiler/frontend/parser/MxStar.g4 by ANTLR 4.7.2
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
		SemiColon=29, Comma=30, LeftBrace=31, RightBrace=32, QuoteOp=33, IntType=34, 
		BoolType=35, StringType=36, VoidType=37, NullConstant=38, TrueConstant=39, 
		FalseConstant=40, IfKw=41, ElseKw=42, ForKw=43, WhileKw=44, BreakKw=45, 
		ContinueKw=46, ReturnKw=47, NewKw=48, ClassKw=49, ThisPointer=50, WhitespaceEater=51, 
		NewlineEater=52, LineCommentEater=53, BlockCommentEater=54, Identifier=55, 
		IntegerConstant=56, EscapeEnter=57, EscapeBackslash=58, EscapeQuote=59, 
		StringContent=60, StringConstant=61;
	public static final int
		RULE_mxStarCode = 0, RULE_classDef = 1, RULE_classDefSuite = 2, RULE_classConstructorDef = 3, 
		RULE_funcDef = 4, RULE_funcDefArgs = 5, RULE_funcRetType = 6, RULE_builtinType = 7, 
		RULE_arrayType = 8, RULE_varDefType = 9, RULE_suite = 10, RULE_varDefStmt = 11, 
		RULE_ifStmt = 12, RULE_whileStmt = 13, RULE_forStmt = 14, RULE_returnStmt = 15, 
		RULE_statement = 16, RULE_funcCallExp = 17, RULE_newExp = 18, RULE_suffixOps = 19, 
		RULE_prefixOps = 20, RULE_shiftOps = 21, RULE_mulLevelOps = 22, RULE_addLevelOps = 23, 
		RULE_compareOps = 24, RULE_equalOps = 25, RULE_expression = 26, RULE_atom = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"mxStarCode", "classDef", "classDefSuite", "classConstructorDef", "funcDef", 
			"funcDefArgs", "funcRetType", "builtinType", "arrayType", "varDefType", 
			"suite", "varDefStmt", "ifStmt", "whileStmt", "forStmt", "returnStmt", 
			"statement", "funcCallExp", "newExp", "suffixOps", "prefixOps", "shiftOps", 
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
			"';'", "','", "'{'", "'}'", "'\"'", "'int'", "'bool'", "'string'", "'void'", 
			"'null'", "'true'", "'false'", "'if'", "'else'", "'for'", "'while'", 
			"'break'", "'continue'", "'return'", "'new'", "'class'", "'this'", null, 
			null, null, null, null, null, "'\\n'", "'\\\\'", "'\\\"'"
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
			"SemiColon", "Comma", "LeftBrace", "RightBrace", "QuoteOp", "IntType", 
			"BoolType", "StringType", "VoidType", "NullConstant", "TrueConstant", 
			"FalseConstant", "IfKw", "ElseKw", "ForKw", "WhileKw", "BreakKw", "ContinueKw", 
			"ReturnKw", "NewKw", "ClassKw", "ThisPointer", "WhitespaceEater", "NewlineEater", 
			"LineCommentEater", "BlockCommentEater", "Identifier", "IntegerConstant", 
			"EscapeEnter", "EscapeBackslash", "EscapeQuote", "StringContent", "StringConstant"
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
	}

	public final MxStarCodeContext mxStarCode() throws RecognitionException {
		MxStarCodeContext _localctx = new MxStarCodeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mxStarCode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << ClassKw) | (1L << Identifier))) != 0)) {
				{
				setState(59);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(56);
					classDef();
					}
					break;
				case 2:
					{
					setState(57);
					funcDef();
					}
					break;
				case 3:
					{
					setState(58);
					varDefStmt();
					}
					break;
				}
				}
				setState(63);
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
		public ClassDefSuiteContext classDefSuite() {
			return getRuleContext(ClassDefSuiteContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
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
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(ClassKw);
			setState(65);
			match(Identifier);
			setState(66);
			classDefSuite();
			setState(67);
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

	public static class ClassDefSuiteContext extends ParserRuleContext {
		public TerminalNode LeftBrace() { return getToken(MxStarParser.LeftBrace, 0); }
		public TerminalNode RightBrace() { return getToken(MxStarParser.RightBrace, 0); }
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
		public ClassDefSuiteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefSuite; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassDefSuite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassDefSuite(this);
		}
	}

	public final ClassDefSuiteContext classDefSuite() throws RecognitionException {
		ClassDefSuiteContext _localctx = new ClassDefSuiteContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDefSuite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(LeftBrace);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << VoidType) | (1L << Identifier))) != 0)) {
				{
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(70);
					classConstructorDef();
					}
					break;
				case 2:
					{
					setState(71);
					varDefStmt();
					}
					break;
				case 3:
					{
					setState(72);
					funcDef();
					}
					break;
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
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
	}

	public final ClassConstructorDefContext classConstructorDef() throws RecognitionException {
		ClassConstructorDefContext _localctx = new ClassConstructorDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classConstructorDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(Identifier);
			setState(81);
			match(LeftParen);
			setState(82);
			match(RightParen);
			setState(83);
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
		public List<FuncDefArgsContext> funcDefArgs() {
			return getRuleContexts(FuncDefArgsContext.class);
		}
		public FuncDefArgsContext funcDefArgs(int i) {
			return getRuleContext(FuncDefArgsContext.class,i);
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
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			funcRetType();
			setState(86);
			match(Identifier);
			setState(87);
			match(LeftParen);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << Identifier))) != 0)) {
				{
				{
				setState(88);
				funcDefArgs();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			match(RightParen);
			setState(95);
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
	}

	public final FuncDefArgsContext funcDefArgs() throws RecognitionException {
		FuncDefArgsContext _localctx = new FuncDefArgsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcDefArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			varDefType(0);
			setState(98);
			match(Identifier);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(99);
				match(Comma);
				setState(100);
				varDefType(0);
				setState(101);
				match(Identifier);
				}
				}
				setState(107);
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
	}

	public final FuncRetTypeContext funcRetType() throws RecognitionException {
		FuncRetTypeContext _localctx = new FuncRetTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcRetType);
		try {
			setState(110);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VoidType:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(VoidType);
				}
				break;
			case IntType:
			case BoolType:
			case StringType:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
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
	}

	public final BuiltinTypeContext builtinType() throws RecognitionException {
		BuiltinTypeContext _localctx = new BuiltinTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_builtinType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrayType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(LeftBracket);
			setState(115);
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
	}

	public final VarDefTypeContext varDefType() throws RecognitionException {
		return varDefType(0);
	}

	private VarDefTypeContext varDefType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		VarDefTypeContext _localctx = new VarDefTypeContext(_ctx, _parentState);
		VarDefTypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_varDefType, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntType:
			case BoolType:
			case StringType:
				{
				setState(118);
				builtinType();
				}
				break;
			case Identifier:
				{
				setState(119);
				match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new VarDefTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_varDefType);
					setState(122);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(124); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(123);
							arrayType();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(126); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
	}

	public final SuiteContext suite() throws RecognitionException {
		SuiteContext _localctx = new SuiteContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_suite);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(LeftBrace);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << SemiColon) | (1L << IntType) | (1L << BoolType) | (1L << StringType) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << IfKw) | (1L << ForKw) | (1L << WhileKw) | (1L << BreakKw) | (1L << ContinueKw) | (1L << ReturnKw) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				{
				setState(134);
				statement();
				}
				}
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(140);
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
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public List<TerminalNode> Identifier() { return getTokens(MxStarParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MxStarParser.Identifier, i);
		}
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
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
	}

	public final VarDefStmtContext varDefStmt() throws RecognitionException {
		VarDefStmtContext _localctx = new VarDefStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDefStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			varDefType(0);
			setState(143);
			match(Identifier);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AssignOp) {
				{
				setState(144);
				match(AssignOp);
				setState(145);
				expression(0);
				}
			}

			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(148);
				match(Comma);
				setState(149);
				match(Identifier);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AssignOp) {
					{
					setState(150);
					match(AssignOp);
					setState(151);
					expression(0);
					}
				}

				}
				}
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(159);
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
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
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
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(IfKw);
			setState(162);
			match(LeftParen);
			setState(163);
			expression(0);
			setState(164);
			match(RightParen);
			setState(165);
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

	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WhileKw() { return getToken(MxStarParser.WhileKw, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
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
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(WhileKw);
			setState(168);
			match(LeftParen);
			setState(169);
			expression(0);
			setState(170);
			match(RightParen);
			setState(171);
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

	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode ForKw() { return getToken(MxStarParser.ForKw, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(MxStarParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(MxStarParser.SemiColon, i);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public SuiteContext suite() {
			return getRuleContext(SuiteContext.class,0);
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
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(ForKw);
			setState(174);
			match(LeftParen);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(175);
				expression(0);
				}
			}

			setState(178);
			match(SemiColon);
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(179);
				expression(0);
				}
			}

			setState(182);
			match(SemiColon);
			setState(183);
			match(RightParen);
			setState(184);
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
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_returnStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(ReturnKw);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp) | (1L << LeftParen) | (1L << NullConstant) | (1L << TrueConstant) | (1L << FalseConstant) | (1L << NewKw) | (1L << ThisPointer) | (1L << Identifier) | (1L << IntegerConstant) | (1L << StringConstant))) != 0)) {
				{
				setState(187);
				expression(0);
				}
			}

			setState(190);
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
	public static class EmptyStmtLContext extends StatementContext {
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public EmptyStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEmptyStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEmptyStmtL(this);
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
	}
	public static class ContinueStmtLContext extends StatementContext {
		public TerminalNode ContinueKw() { return getToken(MxStarParser.ContinueKw, 0); }
		public ContinueStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterContinueStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitContinueStmtL(this);
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
	}
	public static class SingleExpStmtLContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(MxStarParser.SemiColon, 0); }
		public SingleExpStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSingleExpStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSingleExpStmtL(this);
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
	}
	public static class BreakStmtLContext extends StatementContext {
		public TerminalNode BreakKw() { return getToken(MxStarParser.BreakKw, 0); }
		public BreakStmtLContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBreakStmtL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBreakStmtL(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_statement);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new IfStmtLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				ifStmt();
				}
				break;
			case 2:
				_localctx = new WhileStmtLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				whileStmt();
				}
				break;
			case 3:
				_localctx = new ForStmtLContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				forStmt();
				}
				break;
			case 4:
				_localctx = new ReturnStmtLContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				returnStmt();
				}
				break;
			case 5:
				_localctx = new BreakStmtLContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
				match(BreakKw);
				}
				break;
			case 6:
				_localctx = new ContinueStmtLContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(197);
				match(ContinueKw);
				}
				break;
			case 7:
				_localctx = new VarDefStmtLContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(198);
				varDefStmt();
				}
				break;
			case 8:
				_localctx = new SingleExpStmtLContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(199);
				expression(0);
				setState(200);
				match(SemiColon);
				}
				break;
			case 9:
				_localctx = new EmptyStmtLContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(202);
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

	public static class FuncCallExpContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
		public List<TerminalNode> Comma() { return getTokens(MxStarParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MxStarParser.Comma, i);
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
	}

	public final FuncCallExpContext funcCallExp() throws RecognitionException {
		FuncCallExpContext _localctx = new FuncCallExpContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funcCallExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(Identifier);
			setState(206);
			match(LeftParen);
			setState(207);
			expression(0);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(208);
				match(Comma);
				setState(209);
				expression(0);
				}
				}
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(215);
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

	public static class NewExpContext extends ParserRuleContext {
		public TerminalNode NewKw() { return getToken(MxStarParser.NewKw, 0); }
		public VarDefTypeContext varDefType() {
			return getRuleContext(VarDefTypeContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MxStarParser.LeftParen, 0); }
		public TerminalNode RightParen() { return getToken(MxStarParser.RightParen, 0); }
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
	}

	public final NewExpContext newExp() throws RecognitionException {
		NewExpContext _localctx = new NewExpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_newExp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(NewKw);
			setState(218);
			varDefType(0);
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(219);
				match(LeftParen);
				setState(220);
				match(RightParen);
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

	public static class SuffixOpsContext extends ParserRuleContext {
		public TerminalNode IncrementOp() { return getToken(MxStarParser.IncrementOp, 0); }
		public TerminalNode DecrementOp() { return getToken(MxStarParser.DecrementOp, 0); }
		public SuffixOpsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffixOps; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuffixOps(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuffixOps(this);
		}
	}

	public final SuffixOpsContext suffixOps() throws RecognitionException {
		SuffixOpsContext _localctx = new SuffixOpsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_suffixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
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

	public static class PrefixOpsContext extends ParserRuleContext {
		public TerminalNode IncrementOp() { return getToken(MxStarParser.IncrementOp, 0); }
		public TerminalNode DecrementOp() { return getToken(MxStarParser.DecrementOp, 0); }
		public TerminalNode BitNotOp() { return getToken(MxStarParser.BitNotOp, 0); }
		public TerminalNode LogicNotOp() { return getToken(MxStarParser.LogicNotOp, 0); }
		public TerminalNode AddOp() { return getToken(MxStarParser.AddOp, 0); }
		public TerminalNode SubOp() { return getToken(MxStarParser.SubOp, 0); }
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
	}

	public final PrefixOpsContext prefixOps() throws RecognitionException {
		PrefixOpsContext _localctx = new PrefixOpsContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_prefixOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AddOp) | (1L << SubOp) | (1L << LogicNotOp) | (1L << BitNotOp) | (1L << IncrementOp) | (1L << DecrementOp))) != 0)) ) {
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
	}

	public final ShiftOpsContext shiftOps() throws RecognitionException {
		ShiftOpsContext _localctx = new ShiftOpsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_shiftOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
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
	}

	public final MulLevelOpsContext mulLevelOps() throws RecognitionException {
		MulLevelOpsContext _localctx = new MulLevelOpsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_mulLevelOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
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
	}

	public final AddLevelOpsContext addLevelOps() throws RecognitionException {
		AddLevelOpsContext _localctx = new AddLevelOpsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_addLevelOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
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
	}

	public final CompareOpsContext compareOps() throws RecognitionException {
		CompareOpsContext _localctx = new CompareOpsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_compareOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
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
	}

	public final EqualOpsContext equalOps() throws RecognitionException {
		EqualOpsContext _localctx = new EqualOpsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_equalOps);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode MemberOp() { return getToken(MxStarParser.MemberOp, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public MemberExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMemberExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMemberExpL(this);
		}
	}
	public static class SuffixExpLContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SuffixOpsContext suffixOps() {
			return getRuleContext(SuffixOpsContext.class,0);
		}
		public SuffixExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuffixExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuffixExpL(this);
		}
	}
	public static class LogicOrExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LogicOrOp() { return getToken(MxStarParser.LogicOrOp, 0); }
		public LogicOrExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLogicOrExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLogicOrExpL(this);
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
	}
	public static class BitOrExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitOrOp() { return getToken(MxStarParser.BitOrOp, 0); }
		public BitOrExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBitOrExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBitOrExpL(this);
		}
	}
	public static class LogicExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ShiftOpsContext shiftOps() {
			return getRuleContext(ShiftOpsContext.class,0);
		}
		public LogicExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLogicExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLogicExpL(this);
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
	}
	public static class BitXorExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitXorOp() { return getToken(MxStarParser.BitXorOp, 0); }
		public BitXorExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBitXorExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBitXorExpL(this);
		}
	}
	public static class CompareExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CompareOpsContext compareOps() {
			return getRuleContext(CompareOpsContext.class,0);
		}
		public CompareExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCompareExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCompareExpL(this);
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
	}
	public static class LogicAndExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LogicAndOp() { return getToken(MxStarParser.LogicAndOp, 0); }
		public LogicAndExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterLogicAndExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitLogicAndExpL(this);
		}
	}
	public static class EqualExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualOpsContext equalOps() {
			return getRuleContext(EqualOpsContext.class,0);
		}
		public EqualExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterEqualExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitEqualExpL(this);
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
	}
	public static class PrefixExpLContext extends ExpressionContext {
		public PrefixOpsContext prefixOps() {
			return getRuleContext(PrefixOpsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
	}
	public static class MulLevelExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public MulLevelOpsContext mulLevelOps() {
			return getRuleContext(MulLevelOpsContext.class,0);
		}
		public MulLevelExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMulLevelExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMulLevelExpL(this);
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
	}
	public static class BitAndExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BitAndOp() { return getToken(MxStarParser.BitAndOp, 0); }
		public BitAndExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBitAndExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBitAndExpL(this);
		}
	}
	public static class AddLevelExpLContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddLevelOpsContext addLevelOps() {
			return getRuleContext(AddLevelOpsContext.class,0);
		}
		public AddLevelExpLContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAddLevelExpL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAddLevelExpL(this);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				_localctx = new SingleAtomLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(238);
				atom();
				}
				break;
			case 2:
				{
				_localctx = new ParenExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(LeftParen);
				setState(240);
				expression(0);
				setState(241);
				match(RightParen);
				}
				break;
			case 3:
				{
				_localctx = new FuncCallExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				funcCallExp();
				}
				break;
			case 4:
				{
				_localctx = new PrefixExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				prefixOps();
				setState(245);
				expression(13);
				}
				break;
			case 5:
				{
				_localctx = new NewExpLContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247);
				newExp();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(298);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new LogicExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(250);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(251);
						shiftOps();
						setState(252);
						expression(12);
						}
						break;
					case 2:
						{
						_localctx = new MulLevelExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(254);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(255);
						mulLevelOps();
						setState(256);
						expression(11);
						}
						break;
					case 3:
						{
						_localctx = new AddLevelExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(258);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(259);
						addLevelOps();
						setState(260);
						expression(10);
						}
						break;
					case 4:
						{
						_localctx = new CompareExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(262);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(263);
						compareOps();
						setState(264);
						expression(9);
						}
						break;
					case 5:
						{
						_localctx = new EqualExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(266);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(267);
						equalOps();
						setState(268);
						expression(8);
						}
						break;
					case 6:
						{
						_localctx = new BitAndExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(270);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(271);
						match(BitAndOp);
						setState(272);
						expression(7);
						}
						break;
					case 7:
						{
						_localctx = new BitXorExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(273);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(274);
						match(BitXorOp);
						setState(275);
						expression(6);
						}
						break;
					case 8:
						{
						_localctx = new BitOrExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(276);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(277);
						match(BitOrOp);
						setState(278);
						expression(5);
						}
						break;
					case 9:
						{
						_localctx = new LogicAndExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(279);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(280);
						match(LogicAndOp);
						setState(281);
						expression(4);
						}
						break;
					case 10:
						{
						_localctx = new LogicOrExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(283);
						match(LogicOrOp);
						setState(284);
						expression(3);
						}
						break;
					case 11:
						{
						_localctx = new AssignExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(285);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(286);
						match(AssignOp);
						setState(287);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new IndexExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(288);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(289);
						match(LeftBracket);
						setState(290);
						expression(0);
						setState(291);
						match(RightBracket);
						}
						break;
					case 13:
						{
						_localctx = new MemberExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(293);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(294);
						match(MemberOp);
						setState(295);
						match(Identifier);
						}
						break;
					case 14:
						{
						_localctx = new SuffixExpLContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(296);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(297);
						suffixOps();
						}
						break;
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_atom);
		try {
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				_localctx = new IdentifierLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(303);
				match(Identifier);
				}
				break;
			case IntegerConstant:
				_localctx = new IntLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(IntegerConstant);
				}
				break;
			case StringConstant:
				_localctx = new StringLContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(305);
				match(StringConstant);
				}
				break;
			case FalseConstant:
				_localctx = new FalseLContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(306);
				match(FalseConstant);
				}
				break;
			case TrueConstant:
				_localctx = new TrueLContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(307);
				match(TrueConstant);
				}
				break;
			case NullConstant:
				_localctx = new NullLContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(308);
				match(NullConstant);
				}
				break;
			case ThisPointer:
				_localctx = new ThisLContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(309);
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
		case 9:
			return varDefType_sempred((VarDefTypeContext)_localctx, predIndex);
		case 26:
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
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		case 3:
			return precpred(_ctx, 9);
		case 4:
			return precpred(_ctx, 8);
		case 5:
			return precpred(_ctx, 7);
		case 6:
			return precpred(_ctx, 6);
		case 7:
			return precpred(_ctx, 5);
		case 8:
			return precpred(_ctx, 4);
		case 9:
			return precpred(_ctx, 3);
		case 10:
			return precpred(_ctx, 2);
		case 11:
			return precpred(_ctx, 1);
		case 12:
			return precpred(_ctx, 17);
		case 13:
			return precpred(_ctx, 16);
		case 14:
			return precpred(_ctx, 14);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u013b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\7\2>\n\2\f\2\16\2"+
		"A\13\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\\\n\6\f\6\16\6_\13\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\7\7j\n\7\f\7\16\7m\13\7\3\b\3\b\5\bq"+
		"\n\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\5\13{\n\13\3\13\3\13\6\13\177"+
		"\n\13\r\13\16\13\u0080\7\13\u0083\n\13\f\13\16\13\u0086\13\13\3\f\3\f"+
		"\7\f\u008a\n\f\f\f\16\f\u008d\13\f\3\f\3\f\3\r\3\r\3\r\3\r\5\r\u0095\n"+
		"\r\3\r\3\r\3\r\3\r\5\r\u009b\n\r\7\r\u009d\n\r\f\r\16\r\u00a0\13\r\3\r"+
		"\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\5\20\u00b3\n\20\3\20\3\20\5\20\u00b7\n\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\5\21\u00bf\n\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\5\22\u00ce\n\22\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u00d5\n\23\f\23\16\23\u00d8\13\23\3\23\3\23\3\24\3\24\3\24\3\24\5\24"+
		"\u00e0\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u00fb\n\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u012d\n\34\f\34\16\34\u0130"+
		"\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u0139\n\35\3\35\2\4\24"+
		"\66\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2"+
		"\n\3\2$&\3\2\30\31\6\2\3\4\20\20\26\26\30\31\3\2\21\22\3\2\5\7\3\2\3\4"+
		"\3\2\b\13\3\2\f\r\2\u0153\2?\3\2\2\2\4B\3\2\2\2\6G\3\2\2\2\bR\3\2\2\2"+
		"\nW\3\2\2\2\fc\3\2\2\2\16p\3\2\2\2\20r\3\2\2\2\22t\3\2\2\2\24z\3\2\2\2"+
		"\26\u0087\3\2\2\2\30\u0090\3\2\2\2\32\u00a3\3\2\2\2\34\u00a9\3\2\2\2\36"+
		"\u00af\3\2\2\2 \u00bc\3\2\2\2\"\u00cd\3\2\2\2$\u00cf\3\2\2\2&\u00db\3"+
		"\2\2\2(\u00e1\3\2\2\2*\u00e3\3\2\2\2,\u00e5\3\2\2\2.\u00e7\3\2\2\2\60"+
		"\u00e9\3\2\2\2\62\u00eb\3\2\2\2\64\u00ed\3\2\2\2\66\u00fa\3\2\2\28\u0138"+
		"\3\2\2\2:>\5\4\3\2;>\5\n\6\2<>\5\30\r\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2"+
		">A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\3\3\2\2\2A?\3\2\2\2BC\7\63\2\2CD\79\2"+
		"\2DE\5\6\4\2EF\7\37\2\2F\5\3\2\2\2GM\7!\2\2HL\5\b\5\2IL\5\30\r\2JL\5\n"+
		"\6\2KH\3\2\2\2KI\3\2\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NP\3\2"+
		"\2\2OM\3\2\2\2PQ\7\"\2\2Q\7\3\2\2\2RS\79\2\2ST\7\35\2\2TU\7\36\2\2UV\5"+
		"\26\f\2V\t\3\2\2\2WX\5\16\b\2XY\79\2\2Y]\7\35\2\2Z\\\5\f\7\2[Z\3\2\2\2"+
		"\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\36\2\2ab\5\26"+
		"\f\2b\13\3\2\2\2cd\5\24\13\2dk\79\2\2ef\7 \2\2fg\5\24\13\2gh\79\2\2hj"+
		"\3\2\2\2ie\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\r\3\2\2\2mk\3\2\2\2"+
		"nq\7\'\2\2oq\5\24\13\2pn\3\2\2\2po\3\2\2\2q\17\3\2\2\2rs\t\2\2\2s\21\3"+
		"\2\2\2tu\7\33\2\2uv\7\34\2\2v\23\3\2\2\2wx\b\13\1\2x{\5\20\t\2y{\79\2"+
		"\2zw\3\2\2\2zy\3\2\2\2{\u0084\3\2\2\2|~\f\3\2\2}\177\5\22\n\2~}\3\2\2"+
		"\2\177\u0080\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3"+
		"\2\2\2\u0082|\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085"+
		"\3\2\2\2\u0085\25\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u008b\7!\2\2\u0088"+
		"\u008a\5\"\22\2\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3"+
		"\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e"+
		"\u008f\7\"\2\2\u008f\27\3\2\2\2\u0090\u0091\5\24\13\2\u0091\u0094\79\2"+
		"\2\u0092\u0093\7\27\2\2\u0093\u0095\5\66\34\2\u0094\u0092\3\2\2\2\u0094"+
		"\u0095\3\2\2\2\u0095\u009e\3\2\2\2\u0096\u0097\7 \2\2\u0097\u009a\79\2"+
		"\2\u0098\u0099\7\27\2\2\u0099\u009b\5\66\34\2\u009a\u0098\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u0096\3\2\2\2\u009d\u00a0\3\2"+
		"\2\2\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0"+
		"\u009e\3\2\2\2\u00a1\u00a2\7\37\2\2\u00a2\31\3\2\2\2\u00a3\u00a4\7+\2"+
		"\2\u00a4\u00a5\7\35\2\2\u00a5\u00a6\5\66\34\2\u00a6\u00a7\7\36\2\2\u00a7"+
		"\u00a8\5\26\f\2\u00a8\33\3\2\2\2\u00a9\u00aa\7.\2\2\u00aa\u00ab\7\35\2"+
		"\2\u00ab\u00ac\5\66\34\2\u00ac\u00ad\7\36\2\2\u00ad\u00ae\5\26\f\2\u00ae"+
		"\35\3\2\2\2\u00af\u00b0\7-\2\2\u00b0\u00b2\7\35\2\2\u00b1\u00b3\5\66\34"+
		"\2\u00b2\u00b1\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6"+
		"\7\37\2\2\u00b5\u00b7\5\66\34\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2"+
		"\2\u00b7\u00b8\3\2\2\2\u00b8\u00b9\7\37\2\2\u00b9\u00ba\7\36\2\2\u00ba"+
		"\u00bb\5\26\f\2\u00bb\37\3\2\2\2\u00bc\u00be\7\61\2\2\u00bd\u00bf\5\66"+
		"\34\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00c1\7\37\2\2\u00c1!\3\2\2\2\u00c2\u00ce\5\32\16\2\u00c3\u00ce\5\34"+
		"\17\2\u00c4\u00ce\5\36\20\2\u00c5\u00ce\5 \21\2\u00c6\u00ce\7/\2\2\u00c7"+
		"\u00ce\7\60\2\2\u00c8\u00ce\5\30\r\2\u00c9\u00ca\5\66\34\2\u00ca\u00cb"+
		"\7\37\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ce\7\37\2\2\u00cd\u00c2\3\2\2\2"+
		"\u00cd\u00c3\3\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00c6"+
		"\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd\u00c8\3\2\2\2\u00cd\u00c9\3\2\2\2\u00cd"+
		"\u00cc\3\2\2\2\u00ce#\3\2\2\2\u00cf\u00d0\79\2\2\u00d0\u00d1\7\35\2\2"+
		"\u00d1\u00d6\5\66\34\2\u00d2\u00d3\7 \2\2\u00d3\u00d5\5\66\34\2\u00d4"+
		"\u00d2\3\2\2\2\u00d5\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2"+
		"\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d9\u00da\7\36\2\2\u00da"+
		"%\3\2\2\2\u00db\u00dc\7\62\2\2\u00dc\u00df\5\24\13\2\u00dd\u00de\7\35"+
		"\2\2\u00de\u00e0\7\36\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\'\3\2\2\2\u00e1\u00e2\t\3\2\2\u00e2)\3\2\2\2\u00e3\u00e4\t\4\2\2\u00e4"+
		"+\3\2\2\2\u00e5\u00e6\t\5\2\2\u00e6-\3\2\2\2\u00e7\u00e8\t\6\2\2\u00e8"+
		"/\3\2\2\2\u00e9\u00ea\t\7\2\2\u00ea\61\3\2\2\2\u00eb\u00ec\t\b\2\2\u00ec"+
		"\63\3\2\2\2\u00ed\u00ee\t\t\2\2\u00ee\65\3\2\2\2\u00ef\u00f0\b\34\1\2"+
		"\u00f0\u00fb\58\35\2\u00f1\u00f2\7\35\2\2\u00f2\u00f3\5\66\34\2\u00f3"+
		"\u00f4\7\36\2\2\u00f4\u00fb\3\2\2\2\u00f5\u00fb\5$\23\2\u00f6\u00f7\5"+
		"*\26\2\u00f7\u00f8\5\66\34\17\u00f8\u00fb\3\2\2\2\u00f9\u00fb\5&\24\2"+
		"\u00fa\u00ef\3\2\2\2\u00fa\u00f1\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f6"+
		"\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb\u012e\3\2\2\2\u00fc\u00fd\f\r\2\2\u00fd"+
		"\u00fe\5,\27\2\u00fe\u00ff\5\66\34\16\u00ff\u012d\3\2\2\2\u0100\u0101"+
		"\f\f\2\2\u0101\u0102\5.\30\2\u0102\u0103\5\66\34\r\u0103\u012d\3\2\2\2"+
		"\u0104\u0105\f\13\2\2\u0105\u0106\5\60\31\2\u0106\u0107\5\66\34\f\u0107"+
		"\u012d\3\2\2\2\u0108\u0109\f\n\2\2\u0109\u010a\5\62\32\2\u010a\u010b\5"+
		"\66\34\13\u010b\u012d\3\2\2\2\u010c\u010d\f\t\2\2\u010d\u010e\5\64\33"+
		"\2\u010e\u010f\5\66\34\n\u010f\u012d\3\2\2\2\u0110\u0111\f\b\2\2\u0111"+
		"\u0112\7\23\2\2\u0112\u012d\5\66\34\t\u0113\u0114\f\7\2\2\u0114\u0115"+
		"\7\25\2\2\u0115\u012d\5\66\34\b\u0116\u0117\f\6\2\2\u0117\u0118\7\24\2"+
		"\2\u0118\u012d\5\66\34\7\u0119\u011a\f\5\2\2\u011a\u011b\7\16\2\2\u011b"+
		"\u012d\5\66\34\6\u011c\u011d\f\4\2\2\u011d\u011e\7\17\2\2\u011e\u012d"+
		"\5\66\34\5\u011f\u0120\f\3\2\2\u0120\u0121\7\27\2\2\u0121\u012d\5\66\34"+
		"\4\u0122\u0123\f\23\2\2\u0123\u0124\7\33\2\2\u0124\u0125\5\66\34\2\u0125"+
		"\u0126\7\34\2\2\u0126\u012d\3\2\2\2\u0127\u0128\f\22\2\2\u0128\u0129\7"+
		"\32\2\2\u0129\u012d\79\2\2\u012a\u012b\f\20\2\2\u012b\u012d\5(\25\2\u012c"+
		"\u00fc\3\2\2\2\u012c\u0100\3\2\2\2\u012c\u0104\3\2\2\2\u012c\u0108\3\2"+
		"\2\2\u012c\u010c\3\2\2\2\u012c\u0110\3\2\2\2\u012c\u0113\3\2\2\2\u012c"+
		"\u0116\3\2\2\2\u012c\u0119\3\2\2\2\u012c\u011c\3\2\2\2\u012c\u011f\3\2"+
		"\2\2\u012c\u0122\3\2\2\2\u012c\u0127\3\2\2\2\u012c\u012a\3\2\2\2\u012d"+
		"\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f\67\3\2\2"+
		"\2\u0130\u012e\3\2\2\2\u0131\u0139\79\2\2\u0132\u0139\7:\2\2\u0133\u0139"+
		"\7?\2\2\u0134\u0139\7*\2\2\u0135\u0139\7)\2\2\u0136\u0139\7(\2\2\u0137"+
		"\u0139\7\64\2\2\u0138\u0131\3\2\2\2\u0138\u0132\3\2\2\2\u0138\u0133\3"+
		"\2\2\2\u0138\u0134\3\2\2\2\u0138\u0135\3\2\2\2\u0138\u0136\3\2\2\2\u0138"+
		"\u0137\3\2\2\2\u01399\3\2\2\2\32=?KM]kpz\u0080\u0084\u008b\u0094\u009a"+
		"\u009e\u00b2\u00b6\u00be\u00cd\u00d6\u00df\u00fa\u012c\u012e\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}