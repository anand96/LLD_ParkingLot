package ParkingSlot.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Vehicle {
    String vechileNumber;
    VehicleCategory vehicleCategory;
}
