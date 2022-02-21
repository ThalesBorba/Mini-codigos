package Aluno;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Methods {

    Predicate<Aluno> aprovado = a -> a.nota >= 7;
    Predicate<Aluno> bomComportamento = a -> a.bomComportamento;
    Function<Aluno, String> saudacaoAprovado =
            a -> "Parabéns, " + a.nome + "! Você foi aprovado(a)!";
    Function<Aluno, Double> apenasNota = a -> a.nota;
    BiFunction<Media, Double, Media> calculaMedia =
            (media, nota) -> media.adicionar(nota);
    BinaryOperator<Media> combinarMedia = (m1, m2) -> Media.combinar(m1, m2);
    Comparator<Aluno> melhorNota = (aluno1, aluno2) -> {
        if (aluno1.nota > aluno2.nota) return 1;
        if (aluno1.nota < aluno2.nota) return -1;
        return 0;
    };

}
