package pl.coderslab.readAndWriteAndCreate;
import pl.coderslab.Colors.ConsoleColors;
import pl.coderslab.Sleeps.sleepTime;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class writeFile {


    /** TABLICA JEDNOWYMIAROWA Z OZDOBAMI **/
    public static void writeFromTableXOneColors(String[] words, Scanner scan, boolean WithPath, String StaticPath, boolean WetherOverwrite, boolean SaveLine){

    /** JEŻELI Z PYTANIEM O LOKALIZACJE **/
        if (WithPath){
            System.out.println("Podaj ścieżkę zapisu oraz nazwę pliku z rozszerzeniem.");
            String PathSave = scan.next();
            while (true) {
            /** JEŻELI MAM PYTAĆ CZY NADPISAĆ PLIK **/
                if (WetherOverwrite) {
                    File f = new File(PathSave);
                    if(f.exists() && !f.isDirectory()) {
                        System.out.println(ConsoleColors.YELLOW + "Taki plik już istnieje!\nCzy na pewno chcesz go nadpisać?\n TAK       NIE" + ConsoleColors.RESET);
                        String YesOrNot = scan.next();
                        while (true) {
                            if (YesOrNot.contains("NIE")) {
                                System.out.println("Podaj nową ścieżkę z nazwą:");
                                PathSave = scan.next();
                            } else if (YesOrNot.contains("TAK")) {
                                break;
                            } else {
                                System.out.println("Wybież poprawną opcję.\nTAK  lub  NIE");
                            }
                        }
                    }
                }

                try (FileWriter write = new FileWriter(String.valueOf(scan), SaveLine)) {
                    sleepTime.sleep("Trwa zapisywanie...", 2000, ConsoleColors.GREEN_BOLD + "Zapisywanie zakończone sukcesem." + ConsoleColors.RESET);
                    for (String line : words) {
                        write.append(line).append("\n");
                    }
                    break;
                } catch (IOException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Nieprawidłowa ścieżka zapisu pliku!\nSprubuj jeszcze raz!" + ConsoleColors.RESET);
                }
            }
        }else {
                try (FileWriter write = new FileWriter(StaticPath, true)) {
                    sleepTime.sleep("Trwa zapisywanie...", 2000, ConsoleColors.GREEN_BOLD + "Zapisywanie zakończone sukcesem." + ConsoleColors.RESET);
                    for (String line : words) {
                        write.append(line).append("\n");
                    }
                } catch (IOException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Problem z zapisem do pliku. Nieprawidłowa ścieżka lub uszkodzony plik" + ConsoleColors.RESET);
                }


        }

    }

    /** TABLICA JEDNOWYMIAROWA BEZ **/
    public static void writeFromTableXOne(String[] words, Scanner scan, boolean WithPath, String StaticPath, boolean WetherOverwrite, boolean SaveLine){

        /** JEŻELI Z PYTANIEM O LOKALIZACJE **/
        if (WithPath){
            System.out.println("Podaj ścieżkę zapisu oraz nazwę pliku z rozszerzeniem.");
            String PathSave = scan.next();
            while (true) {
                /** JEŻELI MAM PYTAĆ CZY NADPISAĆ PLIK **/
                if (!WetherOverwrite) {
                    File f = new File(PathSave);
                    if(f.exists() && !f.isDirectory()) {
                        System.out.println(ConsoleColors.YELLOW + "Taki plik już istnieje!\nCzy na pewno chcesz go nadpisać?\n TAK       NIE" + ConsoleColors.RESET);
                        String YesOrNot = scan.next();
                        while (true) {
                            if (YesOrNot.contains("NIE")) {
                                System.out.println("Podaj nową ścieżkę z nazwą:");
                                PathSave = scan.next();
                                break;
                            } else if (YesOrNot.contains("TAK")) {
                                break;
                            } else {
                                System.out.println("Wybież poprawną opcję.\nTAK  lub  NIE");
                            }
                        }
                    }
                }

                try (FileWriter write = new FileWriter(String.valueOf(scan), SaveLine)) {
                    for (String line : words) {
                        write.append(line).append("\n");
                    }
                    break;
                } catch (IOException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Nieprawidłowa ścieżka zapisu pliku!\nSprubuj jeszcze raz!" + ConsoleColors.RESET);
                }
            }
        }else if (!WetherOverwrite) {
            /** JEŻELI MAM PYTAĆ CZY NADPISAĆ PLIK **/
                File f = new File(StaticPath);
                if(f.exists() && !f.isDirectory()) {
                    System.out.println(ConsoleColors.YELLOW + "Taki plik już istnieje!\nCzy na pewno chcesz go nadpisać?\n TAK       NIE" + ConsoleColors.RESET);
                    String YesOrNot = scan.next();
                    while (true) {
                        if (YesOrNot.contains("NIE")) {
                            System.out.println("Podaj nową nazwę z rozszeżeniem:");
                            StaticPath += scan.next();
                            break;
                        } else if (YesOrNot.contains("TAK")) {
                            break;
                        } else {
                            System.out.println("Wybież poprawną opcję.\nTAK  lub  NIE");
                        }
                    }
                }
            try (FileWriter write = new FileWriter(StaticPath, true)) {
                for (String line : words) {
                    write.append(line).append("\n");
                }
            } catch (IOException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Problem z zapisem do pliku. Nieprawidłowa ścieżka lub uszkodzony plik" + ConsoleColors.RESET);
            }


        } else {
            try (FileWriter write = new FileWriter(StaticPath, true)) {
                for (String line : words) {
                    write.append(line).append("\n");
                }
            } catch (IOException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Problem z zapisem do pliku. Nieprawidłowa ścieżka lub uszkodzony plik" + ConsoleColors.RESET);
            }
        }

    }

    /** TABLICA DWUWYMIAROWA BEZ **/
    public static void writeFromTabbleXTwo(String[][] words, Scanner scan, boolean WithAskPath, String StaticPath, boolean WetherOverwrite, boolean SaveLine) {

 /** ==============JEŻELI Z PYTANIEM O LOKALIZACJE ================**/
        if (WithAskPath){
            System.out.println("Podaj ścieżkę zapisu oraz nazwę pliku z rozszerzeniem.");
            String PathSave = scan.next();
            while (true) {
 /** =================== JEŻELI MAM PYTAĆ CZY NADPISAĆ PLIK=========================== **/
                if (!WetherOverwrite) {
                    File f = new File(PathSave);
                    if(f.exists() && !f.isDirectory()) {
                        System.out.println(ConsoleColors.YELLOW + "Taki plik już istnieje!\nCzy na pewno chcesz go nadpisać?\n TAK       NIE" + ConsoleColors.RESET);
                        String YesOrNot = scan.next();
                        while (true) {
                            if (YesOrNot.contains("NIE")) {
                                System.out.println("Podaj nową ścieżkę z nazwą:");
                                PathSave = scan.next();
                                break;
                            } else if (YesOrNot.contains("TAK")) {
                                break;
                            } else {
                                System.out.println("Wybież poprawną opcję.\nTAK  lub  NIE");
                            }
                        }
                    }
                }

                try (FileWriter write = new FileWriter(String.valueOf(scan), SaveLine)) {
                    for (String[] line : words) {
                        for (String lineline : line) {
                            write.append(lineline + ",");
                        }
                        write.append("\n");
                    }
                    break;
                } catch (IOException e) {
                    System.out.println(ConsoleColors.RED_BOLD + "Nieprawidłowa ścieżka zapisu pliku!\nSprubuj jeszcze raz!" + ConsoleColors.RESET);
                }
            }
        }else if (!WetherOverwrite) {

/** =================JEŻELI MAM PYTAĆ CZY NADPISAĆ PLIK NA STAŁEJ ŚCIEŻCE====================**/
            File f = new File(StaticPath);
            if(f.exists() && !f.isDirectory()) {
                System.out.println(ConsoleColors.YELLOW + "Taki plik już istnieje!\nCzy na pewno chcesz go nadpisać?\n TAK       NIE" + ConsoleColors.RESET);
                String YesOrNot = scan.next();
                while (true) {
                    if (YesOrNot.contains("NIE")) {
                        System.out.println("Podaj nową nazwę z rozszeżeniem:");
                        StaticPath += scan.next();
                        break;
                    } else if (YesOrNot.contains("TAK")) {
                        break;
                    } else {
                        System.out.println("Wybież poprawną opcję.\nTAK  lub  NIE");
                    }
                }
            }
            try (FileWriter write = new FileWriter(StaticPath, true)) {
                for (String[] line : words) {
                    for (String lineline : line) {
                        write.append(lineline + ",");
                    }
                    write.append("\n");
                }
            } catch (IOException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Problem z zapisem do pliku. Nieprawidłowa ścieżka lub uszkodzony plik" + ConsoleColors.RESET);
            }

/** ======================== POPROSTU ZAPISUJĘ I TYLE =========================*/
        } else {
            try (FileWriter write = new FileWriter(StaticPath, SaveLine)) {
                for (String[] line : words) {
                    for (String lineline : line) {
                        write.append(lineline + ",");
                    }
                    write.append("\n");
                }
            } catch (IOException e) {
                System.out.println(ConsoleColors.RED_BOLD + "Problem z zapisem do pliku. Nieprawidłowa ścieżka lub uszkodzony plik" + ConsoleColors.RESET);
            }
        }
    }
}
