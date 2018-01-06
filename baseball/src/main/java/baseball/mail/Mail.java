package baseball.mail;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import baseball.controller.SubControll;
import baseball.mail.model.MailRepository;
import baseball.mail.model.MailVo;
import baseball.model.PathData;

@Service
public class Mail implements SubControll{
   @Resource
   PathData data;
   
   @Resource
   MailRepository dao;

   MailVo vo;
   
   @Override
   public void execute() {
      System.out.println("메일 엑시큐트 진입"+ data + " //----// data.getDd() : " + data.getDd());
      vo = (MailVo) data.getDd();
      System.out.println("메일클래스에서 mailvo 값 : "+vo);
      switch (data.getService()) {
      
      case "mailList":
         System.out.println("메일 클래스의 메일리스트 케이스");
         list();
      
      case "mailGo":
         System.out.println("메일 클래스의 메일 고 케이스");
         insert();
         break;

      
      }
   }

   void list() {
      data.setDd(dao.list(vo));
      System.out.println("되라제발좀");
   }
   
   void insert() {
      System.out.println("메일클래스 인서트 메소드");
      dao.insert(vo);
      data.setRedirect(true);
      data.setPath("redirect:mailSubmit");
   }
   
   
}