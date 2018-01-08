package baseball.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.model.TicketData;
import baseball.ticket.ResRepository;
import baseball.ticket.model.TicketVo;

@Controller
@RequestMapping("test/{service}")
public class Ticketcontroller{
	
	@Resource
	MyProvider provider;
	
	@Resource
	ResRepository reservation;
	
	@Resource
	TicketData data;
	
	TicketVo vo,vo2;
	
	String res = "test/test";
	
	
	@ModelAttribute("data")
	TicketData data(
			@PathVariable String service,
			TicketVo ticketVo,
			HttpServletRequest request) {
		
		data.setRedirect(false);

		data.setService(service);
		data.setRequest(request);
		
		System.out.println(service+" + ");
		
		data.setDd(ticketVo);
		
		vo = (TicketVo)data.getDd();
		
		
		
		switch (service) {
			case "list":
				mapping();
				break;
			case "ticket":
				mapping2();
				break;
				
			case "cnt":
				mapping3();
				break;
				
			case "checkTest":
				mapping4();
				break;
			case "card":
				data.setDd(ticketVo);
				vo2 = (TicketVo)data.getDd();
				mapping5();
				System.out.println(vo2.getReallist());
				break;
			case "insertticket":
				mapping6();
				System.out.println(vo2.getReallist());
				break;
				
			case "card2":
				mapping7();
				System.out.println(vo2.getReallist());
				break;
			case "card3":
			
				mapping8();
				System.out.println(vo2.getReallist());
				break;
/*			case "payment":
				mapping9();
				break;
				*/
			case "close":
				close();
				System.out.println(vo2.getReallist());
				break;
		}
		return data;

	}
	String close() {
		System.out.println(vo2.getReallist());
		res = "/test/close";
		return res;
	}
	
	String mapping() {
		res = "/test/grade";
		return res;
	}
	
	String mapping2() {
		res = "test/ticket";
		return res;
	}
	

	String mapping3() {
		data.setDd(reservation.reserved());
		res= "test/cnt";
		return res;
	}
	
	String mapping4() {
		res = "test/checkTest";
		return res;
	}
	

	String mapping5() {
		System.out.println(vo2.getReallist());
		res="test/card";
		return res;
	}
	
	String mapping6() {
		System.out.println(vo2.getReallist());
		System.out.println("매핑6! card!");
		reservation.insert(vo2);
		res="test/close";
		return res;
	}
	
	String mapping7() {
		System.out.println(vo2.getReallist());
		res = "test/card2";
		System.out.println("매핑7! card2!");
		return res;
	}
	
	String mapping8() {
		System.out.println(vo2.getReallist());
		res = "test/card3";
		System.out.println("매핑8! card3!");
		return res;
	}

	/*String mapping9() {
		System.out.println("=================");
		reservation.insert(vo);
		data.setRedirect(true);
		data.setPath("redirect:close");
		return res;
	}*/

	@RequestMapping
    String ma() {
        if(data.isRedirect()) {    ////redirect에 따른 redirect or forward 선택
            res = data.getPath();
        }   
        return res;
    }
	

}
