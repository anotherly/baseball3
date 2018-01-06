package baseball.ticket.model;

import java.util.ArrayList;

import org.apache.ibatis.type.Alias;

@Alias("ticketinformation")
public class TicketVo {

	String stadium;
	String seat;
	String ticketinfo;
	String listt;
	String line;
	Integer paid;
	String user_id;
	Integer match_year, match_month, match_day;
	
	ArrayList<TicketVo> reallist;

	

	public Integer getMatch_year() {
		return match_year;
	}

	public void setMatch_year(Integer match_year) {
		this.match_year = match_year;
	}

	public Integer getMatch_month() {
		return match_month;
	}

	public void setMatch_month(Integer match_month) {
		this.match_month = match_month;
	}

	public Integer getMatch_day() {
		return match_day;
	}

	public void setMatch_day(Integer match_day) {
		this.match_day = match_day;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Integer getPaid() {
		return paid;
	}

	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getTicketinfo() {
		return ticketinfo;
	}

	public void setTicketinfo(String ticketinfo) {
		this.ticketinfo = ticketinfo;
	}

	public String getListt() {
		return listt;
	}

	public void setListt(String listt) {
		this.listt = listt;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}


	public ArrayList<TicketVo> getReallist() {
		return reallist;
	}

	public void setReallist(ArrayList<TicketVo> reallist) {
		this.reallist = reallist;
	}

	@Override
	public String toString() {
		return "TicketVo [stadium=" + stadium + ", seat=" + seat + ", ticketinfo=" + ticketinfo + ", listt=" + listt
				+ ", line=" + line + ", paid=" + paid + ", user_id=" + user_id + ", match_year=" + match_year
				+ ", match_month=" + match_month + ", match_day=" + match_day + ", reallist=" + reallist + "]";
	}

	
	
		
} 
 