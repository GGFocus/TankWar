package test;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class ImageTest {

	@Test
	public void test() {
		
		try {
			BufferedImage image = ImageIO.read(new File("E:\\MyCode\\Tank\\TankWar\\src\\images\\GoodTank1.png"));
			assertNotNull(image);

			BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			//this.getClass()
			assertNotNull(image2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
