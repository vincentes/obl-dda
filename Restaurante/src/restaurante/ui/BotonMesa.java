/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.ui;

import java.awt.Color;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import restaurante.dominio.Mesa;
import restaurante.dominio.Mesa.Evento;

/**
 *
 * @author vincentes
 */
public class BotonMesa extends JButton implements Observer {
    
    private final Mesa mesa;
    private static final Color COLOR_ABIERTA = new Color(182, 59, 89);
    private static final Color COLOR_CERRADA = new Color(59, 89, 182);

    public BotonMesa(Mesa mesa) {
        super(String.valueOf(mesa.getNumero()));
        this.mesa = mesa;
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setFont(new Font("Tahoma", Font.BOLD, 25));
        if(mesa.isAbierta()){
            setBackground(COLOR_ABIERTA);
        }else {
            setBackground(COLOR_CERRADA);
        }
    }

    public Mesa getMesa() {
        return mesa;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o.equals(mesa)) {
            Evento evt = (Evento) arg;
            switch(evt) {
                case TOGGLE:
                    if(mesa.getAbierta()) {
                        setBackground(COLOR_ABIERTA);
                    } else {
                        setBackground(COLOR_CERRADA);
                    }
                    break;
            }
        }
    }
}
