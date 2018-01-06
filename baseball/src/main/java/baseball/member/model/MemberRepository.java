package baseball.member.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

@Service
public class MemberRepository {
	
	@Resource
	SqlSessionTemplate template;

	
	public List<MemberVo> list() {
		return template.selectList("mm.selectList");
	}

	public MemberVo detail(MemberVo vo) {
		System.out.println("멤버 레퍼지토리 - 디테일 메소드");
		
		return template.selectOne("mm.selectDetail",vo);
	}
	
	public void insert(MemberVo vo) {
		System.out.println("멤버 레퍼지토리 - 인서트 메소드");
//		vo.setReceivemail("동의");
		vo.setGrade("user");
		System.out.println(vo);
		template.insert("mm.insertOne",vo);
	}
	
	public void delete(MemberVo vo) {

		template.delete("mm.delete",vo);
	}
	
	public MemberVo idPwChk(MemberVo vo){
		System.out.println("멤버 레퍼지토리 아이디 패스워드 체크");
		return template.selectOne("mm.idPwChk", vo);
	}
	
	public void fileDelete(MemberVo vo){
		System.out.println("멤버 레퍼지토리 파일딜리트");
		template.update("mm.fileDelete", vo);
	} 
	
	public boolean modify(MemberVo vo){
		System.out.println("멤버 레퍼지토리 모디파이");
		return template.update("mm.modify", vo)>0;
	} 

	//로그인 관련
//
//	public MemberVo loginCheck(MemberVo vo) {
//		System.out.println("멤버 레퍼지토리 - 로그인체크 메소드");
//		return template.selectOne("mm.loginCheck",vo);
//	}
//	
	public MemberVo findId(MemberVo vo) {
		System.out.println("멤버 레퍼지토리 - 파인드아이디 메소드");
		return template.selectOne("mm.findId",vo);
	}
	
	public MemberVo findPw(MemberVo vo) {
		
		System.out.println("멤버 레퍼지토리 - 파인드 패스워드 메소드");
		return template.selectOne("mm.findPw",vo);
	}
	
}
