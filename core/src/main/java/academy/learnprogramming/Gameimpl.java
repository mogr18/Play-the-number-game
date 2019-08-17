package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
@Slf4j
@Getter
@Component
public class Gameimpl  implements Game{



    //constants


    //fields
    @Getter(AccessLevel.NONE)
    private final Numbergenerator numbergenerator;
    private final int guessCount;
    private int number;

    @Setter //only applies to guess field
    private int guess;


    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    //init method
    @PostConstruct
    @Override
    public void reset() {
        smallest = numbergenerator.getMinNumber();
        guess = -1;
        remainingGuesses = guessCount;
        biggest = numbergenerator.getMaxNumber();
        number = numbergenerator.next();
        log.info("the number is: {}", number);

    }
    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    //constructors


    public Gameimpl(Numbergenerator numbergenerator,@GuessCount int guessCount) {
        this.numbergenerator = numbergenerator;
        this.guessCount = guessCount;
    }

    //public methods

    @Override
    public void check() {
        checkValidNumberRange();
         if (validNumberRange){
             if (guess> number){
                 biggest = guess -1;
             }
             else if (guess < number){
                 smallest = guess +1;
             }
         }
         remainingGuesses--;
    }


    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <=0;
    }


    //private method
    private void checkValidNumberRange(){
        validNumberRange = (guess<=biggest) && (guess >= smallest);
    }
}
