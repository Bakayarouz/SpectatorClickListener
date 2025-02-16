package com.yourname.spectatorclicklistener;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent.Action;
import org.bukkit.plugin.java.JavaPlugin;

public class SpectatorClickListener extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Register events when the plugin starts
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("SpectatorClickListener has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("SpectatorClickListener has been disabled.");
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        // Check if the player is in Spectator mode
        if (player.getGameMode() == GameMode.SPECTATOR) {

            // Check if the player performed a left-click action
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                // Handle left-click in Spectator mode
                player.sendMessage("You left-clicked in Spectator mode!");
            } 
            // Check if the player performed a right-click action
            else if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                // Handle right-click in Spectator mode
                player.sendMessage("You right-clicked in Spectator mode!");
            }
        }
    }
}
