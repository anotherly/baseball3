package baseball.info.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;







@Service
public class InfoRepository {

	@Resource
	SqlSessionTemplate template;

	public List<InfoVo> playerList() {
		return template.selectList("infoMap.selectList");
	}
	/*public List<InfoVo> teamList() {
		return template.selectList("InfoMap.selectTeamList");
	}*/

	public List<InfoVo> listSch(InfoSch isch) {
		return template.selectList("infoMap.selectListSch", isch);
	}

	public List<InfoVo> listSchList(InfoSch isch) {
		return template.selectList("infoMap.selectListSchList", isch);
	}

	public InfoVo detail(InfoVo ivo) {
		System.out.println("焼壕壱覗陥たたたたたたたたたたたた"+ivo);
		return template.selectOne("infoMap.selectDetail", ivo);
	}
	
	public void insertPlayerStatCareer(InfoVo ivo) {
		template.insert("infoMap.insertPlayerStatCareer", ivo);
	}
	public void insert(InfoVo ivo) {
		template.insert("infoMap.insertOne", ivo);
	}
	/*
	
	public void insertStat(InfoVo psvo) {
		template.insert("InfoMap.insertOneStat", psvo);
	}

	public InfoVo idPwChk(InfoVo vo) {
		return template.selectOne("InfoInfo.idPwChk", vo);
	}

	public void fileDelete(InfoVo vo) {
		template.update("InfoMap.fileDelete", vo);
	}*/

	public void delete(InfoVo ivo) {
		template.delete("infoMap.delete", ivo);
	}

	public boolean modify(InfoVo ivo) {
		return template.update("infoMap.modify", ivo) > 0;
	}
}
