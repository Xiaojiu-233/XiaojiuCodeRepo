package MD5Encrypt;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class EncryptMain {
    public static String MD5Encrypt(String s){
        String ret = null;
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(s.getBytes());
            byte[] digestBytes = md5.digest();
            ret= new String(Base64.getEncoder().encodeToString(digestBytes));
        }catch (Exception ignored){}
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(MD5Encrypt("12345678"));
    }
}
