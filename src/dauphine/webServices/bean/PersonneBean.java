/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dauphine.webServices.bean;

import com.sun.faces.el.ELUtils;

import dauphine.webServices.entity.Personne;
import dauphine.webServices.service.PersonneService;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.mail.internet.MailDateFormat;

import org.jboss.weld.SimpleCDI;

/**
 *
 * @author 
 */
@ManagedBean
@SessionScoped
public class PersonneBean implements Serializable {

	private Personne personne;
	
	private PersonneService sp;
	private List<Personne> presonnes;

	private String poste;
	/**
	 * Creates a new instance of PersonneBean
	 */
	public PersonneBean() {
		personne = new Personne();
		sp = new PersonneService();
		presonnes = new ArrayList<>();
	}

	public PersonneBean(Personne personne, String poste, PersonneService sp) {
		this.personne = personne;
		this.poste = poste;
		this.sp = sp;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	



	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public PersonneService getSp() {
		return sp;
	}

	public void setSp(PersonneService sp) {
		this.sp = sp;
	}





	public void setPresonnes(List<Personne> personnes) {
		this.presonnes = personnes;
	}

	public List<Personne> getPresonnes() {
		if (presonnes != null) {
			presonnes = sp.getAll();
		}
		return presonnes;
	}

	public String onSave() {
		personne.setNom(personne.getNom().toUpperCase());
		personne.setPrenom(personne.getPrenom().substring(0, 1).toUpperCase() + ""
				+ personne.getPrenom().substring(1).toLowerCase());
		sp.create(personne);
		return "Login";

	}

	public String onDelete(int id) {
		sp.delete(sp.getById(id));
		return "ListePrs";
	}

	public String onUpdate() {

		personne.setPoste(poste);
		sp.update(personne);
		return "ListePrs";
	}

	public String onSelect(int id) {
		personne = sp.getById(id);
		return "update";
	}

	public String onCreate() {
		personne.setNom(personne.getNom().toUpperCase());
		personne.setPrenom(personne.getPrenom().substring(0, 1).toUpperCase() + ""
				+ personne.getPrenom().substring(1).toLowerCase());

		personne.setPoste(poste);

		return "validate";
	}
}
