/*    */ package com.dnInventorySaver.plugin.Manager.PlayerData.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class PermissionUtil
/*    */ {
/*    */   public static boolean playerHasPermissions(OfflinePlayer paramOfflinePlayer, String paramString) {
/* 13 */     Player player = paramOfflinePlayer.getPlayer();
/* 14 */     if (player == null) {
/* 15 */       return Core.getPermissions().playerHas(((World)Bukkit.getWorlds().get(0)).getName(), paramOfflinePlayer, paramString);
/*    */     }
/* 17 */     return Core.getPermissions().playerHas(player.getWorld().getName(), paramOfflinePlayer, paramString);
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Manager\PlayerData\Util\PermissionUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */