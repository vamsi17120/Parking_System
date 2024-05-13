package Repositories;

import java.util.HashMap;
import java.util.Map;

import Models.Token;

public class TokenRepository {

    private Map<Long, Token> tokens = new HashMap<>();

    private Long previousId = 0L;

    public TokenRepository() {
        tokens = new HashMap<>();

    }

    public Token save(Token token) {
        previousId += 1;
        token.setId(previousId);
        tokens.put(previousId, token);
        return token;
    }

    public Token getToken(Long id) {
        if (tokens.containsKey(id)) {
            return tokens.get(id);
        }
        return null;
    }

}
