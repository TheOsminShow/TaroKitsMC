/*    */ package com.dnInventorySaver.plugin.Manager.Gui.SumGui.Builder;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Util.PageUtil;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IconPlacer
/*    */ {
/*    */   public static void placeInventoryIcons(Inventory paramInventory, int paramInt, ArrayList<ItemStack> paramArrayList) {
/*    */     byte b;
/* 16 */     for (b = 0; b < 9; b++) {
/*    */       
/* 18 */       if (paramInventory.getItem(b) == null) {
/* 19 */         paramInventory.setItem(b, new ItemStack(Material.STONE));
/*    */       }
/*    */     } 
/* 22 */     for (ItemStack itemStack : PageUtil.getPageItems(paramArrayList, paramInt, Core.getConfigManager().getSumGuiSpace())) {
/* 23 */       paramInventory.setItem(paramInventory.firstEmpty(), itemStack);
/*    */     }
/* 25 */     for (b = 0; b < 9; b++) {
/*    */       
/* 27 */       if (paramInventory.getItem(b).getType() == Material.STONE)
/* 28 */         paramInventory.clear(b); 
/*    */     } 
/*    */   }
/*    */ }
