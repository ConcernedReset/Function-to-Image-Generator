package functionToImage;
import java.awt.Color;
import PicLib.Picture;
import PicLib.Pixel;
import PicLib.PictureFrame;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Picture picture = new Picture(256*3, 256*4);
		Pixel[][] pixels = picture.getPixels2D();
		PictureFrame frame = new PictureFrame();
		double time = 1d;
		
		while (true)
		{
			time += 0.1;
			for (Pixel[] row : pixels)
			{
				for (Pixel p : row)
				{
					int x = p.getCol();
					int y = p.getRow();
					
					// Noise : (int) (Math.random() * 100)
					// Deconstructing binary fractal : ((int)((x^y) - time)
					// 3d Beach : (int)((Math.pow(x, 2) + 90)/(y+time)))
					// Alien Death : (int)((Math.pow(x, 2) + 90)/(y+time)) * ((int)((x^y) - time)))
					// Insanity : (int)((Math.pow(x, 2) + 90)/(y+time)) * ((int)((x^y) - time)) * (int)((Math.pow(x, 2) + 90)/(y+time)) * (int)((Math.pow(x, 2) + 90)/(y+time)))
					
					p.setColor(new Color(x^y));
				}
			}
			frame.setPicture(picture);
			
		}
	}
}
