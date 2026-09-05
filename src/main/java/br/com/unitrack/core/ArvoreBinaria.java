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
        System.out.println(aluno.getNome() + " ta entrando.");
        if (atual == null) return new Node(aluno);

        if (atual.aluno.getNome().compareToIgnoreCase(aluno.getNome()) > 0) {
            if (atual.esquerda != null) return atual.esquerda;
            atual.esquerda = new Node(aluno);

            impressao();
            return atual.esquerda;
        } 
        else if (atual.aluno.getNome().compareToIgnoreCase(aluno.getNome()) < 0) {
            if (atual.direita != null) return atual.direita;
            atual.direita = new Node(aluno);

            impressao();
            return atual.direita;
        }
        return atual;
    }

    private void impressao(){
        System.out.println("Atual: " + raiz.aluno.getNome());
        if (raiz.esquerda != null) {
            System.out.println("Esquerda: " + raiz.esquerda.aluno.getNome());
        } else {
            System.out.println("Esquerda: null");
        }

        if (raiz.direita != null) {
            System.out.println("Direita: " + raiz.direita.aluno.getNome());
        } else {
            System.out.println("Direita: null");
        }
        System.out.println("");
    }

    public String getRaiz(){
        return raiz.aluno.getNome();
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