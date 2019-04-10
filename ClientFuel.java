package esprit.petrofactory.interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.petroFact.entity.Fuel;
import tn.esprit.petroFact.entity.GasPump;
import tn.esprit.petroFact.entity.PumpMeter;
import tn.esprit.petroFact.entity.Pumpman;
import tn.esprit.petroFact.entity.Report;
import tn.esprit.petroFact.services.FuelServiceRemote;



public class ClientFuel {

	public static void main(String[] args) throws NamingException, InterruptedException, ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		String dateString = format.format( new Date() ); 
		Date date = format.parse ( "2009-12-31" );
		
		String jndiName="petroFactory-ejb/FuelService!tn.esprit.petroFact.services.FuelServiceRemote";
		
		Context context = new InitialContext();
		
		FuelServiceRemote proxy=(FuelServiceRemote) context.lookup(jndiName);
		Fuel f= new Fuel(); 
		GasPump g= new GasPump();
		PumpMeter pm = new PumpMeter();
		List<Fuel> j;
		Report r= new Report();
		//proxy.ajouterFuel(f);
		//proxy.updateFuel((float)50,4);
		//proxy.deleteFuel(3);
		//proxy.ajouterGas(g);
		//proxy.deleteGas(4);
		//proxy.updateGas(150, 4);
		//proxy.ajouterPump(pm);
		//proxy.deletePump(5);
		//proxy.updatePump(17, 6);
		//proxy.affecterPm(7, 9);
		//proxy.affecterPmToPm(7, 1);
	
		//System.out.println(proxy.NumGas());		
		/*System.out.println(proxy.getPm(7));
		for(PumpMeter pm : g.getPumpmeters()){
			System.out.println(pm.getIdPM());
		}
		*/
		/*List<PumpMeter> k;
		k= proxy.pms();
		for(int i=0;i<k.size();i++)
		{
			System.out.println(k.get(i));
		}
		*/
		//proxy.ajouterRep(r);
		/*proxy.updateD(format.parse("2020-10-25"), 2);
		proxy.updatefA(20f, 2);
		proxy.updateiA(50f, 2);
		proxy.updategain(17.8, 2);*/
		/*List<String> k = proxy.tpm();
		for(int i=0;i<k.size();i++)
		{
			System.out.println(k.get(i));
		}
		//proxy.deleteRep(2);
		//System.out.println(proxy.calculFuel(5));
		/*List list = proxy.gaspumps();
		System.out.println(list);
		*/
		//System.out.println(proxy.Total("essence",(float) 20));
		
		
		//.out.println(proxy.Show("gasoil"));
		//System.out.println(proxy.Amount(3));
		//proxy.updateSystem(80, 2);
		//proxy.IdGas("del");
		
		//System.out.println(proxy.Show("gasoil"));
		
		List<Report> k = proxy.ReportByType("gasoil");
		for(int i=0;i<k.size();i++)
		{
			System.out.println(k.get(i));
		}
		//System.out.println(proxy.AmountSold("essence"));
	}
}