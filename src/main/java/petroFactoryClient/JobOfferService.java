package petroFactoryClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Employee;
import persistence.JobOffer;
import services.JobOfferServiceRemote;
import utils.Role;


public class JobOfferService {
	public static void main(String[] args)throws NamingException{
		String jndiName="petroFactory-ejb/JobOfferService!services.JobOfferServiceRemote";
		Context context=new InitialContext();
		JobOfferServiceRemote proxy=(JobOfferServiceRemote) context.lookup(jndiName);
		List<JobOffer> users=proxy.findAllOffers();
		for (JobOffer us: users)
		{System.out.println(us.getPosition());}
}}
