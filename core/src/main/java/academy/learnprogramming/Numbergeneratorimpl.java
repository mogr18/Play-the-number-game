package academy.learnprogramming;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Getter
@Component
public class Numbergeneratorimpl implements Numbergenerator {

    //livecycle methods
    @PostConstruct
    public void GeneratorStarted(){
        log.info("initialized {} number generator", this);
    }

    //fields section



    private final int maxNumber;
    private  final int minNumber;


    //constructors
    public Numbergeneratorimpl(@MaxNumber int maxNumber, @MinNumber int minNumber){
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }
    //public methods
    @Override
    public int next() {
        return ThreadLocalRandom.current().nextInt(minNumber, maxNumber);
    }



}
