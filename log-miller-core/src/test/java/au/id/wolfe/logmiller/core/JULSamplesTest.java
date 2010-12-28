package au.id.wolfe.logmiller.core;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Loads the java util logging and produces some sample data.
 */
public class JULSamplesTest {

    private static final String TARGET_SAMPLE_LOG = "target/sample.log";


    @Test
    public void testLogParsing() throws Exception {

        produceSampleLog(TARGET_SAMPLE_LOG);

        File logfile = new File(TARGET_SAMPLE_LOG);

        if (logfile.exists()) {
            BufferedReader bis = new BufferedReader(new FileReader(logfile));

            String line;

            while ((line = bis.readLine()) != null) {
                System.out.println("checking = " + line);
                if (line.matches("((\\d{2}\\/\\d{2}\\/\\d{4})\\s(\\d{2}:\\d{2}:\\d{2})\\s(AM|PM)\\s([\\w@#%\\^+\\._]+)\\s([\\w@#%\\^+\\_]+))")) {

                    //if (line.matches("(\\d{2}\\/\\d{2}\\/\\d{4}).*")){
                    System.out.println("Matched!");
                }
            }

            bis.close();
        }
    }

    private void produceSampleLog(String filename) throws Exception {
        FileHandler sampleLogFileHandler = new FileHandler(filename);
        sampleLogFileHandler.setFormatter(new SimpleFormatter());

        Logger logger = Logger.getLogger(this.getClass().getName());
        logger.addHandler(sampleLogFileHandler);
        logger.setLevel(Level.ALL);

        logger.info("testing");
        logger.log(Level.SEVERE, "An error occurred!", new Exception("Some exception...", new Exception("Nested exception")));

        logger.removeHandler(sampleLogFileHandler);

        sampleLogFileHandler.flush();
        sampleLogFileHandler.close();
    }
}
