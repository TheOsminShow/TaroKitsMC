/*    */ package com.dnInventorySaver.plugin.Command;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.ClearArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.HelpArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.InfoArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.LoadArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.MenuArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.ReloadArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.SaveArgument;
/*    */ import com.dnInventorySaver.plugin.Command.Argument.SyncArgument;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class ArgumentExecutor implements CommandExecutor {
/*    */   public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
/*    */     try {
/* 17 */       if (paramCommandSender instanceof Player) {
/*    */         
/* 19 */         Player player = (Player)paramCommandSender;
/*    */ 
/*    */         
/* 22 */         if (paramArrayOfString.length == 1 && paramArrayOfString[0].equalsIgnoreCase("menu")) {
/* 23 */           MenuArgument.openMenu(player);
/*    */         
/*    */         }
/* 26 */         else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("menu")) {
/* 27 */           MenuArgument.openMenu(player, paramArrayOfString[1]);
/*    */         
/*    */         }
/* 30 */         else if (paramArrayOfString.length == 1 && paramArrayOfString[0].equalsIgnoreCase("info")) {
/* 31 */           InfoArgument.playerInfo(player);
/*    */         
/*    */         }
/* 34 */         else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("info")) {
/* 35 */           InfoArgument.playerInfo(player, paramArrayOfString[1]);
/*    */         
/*    */         }
/* 38 */         else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("load")) {
/* 39 */           LoadArgument.loadInventory(player, paramArrayOfString[1]);
/*    */         
/*    */         }
/* 42 */         else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("delete")) {
/* 43 */           DeleteArgument.deleteInventory(player, paramArrayOfString[1]);
/*    */         
/*    */         }
/* 46 */         else if (paramArrayOfString.length == 1 && paramArrayOfString[0].equalsIgnoreCase("clear")) {
/* 47 */           ClearArgument.clearInventories(player);
/*    */         
/*    */         }
/* 50 */         else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("clear")) {
/* 51 */           ClearArgument.clearInventories(player, paramArrayOfString[1]);
/*    */         
/*    */         }
/* 54 */         else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("save")) {
/* 55 */           SaveArgument.saveInventoryArg(player, paramArrayOfString[1]);
/*    */         
/*    */         }
/* 58 */         else if (paramArrayOfString.length == 3 && paramArrayOfString[0].equalsIgnoreCase("save")) {
/* 59 */           SaveArgument.saveInventoryArg(player, paramArrayOfString[2], paramArrayOfString[1]);
/*    */         
/*    */         }
/* 62 */         else if (paramArrayOfString.length == 3 && paramArrayOfString[0].equalsIgnoreCase("sync")) {
/* 63 */           SyncArgument.SyncCommand(player, paramArrayOfString[1], paramArrayOfString[2], paramString);
/*    */         
/*    */         }
/* 66 */         else if (paramArrayOfString.length == 1 && paramArrayOfString[0].equalsIgnoreCase("reload")) {
/* 67 */           ReloadArgument.reloadFiles(player);
/*    */         }
/*    */         else {
/*    */           
/* 71 */           HelpArgument.sendCommands(player, paramString);
/*    */         
/*    */         }
/*    */       
/*    */       }
/* 76 */       else if (paramArrayOfString.length == 1 && paramArrayOfString[0].equalsIgnoreCase("reload")) {
/* 77 */         ReloadArgument.reloadFiles();
/*    */       
/*    */       }
/* 80 */       else if (paramArrayOfString.length == 3 && paramArrayOfString[0].equalsIgnoreCase("sync")) {
/* 81 */         SyncArgument.SyncCommand(paramArrayOfString[1], paramArrayOfString[2], paramString);
/*    */       
/*    */       }
/* 84 */       else if (paramArrayOfString.length == 2 && paramArrayOfString[0].equalsIgnoreCase("info")) {
/* 85 */         InfoArgument.playerInfo(paramArrayOfString[1]);
/*    */       }
/*    */       else {
/*    */         
/* 89 */         HelpArgument.sendCommands(paramString);
/*    */       } 
/*    */       
/* 92 */       return false;
/*    */     } catch (Throwable throwable) {
/*    */       throw throwable;
/*    */     } 
/*    */   }
/*    */ }
