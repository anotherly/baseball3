package baseball.bill.model;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//import org.apache.ibatis.type.Alias;

//@Alias("bi")

//���� ��ư�� ������ �� �� ������ �޾ƿ��� vo
//ticketres ���̺��� money�� deposit�̶�� ������ �޾ƿͼ� 
//�װ��� ���Ͱ� ���� �� �� �ۼ�Ʈ�� �־���
//�� ���� ������ ���� ���̺� �־��ش�
public class BillVo {

	Date billdate;// ��¥
	String stadium;// Ȩ�� �����
	Integer income, refund, deposit, withdraw, // �� ���ż���, ȯ�ұ�, ����(�ѱ���-ȯ��),����(���� �츮 ���� ������)
			home, away, kbo, we;// ���� : Ȩ 60 ����� 20 kbo 10 �츮 10
//	Integer year1,month1,day1,year2,month2,day2;
//	String steam;

	

//	public Integer getYear1() {
//		System.out.println("���̾� �����ϳ�? : "+year1);
//		return year1;
//	}
//
//	public void setYear1(Integer year1) {
//		System.out.println("���̾� �����ϳ�? : "+year1);
//		this.year1 = year1;
//	}
//
//	public Integer getMonth1() {
//		return month1;
//	}
//
//	public void setMonth1(Integer month1) {
//		this.month1 = month1;
//	}
//
//	public Integer getDay1() {
//		return day1;
//	}
//
//	public void setDay1(Integer day1) {
//		this.day1 = day1;
//	}
//
//	public Integer getYear2() {
//		return year2;
//	}
//
//	public void setYear2(Integer year2) {
//		this.year2 = year2;
//	}
//
//	public Integer getMonth2() {
//		return month2;
//	}
//
//	public void setMonth2(Integer month2) {
//		this.month2 = month2;
//	}
//
//	public Integer getDay2() {
//		return day2;
//	}
//
//	public void setDay2(Integer day2) {
//		this.day2 = day2;
//	}
//
//	public String getSteam() {
//		return steam;
//	}
//
//	public void setSteam(String steam) {
//		this.steam = steam;
//	}

	public String strRegDate(Timestamp ts) {
		System.out.println("�� ���׵���Ʈ �����ϳ�");
		return new SimpleDateFormat("yyyy-MM-dd").format(ts);
	}

	public void parseRegDate(String strRegDate) {
		try {
			this.billdate = new SimpleDateFormat("yyyy-MM-dd").parse(strRegDate);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Date getBilldate() {
		return billdate;
	}

	public void setBilldate(Date billdate) {
		
		this.billdate = billdate;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public Integer getIncome() {
		return income;
	}

	public void setIncome(Integer income) {
		this.income = income;
	}

	public Integer getRefund() {
		return refund;
	}

	public void setRefund(Integer refund) {
		this.refund = refund;
	}

	public Integer getDeposit() {
		return deposit;
	}

	public void setDeposit(Integer deposit) {
		this.deposit = deposit;
	}

	public Integer getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(Integer withdraw) {
		this.withdraw = withdraw;
	}

	public Integer getHome() {
		return home;
	}

	public void setHome(Integer home) {
		this.home = home;
	}

	public Integer getAway() {
		return away;
	}

	public void setAway(Integer away) {
		this.away = away;
	}

	public Integer getKbo() {
		return kbo;
	}

	public void setKbo(Integer kbo) {
		this.kbo = kbo;
	}

	public Integer getWe() {
		return we;
	}

	public void setWe(Integer we) {
		this.we = we;
	}

	public void calculate(int income, int refund) {
		this.income = income;
		this.refund = refund;
		this.deposit = income - refund;
		this.withdraw = (int) (deposit * 0.9);
		this.home = (int) (deposit * 0.6);
		this.away = (int) (deposit * 0.2);
		this.kbo = (int) (deposit * 0.1);
		this.we = (int) (deposit * 0.1);
	}

	@Override
	public String toString() {
		return "BillVo [billdate=" + billdate + ", stadium=" + stadium + ", income=" + income + ", refund=" + refund
				+ ", deposit=" + deposit + ", withdraw=" + withdraw + ", home=" + home + ", away=" + away + ", kbo="
				+ kbo + ", we=" + we + "]";
	}

//	@Override
//	public String toString() {
//		return "BillVo [billdate=" + billdate + ", stadium=" + stadium + ", income=" + income + ", refund=" + refund
//				+ ", deposit=" + deposit + ", withdraw=" + withdraw + ", home=" + home + ", away=" + away + ", kbo="
//				+ kbo + ", we=" + we + ", year1=" + year1 + ", month1=" + month1 + ", day1=" + day1 + ", year2=" + year2
//				+ ", month2=" + month2 + ", day2=" + day2 + ", steam=" + steam + "]";
//	}

	
	
}
