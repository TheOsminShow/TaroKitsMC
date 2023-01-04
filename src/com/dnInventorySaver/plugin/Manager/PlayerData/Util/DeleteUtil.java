/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*    */ import com.dnInventorySaver.plugin.Util.DateUtil;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DeleteUtil
/*    */ {
/*    */   public static boolean isInventoryDeleted(OfflinePlayer paramOfflinePlayer, String paramString) {
/* 20 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 22 */       FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer); return 
/* 23 */         (flatfileData.getModifyData().getString("inventories." + paramString + ".info.deletedby") != null);
/*    */     } 
/* 25 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 27 */       String str = "SELECT deletedby FROM invsaver_inventories WHERE uuid=? and name=?;";
/* 28 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */         
/* 30 */         preparedStatement.setString(1, paramOfflinePlayer.getUniqueId().toString());
/* 31 */         preparedStatement.setString(2, paramString);
/* 32 */         ResultSet resultSet = preparedStatement.executeQuery();
/* 33 */         if (resultSet.next())
/*    */         {
/* 35 */           if (resultSet.getString("deletedby") == null)
/*    */           {
/* 37 */             return false;
/*    */           }
/*    */         }
/*    */       }
/* 41 */       catch (SQLException sQLException) {
/*    */         
/* 43 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void deleteInventory(OfflinePlayer paramOfflinePlayer, String paramString) {
/* 51 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 53 */       FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer);
/* 54 */       flatfileData.getModifyData().set("inventories." + paramString, null);
/* 55 */       flatfileData.saveData();
/*    */     }
/* 57 */     else if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 59 */       String str = "DELETE FROM invsaver_inventories WHERE uuid=? and name=?;";
/* 60 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */         
/* 62 */         preparedStatement.setString(1, paramOfflinePlayer.getUniqueId().toString());
/* 63 */         preparedStatement.setString(2, paramString);
/* 64 */         preparedStatement.executeUpdate();
/*    */       }
/* 66 */       catch (SQLException sQLException) {
/*    */         
/* 68 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void dismissInventory(Player paramPlayer, OfflinePlayer paramOfflinePlayer, String paramString) {
/* 75 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 77 */       FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer);
/* 78 */       flatfileData.getModifyData().set("inventories." + paramString + ".info.deletedby", paramPlayer.getName());
/* 79 */       flatfileData.getModifyData().set("inventories." + paramString + ".info.deletedat", DateUtil.getDate());
/* 80 */       flatfileData.saveData();
/*    */     }
/* 82 */     else if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 84 */       String str = "UPDATE invsaver_inventories SET deletedby=?, deletedat=? WHERE uuid=? and name=?;";
/* 85 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */         
/* 87 */         preparedStatement.setString(1, paramPlayer.getName());
/* 88 */         preparedStatement.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
/* 89 */         preparedStatement.setString(3, paramOfflinePlayer.getUniqueId().toString());
/* 90 */         preparedStatement.setString(4, paramString);
/* 91 */         preparedStatement.executeUpdate();
/*    */       }
/* 93 */       catch (SQLException sQLException) {
/*    */         
/* 95 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\PlayerData\Util\DeleteUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */