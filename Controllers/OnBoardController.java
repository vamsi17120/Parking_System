package Controllers;

import Services.ParkingLotService;

public class OnBoardController {
    private ParkingLotService parkingLotService;

    public OnBoardController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    public void OnBoardParkingLot() {

        parkingLotService.AddParkingLot();

    }

}
