
package com.mycompany.myapp.view;

/**
 *
 * @author Armindo Binje
 */


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
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.Insets;
import com.codename1.ui.layouts.Layout;

public class ConsultaMagros extends Form implements ActionListener{
    private Tabs tb;
    private Container c1,c2,c3,botoes;
    private Label lbalim1,lbalim2,lbalim3,lbalim4,lbalim5,lbalim6,lbalim7,lbalim8,lbalim9,lbalim10,lbalim11,lbalim12;
    private Label lbafisic1,lbafisic2,lbafisic3,lbafisic4,lbafisic5,lbafisic6,lbafisic7,lbafisic8,lbafisic9,lbafisic101;
    private Label lbafisic11,lbafisic12;
    private Label lboutro1;
    private RadioButton rbalim1,rbalim11;
    private RadioButton rboutr1,rboutr2;
    private ButtonGroup groupalim1,groupalim2,groupalim3,groupalim4,groupalim5,groupalim6,groupalim7,groupalim8;
    private ButtonGroup groupalim9,groupalim10,groupalim11,groupalim12;
    private ButtonGroup gropoutr1;
    private Button btVer,btSair;
    private final int MAX = 1000; 
    private String recomendacao[] = new String [MAX];
    private int valor = 0;
    private String nome;
    private float IMC;
    private RadioButton rbalim2;
    private RadioButton rbalim21;
    private RadioButton rbalim22;
    private RadioButton rbalim3;
    private RadioButton rbalim31;
    private RadioButton rbalim4;
    private RadioButton rbalim41;
    private RadioButton rbalim42;
    private RadioButton rbalim5;
    private RadioButton rbalim51;
    private RadioButton rbalim6;
    private RadioButton rbalim61;
    private RadioButton rbalim62;
    private RadioButton rbfisic1;
    private RadioButton rbfisic11;
    private ButtonGroup gropfisic1;
    private RadioButton rbalim7;
    private RadioButton rbalim71;
    private RadioButton rbalim72;
    private RadioButton rbalim8;
    private RadioButton rbalim81;
    
