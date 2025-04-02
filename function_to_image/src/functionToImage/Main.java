package functionToImage;
import java.awt.Color;
import PicLib.Picture;
import PicLib.Pixel;
import PicLib.PictureFrame;


public class Main {
	
	public static void main(String[] args) {
		// TODO add recursive portal to have the image repeat itself indefinitely
		Picture picture = new Picture(256*3, 256*4);
		Pixel[][] pixels = picture.getPixels2D();
		PictureFrame frame = new PictureFrame();
		int t = 1;
		System.out.println(Funcs.multiplyEvens(8));
		
		
		while (true)
		{
			//System.out.println(t); // : For Debug
			t += 1;
			for (Pixel[] row : pixels)
			{
				for (Pixel p : row)
				{
					int x = p.getCol();
					int y = p.getRow();
					int mask = 0xFFFFFF;
					
					/*  Tips:
					 * 
					 *  Dividing usually zooms in the image
					 *  Multiplying usually zooms out the image
					 *  Binary Cheat Sheet:
					 *  | : OR binary, if one of the bits compared is 1, it returns 1.
					 *  & : AND binary, only returns 1 if both compared bits are 1. Useful for anding/masking out RGB bits 0xFFFF00, each F is true, each 0 is false, and each RGB val gets 2 letters
					 *  ^ : XOR binary, returns 1 if both compared bits are different. 
					 *  ~ : Bitwise Complement, returns the opposite of the bit, no comparison. 
					 *  >>  : Signed Right shift operator. 
					 *  >>> : Zero Fill Right shift operator.   Try using these to change the amount of times something repeats
					 *  <<  : Left Shift operator. 
					 */
					
					// Basic Fractal : x^y
					// Geometry : x^x + y^y
					// sumEvens Art : sumEvens(x^y)*100
					// Noise : (int) (Math.random() * 100)
					// Blurry Binary Fractal : (int)(x +Math.random() * 10)^(int)(y + Math.random() * 10)
					// Deconstructing binary fractal : ((int)((x^y) - t)
					// Deconstruction bianary fractal different : (x^y)*t
					// 3d Beach : (Math.pow(x, 2) + 90)/(y+t)
					// Alien Death : (int)((Math.pow(x, 2) + 90)/(y+t)) * ((int)((x^y) - t)))
					// Insanity : ((Math.pow(x, 2) + 90)/(y+t)) * ((int)((x^y) - t)) * (int)((Math.pow(x, 2) + 90)/(y+t)) * (int)((Math.pow(x, 2) + 90)/(y+t)))
					// Brick : x^y&t
					// Anding Morph : (int) x&y&-((x*t)^(y*t))
					// Zoom out Insanity : y*t*t*2^x*t*t*2
					// 4d Beach : (Math.pow(x, 2) + 90)/(y-t) 					: Don't forget to set y = (y-t==0) ? y-t-1 : y;
					// Photon Cannon : (int) (Math.pow(x, 2) + 90)/(y-300) * t  : Don't forget to set y = (y-300==0) ? y-300-1 : y;
					// God Complex Chessboard : sumEvens(x*t*t*t^(y*t*t*t))*100 : Try putting t to higher powers
					
					// use & 0xFFFFFF to mask out certian colors, each 2 f's is a color in rgb 
					
					//y = (y-t==0) ? y-t+1 : y;
					//x = (x-t==0) ? x-t+1 : x;
					
					
					p.setColor(new Color(Funcs.sumEvens(x^y)*100 & mask));
					
				}
			}
			frame.setPicture(picture);
		}
	}
	
	
}
