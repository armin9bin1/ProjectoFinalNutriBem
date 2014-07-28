
package com.mycompany.myapp.view;

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

/**
 *
 * @author Armindo Binje
 */
public class ResultadoObesos1 extends Form implements Runnable{
    private Thread t;
    private volatile boolean running;
    private Button btSair,btdown;
    private String recomendacoes[];
    private String nome;
    private float imc;
    private Image img;
    private Container c1;
    Graphics g2;
    static final int FPS = 24;
    
    public ResultadoObesos1(String rec[], String nome, float imc)
    {
        this.recomendacoes = rec;
        this.nome = nome;
        this.imc = imc;
        t = new Thread(this);
        t.start();
        criaGui();
    }
    
    public void init() {
        running = true;
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
       
       g.setColor(0xCD5C5C);
       g.drawRect(10, 100, 300, 370);
       
       for(int i = 0; i <= 26; i++)
       {
            g.setColor(0x0A00FF);
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
            init();
            while( running ) 
            {
                repaint();
            
               try {
                Thread.sleep(1000 / FPS);
               } catch (InterruptedException ex) {
                ex.printStackTrace();
               }
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
                   new ResultadoObesos1_1(recomendacoes,nome,imc).show();
                }
        }
    }
}
