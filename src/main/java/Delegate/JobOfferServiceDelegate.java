package Delegate;

import java.util.List;

import Locator.ServiceLocator;
import persistence.JobOffer;
import services.JobOfferServiceRemote;


public class JobOfferServiceDelegate {
private static final String jndiName ="petroFactory-ejb/JobOfferService!services.JobOfferServiceRemote";
	
	private static JobOfferServiceRemote getProxy(){
		return (JobOfferServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	public static List<JobOffer> findAllOffers(){
		return getProxy().findAllOffers();
	}
	public static JobOffer findOfferById(int id)
	{
		return getProxy().findOfferById(id);
	}
}
