package annonymousInnerClass;

import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class AnonymousInnerClassTest
{
    public static void main(String[] args) {
        var clock = new TalkingClock();
        clock.start(1000, true);

        //keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}

