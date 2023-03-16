package com.fly;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @author <a href="mailto:fteng1024@gmail.com"> tengfei
 * @since 1.0.0 2023/3/15
 */
public class JedisDemo {
    private static int COMMAND_NUM = 100000;

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.auth("tengfei");
        withoutPipeline(jedis);
        withPipeline(jedis);
    }

    private static void withoutPipeline(Jedis jedis) {
        Long start = System.currentTimeMillis();
        for (int i = 0; i < COMMAND_NUM; i++) {
            jedis.set("no_pipe_" + i, String.valueOf(i), SetParams.setParams().ex(60));
        }
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("withoutPipeline cost : " + cost + " ms");
    }

    private static void withPipeline(Jedis jedis) {
        Pipeline pipe = jedis.pipelined();
        long start = System.currentTimeMillis();
        for (int i = 0; i < COMMAND_NUM; i++) {
            pipe.set("pipe_" + i, String.valueOf(i), SetParams.setParams().ex(60));
        }
        pipe.sync(); // 获取所有的response
        long end = System.currentTimeMillis();
        long execTime = end - start;
        System.out.println("withPipeline cost : " + execTime + " ms");
    }

    /*private static void withForkJoinPipeline(Jedis jedis) {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        List<Integer> list = new ArrayList<>(100500);
        for (int i = 0; i < COMMAND_NUM; i++) {
            list.add(i);
        }
        RedisInitTask redisInitTask = new RedisInitTask(list, jedis);
//        Future<Long> future = commonPool.submit(redisInitTask);
        long execTime = commonPool.invoke(redisInitTask);
//        System.out.println("计算出来的总和="+future.get());
//        long result = redisInitTask.join();
        System.out.println("withForkJoinPipeline exec :" + execTime);
    }*/

    /*static class RedisInitTask extends RecursiveTask<Long> {
        private final Jedis jedis;
        private final List<Integer> list;

        private final Integer BATCH_NUM = 10000;

        public RedisInitTask(List<Integer> list, Jedis jedis) {
            this.list = list;
            this.jedis = jedis;
        }

        @Override
        protected Long compute() {
            if (list.size() > BATCH_NUM) {
                return ForkJoinTask.invokeAll(createSubtasks()).stream().mapToLong(ForkJoinTask::join).sum();
            } else {
                return processing(list);
            }
        }

        private List<RedisInitTask> createSubtasks() {

            List<RedisInitTask> dividedTasks = new ArrayList<>();
            int divideSize = list.size() / 2;
            dividedTasks.add(new RedisInitTask(
                    list.subList(0, divideSize), jedis));
            dividedTasks.add(new RedisInitTask(
                    list.subList(divideSize + 1, list.size()), jedis));
            return dividedTasks;
        }

        private Long processing(List<Integer> arrays) {
            long start = System.currentTimeMillis();
            Pipeline pipe = jedis.pipelined();
            arrays.forEach(i -> pipe.set("fork_join_pipe" + i, String.valueOf(i), SetParams.setParams().ex(60)));
            pipe.sync();
            long end = System.currentTimeMillis();
            return end - start;
        }
    }*/
}
