package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArquivosUtils {

    public static String getPropriedades(String propriedade) throws IOException{
        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream("src/main/resources/application.properties"));
        return propriedades.getProperty(propriedade);
    }
}
