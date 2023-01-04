/*    */ package com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Builder;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.ItemUtil;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContentBuilder
/*    */ {
/*    */   public static void buildInventoryContent(PlayerDataManager paramPlayerDataManager, String paramString, Inventory paramInventory) {
/* 15 */     paramInventory.setContents(paramPlayerDataManager.getInventoryContent(paramString));
/*    */     
/* 17 */     paramInventory.setItem(42, ItemUtil.createItem(LanguageManager.getString("InvGUI.back"), Material.valueOf(Core.getConfigManager().getString("InvGUI.Back.material"))));
/* 18 */     paramInventory.setItem(43, ItemUtil.createItem(LanguageManager.getString("InvGUI.load"), Material.valueOf(Core.getConfigManager().getString("InvGUI.Load.material"))));
/* 19 */     paramInventory.setItem(44, ItemUtil.createItem(LanguageManager.getString("InvGUI.delete"), Material.valueOf(Core.getConfigManager().getString("InvGUI.Delete.material"))));
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\InventoryGui\Builder\ContentBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */