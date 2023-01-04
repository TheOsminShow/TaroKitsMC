/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.ChatColor;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StringUtil
/*    */ {
/*    */   public static String translate(String paramString) {
/* 13 */     return ChatColor.translateAlternateColorCodes('&', paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public static List<String> translate(List<String> paramList) {
/* 18 */     ArrayList<String> arrayList = new ArrayList();
/*    */     
/* 20 */     for (String str : paramList) {
/* 21 */       arrayList.add(translate(str));
/*    */     }
/* 23 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Util\StringUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */