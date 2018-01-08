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
		System.out.println("�� Ŭ���� ���Լ���:" + data);
		System.out.println("�� Ŭ���� ���Խ� getDd2:" + data.getDd2());
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
			System.out.println("����Ʈ ó�� ���̽� ���Լ���");
			list(sch);
			break;

		case "listDay":
			System.out.println("����Ʈ ���� ���̽� ���Լ���");
			listDay();
			break;

		case "listMonth":
			System.out.println("����Ʈ �ս� ���̽� ���Լ���");
			listMonth();
			break;

		case "listYear":
			System.out.println("����Ʈ �̾� ���̽� ���Լ���");
			listYear();
			break;

		case "listAll":
			System.out.println("����Ʈ �� ���̽� ���Լ���");
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
		System.out.println("����Ʈ ���� �޼ҵ� ���Լ���");
		data.setDd2(dao.firstAll());
		// data.setDd2(dao.allStaNotDateList());
		data.setDd(dao.ssdAll(y1, m1, d1, y2, m2, d2));
		data.setRedirect(true);
		data.setPath("redirect:list");
	}

	void list(@ModelAttribute("sch") BillSch sch) {
		System.out.println("�� Ŭ���� ó�� ����Ʈ �޼ҵ�");
		System.out.println("����ġ : " + sch);
		System.out.println("data : " + data);
		data.setDd3(dao.firstAll());
		data.setDd2(dao.middleAll());
		// if(sch!=null) {//�˻� ����� ������(������ �ƹ��͵� �������� ����)
		if(data.getDd2()!=null&&sch!=null) {
			System.out.println("data.getDd2()�� ���� �ƴҶ� ������ : "+data.getDd2());
			if (sch.getSteam().equals("NO ONE")) {// ���õ� ���� �ϳ��� ���ٸ�
				data.setDd(dao.ddAll(y1, m1, d1, y2, m2, d2));
			} else if(sch.getSteam().equals("ALL")){// ��ü ���� ���� Ư�� ��¥��ȸ�� �ϰ�ʹٸ�
				data.setDd(dao.ssdAll(y1, m1, d1, y2, m2, d2));
			}else {//Ư�� �Ⱓ�� ���� Ư�� ������ ��ȸ�� ��
				data.setDd(dao.sdAll(y1, m1, d1, y2, m2, d2,sch.getSteam()));
			}
		}
	}

}
