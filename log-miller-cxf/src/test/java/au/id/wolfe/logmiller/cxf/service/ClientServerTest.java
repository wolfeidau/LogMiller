package au.id.wolfe.logmiller.cxf.service;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.helpers.XMLUtils;
import org.apache.cxf.testutil.common.AbstractBusClientServerTestBase;
import org.apache.cxf.testutil.common.AbstractBusTestServerBase;
import org.junit.BeforeClass;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.ws.Endpoint;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.logging.Logger;

/**
 *
 */
public class ClientServerTest extends AbstractBusClientServerTestBase {

    static final String PORT = allocatePort(Server.class);
    static final Logger LOG = LogUtils.getLogger(ClientServerTest.class);

    public static class Server extends AbstractBusTestServerBase {
        protected void run() {
            Object implementor = new PersonManagerImpl();
            String address = "http://localhost:" + PORT + "/person_manager";
            Endpoint.publish(address, implementor);
        }

        public static void main(String[] args) {
            try {
                Server s = new Server();
                s.start();
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(-1);
            } finally {
                System.out.println("done!");
            }
        }
    }

    @BeforeClass
    public static void startServers() throws Exception {

        assertTrue("server did not launch correctly", launchServer(Server.class));

    }

    @Test
    public void testGetWSDL() throws Exception {
        String url = "http://localhost:" + PORT + "/person_manager?wsdl";
        HttpURLConnection httpConnection = getHttpConnection(url);
        httpConnection.connect();
        assertEquals(200, httpConnection.getResponseCode());
        assertEquals("text/xml", httpConnection.getContentType());
        assertEquals("OK", httpConnection.getResponseMessage());
        InputStream in = httpConnection.getInputStream();
        assertNotNull(in);
        Document doc = XMLUtils.parse(in);

         XMLUtils.printDOM(doc);

        assertNotNull(doc);
    }


}
