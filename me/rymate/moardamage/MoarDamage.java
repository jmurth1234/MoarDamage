package me.rymate.moardamage;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.util.config.Configuration;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import me.rymate.moardamage.listeners.Listener_Entity;

public class MoarDamage extends JavaPlugin {

    private Logger log;
    private PluginDescriptionFile description;
    private String prefix;
    private int config_moardamage_damagemultiplyer;
    private Listener_Entity listenerEntity;

    @Override
    public void onEnable() {
        log = Logger.getLogger("Minecraft");
        description = getDescription();
        prefix = "[" + description.getName() + "] ";
        log("loading " + description.getFullName());
        setupConfiguration();
        listenerEntity = new Listener_Entity(this);
        getServer().getPluginManager().registerEvent(Type.ENTITY_DAMAGE, listenerEntity, Priority.Normal, this);

    }

    @Override
    public void onDisable() {
        log("disabled " + description.getFullName());
    }

    public void log(String message) {
        log.info(prefix + message);
    }

    private void setupConfiguration() {
        Configuration cfg = getConfiguration();
        cfg.setHeader("#MahPluginz configuration xD!!111 s0 l33t. There's only one value :)");
        config_moardamage_damagemultiplyer = cfg.getInt("MoarDamage.DamageMultiplyer", 1);
        cfg.save();
    }

    public int getConfig_moardamage_damagemultiplyer() {
        return config_moardamage_damagemultiplyer;
    }
}
