package Repositories;

import java.util.HashMap;
import java.util.Map;

import Models.Gate;

public class GateRepository {

    private Map<Long, Gate> gates = new HashMap<>();

    private Long previousId = 0L;

    public Gate findGateById(Long gateId) {
        if (gates.containsKey(gateId))

        {
            return gates.get(gateId);
        }
        return null;

    }

    public Gate saveGate(Gate gate) {
        previousId += 1;
        gate.setId(previousId);

        gates.put(previousId, gate);
        return gate;
    }

}
