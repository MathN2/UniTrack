package br.com.unitrack;

import br.com.unitrack.core.ArvoreBinaria;
import br.com.unitrack.model.Aluno;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Aluno aluno1 = new Aluno("1", "Alice");
        Aluno aluno2 = new Aluno("2", "Benjamin");
        Aluno aluno3 = new Aluno("3", "Cauan");
        Aluno aluno4 = new Aluno("4", "Daniel");
        Aluno aluno5 = new Aluno("5", "Aang");

        arvore.inserirAluno(aluno1);
        arvore.inserirAluno(aluno2);
        arvore.inserirAluno(aluno3);
        arvore.inserirAluno(aluno4);

        System.out.println("---------------------------------------------------");
        System.out.println(arvore.getRaiz());
        arvore.inserirAluno(aluno5);

        System.out.println();
    }
}