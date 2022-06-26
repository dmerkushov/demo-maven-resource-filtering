package ru.dmerkushov.demo.maven.resource.filtering;

import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {
        InputStream fromPom = Main.class.getResourceAsStream("/fromPom.properties");
        Properties properties = new Properties();
        properties.load(fromPom);

        String version = properties.getProperty("version", "UNKNOWN");
        System.out.println("Hallo world! My version is " + version);
    }
}
