package br.com.unitrack.view;

import java.util.List;

import br.com.unitrack.controller.ArvoreBinariaController;
import br.com.unitrack.model.Aluno;
import br.com.unitrack.model.Campus;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaPrincipal extends Application {

    private final ArvoreBinariaController controller =
            new ArvoreBinariaController();

    private Scene scene;

    @Override
    public void start(Stage stage) {

        scene = new Scene(criarTelaPrincipal(), 800, 600);

        stage.setTitle("UniTrack");
        stage.setScene(scene);
        stage.show();
    }

    private VBox criarTelaPrincipal() {

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("UniTrack");

        Button cadastrar = new Button("Cadastrar Aluno");
        Button listar = new Button("Listar Alunos");
        Button localizar = new Button("Localizar Aluno");

        cadastrar.setOnAction(e ->
            scene.setRoot(criarTelaCadastro())
        );

        listar.setOnAction(e ->
            scene.setRoot(criarTelaLista())
        );

        localizar.setOnAction(e ->
            scene.setRoot(criarTelaLocalizar())
        );

        layout.getChildren().addAll(
            titulo,
            cadastrar,
            listar,
            localizar
        );

        return layout;
    }

    private VBox criarTelaCadastro() {

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("Cadastrar Aluno");

        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome");

        TextField campoMatricula = new TextField();
        campoMatricula.setPromptText("Matrícula");

        String[] campi = {
            "Anália Franco",
            "Guarulhos",
            "Liberdade",
            "Paulista",
            "São Miguel",
            "Santo Amaro",
            "Villa Lobos"
        };

        ComboBox<String> campoCampus = new ComboBox<>();
        campoCampus.getItems().addAll(campi);
        campoCampus.getSelectionModel().selectFirst();

        Button cadastrar = new Button("Cadastrar");
        Button voltar = new Button("Voltar");

        Label resultado = new Label();

        cadastrar.setOnAction(e -> {

            String nome = campoNome.getText().trim();
            String matricula = campoMatricula.getText().trim();

            int campus = campoCampus.getSelectionModel().getSelectedIndex();

            if (nome.isEmpty() || matricula.isEmpty()) {
                resultado.setText("Preencha todos os campos.");
                return;
            }

            Aluno aluno = new Aluno(matricula, nome);

            if (controller.cadastrarAluno(aluno, campus)) {
                resultado.setText("Aluno cadastrado com sucesso!");

                campoNome.clear();
                campoMatricula.clear();

            } else {
                resultado.setText("Já existe um aluno com esse nome.");
            }
        });

        voltar.setOnAction(e ->
            scene.setRoot(criarTelaPrincipal())
        );

        layout.getChildren().addAll(
            titulo,
            campoNome,
            campoMatricula,
            campoCampus,
            cadastrar,
            resultado,
            voltar
        );

        return layout;
    }

    private VBox criarTelaLista() {

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("Listar Alunos");

        ComboBox<String> campoCampus = new ComboBox<>();

        for (int i = 0; i < 7; i++) {
            campoCampus.getItems().add(
                controller.getCampus(i).getNome()
            );
        }

        campoCampus.getSelectionModel().selectFirst();

        TextArea resultado = new TextArea();
        resultado.setEditable(false);

        Button listar = new Button("Listar");
        Button voltar = new Button("Voltar");

        listar.setOnAction(e -> {

            int indice = campoCampus.getSelectionModel().getSelectedIndex();

            Campus campus = controller.getCampus(indice);
            List<Aluno> alunos = campus.listarAlunos();

            resultado.clear();

            resultado.setText(
                "Alunos do campus: " +
                campoCampus.getValue()  + "\n"
            );

            for (Aluno aluno : alunos) {
                resultado.appendText(
                    aluno.getNome() + " | " + aluno.getMatricula() + "\n"
                );
            }
        });

        voltar.setOnAction(e ->
            scene.setRoot(criarTelaPrincipal())
        );

        layout.getChildren().addAll(
            titulo,
            campoCampus,
            listar,
            resultado,
            voltar
        );

        return layout;
    }

    private VBox criarTelaLocalizar() {

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);

        Label titulo = new Label("Localizar Aluno");

        TextField campoNome = new TextField();
        campoNome.setPromptText("Nome do aluno");

        Button buscar = new Button("Buscar");
        Button voltar = new Button("Voltar");

        TextArea resultado = new TextArea();
        resultado.setEditable(false);

        buscar.setOnAction(e -> {

            String nome = campoNome.getText().trim();

            if (nome.isEmpty()) {
                resultado.setText("Digite um nome.");
                return;
            }

            Aluno aluno = controller.localizarAluno(nome);
            Campus campus = controller.localizarCampus(nome);

            if (aluno == null) {
                resultado.setText("Aluno não encontrado.");
                return;
            }

            resultado.setText(
                "Aluno encontrado!\n\n" +
                "Nome: " + aluno.getNome() + "\n" +
                "Matrícula: " + aluno.getMatricula() + "\n" +
                "Campus: " + campus.getNome()
            );
        });

        voltar.setOnAction(e ->
            scene.setRoot(criarTelaPrincipal())
        );

        layout.getChildren().addAll(
            titulo,
            campoNome,
            buscar,
            resultado,
            voltar
        );

        return layout;
    }
}