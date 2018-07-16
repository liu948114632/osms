package com.itecheasy.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.Cipher;

import org.apache.ws.security.util.Base64;

import sun.security.rsa.RSAPrivateKeyImpl;
import sun.security.util.DerValue;

public class RSAEncrypt {
   private  static String publicKeyPassword = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAKgHPfrrj3mUSGbHIrmRiOAPbZin/AM8Y5ooDjqwTxGRvJthvjsMCNAZMH/T6oCYFBVX/TPEYFjOIy0OhFXQjycCAwEAAQ=="; // 共钥 
    private static String privateKeyPassword = "MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAqAc9+uuPeZRIZsciuZGI4A9tmKf8AzxjmigOOrBPEZG8m2G+OwwI0Bkwf9PqgJgUFVf9M8RgWM4jLQ6EVdCPJwIDAQABAkByNnH/1AxzRMKt8d/9qRoTywjhAhZAENVXHLEHXX5xXrZc7Nwvxm08pYWfab0zHU2Xj4JhkzqtLKNq0reoVC35AiEA448RyEXnrSUZMS6bg38qS1fyLTfKnQcuVQaT4PEgClsCIQC9B3GOOaySrluDOnGkYbCIwaTawNCwh8qLzqsI1xowJQIhAIR8a5H6gSQhkUU9KXWpt+odzfXdoa1C3QrLxZUVTd45AiBGXCDueZU8u92gSP7H2vzkyn9cVWzYaJMB2xlanwZGaQIhAMt3/UMz88hV46bU6h3JCGn3slDGzDKX+4rfi/iJt4lo"; // 私钥  
  
    private KeyPairGenerator keyPairGen;  
  
    private KeyPair keyPair;  
  
    private RSAPrivateKey privateKey;  
  
    private RSAPublicKey publicKey;  
  
    public void createKey()  
    {  
        try  
        {  
            keyPairGen = KeyPairGenerator.getInstance("RSA");  
            keyPairGen.initialize(512);  
            keyPair = keyPairGen.generateKeyPair();  
            // Generate keys  
            privateKey = (RSAPrivateKey)keyPair.getPrivate();  
            publicKey = (RSAPublicKey)keyPair.getPublic();    
            byte[] privateEncode = privateKey.getEncoded();  
           // System.out.println("私钥:"+bytesToString(privateEncode));
            System.out.println("私钥:"+ Base64.encode(privateEncode));
            byte[] publicEncode = publicKey.getEncoded();  
           // System.out.println("共钥:"+bytesToString(publicEncode));
            System.out.println("共钥:"+ Base64.encode(publicEncode));
        }  
        catch (NoSuchAlgorithmException e)  
        {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 得到私钥 
     *  
     * @param keyPath 
     *            私钥地址 
     * @return 
     */  
    private  static RSAPrivateKey getPrivateKey()  
    {  
    	try{
         DerValue d = new DerValue(Base64.decode(privateKeyPassword));  
         PrivateKey p = RSAPrivateKeyImpl.parseKey(d);  
         return (RSAPrivateKey)p;  
    	}catch (Exception e) {
    		e.printStackTrace();  
		}
    	return null;
    } 
  
 /*   *//** 
     * 得到公钥 
     *  
     * @param keyPath 
     *            公钥文件地址 
     * @return 
     *//*  
    public  RSAPublicKey getPublicKey()  
    {  
    	try {  
            DerValue d = new DerValue(Base64.decode(publicKeyPassword));
            PublicKey p = RSAPublicKeyImpl.parse(d);  
            return (RSAPublicKey)p;  
          } catch (IOException ex2) {  
                ex2.printStackTrace();  
           }  
         return null;  
    } */ 
  
    public byte[] encrypt(RSAPublicKey publicKey, String info)  
    {  
          byte[] e = this.encrypt(publicKey, info.getBytes());  
          return e;
    }  
  
    public static String decrypt(String info) throws IOException  
    {  
    	RSAPrivateKey privateKey = getPrivateKey();
        ByteArrayInputStream bais = new ByteArrayInputStream(Base64.decode(info));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[64];  
        while (bais.read(bytes1) > 0)  
        {  
            byte[] de = decrypt(privateKey, bytes1);  
            bytes1 = new byte[64];  
            baos.write(de, 0, de.length);  
        }  
        return baos.toString();
    }  
  
    /** */  
    /** 
     * * Encrypt String. * 
     *  
     * @return byte[] 
     */  
    protected byte[] encrypt(RSAPublicKey publicKey, byte[] obj)  
    {  
        if (publicKey != null)  
        {  
            try  
            {  
            	Cipher cipher = Cipher.getInstance("RSA");  
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                //return cipher.doFinal(obj); 
                int blockSize = 53;
                int blocksNum = (int)Math.ceil((1.0*obj.length)/blockSize);
                for (int i = 0; i < blocksNum; i++) {
                    if (i < blocksNum - 1) {
                    	baos.write(cipher.doFinal(obj, i * blockSize, blockSize)) ;
                    } else {
                    	baos.write(cipher.doFinal(obj, i * blockSize, obj.length - i * blockSize));
                    }
                }
                return baos.toByteArray();  
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
  
    /** */  
    /** 
     * * Basic decrypt method * 
     *  
     * @return byte[] 
     */  
    protected static byte[] decrypt(RSAPrivateKey privateKey, byte[] obj)  
    {  
        if (privateKey != null)  
        {  
            try  
            {  
            	 Cipher cipher = Cipher.getInstance("RSA");  
                 cipher.init(Cipher.DECRYPT_MODE, privateKey); 
                 ByteArrayInputStream cis = new ByteArrayInputStream(obj);
                 ByteArrayOutputStream bos = new ByteArrayOutputStream();
                 /*加密时分块加密，加密输出结果大小固定*/
                 byte[] data = new byte[cipher.getOutputSize(cis.available())];
                 int len = 0;
                 while((len = cis.read(data)) > 0){
                     bos.write(cipher.doFinal(data, 0, len));
                 }
                 return bos.toByteArray(); 
            }  
            catch (Exception e)  
            {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
    
 /* public static void main(String[] args)  
    {  
        RSAEncrypt encrypt = new RSAEncrypt();  
        //创建秘钥
       // encrypt.createKey(); 
        
       RSAPublicKey publicKey = encrypt.getPublicKey();  
        // 公钥加密操作  
       byte[] info =  encrypt.encryptFile(publicKey, "192.168.192.18");  
       System.out.println(Base64.encode(info));
       
       //   RSAPrivateKey privateKey = encrypt.getPrivateKey();  
        // 私钥解密操作  
       try {
		System.out.println(encrypt.decryptFile(privateKey, "Jwa0f18chBlTpsV803a2jAaE8hh4jtXr3C//jMzhsKO+Is+0VxG9D4Y4MyFF6i52UBM72zx6bUyaraAQgD1MtQ=="));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } */ 
}
