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
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Listener_Entity extends EntityListener {

    private MoarDamage plugin;

    public Listener_Entity(MoarDamage plugin) {
        this.plugin = plugin;
    }

    @Override
    public void onEntityDamage(EntityDamageEvent event) {
        if (!(event instanceof EntityDamageByEntityEvent)) {
            return;
        }
        EntityDamageByEntityEvent subevent = (EntityDamageByEntityEvent) event;
        if (event.getEntity() instanceof Player && subevent.getDamager() instanceof Monster) {
            onEntityVsPlayer(subevent);
        } else if (subevent.getDamager() instanceof Player && event.getEntity() instanceof Monster) {
            onPlayerVsEntity(subevent);
        }
    }

    private void onEntityVsPlayer(EntityDamageByEntityEvent event) {
        int damage = event.getDamage();
        event.setDamage(damage*plugin.getConfig_moardamage_damagemultiplyer());
    }

    private void onPlayerVsEntity(EntityDamageByEntityEvent event) {
        //TODO Do stuff
    }
}
