package coffee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	private ArrayList<String> alName;
	private ArrayList<Integer> alPrice;
	private ArrayList<String>a;

////	static int a=1;
//	static void seta(int n) {
//		a=n;
//	}
//	static int geta() {
//		return a;
//	}
	// static final a=1; ->필드 수정불가
	Menu() {// 매개변수가 없는 생성자-> 기본생성자(default constructor)
		this.alName = new ArrayList<String>();
		this.alPrice = new ArrayList<Integer>();
		this.a=new ArrayList<String>();
		this.load();
//		this.addName("아메리카노"); = this.alName.add("아메리카노");
		/// 생성자에 초기값을 설정해서 실행할수 있음(설정에는 필드값을 줄수도 있고 메서드를 호출할수도 있음.
		// for(int i=0;i<alName.size();i++) {

//		System.out.println(this.alName.get(i)+"\t $"+this.alPrice.get(i)) = this.showMenu();
//	}	
		
	}/*
		 * 생성자 -용도 :주로 초기화 작업용. 명명법: 클래스와 이름이 같아야됨 반환값: 반환값이 없다.(반환할 수 없이 ,작업만 실행)
		 * 실행/호출:new연산자가 실행된 직후, 자동실행 다른 메소드를 호출할수 있다!!!!!!!!!!!!!
		 */
	// 생성자 오버로딩 <- 다형성 (매개변수를 다르게 해서 여러개의 생성자를 정의 할수있는 기능 )

	Menu(String a, int b) {
		this.alName = new ArrayList<String>();
		this.alPrice = new ArrayList<Integer>();
	}

	void addName(String name) {
		this.alName.add(name);
	}

	void addPrice(int price) {
		this.alPrice.add(price);
	}

	void addPrice(String price) {
		this.alPrice.add(Integer.parseInt(price));
	}
	ArrayList<Integer> totalprice() {
		return this.alPrice;
	}
	int size(){
		return this.alName.size();
	}
	
	int  vscount(String a) {
		if(Integer.parseInt(a)<=alName.size()) {
			return 1;
		}else {
			return 2;
		}
	}
	ArrayList<String> sname() {
		return this.alName;
	}
	String getName(String pick) {
		return this.alName.get(Integer.parseInt(pick)-1);
	}
	int getPrice(String pick) {
		return this.alPrice.get(Integer.parseInt(pick)-1);
	}
	
	void changeMenu() {
		System.out.println("수정할 메뉴번호");
		Scanner s1 = new Scanner(System.in);
		int num = s1.nextInt();
		if (num > alName.size() || num <= 0) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		System.out.println("새 메뉴명:");
		Scanner s2 = new Scanner(System.in);
		String name = s2.nextLine();
		if (name == null || name.equals("")) {
			System.out.println("메뉴명이 비어있습니다.");
			return;
		}
		System.out.println("가격:");
		int price = s1.nextInt();
		if (price < 0) {
			System.out.println("가격이 말아되나..");
			return;
		}
		this.alName.set(num - 1, name);
		this.alPrice.set(num - 1, price);
	}

	void appendMenu() {
		System.out.println("새 메뉴명:");
		Scanner s1 = new Scanner(System.in);
		String name = s1.nextLine();
		if (name == null || name.equals("")) {
			System.out.println("메뉴명이 비어있습니다.");
			return;
		}
		Scanner s2 = new Scanner(System.in);
		System.out.println("가격:");
		int price = s2.nextInt();
		if (price < 0) {
			System.out.println("가격이 말아되나..");
			return;
		}
		this.addName(name);
		this.addPrice(price);
	}

	void deleteMenu() {
		System.out.println("삭제할 메뉴 번호:");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		if (num > alName.size() || num <= 0) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		this.alName.remove(num - 1);
		this.alPrice.remove(num - 1);
		System.out.println("삭제 됬습니다.");
	}
	public void showMenu(ArrayList<Integer>w) {
		for (int i = 0; i < alName.size(); i++) {
			int a=this.alPrice.get(i)*w.get(i);
			System.out.println((i + 1) + ".\t" + this.alName.get(i) + "\t $" + this.alPrice.get(i)+"\t 누적"+w.get(i)+"잔 \t합계:"+a);
		}
	}
	
	public void showMenu() {

		for (int i = 0; i < alName.size(); i++) {

			System.out.println((i + 1) + ".\t" + this.alName.get(i) + "\t $" + this.alPrice.get(i));
		}
	}

	void save() { // arraylist alName,alPrice를 화일(menu.txt)에 저장
		File file = new File("c:/moon/menu.txt");
		if (file.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				for (int i = 0; i < this.alName.size(); i++) {
					String line = this.alName.get(i) + "," + this.alPrice.get(i);
					writer.write(line);
					if ((i + 1) != this.alName.size())
						writer.write("\r\n");
				}
				writer.flush();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void load() { // 화일(menu.txt)을 읽어서 arraylist alName,alprice에 로드.
		File file = new File("c:/moon/menu.txt");
		if (file.exists()) {
			BufferedReader inFile = null;
			try {
				inFile = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			String line;
			try {
				line = inFile.readLine();
				while (line != null) {
					String[] parts = line.split(",");
					addName(parts[0]);
					addPrice(parts[1]);
					line = inFile.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

