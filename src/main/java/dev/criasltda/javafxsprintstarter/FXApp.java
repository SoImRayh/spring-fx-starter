package dev.criasltda.javafxsprintstarter;

import dev.criasltda.javafxsprintstarter.config.StageManager;
import dev.criasltda.javafxsprintstarter.enums.FxmlView;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class FXApp extends Application {

    protected ConfigurableApplicationContext springContext;
    protected StageManager stageManager;

    @Override
    public void init(){
        springContext = springBootApplicationContext();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stageManager=springContext.getBean(StageManager.class, stage);
        displayInitialScene();
    }

    protected void displayInitialScene()
    {
        stageManager.switchScene(FxmlView.Login);
    }

    @Override
    public void stop()
    {
        springContext.close();
    }

    private ConfigurableApplicationContext springBootApplicationContext()
    {
        final SpringApplicationBuilder builder=new SpringApplicationBuilder(JavafxSprintStarterApplication.class);
        builder.headless(false);
        final String[] args=getParameters().getRaw().toArray(new String[0]);
        return builder.run(args);
    }
}
