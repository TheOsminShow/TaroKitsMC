/*    */ package com.dnInventorySaver.plugin.Command.Argument;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.ConfirmationGui.ConfirmationGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ public class DeleteArgument
/*    */ {
/*    */   public static void deleteInventory(Player paramPlayer, String paramString) {
/* 16 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)paramPlayer);
/*    */           if (playerDataManager.isInventoryExists(paramString) && !playerDataManager.isInventoryDeleted(paramString)) {
/*    */             (new ConfirmationGuiManager(paramPlayer, ConfirmationType.DELETE)).openGui(paramString);
/*    */           } else {
/*    */             paramPlayer.sendMessage(LanguageManager.getString("inv-dont-exists"));
/*    */           } 
/*    */         });
/*    */   }
/*    */ }
