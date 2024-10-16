package ParkingSlot;

import ParkingSlot.Model.ParkingSlotType;
import ParkingSlot.Model.Vehicle;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ParkingSlot {
    String name;
    @Builder.Default
    boolean isavailable = true;

    Vehicle vehicle;
    ParkingSlotType parkingSlotType;

    public ParkingSlot(String name, ParkingSlotType parkingSlotType) {
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected void addVehicle(Vehicle vehicle)
    {
        this.vehicle =vehicle;
        isavailable =false;
    }

    protected void removeVechile(Vehicle vehicle)
    {
        this.vehicle = null;
        this.isavailable =true;
    }
}

