
package com.mycompany.myapp.view;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.Insets;

/**
 *
 * @author Armindo Binje
 */
public class ConsultaObesos2 extends Form implements ActionListener{
    private Tabs tb;
    private Container c1,c2,c3,botoes;
    private Label lbalim1,lbalim2,lbalim3,lbalim4,lbalim5,lbalim6,lbalim7,lbalim8;
    private Label lbafisic1,lbafisic2,lbafisic3,lbafisic4,lbafisic5,lbafisic6,lbafisic7,lbafisic8;
    private Label lboutro1;
    private RadioButton rbalim1,rbalim11,rbalim2,rbalim21,rbalim3,rbalim31,rbalim32,rbalim4,rbalim41,rbalim42;
    private RadioButton rbalim5,rbalim51,rbalim6,rbalim61,rbalim62,rbalim7,rbalim71,rbalim72,rbalim8,rbalim81,rbalim82;
    private RadioButton rbfisic1,rbfisic11;
    private RadioButton rboutr1,rboutr2;
    private ButtonGroup groupalim1,groupalim2,groupalim3,groupalim4,groupalim5,groupalim6,groupalim7,groupalim8;
    private ButtonGroup gropoutr1;
    private ButtonGroup gropfisic1;
    private Button btVer,btSair;
    private RadioButton rbfisic2;
    private RadioButton rbfisic21;
    private ButtonGroup gropfisic2,gropfisic3;
    private RadioButton rbfisic3;
    private RadioButton rbfisic31;
    private RadioButton rbfisic32;
    private RadioButton rbfisic4;
    private RadioButton rbfisic41;
    private ButtonGroup gropfisic4;
    private RadioButton rbfisic5;
    private RadioButton rbfisic51;
    private RadioButton rbfisic52;
    private ButtonGroup gropfisic5;
    private RadioButton rbfisic6;
    private RadioButton rbfisic61;
    private ButtonGroup gropfisic6;
    private RadioButton rbfisic7;
    private RadioButton rbfisic71;
    private ButtonGroup gropfisic7;
    private RadioButton rbfisic8;
    private RadioButton rbfisic81;
    private RadioButton rbfisic82;
    private ButtonGroup gropfisic8;
    private final int MAX = 1000; 
    private String recomendacao[] = new String [MAX];
    private int valor = 0;
    private String nome;
    private float IMC;
    public ConsultaObesos2(String nome, float imc)
    {     
       criaGui();
       setTitle(" Seja Bem Vindo(a) a Consulta para Obesos");
       inicializarVector(recomendacao);
       this.nome = nome;
       this.IMC = imc;
    }
    
