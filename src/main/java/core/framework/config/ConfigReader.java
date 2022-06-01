package core.framework.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static void PopulateSettings() throws IOException {
        ConfigReader reader = new ConfigReader();
        reader.ReadProperty();
    }
    private void ReadProperty() throws IOException {
        Properties p = new Properties();
        var inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/core/framework/config/GlobalConfig.properties");
        //p.load(getClass().getResourceAsStream("GlobalConfig.properties"));
        p.load(inputStream);
        Settings.LogPath = p.getProperty("LogPath");
    }
}
