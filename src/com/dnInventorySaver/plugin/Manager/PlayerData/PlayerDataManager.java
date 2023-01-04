/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.Util.AmountUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.Util.DeleteUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.Util.GetInvNamesUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.Util.InvExistsUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.Util.InvInfoUtil;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class PlayerDataManager {
/*    */   private final OfflinePlayer player;
/*    */   private final int invAmount;
/*    */   
/* 18 */   public OfflinePlayer getPlayer() { return this.player; } private final int liveInvAmount; private final ArrayList<String> inventories; private final String playerRank; public int getInvAmount() {
/* 19 */     return this.invAmount; }
/* 20 */   public int getLiveInvAmount() { return this.liveInvAmount; }
/* 21 */   public ArrayList<String> getInventories() { return this.inventories; } public String getPlayerRank() {
/* 22 */     return this.playerRank;
/*    */   }
/*    */   
/*    */   public PlayerDataManager(OfflinePlayer paramOfflinePlayer) {
/* 26 */     this.player = paramOfflinePlayer;
/* 27 */     this.inventories = GetInvNamesUtil.getInventories(paramOfflinePlayer);
/* 28 */     this.invAmount = this.inventories.size();
/* 29 */     this.liveInvAmount = AmountUtil.getLiveInventoryAmount(this);
/* 30 */     this.playerRank = PlayerRankUtil.getPlayerRank(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isInventoryExists(String paramString) {
/* 35 */     return InvExistsUtil.isInventoryNameExists(this, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isInventoryDeleted(String paramString) {
/* 40 */     return DeleteUtil.isInventoryDeleted(this.player, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSavedInventoryEmpty(String paramString) {
/* 45 */     return SavedInvEmptyUtil.isSavedInventoryEmpty(this.player, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void SaveInventory(Player paramPlayer, String paramString) {
/* 50 */     SaveContentUtil.saveInventory(paramPlayer, (Player)this.player, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void UpdateInventory(Player paramPlayer, String paramString, Inventory paramInventory) {
/* 55 */     UpdateContentUtil.UpdateInventoryContent(paramPlayer, paramInventory, this, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void DismissInventory(Player paramPlayer, String paramString) {
/* 60 */     DeleteUtil.dismissInventory(paramPlayer, this.player, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void DeleteInventory(String paramString) {
/* 65 */     DeleteUtil.deleteInventory(this.player, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack[] getInventoryContent(String paramString) {
/* 70 */     return GetContentUtil.getInventoryContent(this.player, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getInventoryDateInfo(String paramString1, String paramString2) {
/* 75 */     return InvInfoUtil.getDateInfo(this.player, paramString1, paramString2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getInventoryPlayerInfo(String paramString1, String paramString2) {
/* 80 */     return InvInfoUtil.getPlayerInfo(this.player, paramString1, paramString2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isPlayerHasPermissions(String paramString) {
/* 86 */     return PermissionUtil.playerHasPermissions(this.player, paramString);
/*    */   }
/*    */ }
