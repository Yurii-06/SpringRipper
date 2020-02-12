package ripper.quotes;

import javax.annotation.PostConstruct;

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

    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("message = " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
