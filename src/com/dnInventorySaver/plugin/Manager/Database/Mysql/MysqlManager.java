/*    */ package com.dnInventorySaver.plugin.Manager.Database.Mysql;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.SQLException;
/*    */ import java.util.Objects;
/*    */ import java.util.logging.Level;
/*    */ import java.util.stream.Collectors;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ 
/*    */ public class MysqlManager
/*    */ {
/*    */   private Connection mysql_connection;
/*    */   
/*    */   public Connection getMysql_connection() {
/* 23 */     return this.mysql_connection;
/*    */   }
/*    */   
/*    */   public MysqlManager() {
/* 27 */     if (Objects.equals(Core.getConfigManager().getDatabaseType(), "mysql")) {
/*    */       
/*    */       try {
/* 30 */         openConnection();
/* 31 */       } catch (SQLException|IOException sQLException) {
/* 32 */         sQLException.printStackTrace();
/*    */       } 
/*    */     }
/*    */   }
/*    */   
/*    */   private void openConnection() {
/* 38 */     if (this.mysql_connection != null && !this.mysql_connection.isClosed()) {
/*    */       return;
/*    */     }
/*    */ 
/*    */     
/* 43 */     this.mysql_connection = DriverManager.getConnection("jdbc:mysql://" + 
/* 44 */         Core.getConfigManager().getString("mysql-database.host") + ":" + 
/* 45 */         Core.getConfigManager().getInt("mysql-database.port") + "/" + 
/* 46 */         Core.getConfigManager().getString("mysql-database.database") + "", 
/* 47 */         Core.getConfigManager().getString("mysql-database.user"), 
/* 48 */         Core.getConfigManager().getString("mysql-database.password"));
/*    */     
/* 50 */     Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[InvSaver] Mysql Connection is successful!");
/* 51 */     initDb();
/*    */   }
/*    */ 
/*    */   
/*    */   private void initDb() {
/*    */     String str;
/* 57 */     try (InputStream null = Core.getInstance().getClass().getClassLoader().getResourceAsStream("dbsetup.sql")) {
/*    */       
/* 59 */       str = (new BufferedReader(new InputStreamReader(inputStream))).lines().collect(Collectors.joining("\n"));
/*    */     }
/* 61 */     catch (IOException iOException) {
/*    */       
/* 63 */       Core.getInstance().getLogger().log(Level.SEVERE, "Could not read db setup file.", iOException);
/* 64 */       throw iOException;
/*    */     } 
/* 66 */     String[] arrayOfString = str.split(";");
/* 67 */     for (String str1 : arrayOfString) {
/*    */       
/* 69 */       PreparedStatement preparedStatement = this.mysql_connection.prepareStatement(str1);
/* 70 */       preparedStatement.execute();
/*    */     } 
/* 72 */     Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[InvSaver] Database setup complete.");
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Database\Mysql\MysqlManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */