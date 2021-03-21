package learn.application.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);


    private final NumberGenerator numberGenerator;
    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;


//    //constructor based dependency injection
//    public GameImpl(NumberGenerator numberGenerator){
//        this.numberGenerator = numberGenerator;
//    }

    //setter based dependency injection
//    public void setNumberGenerator( NumberGenerator numberGenerator){
//        this.numberGenerator =  numberGenerator;
//    }
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        ;
        guess = numberGenerator.getMinNumber();
        ;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);

    }

    @PreDestroy
    public void preDestroy() {
        log.info("in game destroy method!");
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getGuess() {
        return this.guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return this.smallest;
    }

    @Override
    public int getBiggest() {
        return this.biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return this.remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return guessCount;
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                biggest = guess - 1;
            }

            if (guess < number) {
                smallest = guess + 1;
            }
        }

        remainingGuesses -= 1;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return this.guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
