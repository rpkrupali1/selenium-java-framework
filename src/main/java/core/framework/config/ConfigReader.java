package core.framework.config;

import core.framework.App;

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
        var inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/GlobalConfig.properties");
        p.load(inputStream);
        //var inputStream = getClass().getResourceAsStream("GlobalConfig.properties");
        Settings.LogPath = p.getProperty("LogPath");
        Settings.ReportPath = p.getProperty("ReportPath");
    }
}
