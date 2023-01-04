/*    */ package com.dnInventorySaver.plugin.Command.Argument;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Util.ClickableMessageUtil;
/*    */ import com.dnInventorySaver.plugin.Util.StringUtil;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HelpArgument
/*    */ {
/*    */   public static void sendCommands(Player paramPlayer, String paramString) {
/* 13 */     paramPlayer.sendMessage(StringUtil.translate("&8&m---------------------------------------------------"));
/* 14 */     ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " info &7- Show information.", "/inv info", "&eClick here");
/* 15 */     if (paramPlayer.hasPermission("invsaver.others.info"))
/*    */     {
/* 17 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " info <player> &7- Show the players information.", "/inv info ", "&eClick here");
/*    */     }
/* 19 */     if (paramPlayer.hasPermission("invsaver.command.menu"))
/*    */     {
/* 21 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " menu &7- Open summary gui.", "/inv menu", "&eClick here");
/*    */     }
/* 23 */     if (paramPlayer.hasPermission("invsaver.others.open"))
/*    */     {
/* 25 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " menu <player> &7- Open the players summary gui.", "/inv menu ", "&eClick here");
/*    */     }
/* 27 */     ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " save <name> &7- Save inventory.", "/inv save ", "&eClick here");
/* 28 */     if (paramPlayer.hasPermission("invsaver.others.save"))
/*    */     {
/* 30 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " save <name> <player> &7- Save the players inventory.", "/inv save ", "&eClick here");
/*    */     }
/* 32 */     if (paramPlayer.hasPermission("invsaver.command.load"))
/*    */     {
/* 34 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " load <name> &7- Loads the selected inventory.", "/inv load ", "&eClick here");
/*    */     }
/* 36 */     ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " delete <name> &7- Deletes the selected inventory.", "/inv delete ", "&eClick here");
/* 37 */     if (paramPlayer.hasPermission("invsaver.command.clear"))
/*    */     {
/* 39 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " clear &7- Deletes all inventories.", "/inv clear", "&eClick here");
/*    */     }
/* 41 */     if (paramPlayer.hasPermission("invsaver.others.clear"))
/*    */     {
/* 43 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " clear <player> &7- Deletes all the player's inventories.", "/inv clear ", "&eClick here");
/*    */     }
/* 45 */     if (paramPlayer.hasPermission("invsaver.reload"))
/*    */     {
/* 47 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " reload &7- Reload the config and language file.", "/inv reload", "&eClick here");
/*    */     }
/* 49 */     if (paramPlayer.hasPermission("invsaver.command.sync"))
/*    */     {
/* 51 */       ClickableMessageUtil.sendClickableMessage(paramPlayer, " &6» &e/" + paramString + " sync <mysql/flatfile> <flatfile/mysql> \n    &7Synchronize the databases.", "/inv sync ", "&eClick here");
/*    */     }
/* 53 */     paramPlayer.sendMessage(StringUtil.translate("&8&m---------------------------------------------------"));
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendCommands(String paramString) {
/* 58 */     Bukkit.getServer().getConsoleSender().sendMessage(StringUtil.translate("&7&m---------------------------------------------------"));
/* 59 */     Bukkit.getServer().getConsoleSender().sendMessage(StringUtil.translate(" &6» &e/" + paramString + " info <player> &7- Show the players information."));
/* 60 */     Bukkit.getServer().getConsoleSender().sendMessage(StringUtil.translate(" &6» &e/" + paramString + " reload &7- Reload the config and language file."));
/* 61 */     Bukkit.getServer().getConsoleSender().sendMessage(StringUtil.translate(" &6» &e/" + paramString + " sync <mysql/flatfile> <flatfile/mysql> &7Synchronize the databases."));
/* 62 */     Bukkit.getServer().getConsoleSender().sendMessage(StringUtil.translate("&7&m---------------------------------------------------"));
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\Argument\HelpArgument.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */