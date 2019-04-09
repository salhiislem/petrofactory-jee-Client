package petroFactoryClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.JobRequest;
import services.JobRequestServiceRemote;
import utils.Degree;

public class JobRequestService {
	public static void main(String[] args)throws NamingException{
		String jndiName="petroFactory-ejb/JobRequestService!services.JobRequestServiceRemote";
		Context context=new InitialContext();
		JobRequestServiceRemote proxy=(JobRequestServiceRemote) context.lookup(jndiName);
		JobRequest job=proxy.findJobRequestById(1);
		System.out.println(job.getNote());
		int nb=proxy.numberSkillsApproved(job);
		System.out.println(nb);

		//int nb=proxy.countYearExperience(job);
		//System.out.println(nb);
		//int i=proxy.findDegreeIndex(Degree.Expert);
		//System.out.println(i);
		//System.out.println("jobRequest".indexOf("Request"));
}
	}
