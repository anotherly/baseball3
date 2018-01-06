package baseball.team;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("tsch")
public class TeamSch {

	String kind, what;
	
	Integer cnt;
	
	ArrayList<TeamSch> list;
	
	

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public ArrayList<TeamSch> getList() {
		return list;
	}

	public void setList(ArrayList<TeamSch> list) {
		this.list = list;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getWhat() {
		return what;
	}

	public void setWhat(String what) {
		this.what = what;
	}
}
