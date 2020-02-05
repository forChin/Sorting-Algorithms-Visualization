import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.imageio.ImageIO;

public class GradientGenerator {
	static int height = 600, width = 800;
	float ratio;
	int red, green, blue;
	Color color1, color2;
	ArrayList<Color> screenColors = new ArrayList<Color>();
	
	public static void main(String[] args) {
		GradientGenerator gg = new GradientGenerator();
		gg.generateGradient();
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g2d = bufferedImage.createGraphics();
		for(int i = 0; i < 600; i++) {
			for(int j = 0; j < 800; j++) {
				g2d.setColor(gg.screenColors.get(j));
				g2d.fillRect(j,  i, 1, 1);
			}
		}
		g2d.dispose();
		File file = new File("gradient.jpg");
        try {
			ImageIO.write(bufferedImage, "jpg", file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateGradient() {
		int steps = width/5;
		int extraSteps = width%5;

        //in one LOOP
		color1 = Color.RED;
        color2 = Color.YELLOW;
        for (int i = 0; i < steps; i++) {
            ratio = (float) i / (float) steps;
            red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
    		screenColors.add(new Color(red, green, blue));
        }

        color1 = Color.YELLOW;
        color2 = Color.GREEN;
        for (int i = 0; i < steps; i++) {  
            ratio = (float) i / (float) steps;
            red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
    		screenColors.add(new Color(red, green, blue));
        }
        
        color1 = Color.GREEN;
        color2 = Color.CYAN;
        for (int i = 0; i < steps; i++) {
            ratio = (float) i / (float) steps;
            red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
    		screenColors.add(new Color(red, green, blue));
        }
        
        color1 = Color.CYAN;
        color2 = Color.BLUE;
        for (int i = 0; i < steps; i++) {
            ratio = (float) i / (float) steps;
            red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
    		screenColors.add(new Color(red, green, blue));
        }
        
        color1 = Color.BLUE;
        color2 = Color.MAGENTA;
        for (int i = 0; i < steps; i++) {
            ratio = (float) i / (float) steps;
            red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
    		screenColors.add(new Color(red, green, blue));
        };
        
        color1 = Color.MAGENTA;
        color2 = Color.WHITE;
        for (int i = 0; i < extraSteps; i++) {
            ratio = (float) i / (float) extraSteps;
            red = (int) (color2.getRed() * ratio + color1.getRed() * (1 - ratio));
            green = (int) (color2.getGreen() * ratio + color1.getGreen() * (1 - ratio));
            blue = (int) (color2.getBlue() * ratio + color1.getBlue() * (1 - ratio));
    		screenColors.add(new Color(red, green, blue));
        }
	}
}