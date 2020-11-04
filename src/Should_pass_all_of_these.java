import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Should_pass_all_of_these {

    private CodeWars objTF = new CodeWars();

    @Test
    public void simple_test() {
        assertEquals("Should work with simple PIN", "12345", objTF.crack("827ccb0eea8a706c4c34a16891f84e7b", 5));
    }

    @Test
    public void harder_test() {
        assertEquals("Should work with harder PIN", "00078", objTF.crack("86aa400b65433b608a9db30070ec60cd", 5));
    }
}