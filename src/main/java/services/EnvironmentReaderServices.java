package services;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentReaderServices {
    /* Nếu run bằng maven có set đường dẫn file properties trong configurations run của IDE
     */
    private static Properties properties = new Properties();
    static{
        String envFile = System.getProperty("evn");
        if(envFile == null){
            envFile = "production";
        }
        String filePath = envFile.concat(".properties");
        try {
            properties.load(EnvironmentReaderServices.class.getClassLoader().getResourceAsStream(filePath));
        }catch (IOException e){
            System.out.println("Did not manage to read properties file");
            throw new RuntimeException(e);
        }
    }
        public static String getProperty(String key){
            return properties.getProperty(key);
        }

}
