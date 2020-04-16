package net.testusuke.hoppersystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class HopperSystem extends JavaPlugin {

    //////////////////////////
    //  Plugin Information  //
    //////////////////////////
    //  Prefix
    public String prefix;
    //  plugin
    public String pluginName = "HopperSystem";
    //  Version
    public String version = "1.0.0";
    public boolean mode;

    @Override
    public void onEnable() {
        // Plugin startup logic
        //  Logger
        getLogger().info("==============================");
        getLogger().info("Plugin: " + pluginName);
        getLogger().info("Ver: " + version + "  Author: testusuke");
        getLogger().info("==============================");
        //  config
        this.saveDefaultConfig();
        //  LoadPrefix
        loadPrefix();
        //  loadMode
        loadMode();

        //  Command
        getCommand("hs").setExecutor(new HS_command(this));
        getCommand("hoppersystem").setExecutor(new HS_command(this));
        //  Event
        getServer().getPluginManager().registerEvents(new HopperMovingEvent(this),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        saveMode();
    }

    public void loadPrefix(){
        FileConfiguration config = this.getConfig();
        try {
            prefix = config.getString("prefix").replace("&", "§");
        }catch (NullPointerException e){
            e.printStackTrace();
            prefix = "§e[" + pluginName + "]";
        }
    }

    private void loadMode(){
        FileConfiguration config = this.getConfig();
        try {
            mode = config.getBoolean("mode");
            getLogger().info("Load Config about Mode");
        }catch (NullPointerException e){
            e.printStackTrace();
            mode = false;
        }
    }

    private void saveMode() {
        FileConfiguration config = this.getConfig();
        config.set("mode", mode);
        this.saveConfig();
        getLogger().info("Save Config about Mode");
    }
}
