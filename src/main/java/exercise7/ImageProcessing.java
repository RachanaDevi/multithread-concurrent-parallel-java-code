package main.java.exercise7;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessing {

    private static final String SOURCE_FILE = "src/main/java/exercise7/resources/many-flowers.jpg";
    private static final String DESTINATION_FILE = "src/main/java/exercise7/out/many-flowers.jpg";

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File(SOURCE_FILE));
        BufferedImage resultImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_INT_RGB);

        recolorSingleThreaded(originalImage, resultImage);
        File outputFile = new File(DESTINATION_FILE);
        ImageIO.write(resultImage, "jpg", outputFile);
    }

    public static void recolorSingleThreaded(BufferedImage originalImage, BufferedImage resultImage){
        recolorImage(originalImage, resultImage, 0, 0, originalImage.getWidth(), originalImage.getHeight());
    }

    public static void recolorImage(BufferedImage originalImage, BufferedImage resultImage, int leftCorner, int topCorner, int width, int height) {
        for (int x = leftCorner; x < leftCorner + width && x < originalImage.getWidth(); x++) {
            for (int y = topCorner; y < topCorner + height && y < originalImage.getHeight(); y++) {
                recolorPixel(originalImage, resultImage, x, y);

            }
        }
    }

    public static void recolorPixel(BufferedImage originalImage, BufferedImage resultImage, int x, int y) {
        int rgb = originalImage.getRGB(x, y);
        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        int newRed = red;
        int newGreen = green;
        int newBlue = blue;

        if (isShadeOfGray(red, green, blue)) {
            // doing all this is by trail and error
            newRed = Math.min(255, red + 10);
            newGreen = Math.max(0, green - 80);
            newBlue = Math.max(0, blue - 20);
        }

        int newRGB = createRGBFromColors(newRed, newGreen, newBlue);
        setRGB(resultImage, x, y, newRGB);
    }

    public static void setRGB(BufferedImage image, int x, int y, int rgb) {
        image.getRaster().setDataElements(x, y, image.getColorModel().getDataElements(rgb, null));
    }


    // if the difference between all the colors is less than 30
    public static boolean isShadeOfGray(int red, int green, int blue) {
        return Math.abs(red - green) < 30 && Math.abs(red - blue) < 30
                && Math.abs(green - blue) < 30;

    }

    public static int createRGBFromColors(int red, int green, int blue) {
        int rgb = 0;
        // logical or to add the value
        rgb = rgb | blue;
        rgb = rgb | green << 8; //bitshift left
        rgb = rgb | red << 16;
        rgb = rgb | 0xFF000000;

        return rgb;
    }

    private static int getRed(int rgb) {
        return (rgb & 0x00FF0000) >> 16;
    }

    private static int getGreen(int rgb) {
        // green is second right so we shift it to right
        return (rgb & 0x0000FF00) >> 8;
    }

    private static int getBlue(int rgb) {
        return (rgb & 0x000000FF);
    }

}
