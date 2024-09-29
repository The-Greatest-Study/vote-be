package tgs.vote.adapter.out;

import tgs.vote.application.model.session.UserSession;
import tgs.vote.application.out.SessionPort;

public class SessionAdapter implements SessionPort {

    @Override
    public UserSession getUserSession() {
        return UserSession.getDefault();
    }

    @Override
    public long getUserIdFromSession() {
        UserSession userSession = this.getUserSession();
        return userSession.getUserId();
    }
}
