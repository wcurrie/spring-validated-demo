package x.subjects;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

public class Tester {
    public static void expectViolations(Beany beany) {
        try {
            beany.doList(Collections.singletonList(new Thing("abc")));
            fail();
        } catch (ConstraintViolationException e) {
            System.out.println("GOOD: " + e);
        }
        try {
            beany.doIt(new Thing("abc"));
            fail();
        } catch (ConstraintViolationException e) {
            System.out.println("GOOD: " + e);
        }
        try {
            beany.doMore(null);
            fail();
        } catch (ConstraintViolationException e) {
            System.out.println("GOOD: " + e);
        }
    }

    private static void fail() {
        throw new AssertionError("Should have failed validation");
    }

}
