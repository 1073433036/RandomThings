package TRULYRANDOM;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class hello
{
	public static void main(String[] args) throws IOException
	{
		Document doc = Jsoup.connect("https://www.setgame.com/set/puzzle").get();
		
	}
}
