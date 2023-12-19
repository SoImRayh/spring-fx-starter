package dev.criasltda.javafxsprintstarter.enums;


import java.util.ResourceBundle;

public enum FxmlView {
    Login{
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/home.fxml";
        }
    };

    static String getStringFromResourceBundle(final String key)
    {
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

    public abstract String getTitle();
    public abstract String getFxmlFile();
}