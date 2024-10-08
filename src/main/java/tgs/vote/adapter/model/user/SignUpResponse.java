package tgs.vote.adapter.model.user;

public record SignUpResponse( // TODO: 프론트에서 필요한 값과 맞춰서 수정
        String accessToken,
        int expiresIn,
        String tokenType,
        String userId,
        String teamId,
        String userName,
        String email,
        String profileImageUrl) {}
