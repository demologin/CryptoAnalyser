package ru.javarush.cryptoanalyzer.akhundov;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static ru.javarush.cryptoanalyzer.akhundov.Alphabet.ALPHABET;

public class Encryptor {

    private String fileIn;
    private String fileOut;
    private int key;


    public void init(){
        Scanner sc = new Scanner(System.in);
        //TODO Coding. We see console (System.out.print) here. Need move the output to View layer
        System.out.println("Введите корректный путь файла для чтения: ");
        fileIn = sc.nextLine();

        System.out.println("Введите корректный путь файла для записи: ");
        fileOut = sc.nextLine();

        System.out.println("Введите ключ : ");
        key = sc.nextInt();
    }

    public void encrypt(){

        try(FileReader reader = new FileReader(fileIn);
            FileWriter writer = new FileWriter(fileOut, false))
        {
                int c;
                while((c=reader.read())!=-1){
                    if(ALPHABET.contains(Character.toLowerCase((char)c))){
                        int index = ALPHABET.indexOf(Character.toLowerCase((char)c));
                        int newIndex = index + key;
                        if(newIndex >= ALPHABET.size()){
                            newIndex = newIndex - ALPHABET.size();
                        }
                        writer.append(ALPHABET.get(newIndex));
                    }
                }
        } catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Операция прошла успешно!");
    }

}
