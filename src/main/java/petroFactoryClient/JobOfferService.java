package petroFactoryClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Employee;
import persistence.JobOffer;
import persistence.JobRequest;
import persistence.Skills;
import services.JobOfferServiceRemote;
import services.JobRequestServiceRemote;
import services.SkillsServiceRemote;
import utils.Role;


public class JobOfferService {
	
	public static void main(String[] args)throws NamingException{
		String jndiName1="petroFactory-ejb/SkillsService!services.SkillsServiceRemote";
		Context context1=new InitialContext();
		SkillsServiceRemote proxy1=(SkillsServiceRemote) context1.lookup(jndiName1);

		String jndiName="petroFactory-ejb/JobOfferService!services.JobOfferServiceRemote";
		Context context=new InitialContext();
		JobOfferServiceRemote proxy=(JobOfferServiceRemote) context.lookup(jndiName);
		JobOffer job=proxy.findOfferById(1);
System.out.println(job.getPosition());
String jndiName2="petroFactory-ejb/JobRequestService!services.JobRequestServiceRemote";
Context context2=new InitialContext();
JobRequestServiceRemote proxy2=(JobRequestServiceRemote) context2.lookup(jndiName2);

		List<JobRequest> jobs=proxy2.findByJobOffer(job);
		for (JobRequest us: jobs)
		{System.out.println(us.getCin());}
		proxy2.adjustJobRequestBYOffer(job);
	List<JobRequest> l=proxy2.findALL();
		for(JobRequest of:l)
		{
			System.out.println(of.getNbOfapprouvedSkills());
		}
}}
