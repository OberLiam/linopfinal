package main;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
public class WriteGurobia
{
	private static int photoWidth = 13;
	private static int photoHeight = 10;
	private static int numPics = 14;
	
	public static PrintWriter writer;
	public static void main(String[] args)
	{
		try {
			writer = new PrintWriter("gurobifile.txt", "UTF-8");
			// now, everything is all set up to write to your file.
			
			pl("minimize ");
			for(int i=0;i<=numPics;i++)
				for(int j=0;j<=photoWidth;j++)
					for(int k=0;k<=photoHeight;k++)
					{
						p(" x"+i+"_"+j+"_"+k+" ");
						if(i!=photoWidth || j!=photoHeight)
							p("+");
					}
			pl("");
			pl("subject to");
			for(int i=0;i<=photoWidth;i++)
				for(int j=0;j<=photoHeight;j++)
					pl(" 0 <= var"+i+"_"+j+"  <= "+(i+j));
			pl("end");
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static void pl(String s) {
		writer.println(s);
	}
	public static void p(String s) {
		writer.print(s);
	}
}
