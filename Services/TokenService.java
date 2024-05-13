package Services;

import java.sql.Date;

import Models.Gate;
import Models.ParkingLot;
import Models.ParkingSlot;
import Models.Token;
import Models.Vehicle;
import ParkingLot.RandomParkingLot;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TokenRepository;
import Repositories.VehicleRepository;
import enums.SlotStatus;
import enums.VehicleType;

public class TokenService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;

    private TokenRepository tokenRepository;

    public TokenService(GateRepository gateRepository, VehicleRepository vehicleRepository,
            ParkingLotRepository parkingLotRepository, TokenRepository tokenRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        // this.randomParkingLot = randomParkingLot;
        this.tokenRepository = tokenRepository;
    }

    @SuppressWarnings("deprecation")
    public Token issueToken(Long gateid, VehicleType vehicleType, String vehicleNumber, String ownerName) {

        Token token = new Token();

        token.setEntryTime(new Date(2024, 01, 17));

        Gate gate = gateRepository.findGateById(gateid);

        token.setGeneratedAt(gate);

        token.setGeneratedBy(gate.getOperator());

        Vehicle vehicle = new Vehicle();
        vehicle.setNumber(vehicleNumber);
        vehicle.setOwnername(ownerName);
        vehicle.setVehicleType(vehicleType);

        token.setVehicle(vehicle);

        ParkingLot parkingLot = parkingLotRepository.findParkingLotbyGate(gate);

        ParkingSlot parkingSlot = RandomParkingLot.getSlot(parkingLot, vehicleType);

        token.setAssignedSlot(parkingSlot);

        parkingSlot.setSlotStatus(SlotStatus.FILLED);

        Token savedToken = tokenRepository.save(token);

        savedToken.setNumber(savedToken.getId() + "-Token");

        return savedToken;

    }
}
