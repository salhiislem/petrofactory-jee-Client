package tn.esprit.petrofactory.petrofactory.presentation.mbeans;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.petrofactory.entity.Product;
import tn.esprit.petrofactory.entity.shop;
import tn.esprit.petrofactory.petrofactory.services.ProductService;
import tn.esprit.petrofactory.petrofactory.services.ShopService;


@ManagedBean
@SessionScoped
public class ShopBean {




public ShopService getShopservice() {
		return shopservice;
	}

	public void setShopservice(ShopService shopservice) {
		this.shopservice = shopservice;
	}

	
private List<shop> shopList;
	
	@EJB
	ShopService shopservice;
	
	public List<shop> getShop()
	
	{
		//List<shop> shopList=null;
		try{
		shopList=shopservice.getallShops();
		}
		catch(Exception e){
			Logger.getAnonymousLogger().info("probleeeme");
		}
		return shopList;
		
		
	}
	
	
	
	

	

	public List<shop> getShopList() {
		System.out.println("test bean :" );
		return shopservice.getallShops();
	}
	public void setShopList(List<shop> s) {
		this.shopList = s;
	}
	
	
}
