package com.example.rpnparser.parser;

import com.example.rpnparser.converter.Converter;
import com.example.rpnparser.reader.Reader;

import java.util.List;

public class ProcessImpl implements Parser {

    private final Reader<List<String>> reader;
    private final Converter<String, String> converter;

    public ProcessImpl(Reader reader, Converter converter) {
        this.reader = reader;
        this.converter = converter;
    }

    @Override
    public void process() {

        List<String> readRows = reader.read();
        for (String readRow : readRows) {
            String rpnExpression = converter.convert(readRow);
            System.out.println(rpnExpression);
        }
    }
}
