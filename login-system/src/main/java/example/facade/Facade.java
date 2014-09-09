package example.facade;

import example.common.spring.SpringContext;
import example.facade.membership.MembershipManager;

public class Facade {

	public static MembershipManager getMembershipManager() {
		return SpringContext.getContext().getBean(MembershipManager.class);
		
	}
}
