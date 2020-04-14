package ripper.quotes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        final PropertyFileApplicationContext context = new PropertyFileApplicationContext("contex.properties");
        context.getBean(Quoter.class).sayQuote();
    }
}
