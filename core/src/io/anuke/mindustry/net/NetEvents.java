package io.anuke.mindustry.net;

import io.anuke.annotations.Annotations.Loc;
import io.anuke.annotations.Annotations.Remote;
import io.anuke.annotations.Annotations.Variant;
import io.anuke.mindustry.Vars;
import io.anuke.mindustry.entities.Player;

import static io.anuke.mindustry.Vars.playerGroup;

public class NetEvents {

    @Remote(called = Loc.both, targets = Loc.both)
    public static void sendMessage(Player player, String message){
        if(Vars.ui != null){
            Vars.ui.chatfrag.addMessage(message, player == null ? null : colorizeName(player.id, player.name));
        }
    }

    @Remote(called = Loc.both, variants = Variant.both)
    public static void sendMessage(String message){
        if(Vars.ui != null){
            Vars.ui.chatfrag.addMessage(message, null);
        }
    }

    private static String colorizeName(int id, String name){
        Player player = playerGroup.getByID(id);
        if(name == null || player == null) return null;
        return "[#" + player.color.toString().toUpperCase() + "]" + name;
    }
}
