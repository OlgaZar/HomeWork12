package HW12Project;

import java.util.concurrent.*;

public class Task1 {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        class ThreadNumber1 extends Thread {

            int time;

            @Override
            public void run() {
                time++;
              try {
                    queue.put("Attention "+time+" seconds has passed");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Time from start "+time);
            }
        }
        class ThreadNumber2 extends Thread {

            @Override
            public void run() {
                System.out.println("5 seconds has passed");
                while(!queue.isEmpty()) {
                    System.out.println(queue.poll());}

            }
        }


        ThreadNumber1 thread1 = new ThreadNumber1();
        ThreadNumber2 thread2 = new ThreadNumber2();


        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(thread1, 1, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(thread2, 5, 5, TimeUnit.SECONDS);

        try {
            Thread.sleep(21000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();

    }
    }

