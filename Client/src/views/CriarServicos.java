package views;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
public class CriarServicos {

    public CriarServicos(){}

    
    public void construir(){
        //criacao de janela
        JFrame janela=new JFrame();
        //LOAD ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
        //COLOR
        Color lil = new Color(173,216,230);
        //SET IT
        janela.setIconImage(icon); 
        //TAMANHO DA JANELA
        janela.setBounds(300,0,500,330);
        //BACKGROUND COLOR
        janela.setBackground(Color.lightGray);
        //CRIAR PANEL
        JPanel panel=new JPanel();
        //TAMANHO DO PAINEL
        panel.setBounds(120,10,240,28);
        //CRIAR LABEL
        JLabel Titulo = new JLabel("CRIACAO DE SERVICOS");
        //DEFINICAO DO TEXTO
        Titulo.setFont(new Font("Italic",Font.BOLD,20));
        //Rectangulo
        JPanel borda=new JPanel();
        //SETTAR A BORDA
        borda.setBackground(Color.black);
        //SITIO 
        borda.setBounds(120,40,240,1);
    
    
    
        //CRIAR LABEL
        JLabel labelservice = new JLabel("NOME DO SERVICO");
        //DEFINICAO DO TEXTO
        labelservice.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO
        labelservice.setBounds(175,70,130,12);
        //TEXT FIELD
        JTextField textfieldservice=new JTextField();
        //TAMANHO
        textfieldservice.setBounds(130,85,210,30);
    
    
    
         //CRIAR LABEL
         JLabel labelip = new JLabel("INTRODUZA O ENDERECO IP");
         //DEFINICAO DO TEXTO
         labelip.setFont(new Font("Italic",Font.BOLD,12));
         //POSICAO E TAMANHO
         labelip.setBounds(150,140,200,12);
         //TEXT FIELD
         JTextField textfieldip=new JTextField();
         //TAMANHO
         textfieldip.setBounds(130,155,210,30);
    
    
    
        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 220, 140, 40);
        b.setBackground(lil);
         
    
        //ADICIONAR LABEL AO PANEL
        panel.add(Titulo);
        //ADICIONAR COISAS a JANELA
        janela.add(panel);
        janela.add(borda);
        janela.add(labelservice);
        janela.add(textfieldservice);
        janela.add(labelip);
        janela.add(textfieldip);
        janela.add(b);
    
        janela.setLayout(null);
        janela.setVisible(true);
    
    
        }



    
}