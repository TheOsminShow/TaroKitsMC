/*    */ package com.dnInventorySaver.plugin.Manager.Database.Flatfile;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.UUID;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ public class FlatfileData {
/*    */   private final File data;
/*    */   private final FileConfiguration modifyData;
/*    */   private final OfflinePlayer player;
/*    */   private final UUID uuid;
/*    */   
/*    */   public FileConfiguration getModifyData() {
/* 18 */     return this.modifyData;
/* 19 */   } public OfflinePlayer getPlayer() { return this.player; } public UUID getUuid() {
/* 20 */     return this.uuid;
/*    */   }
/*    */   
/*    */   public FlatfileData(OfflinePlayer paramOfflinePlayer) {
/* 24 */     this.player = paramOfflinePlayer;
/* 25 */     this.uuid = paramOfflinePlayer.getUniqueId();
/*    */     
/* 27 */     this.data = new File(Core.getInstance().getDataFolder(), "playerdata/" + this.uuid + ".yml");
/* 28 */     if (!this.data.exists()) {
/*    */       
/*    */       try {
/* 31 */         this.data.createNewFile();
/* 32 */       } catch (IOException iOException) {
/* 33 */         iOException.printStackTrace();
/*    */       } 
/*    */     }
/*    */     
/* 37 */     this.modifyData = (FileConfiguration)new YamlConfiguration();
/*    */     try {
/* 39 */       this.modifyData.load(this.data);
/* 40 */     } catch (IOException|org.bukkit.configuration.InvalidConfigurationException iOException) {
/* 41 */       iOException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void saveData() {
/*    */     try {
/* 49 */       this.modifyData.save(this.data);
/*    */     }
/* 51 */     catch (IOException iOException) {
/*    */       
/* 53 */       iOException.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Database\Flatfile\FlatfileData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */