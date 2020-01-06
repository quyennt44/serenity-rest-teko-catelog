package vn.teko.utilities;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;

public class ImageUtils {
	private static String IMAGE_FOLDER = "src/test/resources/data/image/";
	public BufferedImage drawImage(int width, int height) {
		// Constructs a BufferedImage of one of the predefined image types.
		BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Create a graphics which can be used to draw into the buffered image
		Graphics2D g2d = bufferedImage.createGraphics();

		// draw face that takes up 80% of the JPanel
		int faceTop = height / 10;
		int faceLeft = width / 10;
		int faceHeight = height - height / 5;
		int faceWidth = width - width / 5;

		// Fill background
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, width, height);

		// outline
		g2d.setColor(Color.yellow);
		g2d.fillOval(faceLeft, faceTop, faceWidth, faceHeight);

		// eyes
		g2d.setColor(Color.black);
		g2d.fillOval(faceLeft + (int) (width * 0.2), faceTop + (int) (height * 0.2), width / 10, height / 10);
		g2d.fillOval(faceLeft + (int) (width * 0.5), faceTop + (int) (height * 0.2), width / 10, height / 10);

		// nose
		Polygon nose = new Polygon();
		nose.addPoint(faceLeft + (int) (width * 0.40), faceTop + (int) (height * 0.35));
		nose.addPoint(faceLeft + (int) (width * 0.45), faceTop + (int) (height * 0.50));
		nose.addPoint(faceLeft + (int) (width * 0.35), faceTop + (int) (height * 0.50));
		g2d.fillPolygon(nose);

		// mouth
		g2d.fillArc(faceLeft + (int) (width * 0.25), faceTop + (int) (height * 0.5), (int) (width * 0.3),
				(int) (height * 0.2), 0, -180);
		g2d.dispose();

		return bufferedImage;
	}

	public void saveImageToFile(String fileName, String imageType, BufferedImage bufferedImage) {
		// Save as PNG
		File file = new File(IMAGE_FOLDER + fileName);
		try {
			ImageIO.write(bufferedImage, imageType, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String encodeImageToBase64String(String fileName) {
		String filePath = IMAGE_FOLDER + fileName;
		byte[] fileContent = null;
		try {
			fileContent = FileUtils.readFileToByteArray(new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		return encodedString;
	}
	
	public String generateBase64ImageContent(String fileName, String imageType, int width, int height) {
		BufferedImage bufferedImage = drawImage(width, height);
		saveImageToFile(fileName, imageType, bufferedImage);
		
		String fileContent = encodeImageToBase64String(fileName);
		return fileContent;
	}
	
	public static void main(String str[]) {
		ImageUtils obj = new ImageUtils();
		System.out.println(obj.generateBase64ImageContent("test", "Png", 100, 100));
	}
	
}
