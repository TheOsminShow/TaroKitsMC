/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SavedInvEmptyUtil
/*    */ {
/*    */   public static boolean isSavedInventoryEmpty(OfflinePlayer paramOfflinePlayer, String paramString) {
/*    */     try {
/* 14 */       PlayerDataManager playerDataManager = new PlayerDataManager(paramOfflinePlayer);
/* 15 */       for (ItemStack itemStack : playerDataManager.getInventoryContent(paramString)) {
/* 16 */         if (itemStack != null)
/* 17 */           return false; 
/* 18 */       }  return true;
/*    */     } catch (Throwable throwable) {
/*    */       throw throwable;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\PlayerData\Util\SavedInvEmptyUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */