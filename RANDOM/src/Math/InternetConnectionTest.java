package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class InternetConnectionTest
{
	public static void main(String[] args)
	{
		try
		{
			URLConnection website = (new URL("https://www.wikipedia.org")).openConnection();
			website.connect();
			BufferedReader st = new BufferedReader(new InputStreamReader(website.getInputStream()));
			// OutputStreamWriter out = new
			// OutputStreamWriter(website.getOutputStream());

			// out.write("string=asdjkfla");

			String inputLine;
			while ((inputLine = st.readLine()) != null)
				System.out.println(inputLine);

			st.close();
			// out.close();
		}
		catch (MalformedURLException e)
		{
			System.out.println("OOPS. SOMETHING WENT WRONG WITH THE URL.");
		}
		catch (IOException e)
		{
			System.out.println("OOPS. SOMETHING WENT WRONG WITH THE WEBSITE.");
		}
	}
}
