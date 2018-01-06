package baseball.team.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.team.TeamSch;

@Service
public class TeamRepository {

	@Resource
	SqlSessionTemplate template;

	public List<TeamVo> list() {
		System.out.println("팀 레퍼지토리 리스트 진입 ");
		return template.selectList("teamMap.selectList");
	}

	public TeamVo detail(TeamVo vo) {
		System.out.println("팀 레퍼지토리 디테일 진입 ");
		return template.selectOne("teamMap.selectDetail", vo);
	}

	public void insert(TeamVo vo) {
		template.insert("teamMap.insertOne", vo);
	}

}
