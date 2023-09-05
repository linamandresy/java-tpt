package mbds.tpt.egouvernance_javaserver.helpers;

import java.math.BigInteger;
import java.security.*;

public class HashUtil {

    public static String sha1(String value){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDiggest = md.digest(value.getBytes());
            BigInteger no = new BigInteger(1,messageDiggest);
            String hashText = no.toString(16);
            while(hashText.length()<32){
                hashText = "0"+hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
