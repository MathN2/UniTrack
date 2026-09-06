package br.com.unitrack.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.com.unitrack.core.ArvoreBinaria;
import br.com.unitrack.model.Aluno;

public class TelaPrincipal extends JFrame {

    private final ArvoreBinaria arvore;

    private JTextField campoMatricula;
    private JTextField campoNome;

    private JTextArea areaResultado;

    public TelaPrincipal(ArvoreBinaria arvore) {

        this.arvore = arvore;

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

        JPanel painelCadastro = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel labelMatricula = new JLabel("Matrícula:");
        campoMatricula = new JTextField();

        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField();

        JButton botaoCadastrar = new JButton("Cadastrar");

        painelCadastro.add(labelMatricula);
        painelCadastro.add(campoMatricula);

        painelCadastro.add(labelNome);
        painelCadastro.add(campoNome);

        painelCadastro.add(new JLabel());
        painelCadastro.add(botaoCadastrar);

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);

        JScrollPane scroll = new JScrollPane(areaResultado);

        painelPrincipal.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );

        painelPrincipal.add(painelCadastro, BorderLayout.NORTH);
        painelPrincipal.add(scroll, BorderLayout.CENTER);

        add(painelPrincipal);

        botaoCadastrar.addActionListener(e -> cadastrarAluno());
    }

    private void cadastrarAluno() {

        String matricula = campoMatricula.getText().trim();
        String nome = campoNome.getText().trim();

        if (matricula.isEmpty() || nome.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Preencha matrícula e nome."
            );

            return;
        }

        if (arvore.buscarPorMatricula(matricula) != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Já existe um aluno com essa matrícula."
            );

            return;
        }

        if (arvore.buscarPorNome(nome) != null) {

            JOptionPane.showMessageDialog(
                    this,
                    "Já existe um aluno com esse nome."
            );

            return;
        }

        Aluno aluno = new Aluno(matricula, nome);

        arvore.inserirAluno(aluno);

        areaResultado.append(
                "Aluno cadastrado: " +
                nome +
                " | Matrícula: " +
                matricula +
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