package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class ComputerPlayer implements Player{
    public final Logger logger = LoggerFactory.getLogger("player");
    public Scanner console = new Scanner(System.in);
    public long min = 0;

    public long getMin() {
        return min;
    }

    public long getMax() {
        return max;
    }

    public long max = Integer.MAX_VALUE;

    public void setMin(long min) {
        this.min = min;
    }

    public void setMax(long max) {
        this.max = max;
    }

    @Override
    public long askNextGuess() {
        return 0;
    }

    public long dicho() {
        return ((getMax() + getMin()) / 2);
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
