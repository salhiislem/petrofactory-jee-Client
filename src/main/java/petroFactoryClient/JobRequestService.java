package petroFactoryClient;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import persistence.Employee;
import persistence.JobRequest;
import persistence.Skills;
import services.JobRequestServiceRemote;
import services.SkillsServiceRemote;
import utils.Degree;

public class JobRequestService {
	public static void main(String[] args)throws NamingException{
		String jndiName="petroFactory-ejb/JobRequestService!services.JobRequestServiceRemote";
		Context context=new InitialContext();
		JobRequestServiceRemote proxy=(JobRequestServiceRemote) context.lookup(jndiName);
		JobRequest job=proxy.findJobRequestById(1);
		System.out.println(job.getNote());
		//int nb=proxy.numberSkillsApproved(job);
		//System.out.println(nb);
		
		
		
		
		String jndiName1="petroFactory-ejb/SkillsService!services.SkillsServiceRemote";
		Context context1=new InitialContext();
		SkillsServiceRemote proxy1=(SkillsServiceRemote) context1.lookup(jndiName1);
		int s=proxy1.numberSkillsApproved(job);
		System.out.println(s);
		//for (Skills us: users)
		//{System.out.println(us.getDescription());}

		//int nb=proxy.countYearExperience(job);
		//System.out.println(nb);
		//int i=proxy.findDegreeIndex(Degree.Expert);
		//System.out.println(i);
		//System.out.println("jobRequest".indexOf("Request"));
}
	}
