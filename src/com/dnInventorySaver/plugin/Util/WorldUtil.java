/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldUtil
/*    */ {
/*    */   public static boolean disableWorld(Player paramPlayer) {
/* 13 */     if (!paramPlayer.hasPermission("invsaver.bypass.disabledworlds")) {
/*    */       
/* 15 */       String str = paramPlayer.getWorld().getName();
/* 16 */       for (String str1 : Core.getConfigManager().getList("open-inv-with-block.disabled-worlds")) {
/*    */         
/* 18 */         if (Objects.equals(str1, str))
/* 19 */           return true; 
/*    */       } 
/*    */     } 
/* 22 */     return false;
/*    */   }
/*    */ }
