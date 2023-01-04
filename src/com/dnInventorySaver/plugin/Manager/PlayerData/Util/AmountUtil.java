/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AmountUtil
/*    */ {
/*    */   public static int getLiveInventoryAmount(PlayerDataManager paramPlayerDataManager) {
/* 10 */     byte b = 0;
/* 11 */     if (paramPlayerDataManager.getInventories() != null)
/*    */     {
/* 13 */       for (String str : paramPlayerDataManager.getInventories()) {
/* 14 */         if (!paramPlayerDataManager.isInventoryDeleted(str))
/* 15 */           b++; 
/*    */       }  } 
/* 17 */     return b;
/*    */   }
/*    */ }
