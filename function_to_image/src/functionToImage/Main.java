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
		int t = 1;
		
		while (true)
		{
			t += 1;
			for (Pixel[] row : pixels)
			{
				for (Pixel p : row)
				{
					int x = p.getCol();
					int y = p.getRow();
					int mask = 0xFFFFFF;
					
					// Noise : (int) (Math.random() * 100)
					// Deconstructing binary fractal : ((int)((x^y) - time)
					// 3d Beach : (int)((Math.pow(x, 2) + 90)/(y+time)))
					// Alien Death : (int)((Math.pow(x, 2) + 90)/(y+time)) * ((int)((x^y) - time)))
					// Insanity : (int)((Math.pow(x, 2) + 90)/(y+time)) * ((int)((x^y) - time)) * (int)((Math.pow(x, 2) + 90)/(y+time)) * (int)((Math.pow(x, 2) + 90)/(y+time)))
					// Brick : x^y&t
					
					// use & 0xFFFFFF to mask out certian colors, each 2 f's is a color in rgb 
					
					p.setColor(new Color(x^y));
					
				}
			}
			frame.setPicture(picture);
		}
	}
}
