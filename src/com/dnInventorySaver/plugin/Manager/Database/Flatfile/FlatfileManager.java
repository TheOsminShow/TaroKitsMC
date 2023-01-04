/*    */ package com.dnInventorySaver.plugin.Manager.Database.Flatfile;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FlatfileManager
/*    */ {
/*    */   private static File playerDataFolder;
/*    */   
/*    */   public static File getPlayerDataFolder() {
/* 13 */     return playerDataFolder;
/*    */   }
/*    */   
/*    */   public static void createFolder() {
/* 17 */     playerDataFolder = new File(Core.getInstance().getDataFolder(), "playerdata");
/* 18 */     if (!playerDataFolder.exists()) playerDataFolder.mkdirs(); 
/*    */   }
/*    */ }
