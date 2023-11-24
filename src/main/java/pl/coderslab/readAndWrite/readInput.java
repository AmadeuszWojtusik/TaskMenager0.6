package pl.coderslab.readAndWrite;

import pl.coderslab.Colors.ConsoleColors;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class readInput {

    /** SPRAWDZA CZY DOUBLE**/
    public static double readDouble(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextDouble()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextDouble();
    }

    /** SPRAWDZA CZY FLOAT **/
    public static float readFloat(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextFloat()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextFloat();
    }

    /** SPRAWDZA CZY SHORT **/
    public static short readShort(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextShort()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextShort();
    }

    /** SPRAWDZA CZY BYTE **/
    public static byte readByte(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextByte()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextByte();
    }

    /** SPRAWDZA CZY INT **/
    public static int readInt(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextInt()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextInt();
    }

    /** SPRAWDZA CZY LONG **/
    private static long readLong(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextLong()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextLong();
    }

    /** SPRAWDZA CZY BOOL **/
    public static boolean readBolean(String message, Scanner scan ) {
        System.out.println(message);
        while (!scan.hasNextBoolean()) {
            scan.next();
            System.out.println(ConsoleColors.RED + "Nieprawidłowa liczba. Wypisz ponownie: " + ConsoleColors.RESET);
        }
        return scan.nextBoolean();
    }

    /** SPRAWDZA CZY BOOL TEKSTOWY **/
    public static String readBoleanString(String message, Scanner scan ) {
        System.out.println(message);
        String trueOrFalse = scan.next();
        while (true) {
            if (trueOrFalse.contains("true") || trueOrFalse.contains("false")) {
                break;
            } else {
                System.out.println(ConsoleColors.RED + "Nieprawidłowa wartość. Wypisz ponownie.\n " + ConsoleColors.RESET + message);
                trueOrFalse = scan.next();
            }
        }
        return trueOrFalse;
    }

    /** SPRAWDZA CZY DATA YYYY-MM-DD**/
    public static String readStringDate1(String message, Scanner scan ) {
        System.out.println(message);
        String Data = scan.next();
        while (true) {
            try {
                SimpleDateFormat DAT = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = DAT.parse(Data);
                break;
            } catch (Exception e){
                System.out.println(ConsoleColors.RED + "Nieprawidłowa wartość. Wypisz ponownie.\n " + ConsoleColors.RESET + message);
                Data = scan.next();
            }


        }
        return Data;
    }
}
