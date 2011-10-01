/*
 * MoarDamage - by rymate
 * http://rymatemc.info
 *
 * powered by Kickstarter
 */
package me.rymate.moardamage.listeners;

import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.EntityDamageEvent;
import me.rymate.moardamage.MoarDamage;
import org.bukkit.entity.Player;

public class Listener_Entity extends EntityListener {

    private MoarDamage plugin;

    public Listener_Entity(MoarDamage plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEntityDamage(EntityDamageEvent event) {
        DamageCause damagetype = event.getCause().ENTITY_ATTACK;
        int eventDamage = event.getDamage();
        if (event.getCause().equals(damagetype)) {
            event.setDamage((eventDamage * plugin.getConfig_moardamage_damagemultiplyer()));
        }
    }
}
