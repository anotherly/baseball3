package baseball.model;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Component
public class TicketData {

	String service, path;
	
	Object dd;
	
	
	boolean redirect;
	
	HttpServletRequest request;
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	

	public Object getDd() {
		return dd;
	}

	public void setDd(Object dd) {
		this.dd = dd;
	}

	

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "TicketData service=" + service + ", path=" + path + ", dd=" + dd + ", redirect="
				+ redirect + ", request=" + request + "]";
	}
	
	
}
