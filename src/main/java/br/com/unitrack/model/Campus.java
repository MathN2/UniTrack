package br.com.unitrack.model;

import br.com.unitrack.core.ArvoreBinaria;

public class Campus {
    private String nome;
    private ArvoreBinaria arvoreAlunos;

    public Campus(String nome) {
        this.nome = nome;
        this.arvoreAlunos = new ArvoreBinaria();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarAluno(Aluno aluno) {
        arvoreAlunos.inserirAluno(aluno);
    }

    public Aluno buscarAluno(String matricula) {
        return arvoreAlunos.buscarPorMatricula(matricula);
    }

    public Aluno buscarAlunoPorNome(String nome) {
        return arvoreAlunos.buscarPorNome(nome);
    }
}