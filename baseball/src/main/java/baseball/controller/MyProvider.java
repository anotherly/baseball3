package baseball.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyProvider implements ApplicationContextAware {
	////// spring Container 실행시 자동으로 호출 됨
	//// context를 얻을 수 있음
	/// Bean으로 등록 하여 접근하여

	ApplicationContext context;

	public ApplicationContext getContext() {
		return context;
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("spring container 실행시 작동");
		context = arg0;

	}

}
