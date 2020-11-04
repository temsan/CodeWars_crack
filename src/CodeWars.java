import java.util.Formatter;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

public class CodeWars {
    public String crack(String hash, int length) {

        return IntStream.range(0, (int) Math.pow(10, length+1))
                .boxed()
                .parallel()
                .collect(Collectors.toMap(num -> new Formatter().format("%0"+ length +"d", num).toString(),
                        num -> md5Hex(new Formatter().format("%0" + length + "d", num).toString())))
                .entrySet().stream().parallel()
                .filter(e -> e.getValue().equals(hash))
                .peek(System.out::println)
                .findAny().map(Map.Entry::getKey).orElse("Not found");

    }
}