package ui;

import java.util.Scanner;
import linkedlist2.Friend;
import linkedlist2.Link;
import linkedlist2.LinkedList;
import utility.Validator;

/**
 * A black book rating app.
 *
 * @author 55jphillip
 */
public class BBApp {

    LinkedList list;

    public BBApp() {
        this.list = new LinkedList();
        start();
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        String choice = "";
        while (true) {
            menu();
            String regex = "^quit|add|remove|list$";
            choice = Validator.getLine(sc, "Enter your choice: ", regex);
            if (choice.equalsIgnoreCase("quit")) {
                break;
            } else if (choice.equalsIgnoreCase("add")) {
                String name = Validator.getLine(sc, "Enter friend's name: ");
                int rating = Validator.getInt(sc, "Enter rating: ");
                list.push(new Friend(name, rating));
            } else if (choice.equalsIgnoreCase("list")) {
                System.out.println(list);
            }
        }
    }

    public void menu() {
        System.out.println("\nJohn's Black Book");
        System.out.println("Add - add a new friend");
        System.out.println("Remove - remove a friend");
        System.out.println("List - display list of friends");
        System.out.println("Name - display list of friends ordered by name");
        System.out.println("Reverse - display list of friends ordered by name descending");
        System.out.println("Rating - display list of friends ordered by rating");
        System.out.println("Search - search for a friend");
        System.out.println("Range - display friends in a range of ratings");
        System.out.println("Quit");
    }

    public static void main(String[] args) {
        BBApp app = new BBApp();
    }
}
