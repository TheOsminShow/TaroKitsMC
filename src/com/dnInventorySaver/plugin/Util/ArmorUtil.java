/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArmorUtil
/*    */ {
/*    */   public static boolean isHelmet(ItemStack paramItemStack) {
/* 10 */     return paramItemStack.getType().name().endsWith("_HELMET");
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isChestplate(ItemStack paramItemStack) {
/* 15 */     return (paramItemStack.getType().name().endsWith("_CHESTPLATE") || paramItemStack.getType().name().endsWith("ELYTRA"));
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isLeggings(ItemStack paramItemStack) {
/* 20 */     return paramItemStack.getType().name().endsWith("_LEGGINGS");
/*    */   }
/*    */ 
/*    */   
/*    */   public static boolean isBoots(ItemStack paramItemStack) {
/* 25 */     return paramItemStack.getType().name().endsWith("_BOOTS");
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Util\ArmorUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */