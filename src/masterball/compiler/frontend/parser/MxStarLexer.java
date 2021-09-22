// Generated from src/masterball/compiler/frontend/parser/MxStar.g4 by ANTLR 4.7.2
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
		SemiColon=29, Comma=30, LeftBrace=31, RightBrace=32, QuoteOp=33, IntType=34, 
		BoolType=35, StringType=36, VoidType=37, NullConstant=38, TrueConstant=39, 
		FalseConstant=40, IfKw=41, ElseKw=42, ForKw=43, WhileKw=44, BreakKw=45, 
		ContinueKw=46, ReturnKw=47, NewKw=48, ClassKw=49, ThisPointer=50, WhitespaceEater=51, 
		NewlineEater=52, LineCommentEater=53, BlockCommentEater=54, Identifier=55, 
		IntegerConstant=56, EscapeEnter=57, EscapeBackslash=58, EscapeQuote=59, 
		StringContent=60, StringConstant=61;
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
			"RightBrace", "QuoteOp", "IntType", "BoolType", "StringType", "VoidType", 
			"NullConstant", "TrueConstant", "FalseConstant", "IfKw", "ElseKw", "ForKw", 
			"WhileKw", "BreakKw", "ContinueKw", "ReturnKw", "NewKw", "ClassKw", "ThisPointer", 
			"WhitespaceEater", "NewlineEater", "LineCommentEater", "BlockCommentEater", 
			"Identifier", "IntegerConstant", "EscapeEnter", "EscapeBackslash", "EscapeQuote", 
			"StringContent", "StringConstant"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u0176\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3"+
		"+\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3"+
		"/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\62\3"+
		"\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\6\64\u0127\n\64"+
		"\r\64\16\64\u0128\3\64\3\64\3\65\3\65\5\65\u012f\n\65\3\65\5\65\u0132"+
		"\n\65\3\65\3\65\3\66\3\66\3\66\3\66\7\66\u013a\n\66\f\66\16\66\u013d\13"+
		"\66\3\66\3\66\3\67\3\67\3\67\3\67\7\67\u0145\n\67\f\67\16\67\u0148\13"+
		"\67\3\67\3\67\3\67\3\67\3\67\38\38\78\u0151\n8\f8\168\u0154\138\39\39"+
		"\39\79\u0159\n9\f9\169\u015c\139\59\u015e\n9\3:\3:\3:\3;\3;\3;\3<\3<\3"+
		"<\3=\3=\3>\3>\3>\3>\3>\7>\u0170\n>\f>\16>\u0173\13>\3>\3>\3\u0146\2?\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9"+
		"q:s;u<w=y>{?\3\2\t\4\2\13\13\"\"\4\2\f\f\17\17\4\2C\\c|\6\2\62;C\\aac"+
		"|\3\2\63;\3\2\62;\3\2\"\u0080\2\u0181\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2"+
		"\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\3}\3\2\2\2\5\177\3\2\2"+
		"\2\7\u0081\3\2\2\2\t\u0083\3\2\2\2\13\u0085\3\2\2\2\r\u0087\3\2\2\2\17"+
		"\u0089\3\2\2\2\21\u008b\3\2\2\2\23\u008e\3\2\2\2\25\u0091\3\2\2\2\27\u0094"+
		"\3\2\2\2\31\u0097\3\2\2\2\33\u009a\3\2\2\2\35\u009d\3\2\2\2\37\u009f\3"+
		"\2\2\2!\u00a2\3\2\2\2#\u00a5\3\2\2\2%\u00a7\3\2\2\2\'\u00a9\3\2\2\2)\u00ab"+
		"\3\2\2\2+\u00ad\3\2\2\2-\u00af\3\2\2\2/\u00b2\3\2\2\2\61\u00b5\3\2\2\2"+
		"\63\u00b7\3\2\2\2\65\u00b9\3\2\2\2\67\u00bb\3\2\2\29\u00bd\3\2\2\2;\u00bf"+
		"\3\2\2\2=\u00c1\3\2\2\2?\u00c3\3\2\2\2A\u00c5\3\2\2\2C\u00c7\3\2\2\2E"+
		"\u00c9\3\2\2\2G\u00cd\3\2\2\2I\u00d2\3\2\2\2K\u00d9\3\2\2\2M\u00de\3\2"+
		"\2\2O\u00e3\3\2\2\2Q\u00e8\3\2\2\2S\u00ee\3\2\2\2U\u00f1\3\2\2\2W\u00f6"+
		"\3\2\2\2Y\u00fa\3\2\2\2[\u0100\3\2\2\2]\u0106\3\2\2\2_\u010f\3\2\2\2a"+
		"\u0116\3\2\2\2c\u011a\3\2\2\2e\u0120\3\2\2\2g\u0126\3\2\2\2i\u0131\3\2"+
		"\2\2k\u0135\3\2\2\2m\u0140\3\2\2\2o\u014e\3\2\2\2q\u015d\3\2\2\2s\u015f"+
		"\3\2\2\2u\u0162\3\2\2\2w\u0165\3\2\2\2y\u0168\3\2\2\2{\u016a\3\2\2\2}"+
		"~\7-\2\2~\4\3\2\2\2\177\u0080\7/\2\2\u0080\6\3\2\2\2\u0081\u0082\7,\2"+
		"\2\u0082\b\3\2\2\2\u0083\u0084\7\61\2\2\u0084\n\3\2\2\2\u0085\u0086\7"+
		"\'\2\2\u0086\f\3\2\2\2\u0087\u0088\7@\2\2\u0088\16\3\2\2\2\u0089\u008a"+
		"\7>\2\2\u008a\20\3\2\2\2\u008b\u008c\7@\2\2\u008c\u008d\7?\2\2\u008d\22"+
		"\3\2\2\2\u008e\u008f\7>\2\2\u008f\u0090\7?\2\2\u0090\24\3\2\2\2\u0091"+
		"\u0092\7#\2\2\u0092\u0093\7?\2\2\u0093\26\3\2\2\2\u0094\u0095\7?\2\2\u0095"+
		"\u0096\7?\2\2\u0096\30\3\2\2\2\u0097\u0098\7(\2\2\u0098\u0099\7(\2\2\u0099"+
		"\32\3\2\2\2\u009a\u009b\7~\2\2\u009b\u009c\7~\2\2\u009c\34\3\2\2\2\u009d"+
		"\u009e\7#\2\2\u009e\36\3\2\2\2\u009f\u00a0\7>\2\2\u00a0\u00a1\7>\2\2\u00a1"+
		" \3\2\2\2\u00a2\u00a3\7@\2\2\u00a3\u00a4\7@\2\2\u00a4\"\3\2\2\2\u00a5"+
		"\u00a6\7(\2\2\u00a6$\3\2\2\2\u00a7\u00a8\7~\2\2\u00a8&\3\2\2\2\u00a9\u00aa"+
		"\7`\2\2\u00aa(\3\2\2\2\u00ab\u00ac\7\u0080\2\2\u00ac*\3\2\2\2\u00ad\u00ae"+
		"\7?\2\2\u00ae,\3\2\2\2\u00af\u00b0\7-\2\2\u00b0\u00b1\7-\2\2\u00b1.\3"+
		"\2\2\2\u00b2\u00b3\7/\2\2\u00b3\u00b4\7/\2\2\u00b4\60\3\2\2\2\u00b5\u00b6"+
		"\7\60\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7]\2\2\u00b8\64\3\2\2\2\u00b9\u00ba"+
		"\7_\2\2\u00ba\66\3\2\2\2\u00bb\u00bc\7*\2\2\u00bc8\3\2\2\2\u00bd\u00be"+
		"\7+\2\2\u00be:\3\2\2\2\u00bf\u00c0\7=\2\2\u00c0<\3\2\2\2\u00c1\u00c2\7"+
		".\2\2\u00c2>\3\2\2\2\u00c3\u00c4\7}\2\2\u00c4@\3\2\2\2\u00c5\u00c6\7\177"+
		"\2\2\u00c6B\3\2\2\2\u00c7\u00c8\7$\2\2\u00c8D\3\2\2\2\u00c9\u00ca\7k\2"+
		"\2\u00ca\u00cb\7p\2\2\u00cb\u00cc\7v\2\2\u00ccF\3\2\2\2\u00cd\u00ce\7"+
		"d\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7n\2\2\u00d1H"+
		"\3\2\2\2\u00d2\u00d3\7u\2\2\u00d3\u00d4\7v\2\2\u00d4\u00d5\7t\2\2\u00d5"+
		"\u00d6\7k\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7i\2\2\u00d8J\3\2\2\2\u00d9"+
		"\u00da\7x\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7k\2\2\u00dc\u00dd\7f\2\2"+
		"\u00ddL\3\2\2\2\u00de\u00df\7p\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1\7n\2"+
		"\2\u00e1\u00e2\7n\2\2\u00e2N\3\2\2\2\u00e3\u00e4\7v\2\2\u00e4\u00e5\7"+
		"t\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7\7g\2\2\u00e7P\3\2\2\2\u00e8\u00e9"+
		"\7h\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7u\2\2\u00ec"+
		"\u00ed\7g\2\2\u00edR\3\2\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7h\2\2\u00f0"+
		"T\3\2\2\2\u00f1\u00f2\7g\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7u\2\2\u00f4"+
		"\u00f5\7g\2\2\u00f5V\3\2\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7q\2\2\u00f8"+
		"\u00f9\7t\2\2\u00f9X\3\2\2\2\u00fa\u00fb\7y\2\2\u00fb\u00fc\7j\2\2\u00fc"+
		"\u00fd\7k\2\2\u00fd\u00fe\7n\2\2\u00fe\u00ff\7g\2\2\u00ffZ\3\2\2\2\u0100"+
		"\u0101\7d\2\2\u0101\u0102\7t\2\2\u0102\u0103\7g\2\2\u0103\u0104\7c\2\2"+
		"\u0104\u0105\7m\2\2\u0105\\\3\2\2\2\u0106\u0107\7e\2\2\u0107\u0108\7q"+
		"\2\2\u0108\u0109\7p\2\2\u0109\u010a\7v\2\2\u010a\u010b\7k\2\2\u010b\u010c"+
		"\7p\2\2\u010c\u010d\7w\2\2\u010d\u010e\7g\2\2\u010e^\3\2\2\2\u010f\u0110"+
		"\7t\2\2\u0110\u0111\7g\2\2\u0111\u0112\7v\2\2\u0112\u0113\7w\2\2\u0113"+
		"\u0114\7t\2\2\u0114\u0115\7p\2\2\u0115`\3\2\2\2\u0116\u0117\7p\2\2\u0117"+
		"\u0118\7g\2\2\u0118\u0119\7y\2\2\u0119b\3\2\2\2\u011a\u011b\7e\2\2\u011b"+
		"\u011c\7n\2\2\u011c\u011d\7c\2\2\u011d\u011e\7u\2\2\u011e\u011f\7u\2\2"+
		"\u011fd\3\2\2\2\u0120\u0121\7v\2\2\u0121\u0122\7j\2\2\u0122\u0123\7k\2"+
		"\2\u0123\u0124\7u\2\2\u0124f\3\2\2\2\u0125\u0127\t\2\2\2\u0126\u0125\3"+
		"\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012b\b\64\2\2\u012bh\3\2\2\2\u012c\u012e\7\17\2"+
		"\2\u012d\u012f\7\f\2\2\u012e\u012d\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132"+
		"\3\2\2\2\u0130\u0132\7\f\2\2\u0131\u012c\3\2\2\2\u0131\u0130\3\2\2\2\u0132"+
		"\u0133\3\2\2\2\u0133\u0134\b\65\2\2\u0134j\3\2\2\2\u0135\u0136\7\61\2"+
		"\2\u0136\u0137\7\61\2\2\u0137\u013b\3\2\2\2\u0138\u013a\n\3\2\2\u0139"+
		"\u0138\3\2\2\2\u013a\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2"+
		"\2\2\u013c\u013e\3\2\2\2\u013d\u013b\3\2\2\2\u013e\u013f\b\66\2\2\u013f"+
		"l\3\2\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7,\2\2\u0142\u0146\3\2\2\2"+
		"\u0143\u0145\13\2\2\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0147"+
		"\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0149\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014a\7,\2\2\u014a\u014b\7\61\2\2\u014b\u014c\3\2\2\2\u014c\u014d\b\67"+
		"\2\2\u014dn\3\2\2\2\u014e\u0152\t\4\2\2\u014f\u0151\t\5\2\2\u0150\u014f"+
		"\3\2\2\2\u0151\u0154\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"p\3\2\2\2\u0154\u0152\3\2\2\2\u0155\u015e\7\62\2\2\u0156\u015a\t\6\2\2"+
		"\u0157\u0159\t\7\2\2\u0158\u0157\3\2\2\2\u0159\u015c\3\2\2\2\u015a\u0158"+
		"\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015d"+
		"\u0155\3\2\2\2\u015d\u0156\3\2\2\2\u015er\3\2\2\2\u015f\u0160\7^\2\2\u0160"+
		"\u0161\7p\2\2\u0161t\3\2\2\2\u0162\u0163\7^\2\2\u0163\u0164\7^\2\2\u0164"+
		"v\3\2\2\2\u0165\u0166\7^\2\2\u0166\u0167\7$\2\2\u0167x\3\2\2\2\u0168\u0169"+
		"\t\b\2\2\u0169z\3\2\2\2\u016a\u0171\5C\"\2\u016b\u0170\5s:\2\u016c\u0170"+
		"\5u;\2\u016d\u0170\5w<\2\u016e\u0170\5y=\2\u016f\u016b\3\2\2\2\u016f\u016c"+
		"\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u016e\3\2\2\2\u0170\u0173\3\2\2\2\u0171"+
		"\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0174\3\2\2\2\u0173\u0171\3\2"+
		"\2\2\u0174\u0175\5C\"\2\u0175|\3\2\2\2\r\2\u0128\u012e\u0131\u013b\u0146"+
		"\u0152\u015a\u015d\u016f\u0171\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}