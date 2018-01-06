package baseball.home;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("hsch")
public class HomeSch {

	String kind, what;
	
	Integer cnt;
	
	ArrayList<HomeSch> list;
	
	

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public ArrayList<HomeSch> getList() {
		return list;
	}

	public void setList(ArrayList<HomeSch> list) {
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
