package principal;

import listaduplamenteencadeada.ListaDuplamenteEncadeada;
import utils.Aluno;

public class Main {

    public static void main(String[] args) {
        Aluno ver = null;
        Aluno a1 = new Aluno("Anderson", 42);
        Aluno a2 = new Aluno("Ana", 31);
        Aluno a3 = new Aluno("José", 23);
        Aluno a4 = new Aluno("Jonas", 11);
        Aluno a5 = new Aluno("Rebeca", 19);

        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        lista.adicionaInicio(a1);
        lista.adicionaInicio(a1);
        lista.adicionaInicio(a1);
        lista.adicionaInicio(a2);
        lista.adicionaInicio(a2);
        lista.adicionaInicio(a2);
        lista.adicionaInicio(a3);
        lista.adicionaInicio(a3);
        lista.adicionaInicio(a3);
        //lista.adicionaInicio(a4);
        //lista.adicionaInicio(a5);

        //lista.removeFim();
        //lista.removeFim();
        lista.removeDuplicado();
        for (int i = 0; i < lista.tamanho(); i++) {
            ver = (Aluno) lista.Recupera(i);
            System.out.println(ver.getNome() + " - " + ver.getIdade());
        }
    }

}
