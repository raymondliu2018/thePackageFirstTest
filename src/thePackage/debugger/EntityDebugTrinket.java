package thePackage.debugger;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import thePackage.Entity;
import thePackage.GameData;
import thePackage.Manager;
import thePackage.Text;

public class EntityDebugTrinket extends Entity implements IsDebugger, EntityDebugTrinketSettings{
    private Entity exampleEntity;
    private ArrayList<Entity> discoveredEntities;
    private ControlDebugTrinket controlDebugTrinket;
    private RectDebugTrinket rectDebugTrinket;
    public EntityDebugTrinket (Entity input) {
        super();
        exampleEntity = input;
        discoveredEntities = new ArrayList<>();
        Text entityType = new Text();
        entityType.setColor(Color.BLACK);
        entityType.setFont(new Font(Font.SANS_SERIF,Font.BOLD,ENTITY_TYPE_FONT_SIZE));
        entityType.setMessage(exampleEntity.getClass().getName());
        entityType.setCenterX(() -> {return rect.getCenterX() + ENTITY_TYPE_OFFSET_X;});
        entityType.setCenterY(() -> {return rect.getCenterY() + ENTITY_TYPE_OFFSET_Y;});
        addStat(entityType);
        
        Text entityNumber = new Text();
        entityNumber.setColor(Color.BLACK);
        entityNumber.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,24));
        entityNumber.setMessage(() -> {
            return Integer.toString(countInstances());
        });
        entityNumber.setCenterX(() -> {return rect.getCenterX() + ENTITY_COUNT_OFFSET_X;});
        entityNumber.setCenterX(() -> {return rect.getCenterY() + ENTITY_COUNT_OFFSET_Y;});
        addStat(entityNumber);
        
        controlDebugTrinket = new ControlDebugTrinket(exampleEntity);
        controlDebugTrinket.getRect().setCornerX(rect.getCornerX() + CONTROL_DEBUG_TRINKET_OFFSET_X);
        controlDebugTrinket.getRect().setCornerY(rect.getCornerY() + rect.getHeight() + CONTROL_DEBUG_TRINKET_OFFSET_Y);
        Manager.queueNewEntity(controlDebugTrinket);
        
        rectDebugTrinket = new RectDebugTrinket();
        rectDebugTrinket.getRect().setCornerX(rect.getCornerX() + RECT_DEBUG_TRINKET_OFFSET_X);
        rectDebugTrinket.getRect().setCornerY(rect.getCornerY() + rect.getHeight() + RECT_DEBUG_TRINKET_OFFSET_Y);
        Manager.queueNewEntity(rectDebugTrinket);
        
        sprite.addImage("thePackage/debugger/EntityDebugTrinket.png","main",true);
        resize();
    }
    public void subUpdate() {
        for (Entity input: GameData.allEntities){
            if (input.matchesClassOf(exampleEntity,this)){
                if (!discoveredEntities.contains(input)){
                    entityAdded(input);
                }
            }
        }
        for (Entity input: discoveredEntities){
            if (!Manager.findThisEntity(input)){
                entityRemoved(input);
            }
        }
        
    }
    
    private int countInstances() {
        int counter = 0;
        for (Entity input: GameData.allEntities){
            if (input.matchesClassOf(exampleEntity, this)){
                counter += 1;
            }
        }
        return counter;
    }
    
    private void entityAdded(Entity input) {
        discoveredEntities.add(input);
        controlDebugTrinket.entityAdded(input);
        rectDebugTrinket.entityAdded(input);
        
    }
    
    private void entityRemoved(Entity input) {
        discoveredEntities.remove(input);
        controlDebugTrinket.entityRemoved(input);
        rectDebugTrinket.entityRemoved(input);
    }

}
