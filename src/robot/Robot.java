package robot;

import bodypart.AbstractBodyPart;
import bodypart.BodyPart;
import java.util.ArrayList;
import java.util.Arrays;

public class Robot extends AbstractRobot {
    public Robot(String robotName, BodyPart... bodyParts) {
        this.robotName = robotName;
        this.bodyParts = new ArrayList<>(Arrays.asList(bodyParts)); //т.к. у List нельзя было бы вызвать remove()
        setHitPoints();
    }

    @Override
    public void removeBodyPart(AbstractBodyPart bodyPart) {
        AbstractBodyPart element = bodyParts.stream()
                .filter(predicate -> predicate.getBodyPartType().equals(bodyPart.getBodyPartType()))
                .findFirst()
                .get();
        bodyParts.remove(element);
    }

    @Override
    public void setHitPoints() {
        hitPoints = 0;
        for (AbstractBodyPart bodyPart : bodyParts) {
            hitPoints += 1;
        }
    }
}