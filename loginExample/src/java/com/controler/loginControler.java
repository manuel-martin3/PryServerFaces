package com.controler;
import com.query.dataQuery;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.primefaces.context.RequestContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@ManagedBean(name="login")
@SessionScoped
public class loginControler implements Serializable {
    
    private String username;
    private String password;
    private dataQuery query = new dataQuery();
    
    public String loginControl(){
        if (query.logincontrol(username, password)) {
            return "home.xhtml?faces-redirect=true";
        }        
        RequestContext.getCurrentInstance().update("growl");     
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Usuario o Password no validos... Intenta nuevamente"));
        return "";
    }
    
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
}
