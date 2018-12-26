package com.phanisai.todolist;

import com.phanisai.todolist.datamodel.TodoData;
import com.phanisai.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField description;
    @FXML
    private TextArea details;
    @FXML
    private DatePicker deadline;

    public TodoItem processResults() {
        String des = description.getText() ;
        String det = details.getText();
        LocalDate date = deadline.getValue();

        TodoItem newItem = new TodoItem(des, det, date);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }
}
