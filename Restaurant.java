//Timothy Keenan

/*
   Restaurant class that holds information about the restaurant.
   name - Stores the name of the restaurant
   menuSize - The number of items on the menu
   menuItems - The names of the items on the menu
*/

public class Restaurant {

   //Declare variables
   private String name;
   private int menuSize;
   private String[] menuItems; 
   
   //Setup constructors
   public Restaurant() {
      name = "";
      menuSize = 0;
      menuItems = new String[menuSize];
   }
   //Non-default constructor
   public Restaurant(String rName,  int rMenuSize, String[] rMenuItems) {
      name = rName;
      menuSize = rMenuSize;
      menuItems = rMenuItems;
   }
   
   //Accessors
   public String getName() {
      return name;
   }
   public int getMenuSize() {
      return menuSize;
   }
   public String[] getMenuItems() {
      return menuItems;
   }
   
   //Setters (Although I am not sure if they will be needed
   public void setName(String rName) {
      name = rName;
   }
   public void setMenuSize(int rMenuSize) {
      menuSize = rMenuSize;
   }
   public void setMenuItems(String[] rMenuItems) {
      menuItems = rMenuItems;
   } 
}