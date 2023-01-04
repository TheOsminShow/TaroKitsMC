/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.util.HashSet;
/*    */ import java.util.Map;
/*    */ import java.util.Objects;
/*    */ import java.util.Set;
/*    */ import org.bukkit.OfflinePlayer;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InPlayersUtil
/*    */ {
/*    */   public static Set<Player> getOpenInvPlayers(Map<Player, OfflinePlayer> paramMap, OfflinePlayer paramOfflinePlayer) {
/* 17 */     HashSet<Player> hashSet = new HashSet();
/* 18 */     if (paramMap.containsValue(paramOfflinePlayer))
/*    */     {
/* 20 */       for (Map.Entry<Player, OfflinePlayer> entry : paramMap.entrySet()) {
/*    */         
/* 22 */         if (Objects.equals(entry.getValue(), paramOfflinePlayer))
/* 23 */           hashSet.add(entry.getKey()); 
/*    */       } 
/*    */     }
/* 26 */     return hashSet;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Set<Player> getInInvPlayers(Map<Player, String> paramMap, Set<Player> paramSet, String paramString) {
/* 49 */     HashSet<Player> hashSet = new HashSet();
/* 50 */     if (paramSet.size() > 0)
/*    */     {
/* 52 */       for (Player player : paramSet) {
/*    */         
/* 54 */         if (Core.getInInvGUI().containsKey(player) && !Core.getInConfirmGUI().containsKey(player) && Objects.equals(paramMap.get(player), paramString))
/* 55 */           hashSet.add(player); 
/*    */       } 
/*    */     }
/* 58 */     return hashSet;
/*    */   }
/*    */ }
