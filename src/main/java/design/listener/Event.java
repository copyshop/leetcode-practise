package design.listener;

import java.util.EventObject;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public class Event extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public Event(Object source) {
        super(source);
    }
}
