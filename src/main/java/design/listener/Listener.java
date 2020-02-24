package design.listener;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public interface Listener extends java.util.EventListener {
    
    void fireAfterEventInvoked(Event event);
}
