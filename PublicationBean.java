package tn.esprit.petrofactory.petrofactory.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import tn.esprit.petrofactory.entity.Publication;
import tn.esprit.petrofactory.entity.SendingMail;
import tn.esprit.petrofactory.petrofactory.services.PublicationService;

@ManagedBean
@SessionScoped
public class PublicationBean {
private String sujet;
private String text;

private List<Publication> pubList;
public String getSujet() {
	return sujet;
}
public void setSujet(String sujet) {
	this.sujet = sujet;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
@EJB
PublicationService publicationservice;
public PublicationService getPublicationservice() {
	return publicationservice;
}
public void setPublicationservice(PublicationService publicationservice) {
	this.publicationservice = publicationservice;
}

public void addEmloye()
{
	publicationservice.ajouter(new Publication(sujet, text));
}
public List<Publication> getPubList() {
	return publicationservice.getallProducts();
}
public void setPubList(List<Publication> pubList) {
	this.pubList = pubList;
}
public void supprimer(Integer id)
{
	publicationservice.supprimerProduct(id);
}
public void sendMail()
{
SendingMail s = new SendingMail();
s.envoyer("ccddddd",text);
}
}
