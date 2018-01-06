package baseball.board.model;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("boa")
public class BoardVo {
	
	MultipartFile file;
	int cnt, id;
	String title, content, userid, regdate, category1, category2, receiver, oriname, sysname;
	
	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCategory1() {
		return category1;
	}
	public void setCategory1(String category1) {
		this.category1 = category1;
	}
	public String getCategory2() {
		return category2;
	}
	public void setCategory2(String category2) {
		this.category2 = category2;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	@Override
	public String toString() {
		return "BoardVo [file=" + file + ", id=" + id + ", cnt=" + cnt + ", title=" + title + ", content=" + content
				+ ", userid=" + userid + ", regdate=" + regdate + ", category1=" + category1 + ", category2="
				+ category2 + ", receiver=" + receiver + ", oriname=" + oriname + ", sysname=" + sysname + "]";
	}
	
	
}
