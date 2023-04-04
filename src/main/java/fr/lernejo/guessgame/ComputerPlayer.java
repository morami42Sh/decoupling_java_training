package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class ComputerPlayer implements Player {
    private int min = 0, max = 100;
    private int last = 0;
    private final SecureRandom random = new SecureRandom();

    @Override
    public int play() {
        last = random.nextInt(max - min + 1) + min;
        return last;
    }

    @Override
    public void reset() {
        min = 0;
        max = 100;
    }

    @Override
    public boolean hasWin() {
        return false;
    }

    @Override
    public int getScore() {
        return last;
    }

    @Override
    public void setResult(int attemptedValue, Result result) {
        if (result == Result.TOO_HIGH) {
            max = attemptedValue - 1;
        } else if (result == Result.TOO_LOW) {
            min = attemptedValue + 1;
        }
    }
}

