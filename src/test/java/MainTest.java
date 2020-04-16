import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void userWantsToExitIsWorkingCorrectly(){
        Assertions.assertTrue(Main.userWantsToQuit("exit"));
        Assertions.assertTrue(Main.userWantsToQuit("ExIt"));
        Assertions.assertTrue(Main.userWantsToQuit("  ExIt   "));
        Assertions.assertFalse(Main.userWantsToQuit("ExIt1"));
    }

}
