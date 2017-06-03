package thePackage;

import java.awt.event.*;
import thePackage.GameMaster;
public final class StopListener extends WindowAdapter{
    public void windowClosing(WindowEvent e) {
        GameMaster.stop();
    }
}