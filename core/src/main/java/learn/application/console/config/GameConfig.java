package learn.application.console.config;

import learn.application.console.GuessCount;
import learn.application.console.MaxNumber;
import learn.application.console.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "learn.application")
public class GameConfig {

    @Value("${game.maxNumber}")
    private int maxNumber ;

    @Value("${game.guessCount}")
    private int guessCount ;

    @Value("${game.minNumber}")
    private int minNumber;


    @Bean
    @MaxNumber
    public int maxNumber(){
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount(){
        return guessCount;
    }

    @Bean
    @MinNumber
    public int minNumber(){
        return minNumber;
    }
}
