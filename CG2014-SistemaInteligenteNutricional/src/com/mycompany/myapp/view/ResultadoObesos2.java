
package com.mycompany.myapp.view;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.Insets;

/**
 * @author Armindo Binje
 */

public class ResultadoObesos2 extends Form implements Runnable{
  
    private Thread t;
    private volatile boolean running;
    private Button btSair,btdown;
    private String recomendacoes[];  
    private Image img;
    private Container c1;
    private String nome;
    private float imc;
    
    public ResultadoObesos2(String rec[], String nome, float imc)
    {
        this.recomendacoes = rec;
        this.nome = nome;
        this.imc = imc;
        t = new Thread(this);
        t.start();
         running = true;
        criaGui();
    }
    
    public void paint(Graphics g)
    {
       super.paint(g);
        
       int y = 100;  
        
       g.setColor(0xADFF2F);
       g.drawString("NUTRIBEM", 100, 40);
              
       g.setColor(0xD2691E);
       g.drawString("NOME: "+nome, 80, 60);
       g.drawString("IMC: "+imc, 80, 80);
       
       g.setColor(0xBBFFFF);
       g.drawRect(10, 100, 300, 370);
       
       for(int i = 0; i <= 26; i++)
       {
            g.setColor(0xD02090);
            g.drawString(recomendacoes[i], 15, y);
            y += 13;
       }
    }
    public void criaGui()
    {
        c1 = new Container(new GridBagLayout());
        
        TrataEventos ev = new TrataEventos();
        
        try{
            img = Image.createImage("/down.png");
        }
        catch(Exception e)
        {
        
        }
        
        btdown = new Button("Descer                 ");
        btdown.setIcon(img);
        btdown.addActionListener(ev);
        
        btSair = new Button("Sair");       
        try{
            btSair.setIcon(Image.createImage("/Cancelar.png"));
       }
       catch(Exception e){  }
        btSair.addActionListener(ev);
        
        c1.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(410,285,5,5),0,0),btdown);
        c1.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-895,-342,5,5),0,0),btSair);
                 
        this.addComponent(c1); 
    }
    
    public void run() 
    {
            while( running ) 
            {
                repaint();
            }
    }
    
    //Eventos
    private class TrataEventos implements ActionListener
    {
        public void actionPerformed(ActionEvent evento)
        { 
                if(evento.getSource() == btSair)
                {
                   new MenuPrincipal().show();
                }
                if(evento.getSource() == btdown)
                {
                   new ResultadoObesos2_2(recomendacoes,nome,imc).show();
                }
        }
    }
}
