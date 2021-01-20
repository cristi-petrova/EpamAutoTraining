package cleanCode.aircompany;

import cleanCode.aircompany.Planes.MilitaryPlane;
import cleanCode.aircompany.Planes.PassengerPlane;
import cleanCode.aircompany.Planes.Plane;
import cleanCode.aircompany.models.MilitaryType;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Airport {
    private final List<? extends Plane> planes;

   public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = getPlanes(PassengerPlane.class);
        Optional<PassengerPlane> planeWithMaxCapacity = passengerPlanes.stream().max(Comparator.comparingInt(PassengerPlane::getPassengersCapacity));
        return planeWithMaxCapacity.orElse(null);
    }

    public List<MilitaryPlane> getMilitaryPlanesBYType(MilitaryType type) {
        List<MilitaryPlane> militaryPlanesByType = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getPlanes(MilitaryPlane.class);
        for (MilitaryPlane plane : militaryPlanes) {
            if (plane.getType() == type) {
                militaryPlanesByType.add(plane);
            }
        }
        return militaryPlanesByType;
    }

    public Airport sortByMaxDistance() {
        planes.sort(Comparator.comparingInt(Plane::getMaxFlightDistance));
        return this;
    }


    public Airport sortByMaxSpeed() {
        planes.sort(Comparator.comparingInt(Plane::getMaxSpeed));
        return this;
    }

    public void sortByMaxLoadCapacity() {
        planes.sort(Comparator.comparingInt(Plane::getMinLoadCapacity));
    }

    public List<? extends Plane> getPlanes() {return planes;}

    public <T extends Plane> List<T> getPlanes(Class<T> classPlane) {
        List<T> filteredPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (classPlane.isInstance(plane))
                filteredPlanes.add((T) plane);
        }
        return filteredPlanes;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }
}
