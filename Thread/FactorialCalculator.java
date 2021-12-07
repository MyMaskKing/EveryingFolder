package test;

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {
    private int number;

    public FactorialCalculator(int number) {
        this.number = number;
    }

    //����׳�
    public Integer call() throws Exception {
        Integer result = 1;
        if (number == 0 || number == 1)
            result = 1;
        else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                //Ϊ����ʾЧ��������20ms
                Thread.sleep(20);
            }
        }
        System.out.printf("�߳�:%s," + number + "!= %d\n", Thread.currentThread().getName(), result);
        return result;
    }

}
