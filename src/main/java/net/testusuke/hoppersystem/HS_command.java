package net.testusuke.hoppersystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HS_command implements CommandExecutor {
    private final HopperSystem plugin;
    public HS_command(HopperSystem plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)){
            sender.sendMessage("you can not use console!");
            return false;
        }

        if(args.length == 0){
            Player player = (Player)sender;
            sendHelp(player);
            return true;
        }

        if(args.length == 1){
            Player player = (Player) sender;
            //  On
            if(args[0].equalsIgnoreCase("on")){
                if(!player.isOp())return false;
                if(plugin.mode){
                    sendMessage(player,"§cすでにONになっています");
                }
                plugin.mode = true;
                sendMessage(player,"§aONになりました");
                return true;
            }
            //  Off
            if(args[0].equalsIgnoreCase("off")){
                if(!player.isOp())return false;
                if(!plugin.mode){
                    sendMessage(player,"§cすでにOFFになっています");
                }
                plugin.mode = false;
                sendMessage(player,"§aOFFになりました");
                return true;
            }
            if(args[0].equalsIgnoreCase("reload")){
                if(!player.isOp())return false;
                sendMessage(player,"§aコンフィグを再読み込みします");
                plugin.reloadConfig();
                plugin.loadPrefix();
            }
        }
        return true;
    }

    private void sendHelp(Player player) {
        sendMessageNo(player, "§6============================");
        sendMessageNo(player, "§e/hs </hoppersystem> <- ヘルプの表示");
        sendMessageNo(player, "§e/hs on <- モードをONにします");
        sendMessageNo(player, "§e/hs off <- モードをOFFにします");
        sendMessageNo(player, "§d§lCreated by testusuke");
        sendMessageNo(player, "§6============================");
    }

    private void sendMessage(Player player,String message){
        player.sendMessage(plugin.prefix + message);
    }
    private void sendMessageNo(Player player,String message){
        player.sendMessage(message);
    }
}
