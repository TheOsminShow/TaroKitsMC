/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetInvNamesUtil
/*    */ {
/*    */   public static ArrayList<String> getInventories(OfflinePlayer paramOfflinePlayer) {
/* 18 */     ArrayList<String> arrayList = new ArrayList();
/*    */     
/* 20 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 22 */       FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer);
/* 23 */       if (flatfileData.getModifyData().getConfigurationSection("inventories") != null)
/*    */       {
/* 25 */         arrayList.addAll(flatfileData.getModifyData().getConfigurationSection("inventories").getKeys(false));
/*    */       }
/*    */     }
/* 28 */     else if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 30 */       String str = "SELECT name FROM invsaver_inventories WHERE uuid=?;";
/* 31 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */         
/* 33 */         preparedStatement.setString(1, paramOfflinePlayer.getUniqueId().toString());
/* 34 */         ResultSet resultSet = preparedStatement.executeQuery();
/* 35 */         while (resultSet.next())
/*    */         {
/* 37 */           arrayList.add(resultSet.getString("name"));
/*    */         }
/*    */       }
/* 40 */       catch (SQLException sQLException) {
/*    */         
/* 42 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/* 45 */     return arrayList;
/*    */   }
/*    */ }
