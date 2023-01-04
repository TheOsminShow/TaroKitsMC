/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util.Content;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileData;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.SumGuiManager;
/*    */ import com.dnInventorySaver.plugin.Util.BukkitSerializationUtil;
/*    */ import com.dnInventorySaver.plugin.Util.DateUtil;
/*    */ import com.dnInventorySaver.plugin.Util.InPlayersUtil;
/*    */ import com.dnInventorySaver.plugin.Util.InventoryUtil;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Objects;
/*    */ import java.util.Set;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SaveContentUtil
/*    */ {
/*    */   public static void saveInventory(Player paramPlayer1, Player paramPlayer2, String paramString) {
/* 24 */     String str = BukkitSerializationUtil.itemStackArrayToBase64((ItemStack[])InventoryUtil.getPlayerInventoryContent(paramPlayer2).toArray((Object[])new ItemStack[0]));
/*    */     
/* 26 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "flatfile")) {
/*    */       
/* 28 */       FlatfileData flatfileData = new FlatfileData((OfflinePlayer)paramPlayer2);
/* 29 */       flatfileData.getModifyData().set("inventories." + paramString + ".info.savedby", paramPlayer2.getName());
/* 30 */       flatfileData.getModifyData().set("inventories." + paramString + ".info.savedat", DateUtil.getDate());
/* 31 */       flatfileData.getModifyData().set("inventories." + paramString + ".content", str);
/* 32 */       flatfileData.saveData();
/*    */     }
/* 34 */     else if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/* 36 */       String str1 = "INSERT INTO invsaver_inventories(uuid, name, content, savedby) VALUES(?, ?, ?, ?)";
/* 37 */       try (PreparedStatement null = Core.getMysqlManager().getMysql_connection().prepareStatement(str1)) {
/*    */         
/* 39 */         preparedStatement.setString(1, paramPlayer2.getUniqueId().toString());
/* 40 */         preparedStatement.setString(2, paramString);
/* 41 */         preparedStatement.setString(3, str);
/* 42 */         preparedStatement.setString(4, paramPlayer1.getName());
/* 43 */         preparedStatement.execute();
/*    */       }
/* 45 */       catch (SQLException sQLException) {
/*    */         
/* 47 */         sQLException.printStackTrace();
/*    */       } 
/*    */     } 
/*    */     
/* 51 */     if (Core.getConfigManager().getBoolean("delete-on-save")) {
/*    */       
/* 53 */       paramPlayer2.getInventory().clear();
/* 54 */       paramPlayer2.getInventory().setArmorContents(null);
/*    */     } 
/*    */     
/* 57 */     Set set = InPlayersUtil.getOpenInvPlayers(Core.getOpenInv(), (OfflinePlayer)paramPlayer2);
/* 58 */     for (Player player : set) {
/*    */       
/* 60 */       if (Core.getInSumGUI().containsKey(player) && !Core.getInInvGUI().containsKey(player))
/*    */       {
/* 62 */         (new SumGuiManager(player, (OfflinePlayer)paramPlayer2)).openSumGui(((Integer)Core.getInSumGUI().get(player)).intValue());
/*    */       }
/*    */     } 
/*    */   }
/*    */ }
