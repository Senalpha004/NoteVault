package noteVault;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NotevaultApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NoteManager noteManager = new NoteManager();
        noteManager.loadNotesFromFile();

        boolean exit = false;

        System.out.println("Welcome to the NoteVault");

        while (!exit) {
            System.out.println("\n Choose an option from below: ");
            System.out.println("1. Add a Note");
            System.out.println("2. View all Notes");
            System.out.println("3. Search Notes by a Keyword");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");

            System.out.println("Your Choice? ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Title? ");
                    String title = scanner.nextLine();
                    System.out.println("Content? ");
                    String content = scanner.nextLine();
                    noteManager.addNote(new Note(title, content));
                    System.out.println("Note added successfully!");
                    break;

                case "2":
                    for (Note note : noteManager.getAllNotes()) {
                        System.out.println(note);
                    }
                    break;

                case "3":
                    System.out.println("Enter a Keyword: ");
                    String keyword = scanner.nextLine();
                    System.out.println("Search Results...");
                    for (Note note : noteManager.searchNotes(keyword)) {
                        System.out.println(note);
                    }
                    break;

                case "4":
                    System.out.println("Title of the Note to delete? ");
                    String titleDelete = scanner.nextLine();
                    noteManager.deleteNote(titleDelete);
                    break;

                case "5":
                    System.out.println("Exiting the NoteVault...");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;

            }
        }
        scanner.close();
    }
}