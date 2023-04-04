package fr.lernejo.guessgame;
import fr.lernejo.logger.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

  private final Logger logger = LoggerFactory.getLogger("simulation");
  private final Player player;
  private long numberToGuess;

  public Simulation(Player player) {
    this.player = player;
  }

  public void initialize(long numberToGuess) {
      this.numberToGuess = numberToGuess;

  }

  /**
   * @return true if the player have guessed the right number
   */
  private boolean nextRound() {

      // Ask number
      if (player instanceof HumanPlayer) {
          long numberPlayer =  player.askNextGuess();
          if (numberPlayer == numberToGuess)
              return true;
          else if (numberPlayer < numberToGuess) {
              player.respond(false);
          }
          else {
              player.respond(true);
          }
      }
      else if (player instanceof ComputerPlayer) {
          long nb = ((ComputerPlayer) player).dicho();
          System.out.println(nb);
          if (nb == numberToGuess)
              return true;
          else if (nb < numberToGuess) {
              player.respond(false);
              ((ComputerPlayer) player).setMin(nb);
          }
          else {
              player.respond(true);
              ((ComputerPlayer) player).setMax(nb);
          }
      }
    return false;
  }

  public void loopUntilPlayerSucceed(long nb_ask) {
    long i = 0;
    long timestamp = System.currentTimeMillis();
      while (nextRound() == false && i++ < nb_ask);
      long timestamp2 = System.currentTimeMillis();

      // Duration of the party
      long duration = timestamp2 - timestamp;
      Date date = new Date(duration);
      String result = new SimpleDateFormat("mm:ss.SSSS").format(date);
      System.out.println(result);

      // Result
      if (i >= nb_ask)
          logger.log("Not found :/");
      else
          logger.log("Found ! Good job !");
  }
}
