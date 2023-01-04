/*     */ package com.dnInventorySaver.plugin.Manager.Sync;
/*     */ 
/*     */ import com.dnInventorySaver.plugin.Core;
/*     */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*     */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileManager;
/*     */ import com.dnInventorySaver.plugin.Manager.Database.Mysql.MysqlManager;
/*     */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*     */ import com.dnInventorySaver.plugin.Util.DateUtil;
/*     */ import java.io.File;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.UUID;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SyncManager
/*     */   extends MysqlManager
/*     */ {
/*     */   public static void MysqlToFlatfile() {
/*  24 */     FlatfileManager.createFolder();
/*  25 */     String str = "SELECT * FROM invsaver_inventories";
/*  26 */     try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*     */       
/*  28 */       ResultSet resultSet = preparedStatement.executeQuery();
/*  29 */       while (resultSet.next()) {
/*     */         
/*  31 */         String str1 = resultSet.getString("uuid");
/*  32 */         String str2 = resultSet.getString("name");
/*  33 */         String str3 = resultSet.getString("content");
/*  34 */         String str4 = resultSet.getString("savedby");
/*  35 */         Timestamp timestamp1 = resultSet.getTimestamp("savedat");
/*  36 */         String str5 = resultSet.getString("modifiedby");
/*  37 */         Timestamp timestamp2 = resultSet.getTimestamp("modifiedat");
/*  38 */         String str6 = resultSet.getString("deletedby");
/*  39 */         Timestamp timestamp3 = resultSet.getTimestamp("deletedat");
/*     */         
/*  41 */         OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(UUID.fromString(str1));
/*  42 */         FlatfileData flatfileData = new FlatfileData(offlinePlayer);
/*     */         
/*  44 */         if (flatfileData.getModifyData().getConfigurationSection("inventories." + str2) == null)
/*     */         {
/*  46 */           flatfileData.getModifyData().set("inventories." + str2 + ".info.savedby", str4);
/*  47 */           flatfileData.getModifyData().set("inventories." + str2 + ".info.savedat", DateUtil.getDate(timestamp1));
/*  48 */           flatfileData.getModifyData().set("inventories." + str2 + ".content", str3);
/*  49 */           if (str5 != null) flatfileData.getModifyData().set("inventories." + str2 + ".info.modifiedby", str5); 
/*  50 */           if (timestamp2 != null) flatfileData.getModifyData().set("inventories." + str2 + ".info.modifiedat", DateUtil.getDate(timestamp2)); 
/*  51 */           if (str6 != null) flatfileData.getModifyData().set("inventories." + str2 + ".info.deletedby", str6); 
/*  52 */           if (timestamp3 != null) flatfileData.getModifyData().set("inventories." + str2 + ".info.deletedat", DateUtil.getDate(timestamp3)); 
/*  53 */           flatfileData.saveData();
/*     */         }
/*     */       
/*     */       } 
/*  57 */     } catch (SQLException sQLException) {
/*     */       
/*  59 */       sQLException.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void FlatfileToMysql() {
/*  65 */     FlatfileManager.createFolder();
/*  66 */     if (FlatfileManager.getPlayerDataFolder().exists())
/*     */     {
/*  68 */       for (File file : FlatfileManager.getPlayerDataFolder().listFiles()) {
/*     */         
/*  70 */         if (file.isFile() && file.getName().endsWith(".yml")) {
/*     */           
/*  72 */           UUID uUID = UUID.fromString(file.getName().replace(".yml", ""));
/*  73 */           OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(uUID);
/*  74 */           FlatfileData flatfileData = new FlatfileData(offlinePlayer);
/*     */           
/*  76 */           for (String str : flatfileData.getModifyData().getConfigurationSection("inventories").getKeys(false)) {
/*     */             
/*  78 */             PlayerDataManager playerDataManager = new PlayerDataManager(offlinePlayer);
/*  79 */             if (!playerDataManager.isInventoryExists(str)) {
/*     */               
/*  81 */               String str1 = flatfileData.getModifyData().getString("inventories." + str + ".content");
/*  82 */               String str2 = flatfileData.getModifyData().getString("inventories." + str + ".info.savedby");
/*  83 */               Timestamp timestamp1 = DateUtil.getDate(flatfileData.getModifyData().getString("inventories." + str + ".info.savedat"));
/*  84 */               String str3 = flatfileData.getModifyData().getString("inventories." + str + ".info.modifiedby");
/*  85 */               Timestamp timestamp2 = null;
/*  86 */               if (flatfileData.getModifyData().getString("inventories." + str + ".info.modifiedat") != null)
/*  87 */                 timestamp2 = DateUtil.getDate(flatfileData.getModifyData().getString("inventories." + str + ".info.modifiedat")); 
/*  88 */               String str4 = flatfileData.getModifyData().getString("inventories." + str + ".info.deletedby");
/*  89 */               Timestamp timestamp3 = null;
/*  90 */               if (flatfileData.getModifyData().getString("inventories." + str + ".info.deletedat") != null) {
/*  91 */                 timestamp3 = DateUtil.getDate(flatfileData.getModifyData().getString("inventories." + str + ".info.deletedat"));
/*     */               }
/*  93 */               String str5 = "INSERT INTO invsaver_inventories(uuid, name, content, savedby, savedat, modifiedby, modifiedat, deletedby, deletedat) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
/*  94 */               try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str5)) {
/*     */                 
/*  96 */                 preparedStatement.setString(1, uUID.toString());
/*  97 */                 preparedStatement.setString(2, str);
/*  98 */                 preparedStatement.setString(3, str1);
/*  99 */                 preparedStatement.setString(4, str2);
/* 100 */                 preparedStatement.setTimestamp(5, timestamp1);
/* 101 */                 preparedStatement.setString(6, str3);
/* 102 */                 preparedStatement.setTimestamp(7, timestamp2);
/* 103 */                 preparedStatement.setString(8, str4);
/* 104 */                 preparedStatement.setTimestamp(9, timestamp3);
/* 105 */                 preparedStatement.execute();
/*     */               }
/* 107 */               catch (SQLException sQLException) {
/*     */                 
/* 109 */                 sQLException.printStackTrace();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Sync\SyncManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */