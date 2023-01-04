/*    */ package com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class ClearUtil
/*    */ {
/*    */   public static void ClearInventories(InventoryGuiManager paramInventoryGuiManager) {
/* 16 */     Player player = paramInventoryGuiManager.getOpener();
/* 17 */     OfflinePlayer offlinePlayer = paramInventoryGuiManager.getTarget();
/* 18 */     PlayerDataManager playerDataManager = paramInventoryGuiManager.getPlayerDataManager();
/*    */     
/* 20 */     for (String str : playerDataManager.getInventories()) {
/*    */       
/* 22 */       if (playerDataManager.isInventoryExists(str) && !playerDataManager.isInventoryDeleted(str)) {
/*    */         
/* 24 */         InventoryGuiManager inventoryGuiManager = new InventoryGuiManager(player, offlinePlayer, str);
/* 25 */         inventoryGuiManager.deleteInventory();
/*    */       } 
/*    */     } 
/* 28 */     player.sendMessage(LanguageManager.getString("inv-clear"));
/* 29 */     if (offlinePlayer.isOnline())
/*    */     {
/* 31 */       offlinePlayer.getPlayer().sendMessage(LanguageManager.getString("inv-clear-by").replaceAll("%player%", player.getName()));
/*    */     }
/* 33 */     Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), player::closeInventory);
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\InventoryGui\Util\ClearUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */