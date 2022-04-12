// Generated from ../src/darksword/interpreter/generated/LLVMIR.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LLVMIRLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, IntType=51, VoidType=52, 
		LabelType=53, GlobalReg=54, LocalReg=55, IntegerLiteral=56, Identifier=57, 
		WhitespaceEater=58, NewlineEater=59, LineCommentEater=60, EscapeEnter=61, 
		EscapeBackslash=62, EscapeQuote=63, StringLiteral=64, NullptrConstant=65, 
		BoolConstant=66, InfoStr=67;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "T__47", "T__48", 
			"T__49", "IntType", "VoidType", "LabelType", "GlobalReg", "LocalReg", 
			"IntegerLiteral", "Identifier", "WhitespaceEater", "NewlineEater", "LineCommentEater", 
			"EscapeEnter", "EscapeBackslash", "EscapeQuote", "StringLiteral", "NullptrConstant", 
			"BoolConstant", "InfoStr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'source_filename'", "'='", "'target'", "'datalayout'", "'triple'", 
			"'('", "','", "')'", "'declare'", "'define'", "'{'", "'}'", "':'", "'['", 
			"']'", "'alloca'", "'add'", "'sub'", "'mul'", "'sdiv'", "'srem'", "'shl'", 
			"'ashr'", "'and'", "'or'", "'xor'", "'bitcast'", "'to'", "'trunc'", "'zext'", 
			"'br'", "'call'", "'getelementptr'", "'icmp'", "'sgt'", "'sge'", "'slt'", 
			"'sle'", "'eq'", "'ne'", "'load'", "'store'", "'ret'", "'phi'", "'align'", 
			"'*'", "'x'", "'-'", "'c\"'", "'\\00\"'", null, "'void'", "'label'", 
			null, null, null, null, null, null, null, "'\\n'", "'\\\\'", "'\\\"'", 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "IntType", "VoidType", "LabelType", "GlobalReg", "LocalReg", 
			"IntegerLiteral", "Identifier", "WhitespaceEater", "NewlineEater", "LineCommentEater", 
			"EscapeEnter", "EscapeBackslash", "EscapeQuote", "StringLiteral", "NullptrConstant", 
			"BoolConstant", "InfoStr"
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


	public LLVMIRLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LLVMIR.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2E\u01d2\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3"+
		",\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3"+
		"\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\39\39\39\79"+
		"\u018a\n9\f9\169\u018d\139\59\u018f\n9\3:\6:\u0192\n:\r:\16:\u0193\3;"+
		"\6;\u0197\n;\r;\16;\u0198\3;\3;\3<\3<\5<\u019f\n<\3<\5<\u01a2\n<\3<\3"+
		"<\3=\3=\7=\u01a8\n=\f=\16=\u01ab\13=\3=\3=\3>\3>\3>\3?\3?\3?\3@\3@\3@"+
		"\3A\3A\3B\3B\3B\3B\3B\3C\3C\3C\3C\3C\3C\3C\3C\3C\5C\u01c8\nC\3D\3D\7D"+
		"\u01cc\nD\fD\16D\u01cf\13D\3D\3D\3\u01cd\2E\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177A\u0081"+
		"B\u0083C\u0085D\u0087E\3\2\b\3\2\63;\3\2\62;\7\2\60\60\62;C\\aac|\4\2"+
		"\13\13\"\"\4\2\f\f\17\17\3\2\"\u0080\2\u01da\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2"+
		"\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2"+
		"\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2"+
		"M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3"+
		"\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2"+
		"\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2"+
		"s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177"+
		"\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2"+
		"\2\3\u0089\3\2\2\2\5\u0099\3\2\2\2\7\u009b\3\2\2\2\t\u00a2\3\2\2\2\13"+
		"\u00ad\3\2\2\2\r\u00b4\3\2\2\2\17\u00b6\3\2\2\2\21\u00b8\3\2\2\2\23\u00ba"+
		"\3\2\2\2\25\u00c2\3\2\2\2\27\u00c9\3\2\2\2\31\u00cb\3\2\2\2\33\u00cd\3"+
		"\2\2\2\35\u00cf\3\2\2\2\37\u00d1\3\2\2\2!\u00d3\3\2\2\2#\u00da\3\2\2\2"+
		"%\u00de\3\2\2\2\'\u00e2\3\2\2\2)\u00e6\3\2\2\2+\u00eb\3\2\2\2-\u00f0\3"+
		"\2\2\2/\u00f4\3\2\2\2\61\u00f9\3\2\2\2\63\u00fd\3\2\2\2\65\u0100\3\2\2"+
		"\2\67\u0104\3\2\2\29\u010c\3\2\2\2;\u010f\3\2\2\2=\u0115\3\2\2\2?\u011a"+
		"\3\2\2\2A\u011d\3\2\2\2C\u0122\3\2\2\2E\u0130\3\2\2\2G\u0135\3\2\2\2I"+
		"\u0139\3\2\2\2K\u013d\3\2\2\2M\u0141\3\2\2\2O\u0145\3\2\2\2Q\u0148\3\2"+
		"\2\2S\u014b\3\2\2\2U\u0150\3\2\2\2W\u0156\3\2\2\2Y\u015a\3\2\2\2[\u015e"+
		"\3\2\2\2]\u0164\3\2\2\2_\u0166\3\2\2\2a\u0168\3\2\2\2c\u016a\3\2\2\2e"+
		"\u016d\3\2\2\2g\u0172\3\2\2\2i\u0175\3\2\2\2k\u017a\3\2\2\2m\u0180\3\2"+
		"\2\2o\u0183\3\2\2\2q\u018e\3\2\2\2s\u0191\3\2\2\2u\u0196\3\2\2\2w\u01a1"+
		"\3\2\2\2y\u01a5\3\2\2\2{\u01ae\3\2\2\2}\u01b1\3\2\2\2\177\u01b4\3\2\2"+
		"\2\u0081\u01b7\3\2\2\2\u0083\u01b9\3\2\2\2\u0085\u01c7\3\2\2\2\u0087\u01c9"+
		"\3\2\2\2\u0089\u008a\7u\2\2\u008a\u008b\7q\2\2\u008b\u008c\7w\2\2\u008c"+
		"\u008d\7t\2\2\u008d\u008e\7e\2\2\u008e\u008f\7g\2\2\u008f\u0090\7a\2\2"+
		"\u0090\u0091\7h\2\2\u0091\u0092\7k\2\2\u0092\u0093\7n\2\2\u0093\u0094"+
		"\7g\2\2\u0094\u0095\7p\2\2\u0095\u0096\7c\2\2\u0096\u0097\7o\2\2\u0097"+
		"\u0098\7g\2\2\u0098\4\3\2\2\2\u0099\u009a\7?\2\2\u009a\6\3\2\2\2\u009b"+
		"\u009c\7v\2\2\u009c\u009d\7c\2\2\u009d\u009e\7t\2\2\u009e\u009f\7i\2\2"+
		"\u009f\u00a0\7g\2\2\u00a0\u00a1\7v\2\2\u00a1\b\3\2\2\2\u00a2\u00a3\7f"+
		"\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7"+
		"\7n\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7{\2\2\u00a9\u00aa\7q\2\2\u00aa"+
		"\u00ab\7w\2\2\u00ab\u00ac\7v\2\2\u00ac\n\3\2\2\2\u00ad\u00ae\7v\2\2\u00ae"+
		"\u00af\7t\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7r\2\2\u00b1\u00b2\7n\2\2"+
		"\u00b2\u00b3\7g\2\2\u00b3\f\3\2\2\2\u00b4\u00b5\7*\2\2\u00b5\16\3\2\2"+
		"\2\u00b6\u00b7\7.\2\2\u00b7\20\3\2\2\2\u00b8\u00b9\7+\2\2\u00b9\22\3\2"+
		"\2\2\u00ba\u00bb\7f\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7e\2\2\u00bd\u00be"+
		"\7n\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0\7t\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\24\3\2\2\2\u00c2\u00c3\7f\2\2\u00c3\u00c4\7g\2\2\u00c4\u00c5\7h\2\2\u00c5"+
		"\u00c6\7k\2\2\u00c6\u00c7\7p\2\2\u00c7\u00c8\7g\2\2\u00c8\26\3\2\2\2\u00c9"+
		"\u00ca\7}\2\2\u00ca\30\3\2\2\2\u00cb\u00cc\7\177\2\2\u00cc\32\3\2\2\2"+
		"\u00cd\u00ce\7<\2\2\u00ce\34\3\2\2\2\u00cf\u00d0\7]\2\2\u00d0\36\3\2\2"+
		"\2\u00d1\u00d2\7_\2\2\u00d2 \3\2\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7"+
		"n\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7e\2\2\u00d8\u00d9"+
		"\7c\2\2\u00d9\"\3\2\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7f\2\2\u00dc\u00dd"+
		"\7f\2\2\u00dd$\3\2\2\2\u00de\u00df\7u\2\2\u00df\u00e0\7w\2\2\u00e0\u00e1"+
		"\7d\2\2\u00e1&\3\2\2\2\u00e2\u00e3\7o\2\2\u00e3\u00e4\7w\2\2\u00e4\u00e5"+
		"\7n\2\2\u00e5(\3\2\2\2\u00e6\u00e7\7u\2\2\u00e7\u00e8\7f\2\2\u00e8\u00e9"+
		"\7k\2\2\u00e9\u00ea\7x\2\2\u00ea*\3\2\2\2\u00eb\u00ec\7u\2\2\u00ec\u00ed"+
		"\7t\2\2\u00ed\u00ee\7g\2\2\u00ee\u00ef\7o\2\2\u00ef,\3\2\2\2\u00f0\u00f1"+
		"\7u\2\2\u00f1\u00f2\7j\2\2\u00f2\u00f3\7n\2\2\u00f3.\3\2\2\2\u00f4\u00f5"+
		"\7c\2\2\u00f5\u00f6\7u\2\2\u00f6\u00f7\7j\2\2\u00f7\u00f8\7t\2\2\u00f8"+
		"\60\3\2\2\2\u00f9\u00fa\7c\2\2\u00fa\u00fb\7p\2\2\u00fb\u00fc\7f\2\2\u00fc"+
		"\62\3\2\2\2\u00fd\u00fe\7q\2\2\u00fe\u00ff\7t\2\2\u00ff\64\3\2\2\2\u0100"+
		"\u0101\7z\2\2\u0101\u0102\7q\2\2\u0102\u0103\7t\2\2\u0103\66\3\2\2\2\u0104"+
		"\u0105\7d\2\2\u0105\u0106\7k\2\2\u0106\u0107\7v\2\2\u0107\u0108\7e\2\2"+
		"\u0108\u0109\7c\2\2\u0109\u010a\7u\2\2\u010a\u010b\7v\2\2\u010b8\3\2\2"+
		"\2\u010c\u010d\7v\2\2\u010d\u010e\7q\2\2\u010e:\3\2\2\2\u010f\u0110\7"+
		"v\2\2\u0110\u0111\7t\2\2\u0111\u0112\7w\2\2\u0112\u0113\7p\2\2\u0113\u0114"+
		"\7e\2\2\u0114<\3\2\2\2\u0115\u0116\7|\2\2\u0116\u0117\7g\2\2\u0117\u0118"+
		"\7z\2\2\u0118\u0119\7v\2\2\u0119>\3\2\2\2\u011a\u011b\7d\2\2\u011b\u011c"+
		"\7t\2\2\u011c@\3\2\2\2\u011d\u011e\7e\2\2\u011e\u011f\7c\2\2\u011f\u0120"+
		"\7n\2\2\u0120\u0121\7n\2\2\u0121B\3\2\2\2\u0122\u0123\7i\2\2\u0123\u0124"+
		"\7g\2\2\u0124\u0125\7v\2\2\u0125\u0126\7g\2\2\u0126\u0127\7n\2\2\u0127"+
		"\u0128\7g\2\2\u0128\u0129\7o\2\2\u0129\u012a\7g\2\2\u012a\u012b\7p\2\2"+
		"\u012b\u012c\7v\2\2\u012c\u012d\7r\2\2\u012d\u012e\7v\2\2\u012e\u012f"+
		"\7t\2\2\u012fD\3\2\2\2\u0130\u0131\7k\2\2\u0131\u0132\7e\2\2\u0132\u0133"+
		"\7o\2\2\u0133\u0134\7r\2\2\u0134F\3\2\2\2\u0135\u0136\7u\2\2\u0136\u0137"+
		"\7i\2\2\u0137\u0138\7v\2\2\u0138H\3\2\2\2\u0139\u013a\7u\2\2\u013a\u013b"+
		"\7i\2\2\u013b\u013c\7g\2\2\u013cJ\3\2\2\2\u013d\u013e\7u\2\2\u013e\u013f"+
		"\7n\2\2\u013f\u0140\7v\2\2\u0140L\3\2\2\2\u0141\u0142\7u\2\2\u0142\u0143"+
		"\7n\2\2\u0143\u0144\7g\2\2\u0144N\3\2\2\2\u0145\u0146\7g\2\2\u0146\u0147"+
		"\7s\2\2\u0147P\3\2\2\2\u0148\u0149\7p\2\2\u0149\u014a\7g\2\2\u014aR\3"+
		"\2\2\2\u014b\u014c\7n\2\2\u014c\u014d\7q\2\2\u014d\u014e\7c\2\2\u014e"+
		"\u014f\7f\2\2\u014fT\3\2\2\2\u0150\u0151\7u\2\2\u0151\u0152\7v\2\2\u0152"+
		"\u0153\7q\2\2\u0153\u0154\7t\2\2\u0154\u0155\7g\2\2\u0155V\3\2\2\2\u0156"+
		"\u0157\7t\2\2\u0157\u0158\7g\2\2\u0158\u0159\7v\2\2\u0159X\3\2\2\2\u015a"+
		"\u015b\7r\2\2\u015b\u015c\7j\2\2\u015c\u015d\7k\2\2\u015dZ\3\2\2\2\u015e"+
		"\u015f\7c\2\2\u015f\u0160\7n\2\2\u0160\u0161\7k\2\2\u0161\u0162\7i\2\2"+
		"\u0162\u0163\7p\2\2\u0163\\\3\2\2\2\u0164\u0165\7,\2\2\u0165^\3\2\2\2"+
		"\u0166\u0167\7z\2\2\u0167`\3\2\2\2\u0168\u0169\7/\2\2\u0169b\3\2\2\2\u016a"+
		"\u016b\7e\2\2\u016b\u016c\7$\2\2\u016cd\3\2\2\2\u016d\u016e\7^\2\2\u016e"+
		"\u016f\7\62\2\2\u016f\u0170\7\62\2\2\u0170\u0171\7$\2\2\u0171f\3\2\2\2"+
		"\u0172\u0173\7k\2\2\u0173\u0174\5q9\2\u0174h\3\2\2\2\u0175\u0176\7x\2"+
		"\2\u0176\u0177\7q\2\2\u0177\u0178\7k\2\2\u0178\u0179\7f\2\2\u0179j\3\2"+
		"\2\2\u017a\u017b\7n\2\2\u017b\u017c\7c\2\2\u017c\u017d\7d\2\2\u017d\u017e"+
		"\7g\2\2\u017e\u017f\7n\2\2\u017fl\3\2\2\2\u0180\u0181\7B\2\2\u0181\u0182"+
		"\5s:\2\u0182n\3\2\2\2\u0183\u0184\7\'\2\2\u0184\u0185\5s:\2\u0185p\3\2"+
		"\2\2\u0186\u018f\7\62\2\2\u0187\u018b\t\2\2\2\u0188\u018a\t\3\2\2\u0189"+
		"\u0188\3\2\2\2\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2"+
		"\2\2\u018c\u018f\3\2\2\2\u018d\u018b\3\2\2\2\u018e\u0186\3\2\2\2\u018e"+
		"\u0187\3\2\2\2\u018fr\3\2\2\2\u0190\u0192\t\4\2\2\u0191\u0190\3\2\2\2"+
		"\u0192\u0193\3\2\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194t\3"+
		"\2\2\2\u0195\u0197\t\5\2\2\u0196\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\b;"+
		"\2\2\u019bv\3\2\2\2\u019c\u019e\7\17\2\2\u019d\u019f\7\f\2\2\u019e\u019d"+
		"\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u01a2\7\f\2\2\u01a1"+
		"\u019c\3\2\2\2\u01a1\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3\u01a4\b<"+
		"\2\2\u01a4x\3\2\2\2\u01a5\u01a9\7=\2\2\u01a6\u01a8\n\6\2\2\u01a7\u01a6"+
		"\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa"+
		"\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ad\b=\2\2\u01adz\3\2\2\2\u01ae"+
		"\u01af\7^\2\2\u01af\u01b0\7p\2\2\u01b0|\3\2\2\2\u01b1\u01b2\7^\2\2\u01b2"+
		"\u01b3\7^\2\2\u01b3~\3\2\2\2\u01b4\u01b5\7^\2\2\u01b5\u01b6\7$\2\2\u01b6"+
		"\u0080\3\2\2\2\u01b7\u01b8\t\7\2\2\u01b8\u0082\3\2\2\2\u01b9\u01ba\7p"+
		"\2\2\u01ba\u01bb\7w\2\2\u01bb\u01bc\7n\2\2\u01bc\u01bd\7n\2\2\u01bd\u0084"+
		"\3\2\2\2\u01be\u01bf\7v\2\2\u01bf\u01c0\7t\2\2\u01c0\u01c1\7w\2\2\u01c1"+
		"\u01c8\7g\2\2\u01c2\u01c3\7h\2\2\u01c3\u01c4\7c\2\2\u01c4\u01c5\7n\2\2"+
		"\u01c5\u01c6\7u\2\2\u01c6\u01c8\7g\2\2\u01c7\u01be\3\2\2\2\u01c7\u01c2"+
		"\3\2\2\2\u01c8\u0086\3\2\2\2\u01c9\u01cd\7$\2\2\u01ca\u01cc\5\u0081A\2"+
		"\u01cb\u01ca\3\2\2\2\u01cc\u01cf\3\2\2\2\u01cd\u01ce\3\2\2\2\u01cd\u01cb"+
		"\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01cd\3\2\2\2\u01d0\u01d1\7$\2\2\u01d1"+
		"\u0088\3\2\2\2\f\2\u018b\u018e\u0193\u0198\u019e\u01a1\u01a9\u01c7\u01cd"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}