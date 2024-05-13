package DTO;

import enums.VehicleType;

public class IssusTokenRequestDTO {

    private String vehicleNumber;

    private Long gateId;

    private VehicleType vehicleType;

    private String ownerName;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public IssusTokenRequestDTO setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        return this;
    }

    public Long getGateId() {
        return gateId;
    }

    public IssusTokenRequestDTO setGateId(Long gateId) {
        this.gateId = gateId;
        return this;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public IssusTokenRequestDTO setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
        return this;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public IssusTokenRequestDTO setOwnerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

}
