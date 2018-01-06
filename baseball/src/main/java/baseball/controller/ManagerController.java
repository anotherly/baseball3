package baseball.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.bill.model.BillVo;
import baseball.board.model.BoardVo;
import baseball.member.model.MemberVo;
import baseball.model.SameMenu;
import baseball.model.Menu;
import baseball.model.PathData;
import baseball.team.model.TeamVo;
import baseball.ticket.model.TicketVo;

@Controller
@RequestMapping("pathInfo/manager/{cate2}/{service}")
public class ManagerController {

	@Resource
	MyProvider provider;

	@Resource
	PathData data;

	@ModelAttribute("data") // data 라는 이름으로 값을 주고받음 jsp와
	PathData data(@PathVariable String cate2, @PathVariable String service, 
			MemberVo memberVo, TicketVo ticketVo,
			BoardVo boardVo, TeamVo teamVo,BillVo billVo,
			HttpServletRequest request) {
		System.out.println("@@@@@@@@@@@@@@@@매니저컨트롤러의 데이타 메소드 초기진입");

		System.out.println("최초 순수 데이타 : " + data.getDd());
		System.out.println("배열 넣기전 멤버vo값 : " + memberVo);

		data.setRedirect(false);

		ArrayList<Object> vos = new ArrayList<>(); /// bean들을 받음
		vos.add(teamVo);
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);
		vos.add(billVo);

		data.setCate1("manager");
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);

		// System.out.println("패스컨트롤러의 data - " + data);

		String voName;
		// 처음 홈 화면일때 팀값을 불러온다

		voName = "baseball." + cate2 + ".model." + cate2.substring(0, 1).toUpperCase() + cate2.substring(1) + "Vo";
		System.out.println("voName 값 : " + voName);
		for (Object obj : vos) {
			if (obj.getClass().getName().equals(voName)) {
				data.setDd(obj);
			}
		}

		System.out.println("컨트롤러에서 매니저 일때 cate2 : " + cate2);
		//// mainData
		SubControll control = provider.getContext().getBean(cate2, SubControll.class);
		//// SubCotroll 을 getBean 으로 가져옴
		control.execute();
		/// 실행시킴
		System.out.println("----------------------------------------");
		System.out.println("액시큐트 하고나서 멤버vo값 : " + memberVo);
		System.out.println("최종적인 겟Dd 의 값 :" + data.getDd());
		
		System.out.println("최종카테2 : " + cate2);
		System.out.println("최종 service : " + service);
		System.out.println("패스데이터의 dd - " + data);
		System.out.println("컨트로롤러의 데이타 메소드 나감");

		System.out.println("메뉴 거치기 전 데이타 : " + data.getDd());
		menu();
		System.out.println("메뉴 거치고 데이타 : " + data.getDd());

		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);

		
		// -------------------------↓↓↓↓↓서브메뉴구성↓↓↓↓↓↓--------------------------
		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();

		subMenu.put("team", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
		subMenu.put("ticket", new ArrayList<>());
		subMenu.put("bill", new ArrayList<>());

		/////////////////////// 관리자 메뉴 ////////////////////////////////////////

		subMenu.get("team").add(new Menu("team", "구단 리스트", "list"));
		subMenu.get("member").add(new Menu("member", "회원 목록", "list"));
		subMenu.get("member").add(new Menu("member", "블랙회원 관리", "list"));
		subMenu.get("member").add(new Menu("member", "메일 보내기", "list"));
		subMenu.get("ticket").add(new Menu("ticket", "예약 현황", "list"));
		subMenu.get("bill").add(new Menu("bill", "일별 조회", "list"));
		subMenu.get("bill").add(new Menu("bill", "주간 조회", "weekList"));
		subMenu.get("bill").add(new Menu("bill", "월간 조회", "monthList"));

		
		data.setSubMenu(subMenu.get(data.getCate2()));
	}

	// 여기서 jsp로 보내줌
	@RequestMapping
	String mapping() {
		System.out.println("컨트롤러의 매핑");
		String res = "pathInfo/template3";
		if (data.isRedirect()) { //// redirect에 따른 redirect or forward 선택
			System.out.println("매니저컨트롤러의 리다이렉트 if문 진입");
			res = data.getPath();
		}

		return res;
	}

}
