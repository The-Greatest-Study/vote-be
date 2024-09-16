package tgs.vote.application.out;

import tgs.vote.application.model.session.UserSession;

public interface SessionPort {

    UserSession getUserSession();
    long getUserIdFromSession();
}
