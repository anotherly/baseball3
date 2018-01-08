package baseball.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.board.model.BoardVo;
import baseball.member.model.MemberVo;
import baseball.model.Menu;
import baseball.model.PathData;
import baseball.model.SameMenu;
import baseball.team.model.TeamVo;
import baseball.ticket.model.TicketVo;

@Controller
@RequestMapping("pathInfo/{cate1}/{cate2}/{service}")
public class PathController {

	@Resource
	MyProvider provider;

	@Resource
	PathData data;
	
	@ModelAttribute("data") // data 라는 이름으로 값을 주고받음 jsp와
	PathData data(@PathVariable String cate1, @PathVariable String cate2, @PathVariable String service, 
		MemberVo memberVo, 
		TicketVo ticketVo, 
		BoardVo boardVo, 
		TeamVo teamVo,

		HttpServletRequest request) {
		System.out.println("@@@@@@@@@@@@@@@@패스컨트롤러 초기진입");

		System.out.println("최초 순수 getDd2 : "+ data.getDd2());
		System.out.println("최초 순수 데이타 : "+ data.getDd());
		System.out.println("배열 넣기전 멤버vo값 : "+memberVo);
		
		data.setRedirect(false);

		ArrayList<Object> vos = new ArrayList<>(); /// bean들을 받음
		vos.add(teamVo);		
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);

		
//		System.out.println("배열 넣고 후 멤버vo값 : "+MemberVo);
		
		data.setCate1(cate1);
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);

//		System.out.println("패스컨트롤러의 data - " + data);

		String voName;
		// 처음 홈 화면일때 팀값을 불러온다

		if (cate1.equals("home")) {
			voName = "baseball.team.model.TeamVo";
			for (Object obj : vos) {
				if(obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : "+ data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : "+memberVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : "+ data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : "+memberVo);
				}
				/// 맞으면 data 에 넣음
			}
		//로그인 회원가입시 멤버값이나 관리자값을 불러온다
		}else if (cate1.equals("login")){
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if(obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : "+ data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : "+memberVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : "+ data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : "+memberVo);
				}
			}
		}else if (cate1.equals("join")){
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if(obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : "+ data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : "+memberVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : "+ data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : "+memberVo);
				}
			}
			cate1="member";
		}else {
			voName = "baseball." + cate1 + ".model." + cate1.substring(0, 1).toUpperCase() + cate1.substring(1) + "Vo";
			System.out.println("voName 값 : " + voName);
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("이프문에서 넣기전  데이타 : "+ data.getDd());
					System.out.println("데이터 넣기전 멤버vo값 : "+memberVo);
					data.setDd(obj);
					System.out.println("이프문에서 넣고 나서 데이타 : "+ data.getDd());
					System.out.println("데이터 넣고나서 멤버vo값 : "+memberVo);
				}
			}
		}
		System.out.println("컨트롤러에서 매니저 일때 cate1 : "+cate1);
		//// mainData
		SubControll control = provider.getContext().getBean(cate1, SubControll.class);
		//// SubCotroll 을 getBean 으로 가져옴
		control.execute();
		/// 실행시킴
		System.out.println("----------------------------------------");
		System.out.println("액시큐트 하고나서 멤버vo값 : " + memberVo);
		System.out.println("최종적인 겟Dd 의 값 :" + data.getDd());
		System.out.println("패스데이터의 dd - " + data);
		System.out.println("컨트로롤러의 데이타 메소드 나감");
		
		menu();
		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);
		
		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("board", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
//		subMenu.put("ticket", new ArrayList<>());
		
		subMenu.get("member").add(new Menu("membermail","쪽지 리스트","mailList"));
		subMenu.get("member").add(new Menu("memberticket","예매 현황","ticket"));
		
		subMenu.get("board").add(new Menu("boardinfo", "공지사항", "list"));
		subMenu.get("board").add(new Menu("boardfree", "자유게시판", "list"));
		subMenu.get("board").add(new Menu("boardqna", "질문과 답변", "list"));
		subMenu.get("board").add(new Menu("boardfnq", "자주뭍는질문", "list"));
		subMenu.get("board").add(new Menu("boardmessage", "쪽지", "list"));
		
		data.setSubMenu(subMenu.get(data.getCate1()));

	}

	// 여기서 jsp로 보내줌
	@RequestMapping
	String mapping() {
		System.out.println("컨트롤러의 매핑");
		String res = "pathInfo/template";
		if (data.isRedirect()) { //// redirect에 따른 redirect or forward 선택
			System.out.println("컨트롤러의 리다이렉트 if문 진입");
			res = data.getPath();
		}

		return res;
	}

}
