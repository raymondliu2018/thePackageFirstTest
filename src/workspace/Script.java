package workspace;

import thePackage.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Script implements SuperScript {
    public static void init() {
    }
    
    public static void main(String [] args) {
        new GameMaster("NAME");
    }
    
    public static void loop() {
    }
    
    public static void end() {
        Manager.queueWipeAll();
    }

    
    public static void collide(Entity entity1, Entity entity2) {
    }
}
