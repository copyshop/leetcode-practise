package design.listener;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc:
 */
public class Kid {

    private String name;
    private List<Listener> listenerList;

    public Kid(String name) {
        this.name = name;
        this.listenerList = Lists.newLinkedList();
    }

    public void eat() {
        for (Listener listener : listenerList) {
            if (listener instanceof WashingHandsListener) {
                WashingHandsListener washingHandsListener = (WashingHandsListener) listener;
                washingHandsListener.fireAfterEventInvoked(new WashingHandsEvent(this, "洗手"));
            }
        }
        System.out.println("吃饭...");
    }

    public void addListener(Listener listener) {
        listenerList.add(listener);
    }
}
