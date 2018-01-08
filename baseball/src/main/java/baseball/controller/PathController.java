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
	
	@ModelAttribute("data") // data ��� �̸����� ���� �ְ���� jsp��
	PathData data(@PathVariable String cate1, @PathVariable String cate2, @PathVariable String service, 
		MemberVo memberVo, 
		TicketVo ticketVo, 
		BoardVo boardVo, 
		TeamVo teamVo,

		HttpServletRequest request) {
		System.out.println("@@@@@@@@@@@@@@@@�н���Ʈ�ѷ� �ʱ�����");

		System.out.println("���� ���� getDd2 : "+ data.getDd2());
		System.out.println("���� ���� ����Ÿ : "+ data.getDd());
		System.out.println("�迭 �ֱ��� ���vo�� : "+memberVo);
		
		data.setRedirect(false);

		ArrayList<Object> vos = new ArrayList<>(); /// bean���� ����
		vos.add(teamVo);		
		vos.add(memberVo);
		vos.add(ticketVo);
		vos.add(boardVo);

		
//		System.out.println("�迭 �ְ� �� ���vo�� : "+MemberVo);
		
		data.setCate1(cate1);
		data.setCate2(cate2);
		data.setService(service);
		data.setRequest(request);

//		System.out.println("�н���Ʈ�ѷ��� data - " + data);

		String voName;
		// ó�� Ȩ ȭ���϶� ������ �ҷ��´�

		if (cate1.equals("home")) {
			voName = "baseball.team.model.TeamVo";
			for (Object obj : vos) {
				if(obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : "+ data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : "+memberVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : "+ data.getDd());
					System.out.println("������ �ְ��� ���vo�� : "+memberVo);
				}
				/// ������ data �� ����
			}
		//�α��� ȸ�����Խ� ������̳� �����ڰ��� �ҷ��´�
		}else if (cate1.equals("login")){
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if(obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : "+ data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : "+memberVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : "+ data.getDd());
					System.out.println("������ �ְ��� ���vo�� : "+memberVo);
				}
			}
		}else if (cate1.equals("join")){
			voName = "baseball.member.model.MemberVo";
			for (Object obj : vos) {
				if(obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : "+ data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : "+memberVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : "+ data.getDd());
					System.out.println("������ �ְ��� ���vo�� : "+memberVo);
				}
			}
			cate1="member";
		}else {
			voName = "baseball." + cate1 + ".model." + cate1.substring(0, 1).toUpperCase() + cate1.substring(1) + "Vo";
			System.out.println("voName �� : " + voName);
			for (Object obj : vos) {
				if (obj.getClass().getName().equals(voName)) {
					System.out.println("���������� �ֱ���  ����Ÿ : "+ data.getDd());
					System.out.println("������ �ֱ��� ���vo�� : "+memberVo);
					data.setDd(obj);
					System.out.println("���������� �ְ� ���� ����Ÿ : "+ data.getDd());
					System.out.println("������ �ְ��� ���vo�� : "+memberVo);
				}
			}
		}
		System.out.println("��Ʈ�ѷ����� �Ŵ��� �϶� cate1 : "+cate1);
		//// mainData
		SubControll control = provider.getContext().getBean(cate1, SubControll.class);
		//// SubCotroll �� getBean ���� ������
		control.execute();
		/// �����Ŵ
		System.out.println("----------------------------------------");
		System.out.println("�׽�ťƮ �ϰ��� ���vo�� : " + memberVo);
		System.out.println("�������� ��Dd �� �� :" + data.getDd());
		System.out.println("�н��������� dd - " + data);
		System.out.println("��Ʈ�ηѷ��� ����Ÿ �޼ҵ� ����");
		
		menu();
		return data;

	}// pathData data

	void menu() {
		new SameMenu(data);
		
		HashMap<String, ArrayList<Menu>> subMenu = new HashMap<>();
		subMenu.put("board", new ArrayList<>());
		subMenu.put("member", new ArrayList<>());
//		subMenu.put("ticket", new ArrayList<>());
		
		subMenu.get("member").add(new Menu("membermail","���� ����Ʈ","mailList"));
		subMenu.get("member").add(new Menu("memberticket","���� ��Ȳ","ticket"));
		
		subMenu.get("board").add(new Menu("boardinfo", "��������", "list"));
		subMenu.get("board").add(new Menu("boardfree", "�����Խ���", "list"));
		subMenu.get("board").add(new Menu("boardqna", "������ �亯", "list"));
		subMenu.get("board").add(new Menu("boardfnq", "���ֹ�������", "list"));
		subMenu.get("board").add(new Menu("boardmessage", "����", "list"));
		
		data.setSubMenu(subMenu.get(data.getCate1()));

	}

	// ���⼭ jsp�� ������
	@RequestMapping
	String mapping() {
		System.out.println("��Ʈ�ѷ��� ����");
		String res = "pathInfo/template";
		if (data.isRedirect()) { //// redirect�� ���� redirect or forward ����
			System.out.println("��Ʈ�ѷ��� �����̷�Ʈ if�� ����");
			res = data.getPath();
		}

		return res;
	}

}
