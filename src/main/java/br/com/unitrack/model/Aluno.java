package br.com.unitrack.model;

public class Aluno {
    private String matricula, nome;

    public Aluno(String matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void exibirInfo(){
        System.out.println("-".repeat(30));
        System.out.println("Nome: " + nome);
        System.out.println("Matricula: " + matricula);
        System.out.println("-".repeat(30));
    }
}
