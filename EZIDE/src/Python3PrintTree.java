import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.TreeSet;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

public class Python3PrintTree
{

	public static void main(String[] args) throws IOException
	{
		ParserFacade parserFacade = new ParserFacade();
		AstPrinter astPrinter = new AstPrinter();
		astPrinter.print(parserFacade.parse(new File("simple2.py")));
	}
}

class ParserFacade
{

	private static String readFile(File file, Charset encoding) throws IOException
	{
		byte[] encoded = Files.readAllBytes(file.toPath());
		return new String(encoded, encoding);
	}

	public Python3Parser.File_inputContext parse(File file) throws IOException
	{
		String code = readFile(file, Charset.forName("UTF-8")) + "\n";
		Python3Lexer lexer = new Python3Lexer(new ANTLRInputStream(code));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		Python3Parser parser = new Python3Parser(tokens);

		return parser.file_input();
	}
}

class AstPrinter
{
	private TreeSet<String> classes = new TreeSet<>();
	private boolean ignoringWrappers = true;

	public void setIgnoringWrappers(boolean ignoringWrappers)
	{
		this.ignoringWrappers = ignoringWrappers;
	}

	public void print(RuleContext ctx)
	{
		explore(ctx, 0);
	}

	private void explore(RuleContext ctx, int indentation)
	{
		boolean toBeIgnored = ignoringWrappers && ctx.getChildCount() == 1
				&& ctx.getChild(0) instanceof ParserRuleContext;
		if (!toBeIgnored)
		{
			// indentation
			indent(indentation);

			writeStmts(ctx);
		}

		for (int i = 0; i < ctx.getChildCount(); i++)
		{
			ParseTree element = ctx.getChild(i);
			if (element instanceof RuleContext)
				explore((RuleContext) element, indentation + (toBeIgnored ? 0 : 1));
		}
	}

	private void indent(int indentation)
	{
		for (int i = 0; i < indentation; i++)
			System.out.print("| ");
	}

	private void writeStmts(RuleContext ctx)
	{
		String text = ctx.getText().trim();
		int rule = ctx.getRuleIndex();
		String interval = "" + ctx.getSourceInterval();

		System.out.print(interval + " " + Python3Parser.ruleNames[rule] + " (" + rule + "): ");

		// if (rule != 1)
		// System.out.println(text);
		// else
		// System.out.println();

		switch (rule)
		{
			case 0:				// single_input
				break;
			// case 1: // file_input
			// break;
			case 2:				// eval_input
				break;
			case 3:				// decorator
				System.out.println(text);
				break;
			case 4:				// decorators
				break;
			// case 5: // decorated
			// break;
			case 6:				// async_funcdef
				break;
			case 7:				// funcdef
				String functionName = text.substring(3, text.indexOf("("));
				System.out.println(functionName);
				break;
			// case 8: // parameters
			// break;
			// case 9: // typedargslist
			// break;
			case 10:			// tfpdef
				System.out.println(text);
				break;
			case 11:			// varargslist
				break;
			case 12:			// vfpdef
				break;
			case 13:			// stmt
				break;
			// case 14: // simple_stmt
			// break;
			case 15:			// small_stmt
				break;
			case 16:			// expr_stmt
				System.out.println(text);
				break;
			case 17:			// annassign
				break;
			case 18:			// testlist_star_expr
				break;
			case 19:			// augassign
				break;
			case 20:			// del_stmt
				break;
			case 21:			// pass_stmt
				break;
			case 22:			// flow_stmt
				break;
			case 23:			// break_stmt
				break;
			case 24:			// continue_stmt
				break;
			// case 25: // return_stmt
			// break;
			case 26:			// yield_stmt
				break;
			case 27:			// raise_stmt
				break;
			case 28:			// import_stmt
				break;
			// case 29: // import_name
			// break;
			// case 30: // import_from
			// break;
			case 31:			// import_as_name
				System.out.println(text);
				break;
			case 32:			// dotted_as_name
				break;
			case 33:			// import_as_names
				break;
			case 34:			// dotted_as_names
				break;
			case 35:			// dotted_name
				System.out.println(text);
				break;
			case 36:			// global_stmt
				break;
			case 37:			// nonlocal_stmt
				break;
			case 38:			// assert_stmt
				break;
			case 39:			// compound_stmt
				break;
			case 40:			// async_stmt
				break;
			case 41:			// if_stmt
				break;
			case 42:			// while_stmt
				break;
			case 43:			// for_stmt
				break;
			case 44:			// try_stmt
				break;
			case 45:			// with_stmt
				break;
			case 46:			// with_item
				break;
			case 47:			// except_clause
				break;
			// case 48: // suite
			// break;
			case 49:			// test
				break;
			case 50:			// test_nocond
				break;
			case 51:			// larmbdef
				break;
			case 52:			// lambdef_nocond
				break;
			case 53:			// or_test
				break;
			case 54:			// and_test
				break;
			case 55:			// not_test
				break;
			case 56:			// comparison
				break;
			case 57:			// comp_op
				break;
			case 58:			// star_expr
				break;
			case 59:			// expr
				break;
			case 60:			// xor_expr
				break;
			case 61:			// and_expr
				break;
			case 62:			// shift_expr
				break;
			case 63:			// arith_expr
				break;
			case 64:			// term
				break;
			case 65:			// factor
				break;
			case 66:			// power
				break;
			case 67: 			// atom_expr
				System.out.println(text);
				break;
			case 68:			// atom
				System.out.println(text);
				break;
			case 69:			// testlist_comp
				break;
			case 70: // trailer
				System.out.println(text);
				break;
			case 71:			// subscriptlist
				break;
			case 72:			// subscript
				break;
			case 73:			// sliceop
				break;
			case 74:			// exprlist
				break;
			case 75:			// testlist
				break;
			case 76:			// dictorsetmaker
				break;
			case 77:			// classdef
				String classname = text.substring(5, text.indexOf("("));
				System.out.println(classname);
				break;
			case 78:			// arglist
				break;
			case 79:			// argument
				break;
			case 80:			// comp_iter
				break;
			case 81:			// comp_for
				break;
			case 82:			// comp_if
				break;
			case 83:			// encoding_decl
				break;
			case 84:			// yield_expr
				break;
			case 85:			// yield_arg
				break;
			default:
				System.out.println();
				break;
		}
	}

	public TreeSet<String> getClasses()
	{
		return classes;
	}

}