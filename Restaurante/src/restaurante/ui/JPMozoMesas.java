/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurante.ui;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import restaurante.dominio.Mesa;

/**
 *
 * @author vincentes
 */
public class JPMozoMesas extends JPanel {
    
    private ActionListener listener;
    
    public void setListener(ActionListener listener) {
        this.listener = listener;
    }
    
    public void mostrar(ArrayList<Mesa> mesas, int cols){
        removeAll();
        if(cols > mesas.size()) {
            cols = mesas.size();
        }
        setLayout(new GridLayout(0, cols));
        for(Mesa m : mesas){
            BotonMesa b = new BotonMesa(m);
            b.addActionListener(listener);
            m.addObserver(b);
            add(b);
        }
        validate();
    }
}
