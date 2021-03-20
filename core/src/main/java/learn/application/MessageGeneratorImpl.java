package learn.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {
    //Add logger
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    @PostConstruct
    public void init(){
        log.info( "Game = {} ",game );
    }

    @Override
    public String getMainMessage(){
        return "this is get main message";
    }

    @Override
    public String getResultMessage() {
        return "this is get Result MEsage";
    }
}
