package teach.cycle;

import java.util.Scanner;

public class CycleExampleFirst {

	public static void main(String[] args) {
		//doExample1();
		//doExample2(2000, 2008, 0);
		//aboutNumPlusPlus();
		//doExample3();
		//doExample4();
		//doExample5();
		doExample6();
	}

	/**
	 * i++ ��ʹ��i  �ٽ��м�1
	 * ++i ʹ�÷����෴
	 */
	private static void aboutNumPlusPlus() {
		// TODO Auto-generated method stub
		int i = 10;
		int num = 99 % 10;
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(num);
		
		while (i <= 15 ) {
			i++;
		}
	}

	/**
	 * 1.Ҫ���û�����һ��0��2֮���������**[����ѭ������]**
		����û�����0������������ʯͷ����
		����û�����1�������������Ǽ�������
		����û��������2�������������ǲ�����
		Ȼ�������Ƿ�Ҫ������ȭ��
		����ش�y�����ظ����Ϲ��̣�
		�����������
	 */
	public static void doExample1() {
		// ����̨�������
		Scanner sc = new Scanner(System.in);
		// initFlag ����whileѭ����ʶ  true����  false������
		boolean initFlag = true;
		
		// initFlag Ĭ��Ϊtrue����ѭ��
		while(initFlag) {
			// ��ӡ���
			System.out.println("����һ��0��2֮�������");
			// sc.next()[Type:String] ���Կ���̨�����������
			String inputVal = sc.next();
			
			// �ж�inputVal����ֵΪnull ��� ���½���˷��� **[����˼��,����̨�����޷�����ո�]**
			// inputVal.trim() ȥ�������ַ����Ŀո�
			if (inputVal == null || inputVal.trim().equals("")) {
				System.out.println("Please again input");
				// ���½���˷���
				doExample1();
				break;
			}
			
			if (inputVal.equals("0")) {
				System.out.println("�������ʯͷ");
			} else if (inputVal.equals("1")) {
				System.out.println("������Ǽ���");
			} else if (inputVal.equals("2")) {
				System.out.println("������ǲ�");
			} else if (inputVal.toLowerCase().equals("y")) {
				System.out.println("Exit");
				initFlag = false;
				break;
			} else {
				;
			}
		}
	}
	
	/**2.����2000��1��1�յ�2008��1��1���������졣��ע�����꣩
	 * 
	 */
	public static void doExample2(int startYear, int endYear, int sumDays) {
		// ��������
		int doubleDays = 366;
		// ƽ������
		int singleDays = 365;
		// ��ǰ���
		int year = startYear;
		
		// ��Ԫ���ʽ �жϵ�ǰ����Ƿ���ڽ������
		boolean flag = startYear == endYear ? true : false;
		
		// �������
		if((year%4==0&&year%100!=0)||year%400==0) {
			sumDays = sumDays + doubleDays;
		} else {
			sumDays = sumDays + singleDays;
		}
		
		if (!flag) {
			++startYear;
			doExample2(startYear, endYear, sumDays);
		} else {
			System.out.println("�������:" + sumDays);
		}
	}
	
	/**
	 * ����10000Ԫ�������У���������ǧ��֮����ÿ��1�꣬���������Ϣ�����Ϊ�µı�
	 * �𡣼���5��󣬻�õı����Ƕ��٣�
	 */
	public static void doExample3() {
		// ����
		double capital = 10000;
		// ������
		double precentNums = 0.003;
		int year = 5;
		
		for (int i = 0; i < year; i++) {
			// �������Ϣ�����Ϊ�µı���
			capital = capital * precentNums + capital;
		}
		
		System.out.println("����󱾽�:" + capital);
	}
	
	/**
	 * ������1~100���ۼ�ֵ����Ҫ���������и�λΪ3������
	 */
	public static void doExample4() {
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			// ȡ�����õ���λ
			boolean geWeiFlag = (i >= 10) && ((i % 10) == 3) ? false : true;
			
			if (geWeiFlag) {
				sum = sum + i;
				System.out.println("�ۼ���ֵ:" + i);
				System.out.println("�ۼ�ֵ:" + sum);
			} else {
				System.out.println("��������ֵ:" + i);
				continue;
			}
			
		}
	}
	
	/**
	 * ��ӡ��100~999֮������С�ˮ�ɻ���������ν��ˮ�ɻ���������ָһ��3λ�������λ���������͵��ڸ�������
	 * ���磺153��һ����ˮ�ɻ���������Ϊ153=13+53+33��
	 */
	public static void doExample5() {
		int startNum = 100;
		int endNum = 999;
		
		while(startNum <= endNum) {
			int baiWei = startNum / 100;
			int shiWei = (startNum % 100) / 10;
			int geWei = (startNum % 100) % 10;
			
			boolean flag = (((baiWei * baiWei * baiWei) + (shiWei * shiWei * shiWei)
					+ (geWei * geWei * geWei)) == startNum) ? true : false;
			
			if (flag) {
				System.out.println("ˮ�ɻ���:" + startNum);
			}
			
			startNum ++;
		}
	}
	
	/**
	 * ��һ�������е�Ԫ�ص��Ź����������¿�һ���������ʱ�洢�ռ䣬ֻ����ԭ�����ϸ�
	 */
	public static void doExample6() {
		// String[] arr = new String[10];
		int[] arr = {1, 2, 3, 4, 5};
		int temporaryVariable;
		
		// forѭ��
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					temporaryVariable = arr[i];
					arr[i] = arr[j];
					arr[j] = temporaryVariable;
				}
			}
		}
		
		// ��ǿforѭ��
		for (int val : arr) {
			System.out.print(val + ", ");
		}
	}
}
