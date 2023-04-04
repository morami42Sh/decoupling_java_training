package fr.lernejo.logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{

    private Logger logger;
    private String name;

    public ContextualLogger(String name, Logger logger){
        this.name = name;
        this.logger = logger;
    }

    @Override
    public void log(String message) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        this.logger.log(LocalDateTime.now().format(formatter) + " " + this.name + " " + message);
    }
}
