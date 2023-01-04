/*    */ package com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Builder.ContentBuilder;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.InPlayersUtil;
/*    */ import com.dnInventorySaver.plugin.Util.InventoryUtil;
/*    */ import com.dnInventorySaver.plugin.Util.PlayerHashUtil;
/*    */ import java.util.Set;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class OpenUtil
/*    */ {
/*    */   public static void OpenInventory(InventoryGuiManager paramInventoryGuiManager) {
/* 23 */     Player player = paramInventoryGuiManager.getOpener();
/* 24 */     OfflinePlayer offlinePlayer = paramInventoryGuiManager.getTarget();
/* 25 */     PlayerDataManager playerDataManager = paramInventoryGuiManager.getPlayerDataManager();
/* 26 */     String str = paramInventoryGuiManager.getInvName();
/*    */     
/* 28 */     if (!playerDataManager.isInventoryDeleted(str)) {
/*    */       Inventory inventory;
/* 30 */       int i = ((Integer)Core.getInSumGUI().get(player)).intValue();
/*    */ 
/*    */       
/* 33 */       Set<Player> set = InPlayersUtil.getInInvPlayers(Core.getInInvGUI(), InPlayersUtil.getOpenInvPlayers(Core.getOpenInv(), offlinePlayer), str);
/* 34 */       if (set.size() > 0) {
/*    */         
/* 36 */         inventory = ((Player)set.stream().findFirst().get()).getOpenInventory().getTopInventory();
/*    */       }
/*    */       else {
/*    */         
/* 40 */         inventory = InventoryUtil.createInventory(
/* 41 */             LanguageManager.getString("InvGUI.title").replaceAll("%invname%", str), 5);
/* 42 */         ContentBuilder.buildInventoryContent(playerDataManager, str, inventory);
/*    */       } 
/*    */       
/* 45 */       Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), () -> {
/*    */             paramPlayer.openInventory(paramInventory);
/*    */ 
/*    */ 
/*    */             
/*    */             PlayerHashUtil.putPlayerInHashMap(paramPlayer, paramOfflinePlayer, paramInt, paramString);
/*    */           });
/*    */     } else {
/* 53 */       paramInventoryGuiManager.deleteInventory();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\InventoryGui\Util\OpenUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */