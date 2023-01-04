/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.net.URL;
/*    */ import java.util.Scanner;
/*    */ import java.util.function.Consumer;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CheckUpdateUtil
/*    */ {
/*    */   private final Core core;
/* 18 */   int resourceId = 98790;
/*    */ 
/*    */   
/*    */   public CheckUpdateUtil(Core paramCore) {
/* 22 */     this.core = paramCore;
/*    */   }
/*    */ 
/*    */   
/*    */   public void checkUpdate() {
/* 27 */     if (Core.getConfigManager().getBoolean("update-checker"))
/*    */     {
/* 29 */       getVersion(paramString -> {
/*    */             if (this.core.getDescription().getVersion().equals(paramString)) {
/*    */               Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GRAY + "[InvSaver] There is no new update available for the plugin.");
/*    */             } else {
/*    */               Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "==========================================================");
/*    */               Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[InvSaver] There is a new update available for the plugin.");
/*    */               Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "==========================================================");
/*    */             } 
/*    */           });
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void getVersion(Consumer<String> paramConsumer) {
/* 47 */     Bukkit.getScheduler().runTaskAsynchronously((Plugin)this.core, () -> {
/*    */ 
/*    */ 
/*    */           
/*    */           try(InputStream null = (new URL("https://api.spigotmc.org/legacy/update.php?resource=" + this.resourceId)).openStream(); Scanner null = new Scanner(inputStream)) {
/*    */             
/*    */             if (scanner.hasNext()) {
/*    */               paramConsumer.accept(scanner.next());
/*    */             }
/* 56 */           } catch (IOException iOException) {
/*    */             this.core.getLogger().info("Unable to check for updates: " + iOException.getMessage());
/*    */           } 
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Util\CheckUpdateUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */