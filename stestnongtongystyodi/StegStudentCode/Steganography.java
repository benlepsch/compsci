import java.awt.Color;
import java.awt.Point;
import java.util.*;

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

    public static void testSetLow(Picture p, Color c) {
        Pixel[][] pixels = p.getPixels2D();
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                setLow(pixels[i][j], c);
            }
        }
    }

    public static Picture revealPicture(Picture hidden) {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                Color col = source[i][j].getColor();
                pixels[i][j].setColor(new Color((col.getRed() % 4) * 64, (col.getGreen() % 4) * 64, (col.getBlue() % 4) * 64));
            }
        }

        return copy;
    }

    public static boolean canHide(Picture source, Picture secret) {
        Pixel[][] sourcePix = source.getPixels2D();
        Pixel[][] secretPix = secret.getPixels2D();

        if (sourcePix.length == secretPix.length && sourcePix[0].length == secretPix[0].length) {
            return true;
        }
        return false;
    }

    public static Picture hidePicture(Picture source, Picture secret) {
        Picture copy = new Picture(source);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] secretPix = secret.getPixels2D();

        for (int i = 0; i < secretPix.length; i++) {
            for (int j = 0; j < secretPix[0].length; j++) {
                Color col = secretPix[i][j].getColor();
                setLow(pixels[i][j], col);
            }
        }

        return copy;
    }

    public static Picture hidePicture(Picture source, Picture secret, int startRow, int startCol) {
        Picture copy = new Picture(source);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] secretPix = secret.getPixels2D();

        for (int i = 0; i < secretPix.length; i++) {
            for (int j = 0; j < secretPix[0].length; j++) {
                Color col = secretPix[i][j].getColor();
                setLow(pixels[i + startRow][j + startCol], col);
            }
        }

        return copy;
    }

    public static boolean isSame(Picture pic1, Picture pic2) {
        Pixel[][] p1 = pic1.getPixels2D();
        Pixel[][] p2 = pic2.getPixels2D();

        if (p1.length != p2.length || p1[0].length != p2[0].length) {
            return false;
        }

        for (int i = 0; i < p1.length; i++) {
            for (int j = 0; j < p1[0].length; j++) {
                Color c1 = p1[i][j].getColor();
                Color c2 = p2[i][j].getColor();

                if (c1.getRed() != c2.getRed() || c1.getBlue() != c2.getBlue() || c1.getGreen() != c2.getGreen()) {
                    return false;
                }
            }
        }

        return true;
    }

    public static ArrayList<Point> findDifferences(Picture p1, Picture p2) {
        ArrayList<Point> list = new ArrayList<Point>();

        Pixel[][] pix1 = p1.getPixels2D();
        Pixel[][] pix2 = p2.getPixels2D();

        if (pix1.length != pix2.length || pix1[0].length != pix2[0].length) {
            return list;
        }

        for (int i = 0; i < pix1.length; i++) {
            for (int j = 0; j < pix1[0].length; j++) {
                Color c1 = pix1[i][j].getColor();
                Color c2 = pix2[i][j].getColor();

                if (c1.getRGB() != c2.getRGB()) {
                    list.add(new Point(i, j));
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        Picture arch = new Picture("arch.jpg");
        Picture koala = new Picture("koala.jpg") ;
        Picture robot1 = new Picture("robot.jpg");
        Picture arch2 = new Picture("arch.jpg");
        ArrayList<Point> pointList = findDifferences(arch, arch2);
        System.out.println("PointList after comparing two identical s pictures has a size of " + pointList.size());
        pointList = findDifferences(arch, koala);
        System.out.println("PointList after comparing two different sized pictures has a size of " + pointList.size());
        arch2 = hidePicture(arch, robot1, 65, 102);
        pointList = findDifferences(arch, arch2);
        System.out.println("Pointlist after hiding a picture has a size of " + pointList.size());
        arch.show();
        arch2.show(); 
    }
}