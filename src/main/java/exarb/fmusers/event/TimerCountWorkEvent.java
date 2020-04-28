package exarb.fmusers.event;

import java.io.Serializable;

// TODO: Ta bort från user-service
public class TimerCountWorkEvent implements Serializable {

    private String timerCountSessionId;
    private String userId;

    public TimerCountWorkEvent(String timerCountSessionId, String userId) {
        this.timerCountSessionId = timerCountSessionId;
        this.userId = userId;
    }

    public TimerCountWorkEvent() {
    }

    public String getTimerCountSessionId() {
        return timerCountSessionId;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "TimerCountWorkEvent{" +
                "timerCountSessionId='" + timerCountSessionId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
