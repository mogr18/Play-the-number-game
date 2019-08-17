package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class consoleNumberGuess{



    //fields
    private Game game;
    private MessageGenerator messageGenerator;

    //constructors
    public consoleNumberGuess(Game game, MessageGenerator messageGenerator){
        this.game = game;
        this.messageGenerator = messageGenerator;
    }
    // Event listeners
    @EventListener(ContextRefreshedEvent.class)
    public void start(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("start() ----> container is ready for use");

        Scanner scanner  = new Scanner(System.in);

        while (true){
            log.info(messageGenerator.getMainMessage());
            log.info(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();
            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("play again? y/n");
                String playAgainString = scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }
    }
}
