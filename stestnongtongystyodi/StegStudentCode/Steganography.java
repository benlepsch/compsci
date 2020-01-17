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

    public static Picture showDifferentArea(Picture pic, ArrayList<Point> list) {
        Picture copy = new Picture(pic);
        Pixel[][] pixels = copy.getPixels2D();
        int maxX = (int)list.get(0).getX(), maxY = (int)list.get(0).getY(), minX = (int)list.get(0).getX(), minY = (int)list.get(0).getY();

        for (int i = 0; i < list.size(); i++) {
            Point at = list.get(i);
            if (at.getX() > maxX)
                maxX = (int) at.getX();
            if (at.getX() < minX)
                minX = (int) at.getX();
            if (at.getY() > maxY)
                maxY = (int) at.getY();
            if (at.getY() < minY)
                minY = (int) at.getY();
        }

        for (int i = minX; i <= maxX; i++) {
            pixels[i][minY].setColor(Color.RED);
            pixels[i][maxY].setColor(Color.RED);
        }

        for (int j = minY; j <= maxY; j++) {
            pixels[minX][j].setColor(Color.RED);
            pixels[maxX][j].setColor(Color.RED);
        }

        return copy;
    }

    public static ArrayList<Integer> encodeString(String s) {
        s = s.toUpperCase();
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals(" ")) {
                result.add(27);
            } else {
                result.add(alpha.indexOf(s.substring(i, i+1)) + 1);
            }
        }

        result.add(0);
        return result;
    }

    public static String decodeString(ArrayList<Integer> codes) {
        String result = "";
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < codes.size(); i++) {
            if (codes.get(i) == 0) {
                return result;
            }
            if (codes.get(i) == 27) {
                result = result + " ";
            } else {
                result = result + alpha.substring(codes.get(i) - 1, codes.get(i));
            }
        }

        return result;
    }

    public static int[] getBitPairs(int num) {
        int[] bits = new int[3];
        int code = num;

        for (int i = 0; i < 3; i++) {
            bits[i] = code % 4;
            code = code / 4;
        }

        return bits;
    }

    public static int getNumFromPairs(int[] bits) {
        return bits[0] + bits[1]*4 + bits[2]*16;
    }

    public static void hideText(Picture source, String s) {
        Pixel[][] pixels = source.getPixels2D();
        ArrayList<Integer> bruh = encodeString(s);
        int[][] d = new int[bruh.size()][3];

        for (int i = 0; i < bruh.size(); i++) {
            d[i] = getBitPairs(bruh.get(i));
        }
        // clear last two bits of RGB for each pixel needed
        int count = 0;
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                Color c = pixels[i][j].getColor();
                int red = c.getRed() / 4;
                int green = c.getGreen() / 4;
                int blue = c.getBlue() / 4;
                pixels[i][j].setColor(new Color(red*4 + d[count][0], green*4 + d[count][1], blue*4 + d[count][2]));
                count++;
                if (count >= d.length) {
                    return;
                }
            }
        }
    }

    public static String revealText(Picture source) {
        Pixel[][] pixels = source.getPixels2D();
        ArrayList<Integer> dec = new ArrayList<Integer>();

        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[0].length; j++) {
                Color c = pixels[i][j].getColor();
                int r = c.getRed() % 4;
                int g = c.getGreen() % 4;
                int b = c.getBlue() % 4;
                if (r == 0 && g == 0 && b == 0)
                    return decodeString(dec);
                dec.add(getNumFromPairs(new int[] {r, g, b}));
            }
        }

        return decodeString(dec);
    }

    public static void main(String[] args) {
        Picture bruh = new Picture("beach.jpg");
        hideText(bruh, "IT WORKS IT WORKS IT aWORKS IT WORKS IT WORKS IT WORKS IT WORKdS IT WORKS IT WORKS IT hWORKS IT WORKS IT WORKSw IT WORKS IT WORKS IT WORKS ITg WORKS ");
        System.out.println(revealText(bruh));
    }
}