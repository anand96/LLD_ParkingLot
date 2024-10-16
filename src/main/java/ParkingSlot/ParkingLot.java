package ParkingSlot;

import ParkingSlot.Model.Address;
import ParkingSlot.Model.ParkingSlotType;
import ParkingSlot.Model.Ticket;
import ParkingSlot.Model.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private String nameOfParkinglot;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    public ParkingLot(String nameOfParkinglot, Address address, List<ParkingFloor> parkingFloors) {
        this.nameOfParkinglot = nameOfParkinglot;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(String nameOfParkinglot,Address address,List<ParkingFloor> parkingFloors)
    {
        if(parkingLot==null)
        {
            parkingLot = new ParkingLot(nameOfParkinglot,address,parkingFloors);
        }
        return parkingLot;
    }

    public void addFloor(String name, Map<ParkingSlotType, Map<String ,ParkingSlot>> parkSlots){
        ParkingFloor parkingFloor = new ParkingFloor(name,parkSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFLoors(ParkingFloor parkingFloor)
    {
        parkingFloors.remove(parkingFloor);
    }

    public Ticket assignTicket(Vehicle vehicle){
        ParkingSlot parkingSlot =getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot==null)
            return null;
        Ticket parkingTicket = createTicketForSlot(parkingSlot,vehicle);
        return parkingTicket;
    }

    public double ScanAndPay(Ticket ticket){
        long endTime = System.currentTimeMillis();
        ticket.getParkingSlot().removeVechile(ticket.getVehicle());
        int duration = (int) (endTime - ticket.getStartTime()) /1000;
        double price = ticket.getParkingSlot().getParkingSlotType().getPriceForParking(duration);
        return price;
    }
    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle) {
        return Ticket.createTicket(vehicle,parkingSlot);
    }

    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle) {
        ParkingSlot parkingSlot=null;
        for(ParkingFloor floor : parkingFloors){
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot!= null) break;
        }
        return parkingSlot;
    }




}
