import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Should_pass_all_of_these {

    private CodeWars objTF = new CodeWars();

    @Test
    public void simple_test() {
        String pin = "999999999";
        assertEquals("Should work with simple PIN", pin, objTF.crack(objTF.md5Hex(pin), pin.length()));
    }

    @Test
    public void harder_test() {
        String pin = "00078";
        assertEquals("Should work with harder PIN", pin, objTF.crack(objTF.md5Hex(pin), pin.length()));
    }
}