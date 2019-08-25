package cj.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
	
//	@Autowired
//	private ApplicationContext context;
//	
//	@Override
//	public void getService() {
//		
//		PlanService service = context.getBean(DailyPlanImpl.class);
//		service.getPlan();
//		
//		service = context.getBean(LeadTimePlanImpl.class);
//		service.getPlan();
//	}
	
	@Autowired private AutowireCapableBeanFactory beanFactory;

	@Override
	public void getService() {
		beanFactory.getBean(LeadTimePlanImpl.class).getPlan();
		beanFactory.getBean(DailyPlanImpl.class).getPlan();
	} 
}
