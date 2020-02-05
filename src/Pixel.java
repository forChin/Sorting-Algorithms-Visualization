import java.awt.image.BufferedImage;

/* Pixel.java is an object used to represent
 * every subimage of the browsed image.
 */

public class Pixel {
	private int id;
	private BufferedImage subimage;
	
	public Pixel(int id, BufferedImage subimage) {
		this.id = id;
		this.subimage = subimage;
	}

	public BufferedImage getSubimage() {
		return subimage;
	}
	
	public int getID() {
		return id; 
	}

	public void setID(int position) {
		this.id = position;
	}
	
	public void setSubimage(BufferedImage subimage) {
		this.subimage = subimage;
	}
}
