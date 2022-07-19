package ru.javarush.cryptoanalyzer.karpiza.controller;

import lombok.AllArgsConstructor;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.javarush.cryptoanalyzer.karpiza.service.CesarCypherService;
import ru.javarush.cryptoanalyzer.karpiza.service.FileService;
import ru.javarush.cryptoanalyzer.karpiza.service.LemmaService;

import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Logger;

@ShellComponent
@ShellCommandGroup(value = "Caesar cypher command")
@AllArgsConstructor
public class CypherController {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private final FileService fileService;
    private final CesarCypherService cesarCypherService;
    private final LemmaService lemmaService;

    @ShellMethod(
            value = "Encrypt from file to file using key",
            key = "encrypt"
    )
    public String encrypt(
            @ShellOption(value = {"--source", "-s"}, help = "source file with text to encrypt", arity = 1) String source,
            @ShellOption(value = {"--target", "-t"}, help = "dest file which should have encrypted text", arity = 1) String target,
            @ShellOption(value = {"--key", "-k"}, help = "key for encryption", arity = 1) int key) throws IOException {

        String sourceText = fileService.readFile(source);
        String encryptedText = cesarCypherService.encryption(sourceText, key);
        fileService.writeFile(encryptedText, target);

        return String.format("encrypt success, %s", target);
    }

    @ShellMethod(
            value = "Decrypt from file to file using statistical analysis",
            key = "decrypt"
    )
    public String decrypt(
            @ShellOption(value = {"--source", "-s"}, help = "source file with encrypted text", arity = 1) String source,
            @ShellOption(value = {"--target", "-t"}, help = "dest file which should have decrypted text", arity = 1) String target,
            @ShellOption(value = {"--key", "-k"}, help = "key for encryption", arity = 1) int key) throws IOException {

        String sourceText = fileService.readFile(source);
        String encryptedText = cesarCypherService.decryption(sourceText, key);
        fileService.writeFile(encryptedText, target);

        return String.format("decrypt success, %s", target);
    }

    @ShellMethod(
            value = "Decrypt from file to file using brute force",
            key = "brute_force"
    )
    public String bruteForce(
            @ShellOption(value = {"--source","-s"}, help = "source file with encrypted text", arity = 1) String source,
            //@ShellOption(value = {"--representative", "-r"}, help = "file with unencrypted representative text", arity = 1) String representative,
            @ShellOption(value = {"--target", "-t"}, help = "dest file which should have decrypted text", arity = 1) String target) throws IOException {

        TreeMap<Integer, Integer> keyLemmas = new TreeMap<>();

        String sourceText = fileService.readFile(source);
        String encryptedText;
        for (int i = 0; i < CesarCypherService.ALPHABET.length; i ++) {
            encryptedText = cesarCypherService.decryption(sourceText, i);
            Set<String> lemmas = lemmaService.getLemmas(encryptedText);
            keyLemmas.put(lemmas.size(), i);
        }

        int key = keyLemmas.lastEntry().getValue();

        encryptedText = cesarCypherService.decryption(sourceText, key);
        fileService.writeFile(encryptedText, target);

        logger.info(String.format("Key is defined - %s", key));
        return String.format("brute_force success key, %s", target);
    }

    @ShellMethod(
            value = "Decrypt from file to file using statistical analysis",
            key = "statistical_decryption"
    )
    public String statisticalDecrypt(
            @ShellOption(value = {"--source","-s"}, help = "source file with encrypted text", arity = 1) String source,
            //@ShellOption(value = {"--representative", "-r"}, help = "file with unencrypted representative text", arity = 1) String representative,
            @ShellOption(value = {"--target", "-t"}, help = "dest file which should have decrypted text", arity = 1) String target) throws IOException {

        bruteForce(source, target);

        return String.format("statistical_decryption success, %s", target);
    }

}
