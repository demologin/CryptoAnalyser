package ru.javarush.cryptoanalyzer.gamora.app;

public enum ENMessages {

    ENCODE_SUCCESS("Encoded successfully."),
    ENCODE_FAIL("Encoding failed."),
    DECODE_SUCCESS("Decoded successfully."),
    DECODE_FAIL("Decoding failed."),
    ENCRYPT_SUCCESS("Encrypted successfully."),
    ENCRYPT_FAIL("Encryption failed."),
    DECRYPT_SUCCESS("Decrypted successfully."),
    DECRYPT_FAIL("Decryption failed."),
    HELP_SUCCESS("""
            Commands available:

            \tencode input_file_path output_file_path key
            \t
            Encodes the input text file using Ceasar's cipher with given key. Writes the output to given file path (if file is missing, creates it).

            \tdecode input_file_path output_file_path (key)

            Decodes the input text file from the Ceasar's cipher with or without given key. Writes the output to given file path (if file is missing, creates it). If you know the key, use the one that was used to encode the input text. If the key isn't provided, the program will attempt to brute force the solution, however, it strongly relies on text quality that is assumed to meet punctuational and semantic norms of language.

            \tencrypt input_file_path output_file_path

            Encrypts the input text file. Each character and symbol is turned to another random symbol. Writes the dictionary of characters to text/dict.txt and a result to given output path.

            \tdecrypt input_file_path output_file_path example_file_path

            Decrypts the input text file using given example file (text of the same author) as an example for statistical purposes. Writes the resulting text to output path and a dictionary to text/dict.txt.

            Parameters:

            Optional parameters are surrounded with parentheses.

            input_file_path - path to the input .txt file. If it's in %filename%.txt format, app searches for it in text/ directory, however, absolute path is possible, too - but without spaces in it.
            output_file_path - path to the output .txt file. If it's in %filename%.txt format, app searches for it in text/ directory, however, absolute path is possible, too - but without spaces in it.
            example_file_path - path to the example .txt file. If it's in %filename%.txt format, app searches for it in text/ directory, however, absolute path is possible, too - but without spaces in it.
            key - an integer number."""),
    EXIT_SUCCESS(""),
    START("""
            Cryptoanalizer application. Gamora Constantine, 2022.
            Run help command to view the guide,
            Run exit command to exit.
            """);
    public final String message;

    ENMessages(String message) {
        this.message = message;
    }
}
