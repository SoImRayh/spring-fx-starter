package dev.criasltda.javafxsprintstarter.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ResourceBundle;

@Component
@RequiredArgsConstructor
public class SpringFXMLLoader {

    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;

    public Parent load(final String fxmlpath){
            try {
                final FXMLLoader loader = getFXMLLoader(fxmlpath);
                return (Parent) loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }

    private FXMLLoader getFXMLLoader(final String fxmlpath) {
        final FXMLLoader loader = new FXMLLoader();

        loader.setControllerFactory(context::getBean);
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlpath));
        return loader;
    }
}
