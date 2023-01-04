/*    */ package com.dnInventorySaver.plugin.Manager.Gui.SumGui.Util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PageUtil
/*    */ {
/*    */   public static List<ItemStack> getPageItems(List<ItemStack> paramList, int paramInt1, int paramInt2) {
/* 14 */     int i = paramInt1 * paramInt2;
/* 15 */     int j = i - paramInt2;
/*    */     
/* 17 */     ArrayList<ItemStack> arrayList = new ArrayList();
/* 18 */     for (int k = j; k < i; k++) {
/*    */ 
/*    */       
/*    */       try {
/* 22 */         arrayList.add(paramList.get(k));
/*    */       }
/* 24 */       catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
/*    */     } 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 30 */     return arrayList;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isPageValid(List<ItemStack> paramList, int paramInt1, int paramInt2) {
/* 36 */     if (paramInt1 <= 0)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     int i = paramInt1 * paramInt2;
/* 42 */     int j = i - paramInt2;
/*    */     
/* 44 */     return (paramList.size() > j);
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\SumGui\Util\PageUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */