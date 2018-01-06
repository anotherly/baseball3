package baseball.schedule;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import baseball.controller.SubControll;
import baseball.model.PathData;
import baseball.player.model.PlayerRepository;
import baseball.player.model.PlayerStatCareerVo;
import baseball.player.model.PlayerStatVo;
import baseball.player.model.PlayerVo;
import baseball.schedule.model.ScheduleVo;

@Service
public class Schedule implements SubControll {

	@Resource
	PathData data;

	@Resource
	ScheduleRepository scheRep;

	@Resource
	PlayerRepository pRep;

	PlayerVo pvo;
	PlayerStatVo psvo;
	PlayerStatCareerVo pscvo;
	ScheduleVo schevo;

	@Override
	public void execute() {
		System.out.println("!@!@!@!@!@!@!@!@!플레이어 검색 클래스 진입");
		// TODO Auto-generated method stub

		System.out.println("schedule 진입성공:" + data);
		schevo = (ScheduleVo) data.getDd();
		psvo = (PlayerStatVo) data.getDd2();

		switch (data.getService()) {
		case "list":
			list();
			break;

		case "gameRegisterDetail":
			gameRegisterReg();
			break;

		case "gameRegisterView":
			gameRegisterView();
			break;

		/*
		 * case "view": view(); break;
		 */

		// case "detail": view(); break;

		/*
		 * case "detail": reg(); break;
		 */

		/*
		 * case "register": register(); break;
		 */

		/*
		 * case "modify": modify(); break;
		 */

		/*
		 * case "detail": modify(); break;
		 */
		}

	}

	/*
	 * void modify() { System.out.println("모디파이~~~~~~~~~~~~~~~");
	 * data.setDd(pRep.detail(vo)); //return vo;
	 * 
	 * }
	 */

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

		System.out.println("흠?psvo" + psvo);
		System.out.println("흠?pscvo" + pscvo);
		// fileupload(vo, data.getRequest());
		pRep.insertStat(psvo);

		data.setRedirect(true);
		data.setPath("redirect:view?playerId=" + psvo.getPlayerId());
	}

	void gameRegisterReg() {

		// fileupload(vo, data.getRequest());
		scheRep.insertGameRegister(schevo);
		//scheRep.gameRegisterViewPlayerStat(schevo);
		System.out.println();

		data.setRedirect(true);
		data.setPath("redirect:gameRegisterView?game_num=" + schevo.getGame_num());
	}

	/*
	 * PlayerVo register(PlayerVo pvo) { //data.setDd(pRep.detail(pvo)); switch
	 * (vo.getHome()) { case 1: return pvo.getTeamId(); break; case 2:
	 * 
	 * break;
	 * 
	 * default: break; }
	 * 
	 * }
	 */

	void register() {
		System.out.println("!!!#@%#$^&%$#$!@$@%" + pRep.teamList());
		// init();
		// data.setDd(pRep.list());
	}

	/*
	 * void view() {
	 * 
	 * data.setDd(pRep.detail(pvo));
	 * 
	 * }
	 */
	void gameRegisterView() {
		System.out.println("여기?1" + schevo);
		data.setDd(scheRep.gameRegisterView(schevo));

		
		//System.out.println("여기?2" + schevo);
		
		System.out.println("여기?2" + psvo);
		data.setDd2(scheRep.gameRegisterViewPlayerStat(schevo));

	}

	void list() {
		data.setDd(scheRep.list());
		data.setDd2(scheRep.listPlayerStat());
		

	}

	/*
	 * ModelAndView deleteForm(@ModelAttribute("vo") PlayerVo vo) {
	 * 
	 * ModelAndView mav = new ModelAndView(); System.out.println("deleteForm:" +
	 * vo.getPlayerId()); return mav; }
	 */

	/*
	 * void fileupload(ScheduleVo vo, HttpServletRequest request) {
	 * 
	 * try {
	 * 
	 * String outPath = request.getRealPath("/resources/playerPhoto"); outPath =
	 * "C:\\FINAL\\baseball\\src\\main\\webapp\\resources\\playerPhoto"; outPath +=
	 * "/" + vo.getPlayerPhoto().getOriginalFilename();
	 * vo.setSysFile(vo.getPlayerPhoto().getOriginalFilename()); FileOutputStream
	 * fos = new FileOutputStream(outPath);
	 * 
	 * fos.write(vo.getPlayerPhoto().getBytes());
	 * 
	 * fos.close();
	 * 
	 * } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

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
