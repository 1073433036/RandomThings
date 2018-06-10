import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

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
		astPrinter.print(parserFacade.parse(new File("simple1.py")));
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
		String code = readFile(file, Charset.forName("UTF-8"));
		Python3Lexer lexer = new Python3Lexer(new ANTLRInputStream(code));

		CommonTokenStream tokens = new CommonTokenStream(lexer);

		Python3Parser parser = new Python3Parser(tokens);

		return parser.file_input();
	}
}

class AstPrinter
{

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
			String ruleName = Python3Parser.ruleNames[ctx.getRuleIndex()];
			for (int i = 0; i < indentation; i++)
			{
				System.out.print("  ");
			}
			System.out.println(ruleName + ": " + ctx.getText());
		}
		for (int i = 0; i < ctx.getChildCount(); i++)
		{
			ParseTree element = ctx.getChild(i);
			if (element instanceof RuleContext)
			{
				explore((RuleContext) element, indentation + (toBeIgnored ? 0 : 1));
			}
		}
	}

}