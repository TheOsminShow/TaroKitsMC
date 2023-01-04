/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collections;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InventoryUtil
/*    */ {
/*    */   public static Inventory createInventory(String paramString, int paramInt) {
/* 16 */     return Bukkit.getServer().createInventory(null, paramInt * 9, StringUtil.translate(paramString));
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean playerInvEmpty(Player paramPlayer) {
/* 21 */     for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
/* 22 */       if (itemStack != null) return false; 
/*    */     } 
/* 24 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static ArrayList<ItemStack> getPlayerInventoryContent(Player paramPlayer) {
/* 29 */     ArrayList<? super ItemStack> arrayList = new ArrayList();
/* 30 */     Collections.addAll(arrayList, paramPlayer.getInventory().getContents());
/*    */     
/* 32 */     if (arrayList.size() == 36) {
/* 33 */       Collections.addAll(arrayList, paramPlayer.getInventory().getArmorContents());
/*    */     }
/* 35 */     return (ArrayList)arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Util\InventoryUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */