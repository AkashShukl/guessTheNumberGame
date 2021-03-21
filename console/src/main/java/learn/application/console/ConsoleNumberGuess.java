package learn.application.console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    @Autowired
    private Game game;

    @Autowired
    private  MessageGenerator messageGenerator;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("Inside the console container");

        Scanner scan = new Scanner(System.in);
        int count =0;
        while(true){
            System.out.println(count);
            count++;
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scan.nextInt();
            scan.nextLine();
            game.setGuess(guess);
            game.check();
            if(game.isGameLost() || game.isGameWon()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("wanna play again y/n?");
                if(!(scan.nextLine().trim()).equalsIgnoreCase("y"))
                    break;
                game.reset();

            }
        }
    }
}
