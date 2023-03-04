//package pl.coderslab;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class main {

    //==================================TABELA Z MENU I ŚCIEŻKA========================================
    static final String Path = "tasks.csv";
    static final String[] options = {"add", "remove", "list", "exit"}; //To rozwiązanie może być nawet lepsze.
    //==============================================================================================
    static Scanner scan = new Scanner(System.in);
    static String[][] tasks = readFile.fileToTableXTwo(Path, scan);
    public static void main(String[] args) {

        //String[][] tasks = readFile.fileToTableXTwo(Path, scan);

        boolean exit = false;

        while (!exit) {
            optionsPrint(options);
            String option = scan.next();

            switch (option) {
                case "add":
                    addTask();
                    break;
                case "remove":
                    deleteTask(true);
                    break;
                case "list":
                    printList();
                    break;
                case "exit":
                    writeFile.writeFromTabbleXTwo(main.tasks,scan,false,Path,true,false);
                    exit = true;
                    break;
                default:
                    System.out.println("This options is not exist.");
            }
        }
    }

    /** ============= MENU WYBORU OPCJI ============ **/
    public static void optionsPrint(String[] tab) {
        System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
        for (String option : tab) {
            System.out.println(option);
        }
    }

    /** ============= WYŚWIETLANIE LISTY ============ **/
    public static void printList() {
        for (int i = 0; i < main.tasks.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < main.tasks[i].length; j++) {
                System.out.print(main.tasks[i][j] + " ");
            }
            System.out.println();
        }
    }

    /** ============ DODAWANIE ZADANIA ============== **/
    public static void addTask() {
        main.tasks = Arrays.copyOf(main.tasks, main.tasks.length + 1);
        main.tasks[main.tasks.length-1] = new String[3]; //tego wałśnie brakowao
        System.out.println("Please add task description");
        main.tasks[main.tasks.length-1][0] = scan.next();
        main.tasks[main.tasks.length-1][1] = readInput.readStringDate1("Please add task due date YYYY-MM-DD", main.scan);
        main.tasks[main.tasks.length-1][2] = readInput.readBoleanString("Is your task important: true/false", main.scan);


    }

    /** ============ USUWANIE ZADANIA ============== **/
    public static void deleteTask(boolean twoStepsDeleting) {
        while (true) {
            short numberOfTask = readInput.readShort("\nPlease select number to remove.\nSelect -1 to stop removing", scan);
            if (numberOfTask < -1 || numberOfTask > (main.tasks.length - 1)) {
                System.out.print("This index is not exist!\nTis isn number of index: 0 - " + (main.tasks.length - 1));
            } else if (numberOfTask == -1) {
                System.out.println("Deleting stop.");
                break;
            } else if (twoStepsDeleting) {
                System.out.println("Are you sure?");
                while (true) {
                    System.out.println(ConsoleColors.RED_BOLD + "YES" + ConsoleColors.RESET + "  OR  " + ConsoleColors.GREEN_BOLD + "NO" + ConsoleColors.RESET);
                    String yesOrNot = scan.next();
                    if (yesOrNot.contains("YES")) {
                        main.tasks = ArrayUtils.remove(main.tasks, numberOfTask);
                        System.out.println("Removing successful!");
                        break;
                    } else if (yesOrNot.contains("NO")) {
                        System.out.println("Deleting stop.");
                        break;
                    } else {
                        System.out.println("This options is not exist !\nTry again.");
                    }
                }
                break;
            }else {
                main.tasks = ArrayUtils.remove(main.tasks, numberOfTask);
                break;
            }
        }

    }
}