package ParkingSlot;

import ParkingSlot.Model.*;

import javax.security.auth.callback.TextInputCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingMain {
    public static void main(String[] args) throws InterruptedException{
        String nameOfParkingLot = "Anands Parking Lot";
        Address address = Address.builder().city("MANDI").country("IND").state("HP").build();
        Map<ParkingSlotType, Map<String, ParkingSlot>> allSlot = new HashMap<>();

        Map<String, ParkingSlot> compactSlot = new HashMap<>();
        compactSlot.put("C1",new ParkingSlot("C1", ParkingSlotType.Compact));
        compactSlot.put("C2",new ParkingSlot("C2", ParkingSlotType.Compact));
        compactSlot.put("C3",new ParkingSlot("C3", ParkingSlotType.Compact));
        allSlot.put(ParkingSlotType.Compact,compactSlot);

        Map<String,ParkingSlot> largeSlot = new HashMap<>();
        largeSlot.put("L1",new ParkingSlot("L1",ParkingSlotType.Large));
        largeSlot.put("L2",new ParkingSlot("L2",ParkingSlotType.Large));
        largeSlot.put("L3",new ParkingSlot("L3",ParkingSlotType.Large));
        allSlot.put(ParkingSlotType.Large,largeSlot);

        ParkingFloor parkingFloor = new ParkingFloor("1",allSlot);
        List<ParkingFloor> parkingFloors  = new ArrayList<>();
        parkingFloors.add(parkingFloor);

        ParkingLot parkingLot = ParkingLot.getInstance(nameOfParkingLot,address,parkingFloors);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleCategory(VehicleCategory.Hatchback);
        vehicle.setVechileNumber("ZA-01-0001");

        Ticket ticket = parkingLot.assignTicket(vehicle);
        System.out.println("ticket number"+ ticket.getTicketNumber());
        Thread.sleep(1000);
        double price = parkingLot.ScanAndPay(ticket);
        System.out.println("Price"+ price);
    }
}
