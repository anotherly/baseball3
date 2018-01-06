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

		System.out.println("�� Ŭ���� ���Լ���:" + data);
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
		System.out.println("�� Ŭ���� ���̸���Ʈ �޼ҵ�");
	}

	private void weekList() {
		System.out.println("�� Ŭ���� ��ũ����Ʈ �޼ҵ�");
	}

	private void monthList() {
		System.out.println("�� Ŭ���� �ս�����Ʈ �޼ҵ�");
	}
	
}
