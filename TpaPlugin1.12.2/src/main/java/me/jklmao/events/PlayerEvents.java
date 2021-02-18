package me.jklmao.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.jklmao.main.Main;

public class PlayerEvents implements Listener {

	private Main clicktpa;

	public PlayerEvents(Main pl) {
		clicktpa = pl;
	}

	@EventHandler
	public void onWalk(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (clicktpa.getTeleportStatus().contains(p)) {
			if (e.getFrom().getX() != e.getTo().getX() || e.getFrom().getZ() != e.getTo().getZ()) { // full block }
				clicktpa.getTeleportStatus().clear();
			}
		} else
			return;

	}

	public static String colorize(String message) {
		return ChatColor.translateAlternateColorCodes('&', message);
	}

}
