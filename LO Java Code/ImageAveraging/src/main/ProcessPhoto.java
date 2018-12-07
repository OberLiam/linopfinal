package main;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class ProcessPhoto {
	private static int photoWidth = 13;
	private static int photoHeight = 10;
	private static int picSize = 75;
	int main(String[] args)
	{
		try {
			File imagesFile = new File("images");
			for(File file : imagesFile.listFiles())
			{
				BufferedImage img = ImageIO.read(file);
				int w = img.getWidth();
				int h = img.getHeight();
				System.out.println();
				System.out.println("name: "+file.getName());
				System.out.println("Width: " + w);
				System.out.println("height: " + h);
				
				long totalR = 0;
				long totalG = 0;
				long totalB = 0;
				
				for (int i = 0; i < w; i++)
					for (int j = 0; j < h; j++) {
						int argb = img.getRGB(i, j);
						int a = (argb & 0xff000000) >>> 24;
						int r =	(argb & 0x00ff0000) >>> 16;
						int g = (argb & 0x0000ff00) >>> 8;
						int b = (argb & 0x000000ff) >>> 0;
						totalR += r;
						totalG += g;
						totalB += b;
					}
				
				int averageR = (int)(totalR/(w*h));
				System.out.println("average red  : "+averageR);
				int averageG = (int)(totalG/(w*h));
				System.out.println("average green: "+averageG);
				int averageB = (int)(totalB/(w*h));
				System.out.println("average blue : "+averageB);
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
