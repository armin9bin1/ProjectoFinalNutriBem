
package com.mycompany.myapp.view;

import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.Insets;

/**
 *
 * @author Armindo Binje
 */
public class ConsultaView extends Form implements ActionListener{
    
    private Label lbpeso, lbaltura, lbidade, lbsexo, lbnome, lbfisica;
    private TextField textpeso,textaltura, textnome,textidade;
    private Button btConsultar,btSair;
    private RadioButton rbMasculino,rbFeminino,rbS,rbN;
    private ButtonGroup group,group2;
    private Container c,c2,principal;
    float IMC;
   
    public ConsultaView()
    {
       super("Preencha os seus dados");
       criaGui();
    }
     
    public void criaGui()
    {
       c = new Container(new GridBagLayout()); 
       c2 = new Container(new FlowLayout()); 
       principal = new Container(new BorderLayout());
       
       lbnome = new Label("Nome: ");
       textnome = new TextField();
       lbidade = new Label("Idade: ");
       textidade = new TextField();
       lbsexo = new Label("Sexo: ");
       rbMasculino = new RadioButton("Masculino");
       rbFeminino = new RadioButton("Feminino");
       group = new ButtonGroup();
       group.add(rbMasculino);
       group.add(rbFeminino);
       lbpeso = new Label("Peso(em kg): ");
       textpeso = new TextField();
       lbaltura = new Label("Altura(em metro): ");
       textaltura = new TextField();
       lbfisica = new Label("Praticas Exercícios Físicos?");
       rbS = new RadioButton("Sim");
       rbN = new RadioButton("Não");
       group2 = new ButtonGroup();
       group2.add(rbS);
       group2.add(rbN);
       
       btConsultar = new Button("Consultar");
       try{
            btConsultar.setIcon(Image.createImage("/view.png"));
       }
       catch(Exception e){  }
       btSair = new Button("Sair");
       try{
            btSair.setIcon(Image.createImage("/Cancelar.png"));
       }
       catch(Exception e){  }
       
       c.addComponent(new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),lbnome);
       c.addComponent(new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,6,5,5),0,0),textnome);
       c.addComponent(new GridBagConstraints(0,2,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),lbidade);
       c.addComponent(new GridBagConstraints(0,3,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,6,5,5),0,0),textidade);
       c.addComponent(new GridBagConstraints(0,4,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),lbsexo);
       c.addComponent(new GridBagConstraints(0,5,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),rbMasculino);
       c.addComponent(new GridBagConstraints(0,6,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),rbFeminino);
       c.addComponent(new GridBagConstraints(0,7,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),lbpeso);
       c.addComponent(new GridBagConstraints(0,8,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,6,5,5),0,0),textpeso);
       c.addComponent(new GridBagConstraints(0,9,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),lbaltura);
       c.addComponent(new GridBagConstraints(0,10,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,6,5,5),0,0),textaltura);
       c.addComponent(new GridBagConstraints(0,11,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),lbfisica);
       c.addComponent(new GridBagConstraints(0,12,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),rbN);
       c.addComponent(new GridBagConstraints(0,12,1,1,0,0,GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,new Insets(5,0,5,5),0,0),rbS);
       
       
       c2.addComponent(btConsultar);
       c2.addComponent(btSair);
       
       principal.addComponent(BorderLayout.NORTH, c);
       principal.addComponent(BorderLayout.SOUTH, c2);
       
       this.addComponent(principal);
  
       btSair.addActionListener(this);
       btConsultar.addActionListener(this);
    }
    
    private boolean validar()
    {
        boolean consistencia = true;
        
        if(textnome.getText().equals(""))
        {
            Dialog.show("Info", "Digite o Campo Nome", "Ok", null);
            consistencia = false;
        }
        else if(textidade.getText().equals(""))
        {
            Dialog.show("Info", "Digite o Campo Idade", "Ok", null);
            consistencia = false;
        }
        else if(rbMasculino.isSelected() == false && rbFeminino.isSelected() == false)
        {
            Dialog.show("Info", "Seleccione o Sexo", "Ok", null);
            consistencia = false; 
        }
        else if(textpeso.getText().equals(""))
        {
            Dialog.show("Info", "Digite o Campo Peso", "Ok", null);
            consistencia = false;
        }
        else if(textaltura.getText().equals(""))
        {
            Dialog.show("Info", "Digite o Campo Altura", "Ok", null);
            consistencia = false;
        }   
        else if(rbS.isSelected() == false && rbN.isSelected() == false)
        {
            Dialog.show("Info", "Responda a pergunata sobre a pratica de Exercícios Físico", "Ok", null);
            consistencia = false; 
        }
        return consistencia;
    }
    
    //Eventos
    public void actionPerformed(ActionEvent evento)
    { 
            if(evento.getSource() == btSair)
            {
               new MenuPrincipal().show();
            }
            
            if(evento.getSource() == btConsultar)
            {            
               if(validar())
               {
                    float peso = Float.parseFloat(textpeso.getText());
                    float altura = Float.parseFloat(textaltura.getText());
                    IMC = (peso / (altura * altura));
                    
                    if(IMC < 18.5)
                         new ConsultaMagros(textnome.getText(), IMC).show();
                    else
                    {
                        if(IMC >= 18.5 )
                        {
                           if(rbN.isSelected()) 
                               new ConsultaObesos1(textnome.getText(), IMC).show();  
                          else 
                                new ConsultaObesos2(textnome.getText(), IMC).show();
                        }
                    }                       
               }                                      
            }            
    }   
    
}
