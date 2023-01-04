/*    */ package com.dnInventorySaver.plugin.Listener;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import com.dnInventorySaver.plugin.Manager.Gui.SumGui.SumGuiManager;
/*    */ import com.dnInventorySaver.plugin.Util.WorldUtil;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ 
/*    */ 
/*    */ public class PlayerInteract
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void playerBlockInteract(PlayerInteractEvent paramPlayerInteractEvent) {
/* 21 */     if (Core.getConfigManager().getBoolean("open-inv-with-block.enable")) {
/*    */       
/* 23 */       Player player = paramPlayerInteractEvent.getPlayer();
/* 24 */       Action action = paramPlayerInteractEvent.getAction();
/* 25 */       Block block = paramPlayerInteractEvent.getClickedBlock();
/*    */       
/* 27 */       if (!WorldUtil.disableWorld(player))
/*    */       {
/* 29 */         if (action.equals(
/* 30 */             Action.valueOf(Core.getConfigManager().getString("open-inv-with-block.clicktype").toUpperCase() + "_CLICK_BLOCK")) && block != null && block
/*    */           
/* 32 */           .getType().equals(Material.valueOf(Core.getConfigManager().getString("open-inv-with-block.material")))) {
/*    */           
/* 34 */           paramPlayerInteractEvent.setCancelled(true);
/* 35 */           (new SumGuiManager(player, (OfflinePlayer)player)).openSumGui(1);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Listener\PlayerInteract.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */