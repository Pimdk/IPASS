import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;
import utils.logging.Logger;

public class Main {

    public static void main(String[] args) {
        System.setProperty("org.eclipse.jetty.util.log.class", "org.eclipse.jetty.util.log.StdErrLog");

        ResourceConfig config = new ResourceConfig();
        config.packages("endpoints");
        ServletHolder servletHolder = new ServletHolder(new ServletContainer(config));

        Server server = new Server(8091);
        ServletContextHandler contextHandler = new ServletContextHandler(server, "/*");
        contextHandler.addServlet(servletHolder, "/*");

        try {
            System.out.println("[Websocket Server Started] URI = " + server.getURI());
            server.start();

            server.join();
        } catch (Exception e) {
            Logger.getInstance().log(e);
        }
        finally {
            server.destroy();
        }
    }
}
