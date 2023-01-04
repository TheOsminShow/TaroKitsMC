/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RankInfoUtil
/*    */ {
/*    */   public static boolean canEdit(String paramString) {
/* 10 */     return Core.getConfigManager().getBoolean("PERMISSIONS." + paramString + ".edit");
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getSaveAmount(String paramString) {
/* 15 */     return Core.getConfigManager().getInt("PERMISSIONS." + paramString + ".amount");
/*    */   }
/*    */ 
/*    */   
/*    */   public static int getSavePrice(String paramString) {
/* 20 */     return Core.getConfigManager().getInt("PERMISSIONS." + paramString + ".save-price");
/*    */   }
/*    */ }
