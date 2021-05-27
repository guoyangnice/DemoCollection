package thread.threadpool;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * 模拟加载楼层数据服务
 *
 * @author yangjie
 */
public class ThreadPoolDemo {

    public static ArrayList<String> threadPoolRun() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 1L,
                TimeUnit.MINUTES, new LinkedBlockingDeque<>(12), new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "t_pl_pool_" + r.hashCode());
            }
        }, new ThreadPoolExecutor.AbortPolicy());

        ArrayList<Future<Boolean>> list = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            Future<Boolean> future = executor.submit(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    System.out.println("start task " + finalI);
                    try {
                        result.add(String.valueOf(finalI));
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("end task " + finalI);
                    return true;
                }
            });
            list.add(future);
        }
        for(Future<Boolean> futures : list){
            futures.get();
        }

        executor.shutdown();
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<String> result = threadPoolRun();
        result.stream().forEach(System.out::println);
    }

}
