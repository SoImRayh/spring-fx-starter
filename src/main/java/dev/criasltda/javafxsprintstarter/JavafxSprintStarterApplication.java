package dev.criasltda.javafxsprintstarter;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafxSprintStarterApplication {

    public static void main(String[] args) {
        Application.launch(FXApp.class, args);
    }

}
