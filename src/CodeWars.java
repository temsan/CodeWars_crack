import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodeWars {

    public String crack(String hash, int length) {

        //int length = 5;

        return IntStream.range(0, (int) Math.pow(10, length+1))
                .boxed()
                .parallel()
                .collect(Collectors.toMap(num -> String.format("%0"+String.valueOf(length)+"d", num),
                        num -> {
                            try {
                                return md5Hex(String.format("%0"+String.valueOf(length)+"d", num));
                            } catch (NoSuchAlgorithmException e) {
                                e.printStackTrace();
                                return "";
                            }
                        }))
                .entrySet().stream()
                .parallel()
                .filter(e -> e.getValue().equals(hash))
                .peek(System.out::println)
                .findAny().map(Map.Entry::getKey).orElse("Not found");

    }

    private String md5Hex(String pin) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pin.getBytes());
        byte[]digest = md.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        return bigInt.toString(16);
    }
}