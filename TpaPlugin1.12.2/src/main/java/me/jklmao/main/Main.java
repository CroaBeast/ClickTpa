package me.jklmao.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.jklmao.commands.CommandReload;
import me.jklmao.commands.CommandTpCancel;
import me.jklmao.commands.CommandTpToggle;
import me.jklmao.commands.CommandTpa;
import me.jklmao.commands.CommandTpaDeny;
import me.jklmao.commands.CommandTpaHere;
import me.jklmao.commands.CommandTpo;
import me.jklmao.commands.CommandTpoHere;
import me.jklmao.commands.Commands;
import me.jklmao.events.PlayerEvents;

public class Main extends JavaPlugin {
	
	public static Main main;
	public static Main main1;
	public HashMap<Player, Player> tpacommandlist = new HashMap<Player, Player>();
	public HashMap<Player, Player> tpaherecommandlist = new HashMap<Player, Player>();
	public HashMap<String, String> tpacancel = new HashMap<String, String>();
	public ArrayList<Player> tptoggled = new ArrayList<Player>();
	public ArrayList<Player> willTeleport = new ArrayList<Player>();

	
	
	@Override
	public void onEnable() {
	
		main = this;
		main1 = this;
		saveDefaultConfig();
		
		getLogger().info("Loaded Successfully!");
		
		this.getCommand("tpa").setExecutor(new CommandTpa(this));
		this.getCommand("tpahere").setExecutor(new CommandTpaHere(this));
		this.getCommand("tpacancel").setExecutor(new CommandTpCancel(this));
		this.getCommand("tpaccept").setExecutor(new Commands(this));
		this.getCommand("tpdeny").setExecutor(new CommandTpaDeny(this));
		this.getCommand("tpo").setExecutor(new CommandTpo(this));
		this.getCommand("tpohere").setExecutor(new CommandTpoHere(this));
		this.getCommand("tptoggle").setExecutor(new CommandTpToggle(this));
		this.getCommand("clicktparl").setExecutor(new CommandReload(this));
		this.getServer().getPluginManager().registerEvents(new PlayerEvents(this), this);

	}


	
	public HashMap<Player, Player> getHash() {
		return this.tpacommandlist;
	}
	
	public HashMap<Player, Player> getTpaHere() {
		return this.tpaherecommandlist;
	}

	public HashMap<String, String> getTpaCancel(){
		return this.tpacancel;
	}
	


	
	public ArrayList<Player> getTpToggled(){
		return this.tptoggled;
	}
	
	public ArrayList<Player> getTeleportStatus(){
		return this.willTeleport;
	}
	
	public void reloadTheConfig() {
		this.reloadConfig();
	}

	
	
	

}