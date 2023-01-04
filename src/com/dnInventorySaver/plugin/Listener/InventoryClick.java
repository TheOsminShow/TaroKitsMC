/*     */ package com.dnInventorySaver.plugin.Listener;
/*     */ 
/*     */ import com.dnInventorySaver.plugin.Core;
/*     */ import com.dnInventorySaver.plugin.Enum.ConfirmationType;
/*     */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*     */ import com.dnInventorySaver.plugin.Manager.Gui.ConfirmationGui.ConfirmationGuiManager;
/*     */ import com.dnInventorySaver.plugin.Manager.Gui.InventoryGui.InventoryGuiManager;
/*     */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.SumGuiManager;
/*     */ import com.dnInventorySaver.plugin.Util.ArmorUtil;
/*     */ import com.dnInventorySaver.plugin.Util.RankInfoUtil;
/*     */ import java.util.Objects;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.ClickType;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ public class InventoryClick
/*     */   implements Listener
/*     */ {
/*     */   @EventHandler
/*     */   public void onInventoryClick(InventoryClickEvent paramInventoryClickEvent) {
/*  30 */     Player player = (Player)paramInventoryClickEvent.getWhoClicked();
/*  31 */     Inventory inventory = paramInventoryClickEvent.getView().getTopInventory();
/*     */ 
/*     */     
/*  34 */     if (Core.getInInvGUI().containsKey(player) && !Core.getInConfirmGUI().containsKey(player)) {
/*     */       
/*  36 */       if (paramInventoryClickEvent.getClick().equals(ClickType.SHIFT_LEFT) || paramInventoryClickEvent.getClick().equals(ClickType.SHIFT_RIGHT)) {
/*     */         
/*  38 */         paramInventoryClickEvent.setCancelled(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  50 */       if (paramInventoryClickEvent.getClick().equals(ClickType.DOUBLE_CLICK))
/*     */       {
/*  52 */         paramInventoryClickEvent.setCancelled(true);
/*     */       }
/*  54 */       if (paramInventoryClickEvent.getClick().equals(ClickType.NUMBER_KEY) && player.getInventory().getItem(paramInventoryClickEvent.getHotbarButton()) != null) {
/*     */         
/*  56 */         if (paramInventoryClickEvent.getRawSlot() == 36 && !ArmorUtil.isBoots(player.getInventory().getItem(paramInventoryClickEvent.getHotbarButton()))) { paramInventoryClickEvent.setCancelled(true); return; }
/*  57 */          if (paramInventoryClickEvent.getRawSlot() == 37 && !ArmorUtil.isLeggings(player.getInventory().getItem(paramInventoryClickEvent.getHotbarButton()))) { paramInventoryClickEvent.setCancelled(true); return; }
/*  58 */          if (paramInventoryClickEvent.getRawSlot() == 38 && !ArmorUtil.isChestplate(player.getInventory().getItem(paramInventoryClickEvent.getHotbarButton()))) { paramInventoryClickEvent.setCancelled(true); return; }
/*  59 */          if (paramInventoryClickEvent.getRawSlot() == 39 && !ArmorUtil.isHelmet(player.getInventory().getItem(paramInventoryClickEvent.getHotbarButton()))) { paramInventoryClickEvent.setCancelled(true); return; }
/*     */       
/*  61 */       }  if (paramInventoryClickEvent.getClick().equals(ClickType.RIGHT) || paramInventoryClickEvent.getClick().equals(ClickType.LEFT))
/*     */       {
/*  63 */         if (!player.getItemOnCursor().getType().equals(Material.AIR)) {
/*     */           
/*  65 */           if (paramInventoryClickEvent.getRawSlot() == 36 && !ArmorUtil.isBoots(player.getItemOnCursor())) { paramInventoryClickEvent.setCancelled(true); return; }
/*  66 */            if (paramInventoryClickEvent.getRawSlot() == 37 && !ArmorUtil.isLeggings(player.getItemOnCursor())) { paramInventoryClickEvent.setCancelled(true); return; }
/*  67 */            if (paramInventoryClickEvent.getRawSlot() == 38 && !ArmorUtil.isChestplate(player.getItemOnCursor())) { paramInventoryClickEvent.setCancelled(true); return; }
/*  68 */            if (paramInventoryClickEvent.getRawSlot() == 39 && !ArmorUtil.isHelmet(player.getItemOnCursor())) { paramInventoryClickEvent.setCancelled(true);
/*     */             return; }
/*     */         
/*     */         } 
/*     */       }
/*     */     } 
/*  74 */     if (Core.getOpenInv().containsKey(player) && inventory.getSize() > paramInventoryClickEvent.getRawSlot()) {
/*     */       
/*  76 */       OfflinePlayer offlinePlayer = (OfflinePlayer)Core.getOpenInv().get(player);
/*     */       
/*  78 */       if (Core.getInSumGUI().containsKey(player) && !Core.getInInvGUI().containsKey(player) && !Core.getInConfirmGUI().containsKey(player)) {
/*     */         
/*  80 */         int i = ((Integer)Core.getInSumGUI().get(player)).intValue();
/*  81 */         paramInventoryClickEvent.setCancelled(true);
/*     */         
/*  83 */         if (paramInventoryClickEvent.getCurrentItem() != null && paramInventoryClickEvent.getCurrentItem().getType() != Material.AIR && paramInventoryClickEvent.getSlot() != 31)
/*     */         {
/*  85 */           if (paramInventoryClickEvent.getSlot() == 30)
/*     */           {
/*  87 */             if (i == 1)
/*     */             {
/*  89 */               player.closeInventory();
/*     */             }
/*  91 */             else if (i > 1)
/*     */             {
/*  93 */               Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new SumGuiManager(paramPlayer, paramOfflinePlayer)).openSumGui(paramInt - 1));
/*     */             }
/*     */           
/*     */           }
/*  97 */           else if (paramInventoryClickEvent.getSlot() == 32)
/*     */           {
/*  99 */             Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new SumGuiManager(paramPlayer, paramOfflinePlayer)).openSumGui(paramInt + 1));
/*     */ 
/*     */ 
/*     */           
/*     */           }
/* 104 */           else if (player == offlinePlayer || player.hasPermission("invsaver.others.inv.open"))
/*     */           {
/* 106 */             String str = ChatColor.stripColor(paramInventoryClickEvent.getCurrentItem().getItemMeta().getDisplayName());
/* 107 */             Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(paramPlayer, paramOfflinePlayer, paramString)).openInventory());
/*     */           
/*     */           }
/*     */           else
/*     */           {
/* 112 */             player.sendMessage(LanguageManager.getString("dont-have-permission"));
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 117 */       else if (Core.getInInvGUI().containsKey(player) && !Core.getInConfirmGUI().containsKey(player)) {
/*     */         
/* 119 */         int i = ((Integer)Core.getInSumGUI().get(player)).intValue();
/* 120 */         if (inventory.getSize() > paramInventoryClickEvent.getRawSlot())
/*     */         {
/* 122 */           if (paramInventoryClickEvent.getSlot() >= 42) {
/*     */             
/* 124 */             paramInventoryClickEvent.setCancelled(true);
/* 125 */             if (paramInventoryClickEvent.getSlot() == 42) {
/*     */               
/* 127 */               Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new SumGuiManager(paramPlayer, paramOfflinePlayer)).openSumGui(paramInt));
/*     */             
/*     */             }
/* 130 */             else if (paramInventoryClickEvent.getSlot() == 43) {
/*     */               
/* 132 */               if (player == offlinePlayer || (player.hasPermission("invsaver.others.inv.load") && !((Boolean)Core.getHasBypass().get(offlinePlayer)).booleanValue()))
/*     */               {
/* 134 */                 Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new ConfirmationGuiManager(paramPlayer, ConfirmationType.LOAD)).openGui(paramOfflinePlayer, (String)Core.getInInvGUI().get(paramPlayer), ((Integer)Core.getInSumGUI().get(paramPlayer)).intValue()));
/*     */               
/*     */               }
/*     */               else
/*     */               {
/* 139 */                 player.sendMessage(LanguageManager.getString("dont-have-permission"));
/*     */               }
/*     */             
/* 142 */             } else if (paramInventoryClickEvent.getSlot() == 44) {
/*     */               
/* 144 */               if (player == offlinePlayer || (player.hasPermission("invsaver.others.inv.delete") && !((Boolean)Core.getHasBypass().get(offlinePlayer)).booleanValue()))
/*     */               {
/* 146 */                 Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new ConfirmationGuiManager(paramPlayer, ConfirmationType.DELETE)).openGui(paramOfflinePlayer, (String)Core.getInInvGUI().get(paramPlayer), ((Integer)Core.getInSumGUI().get(paramPlayer)).intValue()));
/*     */               
/*     */               }
/*     */               else
/*     */               {
/* 151 */                 player.sendMessage(LanguageManager.getString("dont-have-permission"));
/*     */               }
/*     */             
/*     */             } 
/* 155 */           } else if (paramInventoryClickEvent.getRawSlot() < 42) {
/*     */             
/* 157 */             if (paramInventoryClickEvent.getRawSlot() == 40 || paramInventoryClickEvent.getRawSlot() == 41) { paramInventoryClickEvent.setCancelled(true); return; }
/* 158 */              if ((paramInventoryClickEvent.getClick().equals(ClickType.RIGHT) || paramInventoryClickEvent.getClick().equals(ClickType.LEFT)) && (paramInventoryClickEvent
/* 159 */               .getCurrentItem() == null || paramInventoryClickEvent.getCurrentItem().getType().equals(Material.AIR)) && (paramInventoryClickEvent
/* 160 */               .getCursor() == null || paramInventoryClickEvent.getCursor().getType().equals(Material.AIR))) {
/*     */               return;
/*     */             }
/*     */ 
/*     */             
/* 165 */             if ((player == offlinePlayer && Objects.equals(Core.getRank().get(offlinePlayer), "*")) || (player == offlinePlayer && 
/* 166 */               RankInfoUtil.canEdit((String)Core.getRank().get(offlinePlayer))) || (player != offlinePlayer && player
/* 167 */               .hasPermission("invsaver.others.inv.edit") && !((Boolean)Core.getHasBypass().get(offlinePlayer)).booleanValue()))
/*     */             {
/* 169 */               Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(paramPlayer, paramOfflinePlayer, (String)Core.getInInvGUI().get(paramPlayer))).updateInventory(paramInventory));
/*     */             
/*     */             }
/*     */             else
/*     */             {
/* 174 */               paramInventoryClickEvent.setCancelled(true);
/* 175 */               player.sendMessage(LanguageManager.getString("dont-have-permission"));
/*     */             }
/*     */           
/*     */           } 
/*     */         }
/* 180 */       } else if (Core.getInConfirmGUI().containsKey(player)) {
/*     */         
/* 182 */         paramInventoryClickEvent.setCancelled(true);
/* 183 */         if (inventory.getSize() > paramInventoryClickEvent.getRawSlot())
/*     */         {
/* 185 */           if (paramInventoryClickEvent.getSlot() == 4) {
/*     */             
/* 187 */             String str = (String)Core.getInInvGUI().get(player);
/* 188 */             switch ((ConfirmationType)Core.getInConfirmGUI().get(player)) {
/*     */               
/*     */               case DELETE:
/* 191 */                 Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(paramPlayer, paramOfflinePlayer, paramString)).deleteInventory());
/*     */                 break;
/*     */               
/*     */               case CLEAR:
/* 195 */                 Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(paramPlayer, paramOfflinePlayer, null)).clearInventories());
/*     */                 break;
/*     */               
/*     */               case LOAD:
/* 199 */                 (new InventoryGuiManager(player, offlinePlayer, str)).loadInventory();
/*     */                 break;
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 206 */           } else if (Core.getInSumGUI().containsKey(player)) {
/*     */             
/* 208 */             Bukkit.getScheduler().runTaskAsynchronously((Plugin)Core.getInstance(), () -> (new InventoryGuiManager(paramPlayer, paramOfflinePlayer, (String)Core.getInInvGUI().get(paramPlayer))).openInventory());
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 213 */             player.closeInventory();
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }
