package Controllers;

import DTO.IssueTokenResponseDTO;
import DTO.IssusTokenRequestDTO;
import Models.Token;
import Services.TokenService;
import enums.RequestStatus;

public class TokenController {

    private TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    public IssueTokenResponseDTO issueToken(IssusTokenRequestDTO issusTokenRequestDTO) {
        IssueTokenResponseDTO responseDTO = new IssueTokenResponseDTO();
        try {

            Token token = tokenService.issueToken(issusTokenRequestDTO.getGateId(),
                    issusTokenRequestDTO.getVehicleType(), issusTokenRequestDTO.getVehicleNumber(),
                    issusTokenRequestDTO.getOwnerName());

            responseDTO.setToken(token);
            responseDTO.setRequestStatus(RequestStatus.SUCCESS);
        } catch (Exception E) {
            responseDTO.setRequestStatus(RequestStatus.FAILURE);
            responseDTO.setFailureMessage(E.getMessage());
        }

        return responseDTO;
    }
}
