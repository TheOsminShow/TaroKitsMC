/*    */ package com.dnInventorySaver.plugin.Manager.Gui.SumGui.Builder;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Util.PageUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.ItemUtil;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NavBuilder
/*    */ {
/*    */   public static void buildNavigation(Inventory paramInventory, int paramInt, ArrayList<ItemStack> paramArrayList, PlayerDataManager paramPlayerDataManager) {
/*    */     ItemStack itemStack1;
/* 21 */     OfflinePlayer offlinePlayer = paramPlayerDataManager.getPlayer();
/*    */ 
/*    */     
/* 24 */     if (PageUtil.isPageValid(paramArrayList, paramInt - 1, Core.getConfigManager().getSumGuiSpace())) {
/*    */       
/* 26 */       itemStack1 = ItemUtil.createItem(
/* 27 */           LanguageManager.getString("Sumgui-nav-icons.go-left"), 
/* 28 */           Material.valueOf(Core.getConfigManager().getString("SumGUI.LeftNav.material")));
/*    */     }
/*    */     else {
/*    */       
/* 32 */       itemStack1 = ItemUtil.createItem(
/* 33 */           LanguageManager.getString("Sumgui-nav-icons.close"), 
/* 34 */           Material.valueOf(Core.getConfigManager().getString("SumGUI.LeftNav.material")));
/*    */     } 
/* 36 */     paramInventory.setItem(30, itemStack1);
/*    */     
/* 38 */     ArrayList<String> arrayList = new ArrayList();
/* 39 */     for (String str : LanguageManager.getItemLore("Sumgui-info-icon.lore"))
/*    */     {
/* 41 */       arrayList.add(str
/* 42 */           .replaceAll("%target%", offlinePlayer.getName())
/* 43 */           .replaceAll("%number%", "" + paramPlayerDataManager.getLiveInvAmount()));
/*    */     }
/*    */     
/* 46 */     ItemStack itemStack2 = ItemUtil.createItem(
/* 47 */         LanguageManager.getString("Sumgui-info-icon.name").replaceAll("%page%", "" + paramInt), 
/* 48 */         Material.valueOf(Core.getConfigManager().getString("SumGUI.Info.material")), arrayList);
/*    */     
/* 50 */     paramInventory.setItem(31, itemStack2);
/*    */     
/* 52 */     if (PageUtil.isPageValid(paramArrayList, paramInt + 1, Core.getConfigManager().getSumGuiSpace())) {
/*    */       
/* 54 */       ItemStack itemStack = ItemUtil.createItem(
/* 55 */           LanguageManager.getString("Sumgui-nav-icons.go-right"), Material.valueOf(Core.getConfigManager().getString("SumGUI.RightNav.material")));
/* 56 */       paramInventory.setItem(32, itemStack);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\SumGui\Builder\NavBuilder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */