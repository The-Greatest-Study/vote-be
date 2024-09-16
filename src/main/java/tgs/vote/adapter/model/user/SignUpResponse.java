package tgs.vote.adapter.model.user;

public record SignUpResponse(
        String accessToken,
        int expiresIn,
        String tokenType,
        String userId,
        String teamId,
        String userName,
        String email,
        String profileImageUrl) {

}
