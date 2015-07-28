package x.subjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import java.util.Collections;

@Service
public class TroubleMaker {

    @Autowired
    Beany beany;

    @Scheduled(initialDelay = 100, fixedDelay = 10000)
    public void foo() {
        System.out.println("making a thing");
        try {
            Tester.expectViolations(beany);
            System.out.println("made a thing");
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
            e.getConstraintViolations().forEach(v -> {
                System.out.println(v.getMessage());
            });
        }
    }
}
