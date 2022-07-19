package ru.javarush.cryptoanalyzer.uzienko.views;

import picocli.CommandLine;
import picocli.CommandLine.*;
import picocli.CommandLine.Model.CommandSpec;
import ru.javarush.cryptoanalyzer.uzienko.controllers.AppController;
import ru.javarush.cryptoanalyzer.uzienko.entity.Result;
import ru.javarush.cryptoanalyzer.uzienko.entity.ResultCode;

import java.io.File;

@CommandLine.Command(name = "cypher", subcommands = {CommandLine.HelpCommand.class}, description = "Caesar cypher command")
public class PicocliView implements Runnable, View {
    @Spec
    CommandSpec spec;

    @Command(name = "encode", description = "Encrypt from file to file using key")
    void encrypt(@Parameters(paramLabel = "<source file>", description = "source file with text to encrypt") File src, @Parameters(paramLabel = "<dest file>", description = "dest file which should have encrypted text") File dest, @Parameters(paramLabel = "<key>", description = "key for encryption") int key) {
    }

    @Command(name = "brute_force", description = "Decrypt from file to file using brute force")
    void bruteForce(@Parameters(paramLabel = "<source file>", description = "source file with encrypted text") File src, @Parameters(paramLabel = "<dest file>", description = "dest file which should have decrypted text") File dest) {
    }

    @Command(name = "statistical_decryption", description = "Decrypt from file to file using statistical analysis")
    void statisticalDecrypt(@Parameters(paramLabel = "<encrypted source file>", description = "source file with encrypted text") File src, @Parameters(paramLabel = "<unencrypted source file>", description = "file with unencrypted representative text") File representativeFile, @Parameters(paramLabel = "<dest file>", description = "dest file which should have decrypted text") File dest) {
    }


    @Command(name = "decode", description = "Decrypt from file to file using statistical analysis")
    void decrypt(@Parameters(paramLabel = "<source file>", description = "source file with encrypted text") File src, @Parameters(paramLabel = "<dest file>", description = "dest file which should have decrypted text") File dest, @Parameters(paramLabel = "<key>", description = "key for encryption") int key) {
    }

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(), "Specify a subcommand");
    }

    @Override
    public Result execute(AppController appController, String[] args) {
        int validateCode = new CommandLine(this).execute(args);
        if (validateCode == 0) {
            return appController.execute(args);
        }
        return new Result(ResultCode.ERROR, "Incorrect command");
    }
}
