import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class CalculaPrecoComFunctions {

    public static void main(String[] args) {

        Produto p = new Produto();
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        p.setNome(leitor.nextLine());
        System.out.println("Digite o preço: ");
        p.setPreco(leitor.nextDouble());
        System.out.println("Digite o desconto (formato float): ");
        p.setDesconto(leitor.nextDouble());

        Function<Produto, Double> precoFinal =
                produto -> produto.getPreco() * (1 - produto.getDesconto());
        UnaryOperator<Double> impostoMunicipal =
                preco -> preco >= 2500 ? preco * 1.085 : preco;
        UnaryOperator<Double> frete =
                preco -> preco >= 3000 ? preco + 100 : preco + 50;
        Function<Double, String> arredondar =
                preco -> String.format("%.2f", preco);
        UnaryOperator<String> formatar =
                preco -> ("R$" + preco).replace(",", "."); //Obs.: depende do locale

        String preco = precoFinal
                .andThen(impostoMunicipal)
                .andThen(frete)
                .andThen(arredondar)
                .andThen(formatar)
                .apply(p);
        System.out.println("O preço final é " + preco + " com o frete.");

        leitor.close();
    }
}
