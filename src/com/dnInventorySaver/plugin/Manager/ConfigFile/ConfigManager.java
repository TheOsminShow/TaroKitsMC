/*    */ package com.dnInventorySaver.plugin.Manager.ConfigFile;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Util.StringUtil;
/*    */ import java.io.File;
/*    */ import java.util.List;
/*    */ import java.util.Objects;
/*    */ import java.util.Set;
/*    */ import org.bukkit.configuration.ConfigurationSection;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.configuration.file.YamlConfiguration;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ConfigManager
/*    */ {
/*    */   private final Core core;
/*    */   private FileConfiguration config;
/*    */   
/*    */   public FileConfiguration getConfig() {
/* 21 */     return this.config;
/*    */   }
/*    */   
/*    */   public ConfigManager(Core paramCore) {
/* 25 */     this.core = paramCore;
/*    */     
/* 27 */     paramCore.saveDefaultConfig();
/* 28 */     this.config = paramCore.getConfig();
/*    */   }
/*    */ 
/*    */   
/*    */   public void reloadConfig() {
/* 33 */     this.config = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(this.core.getDataFolder(), "config.yml"));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getString(String paramString) {
/* 38 */     return this.config.getString(StringUtil.translate(paramString));
/*    */   }
/* 40 */   public boolean getBoolean(String paramString) { return this.config.getBoolean(paramString); }
/* 41 */   public int getInt(String paramString) { return this.config.getInt(paramString); }
/* 42 */   public Set<String> getConfigSectionKeys(String paramString) { return ((ConfigurationSection)Objects.<ConfigurationSection>requireNonNull(this.config.getConfigurationSection(paramString))).getKeys(false); } public List<String> getList(String paramString) {
/* 43 */     return this.config.getStringList(paramString);
/*    */   } public String getDatabaseType() {
/* 45 */     return this.config.getString("database-type");
/*    */   } public int getSumGuiSpace() {
/* 47 */     return 9;
/*    */   }
/*    */ }
