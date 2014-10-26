
public class ImageProcessing {
	
		//BRIGHTEN-METHOD
		public short[][] Brighten(short[][] originalImage, short quantity ){
			short [][] processedImage = new short[originalImage.length][originalImage[0].length];
			
			for (int i = 0; i < originalImage.length; i++) {
				for (int j = 0; j < originalImage[i].length; j++) {
					boolean isGreaterThan255 = (originalImage[i][j]+quantity) > 255; 
					if(!isGreaterThan255){
						processedImage[i][j] = (short)(originalImage[i][j] + quantity);// adding quantity if result is NOT greater than 255
					} else {
						processedImage[i][j] = 255;//else keeping it 255
					}
				}
			}
			return processedImage;
		}
		
		//DARKEN-METHOD
		public short[][] Darken(short[][] originalImage,short quantity){
			short [][] processedImage = new short[originalImage.length][originalImage[0].length];
			
			for (int i = 0; i < originalImage.length; i++) {
				for (int j = 0; j < originalImage[i].length; j++) {
					boolean isLessThan0 = (originalImage[i][j] - quantity) < 0;
					if(!isLessThan0){
						processedImage[i][j] = (short)(originalImage[i][j] - quantity); // subtracting if the result is going to be NOT less than 0
					} else {
						processedImage[i][j] = 0; // else keeping it 0
					}
				}
			}
			return processedImage;
		}
		
		//CROP-METHOD
		public short[][]Crop(short[][] originalImage, int ULx, int ULy, int LRx, int LRy){
			short [][] processedImage = new short[LRy-ULy][LRx - ULx]; // coordinate geometry ! :D 
			for (int i = 0; i < processedImage.length; i++) {
				for (int j = 0; j < processedImage[i].length; j++) {
					processedImage[i][j] = originalImage[i + ULy][j + ULx]; // shifting to appropriate position (x-axis and y-axis)
				}
			}
			return processedImage;
		}
		
		//NOISE-METHOD
		public short[][] Noise(short[][] originalImage, short quantity){
			short[][] processedImage = new short[originalImage.length][originalImage[0].length];
			
			for (int i = 0; i < processedImage.length; i++) {
				for (int j = 0; j < processedImage[i].length; j++) {
					if(Math.random() < 0.51){ // 50 % chance of subtracting or adding random values to the pixels
						processedImage[i][j] = (short)(originalImage[i][j] +  (int)(1+ Math.random()) * quantity); // either adding 'quantity' pixels 
					}else{
						processedImage[i][j] = (short)(originalImage[i][j] -  (int)(1+ Math.random()) * quantity); // or subtracting ... 
					}
				}
			}
			return	processedImage;
		}
}
