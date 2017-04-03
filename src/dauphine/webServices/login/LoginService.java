package dauphine.webServices.login;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

import dauphine.webServices.entity.Personne;
import dauphine.webServices.service.PersonneService;



@ManagedBean
public class LoginService {

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {
		RequestContext context = RequestContext.getCurrentInstance();
		FacesMessage message = null;
		boolean loggedIn = false;
		PersonneService P = new PersonneService();
		List<Personne> p = P.getByName(username, password);

		if (!p.isEmpty()) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
			session.setAttribute("username", username);
			session.setAttribute("prenom", p.get(0).getPrenom());
			session.setAttribute("nom", p.get(0).getNom());
			session.setAttribute("id", p.get(0).getId());
			loggedIn = true;
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenu",
					p.get(0).getPrenom() + " " + p.get(0).getNom());
		} else {
			loggedIn = false;
			message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erreur", "Login erronés");
		}

		FacesContext.getCurrentInstance().addMessage(null, message);
		context.addCallbackParam("loggedIn", loggedIn);
		

	}
}