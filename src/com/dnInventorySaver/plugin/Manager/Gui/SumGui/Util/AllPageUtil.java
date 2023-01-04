/*    */ package com.dnInventorySaver.plugin.Manager.Gui.SumGui.Util;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllPageUtil
/*    */ {
/*    */   public static int getAllPage(List<ItemStack> paramList, int paramInt) {
/* 12 */     byte b = 1; while (true) {
/* 13 */       b++;
/* 14 */       if (!PageUtil.isPageValid(paramList, b, paramInt))
/* 15 */         return b - 1; 
/*    */     } 
/*    */   }
/*    */ }
