package learn.application.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    //Add logger
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private final int guessCount = 10;

    @PostConstruct
    public void init(){
        log.info( "Game = {} ",game );
    }

    @Override
    public String getMainMessage(){
        return "The number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                " can you guess it now ?";
    }

    @Override
    public String getResultMessage() {

        if( game.isGameWon() ){
            return "You Guessed it the number was "+game.getNumber();
        }else if( game.isGameLost()){
            return "You Lost!! the number was " + game.getNumber();
        }else if( !game.isValidNumberRange()){
            return "Invalid Number Range.";
        }else if( game.getRemainingGuesses() == guessCount){
            return "Are you ready for your first move?";
        }else{
            String direction = "lower";

            if( game.getNumber() > game.getGuess() )
                direction = "higher";
            return  direction + "! You have remaining "+ game.getRemainingGuesses() + " guesses left.";
        }

    }
}
