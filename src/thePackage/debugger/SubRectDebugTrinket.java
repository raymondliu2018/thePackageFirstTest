
package thePackage.debugger;

import java.awt.Color;
import java.awt.Font;
import thePackage.Entity;
import thePackage.GameMaster;
import thePackage.Rect;
import thePackage.Text;

public class SubRectDebugTrinket extends Entity implements SubRectDebugTrinketSettings, IsDebugger{
    private Rect rectInfo;
    private Text info;
    public SubRectDebugTrinket(Rect input) {
        rectInfo = input;
        info = new Text();
        info.setColor(Color.BLACK);
        info.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,FONT_SIZE));
        info.setCenterX(rect.getCenterX());
        info.setCenterY(rect.getCenterY());
        info.setMessage(() -> {return stats();});
        addStat(info);
    }
    
    public void subUpdate() {
        if (rectInfo.getCenterX() < 0 || rectInfo.getCenterX() > GameMaster.getWidth()){
            info.setColor(Color.RED);
            
        }
        else if (rectInfo.getCenterY() < 0 || rectInfo.getCenterY() > GameMaster.getHeight()){
            info.setColor(Color.RED);
        }
        else {
            info.setColor(Color.BLACK);
        }
        
    }
    
    private String stats() {
        String stack = "";
        stack += Double.toString(rectInfo.getCenterX());
        stack += "\t";
        stack += Double.toString(rectInfo.getCenterY());
        stack += "\t";
        stack += Double.toString(rectInfo.getAngle());
        
        return stack;
    }
}
