package thePackage.debugger;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Set;
import thePackage.Entity;
import thePackage.GameData;
import thePackage.Manager;
import thePackage.Text;

public class ControlDebugTrinket extends Entity implements ControlDebugTrinketSettings, IsDebugger, GameData{
    Entity exampleEntity;
    private HashMap<Entity, KeyDebugTrinket> keyDebugTrinkets;
    public ControlDebugTrinket(Entity input) {
        super();
        exampleEntity = input;
        Text availableKeys = new Text();
        availableKeys.setColor(Color.BLACK);
        availableKeys.setFont(new Font(Font.SANS_SERIF,Font.ITALIC,FONT_SIZE));
        availableKeys.setMessage(getAvailableKeys());
        addStat(availableKeys);
        keyDebugTrinkets = new HashMap<>();
    }
    
    public void subUpdate(){
    }
    
    private String getAvailableKeys() {
        String stack = "";
        HashMap keyMapPressed = exampleEntity.getKeyMapPressed(this);
        Set <String> keySet = keyMapPressed.keySet();
        for (String key: keySet){
            stack += key + "\t";
        }
        return stack;
    }
    
    public void entityAdded(Entity input) {
        KeyDebugTrinket temp = new KeyDebugTrinket(input.getKeys());
        temp.getRect().setCenterX(rect.getCenterX());
        temp.getRect().setCenterY(rect.getCenterY() + KEY_DEBUG_TRINKET_OFFSET_Y * keyDebugTrinkets.size());
        Manager.queueNewEntity(temp);
        keyDebugTrinkets.put(input, temp);
    }
    
    public void entityRemoved(Entity input){
        Manager.removeEntity(keyDebugTrinkets.get(input));
        keyDebugTrinkets.remove(input);
    }
}
