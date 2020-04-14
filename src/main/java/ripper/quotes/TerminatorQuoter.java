package ripper.quotes;

import ripper.quotes.annotations.DeprecatedClass;
import ripper.quotes.annotations.InjectRandomInt;
import ripper.quotes.annotations.PostProxy;
import ripper.quotes.annotations.Profiling;

import javax.annotation.PostConstruct;

@DeprecatedClass(newImpl = T1000.class)
@Profiling
public class TerminatorQuoter implements Quoter {
    private String message;
    @InjectRandomInt(min = 2, max = 7)
    private int repeat;

    public TerminatorQuoter() {
        System.out.println("Phase 1 => " +  repeat);
    }

    @PostConstruct
    public void init() {
        System.out.println("Phase 2  => " + repeat);
    }

    @PostConstruct
    @PostProxy
    @Override
    public void sayQuote() {
        System.out.println("Phase 3  =>");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }
}
