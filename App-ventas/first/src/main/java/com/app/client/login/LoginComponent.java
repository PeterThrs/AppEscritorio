package com.app.client.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.app.client.vistaPrincipal.VistaPrincipalComponent;

import lombok.Data;

@Data
public class LoginComponent implements ActionListener {

    private LoginTemplate loginTemplate;
    private VistaPrincipalComponent vistaPrincipal;

    public LoginComponent() {
        this.loginTemplate = new LoginTemplate(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginTemplate.getBEntrar()) {
            this.mostrarDatosUsuario();
            this.entrar();
        }

        if (e.getSource() == loginTemplate.getBOpcion1()) {
            JOptionPane.showMessageDialog(null, "Boton Opcion", "Advertencia", 1);
        }
        if (e.getSource() == loginTemplate.getBRegistrarse()) {
            JOptionPane.showMessageDialog(null, "Boton Registro", "Advertencia", 1);
        }

        if (e.getSource() == loginTemplate.getBCerrar()) {
            System.exit(0);
        }

    }

    public void mostrarDatosUsuario() {
        String nombreUsuario = loginTemplate.getTNombreUsuario().getText();
        String claveUsuario = new String(loginTemplate.getTClaveUsuario().getPassword());
        String tipoUsuario = ((String) loginTemplate.getCbTipoUsuario().getSelectedItem());
        String check = "";
        if (loginTemplate.getCheckSi().isSelected()) {
            check = "si";
        }
        if (loginTemplate.getCheckNo().isSelected()) {
            check = "no";
        }

        // Dentro del método mostrarDatosUsuario
        JOptionPane.showMessageDialog(
                null,
                "Nombre Usuario: " + nombreUsuario +
                        "\n Clave Usuario: " + claveUsuario +
                        "\nTipo Usuario: " + tipoUsuario +
                        "\n¿Notificaciones?: " + check,
                "Advertencia",
                1);
    }

    public void entrar() {
        if(vistaPrincipal == null){
            this.vistaPrincipal = new VistaPrincipalComponent(this);
        } else {
            this.vistaPrincipal.getVistaPrincipalTemplate().setVisible(true);
        }
        loginTemplate.setVisible(false);
    }

}
