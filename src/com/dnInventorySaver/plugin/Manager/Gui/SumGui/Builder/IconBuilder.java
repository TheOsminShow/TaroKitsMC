/*    */ package com.dnInventorySaver.plugin.Manager.Gui.SumGui.Builder;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.ItemUtil;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IconBuilder
/*    */ {
/*    */   public static ArrayList<ItemStack> buildInventoryIcons(PlayerDataManager paramPlayerDataManager, Player paramPlayer) {
/* 20 */     ArrayList<ItemStack> arrayList = new ArrayList();
/* 21 */     OfflinePlayer offlinePlayer = paramPlayerDataManager.getPlayer();
/*    */     
/* 23 */     for (String str : paramPlayerDataManager.getInventories()) {
/*    */       
/* 25 */       if (paramPlayerDataManager.isInventoryDeleted(str) && paramPlayer == offlinePlayer) {
/*    */         
/* 27 */         ArrayList<String> arrayList1 = new ArrayList();
/* 28 */         for (String str1 : LanguageManager.getItemLore("Sumgui-dismiss-icon.lore"))
/*    */         {
/* 30 */           arrayList1.add(str1
/* 31 */               .replaceAll("%invname%", str)
/* 32 */               .replaceAll("%deletedby%", paramPlayerDataManager.getInventoryPlayerInfo(str, "deleted"))
/* 33 */               .replaceAll("%deletedat%", paramPlayerDataManager.getInventoryDateInfo(str, "deleted")));
/*    */         }
/*    */         
/* 36 */         ItemStack itemStack = ItemUtil.createItem(LanguageManager.getString("Sumgui-dismiss-icon.name-color") + str, Material.valueOf(Core.getConfigManager().getString("SumGUI.Dismiss.material")), arrayList1);
/* 37 */         arrayList.add(itemStack); continue;
/*    */       } 
/* 39 */       if (!paramPlayerDataManager.isInventoryDeleted(str)) {
/*    */         
/* 41 */         Material material = null;
/* 42 */         if (Core.getConfigManager().getBoolean("SumGUI.InvIcon.first-item")) {
/*    */           
/* 44 */           for (ItemStack itemStack1 : paramPlayerDataManager.getInventoryContent(str))
/*    */           {
/* 46 */             if (itemStack1 != null) {
/*    */               
/* 48 */               material = itemStack1.getType();
/*    */               
/*    */               break;
/*    */             } 
/* 52 */             material = Material.valueOf(Core.getConfigManager().getString("SumGUI.InvIcon.material"));
/*    */           }
/*    */         
/*    */         } else {
/*    */           
/* 57 */           material = Material.valueOf(Core.getConfigManager().getString("SumGUI.InvIcon.material"));
/*    */         } 
/*    */         
/* 60 */         ArrayList<String> arrayList1 = new ArrayList();
/* 61 */         for (String str1 : LanguageManager.getItemLore("Sumgui-normal-icon.lore")) {
/*    */           
/* 63 */           String str2 = paramPlayerDataManager.getInventoryPlayerInfo(str, "modified");
/* 64 */           if (str2 == null) str2 = "null"; 
/* 65 */           String str3 = String.valueOf(paramPlayerDataManager.getInventoryDateInfo(str, "modified"));
/* 66 */           if (str3 == null) str3 = "null";
/*    */           
/* 68 */           arrayList1.add(str1
/* 69 */               .replaceAll("%invname%", str)
/* 70 */               .replaceAll("%savedby%", paramPlayerDataManager.getInventoryPlayerInfo(str, "saved"))
/* 71 */               .replaceAll("%savedat%", paramPlayerDataManager.getInventoryDateInfo(str, "saved"))
/* 72 */               .replaceAll("%modifiedby%", str2)
/* 73 */               .replaceAll("%modifiedat%", str3));
/*    */         } 
/*    */ 
/*    */         
/* 77 */         ItemStack itemStack = ItemUtil.createItem(
/* 78 */             LanguageManager.getString("Sumgui-normal-icon.name-color") + str, material, arrayList1);
/*    */ 
/*    */ 
/*    */         
/* 82 */         arrayList.add(itemStack);
/*    */       } 
/*    */     } 
/*    */     
/* 86 */     return arrayList;
/*    */   }
/*    */ }
