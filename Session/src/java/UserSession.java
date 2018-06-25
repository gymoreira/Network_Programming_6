
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yago
 */
public class UserSession implements Serializable{
    private String name;
    private String login;
    private String password;
    
    public UserSession(){
    }
    public UserSession(String name, String password){
        this.name = name;
        this.login=this.name;
        this.password = password;
    }
    public String getName() { 
        return name;
    }
    public String getLogin() { 
        return login;
    }
    public String getPassword() {
        return password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}