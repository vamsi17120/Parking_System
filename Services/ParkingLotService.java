package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Gate;
import Models.Operator;
import Models.ParkingFloor;
import Models.ParkingLot;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import enums.GateStatus;
import enums.GateType;
import enums.ParkingLotStatus;
import enums.VehicleType;

public class ParkingLotService {

    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    public void AddParkingLot() {

        ParkingLot parkingLot = new ParkingLot();

        List<ParkingFloor> parkingFloor = new ArrayList<>();

        for (int i = 1; i < 4; i++) {
            ParkingFloor floor = new ParkingFloor();
            floor.fill(i + "");
            parkingFloor.add(floor);
        }

        parkingLot.setParkingFloor(parkingFloor);

        List<Gate> gates = new ArrayList<>();

        for (int i = 1; i < 5; i++) {
            Gate gate = new Gate();
            gate.setGateNumber(i);
            gate.setOperator(new Operator("Operator" + i, i));
            gate.setGateStatus(GateStatus.OPEN);
            gate.setParkingLot(parkingLot);

            if (i <= 3) {
                gate.setGateType(GateType.ENTRY);
            } else
                gate.setGateType(GateType.EXIT);

            gates.add(gate);
            gateRepository.saveGate(gate);
        }
        parkingLot.setGates(gates);

        parkingLot.setCapacity(6);

        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);

        List<VehicleType> vehicleTypes = new ArrayList<>() {
            {
                add(VehicleType.BICYCLE);
                add(VehicleType.CAR);

            }
        };
        parkingLot.setVehicleTypes(vehicleTypes);
        parkingLotRepository.saveParkingLot(parkingLot);

    }

}
