package thePackage;

import java.util.List;
import workspace.Script;

public final class Update extends Manipulator implements GameData
{
    public static void run() {
        for( Entity entity: GameData.allEntities ){
            entity.update();
        }
        for( List <Sprite> list: GameData.sprites ) {
            for ( Sprite sprite: list ) {
                sprite.update();
            }
        }
        for( Text text: GameData.stats ){
            text.update();
        }
        for( Ender ender: GameData.enders ) {
            if (ender.checkEndGameCondition()) {Script.end();}
        }
    }
}
