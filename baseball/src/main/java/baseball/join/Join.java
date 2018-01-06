//package baseball.join;
//
//import java.io.File;
//import java.io.FileOutputStream;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.stereotype.Service;
//
//import baseball.controller.SubControll;
//import baseball.member.Member;
//import baseball.member.model.MemberRepository;
//import baseball.member.model.MemberVo;
//import baseball.model.PathData;
//
//@Service
//public class Join implements SubControll {
//
//		@Resource
//		PathData data;
//
//		@Resource
//		MemberRepository dao;
//
//		MemberVo vo;
//		
//		Member mem = new Member();
//		
//		@Override
//		public void execute() {
//			System.out.println("조인클래스 진입성공:" + data);
//			vo = (MemberVo) data.getDd();
//			
//			switch (data.getService()) {
//			case "join":
//				join();
//				break;
//			}
//		}
//		
//		void join() {
//			System.out.println("조인클래스의 조인 메소드 진입");
//			System.out.println("data.getRequest():"+data.getRequest());
//			mem.insert(vo);
////			System.out.println("조인의 vo:"+vo);
////			System.out.println("조인의 data.getRequest():"+data.getRequest());
////			mem.fileupload(vo, data.getRequest());
////			dao.insert(vo);
////			data.setRedirect(true);
////			data.setPath("redirect:../../home/notice/list");
//		}
//		
//}