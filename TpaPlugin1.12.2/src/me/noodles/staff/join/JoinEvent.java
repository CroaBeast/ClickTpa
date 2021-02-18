package me.noodles.staff.join;

import org.bukkit.event.player.*;

import me.noodles.staff.Main;
import me.noodles.staff.util.UpdateChecker;

import org.bukkit.ChatColor;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class JoinEvent implements Listener
{
	
	public UpdateChecker checker;
	
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
    	Player p = e.getPlayer();
    	if (p.hasPermission("staffmode.update")) {
    		if (Main.getPlugin().getConfig().getBoolean("Update.Enabled") == true){
    		this.checker = new UpdateChecker(Main.plugin);
                        if (this.checker.isConnected()) {
                            if (this.checker.hasUpdate()) {
                            	p.sendMessage(ChatColor.GRAY + "=========================");
                                p.sendMessage(ChatColor.RED + "StaffMode is outdated!");
                                p.sendMessage(ChatColor.GREEN + "Newest version: " + this.checker.getLatestVersion());
                                p.sendMessage(ChatColor.RED + "Your version: " + Main.plugin.getDescription().getVersion());
                                p.sendMessage(ChatColor.GRAY + "=========================");
                            }
                        }               
       }
    }
}
}
    