import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class propertiesExample {
    public static Map<String, String> properties = new HashMap<>();


    public void fillInPropertiesMap() throws  Exception{
        BufferedReader reader = null;
        String fileName = null;
        FileInputStream inputStream = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            fileName = reader.readLine();
            inputStream = new FileInputStream(fileName);
        } finally {
            load(inputStream);
            inputStream.close();
            reader.close();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties properties2 = new Properties();
        for (Map.Entry pair : properties.entrySet()) {
            properties2.setProperty((String)pair.getKey(), (String) pair.getValue());
        }
        properties2.store(outputStream, null);
    }

    public void load(InputStream inputStream) throws Exception {
        Properties properties1 = new Properties();
        properties1.load(inputStream);
        for (final String name : properties1.stringPropertyNames()) {
            properties.put(name, properties1.getProperty(name));
        }

    }

    public static void main(String[] args) {

    }
}
