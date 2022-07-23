package ru.javarush.cryptoanalyzer.petrov.ceasar;

import ru.javarush.cryptoanalyzer.petrov.consts.Alphabet;
import ru.javarush.cryptoanalyzer.petrov.function.CeasarsFunction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class CeasarListener implements ActionListener {
    private int key;
    private StringBuilder stringBuilder = new StringBuilder();
    private File inputFile;
    private File outputFile;
    @Override
    public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "SHIFT_PLUS" -> shift(1);
                case "SHIFT_MINES" -> shift(-1);
                case "FORCE_SHIFT" -> {
                    int i = 0;
                    try {
                        i = Integer.parseInt(CeasarFrame.getInstance().getWestPanel().jTextField.getText());
                    }
                    catch (NumberFormatException ex){
                        CeasarFrame.getInstance().getWestPanel().jTextField.setText("");
                    }
                    shift(i);
                    }
                    case "OPEN" -> {
                    CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.selectAll();
                    CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.replaceSelection("");
                    CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
                    CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
                    key = 0;
                    stringBuilder = null;
                    outputFile = null;
                    inputFile = null;
                    String str = openFile();
                    CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.setText(str);
                    CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.setText(str);
                    stringBuilder = new StringBuilder(str);
                    }
                    case "CLEAR" ->clearAll();
                    case "SAVE" -> saveFile();
                    case "NEW_OUT_DIR" -> changeOutDir();
            }
        }
        private void shift(int i){
        //TODO Code style. Many warnings. Skip or fix it.
            if(!"".equals(CeasarFrame.getInstance().getCenterPanel().jTextAreaIn)) {

                stringBuilder = CeasarsFunction.shift(Alphabet.correctCharacters, i, stringBuilder.toString());
                key += i;
                CeasarFrame.getInstance().getWestPanel().jLabel.setText("Ключ: " + key);
                CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.setText(stringBuilder.toString());
                CeasarFrame.getInstance().getContentPane().revalidate();
            }
        }
    private String openFile(){
        clearAll();
        StringBuilder stringBuilder = new StringBuilder();
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        jFileChooser.setCurrentDirectory(new File("./src/main/resources"));
        if(jFileChooser.showOpenDialog(CeasarFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
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
    private void saveFile(){
        String name = outputFile.getAbsolutePath();
        name = name.substring(0,name.length() - 4);
        try(FileWriter fw = new FileWriter(new File(name + "key" + key + ".txt")))
        {

            fw.write(CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.getText());
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    private void clearAll(){
        CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.selectAll();
        CeasarFrame.getInstance().getCenterPanel().jTextAreaIn.replaceSelection("");
        CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.selectAll();
        CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.replaceSelection("");
        stringBuilder = null;
        key = 0;
        outputFile = null;
        inputFile = null;
        CeasarFrame.getInstance().getWestPanel().jLabel.setText("Ключ: " +  key);
        CeasarFrame.getInstance().getContentPane().revalidate();
    }
    private void changeOutDir(){
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jFileChooser.setCurrentDirectory(new File("./src/main/resources"));
        if(jFileChooser.showOpenDialog(CeasarFrame.getInstance())==JFileChooser.APPROVE_OPTION) {
            String lastName = inputFile.getName();
            lastName = lastName.substring(0,lastName.length() - 4);
            outputFile = new File(jFileChooser.getSelectedFile() + "/" + lastName);
            System.out.println(outputFile + "key" + key + ".txt");
            try(FileWriter fw = new FileWriter(new File( outputFile + "key" + key + ".txt")))
            {

                fw.write(CeasarFrame.getInstance().getCenterPanel().jTextAreaOut.getText());
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
