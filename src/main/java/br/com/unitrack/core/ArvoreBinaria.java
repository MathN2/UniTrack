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
        if (buscarPorNome(aluno.getNome()) == null){
            raiz = inserirAluno(raiz, aluno);
        }
    }

    private Node inserirAluno(Node atual, Aluno aluno) {
        if (atual == null) return new Node(aluno);

        if (atual.aluno.getNome().compareToIgnoreCase(aluno.getNome()) > 0) {
            if (atual.esquerda == null) {
                atual.esquerda = new Node(aluno);
                // inserirAluno(atual.esquerda, aluno);
            }

            inserirAluno(atual.esquerda, aluno);
        } 

        else if (atual.aluno.getNome().compareToIgnoreCase(aluno.getNome()) < 0) {
            if (atual.direita == null){
                atual.direita = new Node(aluno);
                // inserirAluno(atual.direita, aluno);
            }
            inserirAluno(atual.direita, aluno);
        }
        return atual;
    }


    public Aluno buscarPorNome(String nome){
        if (nome == null) return null;

        Aluno encontrado = buscarPorNome(raiz, nome);
        return encontrado;
    }
    private Aluno buscarPorNome(Node atual, String nome){
        if (atual == null) return null;
        
        if (atual.aluno.getNome().compareToIgnoreCase(nome) > 0){
            return buscarPorNome(atual.esquerda, nome);
        }
        else if(atual.aluno.getNome().compareToIgnoreCase(nome) < 0){
            return buscarPorNome(atual.direita, nome);
        }
        else if (atual.aluno.getNome().compareToIgnoreCase(nome) == 0){
            return atual.aluno;
        }

        return null;
    }


    public Aluno buscarPorMatricula(String matricula) {
        Aluno aluno = buscarPorMatricula(raiz, matricula);
        return aluno;
    }
    private Aluno buscarPorMatricula(Node atual, String matricula) {
        if (atual == null) return null;
        if (atual.aluno.getMatricula().equals(matricula)) return atual.aluno;

        Aluno aluno = buscarPorMatricula(atual.esquerda, matricula);
        if (aluno != null) return aluno;
        
        aluno = buscarPorMatricula(atual.direita, matricula);
        if (aluno != null) return aluno;

        return null;
    }

    public void removerAluno(String aluno){

    }

    public void imprimirArvore(){
        System.out.println("╔Lista de Alunos" + "═".repeat(19) + "╗");
        System.out.printf("║ %-20s │ %-10s║%n", "Nome", "Matrícula");
        System.out.println("║" + "─".repeat(34) + "║");
        imprimirArvore(raiz);
        System.out.println("╚" + "═".repeat(34) + "╝");
    }
    private void imprimirArvore(Node atual){
        if (atual == null) {
            return;
        }
        imprimirArvore(atual.esquerda);
        
        atual.aluno.exibirInfo();
        
        imprimirArvore(atual.direita);
    }
}