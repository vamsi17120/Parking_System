import java.util.Scanner;

import Controllers.BillController;
import Controllers.OnBoardController;
import Controllers.TokenController;
import DTO.IssueTokenResponseDTO;
import DTO.IssusTokenRequestDTO;
import Models.Bill;
import Models.Token;
import Repositories.GateRepository;
import Repositories.ParkingLotRepository;
import Repositories.TokenRepository;
import Repositories.VehicleRepository;
import Services.BillService;
import Services.ParkingLotService;
import Services.TokenService;
import enums.VehicleType;

public class Cleint {

        public static void main(String[] args) {

                GateRepository gateRepository = new GateRepository();
                ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

                TokenRepository tokenRepository = new TokenRepository();

                VehicleRepository vehicleRepository = new VehicleRepository();

                ParkingLotService parkingLotService = new ParkingLotService(gateRepository, parkingLotRepository);

                OnBoardController onBoardController = new OnBoardController(parkingLotService);

                onBoardController.OnBoardParkingLot();

                TokenService tokenService = new TokenService(gateRepository, vehicleRepository, parkingLotRepository,
                                tokenRepository);

                TokenController tokenController = new TokenController(tokenService);

                IssusTokenRequestDTO requestDTO = new IssusTokenRequestDTO();
                IssueTokenResponseDTO responseDTO = tokenController
                                .issueToken(requestDTO.setGateId(1L).setOwnerName("VAMSHI")
                                                .setVehicleNumber("TS07").setVehicleType(VehicleType.CAR));

                // System.out.println(responseDTO.getFailureMessage());

                // Token token = responseDTO.getToken();

                Scanner sc = new Scanner(System.in);
                System.out.println("enter the token id");
                Long number = sc.nextLong();
                Token token = tokenRepository.getToken(number);

                BillService billService = new BillService();

                BillController billController = new BillController(billService);

                Bill bill = billController.generateBill(token);

                System.out.println(bill.getAmount() + " " + token.getVehicle().getOwnername() + " " + bill.getGate());

        }
}
