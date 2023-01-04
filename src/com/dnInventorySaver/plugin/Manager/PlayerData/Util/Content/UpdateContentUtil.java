/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util.Content;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.BukkitSerializationUtil;
/*    */ import com.dnInventorySaver.plugin.Util.DateUtil;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Timestamp;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Objects;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UpdateContentUtil
/*    */ {
/*    */   public static void UpdateInventoryContent(Player paramPlayer, Inventory paramInventory, PlayerDataManager paramPlayerDataManager, String paramString) {
/* 24 */     OfflinePlayer offlinePlayer = paramPlayerDataManager.getPlayer();
/*    */     
/* 26 */     ArrayList<ItemStack> arrayList = new ArrayList();
/* 27 */     if (paramPlayerDataManager.getInventoryContent(paramString) != null)
/*    */     {
/* 29 */       for (byte b = 0; b < (paramPlayerDataManager.getInventoryContent(paramString)).length; b++)
/*    */       {
/* 31 */         arrayList.add(paramInventory.getItem(b));
/*    */       }
/*    */     }
/* 34 */     String str = BukkitSerializationUtil.itemStackArrayToBase64(arrayList.<ItemStack>toArray(new ItemStack[0]));
/*    */     
/* 36 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 38 */       FlatfileData flatfileData = new FlatfileData(offlinePlayer);
/* 39 */       flatfileData.getModifyData().set("inventories." + paramString + ".info.modifiedby", paramPlayer.getName());
/* 40 */       flatfileData.getModifyData().set("inventories." + paramString + ".info.modifiedat", DateUtil.getDate());
/* 41 */       flatfileData.getModifyData().set("inventories." + paramString + ".content", str);
/* 42 */       flatfileData.saveData();
/*    */     }
/* 44 */     else if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 46 */       String str1 = "UPDATE invsaver_inventories SET content=?, modifiedby=?, modifiedat=? WHERE uuid=? and name=?;";
/* 47 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str1)) {
/*    */         
/* 49 */         preparedStatement.setString(1, str);
/* 50 */         preparedStatement.setString(2, paramPlayer.getName());
/* 51 */         preparedStatement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
/* 52 */         preparedStatement.setString(4, offlinePlayer.getUniqueId().toString());
/* 53 */         preparedStatement.setString(5, paramString);
/* 54 */         preparedStatement.executeUpdate();
/*    */       }
/* 56 */       catch (SQLException sQLException) {
/*    */         
/* 58 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }
