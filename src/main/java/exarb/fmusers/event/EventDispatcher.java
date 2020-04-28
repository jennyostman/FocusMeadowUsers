package exarb.fmusers.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;

    private String timerCountExchange;
    private String timerCountWorkRoutingKey;

    @Autowired
    EventDispatcher(final RabbitTemplate rabbitTemplate,
                    @Value("${timerCount.exchange}") final String timerCountExchange,
                    @Value("${timerCount.work.key}") final String timerCountWorkRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.timerCountExchange = timerCountExchange;
        this.timerCountWorkRoutingKey = timerCountWorkRoutingKey;
    }

    public void send(final TimerCountWorkEvent timerCountWorkEvent) {
        rabbitTemplate.convertAndSend(
                timerCountExchange,
                timerCountWorkRoutingKey,
                timerCountWorkEvent);
    }
}
