/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import net.md_5.bungee.api.chat.BaseComponent;
/*    */ import net.md_5.bungee.api.chat.ClickEvent;
/*    */ import net.md_5.bungee.api.chat.ComponentBuilder;
/*    */ import net.md_5.bungee.api.chat.HoverEvent;
/*    */ import net.md_5.bungee.api.chat.TextComponent;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class ClickableMessageUtil
/*    */ {
/*    */   public static void sendClickableMessage(Player paramPlayer, String paramString1, String paramString2, String paramString3) {
/* 14 */     TextComponent textComponent = new TextComponent(StringUtil.translate(paramString1));
/* 15 */     textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, paramString2));
/* 16 */     textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(StringUtil.translate(paramString3))).create()));
/* 17 */     paramPlayer.spigot().sendMessage((BaseComponent)textComponent);
/*    */   }
/*    */ }
