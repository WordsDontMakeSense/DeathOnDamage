package me.wordsdontmakesense.deathondamage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

import javax.swing.text.html.parser.Entity;

public final class DeathOnDamage extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "DeathOnDamage started!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "DeathOnDamage ended!");
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent event)
    {
        Player player;
        if(event.getEntity() instanceof Player) {
            player = (Player) event.getEntity();
            player.setHealth(0L);
            getServer().broadcastMessage(player.getName() + " took damage!");
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        event.setDeathMessage(null);
    }
}
