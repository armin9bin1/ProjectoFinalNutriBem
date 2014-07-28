
package com.mycompany.myapp.view;

import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.myapp.controller.CenterLayout;

/**
 *
 * @author user
 */
public class MenuPrincipal extends Form implements ActionListener{
    private Label lbImg;
    private ComponentGroup buttons;
    private Image img;
    private RadioButton consulta,ajuda,sair,acerca;
    private ActionListener listener;
    Container c1;
    public MenuPrincipal()
    { 
       super("NUTRIBEM");      
       setLayout(new CenterLayout());
       criaGui();
    }
    
    public void criaGui()
    {
        c1 = new Container(new BorderLayout()); 
        
        try{
            img = Image.createImage("/1.jpg");
        }
        catch(Exception e)
        {
        
        }
        
        lbImg = new Label("");
        lbImg.setIcon(img);
        
        
        buttons = new ComponentGroup();
        buttons.setElementUIID("ToggleButton");
        buttons.setHorizontal(false);
        
        consulta = new RadioButton("Consulta");
        ajuda = new RadioButton("Ajuda");
        sair = new RadioButton("Sair");
        acerca = new RadioButton("Leia - me");
        
        ButtonGroup bg = new ButtonGroup();
        
        initRb(bg, buttons, listener, consulta);
        initRb(bg, buttons, listener, ajuda);
        initRb(bg, buttons, listener, acerca);
        initRb(bg, buttons, listener, sair);
        
        ComponentGroup g = new ComponentGroup(); 
        Container centerFlow = new Container(new BorderLayout());
                
        
        centerFlow.addComponent(BorderLayout.CENTER,buttons);
        g.addComponent(centerFlow);
        
        c1.addComponent(BorderLayout.CENTER,g);
        c1.addComponent(BorderLayout.SOUTH,lbImg);
        
        this.addComponent(c1);
        
        //Animação
        this.revalidate();
        for(int iter = 0 ; iter < centerFlow.getComponentCount() ; iter++) {
           Component current = centerFlow.getComponentAt(iter);
           if(iter % 2 == 0) {
               current.setX(-current.getWidth());
           } else {
               current.setX(current.getWidth()); 
           }           
        }
        centerFlow.setShouldCalcPreferredSize(true);
        centerFlow.animateLayout(4000);
        
        
        consulta.addActionListener(this);
        ajuda.addActionListener(this);
        sair.addActionListener(this);
        acerca.addActionListener(this);
        
    }
    
    private void initRb(ButtonGroup bg, Container buttone, ActionListener listener,
        RadioButton rb) {
        bg.add(rb);
        rb.setToggle(true);
        buttone.addComponent(rb);
        rb.addActionListener(listener);
    }
    
    //Eventos
    public void actionPerformed(ActionEvent evento)
    { 
            if(evento.getSource() == sair)
            {
               System.exit(0);
            }
            if(evento.getSource() == consulta)
            {
                new ConsultaView().show();
            }
            if(evento.getSource() == ajuda)
            {
                Dialog.show("Info", "\nClique no botão consulta do menu\nPreencha os dados e clique em consultar\nAs Perguntas da consulta estão em três Abas \n1. Outro  \n2. Alimentação e \n3. Atividade Física.\n"
                  + "\nResponda todas as perguntas e clique em consultar.", "Ok", null);
    
            }
            if(evento.getSource() == acerca)
            {
                Dialog.show("Acerca de mim", "\nArmindo Conceição Gonçalves Binje\nestudante da Universidade Catóica de Angola \ndo 3º Ano 2014\n" , "Ok", null);
    
            }
    }     
}