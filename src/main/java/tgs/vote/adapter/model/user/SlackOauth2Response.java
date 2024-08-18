package tgs.vote.adapter.model.user;

public record SlackOauth2Response(
        boolean ok,
        String accessToken,
        String tokenType,
        String scope,
        String botUserId,
        String appId,
        Team team,
        Enterprise enterprise,
        AuthedUser authedUser) {
    public record Team(String name, String id) {}

    public record Enterprise(String name, String id) {}

    public record AuthedUser(String id, String scope, String accessToken, String tokenType) {}
}
