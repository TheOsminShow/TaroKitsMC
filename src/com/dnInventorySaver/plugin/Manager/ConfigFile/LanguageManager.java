/*    */ package com.dnInventorySaver.plugin.Manager.ConfigFile;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Util.StringUtil;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ public class LanguageManager
/*    */ {
/*    */   private static File languageFile;
/*    */   private static FileConfiguration modifyLanguageFile;
/*    */   
/*    */   public static FileConfiguration getModifyLanguageFile() {
/* 18 */     return modifyLanguageFile;
/*    */   }
/*    */   
/*    */   public LanguageManager(Core paramCore) {
/* 22 */     languageFile = new File(Core.getInstance().getDataFolder(), "language.yml");
/* 23 */     if (!languageFile.exists()) {
/* 24 */       languageFile.getParentFile().mkdirs();
/* 25 */       paramCore.saveResource("language.yml", false);
/*    */     } 
/*    */     
/* 28 */     modifyLanguageFile = (FileConfiguration)new YamlConfiguration();
/*    */     try {
/* 30 */       modifyLanguageFile.load(languageFile);
/* 31 */     } catch (IOException|org.bukkit.configuration.InvalidConfigurationException iOException) {
/* 32 */       iOException.printStackTrace();
/*    */     } 
/*    */   } public static void reloadLangFile() {
/*    */     
/* 36 */     try { modifyLanguageFile.load(languageFile); } catch (IOException|org.bukkit.configuration.InvalidConfigurationException iOException) { iOException.printStackTrace(); }
/*    */   
/*    */   }
/*    */   public static String getString(String paramString) {
/* 40 */     return StringUtil.translate(getModifyLanguageFile().getString(paramString));
/*    */   }
/*    */ 
/*    */   
/*    */   public static List<String> getItemLore(String paramString) {
/* 45 */     return StringUtil.translate(getModifyLanguageFile().getStringList(paramString));
/*    */   }
/*    */ }
