package br.com.unitrack;

import br.com.unitrack.core.ArvoreBinaria;
import br.com.unitrack.model.Aluno;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Aluno aluno1 = new Aluno("1", "Joao");
        Aluno aluno2 = new Aluno("2", "Maria");
        Aluno aluno3 = new Aluno("3", "Ana");
        Aluno aluno4 = new Aluno("4", "Bruno");
        Aluno aluno5 = new Aluno("5", "Pedro");

        arvore.inserirAluno(aluno1);
        arvore.inserirAluno(aluno2);
        arvore.inserirAluno(aluno3);
        arvore.inserirAluno(aluno4);
        arvore.inserirAluno(aluno5);

        arvore.imprimirArvore();
    }
}