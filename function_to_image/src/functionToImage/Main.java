package functionToImage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import PicLib.Picture;
import PicLib.PictureFrame;

import javax.swing.*;


public class Main {
	static int BIT_MASK=0xFFFFFF;
	static int DIVIDE_ZERO_COLOR=0x0;
	static int WIDTH=256*4;
	static int HEIGHT=256*3;
	static boolean running=true;
	
	public static void main(String[] args) {
		// TODO add recursive portal to have the image repeat itself indefinitely
		Picture picture = new Picture(HEIGHT, WIDTH);
		PictureFrame frame = new PictureFrame();
		JFrame jframe = frame.getFrame();
		int c, t = 0;

		jframe.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { running=false; }
		});
		
		while (running)
		{
			//System.out.println(t); // : For Debug
			for (int x = 0; x<WIDTH; x++)
			{
				for (int y = 0; y<HEIGHT; y++)
				{
					c=picture.getBasicPixel(x, y);
					/*  Tips:
					 * 
					 *  Dividing usually zooms in the image
					 *  Multiplying usually zooms out the image
					 *
					 * 	Variables:
					 * 	x: x-position of pixel
					 *  y: y-position of pixel
					 *  t: current time in ticks
					 *  c: last color of pixel
					 *
					 *  Binary Cheat Sheet:
					 *  | : OR binary, if one of the bits compared is 1, it returns 1.
					 *  & : AND binary, only returns 1 if both compared bits are 1. Useful for masking out RGB bits eg: 0x133742 & 0x00FF00 = 0x003700. Each F is true, each 0 is false, and each RGB val gets 2 digits
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
					// Deconstruction binary fractal different : (x^y)*t
					// 3d Beach : (Math.pow(x, 2) + 90)/(y+t)
					// Alien Death : (int)((Math.pow(x, 2) + 90)/(y+t)) * ((int)((x^y) - t)))
					// Insanity : ((Math.pow(x, 2) + 90)/(y+t)) * ((int)((x^y) - t)) * (int)((Math.pow(x, 2) + 90)/(y+t)) * (int)((Math.pow(x, 2) + 90)/(y+t)))
					// Brick : x^y&t
					// AND Morph : (int) x&y&-((x*t)^(y*t))
					// Zoom out Insanity : y*t*t*2^x*t*t*2
					// 4d Beach : (Math.pow(x, 2) + 90)/(y-t) 					: Don't forget to set y = (y-t==0) ? y-t-1 : y;
					// Photon Cannon : (int) (Math.pow(x, 2) + 90)/(y-300) * t  : Don't forget to set y = (y-300==0) ? y-300-1 : y;
					// God Complex Chessboard : sumEvens(x*t*t*t^(y*t*t*t))*100 : Try putting t to higher powers
					
					// use & 0xFFFFFF to mask out certain colors, each 2 f's is a color in rgb
					
					//y = (y-t==0) ? y-t+1 : y;
					//x = (x-t==0) ? x-t+1 : x;
					
					
					try {
						int color = x^y+c;
						picture.setBasicPixel(x, y, color & BIT_MASK);
					} catch (ArithmeticException e) {
						picture.setBasicPixel(x, y, DIVIDE_ZERO_COLOR);
					}
					
				}
			}
			frame.setPicture(picture);
			t++;
		}
		frame.close();
		System.exit(0);
	}
	
	
}
