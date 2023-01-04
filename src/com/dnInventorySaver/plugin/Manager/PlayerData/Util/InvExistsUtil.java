/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import java.util.Objects;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InvExistsUtil
/*    */ {
/*    */   public static boolean isInventoryNameExists(PlayerDataManager paramPlayerDataManager, String paramString) {
/* 11 */     for (String str : paramPlayerDataManager.getInventories()) {
/*    */       
/* 13 */       if (Objects.equals(str, paramString))
/* 14 */         return true; 
/*    */     } 
/* 16 */     return false;
/*    */   }
/*    */ }
