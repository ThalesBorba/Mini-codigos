package Langs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Langs implements Util {

    public static void main(String[] args) {

        Consumer<String> print = System.out::print;

        List<String> langs = Arrays.asList("java", " javascript", " python");
        print.accept("Tudo maiúsculo...\n");
        langs.stream().map(maiuscula).forEach(print);

        print.accept("\n\nMinusculo e com exclamações...\n");
        langs.stream()
                .map(minuscula)
                .map(uau)
                .forEach(print);
    }
}
