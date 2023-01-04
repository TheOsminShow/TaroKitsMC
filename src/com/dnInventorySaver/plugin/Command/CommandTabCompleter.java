/*    */ package com.dnInventorySaver.plugin.Command;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.command.TabCompleter;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CommandTabCompleter
/*    */   implements TabCompleter
/*    */ {
/*    */   public List<String> onTabComplete(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
/* 19 */     ArrayList<String> arrayList = new ArrayList();
/* 20 */     Player player = (Player)paramCommandSender;
/*    */     
/* 22 */     if (paramArrayOfString.length == 1) {
/*    */       
/* 24 */       arrayList.add("info");
/*    */       
/* 26 */       if (player.hasPermission("invsaver.command.menu") || player.hasPermission("invsaver.others.open")) {
/* 27 */         arrayList.add("menu");
/*    */       }
/* 29 */       arrayList.add("save");
/*    */       
/* 31 */       if (player.hasPermission("invsaver.command.load")) {
/* 32 */         arrayList.add("load");
/*    */       }
/* 34 */       arrayList.add("delete");
/*    */       
/* 36 */       if (player.hasPermission("invsaver.command.clear") || player.hasPermission("invsaver.others.clear")) {
/* 37 */         arrayList.add("clear");
/*    */       }
/* 39 */       if (player.hasPermission("invsaver.reload")) {
/* 40 */         arrayList.add("reload");
/*    */       }
/* 42 */       if (player.hasPermission("invsaver.command.sync")) {
/* 43 */         arrayList.add("sync");
/*    */       }
/* 45 */     } else if (paramArrayOfString.length == 2) {
/*    */       
/* 47 */       if (paramArrayOfString[0].equalsIgnoreCase("info") && player.hasPermission("invsaver.others.info"))
/*    */       {
/* 49 */         for (Player player1 : Bukkit.getOnlinePlayers()) {
/* 50 */           if (!player.getName().equals(player1.getName()))
/* 51 */             arrayList.add(player1.getName()); 
/*    */         }  } 
/* 53 */       if (paramArrayOfString[0].equalsIgnoreCase("menu") && player.hasPermission("invsaver.others.open"))
/*    */       {
/* 55 */         for (Player player1 : Bukkit.getOnlinePlayers()) {
/* 56 */           if (!player.getName().equals(player1.getName()))
/* 57 */             arrayList.add(player1.getName()); 
/*    */         }  } 
/* 59 */       if (paramArrayOfString[0].equalsIgnoreCase("load") && player.hasPermission("invsaver.command.load")) {
/*    */         
/* 61 */         PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)player);
/* 62 */         arrayList.addAll(playerDataManager.getInventories());
/*    */       } 
/* 64 */       if (paramArrayOfString[0].equalsIgnoreCase("delete")) {
/*    */         
/* 66 */         PlayerDataManager playerDataManager = new PlayerDataManager((OfflinePlayer)player);
/* 67 */         arrayList.addAll(playerDataManager.getInventories());
/*    */       } 
/* 69 */       if (paramArrayOfString[0].equalsIgnoreCase("clear") && player.hasPermission("invsaver.others.clear"))
/*    */       {
/* 71 */         for (Player player1 : Bukkit.getOnlinePlayers()) {
/* 72 */           if (!player.getName().equals(player1.getName()))
/* 73 */             arrayList.add(player1.getName()); 
/*    */         }  } 
/* 75 */       if (paramArrayOfString[0].equalsIgnoreCase("sync") && player.hasPermission("invsaver.command.sync"))
/*    */       {
/* 77 */         arrayList.add("mysql");
/* 78 */         arrayList.add("flatfile");
/*    */       }
/*    */     
/* 81 */     } else if (paramArrayOfString.length == 3) {
/*    */       
/* 83 */       if (paramArrayOfString[0].equalsIgnoreCase("sync") && player.hasPermission("invsaver.command.sync"))
/*    */       {
/* 85 */         if (paramArrayOfString[1].equalsIgnoreCase("mysql")) {
/* 86 */           arrayList.add("flatfile");
/* 87 */         } else if (paramArrayOfString[1].equalsIgnoreCase("flatfile")) {
/* 88 */           arrayList.add("mysql");
/*    */         } 
/*    */       }
/*    */     } 
/* 92 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Command\CommandTabCompleter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */