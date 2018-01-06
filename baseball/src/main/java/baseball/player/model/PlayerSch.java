package baseball.player.model;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("pisch")
public class PlayerSch {

	String kind, what;
	
	Integer cnt;
	
	ArrayList<PlayerSch> list;
	
	

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public ArrayList<PlayerSch> getList() {
		return list;
	}

	public void setList(ArrayList<PlayerSch> list) {
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
