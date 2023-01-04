/*    */ package com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.InventoryUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoadUtil
/*    */ {
/*    */   public static void LoadInventory(InventoryGuiManager paramInventoryGuiManager) {
/* 22 */     Player player = paramInventoryGuiManager.getOpener();
/* 23 */     OfflinePlayer offlinePlayer = paramInventoryGuiManager.getTarget();
/* 24 */     PlayerDataManager playerDataManager = paramInventoryGuiManager.getPlayerDataManager();
/* 25 */     String str = paramInventoryGuiManager.getInvName();
/*    */     
/* 27 */     ArrayList<ItemStack> arrayList = new ArrayList(Arrays.asList((Object[])playerDataManager.getInventoryContent(str)));
/*    */     
/* 29 */     if (player == offlinePlayer && Core.getConfigManager().getBoolean("load-inv-delete")) {
/*    */       
/* 31 */       paramInventoryGuiManager.deleteInventory();
/*    */     }
/* 33 */     else if (player != offlinePlayer && Core.getConfigManager().getBoolean("load-other-inv-delete")) {
/*    */       
/* 35 */       paramInventoryGuiManager.deleteInventory();
/*    */     }
/*    */     else {
/*    */       
/* 39 */       player.closeInventory();
/*    */     } 
/*    */     
/* 42 */     if (!InventoryUtil.playerInvEmpty(player)) {
/*    */       
/* 44 */       player.sendMessage(LanguageManager.getString("inv-not-empty"));
/* 45 */       for (ItemStack itemStack : InventoryUtil.getPlayerInventoryContent(player)) {
/*    */         
/* 47 */         if (itemStack != null && itemStack.getType() != Material.AIR) {
/*    */           
/* 49 */           player.getWorld().dropItemNaturally(player.getLocation(), itemStack);
/* 50 */           player.getInventory().removeItem(new ItemStack[] { itemStack });
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 55 */     if ((player.getInventory().getContents()).length == 36) {
/*    */       
/* 57 */       for (byte b = 0; b < 36; b++)
/*    */       {
/* 59 */         player.getInventory().setItem(b, arrayList.get(b));
/*    */       }
/* 61 */       player.getInventory().setBoots(arrayList.get(36));
/* 62 */       player.getInventory().setLeggings(arrayList.get(37));
/* 63 */       player.getInventory().setChestplate(arrayList.get(38));
/* 64 */       player.getInventory().setHelmet(arrayList.get(39));
/*    */     }
/*    */     else {
/*    */       
/* 68 */       player.getInventory().setContents(arrayList.<ItemStack>toArray(new ItemStack[0]));
/*    */     } 
/*    */     
/* 71 */     player.sendMessage(LanguageManager.getString("inv-loaded").replaceAll("%invname%", str));
/* 72 */     Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), player::closeInventory);
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\InventoryGui\Util\LoadUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */