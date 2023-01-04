/*    */ package com.dnInventorySaver.plugin.Listener;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryDragEvent;
/*    */ 
/*    */ 
/*    */ public class InventoryDrag
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInventoryDrag(InventoryDragEvent paramInventoryDragEvent) {
/* 15 */     Player player = (Player)paramInventoryDragEvent.getWhoClicked();
/* 16 */     if (Core.getOpenInv().containsKey(player)) paramInventoryDragEvent.setCancelled(true); 
/*    */   }
/*    */ }
