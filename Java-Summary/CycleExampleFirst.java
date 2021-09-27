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
	 * i++ 先使用i  再进行加1
	 * ++i 使用方法相反
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
	 * 1.要求用户输入一个0到2之间的整数，**[三种循环答题]**
		如果用户输入0输出“你出的是石头”，
		如果用户输入1就输出“你出的是剪刀”，
		如果用户输入的是2就输出“你出的是布”，
		然后再问是否要继续出拳，
		如果回答“y”就重复以上过程，
		否则结束程序。
	 */
	public static void doExample1() {
		// 控制台输入代码
		Scanner sc = new Scanner(System.in);
		// initFlag 进入while循环标识  true进入  false不进入
		boolean initFlag = true;
		
		// initFlag 默认为true进入循环
		while(initFlag) {
			// 打印语句
			System.out.println("输入一个0到2之间的整数");
			// sc.next()[Type:String] 可以控制台输入参数类型
			String inputVal = sc.next();
			
			// 判断inputVal输入值为null 或空 重新进入此方法 **[常规思想,控制台输入无法输入空格]**
			// inputVal.trim() 去掉输入字符串的空格
			if (inputVal == null || inputVal.trim().equals("")) {
				System.out.println("Please again input");
				// 重新进入此方法
				doExample1();
				break;
			}
			
			if (inputVal.equals("0")) {
				System.out.println("你出的是石头");
			} else if (inputVal.equals("1")) {
				System.out.println("你出的是剪刀");
			} else if (inputVal.equals("2")) {
				System.out.println("你出的是布");
			} else if (inputVal.toLowerCase().equals("y")) {
				System.out.println("Exit");
				initFlag = false;
				break;
			} else {
				;
			}
		}
	}
	
	/**2.计算2000年1月1日到2008年1月1日相距多少天。（注意闰年）
	 * 
	 */
	public static void doExample2(int startYear, int endYear, int sumDays) {
		// 闰年天数
		int doubleDays = 366;
		// 平年天数
		int singleDays = 365;
		// 当前年份
		int year = startYear;
		
		// 三元表达式 判断当前年份是否等于结束年份
		boolean flag = startYear == endYear ? true : false;
		
		// 闰年计算
		if((year%4==0&&year%100!=0)||year%400==0) {
			sumDays = sumDays + doubleDays;
		} else {
			sumDays = sumDays + singleDays;
		}
		
		if (!flag) {
			++startYear;
			doExample2(startYear, endYear, sumDays);
		} else {
			System.out.println("相距天数:" + sumDays);
		}
	}
	
	/**
	 * 本金10000元存入银行，年利率是千分之三。每过1年，将本金和利息相加作为新的本
	 * 金。计算5年后，获得的本金是多少？
	 */
	public static void doExample3() {
		// 本金
		double capital = 10000;
		// 年利率
		double precentNums = 0.003;
		int year = 5;
		
		for (int i = 0; i < year; i++) {
			// 本金和利息相加作为新的本金
			capital = capital * precentNums + capital;
		}
		
		System.out.println("五年后本金:" + capital);
	}
	
	/**
	 * 求整数1~100的累加值，但要求跳过所有个位为3的数。
	 */
	public static void doExample4() {
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			// 取余数拿到个位
			boolean geWeiFlag = (i >= 10) && ((i % 10) == 3) ? false : true;
			
			if (geWeiFlag) {
				sum = sum + i;
				System.out.println("累加数值:" + i);
				System.out.println("累加值:" + sum);
			} else {
				System.out.println("跳过的数值:" + i);
				continue;
			}
			
		}
	}
	
	/**
	 * 打印出100~999之间的所有“水仙花数”。所谓“水仙花数”，是指一个3位数，其各位数字立方和等于该数本身。
	 * 例如：153是一个“水仙花数”，因为153=13+53+33。
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
				System.out.println("水仙花数:" + startNum);
			}
			
			startNum ++;
		}
	}
	
	/**
	 * 将一个数组中的元素倒排过来，不能新开一个数组的临时存储空间，只能在原数组上改
	 */
	public static void doExample6() {
		// String[] arr = new String[10];
		int[] arr = {1, 2, 3, 4, 5};
		int temporaryVariable;
		
		// for循环
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					temporaryVariable = arr[i];
					arr[i] = arr[j];
					arr[j] = temporaryVariable;
				}
			}
		}
		
		// 增强for循环
		for (int val : arr) {
			System.out.print(val + ", ");
		}
	}
}
