package ru.javarush.cryptoanalyzer.didukh.toplevel;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Console {
    public static String[] commands;
    public static void start(){
        //TODO Code style. Long code. Needs to be split into several methods
        String[] args = new String[4];
        Scanner scanner = new Scanner(System.in);
        String command;
        Pattern pattern = Pattern.compile("[a-z]+\\.txt");
        Pattern patternKey = Pattern.compile("[0-9]+");
        //boolean a = true;
            do  {
                System.out.println("""
                        Введите одну из команд:
                        1.Encode
                        2.Decode
                        3.Brute
                        4.Statistic""");
                command = scanner.nextLine();
                if (command.equalsIgnoreCase("encode") ||
                        command.equalsIgnoreCase("Decode") ||
                        command.equalsIgnoreCase("Brute") ||
                        command.equalsIgnoreCase("Statistic")) {
                    break;
                }
                System.out.println("Неправильная команда, попробуйте еще раз");
            } while(!command.equalsIgnoreCase("encode") &&
                    !command.equalsIgnoreCase("Decode") &&
                    !command.equalsIgnoreCase("Brute") &&
                    !command.equalsIgnoreCase("Statistic"));

            args[0] = command;


            if(command.equalsIgnoreCase("Encode")){


                String fileName;
                do{
                System.out.println("Введите имя файла, с текстом который вы хотите закодировать");
                fileName = scanner.nextLine();
                if (fileName.matches(pattern.toString())){break;}
                }while (!fileName.matches(pattern.toString()));
                args[1] = fileName;



                String fileName2;
                do{
                System.out.println("Введите имя файла, куда вы хотите записать зашифрованный текст");
                fileName2 = scanner.nextLine();
                if(fileName2.matches(pattern.toString())){break;}
                }while (!fileName2.matches(pattern.toString()));
                args[2] = fileName2;



                String key;
                do{
                System.out.println("Введите ключ кодирования");
                key = scanner.nextLine();
                if(key.matches(patternKey.toString())){break;}
                }while (!key.matches(patternKey.toString()));
                args[3] = key;


                commands = args;






            }else if(command.equalsIgnoreCase("Decode")){


                String fileName;
                do{
                System.out.println("Введите имя файла, с текстом который вы хотите раскодировать");
                fileName = scanner.nextLine();
                if(fileName.matches(pattern.toString())){break;}
                }while (!fileName.matches(pattern.toString()));
                args[1] = fileName;



                String fileName2;
                do{
                System.out.println("Введите имя файла, куда вы хотите записать расшифрованный текст");
                fileName2 = scanner.nextLine();
                if(fileName2.matches(pattern.toString())){break;}
                }while (!fileName2.matches(pattern.toString()));
                args[2] = fileName2;



                String key;
                do{
                System.out.println("Введите ключ кодирования");
                key = scanner.nextLine();
                if(key.matches(patternKey.toString())){break;}
                }while (!key.matches(patternKey.toString()));
                args[3] = key;


                commands = args;






            }else if(command.equalsIgnoreCase("Brute")){


                String fileName;
                do{
                System.out.println("Введите имя файла, с текстом который вы хотите раскодировать");
                fileName = scanner.nextLine();
                if(fileName.matches(pattern.toString())){break;}
                }while (!fileName.matches(pattern.toString()));
                args[1] = fileName;



                String fileName2;
                do{
                System.out.println("Введите имя файла, куда вы хотите записать зашифрованный текст");
                fileName2 = scanner.nextLine();
                if(fileName2.matches(pattern.toString())){break;}
                }while (!fileName2.matches(pattern.toString()));
                args[2] = fileName2;



                String key;
                do{
                System.out.println("Введите имя файла с каким либо текстом того же автора");
                key = scanner.nextLine();
                if(key.matches(pattern.toString())){break;}
                }while (!key.matches(pattern.toString()));
                args[3] = key;


                commands = args;






            }else if(command.equalsIgnoreCase("Statistic")){


                String fileName;
                do{
                System.out.println("Введите имя файла, с текстом который вы хотите раскодировать");
                fileName = scanner.nextLine();
                if(fileName.matches(pattern.toString())){break;}
                }while(!fileName.matches(pattern.toString()));
                args[1] = fileName;



                String fileName2;
                do{
                System.out.println("Введите имя файла, куда вы хотите записать расшифрованный текст");
                fileName2 = scanner.nextLine();
                if(fileName2.matches(pattern.toString())){break;}
                }while (!fileName2.matches(pattern.toString()));
                args[2] = fileName2;



                String key;
                do{
                System.out.println("Введите имя файла с каким либо текстом того же автора");
                key = scanner.nextLine();
                if(key.matches(pattern.toString())){break;}
                }while (!key.matches(pattern.toString()));
                args[3] = key;


                commands = args;
            }
    }
}
