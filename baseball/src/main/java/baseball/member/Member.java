package baseball.member;

import java.io.File;
import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import baseball.controller.SubControll;
import baseball.member.model.MemberRepository;
import baseball.member.model.MemberVo;
import baseball.model.PathData;

@Service
public class Member implements SubControll {

	@Resource
	PathData data;

	@Resource
	MemberRepository dao;

	MemberVo vo;

	@Override
	public void execute() {
		System.out.println("+++++++++++++++++멤버클래스 진입성공:" + data);
		
		vo = (MemberVo) data.getDd();
		System.out.println("멤버vo의 vo값: " + vo);
//		System.out.println("고정 멤버 mvo의 vo값: " + data.getMvo());
		
		switch (data.getService()) {

//		case "memberList":
//			list();
//			break;
//			
		case "detail":
			System.out.println("케이스 멤버디테일");
			detail(vo);
			break;
			
		case "modify":
			System.out.println("케이스 멤버디테일");
			modify(vo);
			break;
			
		case "deleteReg":
			delete(vo);
			break;

		case "modifyReg":
			modifyReg(vo);
			break;

		case "fileDelete":
			fileDelete(vo);
			break;
			
		case "join":
			insert();
			break;
		}
	}

	public void detail(MemberVo vo) {
		System.out.println("디테일에서 받아온 vo의 값 : "+vo);
		MemberVo fvo = dao.detail(vo);
		System.out.println(fvo);
		data.setDd(fvo);
	}

	public void list() {
		data.setDd(dao.list());
	}

	public void delete(MemberVo vo) {
		String url = "redirect:memberFail";
		
		if (dao.idPwChk(vo) != null) {//해당 id와 pw에 해당하는 인원이 존재한다면
			System.out.println("아이디 패스워드 체크가 올바르게되서 삭제");
			fileDelete(vo);
			dao.delete(vo);
			url = "redirect:../../home/notice/first";
		}
		
		data.setRedirect(true);
		data.setPath(url);
		
	}

	public void insert() {
		System.out.println("멤버의 인서트의 vo:"+vo);
		System.out.println("data.getRequest():"+data.getRequest());
		fileupload(vo, data.getRequest());
		dao.insert(vo);
		data.setRedirect(true);
		data.setPath("redirect:../../login/loginSub/first");
		ModelAndView mav = new ModelAndView();
		mav.addObject("title","회원가입에 성공하셨습니다 축하합니다!");
	}

	public void modify(MemberVo vo) {
		data.setDd(dao.detail(vo));
	}

	void modifyReg(MemberVo vo) {
		System.out.println("멤버 클래스의 모디파이 메소드 진입");
		String url = "redirect:memberFail";
		
		vo.setOriname(vo.getFile().getOriginalFilename());
		vo.setSysname(vo.getFile().getOriginalFilename());
		vo.setGrade("user");
		if (dao.modify(vo)) {// 수정했을때 해당 비밀번호의 회원이 존재한다면
			System.out.println("모디파이 맵 실행시 vo객체가 존재한다면");
			fileupload(vo, data.getRequest());
			url = "redirect:detail?userid=" + vo.getUserid();
			data.setDd(vo);
//			data.setMvo(vo);
		}
		data.setRedirect(true);
		data.setPath(url);
	}
	
	public void fileupload(MemberVo vo, HttpServletRequest request) {
		// 파일 업로드 메소드 !!!!!!!!!!!!!! upfile = 파일정보,
		// request = 업로드할 폴더정보
		System.out.println("파일업로드 메소드 진입성공");
		FileOutputStream fos;
		vo.setOriname(vo.getFile().getOriginalFilename());
		vo.setSysname(vo.getFile().getOriginalFilename());
		System.out.println("파일의 오리네임 : "+vo.getFile().getOriginalFilename());
		try {
			String outPath = request.getRealPath("/resources/up");
			outPath = "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\memberPhoto";
			String realPath = outPath + "\\" + vo.getFile().getOriginalFilename();
			File file = new File(realPath);
			if (file.exists()) {
				int count = 0;
				int dot = vo.getOriname().lastIndexOf(".");
				System.out.println("멤버클래스 파일업로드 메소드 vo.getOriname(): "+vo.getOriname());
				String nameonly = vo.getOriname().substring(0, dot);
				String hwak = vo.getOriname().substring(dot);

				while (file.exists()) {
					count++;
					vo.setSysname(nameonly + "_" + count + hwak);
					realPath = outPath + "\\" + vo.getSysname();

					file = new File(realPath);
				}
			}

			fos = new FileOutputStream(realPath);
			fos.write(vo.getFile().getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void fileDelete(MemberVo vo) { // 파일삭제하기!

		String fileName = dao.detail(vo).getSysname();
		System.out.println(fileName);

		if (fileName != null && !fileName.equals("") && !fileName.equals("null")) {
			System.out.println("지우자!");
			File ff = new File(
					"C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\memberPhoto" + fileName);
			ff.delete();
			dao.fileDelete(vo); // 수정에서 파일삭제!!
		}

	}

}
