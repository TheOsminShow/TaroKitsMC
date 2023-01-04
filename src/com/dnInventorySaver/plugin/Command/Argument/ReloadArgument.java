/*    */ package com.dnInventorySaver.plugin.Command.Argument;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReloadArgument
/*    */ {
/*    */   public static void reloadFiles(Player paramPlayer) {
/* 13 */     if (paramPlayer.hasPermission("invsaver.reload")) {
/*    */       
/* 15 */       Core.getConfigManager().reloadConfig();
/* 16 */       LanguageManager.reloadLangFile();
/*    */       
/* 18 */       paramPlayer.sendMessage(LanguageManager.getString("reload"));
/*    */     } else {
/*    */       
/* 21 */       paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void reloadFiles() {
/* 26 */     Core.getConfigManager().reloadConfig();
/* 27 */     LanguageManager.reloadLangFile();
/*    */     
/* 29 */     Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("reload"));
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\Argument\ReloadArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */