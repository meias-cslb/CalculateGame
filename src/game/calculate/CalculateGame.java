package game.calculate;

import java.util.Random;
import java.util.Scanner;

public class CalculateGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("開始します。Enterキーを押してください。");
		scanner.nextLine();
		start(scanner);


		scanner.close();
	}

		/**
		 * 問題表示、正解か不正解か表示、正解数・入力時間を計算
		 */
	public static void start(Scanner scanner) {

//		タイムを定義
		int time = 0;
//		正解数を定義
		int correct = 0;


		for(int i = 0; i < 10; i++) {
			int a = getRandomNumber();
			int b = getRandomNumber();


			System.out.print("(" + (i + 1) + ")" + a + " ＋ " + b + " ＝ " );

//			入力開始時間を取得
			long startTime = System.currentTimeMillis();

			String answer = scanner.next();


//			入力値が数字でない場合、もう一度入力を何度も要請
			while(!checkNumber(answer)) {
				System.out.println("もう1度数字を入力してください。");
				System.out.println("");
				System.out.print("(" + (i + 1) + ")" + a + " ＋ " + b + " ＝ " );
				answer = scanner.next();
			}


//			入力値が数字の場合、正答を判定
//			if(checkNumber(answer)) {
				int intAnswer = Integer.parseInt(answer);
				if(intAnswer == a + b) {
					System.out.println("正解！(^ω^)ノ");
					correct++;
				} else {
					System.out.println("不正解！(-ω-)");
				}
//			}

//			終了時間を取得
			long endTime = System.currentTimeMillis();
//			入力時間を計算しtimeに足す
			time += endTime - startTime;

			System.out.println("");
			System.out.println("-------------------------------");
			System.out.println("");
		}


//		経過時間を定義
		double second = (double)time / 1000.0;

//		結果を表示
		showResult(second,correct);
	}

	/**
	 * 1～9の乱数を取得
	 * @return 乱数(1～9)
	 */
	public static int getRandomNumber() {
		int number = new Random().nextInt(9) + 1;
		return number;
	}

	/**
	 * 文字列が数字かどうかを判断
	 * @param line 入力された文字列
	 * @return true or false
	 */
	public static boolean checkNumber(String line) {
		boolean result = true;

		if(line.length() > 0) {
			for(int i = 0; i < line.length(); i++) {
				if(Character.isDigit(line.charAt(i))) {
					continue;
				} else {
					result = false;
					break;
				}
			}
		}

		return result;
	}

	/**
	 * タイムと正解数の結果と、そこから導き出される脳年齢を表示する
	 * @param second タイム(秒）
	 * @param correct 正解数
	 */
	public static void showResult(double second, int correct) {
		double normalizedTime = second + 3.0 * (double)(10-correct);
		String age = "";
		if(normalizedTime < 18.0) {
			age = "10代";
		} else if(normalizedTime < 20.0) {
			age = "20代";
		} else if(normalizedTime < 25.0) {
			age = "30代";
		} else if(normalizedTime < 30.0) {
			age = "40代";
		} else if(normalizedTime < 35.0) {
			age = "50代";
		} else {
			age = "60代";
		}

		System.out.println("正解数：" + correct);
		System.out.println("タイム：" + second + "秒");
		System.out.println("あなたの脳年齢は" + age + "です。");
	}


}
