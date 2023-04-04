package fr.lernejo.guessgame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HumanPlayer implements Player {
    private int min = 0, max = 100;
    private int last = 0;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int play() {
        System.out.println("Enter a number between " + min + " and " + max + " :");
        int value = -1;
        try {
            value = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException ignored) {
        }
        if (value == -1)
            return play();
        if (value < min || value > max)
            return play();
        last = value;
        return value;
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

