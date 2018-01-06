package baseball.model;

public class Menu {

	String name, korName, url;//이름, 한글로 서브메뉴에 실제 표기되는거, url 주소
	
	public Menu() {
		// TODO Auto-generated constructor stub
	}

	
	public Menu(String name, String korName, String url) {
		super();
		this.name = name;
		this.korName = korName;
		this.url = url;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
