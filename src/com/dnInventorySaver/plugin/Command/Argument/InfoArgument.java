/*     */ package com.dnInventorySaver.plugin.Command.Argument;
/*     */ 
/*     */ import com.dnInventorySaver.plugin.Core;
/*     */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*     */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*     */ import com.dnInventorySaver.plugin.Util.RankInfoUtil;
/*     */ import java.util.Objects;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InfoArgument
/*     */ {
/*     */   public static void playerInfo(Player paramPlayer) {
/*  18 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*     */           PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)paramPlayer);
/*     */           if (playerDataManager.getPlayerRank() != null) {
/*     */             String str1 = playerDataManager.getPlayerRank();
/*     */             String str2 = String.valueOf(RankInfoUtil.getSaveAmount(str1));
/*     */             boolean bool = RankInfoUtil.canEdit(str1);
/*     */             if (Objects.equals(str1, "*")) {
/*     */               str2 = "infinite";
/*     */               bool = true;
/*     */             } 
/*     */             for (String str : LanguageManager.getItemLore("info-command")) {
/*     */               paramPlayer.sendMessage(str.replaceAll("%player%", paramPlayer.getName()).replaceAll("%group%", str1).replaceAll("%savedinv%", String.valueOf(playerDataManager.getLiveInvAmount())).replaceAll("%allinv%", str2).replaceAll("%editinv%", String.valueOf(bool)).replaceAll("%price%", "" + RankInfoUtil.getSavePrice(playerDataManager.getPlayerRank())));
/*     */             }
/*     */           } else {
/*     */             paramPlayer.sendMessage(LanguageManager.getString("dont-have-info"));
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void playerInfo(Player paramPlayer, String paramString) {
/*  53 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*     */           if (paramPlayer.hasPermission("invsaver.others.info")) {
/*     */             OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(paramString);
/*     */             if (offlinePlayer.hasPlayedBefore()) {
/*     */               PlayerDataManager playerDataManager = new PlayerDataManager(offlinePlayer);
/*     */               if (playerDataManager.getPlayerRank() != null) {
/*     */                 String str1 = playerDataManager.getPlayerRank();
/*     */                 String str2 = String.valueOf(RankInfoUtil.getSaveAmount(str1));
/*     */                 boolean bool = RankInfoUtil.canEdit(str1);
/*     */                 if (Objects.equals(str1, "*")) {
/*     */                   str2 = "infinite";
/*     */                   bool = true;
/*     */                 } 
/*     */                 for (String str : LanguageManager.getItemLore("info-command")) {
/*     */                   paramPlayer.sendMessage(str.replaceAll("%player%", offlinePlayer.getName()).replaceAll("%group%", str1).replaceAll("%savedinv%", String.valueOf(playerDataManager.getLiveInvAmount())).replaceAll("%allinv%", str2).replaceAll("%editinv%", String.valueOf(bool)).replaceAll("%price%", "" + RankInfoUtil.getSavePrice(playerDataManager.getPlayerRank())));
/*     */                 }
/*     */               } else {
/*     */                 paramPlayer.sendMessage(LanguageManager.getString("target-dont-have-info"));
/*     */               } 
/*     */             } else {
/*     */               paramPlayer.sendMessage(LanguageManager.getString("cant-find-player"));
/*     */             } 
/*     */           } else {
/*     */             paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void playerInfo(String paramString) {
/* 102 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> {
/*     */           OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(paramString);
/*     */           if (offlinePlayer.hasPlayedBefore()) {
/*     */             PlayerDataManager playerDataManager = new PlayerDataManager(offlinePlayer);
/*     */             if (playerDataManager.getPlayerRank() != null) {
/*     */               String str1 = playerDataManager.getPlayerRank();
/*     */               String str2 = String.valueOf(RankInfoUtil.getSaveAmount(str1));
/*     */               boolean bool = RankInfoUtil.canEdit(str1);
/*     */               if (Objects.equals(str1, "*")) {
/*     */                 str2 = "infinite";
/*     */                 bool = true;
/*     */               } 
/*     */               for (String str : LanguageManager.getItemLore("info-command"))
/*     */                 Bukkit.getServer().getConsoleSender().sendMessage(str.replaceAll("%player%", offlinePlayer.getName()).replaceAll("%group%", str1).replaceAll("%savedinv%", String.valueOf(playerDataManager.getLiveInvAmount())).replaceAll("%allinv%", str2).replaceAll("%editinv%", String.valueOf(bool)).replaceAll("%price%", "" + RankInfoUtil.getSavePrice(playerDataManager.getPlayerRank()))); 
/*     */             } else {
/*     */               Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("target-dont-have-info"));
/*     */             } 
/*     */           } else {
/*     */             Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("cant-find-player"));
/*     */           } 
/*     */         });
/*     */   }
/*     */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\Argument\InfoArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */