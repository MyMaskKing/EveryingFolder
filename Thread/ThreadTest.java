package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadTest {
	public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);//����ֻ��2���̵߳��̳߳�
        //��Ž�����б�
        List<Future<Integer>> resultList = new ArrayList<>();
        //ͨ��Random������һ�������������
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(10);
            FactorialCalculator calculator = new FactorialCalculator(number);
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }
        //����һ��ѭ�������ִ������״̬
        try {
            while (executor.getCompletedTaskCount() < resultList.size()) {
                System.out.printf("\n����ɵ��߳�����: %d\n", executor.getCompletedTaskCount());
                for (int i = 0; i < resultList.size(); i++) {
                    Future<Integer> result = resultList.get(i);
                    System.out.printf("�� %d ���߳� : �Ƿ����:%s\n", i, result.isDone());
                }
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("ȫ���߳�ִ�н���");
        try {
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                Integer number = null;
                number = result.get();
                System.out.printf("�� %d ���߳� ִ�н����: %d\n", i, number);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {	
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executor.shutdown();
        Long endTime = System.currentTimeMillis();
        System.out.println("ʹ��ʱ�� = [" + (endTime - startTime) + "]");
    }
}
