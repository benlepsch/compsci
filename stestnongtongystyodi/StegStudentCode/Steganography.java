import java.awt.Color;

public class Steganography {

    public static void clearLow(Pixel p) {
        int red = p.getRed() / 4;
        int blue = p.getBlue() / 4;
        int green = p.getGreen() / 4;
        p.setColor(new Color(red*4, green*4, blue*4));
    }

    public static void setLow(Pixel p, Color c) {
        int setRed = c.getRed()/64;
        int setBlue = c.getBlue()/64;
        int setGreen = c.getGreen()/64;
        int red = p.getRed() / 4;
        int blue = p.getBlue() / 4;
        int green = p.getGreen() / 4;
        p.setColor(new Color(red*4 + setRed, green*4 + setGreen, blue*4 + setBlue));
    }

    public static void testClearLow(Picture p) {
        Pixel[][] pixels = p.getPixels2D();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                clearLow(pixels[i][j]);
            }
        }
        
    }

    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        testClearLow(beach);
        beach.explore();
    }
}