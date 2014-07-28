
package com.mycompany.myapp.view;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
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
public class ConsultaObesos1 extends Form implements Runnable,ActionListener{
    ResultadoObesos1 r1;
    static final int FPS = 24;
    private volatile boolean running;
    private Thread thread;
    private Tabs tb;
    private String str = "";
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
    
    public ConsultaObesos1(String nome, float imc)
    {       
       super();
       criaGui();
       setTitle(" Seja Bem Vindo(a) a Consulta para Obesos");
       inicializarVector(recomendacao);
       this.nome = nome;
       this.IMC = imc;
       init();
    }
    
    public void addNotify() {
       
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }
    
    public void init() {
        running = true;
        r1 = new ResultadoObesos1(recomendacao, nome, IMC);
    }
    
    public void criaGui()
    {     
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
        {    }
        btSair.addActionListener(this);
        
        botoes = new Container(new GridBagLayout()); 
        botoes.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0),btVer);
        botoes.addComponent(new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,5,5,5),0,0),btSair);
       
        this.addComponent(botoes);
        
        //Alimentação
        c1 = new Container(new GridBagLayout()); 
        lbalim1 = new Label(" Nas Refeições Comes muito depressa? ");
        rbalim1 = new RadioButton(" a) Sim ");
        rbalim11 = new RadioButton(" b) Não ");
        lbalim2 = new Label(" Quantas Vezes mastigas os alimentos? ");
        rbalim2 = new RadioButton(" a) 8 a 50 ");
        rbalim21 = new RadioButton(" b) Superior a 50 ");
        lbalim3 = new Label(" Quantos copos de água você bebe p/ dia? ");
        rbalim3 = new RadioButton(" a) 3 ou menos" );
        rbalim31 = new RadioButton(" b) entre 4 e 6 ");
        rbalim32 = new RadioButton(" c) mais de seis ");
        lbalim4 = new Label(" O que você come no café da manhã? ");
        rbalim4 = new RadioButton(" a) Nada" );
        rbalim41 = new RadioButton(" b) pão c/ manteiga e leite com café  ");
        rbalim42 = new RadioButton("  c) pão c/ queijo, suco ou iogurte c/cereais");
        lbalim5 = new Label(" Comes muitas vezes sozinho ou à pressa?");
        rbalim5 = new RadioButton(" a) Sim " );
        rbalim51 = new RadioButton(" b) Não ");
        lbalim6 = new Label(" Comes até ficar farto?                    ");
        rbalim6 = new RadioButton(" a) Nunca" );
        rbalim61 = new RadioButton(" b) Sempre  ");
        rbalim62 = new RadioButton(" c) Algumas Vezes");
        lbalim7 = new Label(" Quantos leites ou yogurtes consomes/dia?");
        rbalim7 = new RadioButton(" a) 1 ou nenhum " );
        rbalim71 = new RadioButton(" b) Mais de 5  ");
        rbalim72 = new RadioButton(" c) 2 a 3 ");
        lbalim8 = new Label(" O seu jantar é: ?                         ");
        rbalim8 = new RadioButton(" a) Maior que o almoço, tenho mais fome" );
        rbalim81 = new RadioButton(" b) Igual ao almoço  ");
        rbalim82 = new RadioButton(" c) Mais leve que o almoço");
        
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
        lbafisic1 = new Label(" Já praticou algum tipo d actividade Física?");
        rbfisic1  = new RadioButton(" a) Sim");
        rbfisic11  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic1,rbfisic1,rbfisic11);
        
        lbafisic2 = new Label(" Sentes dores ou desconforto no corpo?");
        rbfisic2  = new RadioButton(" a) Sim");
        rbfisic21  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic2,rbfisic2,rbfisic21);
        
        lbafisic3 = new Label(" A quanto tempo não praticas Exercícios?");
        rbfisic3  = new RadioButton(" a) A Menos de 1 ano");
        rbfisic31  = new RadioButton(" b) A Mais de 1 ano");
        rbfisic32  = new RadioButton(" c) Nunca pratiquei");
        criarButonGroup2(gropfisic3,rbfisic3,rbfisic31,rbfisic32);
        
        lbafisic4 = new Label(" Tens interesse em alguma modalidade?");
        rbfisic4  = new RadioButton(" a) Sim");
        rbfisic41  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic4,rbfisic4,rbfisic41);
        
        lbafisic5 = new Label(" O que te faz não praticar Exercícios?");
        rbfisic5  = new RadioButton(" a) Força de Vontade");
        rbfisic51  = new RadioButton(" b) Orientação médica");
        rbfisic52  = new RadioButton(" c) Outro");
        criarButonGroup2(gropfisic5,rbfisic5,rbfisic51,rbfisic52);
        
        lbafisic6 = new Label(" Tens alguma esperiência negativa ? ");
        rbfisic6  = new RadioButton(" a) Sim");
        rbfisic61  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic6,rbfisic6,rbfisic61);
        
        lbafisic7 = new Label(" Tens algum parente ou amigo que pratica?");
        rbfisic7  = new RadioButton(" a) Sim");
        rbfisic71  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic7,rbfisic7,rbfisic71);
        
        lbafisic8 = new Label(" Não praticar exercícios te incomoda ? ");
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
        c3 = new Container( new GridBagLayout()); 
        lboutro1 = new Label("Você tem Problemas Cardíacos?");
        rboutr1 = new RadioButton(" a) Sim");
        rboutr2 = new RadioButton(" b) Não");
       
        criarButonGroup(gropoutr1,rboutr1,rboutr2);
        
        c3.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-850,-20,5,5),0,0),lboutro1);
        c3.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-780,-20,5,5),0,0),rboutr1);
        c3.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-720,-20,5,5),0,0),rboutr2);
      
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
                    if(rbalim1.isSelected()) 
                    {
                            recomendacao [1] += "*Tu Dever comer muito devagar, mastigue";
                            recomendacao [2] += "bem os alimentos antes de os ingerires.";
                            valor += 5;
                    }     
                    if(rbalim2.isSelected()) 
                    {
                            recomendacao [3] += "*Procure mastigar os alimentos no mínimo";
                            recomendacao [4] += "até 50 vezes.";
                            valor += 5;
                    }     
                    if(rbalim3.isSelected()) 
                    {
                            recomendacao [5] += "*Consuma mais água";               
                            valor += 5;
                    }   
                    else if(rbalim32.isSelected()) 
                    {
                            recomendacao [5] += "*Consumo exagerado de água, reduza um";               
                            recomendacao [6] += "pouco na quantidade consumida por dia,";
                            recomendacao [7] += "pois tudo por excesso faz mal.";
                            valor += 5;
                    } 
                    if(rbalim4.isSelected()) 
                    {
                            recomendacao [8] += "*Toma sempre o café da manhã";
                            valor += 5;
                    } 
                    if(rbalim5.isSelected()) 
                    {
                            recomendacao [9] += "*Proucure comer com a família ou amigos,";
                            recomendacao [10] += "comer com ritual próprio,à mesa,com";
                            recomendacao [11] += " talheres, pratos.";
                            valor += 5;
                    } 
                    if(rbalim61.isSelected() || rbalim62.isSelected()) 
                    {
                            recomendacao [12] += "*Evite comer até ficar farto,pare de comer";
                            recomendacao [13] += "com o estômago meio vazio.";
                            valor += 5;
                    } 
                    if(rbalim71.isSelected()) 
                    {
                            recomendacao [14] += "*Tudo por excesso faz mal, procure";
                            recomendacao [15] += "reduzirna quantidade de leites & yogurtes";
                            recomendacao [16] += "consumidos por dia.";
                            valor += 5;
                    } 
                    recomendacao [18] +=  "ªªªªªªªªªªªªªªªªAtividade Físicaªªªªªªªªªªªªªªªªªªªª";
                    
                    if(rbfisic11.isSelected())
                    {
                        valor += 5;
                    }
                    if(rbfisic2.isSelected())
                    {
                        recomendacao [19] += "*Consulte um médico para resolver as";
                        recomendacao [20] += "tuas dores no corpo.";                          
                        valor += 5;
                    }
                    if(rbfisic3.isSelected())
                    {                         
                        valor += 2;
                    }
                    else if(rbfisic31.isSelected())
                    {                         
                        valor += 5;
                    }
                    else
                    {
                        valor += 10;
                    }
                    if(rbfisic5.isSelected())
                    {                         
                        valor += 5;
                    }
                    else if(rbfisic51.isSelected())
                    {
                        recomendacao [21] += "*Acredito que as orientações médicas"; 
                        recomendacao [22] += "sejam por alguma razão sigue-as até que";
                        recomendacao [23] += "te deêm novas recomendações.";
                    }
                    if(rbfisic6.isSelected())
                    {                         
                        recomendacao [24] += "*Procure tirar proveito das esperiências"; 
                        recomendacao [25] += "negativas, procure usa-las para o teu bem"; 
                        recomendacao [26] += "agora e sairas a ganhar.";
                        valor += 5;
                    }
                    if(rbfisic7.isSelected())
                    {
                        recomendacao [27] += "*Converse mais com os teus parentes e"; 
                        recomendacao [28] += "amigos que praticam exercícios físicos e";
                        recomendacao [29] += "sairas a ganhar.";
                        valor += 5;
                    }
                    if(rbfisic8.isSelected() || rbfisic81.isSelected())
                    {
                        recomendacao [30] += "*O incomodo do hoje é o conforto do"; 
                        recomendacao [31] += "amanha, procure ultrapassar isso.";
                        valor += 5;
                    }
                    
                    recomendacao [33] +=  "ªªªªªªªªªªªªªªªªAvaliação Geralªªªªªªªªªªªªªªªªªªªª";
                    if(valor >= 0 && valor < 30)
                    {
                            recomendacao [34] +=  "***PARABÉNS: Você se alimenta muito bem";
                            recomendacao [35] +=  "Tente manter sempre o mesmo ritmo,o";
                            recomendacao [36] +=  "que certamente lhe assegurará vida";
                            recomendacao [37] +=  "saudável e corpo em forma!!!.";
                            recomendacao [38] +=  "Continue com o mesmo ritmo na prática";
                            recomendacao [39] +=  "de exercícios físicos que te trará cada";
                            recomendacao [40] +=  "vez mais benefícios.";
                    }
                    else if(valor >= 30 && valor < 50)
                    {
                            recomendacao [34] +=  "***ATENÇÃO: Em linhas gerais, sua";
                            recomendacao [35] +=  "alimentação está razoável e apresenta";
                            recomendacao [36] +=  " algumas falhas.Procure corrigi-las";
                            recomendacao [37] +=  "interando-se do assunto ou consultando";
                            recomendacao [38] += "um nutricionista. Dessa forma, você";
                            recomendacao [39] += "certamente atingirá ao máximo seus";
                            recomendacao [40] += "objetivos com o corpo, adquirindo ou";
                            recomendacao [41] += "mantendo a forma e ainda garantindo uma";
                            recomendacao [42] += " saúde adequada.";
                            recomendacao [43] += "Inclua mais exercícios físicos na tua dieta.";                
                    }
                    else if(valor >= 50 && valor < 80)
                    {       
                            recomendacao [34] +=  "***CUIDADO: Sua alimentação não está";
                            recomendacao [35] +=  "adequada. Está faltando qualidade na";
                            recomendacao [36] +=  "escolha e na forma como você ingere os";
                            recomendacao [37] +=  "alimentos, o que pode lhe trazer aumento";
                            recomendacao [38] += "da gordura corporal e até uma carência";
                            recomendacao [39] += "nutricional. Lembre-se que uma";
                            recomendacao [40] += "alimentação adequada reflete em maior";
                            recomendacao [41] += "bem estar e qualidade de vida. Marque"; 
                            recomendacao [42] += "uma consulta com um nutricionista para";
                            recomendacao [43] += "que possa corrigir seus hábitos.";
                            recomendacao [44] += "Também pude notar que não estas apto";
                            recomendacao [45] += "no que toca a actividade física, pratique";
                            recomendacao [46] += " exercícios e sentirás os enormes";
                            recomendacao [47] += "benefícios que isto trará para ti.";
                    }                   
               
                    r1.show();
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
    
}