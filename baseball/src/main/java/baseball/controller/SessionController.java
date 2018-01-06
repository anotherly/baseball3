package baseball.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.member.model.MemberRepository;
import baseball.member.model.MemberVo;
import baseball.model.PathData;


@Controller
public class SessionController {
	
	@Resource
	PathData data;
	
	@Resource
	MemberRepository dao;
	
	MemberVo vo;
	
	//로그인 창에서 id pw입력하고 확인버튼 눌렀을 때
	@RequestMapping("pathInfo/login/loginSub/loginCheck")
	String loginCheck(HttpSession session, MemberVo mvo) {
		System.out.println("세션컨트롤러 의 로그인체크 메소드의 mvo : "+mvo);
		data.setDd(mvo);
		vo = (MemberVo) data.getDd();
		System.out.println("받은 아이디 : " + vo.getUserid());
		System.out.println("받은 패스워드 : " + vo.getPassword());
		MemberVo fvo = dao.idPwChk(vo);
		String url="";
		if (fvo == null) {
			
			System.out.println("회원 정보가 없거나 일치하지 않을때");
			url="redirect:loginFail";
//			session.setAttribute("title", "존재하지 않는 아이디이거나 비밀번호가 틀렸습니다.");
			
		} else {
			System.out.println("회원정보가 있을때");
			url="redirect:../../home/notice/first";
			session.setAttribute("loginVo",fvo );
		}
		return url;
	}
	
	//로그아웃을 시도할 때
	@RequestMapping("pathInfo/login/loginSub/logout")
	String delete(HttpSession session) {
//		vo = (MemberVo) data.getDd();
		System.out.println("로그인클래스의 로그아웃 메소드");
			
		data.setRedirect(true);// 맞으면 컨트롤러 맵핑에서 아래 세팅한 주소로 보냄
		String url = "redirect:../../login/loginSub/first";
//		session.setAttribute("title", "로그아웃 되었습니다.");
		session.invalidate();
		
		return url;
	}
}