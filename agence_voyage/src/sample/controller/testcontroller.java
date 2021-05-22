package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.util.connectionDB;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class testcontroller {

    @FXML
    private TextField txt;

    @FXML
    private Button but;

    @FXML
    private Label lab;

    @FXML

    public void click(javafx.event.ActionEvent actionEvent) throws SQLException
    {
        connectionDB con=new connectionDB();
        Connection connection=con.getConnection();
        String sql="INSERT INTO `user` (`id_user`, `email_user`, `password_user`) VALUES (NULL, 'abdelhadi@dmmm.com', '1222222')";
        Statement stm=connection.createStatement();
        stm.executeUpdate(sql);
    }
}
