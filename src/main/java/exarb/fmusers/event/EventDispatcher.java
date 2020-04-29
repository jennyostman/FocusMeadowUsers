package exarb.fmusers.event;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventDispatcher {

    private RabbitTemplate rabbitTemplate;

    private String userExchange;
    private String userLoggedInRoutingKey;

    @Autowired
    EventDispatcher(final RabbitTemplate rabbitTemplate,
                    @Value("${user.exchange}") final String userExchange,
                    @Value("${user.logedin.key}") final String userLoggedInRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.userExchange = userExchange;
        this.userLoggedInRoutingKey = userLoggedInRoutingKey;
    }

    // TODO: Lägg till param i javadocs
    /**
     * Converts and sends the UserLoggedInEvent
     * @param
     */
    public void send(final UserLoggedInEvent userLoggedInEvent) {
        rabbitTemplate.convertAndSend(
                userExchange,
                userLoggedInRoutingKey,
                userLoggedInEvent);
    }
}
