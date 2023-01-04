/*    */ package com.dnInventorySaver.plugin.Manager.Gui.InventoryGui;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util.ClearUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util.DeleteUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util.LoadUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util.OpenUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ 
/*    */ public class InventoryGuiManager {
/*    */   private final Player opener;
/*    */   private final OfflinePlayer target;
/*    */   
/* 16 */   public Player getOpener() { return this.opener; } private final String invName; private final PlayerDataManager playerDataManager; public OfflinePlayer getTarget() {
/* 17 */     return this.target; }
/* 18 */   public String getInvName() { return this.invName; } public PlayerDataManager getPlayerDataManager() {
/* 19 */     return this.playerDataManager;
/*    */   }
/*    */   
/*    */   public InventoryGuiManager(Player paramPlayer, OfflinePlayer paramOfflinePlayer, String paramString) {
/* 23 */     this.opener = paramPlayer;
/* 24 */     this.target = paramOfflinePlayer;
/* 25 */     this.invName = paramString;
/* 26 */     this.playerDataManager = new PlayerDataManager(paramOfflinePlayer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void openInventory() {
/* 31 */     OpenUtil.OpenInventory(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateInventory(Inventory paramInventory) {
/* 36 */     this.playerDataManager.UpdateInventory(this.opener, this.invName, paramInventory);
/*    */   }
/*    */ 
/*    */   
/*    */   public void loadInventory() {
/* 41 */     LoadUtil.LoadInventory(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void deleteInventory() {
/* 46 */     DeleteUtil.DeleteInventory(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void clearInventories() {
/* 51 */     ClearUtil.ClearInventories(this);
/*    */   }
/*    */ }
