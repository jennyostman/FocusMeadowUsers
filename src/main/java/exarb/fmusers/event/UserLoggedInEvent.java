package exarb.fmusers.event;

import java.io.Serializable;

/**
 * This is a model for an event that is sent when a user stayed focused the whole time.
 */
public class UserLoggedInEvent implements Serializable {

    private Long userId;

    public UserLoggedInEvent(Long userId) {
        this.userId = userId;
    }

    public UserLoggedInEvent() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
