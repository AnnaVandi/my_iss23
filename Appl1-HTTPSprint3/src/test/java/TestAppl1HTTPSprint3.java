import org.junit.Before;
import unibo.appl1.core.Appl1Core;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.fail;

public class TestAppl1HTTPSprint3 {
    private Appl1Core appl;

    @Before
    public void initSystemTest() throws Exception {

    }

    private void startTheApplication() {
        new Thread() {
            public void run() {
                try {
                    appl.start();
                } catch (Exception e) {
                    fail("startTheApplication " + e.getMessage());
                }
            }
        }.start();
    }

    private void checkHistoryAfterStop() {

    }
}


