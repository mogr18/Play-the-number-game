package academy.learnprogramming.service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    //fields
    private final Game game;
    private final MessageGenerator messageGenerator;

    //constructor
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator){
        this.messageGenerator = messageGenerator;
        this.game = game;
    }
    @Override
    public boolean isGameOver() {
        return game.isGameLost() == true || game.isGameWon() == true;
    }
    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }

    //java lifecyce methods
    @PostConstruct
    public void test(){
        log.info("MainMessage = {}", messageGenerator.getMainMessage());
        log.info("This is the number that has to be guessed by the player: {}", game.getNumber());

    }
}
