package baseball.mail.model;

import java.util.List;

import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;


@Service
public class MailRepository {
   
   @Resource
   SqlSessionTemplate template;
   
   public List<MailVo> list(MailVo vo) {
      System.out.println("메일 레퍼지토리 리스트 vo의 유저아이디 : "+vo.userid+", "+vo.getUserid());
      return template.selectList("mail.mailList",vo);
   }
   
   public void insert(MailVo vo) {
      System.out.println("메일 레퍼지토리 - 인서트 메소드");
      System.out.println(vo);
      template.insert("mail.sendMail",vo);
   }

   public MailVo detail(MailVo vo) {
      System.out.println("멤버 레퍼지토리 - 디테일 메소드");   
      return template.selectOne("mail.mailCheck",vo);
   }
   
   public void delete(MailVo vo) {
      template.delete("mail.delete",vo);
   }
   
}