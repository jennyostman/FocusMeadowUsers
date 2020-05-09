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
                    @Value("${user.loggedin.key}") final String userLoggedInRoutingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.userExchange = userExchange;
        this.userLoggedInRoutingKey = userLoggedInRoutingKey;
    }


    /**
     * Converts and sends the UserRegisteredEvent
     * @param userRegisteredEvent event message object for a registered user
     */
    public void send(final UserRegisteredEvent userRegisteredEvent) {
        System.out.println("event konverteras");
        rabbitTemplate.convertAndSend(
                userExchange,
                userLoggedInRoutingKey,
                userRegisteredEvent);
    }
}
