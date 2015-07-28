package x.subjects;

import x.constraint.Silly;

import javax.validation.constraints.Pattern;

public class Thing {

    @Pattern(regexp = "[0-9]+")
    String foo;
    @Silly
    String bar;

    public Thing(String foo) {
        this.foo = foo;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "foo='" + foo + '\'' +
                '}';
    }
}
