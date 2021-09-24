// Generated from src/masterball/compiler/frontend/parser/MxStar.g4 by ANTLR 4.7.2

    package masterball.compiler.frontend.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AddOp", "SubOp", "MulOp", "DivOp", "ModOp", "GreaterOp", "LessOp", "GreaterEqualOp", 
			"LessEqualOp", "NotEqualOp", "EqualOp", "LogicAndOp", "LogicOrOp", "LogicNotOp", 
			"ArithShiftLeftOp", "ArithShiftRightOp", "BitAndOp", "BitOrOp", "BitXorOp", 
			"BitNotOp", "AssignOp", "IncrementOp", "DecrementOp", "MemberOp", "LeftBracket", 
			"RightBracket", "LeftParen", "RightParen", "SemiColon", "Comma", "LeftBrace", 
			"RightBrace", "QuoteOp", "LambdaStartSymbol", "LambdaArrowSymbol", "IntType", 
			"BoolType", "StringType", "VoidType", "NullConstant", "TrueConstant", 
			"FalseConstant", "IfKw", "ElseKw", "ForKw", "WhileKw", "BreakKw", "ContinueKw", 
			"ReturnKw", "NewKw", "ClassKw", "ThisPointer", "WhitespaceEater", "NewlineEater", 
			"LineCommentEater", "BlockCommentEater", "Identifier", "IntegerConstant", 
			"EscapeEnter", "EscapeBackslash", "EscapeQuote", "StringContent", "StringConstant"
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


	public MxStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u0181\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'"+
		"\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3"+
		"\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\66\6\66\u0132\n\66\r\66"+
		"\16\66\u0133\3\66\3\66\3\67\3\67\5\67\u013a\n\67\3\67\5\67\u013d\n\67"+
		"\3\67\3\67\38\38\38\38\78\u0145\n8\f8\168\u0148\138\38\38\39\39\39\39"+
		"\79\u0150\n9\f9\169\u0153\139\39\39\39\39\39\3:\3:\7:\u015c\n:\f:\16:"+
		"\u015f\13:\3;\3;\3;\7;\u0164\n;\f;\16;\u0167\13;\5;\u0169\n;\3<\3<\3<"+
		"\3=\3=\3=\3>\3>\3>\3?\3?\3@\3@\3@\3@\3@\7@\u017b\n@\f@\16@\u017e\13@\3"+
		"@\3@\3\u0151\2A\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64"+
		"g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\3\2\t\4\2\13\13\"\"\4\2\f\f\17\17"+
		"\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\3\2\"\u0080\2\u018c\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2"+
		"\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2"+
		"W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2"+
		"\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2"+
		"}\3\2\2\2\2\177\3\2\2\2\3\u0081\3\2\2\2\5\u0083\3\2\2\2\7\u0085\3\2\2"+
		"\2\t\u0087\3\2\2\2\13\u0089\3\2\2\2\r\u008b\3\2\2\2\17\u008d\3\2\2\2\21"+
		"\u008f\3\2\2\2\23\u0092\3\2\2\2\25\u0095\3\2\2\2\27\u0098\3\2\2\2\31\u009b"+
		"\3\2\2\2\33\u009e\3\2\2\2\35\u00a1\3\2\2\2\37\u00a3\3\2\2\2!\u00a6\3\2"+
		"\2\2#\u00a9\3\2\2\2%\u00ab\3\2\2\2\'\u00ad\3\2\2\2)\u00af\3\2\2\2+\u00b1"+
		"\3\2\2\2-\u00b3\3\2\2\2/\u00b6\3\2\2\2\61\u00b9\3\2\2\2\63\u00bb\3\2\2"+
		"\2\65\u00bd\3\2\2\2\67\u00bf\3\2\2\29\u00c1\3\2\2\2;\u00c3\3\2\2\2=\u00c5"+
		"\3\2\2\2?\u00c7\3\2\2\2A\u00c9\3\2\2\2C\u00cb\3\2\2\2E\u00cd\3\2\2\2G"+
		"\u00d1\3\2\2\2I\u00d4\3\2\2\2K\u00d8\3\2\2\2M\u00dd\3\2\2\2O\u00e4\3\2"+
		"\2\2Q\u00e9\3\2\2\2S\u00ee\3\2\2\2U\u00f3\3\2\2\2W\u00f9\3\2\2\2Y\u00fc"+
		"\3\2\2\2[\u0101\3\2\2\2]\u0105\3\2\2\2_\u010b\3\2\2\2a\u0111\3\2\2\2c"+
		"\u011a\3\2\2\2e\u0121\3\2\2\2g\u0125\3\2\2\2i\u012b\3\2\2\2k\u0131\3\2"+
		"\2\2m\u013c\3\2\2\2o\u0140\3\2\2\2q\u014b\3\2\2\2s\u0159\3\2\2\2u\u0168"+
		"\3\2\2\2w\u016a\3\2\2\2y\u016d\3\2\2\2{\u0170\3\2\2\2}\u0173\3\2\2\2\177"+
		"\u0175\3\2\2\2\u0081\u0082\7-\2\2\u0082\4\3\2\2\2\u0083\u0084\7/\2\2\u0084"+
		"\6\3\2\2\2\u0085\u0086\7,\2\2\u0086\b\3\2\2\2\u0087\u0088\7\61\2\2\u0088"+
		"\n\3\2\2\2\u0089\u008a\7\'\2\2\u008a\f\3\2\2\2\u008b\u008c\7@\2\2\u008c"+
		"\16\3\2\2\2\u008d\u008e\7>\2\2\u008e\20\3\2\2\2\u008f\u0090\7@\2\2\u0090"+
		"\u0091\7?\2\2\u0091\22\3\2\2\2\u0092\u0093\7>\2\2\u0093\u0094\7?\2\2\u0094"+
		"\24\3\2\2\2\u0095\u0096\7#\2\2\u0096\u0097\7?\2\2\u0097\26\3\2\2\2\u0098"+
		"\u0099\7?\2\2\u0099\u009a\7?\2\2\u009a\30\3\2\2\2\u009b\u009c\7(\2\2\u009c"+
		"\u009d\7(\2\2\u009d\32\3\2\2\2\u009e\u009f\7~\2\2\u009f\u00a0\7~\2\2\u00a0"+
		"\34\3\2\2\2\u00a1\u00a2\7#\2\2\u00a2\36\3\2\2\2\u00a3\u00a4\7>\2\2\u00a4"+
		"\u00a5\7>\2\2\u00a5 \3\2\2\2\u00a6\u00a7\7@\2\2\u00a7\u00a8\7@\2\2\u00a8"+
		"\"\3\2\2\2\u00a9\u00aa\7(\2\2\u00aa$\3\2\2\2\u00ab\u00ac\7~\2\2\u00ac"+
		"&\3\2\2\2\u00ad\u00ae\7`\2\2\u00ae(\3\2\2\2\u00af\u00b0\7\u0080\2\2\u00b0"+
		"*\3\2\2\2\u00b1\u00b2\7?\2\2\u00b2,\3\2\2\2\u00b3\u00b4\7-\2\2\u00b4\u00b5"+
		"\7-\2\2\u00b5.\3\2\2\2\u00b6\u00b7\7/\2\2\u00b7\u00b8\7/\2\2\u00b8\60"+
		"\3\2\2\2\u00b9\u00ba\7\60\2\2\u00ba\62\3\2\2\2\u00bb\u00bc\7]\2\2\u00bc"+
		"\64\3\2\2\2\u00bd\u00be\7_\2\2\u00be\66\3\2\2\2\u00bf\u00c0\7*\2\2\u00c0"+
		"8\3\2\2\2\u00c1\u00c2\7+\2\2\u00c2:\3\2\2\2\u00c3\u00c4\7=\2\2\u00c4<"+
		"\3\2\2\2\u00c5\u00c6\7.\2\2\u00c6>\3\2\2\2\u00c7\u00c8\7}\2\2\u00c8@\3"+
		"\2\2\2\u00c9\u00ca\7\177\2\2\u00caB\3\2\2\2\u00cb\u00cc\7$\2\2\u00ccD"+
		"\3\2\2\2\u00cd\u00ce\7]\2\2\u00ce\u00cf\7(\2\2\u00cf\u00d0\7_\2\2\u00d0"+
		"F\3\2\2\2\u00d1\u00d2\7/\2\2\u00d2\u00d3\7@\2\2\u00d3H\3\2\2\2\u00d4\u00d5"+
		"\7k\2\2\u00d5\u00d6\7p\2\2\u00d6\u00d7\7v\2\2\u00d7J\3\2\2\2\u00d8\u00d9"+
		"\7d\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7n\2\2\u00dc"+
		"L\3\2\2\2\u00dd\u00de\7u\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7t\2\2\u00e0"+
		"\u00e1\7k\2\2\u00e1\u00e2\7p\2\2\u00e2\u00e3\7i\2\2\u00e3N\3\2\2\2\u00e4"+
		"\u00e5\7x\2\2\u00e5\u00e6\7q\2\2\u00e6\u00e7\7k\2\2\u00e7\u00e8\7f\2\2"+
		"\u00e8P\3\2\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7w\2\2\u00eb\u00ec\7n\2"+
		"\2\u00ec\u00ed\7n\2\2\u00edR\3\2\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7"+
		"t\2\2\u00f0\u00f1\7w\2\2\u00f1\u00f2\7g\2\2\u00f2T\3\2\2\2\u00f3\u00f4"+
		"\7h\2\2\u00f4\u00f5\7c\2\2\u00f5\u00f6\7n\2\2\u00f6\u00f7\7u\2\2\u00f7"+
		"\u00f8\7g\2\2\u00f8V\3\2\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7h\2\2\u00fb"+
		"X\3\2\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7u\2\2\u00ff"+
		"\u0100\7g\2\2\u0100Z\3\2\2\2\u0101\u0102\7h\2\2\u0102\u0103\7q\2\2\u0103"+
		"\u0104\7t\2\2\u0104\\\3\2\2\2\u0105\u0106\7y\2\2\u0106\u0107\7j\2\2\u0107"+
		"\u0108\7k\2\2\u0108\u0109\7n\2\2\u0109\u010a\7g\2\2\u010a^\3\2\2\2\u010b"+
		"\u010c\7d\2\2\u010c\u010d\7t\2\2\u010d\u010e\7g\2\2\u010e\u010f\7c\2\2"+
		"\u010f\u0110\7m\2\2\u0110`\3\2\2\2\u0111\u0112\7e\2\2\u0112\u0113\7q\2"+
		"\2\u0113\u0114\7p\2\2\u0114\u0115\7v\2\2\u0115\u0116\7k\2\2\u0116\u0117"+
		"\7p\2\2\u0117\u0118\7w\2\2\u0118\u0119\7g\2\2\u0119b\3\2\2\2\u011a\u011b"+
		"\7t\2\2\u011b\u011c\7g\2\2\u011c\u011d\7v\2\2\u011d\u011e\7w\2\2\u011e"+
		"\u011f\7t\2\2\u011f\u0120\7p\2\2\u0120d\3\2\2\2\u0121\u0122\7p\2\2\u0122"+
		"\u0123\7g\2\2\u0123\u0124\7y\2\2\u0124f\3\2\2\2\u0125\u0126\7e\2\2\u0126"+
		"\u0127\7n\2\2\u0127\u0128\7c\2\2\u0128\u0129\7u\2\2\u0129\u012a\7u\2\2"+
		"\u012ah\3\2\2\2\u012b\u012c\7v\2\2\u012c\u012d\7j\2\2\u012d\u012e\7k\2"+
		"\2\u012e\u012f\7u\2\2\u012fj\3\2\2\2\u0130\u0132\t\2\2\2\u0131\u0130\3"+
		"\2\2\2\u0132\u0133\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0135\3\2\2\2\u0135\u0136\b\66\2\2\u0136l\3\2\2\2\u0137\u0139\7\17\2"+
		"\2\u0138\u013a\7\f\2\2\u0139\u0138\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013d"+
		"\3\2\2\2\u013b\u013d\7\f\2\2\u013c\u0137\3\2\2\2\u013c\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u013f\b\67\2\2\u013fn\3\2\2\2\u0140\u0141\7\61\2"+
		"\2\u0141\u0142\7\61\2\2\u0142\u0146\3\2\2\2\u0143\u0145\n\3\2\2\u0144"+
		"\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2"+
		"\2\2\u0147\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149\u014a\b8\2\2\u014a"+
		"p\3\2\2\2\u014b\u014c\7\61\2\2\u014c\u014d\7,\2\2\u014d\u0151\3\2\2\2"+
		"\u014e\u0150\13\2\2\2\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154"+
		"\u0155\7,\2\2\u0155\u0156\7\61\2\2\u0156\u0157\3\2\2\2\u0157\u0158\b9"+
		"\2\2\u0158r\3\2\2\2\u0159\u015d\t\4\2\2\u015a\u015c\t\5\2\2\u015b\u015a"+
		"\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		"t\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0169\7\62\2\2\u0161\u0165\t\6\2\2"+
		"\u0162\u0164\t\7\2\2\u0163\u0162\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0168"+
		"\u0160\3\2\2\2\u0168\u0161\3\2\2\2\u0169v\3\2\2\2\u016a\u016b\7^\2\2\u016b"+
		"\u016c\7p\2\2\u016cx\3\2\2\2\u016d\u016e\7^\2\2\u016e\u016f\7^\2\2\u016f"+
		"z\3\2\2\2\u0170\u0171\7^\2\2\u0171\u0172\7$\2\2\u0172|\3\2\2\2\u0173\u0174"+
		"\t\b\2\2\u0174~\3\2\2\2\u0175\u017c\5C\"\2\u0176\u017b\5w<\2\u0177\u017b"+
		"\5y=\2\u0178\u017b\5{>\2\u0179\u017b\5}?\2\u017a\u0176\3\2\2\2\u017a\u0177"+
		"\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b\u017e\3\2\2\2\u017c"+
		"\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e\u017c\3\2"+
		"\2\2\u017f\u0180\5C\"\2\u0180\u0080\3\2\2\2\r\2\u0133\u0139\u013c\u0146"+
		"\u0151\u015d\u0165\u0168\u017a\u017c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}