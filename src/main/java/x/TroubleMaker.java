package x;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;

@Service
public class TroubleMaker {

    @Autowired
    Beany beany;

    @Scheduled(initialDelay = 100, fixedDelay = 1000)
    public void foo() {
        System.out.println("making a thing");
        try {
            beany.doIt(new Thing("abc"));
            beany.doMore(null);
            System.out.println("made a thing");
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
            e.getConstraintViolations().forEach(v -> {
                System.out.println(v.getMessage());
            });
        }
    }
}
