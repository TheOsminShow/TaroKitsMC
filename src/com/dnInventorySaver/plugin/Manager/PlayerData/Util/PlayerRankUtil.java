/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerRankUtil
/*    */ {
/*    */   public static String getPlayerRank(PlayerDataManager paramPlayerDataManager) {
/* 11 */     if (paramPlayerDataManager.isPlayerHasPermissions("invsaver.group.*")) {
/* 12 */       return "*";
/*    */     }
/*    */     
/* 15 */     for (String str1 : Core.getConfigManager().getConfigSectionKeys("PERMISSIONS")) {
/*    */       
/* 17 */       String str2 = Core.getInstance().getConfig().getString("PERMISSIONS." + str1 + ".permission");
/* 18 */       if (str2 != null && paramPlayerDataManager.isPlayerHasPermissions(str2) && str2.startsWith("invsaver.group."))
/*    */       {
/* 20 */         return str1;
/*    */       }
/*    */     } 
/*    */     
/* 24 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\PlayerData\Util\PlayerRankUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */