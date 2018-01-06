package baseball.playerBat.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class PlayerBatRepository {

	@Resource
	SqlSessionTemplate template;

	public List<PlayerBatVo> playerList() {
		return template.selectList("playerBatMap.selectList");
	}
	
}
