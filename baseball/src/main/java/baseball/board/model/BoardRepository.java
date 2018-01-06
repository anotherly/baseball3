package baseball.board.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.model.PathData;


@Service
public class BoardRepository {

	@Resource
	SqlSessionTemplate template;

	
	public List<BoardVo> list(PathData data) {
		return template.selectList("board.selectList",data);
	}

	public BoardVo detail(BoardVo vo) {
		System.out.println("보드 vo의 디테일");
		return template.selectOne("board.selectDetail",vo);
	}
	public void insert(BoardVo vo) {
		template.insert("board.insertOne",vo);
	}
	/*
	
	public void delete(BoardVo vo) {

		template.delete("board.delete",vo);
	}
	
	public BoardVo idPwChk(BoardVo vo)
	{
		return template.selectOne("board.idPwChk", vo);
	}
	
	public void fileDelete(BoardVo vo)
	{
		template.update("board.fileDelete", vo);
	} 
	
	public boolean modify(BoardVo vo)
	{
		return template.update("board.modify", vo)>0;
	} */
	
}
