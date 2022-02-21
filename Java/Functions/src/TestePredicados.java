import java.util.Scanner;
import java.util.function.Predicate;

public class TestePredicados {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um número: ");
        int escolha = leitor.nextInt();

        Predicate<Integer> ePar = numero -> numero % 2 == 0;
        Predicate<Integer> temTresDigitos =
                numero -> numero >= 100 && numero <= 999;

        if (ePar.and(temTresDigitos).test(escolha)) {
            System.out.println("O número é par e tem 3 dígitos");
        } else if (ePar.test(escolha)) {
            System.out.println("O número é par");
        } else if (temTresDigitos.test(escolha)) {
            System.out.println("O número tem 3 dígitos");
        } else {
            System.out.println("O número nem é par, nem tem 3 dígitos");
        }

    }
}
