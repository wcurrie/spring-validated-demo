package x;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Pattern;

//@Validated
public class Thing {

    @Pattern(regexp = "[0-9]+")
    String foo;

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
