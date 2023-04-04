package fr.lernejo.guessgame;

import fr.lernejo.logger.*;

import java.util.Scanner;

public class HumanPlayer implements Player{
    public final Logger logger = LoggerFactory.getLogger("player");
    public Scanner console = new Scanner(System.in);

    @Override
    public long askNextGuess() {
        System.out.println("Enter a number : ");
        long numberPlayer = console.nextInt();
        return numberPlayer;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == true){
            logger.log("Lower");
        }
        else{
            logger.log("Greater");
        }
    }
}
