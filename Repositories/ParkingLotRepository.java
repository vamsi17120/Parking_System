package Repositories;

import java.util.Map;
import java.util.TreeMap;

import Models.Gate;
import Models.ParkingLot;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLots = new TreeMap<>();
    private Long previousId = 0L;

    public ParkingLot findParkingLotbyGate(Gate gate) {

        for (ParkingLot parkingLot : parkingLots.values()) {
            if (parkingLot.getGates().contains(gate)) {
                return parkingLot;
            }

        }
        return null;
    }

    public ParkingLot saveParkingLot(ParkingLot parkingLot) {
        previousId += 1;
        parkingLot.setId(previousId);
        parkingLots.put(previousId, parkingLot);
        return parkingLot;
    }
}
