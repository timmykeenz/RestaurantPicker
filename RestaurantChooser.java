//Timothy Keenan
/*
   This project chooses a restaurant for those of us who may be
   indecisive at making decisions.  It grabs input from a file
   to generate the restaurants and menus.  It also chooses
   an item on the menu for each person to order.
*/

import java.util.*;
import java.io.*;

class RestaurantChooser {
   //Main
   public static void main(String[] args) {
      //Choose file to open containing restaurant data
      Restaurant[] restaurants = openFile("C:\\Users\\Tim\\OneDrive - sjfc.edu\\Business V2\\GitHub Programs\\fastFood.txt");
      
      //Create scanner and declare variables
      Scanner keyboard = new Scanner(System.in);
      int peopleEating;
      int restaurantToEat;
      String[] menuItems;
      Random rand = new Random();
      boolean done = false;
      
      System.out.println("Welcome to my fancy restaurant chooser!");
      //Loop to get the correct input
      while (!done) {
         //Print menu
         try {
            System.out.print("Enter the number of people going to grab food: ");
            peopleEating = keyboard.nextInt();
            //Make sure the number is reasonable, if not, throw an exception and try again
            if (peopleEating < 1 || peopleEating > 50)
               throw new Exception("Please enter a valid integer between 1 and 50.");
            //Pick the restaurant
            restaurantToEat = rand.nextInt(restaurants.length);
            //Now that we have the restaurant, let's pick their meal
            System.out.println("Restaurant of this program's choice: " + restaurants[restaurantToEat].getName());
            for (int i = 0; i < peopleEating; i++) {
               //Grab the menuItems
               menuItems = restaurants[restaurantToEat].getMenuItems();
               System.out.println("Person " + (i+1) + " should order a " + menuItems[rand.nextInt(menuItems.length)] + ".");
            } 
            //Finish the loop as everything ran successful
            done = true;
         }
         //Catch if the user enters a string instead of an integer
         catch (InputMismatchException e) {
            System.out.println("Please enter a number in integer form. (Ex: 1, 2, 3, etc.)");
            //Clear buffer
            keyboard.next();
         }
         //Catch invalid integers
         catch (Exception e) {
            System.out.println(e.getMessage());
         }
         
      }
   }
   //This function opens the file, reads in the restaurants, and returns the Restaurant objects
   public static Restaurant[] openFile(String file) {
      //Setup variables
      int numOfRestaurants;
      String name;
      int menuSize;
      String[] menuItems;
      //Setup scanner and try to open file
      try {
         Scanner scan = new Scanner(new File(file));
         scan.next();
         //Get number of restaurants and setup Restaurant objects
         numOfRestaurants = scan.nextInt();
         Restaurant[] placesToEat = new Restaurant[numOfRestaurants];
         //Loop through each restaurant following the template structure provided (See template.txt)
         scan.nextLine();
         scan.nextLine();
         for (int i = 0; i < numOfRestaurants; i++) {
            //Get restaurant name
            scan.next();
            name = scan.nextLine();
            scan.next();
            menuSize = scan.nextInt();
            scan.nextLine();
            
            //Loop through each menu item
            menuItems = new String[menuSize];
            for (int j = 0; j < menuSize; j++)
               menuItems[j] = scan.nextLine();
            
            //Make sure it doesn't try going past the end of file
            if (i != numOfRestaurants - 1)
               scan.nextLine();
            
            //Setup restaurant object
            placesToEat[i] = new Restaurant(name, menuSize, menuItems);
         }
         //Close the file
         scan.close();
         //Return the restaurant object array
         return placesToEat;
      }
      //Catch file not found exception as Java is really picky about exception handling for files
      catch (FileNotFoundException e) {
         System.out.println("File was not found.");
      }
      //Catch all the other issues that could come up
      catch (Exception e) {
         System.out.println("Something went wrong...");
      }
      //if something went wrong, return null
      return null;
   }
}