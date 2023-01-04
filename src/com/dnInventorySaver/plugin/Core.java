/*     */ package com.dnInventorySaver.plugin;
/*     */ import com.dnInventorySaver.plugin.Command.ArgumentExecutor;
/*     */ import com.dnInventorySaver.plugin.Command.CommandTabCompleter;
/*     */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*     */ import com.dnInventorySaver.plugin.Listener.InventoryClose;
/*     */ import com.dnInventorySaver.plugin.Manager.ConfigFile.ConfigManager;
/*     */ import com.dnInventorySaver.plugin.Manager.Database.Flatfile.FlatfileManager;
/*     */ import com.dnInventorySaver.plugin.Manager.Database.Mysql.MysqlManager;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.URLConnection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import net.milkbowl.vault.economy.Economy;
/*     */ import net.milkbowl.vault.permission.Permission;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.TabCompleter;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.RegisteredServiceProvider;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ 
/*     */ public class Core extends JavaPlugin {
/*  29 */   private static final HashMap<Player, OfflinePlayer> openInv = new HashMap<>(); public static HashMap<Player, OfflinePlayer> getOpenInv() { return openInv; }
/*  30 */    private static final HashMap<Player, Integer> inSumGUI = new HashMap<>(); public static HashMap<Player, Integer> getInSumGUI() { return inSumGUI; }
/*  31 */    private static final HashMap<Player, String> inInvGUI = new HashMap<>(); public static HashMap<Player, String> getInInvGUI() { return inInvGUI; }
/*  32 */    private static final HashMap<Player, ConfirmationType> inConfirmGUI = new HashMap<>(); public static HashMap<Player, ConfirmationType> getInConfirmGUI() { return inConfirmGUI; }
/*  33 */    private static final HashMap<OfflinePlayer, Boolean> hasBypass = new HashMap<>(); public static HashMap<OfflinePlayer, Boolean> getHasBypass() { return hasBypass; }
/*  34 */    private static final HashMap<OfflinePlayer, String> rank = new HashMap<>(); private static Permission permissions; private static Economy economy; private static MysqlManager mysqlManager; private static ConfigManager configManager; public static HashMap<OfflinePlayer, String> getRank() { return rank; }
/*  35 */   public static Permission getPermissions() { return permissions; }
/*  36 */   public static Economy getEconomy() { return economy; }
/*  37 */   public static MysqlManager getMysqlManager() { return mysqlManager; } public static ConfigManager getConfigManager() {
/*  38 */     return configManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onEnable() {
/*  43 */     loadConfig0(); configManager = new ConfigManager(this);
/*     */     
/*  45 */     if (configManager.getDatabaseType().equals("flatfile") || configManager.getDatabaseType().equals("mysql")) {
/*     */       
/*  47 */       if (Objects.equals(configManager.getDatabaseType(), "flatfile")) FlatfileManager.createFolder(); 
/*  48 */       new LanguageManager(this);
/*  49 */       (new CheckUpdateUtil(this)).checkUpdate();
/*  50 */       mysqlManager = new MysqlManager();
/*     */       
/*  52 */       setupPermissions();
/*  53 */       if (!configManager.getBoolean("economy.disable") && 
/*  54 */         !setupEconomy()) Bukkit.getServer().getConsoleSender().sendMessage("[InvSaver] " + ChatColor.RED + "Economy disabled due to no Vault dependency found!");
/*     */       
/*  56 */       PluginManager pluginManager = Bukkit.getPluginManager();
/*  57 */       pluginManager.registerEvents((Listener)new InventoryClick(), (Plugin)this);
/*  58 */       pluginManager.registerEvents((Listener)new InventoryDrag(), (Plugin)this);
/*  59 */       pluginManager.registerEvents((Listener)new InventoryClose(), (Plugin)this);
/*  60 */       pluginManager.registerEvents((Listener)new PlayerInteract(), (Plugin)this);
/*     */       
/*  62 */       getCommand("inventory").setExecutor((CommandExecutor)new ArgumentExecutor());
/*  63 */       getCommand("inventory").setTabCompleter((TabCompleter)new CommandTabCompleter());
/*     */     }
/*     */     else {
/*     */       
/*  67 */       Bukkit.getServer().getConsoleSender().sendMessage("[InvSaver] " + ChatColor.RED + "Please set a valid database type in the config file.");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onDisable() {
/*     */     try {
/*  75 */       if (Objects.equals(configManager.getDatabaseType(), "mysql") && mysqlManager.getMysql_connection() != null && !mysqlManager.getMysql_connection().isClosed()) {
/*  76 */         mysqlManager.getMysql_connection().close();
/*     */       }
/*  78 */       for (Player player : Bukkit.getOnlinePlayers()) {
/*  79 */         if (openInv.containsKey(player))
/*  80 */           player.closeInventory(); 
/*     */       } 
/*     */     } catch (Throwable throwable) {
/*     */       throw throwable;
/*     */     }  } private void setupPermissions() {
/*  85 */     RegisteredServiceProvider registeredServiceProvider = getServer().getServicesManager().getRegistration(Permission.class);
/*  86 */     if (registeredServiceProvider != null) {
/*  87 */       permissions = (Permission)registeredServiceProvider.getProvider();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean setupEconomy() {
/*  92 */     if (getServer().getPluginManager().getPlugin("Vault") == null) {
/*  93 */       return false;
/*     */     }
/*  95 */     RegisteredServiceProvider registeredServiceProvider = getServer().getServicesManager().getRegistration(Economy.class);
/*  96 */     if (registeredServiceProvider == null) {
/*  97 */       return false;
/*     */     }
/*  99 */     economy = (Economy)registeredServiceProvider.getProvider();
/* 100 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Core getInstance() {
/* 105 */     return (Core)getPlugin(Core.class);
/*     */   }
/*     */ }
