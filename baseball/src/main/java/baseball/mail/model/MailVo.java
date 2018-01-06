package baseball.mail.model;

import org.apache.ibatis.type.Alias;

@Alias("zzokzi")
public class MailVo {
   String userid,sendid,title,content,maildate;
   
   public String getUserid() {
      return userid;
   }
   public void setUserid(String userid) {
      this.userid = userid;
   }
   public String getSendid() {
      return sendid;
   }
   public void setSendid(String sendid) {
      this.sendid = sendid;
   }
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public String getContent() {
      return content;
   }
   public void setContent(String content) {
      this.content = content;
   }
   public String getMaildate() {
      return maildate;
   }
   public void setMaildate(String maildate) {
      this.maildate = maildate;
   }
   @Override
   public String toString() {
      return "MailVo [userid=" + userid + ", sendid=" + sendid + ", title=" + title + ", content=" + content
            + ", maildate=" + maildate + "]";
   }

   
}