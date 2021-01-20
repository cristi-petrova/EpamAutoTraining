package cleanCode.aircompany.Planes;

import cleanCode.aircompany.models.ClassificationLevel;
import cleanCode.aircompany.models.ExperimentalType;

import java.util.Objects;
public class ExperimentalPlane extends Plane{

    private final ExperimentalType type;
    private final ClassificationLevel classificationLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType type, ClassificationLevel classificationLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.classificationLevel = classificationLevel;
        this.type = type;
    }

    public ClassificationLevel getClassificationLevel(){
        return classificationLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExperimentalPlane)) return false;
        if (!super.equals(o)) return false;
        ExperimentalPlane plane = (ExperimentalPlane) o;
        return classificationLevel == plane.classificationLevel && type == plane.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), classificationLevel, type);
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", classificationLevel='" + classificationLevel + '\'' +
                ", experimentalType=" + type +
                '}');



    }
}
