package Services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



import Models.Bill;
import Models.Payment;
import Models.Token;
import enums.SlotStatus;

public class BillService {

    @SuppressWarnings("deprecation")
    public Bill getBill(Token token) {
        Bill bill = new Bill();

        bill.setExitTime(new Date(2024, 01, 18));

        bill.setToken(token);
        bill.setGate(token.getGeneratedAt());

        bill.setOperator(token.getGeneratedBy());

        int amount = bill.calculate(token.getCreatedAt(), bill.getExitTime());

        bill.setAmount(amount);

        List<Payment> payments = new ArrayList<>() {
            {
                add(new Payment());
            }
        };
        bill.setPayments(payments);

        token.getAssignedSlot().setSlotStatus(SlotStatus.EMPTY);
        return bill;
    }
}
