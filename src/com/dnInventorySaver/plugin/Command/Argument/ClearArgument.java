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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ClearArgument
/*    */ {
/*    */   public static void clearInventories(Player paramPlayer) {
/* 20 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           if (paramPlayer.hasPermission("invsaver.command.clear")) {
/*    */             PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)paramPlayer);
/*    */             if (playerDataManager.getLiveInvAmount() > 0) {
/*    */               (new ConfirmationGuiManager(paramPlayer, ConfirmationType.CLEAR)).openGui((OfflinePlayer)paramPlayer);
/*    */             } else {
/*    */               paramPlayer.sendMessage(LanguageManager.getString("no-inv-saved"));
/*    */             } 
/*    */           } else {
/*    */             paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*    */           } 
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void clearInventories(Player paramPlayer, String paramString) {
/* 43 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           if (paramPlayer.hasPermission("invsaver.others.clear")) {
/*    */             OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(paramString);
/*    */             PlayerDataManager playerDataManager = new PlayerDataManager(offlinePlayer);
/*    */             if (!playerDataManager.isPlayerHasPermissions("invsaver.bypass.edit")) {
/*    */               if (playerDataManager.getLiveInvAmount() > 0) {
/*    */                 (new ConfirmationGuiManager(paramPlayer, ConfirmationType.CLEAR)).openGui(offlinePlayer);
/*    */               } else {
/*    */                 paramPlayer.sendMessage(LanguageManager.getString("target-no-inv-saved").replaceAll("%target%", offlinePlayer.getName()));
/*    */               } 
/*    */             } else {
/*    */               paramPlayer.sendMessage(LanguageManager.getString("cant-clear"));
/*    */             } 
/*    */           } else {
/*    */             paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*    */           } 
/*    */         });
/*    */   }
/*    */ }
