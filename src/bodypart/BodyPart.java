package bodypart;

public class BodyPart extends AbstractBodyPart {
    public BodyPart(BodyPartType bodyPartType) {
        this.bodyPartType = bodyPartType;
    }

    @Override
    public BodyPartType getBodyPartType() {
        return bodyPartType;
    }
}