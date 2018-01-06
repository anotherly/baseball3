package baseball.schedule;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.player.model.PlayerStatVo;
import baseball.player.model.PlayerVo;
import baseball.schedule.model.ScheduleVo;

@Service
public class ScheduleRepository {

	@Resource
	SqlSessionTemplate template;

	public List<ScheduleVo> list() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+template.selectList("scheduleMap.selectList"));
		
		return template.selectList("scheduleMap.selectList");
	}
	
	public List<PlayerStatVo> listPlayerStat() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+template.selectList("scheduleMap.selectList"));
		
		return template.selectList("scheduleMap.selectListPlayerStat");
	}

	/*public List<PlayerVo> listSch(PlayerSch sch) {
		return template.selectList("playerInfo.selectListSch", sch);
	}

	public List<PlayerVo> listSchList(PlayerSch sch) {
		return template.selectList("playerInfo.selectListSchList", sch);
	}*/

	public ScheduleVo detail(PlayerVo vo) {
		System.out.println("焼壕壱覗陥たたたたたたたたたたたた"+vo);
		return template.selectOne("scheduleMap.selectDetail", vo);
	}
	public ScheduleVo gameRegisterView(ScheduleVo schevo) {
		return template.selectOne("scheduleMap.gameRegisterView", schevo);
	}
		
	public ScheduleVo gameRegisterViewPlayerStat(ScheduleVo schevo) {
		System.out.println("推奄澗 什追匝傾匂憎塘軒"+schevo);
		return template.selectOne("scheduleMap.gameRegisterViewPlayerStat", schevo);
	}
	
	

	public void insert(ScheduleVo vo) {
		template.insert("scheduleMap.insertOne", vo);
	}
	/*public void insertSchedule(ScheduleVo schevo) {
		template.insert("scheduleMap.insertSchedule", schevo);
	}*/
	
	
	public void insertGameRegister(ScheduleVo schevo) {
		template.insert("scheduleMap.insertGameRegister", schevo);
	}
	
	

	/*public PlayerVo idPwChk(PlayerVo vo) {
		return template.selectOne("playerInfo.idPwChk", vo);
	}*/

	public void fileDelete(PlayerVo vo) {
		template.update("playerMap.fileDelete", vo);
	}

	/*public void delete(PlayerVo vo) {
		template.delete("playerInfo.delete", vo);
	}
*/
	public boolean modify(PlayerVo vo) {
		return template.update("playerMap.modify", vo) > 0;
	}
}
