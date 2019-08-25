package cj.api.service;

import org.springframework.stereotype.Service;

@Service
public class LeadTimePlanImpl implements PlanService {

	@Override
	public void getPlan() {
		System.out.println("Leadtime Supply Plan");
	}

}
