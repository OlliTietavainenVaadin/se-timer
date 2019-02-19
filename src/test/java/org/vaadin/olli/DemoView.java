package org.vaadin.olli;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        SeTimer timer = new SeTimer();
        add(timer);
        Button start = new Button("start", e -> {
            timer.start();
        });
        Button stop = new Button("stop", e -> {
            timer.stop();
        });
        Button reset = new Button("reset", e -> {
            timer.reset();
        });
        Button getElapsedTime = new Button("get elapsed time", e -> {
            Div div = new Div();
            div.setText("elapsed: " + timer.getTimePassed());
            add(div);
        });

        add(start, stop, reset, getElapsedTime);
    }
}
