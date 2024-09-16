package tgs.vote.application;

import org.springframework.stereotype.Service;
import tgs.vote.application.model.session.UserSession;

@Service
public class SessionService {
    // TODO session 처리에 대해서 아직 미지수
    public static UserSession getUserSession() {
        // TODO static method가 맞을까요?
        return UserSession.getDefault();
    }

    public static long getUserIdFromSession() {
        UserSession userSession = getUserSession();
        return userSession.getUserId();
    }
}
