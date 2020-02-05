import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

/* Image.java is an object, 
 * which contains information about the image 
 * and crops the image into pixels
 */

public class Image {
	private int width, height;
	private BufferedImage image;
	private ArrayList<ArrayList<Pixel>> pixels;

	
	Image(String path, int size) {
		pixels = new ArrayList<>();

		try {
			image = ImageIO.read(new File(path));
			width = image.getWidth();
			height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}

		generatePixels(size);
		shuffle();
	}
	
	public void shuffle() {
		for(int i = 0; i < pixels.size(); i++) {
			Collections.shuffle(pixels.get(i));
		}
	}

	public ArrayList<ArrayList<Pixel>> getPixels() {
		return pixels;
	}
	
	// generate subimages from original image
	public void generatePixels(int size) {
		pixels.clear();
		
		for(int i = 0; i < height - height%size; i += size) {
			ArrayList<Pixel> row = new ArrayList<>();
			for (int j = 0; j < width - width%size; j += size) {
				row.add(new Pixel(j, image.getSubimage(j,  i, size, size)));
			}
			pixels.add(row);
		}
	}

	public BufferedImage getImage() {
		return image;
	}
}
