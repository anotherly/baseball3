package baseball.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import baseball.member.model.MemberVo;

@Alias("boa2")
@Component
public class PathData {

	String cate1, cate2, service, path, serviceTemp, cate1Temp;
	
	Object dd,dd2;

	ArrayList<Menu> topMenu, subMenu, topMenu2, subMenu2, loginMenu, managerMenu;

	HttpServletRequest request;
	
	boolean redirect;//현재 로그인한 사용자가 관리자인지 아닌지 판단여부
	
	public Object getDd2() {
		return dd2;
	}

	public void setDd2(Object dd2) {
		this.dd2 = dd2;
	}

	public String getServiceTemp() {
		return serviceTemp;
	}

	public void setServiceTemp(String serviceTemp) {
		this.serviceTemp = serviceTemp;
	}

	public String getCate1Temp() {
		return cate1Temp;
	}

	public void setCate1Temp(String cate1Temp) {
		this.cate1Temp = cate1Temp;
	}

	public ArrayList<Menu> getTopMenu2() {
		return topMenu2;
	}

	public void setTopMenu2(ArrayList<Menu> topMenu2) {
		this.topMenu2 = topMenu2;
	}

	public ArrayList<Menu> getSubMenu2() {
		return subMenu2;
	}

	public void setSubMenu2(ArrayList<Menu> subMenu2) {
		this.subMenu2 = subMenu2;
	}

	public ArrayList<Menu> getManagerMenu() {
		return managerMenu;
	}

	public void setManagerMenu(ArrayList<Menu> managerMenu) {
		this.managerMenu = managerMenu;
	}

	public ArrayList<Menu> getLoginMenu() {
		return loginMenu;
	}

	public void setLoginMenu(ArrayList<Menu> loginMenu) {
		this.loginMenu = loginMenu;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public ArrayList<Menu> getTopMenu() {
		return topMenu;
	}

	public void setTopMenu(ArrayList<Menu> topMenu) {
		this.topMenu = topMenu;
	}

	public ArrayList<Menu> getSubMenu() {
		return subMenu;
	}

	public void setSubMenu(ArrayList<Menu> subMenu) {
		this.subMenu = subMenu;
	}

	public Object getDd() {
		return dd;
	}

	public void setDd(Object dd) {
		this.dd = dd;
	}

	public String getCate1() {
//		System.out.println("패스데이타 클래스 의 getCate1값 : "+cate1);
		return cate1;
	}

	public void setCate1(String cate1) {
		this.cate1 = cate1;
//		System.out.println("패스데이타 클래스 의 setCate1값 : "+cate1);
	}

	public String getCate2() {
		return cate2;
	}

	public void setCate2(String cate2) {
		this.cate2 = cate2;
	}

	public String getService() {
//		System.out.println("패스데이터의 getservice : "+service);
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "PathData [cate1=" + cate1 + ", cate2=" + cate2 + ", service=" + service + "]";
	}

}
