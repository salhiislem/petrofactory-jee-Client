package Delegate;

import java.util.List;

import Locator.ServiceLocator;
import persistence.JobOffer;
import persistence.JobRequest;
import services.JobRequestServiceRemote;

public class JobRequestServiceDelegate {
private static final String jndiName ="petroFactory-ejb/JobRequestService!services.JobRequestServiceRemote";
	
	private static JobRequestServiceRemote getProxy(){
		return (JobRequestServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}
	public static List<JobRequest> findByJobOffer(JobOffer job)
	{
		return getProxy().findByJobOffer(job);
	}
	public static List<JobRequest> findALL()
	{
		return getProxy().findALL();
	}
	public static void adjustJobRequestBYOffer(JobOffer job)
	{
		 getProxy().adjustJobRequestBYOffer(job);
	}
	public static List<JobRequest> SortBySkill()
	{
		return getProxy().SortBySkill();
	}
	public static List<JobRequest> SortByEXP()
	{
		return getProxy().SortByEXP();
	}
	public static void updateJob(JobRequest job)
	{
		getProxy().updateJob(job);
	}
	public static int countYearExperience(JobRequest jobRequest)
	{
		return getProxy().countYearExperience(jobRequest);
	}
}
