package Produto;

import java.util.Scanner;
import java.util.function.BiFunction;
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
        BiFunction<Double, Double, String> valeAPena =
                (precoSemFrete, precoComFrete) -> precoSemFrete > precoComFrete
                        ? "O frete compensa a compra." : "O frete não compensa a compra.";
        Function<Double, String> arredondar =
                preco -> String.format("%.2f", preco);
        UnaryOperator<String> formatar =
                preco -> (preco).replace(",", "."); //Obs.: depende do locale

        String preco = precoFinal
                .andThen(impostoMunicipal)
                .andThen(frete)
                .andThen(arredondar)
                .andThen(formatar)
                .apply(p);
        System.out.println("O preço final do(a) " + p.getNome() + " é R$" + preco + " com o frete.");

        String compensa = valeAPena.apply(p.getPreco(), Double.valueOf(preco));
        System.out.println(compensa);

        leitor.close();
    }
}
