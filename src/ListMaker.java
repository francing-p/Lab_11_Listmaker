import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    static ArrayList<String> list = new ArrayList<>();
    static String item ="";
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String menuChoice = "";
        boolean confirm = false;
        displayList();
        do {
            // PICK CHOICE
            menuChoice = SafeInput.getRegExString(in,"What would you like to do?","[AaDdIiPpQq]");
            // IF CHOICE IS QUIT, ENSURE USER WANTS TO DO SO
            if (menuChoice.equalsIgnoreCase("A")) {
                addItem(in);
            }
            else if (menuChoice.equalsIgnoreCase("D")){
                deleteItem();;
            }
            else if (menuChoice.equalsIgnoreCase("I")){
                updItem(in);
            }
            else if (menuChoice.equalsIgnoreCase("P")){
                printList();
            }
            else if (menuChoice.equalsIgnoreCase("Q")){
                confirm = SafeInput.getYNConfirm(in,"Are you sure? [Y/N] ");
                if (!confirm){
                    menuChoice = ""; // resets menu choice if user says no
                }
                else{
                    System.out.println("Quitting...");
                }
                }
        }
        // KEEP GOING THROUGH MENU UNTIL USER QUITS
        while(!menuChoice.equalsIgnoreCase("Q"));
    }

    // -------------- UTILITY METHODS -------------
    private static void displayList(){
        // display current list
        for(String item : list){
            System.out.println("Index: " + list + "Item:" + item);
        }
        System.out.println(); // extra space
        // menu options
        System.out.println("Your options are:");
        System.out.println("A – Add an item to the list\n" +
                "D – Delete an item from the list\n" +
                "I – Insert an item into the list\n" +
                "P – Print (i.e. display) the list\n" +
                "Q – Quit the program\n");
    }

    // ------------- METHODS FOR EACH OPTION -----------
    private static void addItem(Scanner pipe){
        System.out.print("What would you like to add? ");
        if (pipe.hasNextLine()){
            item = pipe.nextLine();
            list.add(item);
        }

    }

    private static void deleteItem(){
        int index = 0;
        for(String item : list){
            System.out.println("Index: " + (index++)  + " Item: " + item);
        }
        index = SafeInput.getRangedInt(in,"Which index would you like to delete? ",0,list.size());
        list.remove(index);
        in.nextLine();
    }

    private static void updItem(Scanner pipe) {
        int index = 0;
        for(String item : list){
            System.out.println("Index: " + (index++)  + " Item: " + item);
        }
        index = SafeInput.getRangedInt(in, "Which index would you like to update? ", 0, list.size());
        in.nextLine();
        System.out.print("What would you like to insert? ");
        if (pipe.hasNextLine()) {
            item = pipe.nextLine();
        }
        list.add(index, item);
    }

    private static void printList(){
        int index = 0;
        for(String item : list){
            System.out.println("Index: " + (index++)  + " Item: " + item);
        }
    }


}
