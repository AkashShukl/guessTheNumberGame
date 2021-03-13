package learn.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION = "beans.xml";


    public static void main(String[] args) {
        System.out.println("hello world");
        log.info("Inside the guess number game ");

        //create context (container )
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator = ctx.getBean("numberGenerator",NumberGenerator.class);

        //call method next() to get the next number

        int num = numberGenerator.next();

        //logging the number
        log.info("number ={}",num);

        //close context (container)

        ctx.close();

    }
}
