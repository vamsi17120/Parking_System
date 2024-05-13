package ParkingLot;

import Models.ParkingFloor;
import Models.ParkingLot;
import Models.ParkingSlot;
import Repositories.ParkingLotRepository;
import enums.SlotStatus;
import enums.VehicleType;

public class RandomParkingLot {

    private ParkingLotRepository parkingLotRepository;

    public RandomParkingLot(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public static ParkingSlot getSlot(ParkingLot parkingLot, VehicleType vehicleType) {

        for (ParkingFloor floor : parkingLot.getParkingFloor()) {
            for (ParkingSlot parkingSlot : floor.getParkingSlots()) {
                if (parkingSlot.getSupportedVehicleTypes().contains(vehicleType)
                        && parkingSlot.getSlotStatus().equals(SlotStatus.EMPTY)) {
                    return parkingSlot;
                }

            }
        }

        return null;
    }

}
