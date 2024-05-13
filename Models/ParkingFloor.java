package Models;

import java.util.ArrayList;
import java.util.List;

import enums.FloorStatus;
import enums.SlotStatus;
import enums.VehicleType;

public class ParkingFloor extends BaseModel {

    private String number;

    private List<ParkingSlot> parkingSlots;

    private List<VehicleType> vehicleTypes;

    private FloorStatus floorStatus;

    public String getNumber() {
        return number;
    }

    public ParkingFloor() {
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public FloorStatus getFloorStatus() {
        return floorStatus;
    }

    public void setFloorStatus(FloorStatus floorStatus) {
        this.floorStatus = floorStatus;
    }

    public ParkingFloor fill(String number) {
        this.setNumber(number);
        List<ParkingSlot> parkingSlots = new ArrayList<>();
        for (int i = 1; i < 4; i++) {

            ParkingSlot parkingSlot = new ParkingSlot(SlotStatus.EMPTY);
            parkingSlot.setNumber(i + "");
            // parkingSlot.setSlotStatus(SlotStatus.EMPTY);
            if (i <= 2)
                parkingSlot.setSupportedVehicleTypes(VehicleType.BICYCLE);
            else
                parkingSlot.setSupportedVehicleTypes(VehicleType.CAR);
            parkingSlots.add(parkingSlot);

        }
        this.setParkingSlots(parkingSlots);

        List<VehicleType> vehicleTypes = new ArrayList<>() {
            {
                add(VehicleType.BICYCLE);
                add(VehicleType.CAR);

            }
        };

        this.setVehicleTypes(vehicleTypes);
        this.setFloorStatus(FloorStatus.AVAIABLE);

        return this;
    }

}
