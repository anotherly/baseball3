package baseball.playerBat;

import java.io.FileOutputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import baseball.controller.SubControll;
import baseball.info.model.InfoRepository;
import baseball.info.model.InfoSch;
import baseball.info.model.InfoVo;
import baseball.model.PathData;

@Service
public class playerBat implements SubControll {

	@Resource
	PathData data;

	@Resource
	InfoRepository iRep;
	
	InfoVo ivo;
	
	InfoSch isch;
	
	@Override
	public void execute() {
		System.out.println("!@!@!@!@!@!@!@!@!플레이어bat 클래스 진입");
		// TODO Auto-generated method stub
		
		System.out.println("info 진입성공:" + data);
		
		ivo = (InfoVo) data.getDd();
		//pvo = (PlayerVo)data.getDd();
		System.out.println("vo뒤"+ivo);
		
		switch (data.getService()) {
		/*case "list":
			list();
			break;*/
			
		case "playerList":
			playerList();
			break;

		case "view":
			view();
			break;
		// case "detail": view(); break;

		case "detail":
			reg();
			break;
			
		case "playerModify":
			playerModify();
			break;
			

		/*
		 * case "detail": modify(); break;
		 */
		}

	}

	InfoVo playerModify() {
		System.out.println("모디파이~~~~~~~~~~~~~~~");
		data.setDd(iRep.modify(ivo));
		//data.setDd(iRep.detail(ivo));
		return	ivo;

	}

	/*
	 * ModelAndView modifySubmit(BoardVO vo, HttpServletRequest request) {
	 * 
	 * String url = "redirect:modifyForm";
	 * 
	 * vo.setUpfile(vo.getFf().getOriginalFilename());
	 * 
	 * if(dao.modify(vo)) { fileupload(vo, request); url = "redirect:detail"; }
	 * ModelAndView mav = new ModelAndView(url);
	 * 
	 * 
	 * mav.addObject("id", vo.getId()); return mav; }
	 */

	void reg() {

		System.out.println("인포의 레그진입확인" + ivo);

		fileupload(ivo, data.getRequest());
		iRep.insert(ivo);
		iRep.insertPlayerStatCareer(ivo);
		data.setRedirect(true);
		
		data.setPath("redirect:view?playerId=" + ivo.getPlayerId());
	}

	/*
	 * void register() { data.setPath("redirect:register"); }
	 */

	void view() {
		
		data.setDd(iRep.detail(ivo));

	}

	/*void list() {
		//kindArr();
		System.out.println("옵니까?????????????????????????????");
		
		data.setDd(iRep.list());
		//data.setDd(iRep.listSch(isch));
		//data.setDd(iRep.listSchList(isch));
		data.setPath("redirect:list");

	}*/
	
	/*@RequestMapping("info/list")
	ModelAndView  list(@ModelAttribute("isch") InfoSch isch) {
		
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", iRep.listSchList(isch));
		
		return mav;
	}*/
	
	
	void playerList() {
		//kindArr();
				
		data.setDd(iRep.playerList());
		data.setDd(iRep.listSch(isch));
		data.setDd(iRep.listSchList(isch));
		data.setPath("redirect:playerList");

	}

	/*
	 * ModelAndView deleteForm(@ModelAttribute("vo") PlayerVo vo) {
	 * 
	 * ModelAndView mav = new ModelAndView(); System.out.println("deleteForm:" +
	 * vo.getPlayerId()); return mav; }
	 */

	void fileupload(InfoVo vo, HttpServletRequest request) {

		try {

			String outPath = request.getRealPath("/resources/playerPhoto");
			outPath = "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto";
			outPath += "/" + vo.getPlayerPhoto().getOriginalFilename();
			vo.setSysFile(vo.getPlayerPhoto().getOriginalFilename());
			FileOutputStream fos = new FileOutputStream(outPath);

			fos.write(vo.getPlayerPhoto().getBytes());

			fos.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		/*
		 * void fileupload(PlayerVo vo, HttpServletRequest request) {
		 * System.out.println("우호호호호호" + vo.getPlayerPhoto().getOriginalFilename()); try
		 * {
		 * 
		 * vo.setOriFile(vo.getPlayerPhoto().getOriginalFilename()); String outPath =
		 * request.getRealPath("/resources/playerPhoto"); outPath =
		 * "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto"; outPath +=
		 * "/" + vo.getOriFile();
		 * 
		 * vo.setSysFile(vo.getOriFile());
		 * System.out.println("시스파일입니다"+vo.getSysFile());
		 * 
		 * FileOutputStream fos = new FileOutputStream(outPath);
		 * 
		 * fos.write(vo.getPlayerPhoto().getBytes());
		 * 
		 * fos.close();
		 * 
		 * } catch (Exception e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * String fileupload(PlayerVo vo, HttpServletRequest request) { // 파일 업로드 메소드
		 * !!!!!!!!!!!!!! upfile = 파일정보, // request = 업로드할 폴더정보 FileOutputStream fos;
		 * String sysfile = vo.getPlayerPhoto().getOriginalFilename().toString();
		 * 
		 * try { String outPath = request.getRealPath("/resources/playerPhoto"); outPath
		 * = "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto"; String
		 * realPath = outPath + "\\" + sysfile; File file = new File(realPath); if
		 * (file.exists()) { int count = 0; int dot = sysfile.lastIndexOf("."); String
		 * nameonly = sysfile.substring(0, dot); String hwak = sysfile.substring(dot);
		 * 
		 * while (file.exists()) { count++; sysfile = nameonly + "_" + count + hwak;
		 * 
		 * realPath = outPath + "\\" + sysfile;
		 * 
		 * file = new File(realPath); } }
		 * 
		 * fos = new FileOutputStream(realPath);
		 * fos.write(vo.getPlayerPhoto().getBytes()); fos.close(); } catch (Exception e)
		 * { // TODO Auto-generated catch block e.printStackTrace(); } return sysfile; }
		 */

	}
