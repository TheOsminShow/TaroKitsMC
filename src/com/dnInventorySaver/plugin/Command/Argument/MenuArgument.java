/*    */ package com.dnInventorySaver.plugin.Command.Argument;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.SumGuiManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class MenuArgument
/*    */ {
/*    */   public static void openMenu(Player paramPlayer) {
/* 16 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           if (paramPlayer.hasPermission("invsaver.command.menu")) {
/*    */             SumGuiManager sumGuiManager = new SumGuiManager(paramPlayer, (OfflinePlayer)paramPlayer);
/*    */             sumGuiManager.openSumGui(1);
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
/*    */   public static void openMenu(Player paramPlayer, String paramString) {
/* 32 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           if (paramPlayer.hasPermission("invsaver.others.open")) {
/*    */             OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(paramString);
/*    */             PlayerDataManager playerDataManager = new PlayerDataManager(offlinePlayer);
/*    */             SumGuiManager sumGuiManager = new SumGuiManager(paramPlayer, offlinePlayer);
/*    */             if (!playerDataManager.isPlayerHasPermissions("invsaver.bypass.open")) {
/*    */               sumGuiManager.openSumGui(1);
/*    */             } else {
/*    */               paramPlayer.sendMessage(LanguageManager.getString("cant-open-sb-inv"));
/*    */             } 
/*    */           } else {
/*    */             paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*    */           } 
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\Argument\MenuArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */