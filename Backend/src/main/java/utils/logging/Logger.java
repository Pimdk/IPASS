package utils.logging;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger logger;
    private ArrayList<LogMessage> messages;

    public static synchronized Logger getInstance(){
        if(logger == null)
            logger = new Logger();
        return logger;
    }

    private Logger() {
        messages = new ArrayList<>();
    }

    public void log(Exception ex)
    {
        log(ex.getMessage(), LogLevel.FATAL);
    }

    public void log(String message, LogLevel logLevel)
    {
        messages.add(new LogMessage(message, logLevel));
    }

    public List<LogMessage> getMessages()
    {
        return messages;
    }
}
