package baseball.model;

import java.util.ArrayList;

public class SameMenu {

//	@Resource
//	PathData data;
	
	public SameMenu(PathData data) {
		// -------------------------↓↓↓↓↓로그인/회원가입메뉴구성↓↓↓↓↓↓--------------------------
		ArrayList<Menu> loginMenu = new ArrayList<>();
		loginMenu.add(new Menu("login", "로그인", "loginSub"));// cate1, cate2, service---자바에서 받아올때의 의미
		loginMenu.add(new Menu("join", "회원가입", "joinSub"));// name, korName, url-----jsp로 보낼때의 의미

		// -------------------------↓↓↓↓↓탑 메뉴구성↓↓↓↓↓↓--------------------------
		ArrayList<Menu> topMenu = new ArrayList<>();
		
		topMenu.add(new Menu("ticket", "예매", "reservation"));
		topMenu.add(new Menu("board", "게시판", "boardinfo"));

		topMenu.add(new Menu("player", "기록", "stat"));
		topMenu.add(new Menu("schedule", "일정/결과", "notice"));
		topMenu.add(new Menu("info", "정보", "notice"));
		
		// -------------------------↓↓↓↓↓관리자 메뉴↓↓↓↓↓↓--------------------------
		ArrayList<Menu> managerMenu = new ArrayList<>();
		managerMenu.add(new Menu("manager", "회원 관리", "member"));// name, korName, url-----jsp로 보낼때의 의미
		managerMenu.add(new Menu("manager", "구단 관리", "team"));// name, korName, url-----jsp로 보낼때의 의미
		managerMenu.add(new Menu("manager", "예매 관리", "ticket"));// name, korName, url-----jsp로 보낼때의 의미
		managerMenu.add(new Menu("manager", "장부 관리", "bill"));// name, korName, url-----jsp로 보낼때의 의미

		
		data.setLoginMenu(loginMenu);
		data.setManagerMenu(managerMenu);
		data.setTopMenu(topMenu);
		
	}
	
}
