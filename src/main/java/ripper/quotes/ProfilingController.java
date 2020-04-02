package ripper.quotes;

public class ProfilingController  implements ProfilingControllerMBean {
    private boolean enabled = true; // TODO: set to => true to enable profiling
//    private boolean enabled;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
