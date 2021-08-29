package robot;

import bodypart.AbstractBodyPart;
import moves.Attack;
import moves.Defence;
import utils.Utils;
import java.util.List;

public abstract class AbstractRobot implements Attack, Defence {
    protected int hitPoints;
    protected String robotName;
    protected List<AbstractBodyPart> bodyParts;

    public String getRobotName() {
        return robotName;
    }

    public abstract void setHitPoints();

    public abstract void removeBodyPart(AbstractBodyPart bodyPart);

    public int getHitPoints() {
        return hitPoints;
    }

    @Override
    public AbstractBodyPart attack() {
        AbstractBodyPart attackedPart = null;
        int randomBodyPartNumber = Utils.random(0, bodyParts.size() - 1);

        if (bodyParts.size() > 0) {
            attackedPart = bodyParts.get(randomBodyPartNumber);
        }

        return attackedPart;
    }

    @Override
    public AbstractBodyPart defence() {
        AbstractBodyPart defendedPart = null;
        int randomBodyPartNumber = Utils.random(0, bodyParts.size() - 1);

        if (bodyParts.size() > 0) {
            defendedPart = bodyParts.get(randomBodyPartNumber);
        }

        return defendedPart;
    }
}