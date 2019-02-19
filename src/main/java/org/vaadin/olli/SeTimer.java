package org.vaadin.olli;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.PropertyDescriptor;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("se-timer")
@HtmlImport("bower_components/se-timer/se-timer.html")
public class SeTimer extends Component {
    private long start;
    private long timePassed = 0;
    private boolean running = false;

    public SeTimer() {
        getElement().setProperty("value", 0);
    }

    public void start() {
        getElement().setProperty("state", "count");
        start = System.currentTimeMillis();
        running = true;
    }

    public void stop() {
        getElement().setProperty("state", "stop");
        if (running) {
            timePassed += System.currentTimeMillis() - start;
        }
        running = false;
    }

    public void reset() {
        if (getElement().getProperty("value", -1) == 0) {
            getElement().setProperty("value", 1);
        } else {
            getElement().setProperty("value", 0);
        }
        timePassed = 0;
    }

    public long getTimePassed() {
        if (running) {
            return timePassed + (System.currentTimeMillis() - start);
        }
        return timePassed;
    }

}
