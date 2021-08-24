package coffee;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {
	private ArrayList<String>alMobile;
	private ArrayList<String>alMenu;
	private ArrayList<Integer>alCount;
	private ArrayList<Integer>alTotal;
	private ArrayList<Integer>als;
	
	Order(){
		this.alMobile=new ArrayList<String>();
		this.alMenu=new ArrayList<String>();
		this.alCount=new ArrayList<Integer>();
		this.alTotal=new ArrayList<Integer>();
		this.als=new ArrayList<Integer>();
		
	}
	Order(int size){
		this.alMobile=new ArrayList<String>();
		this.alMenu=new ArrayList<String>();
		this.alCount=new ArrayList<Integer>();
		this.alTotal=new ArrayList<Integer>();
		this.als=new ArrayList<Integer>();
		for(int i=0;i<size;i++) {
			this.als.add(i,0);
		}
	}
	
	void addOrder(String menuName, int count, int totalPrice) {
		this.alMenu.add(menuName);//주문 메뉴명 추가
		this.alCount.add(count);//주무수량 추가
		this.alTotal.add(totalPrice);//합계 +추가 반환
		
	}
	
	ArrayList<Integer> scount() {
		return this.als;
	}
	void counting(String pick,int size,int count) {
//		for(int i=0;i<size;i++) {
//			this.als.add(i,0);
//		}
		int b=this.als.get(Integer.parseInt(pick)-1);
		this.als.set(Integer.parseInt(pick)-1, b+count);
	}
	int addOrder(String menuName,int menuPrice) {
		Scanner c=new Scanner(System.in);
		System.out.println(menuName);
		System.out.println("수량을 입력세요:");
		int count = c.nextInt();
		int totalPrice = menuPrice * count;
		this.alMenu.add(menuName);//주문 메뉴명 추가
		this.alCount.add(count);//주무수량 추가
		this.alTotal.add(totalPrice);//합계 +추가 반환
		System.out.println(menuName + "," + count + "잔" + totalPrice);
		
		
		return totalPrice;
	}
	
	int getTotalSum(int a) {
		//주문 리스트의 총액을 모두 더해서 합계를 반환
		int sum=0;
		for(int i=0;i<this.alTotal.size();i++) {
			sum=sum+this.alTotal.get(i);
		}
		return sum;
	}
	void addMobile(String check) {
		Scanner s=new Scanner(System.in);
		if(check.equals("y")) {
			System.out.print("모바일 번호를 입력하세요:");	
			String mobile=s.nextLine();
			this.alMobile.add(mobile);
			System.out.println(mobile + "번호로 적립되었습니다.");
		}else {
			System.out.println("적립은 생략됩니다.");
		}
		System.out.println("주문 종료.계산 gogo");
	}
	void s() {
		int sum=0;
		for(int i=0;i<alMenu.size();i++) {
			System.out.println(this.alMenu.get(i)+","+this.alCount.get(i)+","+this.alTotal.get(i));
			sum=sum+this.alTotal.get(i);
		}
		System.out.println(sum);
	}
	
	
	
}
