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
import baseball.ticket.model.TicketVo;

@Service
public class Member implements SubControll {

	@Resource
	PathData data;

	@Resource
	MemberRepository dao;

	MemberVo vo;
	TicketVo tvo;

	@Override
	public void execute() {
		if(data.getCate2().equals("reserve")) {
			tvo = (TicketVo) data.getDd();
		}else {
			vo = (MemberVo) data.getDd();
		}
		switch (data.getService()) {

//		case "memberList":
//			list();
//			break;
//			
		case "detail":
			detail(vo);
			break;
			
		case "modify":
			detail(vo);
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
			
			
		case "reservedList":
			list();
			break;
		
		case "cancel":
			cancel();
			break;
			
		}
	}

	public void list() {

		data.setDd(dao.reservedList(vo));

	}
	public void cancel() {
		dao.cancel(tvo);
		data.setRedirect(true);
		data.setPath("redirect:reservedList");
	}
	
	public void detail(MemberVo vo) {
		MemberVo fvo = dao.detail(vo);
		data.setDd(fvo);
	}

	public void delete(MemberVo vo) {
		String url = "redirect:memberFail";
		
		if (dao.idPwChk(vo) != null) {//�ش� id�� pw�� �ش��ϴ� �ο��� �����Ѵٸ�
			System.out.println("���̵� �н����� üũ�� �ùٸ��ԵǼ� ����");
			fileDelete(vo);
			dao.delete(vo);
			url = "redirect:../../home/notice/first";
		}
		
		data.setRedirect(true);
		data.setPath(url);
		
	}

	public void insert() {
		fileupload(vo, data.getRequest());
		dao.insert(vo);
		data.setRedirect(true);
		data.setPath("redirect:../../login/loginSub/first");
	}

	public void modify(MemberVo vo) {
		data.setDd(dao.detail(vo));
	}

	void modifyReg(MemberVo vo) {
		String url = "redirect:memberFail";
		if (dao.modify(vo)) {// ���������� �ش� ��й�ȣ�� ȸ���� �����Ѵٸ�
			fileupload(vo, data.getRequest());
			url = "redirect:detail?userid=" + vo.getUserid();
		}
		data.setRedirect(true);
		data.setPath(url);
	}
	
	public void fileupload(MemberVo vo, HttpServletRequest request) {
		// ���� ���ε� �޼ҵ� !!!!!!!!!!!!!! upfile = ��������,
		// request = ���ε��� ��������
		
		try {
			FileOutputStream fos;
			vo.setOriname(vo.getFile().getOriginalFilename());
			vo.setSysname(vo.getOriname());
			
			String outPath = request.getRealPath("/resources/up");
			outPath = "C:\\FINAL\\baseball3\\baseball\\src\\main\\webapp\\resources\\memberPhoto";
			String realPath = outPath + "\\" + vo.getFile().getOriginalFilename();
			File file = new File(realPath);
			if (file.exists()) {
				int count = 0;
				int dot = vo.getOriname().lastIndexOf(".");
				System.out.println("���Ŭ���� ���Ͼ��ε� �޼ҵ� vo.getOriname(): "+vo.getOriname());
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

	void fileDelete(MemberVo vo) { // ���ϻ����ϱ�!

		String fileName = dao.detail(vo).getSysname();
		if (fileName != null && !fileName.equals("") && !fileName.equals("null")) {
			System.out.println("������!");
			File ff = new File(
					"C:\\FINAL\\baseball3\\baseball\\src\\main\\webapp\\resources\\" + fileName);
			ff.delete();
			dao.fileDelete(vo); // �������� ���ϻ���!!
		}
		data.setRedirect(true);
		data.setPath("redirect:modify?userid=" + vo.getUserid());
	}

}
