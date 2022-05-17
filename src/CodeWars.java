import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.LongStream;

public class CodeWars {

    public String crack(String hash, int length) {

        // I tested with different lengths of the pin code, on my laptop I was able to crack only 6 characters
        //long length = 5;

        return LongStream.range(0, (int) Math.pow(10, length+1))
                    .mapToObj(pin -> String.format("%0"+String.valueOf(length)+"d", pin))
                    .parallel()
                    .filter(pin -> md5Hex(pin).equals(hash))
                    .peek(System.out::println)
                    .findAny().orElse("Not found");
    }

    public String md5Hex(String pin) {
        try {
            return new BigInteger(1, MessageDigest.getInstance("MD5").digest(pin.getBytes())).toString(16);
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}