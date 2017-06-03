package thePackage;

import java.util.TimerTask;
import workspace.Script;
public final class Looper extends TimerTask implements GameData{
    
    private boolean enabled = true;
    
    public void run() {
        if (enabled) {
            Script.loop();
        }
        
        Control.run();
        
        Update.run();
        
        Collision.run();
        
        Manager.run();
        
        Camera.run();
        
        Drawing.run();
    }
    
    public void enable(){
        enabled = true;
    }
    
    public void disable() {
        enabled = false;
    }
}