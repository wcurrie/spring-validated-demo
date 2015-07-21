package x;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Service
@Validated
public class Beany {

    public void doIt(@Valid Thing thing) {
        System.out.println("doIt got " + thing);
    }

    public void doMore(@NotNull String arg) {
        System.out.println("arg = " + arg);
    }
}
