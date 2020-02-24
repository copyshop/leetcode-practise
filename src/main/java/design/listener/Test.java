package design.listener;

/**
 * @author: yin.he
 * @date: 2019-09-17
 * @desc: 监听器模式
 */
public class Test {

    public static void main(String[] args) {
        Kid kid = new Kid("xiaoming");
        kid.addListener(new WashingHandsListener());
        kid.eat();
    }
}