    public void criaGui()
    {      
        //Alimentação
        c1 = new Container(new GridBagLayout()); 
        lbalim1 = new Label(" Tomas sempre o pequeno almoço? ");
        rbalim1 = new RadioButton(" a) Sim ");
        rbalim11 = new RadioButton(" b) Não ");
        lbalim2 = new Label(" Saltas algumas refeições?         ");
        rbalim2 = new RadioButton(" a) Sim ");
        rbalim21 = new RadioButton(" b) Não ");
        lbalim3 = new Label(" Comeste - q o normal nos últimos 3 mes?");
        rbalim3 = new RadioButton(" a) redução severa" );
        rbalim31 = new RadioButton(" b) redução moderada ");
        rbalim32 = new RadioButton(" c) não houve redução ");
        lbalim4 = new Label(" Quanto peso você acha que perdeu? ");
        rbalim4 = new RadioButton(" a) superior a 3 kg" );
        rbalim41 = new RadioButton(" b) não sei  ");
        rbalim42 = new RadioButton(" c) nenhuma perda de peso");
        lbalim5 = new Label(" Incluis nas refeições alimentos variados?");
        rbalim5 = new RadioButton(" a) Sim " );
        rbalim51 = new RadioButton(" b) Não ");
        lbalim6 = new Label(" Você costuma ler o rótulo dos alimentos?");
        rbalim6 = new RadioButton(" a) Nunca" );
        rbalim61 = new RadioButton(" b) Às vezes  ");
        rbalim62 = new RadioButton(" c) Com frequência");
        lbalim7 = new Label(" Qual prato você escolheria ao almoço?");
        rbalim7 = new RadioButton(" a) Pizza " );
        rbalim71 = new RadioButton(" b) Arroz, bife grelhado e batata frita  ");
        rbalim72 = new RadioButton(" c) Arroz, Salada de alface,cenoura,bife.");
        lbalim8 = new Label(" Quantos cafés você toma por dia?  ");
        rbalim8 = new RadioButton(" a) Três ou mais" );
        rbalim81 = new RadioButton(" b) Um ou dois  ");
        rbalim82 = new RadioButton(" c) Nenhum");
        
        //Criar BottonGroup
        criarButonGroup(groupalim1,rbalim1,rbalim11);
        criarButonGroup(groupalim2,rbalim2,rbalim21);
        criarButonGroup2(groupalim3,rbalim3,rbalim31,rbalim32);
        criarButonGroup2(groupalim4,rbalim4,rbalim41,rbalim42);
        criarButonGroup(groupalim5,rbalim5,rbalim51);
        criarButonGroup2(groupalim6,rbalim6,rbalim61,rbalim62);
        criarButonGroup2(groupalim7,rbalim7,rbalim71,rbalim72);
        criarButonGroup2(groupalim8,rbalim8,rbalim81,rbalim82);        
        
        c1.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-35,5,5,5),0,0),lbalim1);
        c1.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-10,5,5,5),0,0),rbalim1);
        c1.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-10,5,5,5),0,0),rbalim11);
        
        c1.addComponent(new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim2);
        c1.addComponent(new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim2);
        c1.addComponent(new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim21);
        
        c1.addComponent(new GridBagConstraints(0,6,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim3);
        c1.addComponent(new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim3);
        c1.addComponent(new GridBagConstraints(0,8,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim31);
        c1.addComponent(new GridBagConstraints(0,9,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim32);
         
        c1.addComponent(new GridBagConstraints(0,10,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim4);
        c1.addComponent(new GridBagConstraints(0,11,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim4);
        c1.addComponent(new GridBagConstraints(0,12,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim41);
        c1.addComponent(new GridBagConstraints(0,13,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim42);
         
        c1.addComponent(new GridBagConstraints(0,14,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim5);
        c1.addComponent(new GridBagConstraints(0,15,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim5);
        c1.addComponent(new GridBagConstraints(0,16,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim51);
        
        c1.addComponent(new GridBagConstraints(0,17,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim6);
        c1.addComponent(new GridBagConstraints(0,18,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim6);
        c1.addComponent(new GridBagConstraints(0,19,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim61);
        c1.addComponent(new GridBagConstraints(0,20,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim62);
         
        c1.addComponent(new GridBagConstraints(0,21,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim7);
        c1.addComponent(new GridBagConstraints(0,22,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim7);
        c1.addComponent(new GridBagConstraints(0,23,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim71);
        c1.addComponent(new GridBagConstraints(0,24,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim72);
         
        c1.addComponent(new GridBagConstraints(0,25,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim8);
        c1.addComponent(new GridBagConstraints(0,26,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim8);
        c1.addComponent(new GridBagConstraints(0,27,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim81);
        c1.addComponent(new GridBagConstraints(0,28,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim82);
        
        //Actividade Física
        c2 = new Container(new GridBagLayout()); 
        lbafisic1 = new Label(" Praticas actividade Física com frequência?");
        rbfisic1  = new RadioButton(" a) Sim");
        rbfisic11  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic1,rbfisic1,rbfisic11);
        
        lbafisic2 = new Label(" Você se sente confortável no que fazes?");
        rbfisic2  = new RadioButton(" a) Sim");
        rbfisic21  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic2,rbfisic2,rbfisic21);
        
        lbafisic3 = new Label(" A quanto tempo praticas Exercícios?");
        rbfisic3  = new RadioButton(" a) A Menos de 1 ano");
        rbfisic31  = new RadioButton(" b) A Mais de 1 ano");
        rbfisic32  = new RadioButton(" c) Desde sempre");
        criarButonGroup2(gropfisic3,rbfisic3,rbfisic31,rbfisic32);
        
        lbafisic4 = new Label(" Você tem transporte próprio?        ");
        rbfisic4  = new RadioButton(" a) Sim");
        rbfisic41  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic4,rbfisic4,rbfisic41);
        
        lbafisic5 = new Label(" O que te levou a praticar Exercícios?");
        rbfisic5  = new RadioButton(" a) Porque gosto");
        rbfisic51  = new RadioButton(" b) Orientação médica");
        rbfisic52  = new RadioButton(" c) Outro");
        criarButonGroup2(gropfisic5,rbfisic5,rbfisic51,rbfisic52);
        
        lbafisic6 = new Label(" Tens alguma esperiência negativa ? ");
        rbfisic6  = new RadioButton(" a) Sim");
        rbfisic61  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic6,rbfisic6,rbfisic61);
        
        lbafisic7 = new Label(" Gostas de praticar com a família e amigos?");
        rbfisic7  = new RadioButton(" a) Sim");
        rbfisic71  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic7,rbfisic7,rbfisic71);
        
        lbafisic8 = new Label(" Praticar exercícios te incomoda ? ");
        rbfisic8  = new RadioButton(" a) Muito");
        rbfisic81  = new RadioButton(" b) Um pouco");
        rbfisic82  = new RadioButton(" c) Não");
        criarButonGroup2(gropfisic8,rbfisic8,rbfisic81,rbfisic82);       
        
        c2.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-35,5,5,5),0,0),lbafisic1);
        c2.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-10,5,5,5),0,0),rbfisic1);
        c2.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-10,5,5,5),0,0),rbfisic11);
        
        c2.addComponent(new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic2);
        c2.addComponent(new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic2);
        c2.addComponent(new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic21);
        
        c2.addComponent(new GridBagConstraints(0,6,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic3);
        c2.addComponent(new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic3);
        c2.addComponent(new GridBagConstraints(0,8,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic31);
        c2.addComponent(new GridBagConstraints(0,9,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic32);
        
        c2.addComponent(new GridBagConstraints(0,10,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic4);
        c2.addComponent(new GridBagConstraints(0,11,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic4);
        c2.addComponent(new GridBagConstraints(0,12,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic41);
        
        c2.addComponent(new GridBagConstraints(0,13,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic5);
        c2.addComponent(new GridBagConstraints(0,14,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic5);
        c2.addComponent(new GridBagConstraints(0,15,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic51);
        c2.addComponent(new GridBagConstraints(0,16,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic52);
        
        c2.addComponent(new GridBagConstraints(0,17,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic6);
        c2.addComponent(new GridBagConstraints(0,18,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic6);
        c2.addComponent(new GridBagConstraints(0,19,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic61);
        
        c2.addComponent(new GridBagConstraints(0,20,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic7);
        c2.addComponent(new GridBagConstraints(0,21,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic7);
        c2.addComponent(new GridBagConstraints(0,22,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic71);
        
        c2.addComponent(new GridBagConstraints(0,23,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbafisic8);
        c2.addComponent(new GridBagConstraints(0,24,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic8);
        c2.addComponent(new GridBagConstraints(0,25,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic81);
        c2.addComponent(new GridBagConstraints(0,26,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbfisic82);
        
        //Outros
        c3 = new Container(new GridBagLayout()); 
        lboutro1 = new Label("Você tem Problemas Respiratórios?");
        rboutr1 = new RadioButton(" a) Sim");
        rboutr2 = new RadioButton(" b) Não");
      
        criarButonGroup(gropoutr1,rboutr1,rboutr2);
       
        c3.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-875,-20,5,5),0,0),lboutro1);
        c3.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-800,-20,5,5),0,0),rboutr1);
        c3.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-725,-20,5,5),0,0),rboutr2);
           
        //Botões
        btVer = new Button("Ver Resultado");
        btVer.addActionListener(this);
        try{
            btVer.setIcon(Image.createImage("/view.png"));
        }
        catch(Exception e)
        {
        
        }
        btSair = new Button("Cancelar");
        try{
            btSair.setIcon(Image.createImage("/Cancelar.png"));
        }
        catch(Exception e)
        {
        
        }
        btSair.addActionListener(this);
        
        botoes = new Container(new GridBagLayout()); 
        botoes.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0),btVer);
        botoes.addComponent(new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0),btSair);
       
        this.addComponent(botoes);
        
        tb = new Tabs();
        
        tb.addTab("Outros",c3);
        tb.addTab("Alimentação",c1);
        tb.addTab("Actividade Física",c2);       
        
        tb.setTabPlacement(TOP);
        
        this.addComponent(tb);
         
        
    }
    
    //Método para criar bottonGroup com duas opções de selecção
    public void criarButonGroup(ButtonGroup btg,RadioButton rb1,RadioButton rb2)
    {
       btg = new ButtonGroup();
       btg.add(rb1);
       btg.add(rb2);
    }
    
    //Método para criar bottonGroup com três opções de selecção
    public void criarButonGroup2(ButtonGroup btg,RadioButton rb1,RadioButton rb2,RadioButton rb3)
    {
       btg = new ButtonGroup();
       btg.add(rb1);
       btg.add(rb2);
       btg.add(rb3);
    }
    
   
    private boolean validar()
    {
        boolean consistencia = true;
        
        if(rbalim1.isSelected() == false && rbalim11.isSelected() == false)
            consistencia = false; 
        else if(rbalim2.isSelected() == false && rbalim21.isSelected() == false)
            consistencia = false; 
        else if(rbalim3.isSelected() == false && rbalim31.isSelected() == false && rbalim32.isSelected() == false)
            consistencia = false; 
        else if(rbalim4.isSelected() == false && rbalim41.isSelected() == false && rbalim42.isSelected() == false)
            consistencia = false;
        else if(rbalim5.isSelected() == false && rbalim51.isSelected() == false)
            consistencia = false;  
        else if(rbalim6.isSelected() == false && rbalim61.isSelected() == false && rbalim62.isSelected() == false)
            consistencia = false; 
        else if(rbalim7.isSelected() == false && rbalim71.isSelected() == false && rbalim72.isSelected() == false)
            consistencia = false;
        else if(rbalim8.isSelected() == false && rbalim81.isSelected() == false && rbalim82.isSelected() == false)
            consistencia = false;
        else if(rbfisic1.isSelected() == false && rbfisic11.isSelected() == false)
            consistencia = false; 
        else if(rbfisic2.isSelected() == false && rbfisic21.isSelected() == false)
            consistencia = false; 
        else if(rbfisic3.isSelected() == false && rbfisic31.isSelected() == false && rbfisic32.isSelected() == false)
            consistencia = false;
        else if(rbfisic4.isSelected() == false && rbfisic41.isSelected() == false)
            consistencia = false; 
        else if(rbfisic5.isSelected() == false && rbfisic51.isSelected() == false && rbfisic52.isSelected() == false)
            consistencia = false;
        else if(rbfisic6.isSelected() == false && rbfisic61.isSelected() == false)
            consistencia = false; 
        else if(rbfisic7.isSelected() == false && rbfisic71.isSelected() == false)
            consistencia = false; 
        else if(rbfisic8.isSelected() == false && rbfisic81.isSelected() == false && rbfisic82.isSelected() == false)
            consistencia = false;
        else if(rboutr1.isSelected() == false && rboutr2.isSelected() == false)
            consistencia = false;
        
        return consistencia;
    }
    
    //Eventos
    public void actionPerformed(ActionEvent evento)
    { 
            if(evento.getSource() == btSair)
            {
               new MenuPrincipal().show();
            }
            if(evento.getSource() == btVer)
            {
              if(validar())
              {
                recomendacao [0] +=  "ªªªªªªªªªªªªªªªA Sua Alimentaçãoªªªªªªªªªªªªªªªªª"; 
                if(rbalim11.isSelected()) 
                {
                        recomendacao [1] +=  "*Deves Tomar sempre o pequeno almoço.";
                        valor += 5;
                }
                if(rbalim2.isSelected())
                {
                        recomendacao [2] +=  "*Não Salte refeições.";
                        valor += 5;
                }
                if(rbalim3.isSelected() || rbalim31.isSelected())
                {
                        recomendacao [3] += "*Tenha muito cuidado ao reduzir na";
                        recomendacao [4] += "quantidade de alimentos, nem sempre";
                        recomendacao [5] += "é a melhor solução.";
                        valor += 5;
                }
                if(rbalim42.isSelected() || rbalim31.isSelected())
                {
                        recomendacao [6] += "*Não fique deprimido por não perder";
                        recomendacao [7] += "uns quilos a mais, trabalhe mais no seu";
                        recomendacao [8] += "regime alimentar.";
                        valor += 5;
                }               
                if(rbalim51.isSelected())
                {
                        recomendacao [9] +=  "*Tenha uma alimentação equilibrada,";
                        recomendacao [10] += " comendo de tudo um pouco, um bom";
                        recomendacao [11] += "regime alimentar baseia-se nisso.";
                        valor += 5;
                }
                if(rbalim6.isSelected() || rbalim61.isSelected())
                {
                        recomendacao [12] +=  "*Leia sempre que poderes os rotulos"; 
                        recomendacao [13] += "dos alimentos, Assim teras maior controlo";
                        recomendacao [14] += " da tua alimentação.";
                        valor += 5;
                }
                if(rbalim7.isSelected() || rbalim71.isSelected())
                {
                        recomendacao [15] +=  "*Ao almoço tenha cuidado com os fritos,"; 
                        recomendacao [16] += "não são a melhor solução para uma boa"; 
                        recomendacao [17] += "refeição."; 
                        valor += 5;
                }
                if(rbalim8.isSelected())
                {
                        recomendacao [18] +=  "*Reduza no consumo de café, Café em"; 
                        recomendacao [19] += "excesso engorda."; 
                        valor += 5;
                }
                recomendacao [20] +=  "ªªªªªªªªªªªªªªªªAtividade Físicaªªªªªªªªªªªªªªªªªªªª"; 
                if(rbfisic11.isSelected())
                {
                        recomendacao [21] +=  "*A prática de Exercícios Físicos faz bem"; 
                        recomendacao [22] += "a todos procure praticar mais vezes"; 
                        valor += 5;
                }
                if(rbfisic21.isSelected())
                {
                        recomendacao [23] +=  "*Procure ganhar conforto na pratica de"; 
                        recomendacao [24] += "exercícios físicos, pois so sais a ganhar."; 
                        valor += 5;
                }
                if(rbfisic4.isSelected())
                {
                        recomendacao [25] +=  "*Tire alguns dias ou os fins de semana"; 
                        recomendacao [26] += "para caminhar um pouco."; 
                        valor += 5;
                }
                if(rbfisic51.isSelected())
                {
                        recomendacao [27] += "*Os médicos sabem o que fazem, procure"; 
                        recomendacao [28] += "tirar proveito das suas orientações e"; 
                        recomendacao [29] += "prátique cada vez mais exercícios físicos.";
                        valor += 2;
                }
                if(rbfisic6.isSelected())
                {
                        recomendacao [33] += "*Ser inteligente é saber tirar proveito das"; 
                        recomendacao [34] += "esperiências vividas procure usa-las para"; 
                        recomendacao [35] += "o teu bem agora e sairas a ganhar.";
                        valor += 5;
                }
                if(rbfisic71.isSelected())
                {
                        recomendacao [36] += "*Procure praticar exercícios com a Família,"; 
                        recomendacao [37] += "amigos, nem que for uma vez por semana.";
                        valor += 5;
                }
                if(rbfisic8.isSelected())
                {
                        recomendacao [38] += "*O incomodo do hoje é o conforto do"; 
                        recomendacao [39] += "amanha, procure ultrapassar isso.";
                        valor += 5;
                }


                recomendacao [40] +=  "ªªªªªªªªªªªªªªªªAvaliação Geralªªªªªªªªªªªªªªªªªªªª";
                if(valor >= 0 && valor < 30)
                {
                        recomendacao [41] +=  "***PARABÉNS: Você se alimenta muito bem";
                        recomendacao [42] +=  "Tente manter sempre o mesmo ritmo,o";
                        recomendacao [43] +=  "que certamente lhe assegurará vida";
                        recomendacao [44] +=  "saudável e corpo em forma!!!.";
                        recomendacao [45] +=  "Continue com o mesmo ritmo na prática";
                        recomendacao [46] +=  "de exercícios físicos que te trará cada";
                        recomendacao [47] +=  "vez mais benefícios.";
                }
                else if(valor >= 30 && valor < 50)
                {
                        recomendacao [41] +=  "***ATENÇÃO: Em linhas gerais, sua";
                        recomendacao [42] +=  "alimentação está razoável e apresenta";
                        recomendacao [43] +=  " algumas falhas.Procure corrigi-las";
                        recomendacao [44] +=  "interando-se do assunto ou consultando";
                        recomendacao [45] += "um nutricionista. Dessa forma, você";
                        recomendacao [46] += "certamente atingirá ao máximo seus";
                        recomendacao [47] += "objetivos com o corpo, adquirindo ou";
                        recomendacao [48] += "mantendo a forma e ainda garantindo uma";
                        recomendacao [49] += " saúde adequada.";
                        recomendacao [50] += "Inclua mais exercícios físicos na tua dieta.";                
                }
                else if(valor >= 50 && valor < 80)
                {       
                        recomendacao [41] +=  "***CUIDADO: Sua alimentação não está";
                        recomendacao [42] +=  "adequada. Está faltando qualidade na";
                        recomendacao [43] +=  "escolha e na forma como você ingere os";
                        recomendacao [44] +=  "alimentos, o que pode lhe trazer aumento";
                        recomendacao [45] += "da gordura corporal e até uma carência";
                        recomendacao [46] += "nutricional. Lembre-se que uma";
                        recomendacao [47] += "alimentação adequada reflete em maior";
                        recomendacao [48] += "bem estar e qualidade de vida. Marque"; 
                        recomendacao [49] += "uma consulta com um nutricionista para";
                        recomendacao [50] += "que possa corrigir seus hábitos.";
                        recomendacao [51] += "Também pude notar que não estas apto";
                        recomendacao [52] += "no que toca a actividade física, pratique";
                        recomendacao [53] += " exercícios e sentirás os enormes";
                        recomendacao [54] += "benefícios que isto trará para ti.";
                }
                new ResultadoObesos2(recomendacao, nome, IMC).show();
            }
            else
                     Dialog.show("Info", "Por Favor Responda todas as perguntas!...", "Ok", null);
            
            }
    }
    
    void inicializarVector(String vet[])
    {
       for(int i = 0; i < MAX; i++)
       {
            vet[i] = "";
       }
    }
}