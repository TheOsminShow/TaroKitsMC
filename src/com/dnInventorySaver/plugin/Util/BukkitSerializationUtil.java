/*    */ package com.dnInventorySaver.plugin.Util;
/*    */ 
/*    */ import java.io.ByteArrayInputStream;
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.util.io.BukkitObjectInputStream;
/*    */ import org.bukkit.util.io.BukkitObjectOutputStream;
/*    */ import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BukkitSerializationUtil
/*    */ {
/*    */   public static String itemStackArrayToBase64(ItemStack[] paramArrayOfItemStack) {
/*    */     try {
/* 17 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 18 */       BukkitObjectOutputStream bukkitObjectOutputStream = new BukkitObjectOutputStream(byteArrayOutputStream);
/*    */       
/* 20 */       bukkitObjectOutputStream.writeInt(paramArrayOfItemStack.length);
/*    */       
/* 22 */       for (ItemStack itemStack : paramArrayOfItemStack) {
/* 23 */         bukkitObjectOutputStream.writeObject(itemStack);
/*    */       }
/*    */       
/* 26 */       bukkitObjectOutputStream.close();
/* 27 */       return Base64Coder.encodeLines(byteArrayOutputStream.toByteArray());
/* 28 */     } catch (Exception exception) {
/* 29 */       throw new IllegalStateException("Unable to save item stacks.", exception);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static ItemStack[] itemStackArrayFromBase64(String paramString) {
/*    */     try {
/* 35 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64Coder.decodeLines(paramString));
/* 36 */       BukkitObjectInputStream bukkitObjectInputStream = new BukkitObjectInputStream(byteArrayInputStream);
/* 37 */       ItemStack[] arrayOfItemStack = new ItemStack[bukkitObjectInputStream.readInt()];
/*    */       
/* 39 */       for (byte b = 0; b < arrayOfItemStack.length; b++) {
/* 40 */         arrayOfItemStack[b] = (ItemStack)bukkitObjectInputStream.readObject();
/*    */       }
/*    */       
/* 43 */       bukkitObjectInputStream.close();
/* 44 */       return arrayOfItemStack;
/* 45 */     } catch (ClassNotFoundException classNotFoundException) {
/* 46 */       throw new IOException("Unable to decode class type.", classNotFoundException);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\marcp\Downloads\InventorySaver.jar!\com\dnInventorySaver\plugin\Util\BukkitSerializationUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */