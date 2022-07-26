//TODO ---  package contains Uppercase symbols
package ru.javarush.cryptoanalyzer.petrochenko.Util;

import java.nio.file.Path;

public class PathChoice {
    public static Path txtPath = Path.of(PathFinder.getRoot()+"text.txt");
    public static Path encryptedPath = Path.of(PathFinder.getRoot()+"encrypted.txt");
    public static Path decryptedPath = Path.of(PathFinder.getRoot()+"decrypted.txt");
    public static Path decodedPath = Path.of(PathFinder.getRoot()+"decoded.txt");



    public static Path pathWithParameters;

    public PathChoice(String path) {
//        System.out.println("1. Default directory.\n"+"2. Enter directory: ");
//        Scanner console = new Scanner(System.in);
//        pathWithParameters = Path.of(path);
//       // return Path.of(path);
    }

}
