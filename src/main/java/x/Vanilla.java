package x;

import x.subjects.Beany;
import x.subjects.Tester;

public class Vanilla {
    public static void main(String[] args) {
        Beany beany = new Beany();
        Tester.expectViolations(beany);
    }

}
