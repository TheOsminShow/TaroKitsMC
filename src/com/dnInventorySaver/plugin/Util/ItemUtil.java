/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import java.util.List;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemUtil
/*    */ {
/*    */   public static ItemStack createItem(String paramString, Material paramMaterial) {
/* 14 */     ItemStack itemStack = new ItemStack(paramMaterial);
/* 15 */     ItemMeta itemMeta = itemStack.getItemMeta();
/* 16 */     itemMeta.setDisplayName(StringUtil.translate(paramString));
/* 17 */     itemStack.setItemMeta(itemMeta);
/* 18 */     return itemStack;
/*    */   }
/*    */ 
/*    */   
/*    */   public static ItemStack createItem(String paramString, Material paramMaterial, List<String> paramList) {
/* 23 */     ItemStack itemStack = new ItemStack(paramMaterial);
/* 24 */     ItemMeta itemMeta = itemStack.getItemMeta();
/* 25 */     itemMeta.setDisplayName(StringUtil.translate(paramString));
/* 26 */     itemMeta.setLore(StringUtil.translate(paramList));
/* 27 */     itemStack.setItemMeta(itemMeta);
/* 28 */     return itemStack;
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Util\ItemUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */