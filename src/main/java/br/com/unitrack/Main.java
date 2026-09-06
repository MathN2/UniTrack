
package br.com.unitrack;

import javax.swing.SwingUtilities;

import br.com.unitrack.View.TelaPrincipal;
import br.com.unitrack.controller.ArvoreBinariaController;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ArvoreBinariaController controller =
                    new ArvoreBinariaController();

            TelaPrincipal tela = new TelaPrincipal(controller);

            tela.setVisible(true);
        });
    }
}
