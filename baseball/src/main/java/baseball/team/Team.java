package baseball.team;

import java.io.FileOutputStream;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import baseball.controller.SubControll;
import baseball.model.PathData;
import baseball.team.model.TeamRepository;
import baseball.team.model.TeamVo;

@Service
public class Team implements SubControll {

	@Resource
	PathData data;

	@Resource
	TeamRepository dao;

	TeamVo vo;

	@Override
	public void execute() {

		// TODO Auto-generated method stub

		System.out.println("팀 클래스 진입성공:" + data);
		vo = (TeamVo) data.getDd();

		switch (data.getService()) {
		
		case "teaminfolist":
			list();
			break;
			
		case "teamregister":
			reg();
			break;

		case "teamdetail":
			view();
			break;

		}
	}

	void reg() {
		System.out.println("진입확인" + vo);
		fileupload(vo, data.getRequest());
		dao.insert(vo);
		data.setRedirect(true);
		data.setPath("redirect:teamdetail?id=" + vo.getTeamId());
	}

	void view() {
		System.out.println("팀 클래스 뷰 메서드 진입");
		System.out.println("vo : "+vo);
		data.setDd(dao.detail(vo));
	}

	void list() {
		System.out.println("팀 클래스 리스트 메소드 진입");
		data.setDd(dao.list());
//		data.setRedirect(true);
//		data.setPath("redirect:teaminfolist");
	}

	ModelAndView deleteForm(@ModelAttribute("vo") TeamVo vo) {

		ModelAndView mav = new ModelAndView();
		System.out.println("deleteForm:" + vo.getTeamId());
		return mav;
	}

	void fileupload(TeamVo vo, HttpServletRequest request) {

		try {
			vo.setOriFile(vo.getFf().getOriginalFilename());
			String outPath = request.getRealPath("/resources/teamPhoto");
			outPath = "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\teamPhoto";
			outPath += "/" + vo.getOriFile();

			vo.setSysFile(vo.getOriFile());

			FileOutputStream fos = new FileOutputStream(outPath);

			fos.write(vo.getFf().getBytes());

			fos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
