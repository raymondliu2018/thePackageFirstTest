package thePackage.debugger;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import thePackage.Entity;
import thePackage.Key;
import thePackage.Text;

public class KeyDebugTrinket extends Entity implements KeyDebugTrinketSettings, IsDebugger{
    private HashMap<String,Text> individualKeys;
    public KeyDebugTrinket(ArrayList<Key> keys) {
        super();
        int counter = 0;
        individualKeys = new HashMap<>();
        for (Key key: keys){
            counter += 1;
            bindCodeToAction(key.toString(),(a) -> {
                Text temp = individualKeys.get(key.toString());
                temp.setColor(Color.RED);
            }, (a) -> {
                Text temp = individualKeys.get(key.toString());
                temp.setColor(Color.BLACK);
            });
            this.bindKeyToAction(key.getInput(), key.toString());
            Text temp = new Text();
            temp.setColor(Color.BLACK);
            temp.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,FONT_SIZE));
            temp.setMessage(Character.toString((char)(key.getInput())));
            temp.setCenterX(rect.getCornerX() + OFFSET_X * counter);
            temp.setCenterY(rect.getCenterY());
            addStat(temp);
        }
    }
    
    public void subUpdate() {
        
    }
}
