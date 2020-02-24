package design.listener;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public class WashingHandsEvent extends Event {

    private String eventName;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public WashingHandsEvent(Object source, String eventName) {
        super(source);
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
