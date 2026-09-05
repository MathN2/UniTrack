package br.com.unitrack.core;

import br.com.unitrack.model.Aluno;

public class ArvoreBinaria {
    private class Node {
        private Aluno aluno;
        private Node esquerda;
        private Node direita;
        

        Node(Aluno aluno) {
            this.aluno = aluno;
            esquerda = direita = null;
        }
    }

    Node raiz;

    public void inserirAluno(Aluno aluno) {
        raiz = inserirRecursivo(raiz, aluno);
    }

    private Node inserirRecursivo(Node atual, Aluno aluno) {

        if (atual == null) return new Node(aluno);

        if (atual.aluno.getNome().compareToIgnoreCase(aluno.getNome()) > 0) {
            if (atual.esquerda == null) {
                atual.esquerda = new Node(aluno);
                inserirRecursivo(atual.esquerda, aluno);
            }

            inserirRecursivo(atual.esquerda, aluno);
        } 

        else if (atual.aluno.getNome().compareToIgnoreCase(aluno.getNome()) < 0) {
            if (atual.direita == null){
                atual.direita = new Node(aluno);
                inserirRecursivo(atual.direita, aluno);
            }

            inserirRecursivo(atual.direita, aluno);
        }

        return raiz;
    }


    public void imprimirArvore(){
        imprimirArvore(raiz, 0);
    }
    public void imprimirArvore(Node atual, int nivel){
        if (atual == null) {
            return;
        }
        imprimirArvore(atual.direita, nivel + 1);

        System.out.println("  ".repeat(nivel) + atual.aluno.getNome());

        imprimirArvore(atual.esquerda, nivel + 1);
    }

        /*
        "João" "Maria" "Ana" "Bruno" "Pedro"

        Joao
        /  \
      Ana  Maria
        \    \
      Bruno  Pedro

        */
    
}