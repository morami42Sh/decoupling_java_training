package fr.lernejo.logger;

public class ConsoleLogger implements Logger {

    @Override
    public void log(String message) {
        System.out.println(message);
    }
    
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger();
        logger.log("Hello World!");
    }
}

