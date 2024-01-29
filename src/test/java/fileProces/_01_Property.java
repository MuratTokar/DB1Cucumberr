package fileProces;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class _01_Property {
    public static void main(String[] args) throws IOException {

      // property tanimlaniyor
        Properties properties=new Properties();

        //Hangi property file okunacak ,FileReader
        String file="src/test/java/fileProces/_01_Property.properties";

        //FileReader kullanarak okunur
        FileReader fileReader=new FileReader(file);

        //okunani yukledik
        properties.load(fileReader);

        System.out.println("properties.getProperty(\"url\") = " + properties.getProperty("url"));

        fileReader.close();

    }
}
