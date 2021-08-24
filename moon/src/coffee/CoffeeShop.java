package coffee;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeShop {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Scanner s = new Scanner(System.in);
		Scanner c = new Scanner(System.in);
		int size=0;//s-사이즈 구하기 변수
		//추가
		size=menu.size();
		Order order = new Order(size);
		System.out.println("작업을 선택하시오 (m:메뉴관리,o:주문,s:실적보기,x:프로그램 종료) ");
		String input = s.nextLine();
		while (!input.equals("x")) {// input.isEmpty()
			
			switch (input) {
			case "m":
				System.out.println("메뉴관리");
				menu.showMenu();
				// CRUD (추가/수정/삭제)
				System.out.println("메뉴작업을 선택하시오. (c:추가,r:목록보기,u:수정,d:삭제,q:메뉴관리 종료)");
				input = s.nextLine();
				while (!input.equals("q")) {
					switch (input) {
					case "c":
						menu.appendMenu();
						break;
					case "r":
						menu.showMenu();
						break;
					case "u":
						menu.changeMenu();
						break;
					case "d":
						menu.deleteMenu();
					}
					System.out.println("메뉴작업을 선택하시오. (c:추가,r:목록보기,u:수정,d:삭제,q:메뉴관리 종료)");
					input = s.nextLine();
					menu.save();
				}
				break;
			case "o":
				System.out.println("주문");
				menu.showMenu();
				//Order order = new Order();
				System.out.print("메뉴 번호를 선택하세요:");
				String pick = s.nextLine();
				//추가
				//size=menu.size();
				//추가Order order = new Order(size);
				int su = 0;
				while (!pick.equals("")) {
					if(menu.vscount(pick)==1) {
						String menuName = menu.getName(pick);
						System.out.println(menuName);
						System.out.println("수량을 입력세요:");
						int count = c.nextInt();
						int menuPrice = menu.getPrice(pick);
						int totalPrice = menuPrice * count;
						order.addOrder(menuName, count, totalPrice);
						menu.showMenu();
						System.out.println(menuName + "," + count + "잔" + totalPrice);
						//실적추가
						//size=menu.size();
						order.counting(pick, size, count);
						//
						System.out.print("메뉴 번호를 선택하세요:");
						pick = s.nextLine();
						su=su+1;
						
					}else if(menu.vscount(pick)==2) {
						System.out.println("잘못된 주문 번호입니다.다시입력해주세요.");
						System.out.print("메뉴 번호를 선택하세요:");
						pick = s.nextLine();
						continue;
					}
//					System.out.println(menuName);
//					System.out.println("수량을 입력세요:");
//					int count = c.nextInt();
//					int menuPrice = menu.getPrice(in);
//					int totalPrice = menuPrice * count;
//					order.addOrder(menuName, count, totalPrice);
//					menu.showMenu();
//					System.out.println(menuName + "," + count + "잔" + totalPrice);
//					System.out.print("메뉴 번호를 선택하세요:");
//					in = s.nextLine();
//					su=su+1;
				}
				//System.out.println(su);
				int totals = order.getTotalSum(su);
				System.out.println("총 금액:" + totals);

				System.out.print("적립하시겠습니까?y/n:");
				String check = s.nextLine();
				order.addMobile(check);

				// 실적에 추가
				
				break;
			case "s":
				System.out.println("실적보기");
//				ArrayList<Integer>e=menu.totalprice();
//				ArrayList<String> q=menu.sname();
				ArrayList<Integer>w=order.scount();
//				for(int i=0;i<size;i++) {
//					System.out.println(q.get(i)+"\t"++w.get(i));
//				}
				menu.showMenu(w);
				//order.s();
				
				break;
			}
			System.out.println("작업을 선택하시오 (m:메뉴관리,o:주문,s:실적보기,x:프로그램 종료) ");
			input = s.nextLine();
		}
		System.out.println("프로그램 종료");
		
		s.close();
//		menu.load();
//		Scanner s1 = new Scanner(System.in);
//		Scanner s2 = new Scanner(System.in);
//		
//		System.out.println("메뉴명 입력:");
//		String name=s1.nextLine();
//		while(!name.equals("")) {  name.isExpity// 빈 문자열 입력.
//			System.out.println("가격입력:");
//			int price = s2.nextInt();
//			menu.addName(name);
//			menu.addPrice(price);
//			System.out.println("메뉴명 입력:");
//			name=s1.nextLine();
//		}
//		System.out.println("메뉴목록");
//		s1.close(); s2.close();
	}

}
