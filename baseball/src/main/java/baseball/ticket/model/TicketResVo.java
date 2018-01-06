package baseball.ticket.model;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("ticketReservation")
public class TicketResVo {

	String stadium, user_name, user_phone, money;

	String user_id;
	
	Date payday;

	
	
	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "TicketResVo [stadium=" + stadium + ", user_name=" + user_name + ", user_phone=" + user_phone
				+ ", money=" + money + ", user_id=" + user_id + ", payday=" + payday + "]";
	}

}