package com.example.rpnparser.converter;

public interface Converter<T, V> {

    T convert(V expression);
}
