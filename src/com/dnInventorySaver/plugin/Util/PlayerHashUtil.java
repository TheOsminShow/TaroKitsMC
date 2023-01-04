/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerHashUtil
/*    */ {
/*    */   public static void putPlayerInHashMap(Player paramPlayer, OfflinePlayer paramOfflinePlayer, int paramInt) {
/* 13 */     Core.getOpenInv().put(paramPlayer, paramOfflinePlayer);
/* 14 */     Core.getInSumGUI().put(paramPlayer, Integer.valueOf(paramInt));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void putPlayerInHashMap(Player paramPlayer, OfflinePlayer paramOfflinePlayer, ConfirmationType paramConfirmationType) {
/* 19 */     Core.getOpenInv().put(paramPlayer, paramOfflinePlayer);
/* 20 */     Core.getInConfirmGUI().put(paramPlayer, paramConfirmationType);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void putPlayerInHashMap(Player paramPlayer, OfflinePlayer paramOfflinePlayer, String paramString, ConfirmationType paramConfirmationType) {
/* 25 */     Core.getOpenInv().put(paramPlayer, paramOfflinePlayer);
/* 26 */     Core.getInInvGUI().put(paramPlayer, paramString);
/* 27 */     Core.getInConfirmGUI().put(paramPlayer, paramConfirmationType);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void putPlayerInHashMap(Player paramPlayer, OfflinePlayer paramOfflinePlayer, int paramInt, String paramString) {
/* 32 */     Core.getOpenInv().put(paramPlayer, paramOfflinePlayer);
/* 33 */     Core.getInSumGUI().put(paramPlayer, Integer.valueOf(paramInt));
/* 34 */     Core.getInInvGUI().put(paramPlayer, paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void putPlayerInHashMap(Player paramPlayer, OfflinePlayer paramOfflinePlayer, int paramInt, String paramString, ConfirmationType paramConfirmationType) {
/* 39 */     Core.getOpenInv().put(paramPlayer, paramOfflinePlayer);
/* 40 */     Core.getInSumGUI().put(paramPlayer, Integer.valueOf(paramInt));
/* 41 */     Core.getInInvGUI().put(paramPlayer, paramString);
/* 42 */     Core.getInConfirmGUI().put(paramPlayer, paramConfirmationType);
/*    */   }
/*    */ }
