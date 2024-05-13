package Models;

import java.util.ArrayList;
import java.util.List;

import enums.SlotStatus;
import enums.VehicleType;

public class ParkingSlot extends BaseModel {

    private String number;

    private SlotStatus slotStatus;

    private List<VehicleType> supportedVehicleTypes;

    public ParkingSlot(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
        supportedVehicleTypes = new ArrayList<>();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public void setSupportedVehicleTypes(VehicleType bicycle) {
        this.supportedVehicleTypes.add(bicycle);
    }

}
