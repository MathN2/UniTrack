package br.com.unitrack;

import javax.swing.SwingUtilities;

import br.com.unitrack.View.TelaPrincipal;
import br.com.unitrack.core.ArvoreBinaria;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ArvoreBinaria arvore = new ArvoreBinaria();

            TelaPrincipal tela = new TelaPrincipal(arvore);

            tela.setVisible(true);
        });
    }
}