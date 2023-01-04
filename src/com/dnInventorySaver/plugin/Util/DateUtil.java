/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import com.dnInventorySaver.plugin.Core;
/*    */ import java.sql.Timestamp;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.time.LocalDateTime;
/*    */ import java.time.format.DateTimeFormatter;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DateUtil
/*    */ {
/*    */   public static String getDate() {
/* 16 */     Date date = new Date();
/* 17 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Core.getConfigManager().getString("date-format"));
/* 18 */     return simpleDateFormat.format(date);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getDate(Timestamp paramTimestamp) {
/* 23 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Core.getConfigManager().getString("date-format"));
/* 24 */     return simpleDateFormat.format(paramTimestamp);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Timestamp getDate(String paramString) {
/* 29 */     String str = Core.getConfigManager().getString("date-format");
/* 30 */     DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(str);
/* 31 */     LocalDateTime localDateTime = LocalDateTime.from(dateTimeFormatter.parse(paramString));
/* 32 */     return Timestamp.valueOf(localDateTime);
/*    */   }
/*    */ }
