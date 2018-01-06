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

	@ModelAttribute("data") // data ��� �̸����� ���� �ְ���� jsp��
	PathData data(@PathVariable String cate2, @PathVariable String service, 
			MemberVo memberVo, TicketVo ticketVo,
			BoardVo boardVo, TeamVo teamVo,BillVo billVo,
			HttpServletRequest request) {
		System.out.println("@@@@@@@@@@@@@@@@�Ŵ�����Ʈ�ѷ��� ����Ÿ �޼ҵ� �ʱ�����");

		System.out.println("���� ���� ����Ÿ : " + data.getDd());
		System.out.println("�迭 �ֱ��� ���vo�� : " + memberVo);

		data.setRedirect(false);

		ArrayList<Object> vos = new ArrayList<>(); /// bean���� ����
		vos.add(teamVo);
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);
		vos.add(billVo);

		data.setCate1("manager");
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);

		// System.out.println("�н���Ʈ�ѷ��� data - " + data);

		String voName;
		// ó�� Ȩ ȭ���϶� ������ �ҷ��´�

		voName = "baseball." + cate2 + ".model." + cate2.substring(0, 1).toUpperCase() + cate2.substring(1) + "Vo";
		System.out.println("voName �� : " + voName);
		for (Object obj : vos) {
			if (obj.getClass().getName().equals(voName)) {
				data.setDd(obj);
			}
		}

		System.out.println("��Ʈ�ѷ����� �Ŵ��� �϶� cate2 : " + cate2);
		//// mainData
		SubControll control = provider.getContext().getBean(cate2, SubControll.class);
		//// SubCotroll �� getBean ���� ������
		control.execute();
		/// �����Ŵ
		System.out.println("----------------------------------------");
		System.out.println("�׽�ťƮ �ϰ��� ���vo�� : " + memberVo);
		System.out.println("�������� ��Dd �� �� :" + data.getDd());
		
		System.out.println("����ī��2 : " + cate2);
		System.out.println("���� service : " + service);
		System.out.println("�н��������� dd - " + data);
		System.out.println("��Ʈ�ηѷ��� ����Ÿ �޼ҵ� ����");

		System.out.println("�޴� ��ġ�� �� ����Ÿ : " + data.getDd());
		menu();
		System.out.println("�޴� ��ġ�� ����Ÿ : " + data.getDd());

		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);

		
		// -------------------------�����鼭��޴������������--------------------------
		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();

		subMenu.put("team", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
		subMenu.put("ticket", new ArrayList<>());
		subMenu.put("bill", new ArrayList<>());

		/////////////////////// ������ �޴� ////////////////////////////////////////

		subMenu.get("team").add(new Menu("team", "���� ����Ʈ", "list"));
		subMenu.get("member").add(new Menu("member", "ȸ�� ���", "list"));
		subMenu.get("member").add(new Menu("member", "��ȸ�� ����", "list"));
		subMenu.get("member").add(new Menu("member", "���� ������", "list"));
		subMenu.get("ticket").add(new Menu("ticket", "���� ��Ȳ", "list"));
		subMenu.get("bill").add(new Menu("bill", "�Ϻ� ��ȸ", "list"));
		subMenu.get("bill").add(new Menu("bill", "�ְ� ��ȸ", "weekList"));
		subMenu.get("bill").add(new Menu("bill", "���� ��ȸ", "monthList"));

		
		data.setSubMenu(subMenu.get(data.getCate2()));
	}

	// ���⼭ jsp�� ������
	@RequestMapping
	String mapping() {
		System.out.println("��Ʈ�ѷ��� ����");
		String res = "pathInfo/template3";
		if (data.isRedirect()) { //// redirect�� ���� redirect or forward ����
			System.out.println("�Ŵ�����Ʈ�ѷ��� �����̷�Ʈ if�� ����");
			res = data.getPath();
		}

		return res;
	}

}
