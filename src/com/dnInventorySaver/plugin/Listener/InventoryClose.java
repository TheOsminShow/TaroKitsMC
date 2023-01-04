/*    */ package com.dnInventorySaver.plugin.Listener;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.RankInfoUtil;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.inventory.InventoryCloseEvent;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class InventoryClose
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void onInventoryClose(InventoryCloseEvent paramInventoryCloseEvent) {
/* 23 */     Player player = (Player)paramInventoryCloseEvent.getPlayer();
/*    */     
/* 25 */     if (Core.getInInvGUI().containsKey(player) && !Core.getInConfirmGUI().containsKey(player)) {
/*    */       
/* 27 */       OfflinePlayer offlinePlayer = (OfflinePlayer)Core.getOpenInv().get(player);
/* 28 */       String str = (String)Core.getInInvGUI().get(player);
/* 29 */       Inventory inventory = paramInventoryCloseEvent.getInventory();
/*    */       
/* 31 */       Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */             PlayerDataManager playerDataManager = new PlayerDataManager(paramOfflinePlayer);
/*    */             
/*    */             InventoryGuiManager inventoryGuiManager = new InventoryGuiManager(paramPlayer, paramOfflinePlayer, paramString);
/*    */             
/*    */             if (playerDataManager.isInventoryExists(paramString) && Core.getConfigManager().getBoolean("delete-if-inv-empty") && playerDataManager.isSavedInventoryEmpty(paramString)) {
/*    */               inventoryGuiManager.deleteInventory();
/*    */             }
/*    */           });
/*    */       
/* 41 */       Bukkit.getScheduler().runTaskLaterAsynchronously((Plugin)Core.getInstance(), () -> { if ((paramPlayer == paramOfflinePlayer && Objects.equals(Core.getRank().get(paramOfflinePlayer), "*")) || (paramPlayer == paramOfflinePlayer && RankInfoUtil.canEdit((String)Core.getRank().get(paramOfflinePlayer))) || (paramPlayer != paramOfflinePlayer && paramPlayer.hasPermission("invsaver.others.inv.edit") && !((Boolean)Core.getHasBypass().get(paramOfflinePlayer)).booleanValue())) { PlayerDataManager playerDataManager = new PlayerDataManager(paramOfflinePlayer); InventoryGuiManager inventoryGuiManager = new InventoryGuiManager(paramPlayer, paramOfflinePlayer, paramString); if (playerDataManager.isInventoryExists(paramString) && !playerDataManager.isInventoryDeleted(paramString)) inventoryGuiManager.updateInventory(paramInventory);  }  }5L);
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 57 */     Core.getOpenInv().remove(player);
/* 58 */     Core.getInSumGUI().remove(player);
/* 59 */     Core.getInInvGUI().remove(player);
/* 60 */     Core.getInConfirmGUI().remove(player);
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Listener\InventoryClose.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */