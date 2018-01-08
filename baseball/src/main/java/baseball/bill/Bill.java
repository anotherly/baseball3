package baseball.bill;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import baseball.bill.model.BillDao;
import baseball.bill.model.BillSch;
import baseball.bill.model.BillVo;
import baseball.controller.SubControll;
import baseball.model.PathData;

@Service
public class Bill implements SubControll {

	@Resource
	PathData data;

	@Resource
	BillDao dao;

	BillVo vo;

	BillSch sch;
	String y1, m1, d1, y2, m2, d2;

	@Override
	public void execute() {
		System.out.println("빌 클래스 진입성공:" + data);
		System.out.println("빌 클래스 진입시 getDd2:" + data.getDd2());
		vo = (BillVo) data.getDd();
		if(data.getDd2()!=null) {
			sch = (BillSch) data.getDd2();
			y1 = Integer.toString(sch.getYear());
			m1 = Integer.toString(sch.getMonth());
			d1 = Integer.toString(sch.getDay());
			y2 = Integer.toString(sch.getYear2());
			m2 = Integer.toString(sch.getMonth2());
			d2 = Integer.toString(sch.getDay2());
			System.out.println(y1);
			System.out.println(m1);
			System.out.println(d1);
			System.out.println(y2);
			System.out.println(m2);
			System.out.println(d2);
		}
		

		switch (data.getService()) {
		case "list":
			System.out.println("리스트 처음 케이스 진입성공");
			list(sch);
			break;

		case "listDay":
			System.out.println("리스트 데이 케이스 진입성공");
			listDay();
			break;

		case "listMonth":
			System.out.println("리스트 먼스 케이스 진입성공");
			listMonth();
			break;

		case "listYear":
			System.out.println("리스트 이어 케이스 진입성공");
			listYear();
			break;

		case "listAll":
			System.out.println("리스트 얼 케이스 진입성공");
			listAll();
			break;

		}
	}

	private void listAll() {
		// TODO Auto-generated method stub

	}

	private void listYear() {
		// TODO Auto-generated method stub

	}

	private void listMonth() {
		// TODO Auto-generated method stub

	}

	private void listDay() {
		System.out.println("리스트 데이 메소드 진입성공");
		data.setDd2(dao.firstAll());
		// data.setDd2(dao.allStaNotDateList());
		data.setDd(dao.ssdAll(y1, m1, d1, y2, m2, d2));
		data.setRedirect(true);
		data.setPath("redirect:list");
	}

	void list(@ModelAttribute("sch") BillSch sch) {
		System.out.println("빌 클래스 처음 리스트 메소드");
		System.out.println("빌서치 : " + sch);
		System.out.println("data : " + data);
		data.setDd3(dao.firstAll());
		data.setDd2(dao.middleAll());
		// if(sch!=null) {//검색 결과가 있을때(없으면 아무것도 보여주지 않음)
		if(data.getDd2()!=null&&sch!=null) {
			System.out.println("data.getDd2()가 널이 아닐때 이프문 : "+data.getDd2());
			if (sch.getSteam().equals("NO ONE")) {// 선택된 팀이 하나도 없다면
				data.setDd(dao.ddAll(y1, m1, d1, y2, m2, d2));
			} else if(sch.getSteam().equals("ALL")){// 전체 팀에 대한 특정 날짜조회를 하고싶다면
				data.setDd(dao.ssdAll(y1, m1, d1, y2, m2, d2));
			}else {//특정 기간에 대한 특정 구장을 조회할 떼
				data.setDd(dao.sdAll(y1, m1, d1, y2, m2, d2,sch.getSteam()));
			}
		}
	}

}
