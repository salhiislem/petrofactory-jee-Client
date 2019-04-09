package Delegate;

import java.util.List;

import Locator.ServiceLocator;
import persistence.JobOffer;
import services.JobOfferServiceRemote;


public class JobOfferServiceDelegate {
private static final String jndiName ="petroFactory-ejb/EmployeeService!services.EmployeeServiceRemote";
	
	private static JobOfferServiceRemote getProxy(){
		return (JobOfferServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	public static List<JobOffer> findAllOffers(){
		return getProxy().findAllOffers();
	}
}
