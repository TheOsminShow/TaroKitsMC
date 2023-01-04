/*    */ package com.dnInventorySaver.plugin.Command.Argument;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.InventoryUtil;
/*    */ import com.dnInventorySaver.plugin.Util.RankInfoUtil;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class SaveArgument
/*    */ {
/*    */   public static void saveInventoryArg(Player paramPlayer, String paramString) {
/* 18 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)paramPlayer);
/*    */           int i = RankInfoUtil.getSaveAmount(playerDataManager.getPlayerRank());
/*    */           int j = playerDataManager.getInvAmount();
/*    */           int k = RankInfoUtil.getSavePrice(playerDataManager.getPlayerRank());
/*    */           if ((i != 0 && j < i) || Objects.equals(playerDataManager.getPlayerRank(), "*")) {
/*    */             if (!InventoryUtil.playerInvEmpty(paramPlayer)) {
/*    */               if (!playerDataManager.isInventoryExists(paramString)) {
/*    */                 if (18 < paramString.length() || paramString.length() < 5) {
/*    */                   paramPlayer.sendMessage(LanguageManager.getString("inv-save-problem"));
/*    */                 } else {
/*    */                   if (Core.getEconomy() != null) {
/*    */                     if (Core.getEconomy().has((OfflinePlayer)paramPlayer, k) || paramPlayer.hasPermission("invsaver.bypass.saveprice")) {
/*    */                       if (k > 0 && !paramPlayer.hasPermission("invsaver.bypass.saveprice") && !Objects.equals(playerDataManager.getPlayerRank(), "*")) {
/*    */                         Core.getEconomy().withdrawPlayer((OfflinePlayer)paramPlayer, k);
/*    */                         paramPlayer.sendMessage(LanguageManager.getString("money-withdraw").replaceAll("%money%", "" + k));
/*    */                       } 
/*    */                     } else if (!Core.getEconomy().has((OfflinePlayer)paramPlayer, k)) {
/*    */                       paramPlayer.sendMessage(LanguageManager.getString("not-enough-money").replaceAll("%money%", "" + k));
/*    */                       return;
/*    */                     } 
/*    */                   }
/*    */                   playerDataManager.SaveInventory(paramPlayer, paramString);
/*    */                   paramPlayer.sendMessage(LanguageManager.getString("inv-saved"));
/*    */                 } 
/*    */               } else {
/*    */                 paramPlayer.sendMessage(LanguageManager.getString("name-taken"));
/*    */               } 
/*    */             } else {
/*    */               paramPlayer.sendMessage(LanguageManager.getString("inv-empty"));
/*    */             } 
/*    */           } else {
/*    */             paramPlayer.sendMessage(LanguageManager.getString("cant-save-inv"));
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void saveInventoryArg(Player paramPlayer, String paramString1, String paramString2) {
/* 78 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*    */           if (paramPlayer.hasPermission("invsaver.others.save")) {
/*    */             if (Bukkit.getPlayer(paramString1) != null) {
/*    */               Player player = Bukkit.getPlayer(paramString1);
/*    */               PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)player);
/*    */               if (player.isOnline()) {
/*    */                 if (!player.hasPermission("invsaver.bypass.forcesave")) {
/*    */                   if (18 >= paramString2.length() || paramString2.length() > 5) {
/*    */                     if (!playerDataManager.isInventoryExists(paramString2)) {
/*    */                       if (!InventoryUtil.playerInvEmpty(player)) {
/*    */                         if (paramPlayer.hasPermission("invsaver.others.save.bypass.amount")) {
/*    */                           playerDataManager.SaveInventory(paramPlayer, paramString2);
/*    */                           paramPlayer.sendMessage(LanguageManager.getString("saved-sb-inv").replaceAll("%target%", player.getName()));
/*    */                           player.sendMessage(LanguageManager.getString("inv-saved-by").replaceAll("%player%", paramPlayer.getName()).replaceAll("%invname%", paramString2));
/*    */                         } else {
/*    */                           int i = RankInfoUtil.getSaveAmount(playerDataManager.getPlayerRank());
/*    */                           int j = playerDataManager.getInvAmount();
/*    */                           if (i >= j) {
/*    */                             playerDataManager.SaveInventory(paramPlayer, paramString2);
/*    */                             paramPlayer.sendMessage(LanguageManager.getString("saved-sb-inv").replaceAll("%target%", player.getName()));
/*    */                             player.sendMessage(LanguageManager.getString("inv-saved-by").replaceAll("%player%", paramPlayer.getName()).replaceAll("%invname%", paramString2));
/*    */                           } else {
/*    */                             paramPlayer.sendMessage(LanguageManager.getString("cant-save-sb-inv"));
/*    */                           } 
/*    */                         } 
/*    */                       } else {
/*    */                         paramPlayer.sendMessage(LanguageManager.getString("target-inv-empty"));
/*    */                       } 
/*    */                     } else {
/*    */                       paramPlayer.sendMessage(LanguageManager.getString("name-taken"));
/*    */                     } 
/*    */                   } else {
/*    */                     paramPlayer.sendMessage(LanguageManager.getString("inv-save-problem"));
/*    */                   } 
/*    */                 } else {
/*    */                   paramPlayer.sendMessage(LanguageManager.getString("cant-save-sb-inv"));
/*    */                 } 
/*    */               } else {
/*    */                 paramPlayer.sendMessage(LanguageManager.getString("cant-find-player"));
/*    */               } 
/*    */             } else {
/*    */               paramPlayer.sendMessage(LanguageManager.getString("cant-find-player"));
/*    */             } 
/*    */           } else {
/*    */             paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*    */           } 
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\Argument\SaveArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */