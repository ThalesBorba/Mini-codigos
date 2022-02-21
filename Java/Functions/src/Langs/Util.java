package Langs;

import java.util.function.UnaryOperator;

public interface Util {

    public static UnaryOperator<String> maiuscula = n -> n.toUpperCase();
    public static UnaryOperator<String> minuscula = n -> n.toLowerCase();
    public static UnaryOperator<String> uau = n -> n + "!!!";

}
