/*    */ package com.dnInventorySaver.plugin.Command.Argument;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Sync.SyncManager;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ public class SyncArgument
/*    */ {
/*    */   public static void SyncCommand(Player paramPlayer, String paramString1, String paramString2, String paramString3) {
/* 14 */     if (!paramPlayer.hasPermission("invsaver.command.sync")) {
/*    */       
/* 16 */       paramPlayer.sendMessage(LanguageManager.getString("dont-have-permission"));
/*    */       
/*    */       return;
/*    */     } 
/* 20 */     if (paramString1.equalsIgnoreCase("mysql") && paramString2.equalsIgnoreCase("flatfile")) {
/*    */       
/* 22 */       if (Core.getMysqlManager().getMysql_connection() != null)
/*    */       {
/* 24 */         Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), SyncManager::MysqlToFlatfile);
/* 25 */         paramPlayer.sendMessage(LanguageManager.getString("sync-mysql-to-flatfile"));
/*    */       }
/*    */       else
/*    */       {
/* 29 */         paramPlayer.sendMessage(LanguageManager.getString("no-mysql-connection"));
/*    */       }
/*    */     
/* 32 */     } else if (paramString1.equalsIgnoreCase("flatfile") && paramString2.equalsIgnoreCase("mysql")) {
/*    */       
/* 34 */       if (Core.getMysqlManager().getMysql_connection() != null)
/*    */       {
/* 36 */         Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), SyncManager::FlatfileToMysql);
/* 37 */         paramPlayer.sendMessage(LanguageManager.getString("sync-flatfile-to-mysql"));
/*    */       }
/*    */       else
/*    */       {
/* 41 */         paramPlayer.sendMessage(LanguageManager.getString("no-mysql-connection"));
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 46 */       HelpArgument.sendCommands(paramPlayer, paramString3);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void SyncCommand(String paramString1, String paramString2, String paramString3) {
/* 52 */     if (paramString1.equalsIgnoreCase("mysql") && paramString2.equalsIgnoreCase("flatfile")) {
/*    */       
/* 54 */       if (Core.getMysqlManager().getMysql_connection() != null)
/*    */       {
/* 56 */         Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), SyncManager::MysqlToFlatfile);
/* 57 */         Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("sync-mysql-to-flatfile"));
/*    */       }
/*    */       else
/*    */       {
/* 61 */         Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("no-mysql-connection"));
/*    */       }
/*    */     
/* 64 */     } else if (paramString1.equalsIgnoreCase("flatfile") && paramString2.equalsIgnoreCase("mysql")) {
/*    */       
/* 66 */       if (Core.getMysqlManager().getMysql_connection() != null)
/*    */       {
/* 68 */         Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), SyncManager::FlatfileToMysql);
/* 69 */         Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("sync-flatfile-to-mysql"));
/*    */       }
/*    */       else
/*    */       {
/* 73 */         Bukkit.getServer().getConsoleSender().sendMessage(LanguageManager.getString("no-mysql-connection"));
/*    */       }
/*    */     
/*    */     } else {
/*    */       
/* 78 */       HelpArgument.sendCommands(paramString3);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\Argument\SyncArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */