import org.code.theater.*;
import org.code.media.*;

public class MyStory extends Scene {

  /* 
   * Instance variables to store data about the visualization:
   * - foodIntro: Title or introduction text
   * - favoriteFoods: 2D array of favorite food names
   * - foodsToTry: 2D array of foods the user wants to try
   * - favFoodImages: 2D array of ImageFilter objects for favorite foods
   * - tryFoodImages: 2D array of ImageFilter objects for foods to try
   */
  private String[] foodIntro;
  private String[][] favoriteFoods;
  private String[][] foodsToTry;
  private ImageFilter[][] favFoodImages;
  private ImageFilter[][] tryFoodImages;  

  /*
   * Constructor for the MyStory class
   * Initializes all instance variables with the provided arrays
   */
  public MyStory(String[] foodIntro, String[][] favoriteFoods, String[][] foodsToTry, ImageFilter[][] favFoodImages, ImageFilter[][] tryFoodImages) {
    this.foodIntro = foodIntro;
    this.favoriteFoods = favoriteFoods;
    this.foodsToTry = foodsToTry;
    this.favFoodImages = favFoodImages;
    this.tryFoodImages = tryFoodImages;
  }
  
/*
   * Main method that calls all sub-scene methods in order
   * This method determines the sequence of the visualization
   */
  public void drawScene() {
    drawFavoriteFoodIntro();  
    drawAllFavoriteFoods();
    drawFoodsToTryIntro();
    drawAllFoodsToTry();
}

  /*
   * Displays the title for the "Favorite Foods" section
   * - Sets the background color
   * - Styles and displays the text
   * - Plays an intro sound
   */
  public void drawFavoriteFoodIntro(){
   playSound("90_Em_BarPiano_03_575.wav"); 
    clear("pink");
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
   drawText("My Favorite Foods", 50, 40);
    pause(1.5);
 }

   /*
   * Iterates through the 2D array of favorite foods
   * - Calls drawFavoriteFoodScene to display the food name and image
   * - Applies filters to each image
   */
  public void drawAllFavoriteFoods() {
    for (int row = 0; row < favoriteFoods.length; row++) {
        for (int col = 0; col < favoriteFoods[row].length; col++) {
            drawFavoriteFoodScene(row, col);
            applyFilters(favFoodImages[row][col], 50, 120, 250);
        }
    }
}

 /*
   * Displays the title for the "Foods I Want to Try" section
   * - Sets the background color
   * - Styles and displays the text
   */
  public void drawFoodsToTryIntro(){
    clear("pink");
    setTextHeight(30);
    setTextColor("white");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("Foods I Want to Try", 50, 40);
    pause(1.5);
 }

 /*
   * Iterates through the 2D array of foods to try
   * - Calls drawTryFoodScene to display the food name and image
   * - Applies filters to each image
   */
  public void drawAllFoodsToTry() {
    for (int row = 0; row < foodsToTry.length; row++) {
        for (int col = 0; col < foodsToTry[row].length; col++) {
            drawTryFoodScene(row, col);
            applyFilters(tryFoodImages[row][col], 50, 120, 250);
        }
    }
}

 /*
   * Applies multiple filters to an image sequentially
   * - Applies negative, emboss, colorize, and flip effects
   * - Displays the image after each filter application
   * - Pauses after each step for a smoother transition
   */
  public void applyFilters(ImageFilter image, int x, int y, int size) {
    pause(1);
    image.makeNegative();
    drawImage(image, x, y, size);
    pause(1);
    image.emboss();
    drawImage(image, x, y, size);
    pause(1);
    image.colorize();
    drawImage(image, x, y, size);
    pause(1);
    image.flipupsidedown();
    drawImage(image, x, y, size);
    pause(1);
  }

  /*
   * Displays an individual favorite food scene
   * - Changes the background color based on the food's position
   * - Displays the food name with custom styling
   * - Draws the corresponding food image
   */
  public void drawFavoriteFoodScene(int row, int col) {
    String[] colors = {"blue", "green", "purple", "yellow"};
    clear(colors[(row * 2 + col) % colors.length]);

    setTextColor("white");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextHeight(45);
    drawText(favoriteFoods[row][col], 60, 70);

    drawImage(favFoodImages[row][col], 50, 120, 250);
  }

/*
   * Displays an individual "food to try" scene
   * - Changes the background color based on the food's position
   * - Displays the food name with custom styling
   * - Draws the corresponding food image
   */
  public void drawTryFoodScene(int row, int col) {
    String[] colors = {"blue", "green", "purple", "yellow"};
    clear(colors[(row * 2 + col) % colors.length]);

    setTextColor("white");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextHeight(35);
    drawText(foodsToTry[row][col], 30, 45);

    drawImage(tryFoodImages[row][col], 50, 120, 250);
  }
}