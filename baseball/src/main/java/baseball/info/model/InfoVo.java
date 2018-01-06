package baseball.info.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

@Alias("ivo")
public class InfoVo {

	String playerName, position, schoolName, pitchingHand, battingHand, 
	country, sysFile , playerBirth, status, backNum, salary, gun, teamId;
	
	Integer playerId, height, weight, seq, lev, cnt;

	MultipartFile playerPhoto;

	Date regDate;
	
	

	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getLev() {
		return lev;
	}
	public void setLev(Integer lev) {
		this.lev = lev;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getPitchingHand() {
		return pitchingHand;
	}
	public void setPitchingHand(String pitchingHand) {
		this.pitchingHand = pitchingHand;
	}
	public String getBattingHand() {
		return battingHand;
	}
	public void setBattingHand(String battingHand) {
		this.battingHand = battingHand;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSysFile() {
		return sysFile;
	}
	public void setSysFile(String sysFile) {
		this.sysFile = sysFile;
	}
	public String getPlayerBirth() {
		return playerBirth;
	}
	public void setPlayerBirth(String playerBirth) {
		this.playerBirth = playerBirth;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBackNum() {
		return backNum;
	}
	public void setBackNum(String backNum) {
		this.backNum = backNum;
	}
	
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getGun() {
		return gun;
	}
	public void setGun(String gun) {
		this.gun = gun;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	public Integer getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Integer playerId) {
		this.playerId = playerId;
	}
	public MultipartFile getPlayerPhoto() {
		return playerPhoto;
	}
	public void setPlayerPhoto(MultipartFile playerPhoto) {
		this.playerPhoto = playerPhoto;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	/*public String strRegDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate);
	}
	public void parseRegDate(String strRegDate) {
		try {
			regDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strRegDate);
			System.out.println("´¢³»");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/

	

	public String getSysFileEnc() {
		String res = sysFile;
		try {
			res = URLEncoder.encode(sysFile, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public boolean isImg() {
		String ext = sysFile.toLowerCase().substring(sysFile.lastIndexOf(".") + 1);

		ArrayList<String> list = new ArrayList<>();

		list.add("png");
		list.add("gif");
		list.add("bmp");
		list.add("jpg");
		list.add("jpeg");

		return list.contains(ext);

	}
	@Override
	public String toString() {
		return "InfoVo [playerName=" + playerName + ", position=" + position + ", schoolName=" + schoolName
				+ ", pitchingHand=" + pitchingHand + ", battingHand=" + battingHand + ", country=" + country
				+ ", sysFile=" + sysFile + ", playerBirth=" + playerBirth + ", status=" + status + ", backNum="
				+ backNum + ", salary=" + salary + ", gun=" + gun + ", teamId=" + teamId + ", playerId=" + playerId
				+ ", height=" + height + ", weight=" + weight + ", seq=" + seq + ", lev=" + lev + ", cnt=" + cnt
				+ ", playerPhoto=" + playerPhoto + ", regDate=" + regDate + "]";
	}
	
	
	

	

	/*public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	
	public Date getPlayerBirth() {
		return playerBirth;
	}

	public void setPlayerBirth(Date playerBirth) {
		this.playerBirth = playerBirth;
	}

	public String strRegDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate);
	}

	public String strBirth() {
		return new SimpleDateFormat("yyyy-MM-dd").format(playerBirth);
	}

	public void parseBirth(String strBirth) {
		try {
			playerBirth = new SimpleDateFormat("yyyy-MM-dd").parse(strBirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public String strRegDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate);
	}
	public void parseRegDate(String strRegDate) {
		try {
			regDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strRegDate);
			System.out.println("´¢³»");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/



	/*
	 * public PlayerVo(String playerName, String position, String schoolName, String
	 * pitchingHand, String battingHand, String country, String oriFile, String
	 * sysFile, Integer playerId, Integer backNum, Integer height, Integer weight,
	 * Integer salary, Integer teamId, MultipartFile playerPhoto, Date regDate, Date
	 * playerBirth) { super(); this.playerName = playerName; this.position =
	 * position; this.schoolName = schoolName; this.pitchingHand = pitchingHand;
	 * this.battingHand = battingHand; this.country = country; this.oriFile =
	 * oriFile; this.sysFile = sysFile; this.playerId = playerId; this.backNum =
	 * backNum; this.height = height; this.weight = weight; this.salary = salary;
	 * this.teamId = teamId; this.playerPhoto = playerPhoto; this.regDate = regDate;
	 * this.playerBirth = playerBirth; }
	 */

	/*
	 * public String strRegDate() { return new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate); }
	 * 
	 * public String strBirth() { return new
	 * SimpleDateFormat("yyyy-MM-dd").format(playerBirth); }
	 * 
	 * public void parseBirth(String strBirth) { try { playerBirth = new
	 * SimpleDateFormat("yyyy-MM-dd").parse(strBirth); } catch (ParseException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public void parseRegDate(String strRegDate) { try { regDate = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(strRegDate);
	 * System.out.println("´¢³»"); } catch (ParseException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } }
	 */

}
