/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.controller;

import ec.edu.espe.distribuidas.ejb.PeempEmpleaFacadeLocal;
import ec.edu.espe.distribuidas.model.PeempEmplea;
import ec.edu.espe.distribuidas.model.XeusuUsuar;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import ec.edu.espe.distribuidas.ejb.XeusuUsuarFacadeLocal;

@Named
@ViewScoped
public class loginController implements Serializable {

    @EJB
    private PeempEmpleaFacadeLocal empleadoEJB;
    @EJB
    private XeusuUsuarFacadeLocal usuarioEJB;

    private String username;
    private String password;

    @PostConstruct
    public void init() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String iniciarSesion() {
        PeempEmplea empleado;
        String redireccion = null;
        try {
            empleado = empleadoEJB.findXCedula(username);
            if (empleado != null) {
                //Verificar Contrasenia
                XeusuUsuar usuario;
                usuario = usuarioEJB.findXCodPersona(empleado.getPeempCodigo());
                if (usuario != null) {
                    if (encryptPassword(password).equals(usuario.getXeusuPasswo())) {
                        //Almacenar en la sesion de JSF
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Nombre", empleado.getPeempNombre() + " " + empleado.getPeempApelli());
                        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
                        redireccion = "protegido/Bienvenida/principal?faces-redirect=true";
                    }else{
                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Contraseña incorrecta."));
                        password="";
                    }

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Todavía no a sido asignado un usuario a su cuenta."));
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario incorrecto"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Problemas de conexion"));
        }
        return redireccion;
    }

    private static String encryptPassword(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        String result;
        try (Formatter formatter = new Formatter()) {
            for (byte b : hash) {
                formatter.format("%02x", b);
            }
            result = formatter.toString();
        }
        return result;
    }

}
