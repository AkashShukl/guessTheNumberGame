package learn.application.console;

import learn.application.console.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        System.out.println("hello world");
        log.info("Inside the guess number game ");

        //create context (container )
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        NumberGenerator numberGenerator = ctx.getBean(NumberGenerator.class);

        //call method next() to get the next number

        int num = numberGenerator.next();

        //logging the number
        log.info("number ={}",num);

        //close context (container)

        Game game = ctx.getBean(Game.class);

        MessageGenerator messageGenerator = ctx.getBean(MessageGenerator.class);
        System.out.println(messageGenerator.getMainMessage());
        ctx.close();

    }
}
