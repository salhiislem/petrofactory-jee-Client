package tn.esprit.petrofactory.petrofactory.presentation.mbeans;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.petrofactory.entity.Panier;
import tn.esprit.petrofactory.entity.Product;
import tn.esprit.petrofactory.petrofactory.services.PanierService;
import tn.esprit.petrofactory.petrofactory.services.ProductService;

@ManagedBean
@SessionScoped
public class ProductBean {
	private List<Product> productList;
	private List<Product> productbycategory;
	private List<Panier> PanierList;
	private List<String> categoryList;
	private String ca;
	long somme=0;
	long panier=0;
	@EJB
	ProductService productservice;
	@EJB
	PanierService panierservice;
	
	
	
	public ProductService getProductservice() {
		return productservice;
	}

	public void setProductservice(ProductService productservice) {
		this.productservice = productservice;
	}

	public List<Product> getProductList() {
		return productservice.getallProducts();
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getProductbycategory() {
		return productservice.getallProductsByCategory(ca);
	}

	public void setProductbycategory(List<Product> productbycategory) {
		this.productbycategory = productbycategory;
	}
	
	public String getCa() {
		return ca;
	}

	public void setCa(String ca) {
		this.ca = ca;
	}
	

	

	public long getSomme() {
		return somme;
	}

	public void setSomme(long somme) {
		this.somme = somme;
	}

	public String sum()
	{
	List<Long>	l=productservice.sommePrix(ca);
	somme=l.get(0);
	return "afficherProduit?faces-redirect=true";
	}

	public List<Panier> getPanierList() {
		return panierservice.getAllproduct();
	}

	public void setPanierList(List<Panier> panierList) {
		PanierList = panierList;
	}
	public void addpanier(Product p)
	{
		Panier pa=new Panier(p.getNom(), p.getPrix());
		panierservice.ajouter(pa);
	}
	public String fpanier()
	{List<Long>	l=panierservice.sommePrix();
	panier=l.get(0);
		return "ajout?faces-redirect=true";
		
	}

	public long getPanier() {
		return panier;
	}

	public void setPanier(long panier) {
		this.panier = panier;
	}

	public PanierService getPanierservice() {
		return panierservice;
	}

	public void setPanierservice(PanierService panierservice) {
		this.panierservice = panierservice;
	}

	public List<String> getCategoryList() {
		return productservice.getallCategory();
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}
	
}
