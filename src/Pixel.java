import java.awt.image.BufferedImage;

public class Pixel {
	private int position;
	private BufferedImage subimage;
	
	public Pixel(int position, BufferedImage subimage) {
		this.position = position;
		this.subimage = subimage;
	}

	public BufferedImage getSubimage() {
		return subimage;
	}
	
	public int getPosition() {
		return position; 
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	public void setSubimage(BufferedImage subimage) {
		this.subimage = subimage;
	}
}
