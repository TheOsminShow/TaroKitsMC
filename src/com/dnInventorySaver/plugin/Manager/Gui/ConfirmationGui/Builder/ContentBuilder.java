/*    */ package com.dnInventorySaver.plugin.Manager.Gui.ConfirmationGui.Builder;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Util.ItemUtil;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContentBuilder
/*    */ {
/*    */   public static void buildConfirmationGuiContent(Inventory paramInventory, ConfirmationType paramConfirmationType) {
/* 16 */     ItemStack itemStack1 = ItemUtil.createItem(
/* 17 */         LanguageManager.getString("ConfirmationGui." + paramConfirmationType.toString().toLowerCase() + ".cancel-item"), 
/* 18 */         Material.valueOf(Core.getConfigManager().getString("ConfirmationGui." + paramConfirmationType.toString().toLowerCase() + ".cancel-item-material")));
/* 19 */     ItemStack itemStack2 = ItemUtil.createItem(
/* 20 */         LanguageManager.getString("ConfirmationGui." + paramConfirmationType.toString().toLowerCase() + ".accept-item"), 
/* 21 */         Material.valueOf(Core.getConfigManager().getString("ConfirmationGui." + paramConfirmationType.toString().toLowerCase() + ".accept-item-material")));
/*    */     
/* 23 */     for (byte b = 0; b < 9; b++)
/*    */     {
/* 25 */       paramInventory.setItem(b, itemStack1);
/*    */     }
/* 27 */     paramInventory.setItem(4, itemStack2);
/*    */   }
/*    */ }
