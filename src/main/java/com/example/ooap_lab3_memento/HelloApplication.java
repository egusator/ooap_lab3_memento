package com.example.ooap_lab3_memento;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Note note = new Note();
    private ListView<Memento> statesListView = new ListView<>();
    private TextField titleTextField = new TextField();
    private TextArea contentTextArea = new TextArea();
    private Caretaker caretaker = new Caretaker();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Notes App");

        Label statesLabel = new Label("Saved States:");
        statesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                note.restore(newValue);
                titleTextField.setText(note.getTitle());
                contentTextArea.setText(note.getContent());
            }
        });

        Label titleLabel = new Label("Title:");
        Label contentLabel = new Label("Content:");
        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> saveState());

        VBox layout = new VBox(10, statesLabel, statesListView, titleLabel, titleTextField, contentLabel, contentTextArea, saveButton);
        Scene scene = new Scene(layout, 400, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void saveState() {
        String title = titleTextField.getText();
        String content = contentTextArea.getText();

        if (!title.isEmpty() && !content.isEmpty()) {
            note.setTitle(title);
            note.setContent(content);
            Memento memento = note.save();
            caretaker.saveState(memento);
            statesListView.getItems().setAll(caretaker.getSavedStates().values());
            titleTextField.clear();
            contentTextArea.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}