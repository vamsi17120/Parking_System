package Controllers;

import Models.Bill;
import Models.Token;
import Services.BillService;

public class BillController {

    private BillService billservice;

    public BillController(BillService billservice) {
        this.billservice = billservice;
    }

    public Bill generateBill(Token token) {
        Bill bill = billservice.getBill(token);

        return bill;
    }

}
