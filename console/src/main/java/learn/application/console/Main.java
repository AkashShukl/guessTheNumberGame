package learn.application.console;

import learn.application.console.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);//    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {

        log.info("Inside the guess number game ");

        //create context (container )
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(GameConfig.class);

        ctx.close();

    }
}
