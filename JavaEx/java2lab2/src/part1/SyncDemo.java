package part1;

public class SyncDemo {
    public static void main(String[] args) {
        final Counter ct = new Counter();
        //Create new runnable object t1,
        //therefore t1 is a thread is using Counter object ct
        /*
        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                ct.count();
            }
        };
        */

        //Create new runnable object t1,
        //Therefore t2 í a thread using Counter object vt.
        //Both t1 and t2 are using ct at the same time,
        //so ct is called shared-recourse
        /*
        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                ct.countdown();
            }
        };


        new Thread(t1).start();
        new Thread(t2).start();
        */
        synchronized(ct) {
            ct.count();
        }
        synchronized(ct) {
            ct.countdown();
        }

    }
}
