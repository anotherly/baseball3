package baseball.bill;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import baseball.bill.model.BillDao;
import baseball.bill.model.BillVo;
import baseball.controller.SubControll;
import baseball.model.PathData;
import baseball.team.model.TeamVo;

@Service
public class Bill implements SubControll{

	@Resource
	PathData data;
	
	BillDao dao = new BillDao();
	
	BillVo vo;
	
	@Override
	public void execute() {

		// TODO Auto-generated method stub

		System.out.println("빌 클래스 진입성공:" + data);
		vo = (BillVo) data.getDd();

		switch (data.getService()) {
		case "dayList":
			dayList();
			break;
			
		case "weekList":
			weekList();
			break;

		case "monthList":
			monthList();
			break;

		}
	}

	private void dayList() {
		System.out.println("빌 클래스 데이리스트 메소드");
	}

	private void weekList() {
		System.out.println("빌 클래스 위크리스트 메소드");
	}

	private void monthList() {
		System.out.println("빌 클래스 먼스리스트 메소드");
	}
	
}
