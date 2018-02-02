package com.example.rpnparser;

import com.example.rpnparser.converter.Converter;
import com.example.rpnparser.converter.RpnConverterImpl;
import com.example.rpnparser.parser.Parser;
import com.example.rpnparser.parser.ProcessImpl;
import com.example.rpnparser.reader.FileReaderImpl;
import com.example.rpnparser.reader.Reader;

public class Main {

    public static void main(String[] args) {

        Reader reader = new FileReaderImpl("expressions.txt", 400, 100);
        Converter converter = new RpnConverterImpl();

        Parser parser = new ProcessImpl(reader, converter);
        parser.process();
    }
}
