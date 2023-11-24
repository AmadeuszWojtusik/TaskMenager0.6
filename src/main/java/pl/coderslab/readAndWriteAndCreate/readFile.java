package pl.coderslab.readAndWriteAndCreate;

import pl.coderslab.Colors.ConsoleColors;
import pl.coderslab.Sleeps.sleepTime;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

//Niebawem przeniesienie wszystkiego na java.nio.*
public class readFile {

    /** TABLICA JEDNOWYMIAROWA Z OZDOBAMI **/ //DO POPRAWY
    public static String[] fileToTableXOneColor(String PathRead, Scanner scan) {

            while (true) {
                File file = new File(PathRead); //Pobieram ścieżkę do pliku.

                try (Scanner scan2 = new Scanner(file)) {
                    sleepTime.sleep(ConsoleColors.GREEN_BOLD + "Udało się wczytać plik, przetwarzam..." + ConsoleColors.RESET, 2000, "");

                    String[] line = new String[1];

                    //Wpakowuję do tabeli
                    for (int i = 0; scan2.hasNextLine(); i++) {
                        line = Arrays.copyOf(line, line.length + 1);
                        line[i] = scan2.nextLine();
                    }
                    return line;
                } catch (FileNotFoundException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Brak Pliku, podana ścieżka jest nieprawidłowa.\n Podaj ją jeszcze raz!" + ConsoleColors.RESET);
                }
            }
    }

    /** TABLICA JEDNOWYMIAROWA BEZ **/ //DO POPRAWY
    public static String[] fileToTableXOne(String PathRead, Scanner scan) {

        while (true) {
            File file = new File(PathRead);

            try (Scanner scan2 = new Scanner(file)) {

                String[] line = new String[1];

                //Wpakowuję do tabeli
                for (int i = 0; scan2.hasNextLine(); i++) {
                    line = Arrays.copyOf(line, line.length + 1);
                    line[i] = scan2.nextLine();
                }
                return line;
            } catch (FileNotFoundException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Brak Pliku, podana ścieżka jest nieprawidłowa.\n Podaj ją jeszcze raz!" + ConsoleColors.RESET);
            }
        }
    }

    /** ======TABLICA DWUWYMIAROWA BEZ ===========**/
    public static String[][] fileToTableXTwo(String PathRead, Scanner scan) {

/**============ CZY PLIK ISTNIEJE ==============**/
            Path file = Paths.get(PathRead);
            if (!Files.exists(file)) {
                System.out.println(ConsoleColors.RED_BOLD + "Brak Pliku, podana ścieżka jest nieprawidłowa." + ConsoleColors.RESET);
                System.exit(0);
            }
/** ============JEŻELI TAK TO ROBIMY WPIS DO TABLICY ==========**/

        String[][] tab = null;
                try {
                    List<String> line = Files.readAllLines(file);
                    tab = new String[line.size()][line.get(0).split(",").length];

                    // Wpakowuję do tabeli
                    // W sumie to rozwiązanie jest lepsze od tego co wcześniej namodziłem.
                    for (int i = 0; i < line.size(); i++) {
                        String[] split = line.get(i).split(",");
                        for (int j = 0; j < split.length; j++) {
                            tab[i][j] = split[j];
                        }
                    }
                    //ZOSTAWIĆ, TESTY
                }/* catch (FileNotFoundException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Brak Pliku, podana ścieżka jest nieprawidłowa.\n Podaj ją jeszcze raz!\nJeżeli widzisz ten błąd skontaktój się z supportem." + ConsoleColors.RESET);
                }*/ catch (IOException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Brak Pliku, plik uszkodzony lub podana ścieżka jest nieprawidłowa.\n Podaj ją jeszcze raz!\nJeżeli widzisz ten błąd skontaktój się z supportem." + ConsoleColors.RESET);
                    System.exit(0);
                }
                return tab;/** TUTAJ KONIEC **/
        /** JEŻELI WYSTĄPI JAKIŚ BŁĄD W ODCZYCIE TO PUSTA TABLICA NIGDY NIE ZOSTANIE ZWRUCONA  **/
        }
}
