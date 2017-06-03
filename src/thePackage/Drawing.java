package thePackage;

public final class Drawing extends Manipulator implements GameData {
    public static void run() {
        if (enabled) {
            GameMaster.getFrame().getPanel().preparePaint(GameData.sprites);
            GameMaster.getFrame().getPanel().prepareWrite(GameData.stats);
        }
    }
}