package annonymousInnerClass;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
/**
 * A clock that prints the time in regular intervals.
 */
Class TalkingClock
        {
public void start(int interval, boolean beep)
        {
        var listener = new ActionListener()
        {
public void actionPerformed(ActionEvent event)
        {
        System.out.println("At the tone, the time is "
        + Instant.ofEpochMilli(event.getWhen()));
        if (beep) Tookit.getDefaultTookit().beep();
        }
        };
        var timer = new Timer(interval, listener);
        timer.start();
        }
        }