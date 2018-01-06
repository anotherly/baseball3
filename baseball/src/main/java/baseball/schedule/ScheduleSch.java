package baseball.schedule;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("schesch")
public class ScheduleSch {

	String kind, what;
	
	Integer cnt;
	
	ArrayList<ScheduleSch> list;
	
	

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public ArrayList<ScheduleSch> getList() {
		return list;
	}

	public void setList(ArrayList<ScheduleSch> list) {
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
