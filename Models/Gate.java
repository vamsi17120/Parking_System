package Models;

import enums.GateStatus;
import enums.GateType;

public class Gate extends BaseModel {

    private GateType gateType;

    private Operator operator;

    private int gateNumber;

    private GateStatus gateStatus;

    private ParkingLot ParkingLot;

    public ParkingLot getParkingLot() {
        return ParkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        ParkingLot = parkingLot;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Gate() {
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

}
