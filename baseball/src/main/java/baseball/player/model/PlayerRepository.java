package baseball.player.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.player.model.PlayerVo;

@Service
public class PlayerRepository {

	@Resource
	SqlSessionTemplate template;

	public List<PlayerStatCareerVo> list() {
		return template.selectList("playerMap.selectList");
	}
	public List<PlayerVo> teamList() {
		return template.selectList("playerMap.selectTeamList");
	}

	/*public List<PlayerVo> listSch(PlayerSch sch) {
		return template.selectList("playerInfo.selectListSch", sch);
	}

	public List<PlayerVo> listSchList(PlayerSch sch) {
		return template.selectList("playerInfo.selectListSchList", sch);
	}*/

	public PlayerVo detail(PlayerVo vo) {
		System.out.println("焼壕壱覗陥たたたたたたたたたたたた"+vo);
		return template.selectOne("playerMap.selectDetail", vo);
	}

	
	public PlayerStatVo viewTodayStat(PlayerStatVo psvo) {
		System.out.println("焼壕壱覗陥たたたたたたたたたたたた"+psvo);
		return template.selectOne("playerMap.selectViewTodayStat", psvo);
	}
	/*public void insert(PlayerVo vo) {
		template.insert("playerMap.insertOne", vo);
	}
	
	public void insertPlayerStatCareer(PlayerVo pvo) {
		template.insert("playerMap.insertPlayerStatCareer", pvo);
	}*/
	
	public void insertStat(PlayerStatVo psvo) {
		template.insert("playerMap.insertOneStat", psvo);
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
