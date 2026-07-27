import java.util.concurrent.Semaphore;

class DiningPhilosophers {

    private final Semaphore maxEat = new Semaphore(4);
    private final Object[] forks = new Object[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Object();
        }
    }

   
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

       
        maxEat.acquire();

      
        synchronized (forks[leftFork]) {
            synchronized (forks[rightFork]) {
                
                pickLeftFork.run();
                pickRightFork.run();
                eat.run();
                putLeftFork.run();
                putRightFork.run();

            }
        }

        maxEat.release();
    }
}
