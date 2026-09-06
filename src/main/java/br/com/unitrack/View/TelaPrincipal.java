package br.com.unitrack.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.unitrack.controller.ArvoreBinariaController;
import br.com.unitrack.model.Aluno;

public class TelaPrincipal extends JFrame {

    private final ArvoreBinariaController controller;

    private JTextField campoMatricula;
    private JTextField campoNome;
    private JComboBox<String> campoCampus;
    private JTextArea areaResultado;

    public TelaPrincipal(ArvoreBinariaController controller) {

        this.controller = controller;

        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {

        setTitle("UniTrack - Cadastro de Alunos");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void criarComponentes() {

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout(10, 10));

        JPanel painelCadastro = new JPanel(
                new GridLayout(4, 2, 10, 10)
        );

        JLabel labelMatricula = new JLabel("Matrícula:");
        campoMatricula = new JTextField();

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField();

        JLabel labelCampus = new JLabel("Campus:");

        String[] campi = {
                "Anália Franco",
                "Guarulhos",
                "Liberdade",
                "Paulista",
                "São Miguel",
                "Santo Amaro",
                "Villa Lobos"
        };

        campoCampus = new JComboBox<>(campi);

        JButton botaoCadastrar = new JButton("Cadastrar");

        painelCadastro.add(labelMatricula);
        painelCadastro.add(campoMatricula);

        painelCadastro.add(labelNome);
        painelCadastro.add(campoNome);

        painelCadastro.add(labelCampus);
        painelCadastro.add(campoCampus);

        painelCadastro.add(new JLabel());
        painelCadastro.add(botaoCadastrar);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        painelPrincipal.add(
                painelCadastro,
                BorderLayout.NORTH
        );

        painelPrincipal.add(
                scroll,
                BorderLayout.CENTER
        );

        add(painelPrincipal);

        botaoCadastrar.addActionListener(
                e -> cadastrarAluno()
        );
    }

    private void cadastrarAluno() {

        String matricula = campoMatricula.getText().trim();
        String nome = campoNome.getText().trim();

        int campus = campoCampus.getSelectedIndex();

        if (matricula.isEmpty() || nome.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Preencha matrícula e nome."
            );

            return;
        }

        Aluno aluno = new Aluno(matricula, nome);

        if (controller.localizarAluno(nome) != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Já existe um aluno com esse nome."
            );

            return;
        }

        if (!controller.cadastrarAluno(aluno, campus)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Não foi possível cadastrar o aluno."
            );

            return;
        }

        String nomeCampus =
                campoCampus.getSelectedItem().toString();

        areaResultado.append(
                "Aluno cadastrado: " +
                nome +
                " | Matrícula: " +
                matricula +
                " | Campus: " +
                nomeCampus +
                "\n"
        );

        campoMatricula.setText("");
        campoNome.setText("");

        JOptionPane.showMessageDialog(
                this,
                "Aluno cadastrado com sucesso!"
        );
    }
}

