package commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtils {
    public static String getProperty(String propertyName) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("environment.properties"));

            return prop.getProperty(propertyName);
        } catch (IOException e) {
            e.printStackTrace();
            return "null";
        }
    }
}
