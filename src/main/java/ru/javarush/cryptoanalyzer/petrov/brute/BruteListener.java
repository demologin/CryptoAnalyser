package ru.javarush.cryptoanalyzer.petrov.brute;

import ru.javarush.cryptoanalyzer.petrov.ceasar.CeasarFrame;
import ru.javarush.cryptoanalyzer.petrov.consts.Alphabet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
public class BruteListener implements ActionListener {
    int key = 0;
    private StringBuilder stringBuilder = new StringBuilder();
    private File inputFile;
    private File outputFile;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "OPEN" -> {
                BruteFrame.getInstance().getCenterPanel().jTextAreaIn.selectAll();
                BruteFrame.getInstance().getCenterPanel().jTextAreaIn.replaceSelection("");
                BruteFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
                BruteFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
                stringBuilder = null;
                outputFile = null;
                inputFile = null;
                String str = openFile();
                stringBuilder = new StringBuilder(str);
                BruteFrame.getInstance().getCenterPanel().jTextAreaIn.setText(str);
                BruteFrame.getInstance().getCenterPanel().jTextAreaOut.setText(str);
            }
            case "CLEAR" -> clearAll();
            case "SAVE" -> saveFile();
            case "NEW_OUT_DIR" -> changeOutDir();
            case "FIND" -> {
                int i = findKey(Alphabet.correctCharacters, BruteFrame.getInstance().getSouthPanel().jTextField.getText(), stringBuilder.toString());
                if(i == Integer.MAX_VALUE){
                    BruteFrame.getInstance().getSouthPanel().key.setText(String.valueOf("Ключ не найден"));
                    return;
                }
                stringBuilder = shift(Alphabet.correctCharacters, -i, stringBuilder.toString());
                BruteFrame.getInstance().getSouthPanel().key.setText(String.valueOf("Ключ" + i));
                BruteFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
                BruteFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
                BruteFrame.getInstance().getSouthPanel().jTextField.setText("");
                BruteFrame.getInstance().getCenterPanel().jTextAreaOut.setText(stringBuilder.toString());
                stringBuilder = new StringBuilder("");
                BruteFrame.getInstance().revalidate();
                BruteFrame.getInstance().repaint();
            }
        }
    }

    private String openFile() {
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setCurrentDirectory(new File("./src/main/resources"));
        if (jFileChooser.showOpenDialog(BruteFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            inputFile = file;
            String str;
            try (BufferedReader br = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
                while ((str = br.readLine()) != null) {
                    stringBuilder.append(str);
                }
            } catch (IOException ex) {
                inputFile = null;
                ex.printStackTrace();
            }
            outputFile = inputFile;
        }
        return stringBuilder.toString();
    }

    private void saveFile() {
        String name = outputFile.getAbsolutePath();
        name = name.substring(0, name.length() - 4);
        try (FileWriter fw = new FileWriter(new File(name + "force" + key + ".txt"))) {

            fw.write(BruteFrame.getInstance().getCenterPanel().jTextAreaOut.getText());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private void clearAll() {
        BruteFrame.getInstance().getCenterPanel().jTextAreaIn.selectAll();
        BruteFrame.getInstance().getCenterPanel().jTextAreaIn.replaceSelection("");
        BruteFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
        BruteFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
        stringBuilder = null;
        key = 0;
        outputFile = null;
        inputFile = null;
        BruteFrame.getInstance().getSouthPanel().key.setText("Ключ");
    }

    private void changeOutDir() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setCurrentDirectory(new File("./src/main/resources"));
        if (jFileChooser.showOpenDialog(BruteFrame.getInstance()) == JFileChooser.APPROVE_OPTION) {
            String lastName = inputFile.getName();
            lastName = lastName.substring(0, lastName.length() - 4);
            outputFile = new File(jFileChooser.getSelectedFile() + "/" + lastName);
            try (FileWriter fw = new FileWriter(new File(outputFile + "force" + key + ".txt"))) {
                System.out.println(outputFile + "force" + key + ".txt");
                fw.write(CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.getText());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private int findKey(int[] alphabet, String charSequence, String txt) {
        int i = 0;
        while (i < alphabet.length) {
            String nextCharSequence = shift(alphabet, i, charSequence).toString();
            if (txt.contains(nextCharSequence)) {
                return i;
            }
            i++;
        }
        return Integer.MAX_VALUE;
    }

    public static StringBuilder shift(int[] offsetCharacters, int range, String inputStr) {
        Arrays.sort(offsetCharacters);
        StringBuilder stringBuilder = new StringBuilder(inputStr);
        if (offsetCharacters.length == range) {
            return stringBuilder;
        }
        if (Math.abs(range) > offsetCharacters.length) {
            range = range % offsetCharacters.length;
        }
        int indexInOffset;
        int currentChar;
        int newChar;
        for (int i = 0; i < stringBuilder.length(); ++i) {
            currentChar = stringBuilder.charAt(i);
            indexInOffset = Arrays.binarySearch(offsetCharacters, currentChar);
            if (indexInOffset < 0 || offsetCharacters.length <= indexInOffset) {
                continue;
            }
            if (indexInOffset + range < 0) {
                newChar = offsetCharacters.length + indexInOffset + range;
            } else if (indexInOffset + range >= offsetCharacters.length) {
                newChar = -offsetCharacters.length + indexInOffset + range;
            } else {
                newChar = indexInOffset + range;
            }
            stringBuilder.setCharAt(i, (char) offsetCharacters[newChar]);
        }
        return stringBuilder;
    }

}


