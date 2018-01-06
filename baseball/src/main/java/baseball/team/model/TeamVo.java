package baseball.team.model;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("tvo")
public class TeamVo {

	String teamName, office, tel, homepage, teamId;
	Integer teamBirth, win;
	String home, owner, president, captin, manager, sysFile, oriFile;
	MultipartFile ff;
	// HttpServletRequest request; mapping에서 자동으로 주지 못한다.

	public TeamVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamVo(String teamId, String teamName, String office, String tel, String homepage, int teamBirth, int win,
			String home, String owner, String president, String captin, String manager, MultipartFile ff) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.office = office;
		this.tel = tel;
		this.homepage = homepage;
		this.teamBirth = teamBirth;
		this.win = win;
		this.home = home;
		this.owner = owner;
		this.president = president;
		this.captin = captin;
		this.manager = manager;
		this.ff = ff;
	}

	

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public void setTeamBirth(Integer teamBirth) {
		this.teamBirth = teamBirth;
	}

	public void setWin(Integer win) {
		this.win = win;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public int getTeamBirth() {
		return teamBirth;
	}

	public void setTeamBirth(int teamBirth) {
		this.teamBirth = teamBirth;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public String getHome() {
		return home;
	}

	public void setHome(String home) {
		this.home = home;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getPresident() {
		return president;
	}

	public void setPresident(String president) {
		this.president = president;
	}

	public String getCaptin() {
		return captin;
	}

	public void setCaptin(String captin) {
		this.captin = captin;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public MultipartFile getFf() {
		System.out.println("겟파일");
		return ff;
	}

	public void setFf(MultipartFile ff) {
		System.out.println("셋파일" + ff.getOriginalFilename());
		this.ff = ff;
	}

	public String getSysFile() {
		return sysFile;
	}

	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	}

	public String getOriFile() {
		return oriFile;
	}

	public void setOriFile(String oriFile) {
		this.oriFile = oriFile;
	}

	@Override
	public String toString() {
		return "TeamVo [teamId=" + teamId + ", teamName=" + teamName + ", office=" + office + ", tel=" + tel
				+ ", homepage=" + homepage + ", teamBirth=" + teamBirth + ", win=" + win + ", home=" + home + ", owner="
				+ owner + ", president=" + president + ", captin=" + captin + ", manager=" + manager + ", sysFile="
				+ sysFile + ", oriFile=" + oriFile + ", ff=" + ff + "]";
	}

}