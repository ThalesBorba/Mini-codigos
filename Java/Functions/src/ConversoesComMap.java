import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ConversoesComMap {

    public static void main(String[] args) {

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        UnaryOperator<String> inverter =
                binarios -> new StringBuilder(binarios).reverse().toString();
        Function<String, Integer> binarioParaInt =
                binarios -> Integer.parseInt(binarios, 2);
        //o 2 é que faz a conversao de binario para int

        numeros.stream()
                .map(Integer::toBinaryString)
                .map(inverter)
                .map(binarioParaInt)
                .forEach(System.out::println);
    }
}
