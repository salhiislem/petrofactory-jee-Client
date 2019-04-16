package Delegate;

import Locator.ServiceLocator;
import persistence.JobRequest;
import services.SkillsServiceRemote;

public class SkillsServiceDelegate {
private static final String jndiName ="petroFactory-ejb/SkillsService!services.SkillsServiceRemote";
	
	private static SkillsServiceRemote getProxy(){
		return (SkillsServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	public static int numberSkillsApproved(JobRequest jobRequest){
		return getProxy().numberSkillsApproved(jobRequest);
	}
}
