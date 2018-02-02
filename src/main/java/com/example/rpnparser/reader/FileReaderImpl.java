package com.example.rpnparser.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements Reader<List<String>> {

    private final String fileName;

    private final int countOfSymbol;

    private final int countRows;

    public FileReaderImpl(String fileName, int countOfSymbol, int countRows) {
        this.fileName = fileName;
        this.countOfSymbol = countOfSymbol;
        this.countRows = countRows;
    }

    @Override
    public List<String> read() {

        ClassLoader loader = ClassLoader.getSystemClassLoader();

        String file = loader.getResource(fileName).getFile();

        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty() && !containsDigits(line) && line.length() <= countOfSymbol) {
                    lines.add(line);
                    count++;
                }
                if (count >= countRows) {
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private boolean containsDigits(String string) {

        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

}
