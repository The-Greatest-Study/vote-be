package tgs.vote.adapter.model.user;

public record LoginResponse(
        String accessToken,
        String refreshToken,
        String expiresIn,
        String tokenType,
        String scope,
        String userId,
        String teamId,
        String userName) {}
