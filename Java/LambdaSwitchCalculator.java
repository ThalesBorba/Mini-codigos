import java.util.Scanner;
import java.util.function.BinaryOperator;

public class LambdaSwitchCalculator {

    public static void main(String[] args) {

        BinaryOperator<Integer> calc;
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite 1 para soma, 2 para subtração, 3 para multiplicação, 4 para divisão");
        int escolha = leitor.nextInt();

        switch (escolha) {
            case 1:
                calc = (x, y) -> x + y;
                break;
            case 2:
                calc = (x, y) -> x - y;
                break;
            case 3:
                calc = (x, y) -> x * y;
                break;
            case 4:
                calc = (x, y) -> x / y;
                break;
            default:
                throw new IllegalStateException("Valor inválido: " + escolha);
        }

        System.out.println("Digite dois inteiros");

        int x = leitor.nextInt();
        int y = leitor.nextInt();

        System.out.println(calc.apply(x, y));
    }
}
