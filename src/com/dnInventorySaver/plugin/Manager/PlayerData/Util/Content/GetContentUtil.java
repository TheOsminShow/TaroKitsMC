/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util.Content;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*    */ import com.dnInventorySaver.plugin.Util.BukkitSerializationUtil;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GetContentUtil
/*    */ {
/*    */   public static ItemStack[] getInventoryContent(OfflinePlayer paramOfflinePlayer, String paramString) {
/*    */     try {
/* 21 */       if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */         
/* 23 */         FlatfileData flatfileData = new FlatfileData(paramOfflinePlayer);
/* 24 */         String str = flatfileData.getModifyData().getString("inventories." + paramString + ".content");
/*    */         
/* 26 */         if (str != null)
/*    */         {
/* 28 */           return BukkitSerializationUtil.itemStackArrayFromBase64(str);
/*    */         }
/*    */       }
/* 31 */       else if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */         
/* 33 */         String str = "SELECT content FROM invsaver_inventories WHERE uuid=? and name=?;";
/* 34 */         try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str)) {
/*    */           
/* 36 */           preparedStatement.setString(1, paramOfflinePlayer.getUniqueId().toString());
/* 37 */           preparedStatement.setString(2, paramString);
/* 38 */           ResultSet resultSet = preparedStatement.executeQuery();
/* 39 */           if (resultSet.next())
/*    */           {
/* 41 */             return BukkitSerializationUtil.itemStackArrayFromBase64(resultSet.getString("content"));
/*    */           }
/*    */         }
/* 44 */         catch (SQLException sQLException) {
/*    */           
/* 46 */           sQLException.printStackTrace();
/*    */         } 
/*    */       } 
/* 49 */       return null;
/*    */     } catch (Throwable throwable) {
/*    */       throw throwable;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\PlayerData\Util\Content\GetContentUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */