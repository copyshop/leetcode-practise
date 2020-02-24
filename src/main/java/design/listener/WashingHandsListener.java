package design.listener;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public class WashingHandsListener implements Listener {

    @Override
    public void fireAfterEventInvoked(Event event) {
        WashingHandsEvent washingHandsEvent = (WashingHandsEvent) event;
        System.out.println("饭前准备" + washingHandsEvent.getEventName());
    }
}
