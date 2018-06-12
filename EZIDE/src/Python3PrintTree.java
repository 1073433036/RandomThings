import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashSet;
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
	private TreeSet<String> atoms = new TreeSet<>();
	private boolean ignoringWrappers = false;

	public void setIgnoringWrappers(boolean ignoringWrappers)
	{
		this.ignoringWrappers = ignoringWrappers;
	}

	public void print(RuleContext ctx)
	{
		explore(ctx, 0);
	}

	static int times = 0;

	private void explore(RuleContext ctx, int indentation)
	{
		boolean toBeIgnored = ignoringWrappers && ctx.getChildCount() == 1
				&& ctx.getChild(0) instanceof ParserRuleContext;
		if (!toBeIgnored)
		{
			String ruleName = Python3Parser.ruleNames[ctx.getRuleIndex()];
			if (!ruleName.equals("file_input"))
			{
				for (int i = 0; i < indentation; i++)
					System.out.print(" ");
				System.out.println(ruleName + ": " + ctx.getText().trim());
			}
			else
				System.out.println(ruleName + ":");
		}

		for (int i = 0; i < ctx.getChildCount(); i++)
		{
			ParseTree element = ctx.getChild(i);
			if (element instanceof RuleContext)
				explore((RuleContext) element, indentation + (toBeIgnored ? 0 : 1));
		}
	}

	public TreeSet<String> getAtoms()
	{
		return atoms;
	}

}