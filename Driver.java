/*
 * Name : Prashant Ghimire 
 * W0512595
 * CMPS 280 
 * Submitted to : Dr. Sebastian Van Delden
 * Date : 10/10/13
 * ASSIGNMENT - 2 (2D ARRAYS)
 */


public class Driver {
	public static void main(String[]args){
		getPGM file = new getPGM("football.pgm");
		new showGrayImage(new ImageProcessing().Brighten(file.getImage(), (short) 100), "Brightened!!");
		new showGrayImage(new ImageProcessing().Darken(file.getImage(), (short) 50), "Darkened!!");
		new showGrayImage(new ImageProcessing().Crop(file.getImage(), 50, 50, 400, 100), "Croped!!" );
		new showGrayImage(new ImageProcessing().Noise(file.getImage(), (short)35), "Noised!!");
	}
}
