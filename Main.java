package com.company;

/*РАБОЧИЯ ТАБЛИЦА*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void clon (TableView tableView,Button btn,TextField textField){

        btn.setOnAction(event -> tableView.getItems().add(new Person(textField.getText(),"")));

    }

   public void con (TableView tableView,Button btn,TextField textField){

        btn.setOnAction(event -> {
            tableView.getItems().remove(0);
            tableView.getItems().add(new Person("",textField.getText()));
        });
    }

    public void co (TableView tableView,Button btn,TextField textField){

        btn.setOnAction(event -> {
            tableView.getItems().remove(0);
            tableView.getItems().add(new Person(textField.getText(),""));
        });
    }

    public void setEffect (Button btn) {
        btn.setOnMouseExited((e) -> btn.setStyle("-fx-background-color:#FFFFFF;"));

        btn.setOnMouseEntered((e) -> btn.setStyle("-fx-background-color:#1882de;"));
    }

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        TableView tableView = new TableView();

        TableColumn<Person, String> column1 = new TableColumn<>("First Name");
        column1.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> column2 = new TableColumn<>("Last Name");
        column2.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        tableView.getColumns().add(column1);
        tableView.getColumns().add(column2);

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.snapSizeX(5);//размер х = 10
        tableView.snapSizeY(5);//

        FileInputStream input = new FileInputStream("D:\\программы по java\\prog\\src\\com\\company\\vo.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);


        Button btn = new Button("1",imageView);
        Button btn1 = new Button("2");
        Button btn2 = new Button("3");
        btn.setMaxSize(20,20);
        btn1.setMaxSize(20,20);
        btn2.setMaxSize(20,20);
        TextField textField = new TextField();
        textField.setPrefColumnCount(11);
        clon(tableView,btn,textField);
        con(tableView,btn1,textField);
        co(tableView,btn2,textField);
        setEffect(btn);
        setEffect(btn1);
        setEffect(btn2);
        VBox vbox = new VBox(tableView,textField,btn,btn1,btn2);

        Scene scene = new Scene(vbox);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

}




