package maze;

import java.awt.EventQueue;

class Test {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ActionFrame();
            }
        });
    }
}