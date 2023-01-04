/*    */ package com.dnInventorySaver.plugin.Manager.Gui.ConfirmationGui;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.ConfirmationGui.Builder.ContentBuilder;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*    */ import com.dnInventorySaver.plugin.Util.InventoryUtil;
/*    */ import com.dnInventorySaver.plugin.Util.PlayerHashUtil;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class ConfirmationGuiManager
/*    */ {
/*    */   private final Player opener;
/*    */   private final ConfirmationType confirmationType;
/*    */   
/*    */   public ConfirmationGuiManager(Player paramPlayer, ConfirmationType paramConfirmationType) {
/* 23 */     this.opener = paramPlayer;
/* 24 */     this.confirmationType = paramConfirmationType;
/*    */   }
/*    */ 
/*    */   
/*    */   public void openGui(OfflinePlayer paramOfflinePlayer, String paramString, int paramInt) {
/* 29 */     Inventory inventory = createGui(paramOfflinePlayer, paramString);
/* 30 */     if (inventory == null)
/*    */       return; 
/* 32 */     ContentBuilder.buildConfirmationGuiContent(inventory, this.confirmationType);
/*    */     
/* 34 */     Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), () -> {
/*    */           this.opener.openInventory(paramInventory);
/*    */           PlayerHashUtil.putPlayerInHashMap(this.opener, paramOfflinePlayer, paramInt, paramString, this.confirmationType);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void openGui(String paramString) {
/* 43 */     Inventory inventory = createGui((OfflinePlayer)this.opener, paramString);
/* 44 */     if (inventory == null)
/*    */       return; 
/* 46 */     ContentBuilder.buildConfirmationGuiContent(inventory, this.confirmationType);
/*    */     
/* 48 */     Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), () -> {
/*    */           this.opener.openInventory(paramInventory);
/*    */           PlayerHashUtil.putPlayerInHashMap(this.opener, (OfflinePlayer)this.opener, paramString, this.confirmationType);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void openGui(OfflinePlayer paramOfflinePlayer) {
/* 57 */     Inventory inventory = createGui(paramOfflinePlayer, null);
/* 58 */     if (inventory == null)
/*    */       return; 
/* 60 */     ContentBuilder.buildConfirmationGuiContent(inventory, this.confirmationType);
/*    */     
/* 62 */     Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), () -> {
/*    */           this.opener.openInventory(paramInventory);
/*    */           PlayerHashUtil.putPlayerInHashMap(this.opener, paramOfflinePlayer, this.confirmationType);
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private Inventory createGui(OfflinePlayer paramOfflinePlayer, String paramString) {
/* 71 */     switch (this.confirmationType) {
/*    */       
/*    */       case DELETE:
/* 74 */         if (!Core.getConfigManager().getBoolean("confirmation-gui.delete")) {
/*    */           
/* 76 */           Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(this.opener, paramOfflinePlayer, paramString)).deleteInventory());
/*    */           
/* 78 */           return null;
/*    */         } 
/*    */       case CLEAR:
/* 81 */         if (!Core.getConfigManager().getBoolean("confirmation-gui.clear")) {
/*    */           
/* 83 */           Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(this.opener, paramOfflinePlayer, null)).clearInventories());
/*    */           
/* 85 */           return null;
/*    */         } 
/*    */       case LOAD:
/* 88 */         if (!Core.getConfigManager().getBoolean("confirmation-gui.load")) {
/*    */           
/* 90 */           Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(this.opener, paramOfflinePlayer, paramString)).loadInventory());
/*    */           
/* 92 */           return null;
/*    */         } 
/*    */         break;
/*    */     } 
/* 96 */     return InventoryUtil.createInventory(
/* 97 */         LanguageManager.getString("ConfirmationGui." + this.confirmationType.toString().toLowerCase() + ".title"), 1);
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\ConfirmationGui\ConfirmationGuiManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */