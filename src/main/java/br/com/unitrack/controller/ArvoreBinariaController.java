package br.com.unitrack.controller;

import br.com.unitrack.model.Aluno;
import br.com.unitrack.model.Campus;

public class ArvoreBinariaController {

    private Campus[] campi;

    public ArvoreBinariaController() {
        campi = new Campus[7];

        campi[0] = new Campus("Anália Franco");
        campi[1] = new Campus("Guarulhos");
        campi[2] = new Campus("Liberdade");
        campi[3] = new Campus("Paulista");
        campi[4] = new Campus("São Miguel");
        campi[5] = new Campus("Santo Amaro");
        campi[6] = new Campus("Villa Lobos");
    }

    public boolean cadastrarAluno(Aluno aluno, int campus) {
        for (Campus c : campi) {
            if (c.buscarAlunoPorNome(aluno.getNome()) != null) {
                return false;
            }
        }

        campi[campus].adicionarAluno(aluno);
        return true;
    }

    public Aluno localizarAluno(String nome) {
        for (Campus c : campi) {
            Aluno aluno = c.buscarAlunoPorNome(nome);

            if (aluno != null) {
                return aluno;
            }
        }

        return null;
    }

    public Campus localizarCampus(String nome) {
        for (Campus campus : campi) {
            if (campus.buscarAlunoPorNome(nome) != null) {
                return campus;
            }
        }

        return null;
    }

    public Campus getCampus(int campus) {
        return campi[campus];
    }
}