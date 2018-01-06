package baseball.ticket;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import baseball.ticket.model.TicketResVo;
import baseball.ticket.model.TicketVo;

@Service
public class ResRepository {

	@Resource
	SqlSessionTemplate template;
	
	public void insert(TicketVo vo) {
		template.insert("ticket.insertOne",vo);
	}
	
	public void paymentcomplete(TicketResVo vo) {
		template.insert("ticket.payment",vo);
	}

	public void comfirmpayment(TicketResVo vo) {
		template.update("ticket.comfirm",vo);
	}
	
	public List<String> reserved(){
		return template.selectList("ticket.selectform");
	}
}
