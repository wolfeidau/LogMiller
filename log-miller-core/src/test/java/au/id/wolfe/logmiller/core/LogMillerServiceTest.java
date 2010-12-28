package au.id.wolfe.logmiller.core;

import org.junit.Test;

import java.io.File;
import java.util.concurrent.FutureTask;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class LogMillerServiceTest {


    @Test
    public void testFileImportProcess() throws Exception {

        File sampleLogFile = generateSimpleJULLogFileWithData();

        LogMillerService logMillerService = createLogMillerService();

        FutureTask<IndexingResult> indexingFuture = logMillerService.indexLogFile(LogFileType.JUL, sampleLogFile);

        assertThat(indexingFuture.get(), is(notNullValue()));


    }

    private LogMillerService createLogMillerService() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private File generateSimpleJULLogFileWithData() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

}
