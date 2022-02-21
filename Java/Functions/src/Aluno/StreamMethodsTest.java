package Aluno;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class StreamMethodsTest implements Methods {

    public static void main(String[] args) {

        Aluno a1 = new Aluno("Ana", 7.8, false);
        Aluno a2 = new Aluno("Bia", 5.8, true);
        Aluno a3 = new Aluno("Daniel", 9.8, true);
        Aluno a4 = new Aluno("Gui", 6.8, true);
        Aluno a5 = new Aluno("Rebeca", 7.1, true);
        Aluno a6 = new Aluno("Pedro", 8.8, false);

        List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6);

        Media media = alunos.stream()
                .filter(aprovado)
                .map(apenasNota)
                .reduce(new Media(), calculaMedia, combinarMedia);

        System.out.println("A média da turma é " + media.getValor());
        System.out.println();

        alunos.stream()
                .filter(aprovado)
                .filter(bomComportamento)
                .map(saudacaoAprovado)
                .forEach(System.out::println);

        System.out.println();
        System.out.println(alunos.stream().max(melhorNota).get() + ", a melhor da turma!");
    }
}