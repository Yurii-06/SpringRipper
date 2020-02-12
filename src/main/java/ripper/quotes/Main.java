package ripper.quotes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        TerminatorQuoter bean = context.getBean(TerminatorQuoter.class);
        bean.sayQuote();
    }
}
