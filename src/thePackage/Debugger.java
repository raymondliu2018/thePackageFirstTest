
package thePackage;

import thePackage.debugger.DebugTool;
public class Debugger {
    private static boolean enabled = false;
    public static void enabled() {
        enabled = true;
        Manager.queueNewEntity(new DebugTool());
    }
}
