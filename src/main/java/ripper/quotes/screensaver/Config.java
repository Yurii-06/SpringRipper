package ripper.quotes.screensaver;

import org.springframework.context.annotation.*;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "ripper.quotes.screensaver")
public class Config {
    @Bean
//    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope(value = "periodical")
    public Color color() {
        final Random random = new Random();
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame frame() {
        return new ColorFrame() {
            @Override
            protected Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws InterruptedException {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            context.getBean(ColorFrame.class).showOnRandomPlace();
            Thread.sleep(1000);
        }
    }
}
