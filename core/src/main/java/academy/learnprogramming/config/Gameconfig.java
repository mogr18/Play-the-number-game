package academy.learnprogramming.config;

import academy.learnprogramming.GuessCount;
import academy.learnprogramming.MaxNumber;
import academy.learnprogramming.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages ="academy.learnprogramming")
public class Gameconfig {

    // fields
    @Value("${game.maxNumber:100}")
    private int maxNumber;

    @Value("${game.guessCount:10}")
    private int guessCount;

    @Value("${game.minNumber:0}")
    private int minNumber;

    //bean method
    @Bean
    @MaxNumber
    public int maxNumber1(){
        return maxNumber;
    }
    @Bean
    @GuessCount
    public int guessCount1(){
        return guessCount;
    }
    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }

}
