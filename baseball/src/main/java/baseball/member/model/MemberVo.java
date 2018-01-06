package baseball.member.model;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("mem")
public class MemberVo {

	MultipartFile file;
	
	String userid, nick ,name, birth, address, phone, receivemail, preferTeam, password,grade;

	String sysname, oriname;

	
	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getOriname() {
		return oriname;
	}

	public void setOriname(String oriname) {
		this.oriname = oriname;
	}

	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReceivemail() {
		return receivemail;
	}
	public void setReceivemail(String receivemail) {
		this.receivemail = receivemail;
	}
	public String getPreferTeam() {
		return preferTeam;
	}
	public void setPreferTeam(String preferTeam) {
		this.preferTeam = preferTeam;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "MemberVo [file=" + file + ", userid=" + userid + ", nick=" + nick + ", name=" + name + ", birth="
				+ birth + ", address=" + address + ", phone=" + phone + ", receivemail=" + receivemail + ", preferTeam="
				+ preferTeam + ", password=" + password + ", grade=" + grade + ", sysname=" + sysname + ", oriname="
				+ oriname + "]";
	}
	
}
