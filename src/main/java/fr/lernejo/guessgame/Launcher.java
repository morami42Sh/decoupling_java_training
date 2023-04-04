package fr.lernejo.guessgame;

import java.security.SecureRandom;
import java.util.regex.Pattern;

public class Launcher {

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if (args[0].equals("-interactive")){
            HumanPlayer player = new HumanPlayer();
            Simulation simulation = new Simulation(player);
            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100);
            simulation.initialize(randomNumber);
            simulation.loopUntilPlayerSucceed();
        } else if (args[0].equals("-auto") && pattern.matcher(args[1]).matches()) {
            ComputerPlayer player = new ComputerPlayer();
            Simulation simulation = new Simulation(player);
            simulation.initialize(Long.parseLong(args[1]));
            simulation.loopUntilPlayerSucceed();
        }
        else {
            System.out.println(" -interactive => Human Player");
            System.out.println("-auto ComputerGuess(number) => Computer Player");
        }


    }
}

