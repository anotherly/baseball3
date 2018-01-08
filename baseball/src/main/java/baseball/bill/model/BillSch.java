package baseball.bill.model;

import java.util.ArrayList;

public class BillSch {

	Integer year,month,day,year2,month2,day2;
	
	public Integer getYear2() {
		System.out.println("°ÙÀÌ¾î2 : "+year2);
		return year2;
	}

	public void setYear2(Integer year2) {
		System.out.println("¼ÂÀÌ¾î2 : "+year2);
		this.year2 = year2;
	}

	public Integer getMonth2() {
		System.out.println("°Ù¸Õ½º2 : "+month2);
		return month2;
	}

	public void setMonth2(Integer month2) {
		System.out.println("¼Â¸Õ½º2 : "+month2);
		this.month2 = month2;
	}

	public Integer getDay2() {
		System.out.println("°Ùµ¥ÀÌ2 : "+day2);
		return day2;
	}

	public void setDay2(Integer day2) {
		System.out.println("¼Âµ¥ÀÌ2 : "+day2);
		this.day2 = day2;
	}

	String steam;
	
	ArrayList<BillSch> list;



	public String getSteam() {
		return steam;
	}

	public void setSteam(String steam) {
		this.steam = steam;
	}

	public ArrayList<BillSch> getList() {
		return list;
	}

	public void setList(ArrayList<BillSch> list) {
		System.out.println();
		this.list = list;
	}

	public Integer getYear() {
		System.out.println("°ÙÀÌ¾î : "+year);
		return year;
	}

	public void setYear(Integer year) {
		System.out.println("¼ÂÀÌ¾î : "+year);
		this.year = year;
	}

	public Integer getMonth() {
		System.out.println("°Ù¸Õ½º : "+month);
		return month;
	}

	public void setMonth(Integer month) {
		System.out.println("¼Â¸Õ½º : "+month);
		this.month = month;
	}

	public Integer getDay() {
		System.out.println("°Ùµ¥ÀÌ : "+day);
		return day;
	}

	public void setDay(Integer day) {
		System.out.println("¼Âµ¥ÀÌ : "+day);
		this.day = day;
	}

	@Override
	public String toString() {
		return "BillSch [year=" + year + ", month=" + month + ", day=" + day + ", year2=" + year2 + ", month2=" + month2
				+ ", day2=" + day2 + ", steam=" + steam + ", list=" + list + "]";
	}

	
	
}