    public ConsultaMagros(String nome, float imc)
    {       
       criaGui();
       setTitle(" Seja Bem Vindo(a) a Consulta para Magros");
       inicializarVector(recomendacao);
       this.nome = nome;
       this.IMC = imc;
       
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
        lbalim1 = new Label(" Contas as calorias que consomes? ");
        rbalim1 = new RadioButton(" a) Sim ");
        rbalim11 = new RadioButton(" b) Não ");
        criarButonGroup(groupalim1,rbalim1,rbalim11);
        
        lbalim2 = new Label(" Quantas horas Comes por dia? ");
        rbalim2 = new RadioButton(" a) a cada 3 horas ");
        rbalim21 = new RadioButton(" b) 2 vezes ao dia ");
        rbalim22 = new RadioButton(" c) outro ");
        criarButonGroup2(groupalim2,rbalim2,rbalim21,rbalim22);
        
        lbalim3 = new Label(" Tens uma alimentação variada? ");
        rbalim3 = new RadioButton(" a) Sim ");
        rbalim31 = new RadioButton(" b) Não ");
        criarButonGroup(groupalim3,rbalim3,rbalim31);
        
        lbalim4 = new Label(" Comes Sempre o pequeno almoço? ");
        rbalim4 = new RadioButton(" a) Sim ");
        rbalim41 = new RadioButton(" b) Não ");
        rbalim42 = new RadioButton(" c) Só quando tenho fome");
        criarButonGroup2(groupalim4,rbalim4,rbalim41,rbalim42);
        
        lbalim5 = new Label(" Como mastigas os alimentos? ");
        rbalim5 = new RadioButton(" a) Devagar ");
        rbalim51 = new RadioButton(" b) Rápido ");
        criarButonGroup(groupalim5,rbalim5,rbalim51);
        
        lbalim6 = new Label("  Quantas vezes p/semana consomes doces?");
        rbalim6 = new RadioButton(" a) 2-3 vezes  ");
        rbalim61 = new RadioButton(" b) mais de 3 vezes ");
        rbalim62 = new RadioButton(" c) nunca conto");   
        criarButonGroup2(groupalim6,rbalim6,rbalim61,rbalim62);
        
        lbalim7 = new Label("  Quantos copos de água bebes por dia?");
        rbalim7 = new RadioButton(" a) 1 a 3 copos  ");
        rbalim71 = new RadioButton(" b) 4 a 8 copos ");
        rbalim72 = new RadioButton(" c) 9 a 12 copos");   
        criarButonGroup2(groupalim7,rbalim7,rbalim71,rbalim72);
        
        lbalim8 = new Label("  Consumes alimentos de fonte protéica diariamente? ");
        rbalim8 = new RadioButton(" a) Sim  ");
        rbalim81 = new RadioButton(" b) Não ");   
        criarButonGroup(groupalim8,rbalim8,rbalim81);
        
        c1.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-35,5,5,5),0,0),lbalim1);
        c1.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-10,5,5,5),0,0),rbalim1);
        c1.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-10,5,5,5),0,0),rbalim11);
        
        c1.addComponent(new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim2);
        c1.addComponent(new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim2);
        c1.addComponent(new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim21);
        c1.addComponent(new GridBagConstraints(0,6,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim22);
        
        c1.addComponent(new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim3);
        c1.addComponent(new GridBagConstraints(0,8,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim3);
        c1.addComponent(new GridBagConstraints(0,9,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim31);
        
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
        
       /* c1.addComponent(new GridBagConstraints(0,25,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),lbalim8);
        c1.addComponent(new GridBagConstraints(0,26,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim8);
        c1.addComponent(new GridBagConstraints(0,27,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-5,5,5,5),0,0),rbalim81);
        */
        
        //Actividade Física
        c2 = new Container(new GridBagLayout()); 
        lbafisic1 = new Label(" Você faz treino de força?");
        rbfisic1  = new RadioButton(" a) Sim");
        rbfisic11  = new RadioButton(" b) Não");
        criarButonGroup(gropfisic1,rbfisic1,rbfisic11);
        
        c2.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-700,-20,5,5),0,0),lbafisic1);
        c2.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-600,-20,5,5),0,0),rbfisic1);
        c2.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-500,-20,5,5),0,0),rbfisic11);
        
        //Outros
        c3 = new Container(new GridBagLayout()); 
        lboutro1 = new Label("Você tem Problemas Respiratórios?");
        rboutr1 = new RadioButton(" a) Sim");
        rboutr2 = new RadioButton(" b) Não");
      
        criarButonGroup(gropoutr1,rboutr1,rboutr2);
       
        c3.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-700,-20,5,5),0,0),lboutro1);
        c3.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-600,-20,5,5),0,0),rboutr1);
        c3.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(-500,-20,5,5),0,0),rboutr2);
        
        
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
    
    //Eventos
    public void actionPerformed(ActionEvent evento)
    { 
            if(evento.getSource() == btSair)
            {
               new MenuPrincipal().show();
            }
            if(evento.getSource() == btVer)
            {
               //if(validar())
              // {
                    recomendacao [0] +=  "ªªªªªªªªªªªªªªªA Sua Alimentaçãoªªªªªªªªªªªªªªªªª"; 
                    if(rbalim11.isSelected()) 
                    {
                            recomendacao [2] += "*Conte as calorias. Leia os rótulos e use";
                            recomendacao [3] += "uma escala para saber quais as calorias";
                            recomendacao [4] += "dos alimentos, e registe tudo o que come"; 
                            recomendacao [5] += "e respetivas calorias.";
                            valor += 5;
                    } 
                    if(rbalim21.isSelected() || rbalim22.isSelected()) 
                    {
                            recomendacao [7] += "*Coma de 3 em 3 horas para conseguir ";
                            recomendacao [8] += "ingerir as calorias necessárias.";
                            valor += 5;
                    } 
                    if(rbalim31.isSelected()) 
                    {
                            recomendacao [10] += "*Tenha uma alimentação o mais variada";
                            recomendacao [11] += "possível. Para um bom estado de saúde,";
                            recomendacao [12] += "necessitamos de mais de 40 nutrientes.";
                            valor += 5;
                    } 
                    if(rbalim41.isSelected()) 
                    {
                            recomendacao [14] += "*O pequeno-almoço é a refeição mais";
                            recomendacao [15] += "importante do dia e por isso deve ser";
                            recomendacao [16] += "respeitada e valorizada.";
                            valor += 5;
                    } 
                    else  if(rbalim42.isSelected()) 
                    {
                            recomendacao [14] += "*O pequeno-almoço é a refeição mais";
                            recomendacao [15] += "importante do dia. Se não tiver fome,coma";
                            recomendacao [16] += "na mesma. Mas não pule essa refeição do";
                            recomendacao [17] += "dia, já que essa refeição é muito";
                            recomendacao [18] += "importante.";
                            valor += 5;
                    } 
                    if(rbalim51.isSelected()) 
                    {
                            recomendacao [20] += "*Coma devagar e mastigue bem os";
                            recomendacao [21] += "alimentos. Isso favorece a digestão e faz";
                            recomendacao [22] += "com que você tenha fome nas próximas";
                            recomendacao [23] += "refeições.";
                            valor += 5;
                    }     
                    if(rbalim61.isSelected() || rbalim62.isSelected())
                    {
                            recomendacao [25] += "*Não abuse dos doces. Para sua saúde,";
                            recomendacao [26] += "consuma apenas de 2-3 vezes por semana";
                            recomendacao [27] += "e depois das grandes refeições, como";
                            recomendacao [28] += "almoço e jantar.";
                            valor += 5;                    
                    }
                    if(rbalim7.isSelected())
                    {
                            recomendacao [30] += "*Beba muita água durante o dia, no mínimo";
                            recomendacao [31] += " 8 copos, pois 60% (aproximadamente) do";
                            recomendacao [32] += " nosso peso corporal é água.";
                            valor += 5;                    
                    }
                    if(rbalim81.isSelected())
                    {
                            recomendacao [30] += "*Consumir alimentos de fonte protéica diariamente,";
                            recomendacao [31] += " como leites, queijos, iogurtes, carnes, peixes e frangos.";
                            recomendacao [32] += " As proteínas são essenciais para a manutenção e aumento da";
                            recomendacao [33] += "massa muscular.";
                            valor += 5;                    
                    }
                    
                    recomendacao [35] +=  "ªªªªªªªªªªªªªªªªAtividade Físicaªªªªªªªªªªªªªªªªªªªª";
                    
                    if(rbfisic11.isSelected())
                    {
                            recomendacao [37] += "*Ganhe força. Se quer passar de magro a";
                            recomendacao [38] += "musculoso e não de magro a gordo,";
                            recomendacao [39] += "comece a fazer treino de força.";
                            recomendacao [40] += "Mais força significa mais músculo.";
                            valor += 5;
                    }
                    
                    new ResultadoMagros(recomendacao, nome, IMC).show();
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
