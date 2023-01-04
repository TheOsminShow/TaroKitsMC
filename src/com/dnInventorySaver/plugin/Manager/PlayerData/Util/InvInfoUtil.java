/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InvInfoUtil
/*    */ {
/*    */   public static String getDateInfo(OfflinePlayer paramOfflinePlayer, String paramString1, String paramString2) {
/*    */     try {
/* 22 */       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Core.getConfigManager().getString("date-format"));
/*    */       
/* 24 */       if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */         
/* 26 */         FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer);
/* 27 */         return flatfileData.getModifyData().getString("inventories." + paramString1 + ".info." + paramString2 + "at");
/*    */       } 
/* 29 */       if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */         
/* 31 */         String str = "SELECT " + paramString2 + "at FROM invsaver_inventories WHERE uuid=? and name=?;";
/* 32 */         try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */           
/* 34 */           preparedStatement.setString(1, paramOfflinePlayer.getUniqueId().toString());
/* 35 */           preparedStatement.setString(2, paramString1);
/* 36 */           ResultSet resultSet = preparedStatement.executeQuery();
/* 37 */           if (resultSet.next())
/*    */           {
/* 39 */             if (resultSet.getDate(paramString2 + "at") != null)
/*    */             {
/* 41 */               return simpleDateFormat.format(resultSet.getTimestamp(paramString2 + "at"));
/*    */             }
/*    */           }
/*    */         }
/* 45 */         catch (SQLException sQLException) {
/*    */           
/* 47 */           sQLException.printStackTrace();
/*    */         } 
/*    */       } 
/* 50 */       return null;
/*    */     } catch (Throwable throwable) {
/*    */       throw throwable;
/*    */     } 
/*    */   } public static String getPlayerInfo(OfflinePlayer paramOfflinePlayer, String paramString1, String paramString2) {
/* 55 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 57 */       FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer);
/* 58 */       return flatfileData.getModifyData().getString("inventories." + paramString1 + ".info." + paramString2 + "by");
/*    */     } 
/* 60 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 62 */       String str = "SELECT " + paramString2 + "by FROM invsaver_inventories WHERE uuid=? and name=?;";
/* 63 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */         
/* 65 */         preparedStatement.setString(1, paramOfflinePlayer.getUniqueId().toString());
/* 66 */         preparedStatement.setString(2, paramString1);
/* 67 */         ResultSet resultSet = preparedStatement.executeQuery();
/* 68 */         if (resultSet.next())
/*    */         {
/* 70 */           if (resultSet.getString(paramString2 + "by") != null)
/*    */           {
/* 72 */             return resultSet.getString(paramString2 + "by");
/*    */           }
/*    */         }
/*    */       }
/* 76 */       catch (SQLException sQLException) {
/*    */         
/* 78 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/* 81 */     return null;
/*    */   }
/*    */ }
