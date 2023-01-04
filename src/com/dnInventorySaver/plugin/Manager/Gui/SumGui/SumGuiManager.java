/*    */ package com.dnInventorySaver.plugin.Manager.Gui.SumGui;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.ConfigFile.LanguageManager;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Builder.IconBuilder;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Builder.IconPlacer;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Builder.NavBuilder;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Util.AllPageUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.Util.PageUtil;
/*    */ import com.dnInventorySaver.plugin.Manager.PlayerData.PlayerDataManager;
/*    */ import com.dnInventorySaver.plugin.Util.HasBypassUtil;
/*    */ import com.dnInventorySaver.plugin.Util.InventoryUtil;
/*    */ import com.dnInventorySaver.plugin.Util.PlayerHashUtil;
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SumGuiManager
/*    */ {
/*    */   private final Player opener;
/*    */   private final OfflinePlayer target;
/*    */   private final PlayerDataManager playerDataManager;
/*    */   
/*    */   public SumGuiManager(Player paramPlayer, OfflinePlayer paramOfflinePlayer) {
/* 31 */     this.opener = paramPlayer;
/* 32 */     this.target = paramOfflinePlayer;
/* 33 */     this.playerDataManager = new PlayerDataManager(paramOfflinePlayer);
/*    */   }
/*    */ 
/*    */   
/*    */   public void openSumGui(int paramInt) {
/* 38 */     if ((this.opener == this.target && this.playerDataManager.getInvAmount() > 0) || (this.opener != this.target && this.playerDataManager.getLiveInvAmount() > 0)) {
/*    */       
/* 40 */       ArrayList arrayList = IconBuilder.buildInventoryIcons(this.playerDataManager, this.opener);
/*    */       
/* 42 */       Inventory inventory = InventoryUtil.createInventory(LanguageManager.getString("sum-gui-title")
/* 43 */           .replaceAll("%target%", this.target.getName())
/* 44 */           .replaceAll("%page%", "" + paramInt)
/* 45 */           .replaceAll("%allpage%", "" + AllPageUtil.getAllPage(arrayList, Core.getConfigManager().getSumGuiSpace())), 4);
/*    */       
/* 47 */       NavBuilder.buildNavigation(inventory, paramInt, arrayList, this.playerDataManager);
/* 48 */       IconPlacer.placeInventoryIcons(inventory, paramInt, arrayList);
/* 49 */       HasBypassUtil.checkIfPlayerHasBypass(this.playerDataManager);
/* 50 */       Core.getRank().put(this.target, this.playerDataManager.getPlayerRank());
/*    */       
/* 52 */       if (!PageUtil.isPageValid(arrayList, paramInt, Core.getConfigManager().getSumGuiSpace())) {
/*    */         
/* 54 */         if (paramInt == 1) {
/*    */           
/* 56 */           Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), this.opener::closeInventory);
/*    */         }
/*    */         else {
/*    */           
/* 60 */           (new SumGuiManager(this.opener, (OfflinePlayer)Core.getOpenInv().get(this.opener))).openSumGui(((Integer)Core.getInSumGUI().get(this.opener)).intValue() - 1);
/*    */         } 
/*    */         
/*    */         return;
/*    */       } 
/* 65 */       Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), () -> {
/*    */             this.opener.openInventory(paramInventory);
/*    */ 
/*    */             
/*    */             PlayerHashUtil.putPlayerInHashMap(this.opener, this.target, paramInt);
/*    */           });
/* 71 */     } else if (this.opener == this.target) {
/*    */       
/* 73 */       this.opener.sendMessage(LanguageManager.getString("no-inv-saved"));
/* 74 */       Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), this.opener::closeInventory);
/*    */     }
/*    */     else {
/*    */       
/* 78 */       this.opener.sendMessage(LanguageManager.getString("target-no-inv-saved").replaceAll("%target%", this.target.getName()));
/* 79 */       Bukkit.getScheduler().runTask((Plugin)Core.getInstance(), this.opener::closeInventory);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\Gui\SumGui\SumGuiManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */