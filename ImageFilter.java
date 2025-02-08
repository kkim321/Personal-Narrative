import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  public ImageFilter(String fileName) {
    super(fileName);
  }

   /*
   * Applies a negative filter to the image
   * - Inverts the red, green, and blue values of each pixel
   * - Formula: newColor = 255 - originalColor
   */
  public void makeNegative() {

    Pixel[][] pixels = getPixelsFromImage();
    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[0].length; col++) {
      Pixel currentPixel = pixels[row][col];

        int red = 255 - currentPixel.getRed();
        int green = 255 - currentPixel.getGreen();
        int blue = 255 - currentPixel.getBlue();
        
        currentPixel.setColor(new Color(red, green, blue));
      }
    }
  }
  
  /*
   * Applies an emboss effect to the image
   * - Compares each pixel with the pixel diagonally above it
   * - Computes the difference in RGB values
   * - Sets the new color based on the largest difference
   */
  public void emboss() {
  Pixel[][] pixels = getPixelsFromImage();

    for (int row = 1; row < pixels.length; row++) {
      for (int col = 1; col < pixels[0].length; col++) {
        Pixel currentPixel = pixels[row][col];
        Pixel topLeftPixel = pixels[row - 1][col - 1];

        int newRed = currentPixel.getRed() - topLeftPixel.getRed();
        int newGreen = currentPixel.getGreen() - topLeftPixel.getGreen();
        int newBlue = currentPixel.getBlue() - topLeftPixel.getBlue();

        int maxDiff = 0;

        if (Math.abs(newRed) > Math.abs(newGreen) && Math.abs(newRed) > Math.abs(newBlue)) {
          maxDiff = Math.abs(newRed);
        }
        else if (Math.abs(newGreen) > Math.abs(newRed) && Math.abs(newGreen) > Math.abs(newBlue)) {
          maxDiff = Math.abs(newGreen);
        }
        else {
          maxDiff = Math.abs(newBlue);
        }

        int newColor = 128 + maxDiff;
        currentPixel.setRed(newColor);
        currentPixel.setGreen(newColor);
        currentPixel.setBlue(newColor);
      }
    }
    
  }
  

 /*
   * Applies a colorize filter to the image
   * - Converts the image to a simplified color range based on brightness
   * - If the brightness (average RGB) is low, sets color to red
   * - If brightness is medium, sets color to green
   * - If brightness is high, sets color to blue
   */
  public void colorize() {
Pixel[][] pixels = getPixelsFromImage(); 

    for (int row = 0; row < pixels.length; row++) {
      for (int col = 0; col < pixels[row].length; col++) {
        Pixel pixel = pixels[row][col];

        int red = pixel.getRed();
        int green = pixel.getGreen();
        int blue = pixel.getBlue();
        int average = (red + green + blue) / 3;

        if (average < 85) {
          pixel.setColor(new Color(255, 0, 0));
        } else if (average < 170) {
          pixel.setColor(new Color(0, 255, 0));
        } else {
          pixel.setColor(new Color(0, 0, 255));
        }
      }
    }
  }

 /*
   * Flips the image upside down
   * - Swaps pixel values between the top and bottom rows
   * - Continues swapping until the middle of the image is reached
   */
  public void flipupsidedown() {
    Pixel[][] p = getPixelsFromImage();
    for(int i = 0; i < p.length / 2; i++) {
      for(int j = 0; j < p[0].length; j++) {
        int tempred = p[i][j].getRed();
        int tempgreen = p[i][j].getGreen();
        int tempblue = p[i][j].getBlue();

        int newred = p[p.length-i-1][j].getRed();
        int newgreen = p[p.length-i-1][j].getGreen();
        int newblue = p[p.length-i-1][j].getBlue();

        p[i][j].setRed(newred);
        p[i][j].setGreen(newgreen);
        p[i][j].setBlue(newblue);

        p[p.length-i-1][j].setRed(tempred);
        p[p.length-i-1][j].setGreen(tempgreen);
        p[p.length-i-1][j].setBlue(tempblue);
      }
    }
  }
}