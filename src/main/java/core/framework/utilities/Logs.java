package core.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Logs {
    private BufferedWriter bufferedWriter = null;
    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String fileNameFormat = date.format((formatter));

    //create log file
    public void CreateLogFile(){
        try {
            File dir = new File(System.getProperty("user.dir") + "/src/test/java/core/framework/logs");
            if(!dir.exists())
                dir.mkdir();
            //create file
            File logFile = new File(dir + "/" + fileNameFormat + ".log");
            //file writer
            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    //write messages within log
    public void Write(String message){
        try {
            formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss a");
            String dateFormat = date.format(formatter);
            bufferedWriter.write("[" + dateFormat + "] " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }
}
