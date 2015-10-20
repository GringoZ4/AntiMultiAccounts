/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bandalicraft.antiamult;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPreLoginEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Fernando
 */
public class Main extends JavaPlugin implements Listener{
    public FileUtilsWrite playersip;
    @Override
    public void onEnable()

    {
        playersip= new FileUtilsWrite("plugins/AntiMultiAccount/playersip.txt");
     Bukkit.getPluginManager().registerEvents(this, this);    
         getServer().getConsoleSender().sendMessage("[AntiMultiAccoutn]Plugin activado");
        // playersip.
    }
    @Override
    public void onDisable(){
        getServer().getConsoleSender().sendMessage("[AntiMultiAccoutn]}Plugin desactivado");
    }
    
      @EventHandler
    public void onJoin(PlayerPreLoginEvent e){
        
       
        
    }
    
}
