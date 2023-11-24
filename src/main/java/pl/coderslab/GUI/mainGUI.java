package pl.coderslab.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static pl.coderslab.readAndWriteAndCreate.Create.createTaskFile.createTaskFile;

public class mainGUI {

    public static void initialGUI() {
        JFrame frame = new JFrame("Task App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setVisible(true);

        File file = new File("task.csv");

        if(!file.exists()) {
            createCVS();
        } else {
            JOptionPane.showMessageDialog(frame, "Plik task.csv został utworzony.");
        }

    }

    private static void createCVS(){

        JFrame frame = new JFrame("Task App");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Zamknięcie tego okna nie zamyka całej aplikacji
        frame.setSize(300, 200);

            try {
                if(!createTaskFile()){
                    JOptionPane.showMessageDialog(frame, "Plik task.csv nie istnieje. \n Czy chcesz go utworzyć?");
                    JButton createFileButton1 = new JButton("TAK");
                    createFileButton1.addActionListener(e -> {
                        frame.setVisible(false);
                    });


                    JButton createFileButton2 = new JButton("NIE");
                    createFileButton2.addActionListener(e -> {
                    });


                    frame.getContentPane().setLayout(new FlowLayout());
                    frame.getContentPane().add(createFileButton1);
                    frame.getContentPane().add(createFileButton2);
                    frame.setVisible(true);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Wystąpił błąd podczas tworzenia pliku." + ex, "Błąd", JOptionPane.ERROR_MESSAGE);
            }
    }
}

