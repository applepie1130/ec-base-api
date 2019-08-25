package cj.api.service;

import org.springframework.stereotype.Service;

@Service
public class DailyPlanImpl implements PlanService {

	@Override
	public void getPlan() {
		System.out.println("Daily Supply Plan");
	}

}
