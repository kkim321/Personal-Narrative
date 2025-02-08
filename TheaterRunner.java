import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
  public static void main(String[] args) {


/* 
     * Titles for the scenes
     * title1 represents the title for the favorite foods section
     * title represents the title for foods the user wants to try
     */
  String[] title1 = {"My Favorite Foods"};
  String[] title = {"Foods I Want To Try"};

    /* 
     * 2D Array: favoriteFoods
     * Stores the names of the user's favorite foods in a 2D array format
     */

    // 2D Array: Artists
    String[][] favoriteFoods = {
      {"Pho", "Sushi"},
      {"KKBQ", "Kimchi Stew"}
    };

     /* 
     * 2D Array: foodsToTry
     * Stores the names of foods the user wants to try in a 2D array format
     */

    String[][] foodsToTry = {
      {"Birria Tacos", "Chicken Tikki Masala"},
      {"Banh Mi", "Poutine"}
    };

     /* 
     * 2D Array: favFoodImages
     * Stores ImageFilter objects for each of the favorite foods
     * Each ImageFilter is created with a corresponding image file name
     */
   
    ImageFilter[][] favFoodImages = {
      {new ImageFilter("pho.jpeg"), new ImageFilter("sushi.jpeg")},
      {new ImageFilter("kbbq.jpeg"), new ImageFilter("kimichistew.jpeg")},
    };

    /* 
     * 2D Array: tryFoodImages
     * Stores ImageFilter objects for each of the foods the user wants to try
     * Each ImageFilter is created with a corresponding image file name
     */
      ImageFilter[][] tryFoodImages = {
      {new ImageFilter("birriatacos.jpg"), new ImageFilter("chickentikkimasala.jpeg")},
      {new ImageFilter("banh-mi.jpg"), new ImageFilter("poutine.jpg")},
    };
      
    
    MyStory scene = new MyStory(title, favoriteFoods, foodsToTry, favFoodImages, tryFoodImages);
    
    // Call drawScene
    scene.drawScene();
    
    // Play scene in Theater
    Theater.playScenes(scene);
  }
}