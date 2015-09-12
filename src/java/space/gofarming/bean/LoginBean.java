/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space.gofarming.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author aida
 */
@ManagedBean
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
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

    public String login() {
        if (username.length() == 0 || password.length() == 0) {
            FacesContext.getCurrentInstance()
                    .addMessage(null, new FacesMessage("Введите пользовательские данные."));
            return null;
        }
        if (username.equals("farmer")) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
//            session.setAttribute("currentUser", user);
//            session.setMaxInactiveInterval(300);
            return "farmer?faces-redirect=true";
        } else if (username.equalsIgnoreCase("buyer")) {
            return "buyer?faces-redirect=true";
        } else if (username.equalsIgnoreCase("admin")) {
            return "admin?faces-redirect=true";
        }
        return null;

    }

    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        session.invalidate();
        return "index?faces-redirect=true";
    }
}
