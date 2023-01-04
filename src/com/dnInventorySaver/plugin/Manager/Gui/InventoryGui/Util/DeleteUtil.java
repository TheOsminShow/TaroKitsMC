/*    */ package com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.SumGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.InPlayersUtil;
/*    */ import java.util.Set;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeleteUtil
/*    */ {
/*    */   public static void DeleteInventory(InventoryGuiManager paramInventoryGuiManager) {
/* 21 */     Player player = paramInventoryGuiManager.getOpener();
/* 22 */     OfflinePlayer offlinePlayer = paramInventoryGuiManager.getTarget();
/* 23 */     PlayerDataManager playerDataManager = paramInventoryGuiManager.getPlayerDataManager();
/* 24 */     String str = paramInventoryGuiManager.getInvName();
/*    */     
/* 26 */     if (playerDataManager.isInventoryExists(str) && !playerDataManager.isInventoryDeleted(str)) {
/*    */       
/* 28 */       if (player == offlinePlayer)
/*    */       {
/* 30 */         playerDataManager.DeleteInventory(str);
/* 31 */         if (Core.getInConfirmGUI().containsKey(player) && !((ConfirmationType)Core.getInConfirmGUI().get(player)).equals(ConfirmationType.CLEAR))
/*    */         {
/* 33 */           player.sendMessage(LanguageManager.getString("inv-deleted").replaceAll("%invname%", str));
/*    */         }
/*    */       }
/* 36 */       else if (offlinePlayer.isOnline())
/*    */       {
/* 38 */         playerDataManager.DismissInventory(player, str);
/* 39 */         if (Core.getInConfirmGUI().containsKey(player) && !((ConfirmationType)Core.getInConfirmGUI().get(player)).equals(ConfirmationType.CLEAR))
/*    */         {
/* 41 */           offlinePlayer.getPlayer().sendMessage(LanguageManager.getString("inv-deleted-by-sb").replaceAll("%invname%", str).replaceAll("%player%", player.getName()));
/*    */         }
/*    */       }
/*    */       else
/*    */       {
/* 46 */         playerDataManager.DismissInventory(player, str);
/*    */       }
/*    */     
/* 49 */     } else if (playerDataManager.isInventoryDeleted(str)) {
/*    */       
/* 51 */       playerDataManager.DeleteInventory(str);
/*    */     } 
/*    */     
/* 54 */     Set set = InPlayersUtil.getOpenInvPlayers(Core.getOpenInv(), offlinePlayer);
/* 55 */     for (Player player1 : set) {
/*    */       
/* 57 */       if (player1 != player && player1 != offlinePlayer && Core.getInInvGUI().containsKey(player1))
/*    */       {
/* 59 */         player1.sendMessage(LanguageManager.getString("open-inv-deleted"));
/*    */       }
/* 61 */       if (Core.getInSumGUI().containsKey(player1)) {
/*    */         
/* 63 */         if (player1 == player && Core.getInConfirmGUI().containsKey(player1) && ((ConfirmationType)Core.getInConfirmGUI().get(player1)).equals(ConfirmationType.LOAD)) {
/*    */           
/* 65 */           Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), player::closeInventory);
/*    */           
/*    */           continue;
/*    */         } 
/* 69 */         (new SumGuiManager(player1, offlinePlayer)).openSumGui(((Integer)Core.getInSumGUI().get(player1)).intValue());
/*    */         
/*    */         continue;
/*    */       } 
/*    */       
/* 74 */       Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), player::closeInventory);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\InventoryGui\Util\DeleteUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */