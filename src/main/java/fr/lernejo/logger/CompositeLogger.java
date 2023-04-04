package fr.lernejo.logger;

public class CompositeLogger implements Logger{

    public Logger file;
    public Logger console;

    public CompositeLogger(Logger file, Logger console) {
        this.file = file;
        this.console = console;
    }

    @Override
    public void log(String message) {
        this.file.log(message);
        this.console.log(message);
    }
}
