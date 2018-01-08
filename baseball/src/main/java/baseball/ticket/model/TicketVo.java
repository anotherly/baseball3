package baseball.ticket.model;

import java.util.ArrayList;
import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("ticketinformation")
public class TicketVo {

	String stadium;
	String seat;
	String ticketinfo;
	String listt;
	String line;
	Integer paid;
	String userid;
	Integer match_year, match_month, match_day;
	Integer price;
	Date pay_date;
	
	ArrayList<TicketVo> reallist;

	
	

	public Date getPay_date() {
		return pay_date;
	}

	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

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

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		return "TicketVo [stadium=" + stadium + ", seat=" + seat + ", ticketinfo=" + ticketinfo + ", listt=" + listt
				+ ", line=" + line + ", paid=" + paid + ", userid=" + userid + ", match_year=" + match_year
				+ ", match_month=" + match_month + ", match_day=" + match_day + ", price=" + price + ", reallist="
				+ reallist + "]";
	}


	
	
		
} 
 