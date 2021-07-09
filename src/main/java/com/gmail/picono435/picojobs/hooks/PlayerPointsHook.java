package com.gmail.picono435.picojobs.hooks;

import org.black_ixx.playerpoints.PlayerPoints;
import org.black_ixx.playerpoints.PlayerPointsAPI;
import org.bukkit.Bukkit;

import com.gmail.picono435.picojobs.api.PicoJobsAPI;
import com.gmail.picono435.picojobs.hooks.economy.PointsImplementation;

public class PlayerPointsHook {
	
	private static boolean isEnabled = false;
	private static PlayerPoints playerPoints;
	
	public static void setupPlayerPoints() {
		if(Bukkit.getPluginManager().getPlugin("PlayerPoints") == null) {
			return;
		}
		isEnabled = true;
		hookPlayerPoints();
		PicoJobsAPI.registerEconomy(new PointsImplementation());
	}
	
	public static boolean isEnabled() {
		return isEnabled;
	}
	
	private static void hookPlayerPoints() {
	    playerPoints = PlayerPoints.getInstance();
	}
	
	public static PlayerPointsAPI getPlayerPointsAPI() {
		return playerPoints.getAPI();
	}
}
