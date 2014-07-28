
package com.mycompany.myapp.view;

/**
 *
 * @author Armindo Binje
 */

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.Insets;

public class ResultadoMagros1_1 extends Form implements Runnable{
    private Thread t;
    private volatile boolean running;
     private Button btSair,btup;
    private String recomendacoes[];
    private String nome;
    private float imc;
    private Image img;
    private Container c1;
    Graphics g2;
    
    public ResultadoMagros1_1(String rec[], String nome, float imc)
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
       
       g.setColor(0x0000FF);
       g.drawRect(10, 100, 300, 370);
       
       for(int i = 25; i < recomendacoes.length; i++)
       {
            g.setColor(0xFF7F00);
            g.drawString(recomendacoes[i], 15, y);
            y += 13;
       }
    }
    
    public void criaGui()
    {
        c1 = new Container(new GridBagLayout());
        
        TrataEventos ev = new TrataEventos();
        
        try{
            img = Image.createImage("/up.png");
        }
        catch(Exception e)
        {
        
        }
        
        btup = new Button("Subir                 ");
        btup.setIcon(img);
        btup.addActionListener(ev);
        
        btSair = new Button("Sair");   
        try{
            btSair.setIcon(Image.createImage("/Cancelar.png"));
       }
       catch(Exception e){  }
        btSair.addActionListener(ev);
        
        c1.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(410,285,5,5),0,0),btup);
        c1.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-895,-342,5,5),0,0),btSair);       
        
        this.addComponent(c1); 
    }
    
    public void run() 
    {
            while( running ) 
            {
                repaint();
             //   g2.setColor(0x00FF00);
               // g2.drawString("Mete Bem", 120, 200);
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
                if(evento.getSource() == btup)
                {
                    new ResultadoMagros(recomendacoes, nome, imc).show(); 
                }
        }
    }
}
