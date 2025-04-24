package ru.tolkacheva.spring.streamplatform;

import java.io.*;
import java.util.Scanner;

public class StreamPlatform {
    private File fileIn;
    private File fileOut;

    public StreamPlatform(String fileIn, String fileOut) {
        this.fileIn = new File(fileIn);
        this.fileOut = new File(fileOut);
    }

    public void dataUpper() throws IOException {
        Scanner scanner = new Scanner(fileIn);
        FileWriter writer = new FileWriter(fileOut);
        while (scanner.hasNextLine()) {
            writer.write(scanner.nextLine().toUpperCase());
        }
    }

    public void hasFourSymbols() throws IOException {
        Scanner scanner = new Scanner(fileIn);
        FileWriter writer = new FileWriter(fileOut);
        while (scanner.hasNextLine()) {
            if (scanner.nextLine().length() > 4) {
                writer.write(scanner.nextLine());
            }
        }
    }
}
