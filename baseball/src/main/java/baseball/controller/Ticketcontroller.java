package baseball.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import baseball.model.TicketData;
import baseball.ticket.ResRepository;
import baseball.ticket.model.TicketResVo;
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
	
	TicketVo vo;
	TicketResVo resvo;
	
	String res = "test/test";
	
	
	@ModelAttribute("data")
	TicketData data(
			@PathVariable String service,
			TicketVo ticketVo, TicketResVo ticketres,
			HttpServletRequest request) {

		
		data.setRedirect(false);

		data.setService(service);
		data.setRequest(request);
		
		System.out.println(service+" + ");
		
		data.setDd(ticketVo);
		vo = (TicketVo)data.getDd();
		
		if(service.equals("payment")) {
			data.setDd(ticketres);
			resvo = (TicketResVo)data.getDd();
		}

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
				
			case "insertticket":
				mapping5();
				break;
			case "card":
				mapping6();
				break;
			case "card2":
				mapping7();
				break;
			case "card3":
				mapping8();
				break;
			case "payment":
				mapping9();
				break;
				
		}
		return data;

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

		System.out.println(vo);
		System.out.println("=================");
		reservation.insert(vo);
		
		res="test/card";
		return res;
	}
	
	String mapping6() {
		res = "test/card";
		System.out.println("매핑6! card!");
		return res;
	}
	
	String mapping7() {
		res = "test/card2";
		System.out.println("매핑7! card2!");
		return res;
	}
	
	String mapping8() {
		res = "test/card3";
		System.out.println("매핑8! card3!");
		return res;
	}

	String mapping9() {
		System.out.println("=================");
		reservation.paymentcomplete(resvo);
		reservation.comfirmpayment(resvo);
		return res;
	}
	
	

	@RequestMapping
    String ma() {
        if(data.isRedirect()) {    ////redirect에 따른 redirect or forward 선택
            res = data.getPath();
        }   
        return res;
    }
	

}
