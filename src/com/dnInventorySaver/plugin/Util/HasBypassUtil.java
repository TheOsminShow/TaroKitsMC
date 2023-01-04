/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HasBypassUtil
/*    */ {
/*    */   public static void checkIfPlayerHasBypass(PlayerDataManager paramPlayerDataManager) {
/* 11 */     if (paramPlayerDataManager.isPlayerHasPermissions("invsaver.bypass.edit")) {
/* 12 */       Core.getHasBypass().put(paramPlayerDataManager.getPlayer(), Boolean.valueOf(true));
/*    */     } else {
/* 14 */       Core.getHasBypass().put(paramPlayerDataManager.getPlayer(), Boolean.valueOf(false));
/*    */     } 
/*    */   }
/*    */ }
