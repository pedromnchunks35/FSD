package views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;
import javax.swing.*;
import java.awt.event.*;

<<<<<<< HEAD

public class SisIdenti implements ActionListener{
    //LABEL IMAGEM
    JLabel backb=new JLabel(new ImageIcon("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/l.png"));
    //Inicializar janela principal  
    JFrame janela=new JFrame();
    //BOTAO
    JButton b=new JButton("CONFIRMAR");
    //TEXT FIELD USER
    JTextField t_user=new JTextField();
    //TEXT FIELD CC
    JTextField t_cc=new JTextField();
    //TEXT FIELD IP
    JTextField t_ip=new JTextField();
    
    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
    public void construir(){
        //LOAD ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("C:/Users/pedro/Desktop/universidade/3 ano/Projects/fsd projects/FSD_Project/Client/src/views/assets/icon.PNG");
        //SET IT
        janela.setIconImage(icon);
        //TAMANHO DA JANELA
        janela.setBounds(300,0,500,480);
        //COLOCAR NO CENTRO DA TELA
        janela.setLocationRelativeTo(null);
        //DESATIVAR O BOTÃO DE AUMENTAR A JANELA
        janela.setResizable(false);
        //FECHAR O PROGRAMA NO BOTÃO 'X'
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //BACKGROUND COLOR
        janela.setBackground(Color.lightGray);

        //COLOR
        Color lil = new Color(173,216,230);

        //CRIAR PANEL
        JPanel panel=new JPanel();
        //TAMANHO DO PAINEL
        panel.setBounds(80,10,300,28);

        //CRIAR LABEL
        JLabel Titulo = new JLabel("SISTEMA DE IDENTIFICACAO");
        //DEFINICAO DO TEXTO
        Titulo.setFont(new Font("Italic",Font.BOLD,20));
        Titulo.setSize(100, 100);

        //Rectangulo
        JPanel borda=new JPanel();
        //SETTAR A BORDA
        borda.setBackground(Color.black);
        //SITIO 
        borda.setBounds(100,40,260,1);

        //Texto op USER
        JLabel j_user=new JLabel("INTRODUZA O SEU USERNAME:");
        //DEF DE TEXTO
        j_user.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_user.setBounds(130,70,200,12);


        //TAMANHO DO TEXTFIELD USER
        t_user.setBounds(130,85,210,30);

        //LABEL CC 
        JLabel j_cc=new JLabel("INTRODUZA O SEU NUMERO DE CC:");
        //DEF DE TEXTO
        j_cc.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_cc.setBounds(130,135,200,12);
                

        //TAMANHO DO TEXT FIELD CC
        t_cc.setBounds(130,150,210,30);

        //BOTÃO
        b.setBounds(165, 265, 140, 40);
        b.setBackground(lil);
        //LER O BOTÃO
        b.addActionListener(this);

        //LABEL HASH
        JLabel j_hash=new JLabel("RESPOSTA DO SERVIDOR:");
        //DEF DE TEXTO
        j_hash.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_hash.setBounds(130,330,200,30);

        //TEXT FIELD RESPOSTA COM HASH
        JTextField t_hash = new JTextField();
        //TAMANHO
        t_hash.setBounds(130, 360, 210, 30);

        //FAZER O BOTAO CLICAVEL
        backb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                //dispose da janela
                janela.dispose();
                //CRIAR NOVA JANELA
                TipoServico t=new TipoServico();

              }
          });
          //SELECIONAR POSI E TAMANHO
          backb.setBounds(40, 15, 32, 32);

        //ADICIONAR LABEL AO PANEL
        panel.add(Titulo);
        //ADICIONAR ITENS NA JANELA
        janela.add(panel);
        janela.add(borda);
        janela.add(b);
        janela.add(j_cc);
        janela.add(t_cc);
        janela.add(j_user);
        janela.add(t_user);
        janela.add(j_hash);
        janela.add(t_hash);
        janela.add(backb);

        janela.setLayout(null);
        janela.setVisible(true);

    }

    @Override
    //FUNÇÃO PARA VERIFICAR SE OS CAMPOS ESTÃO TODOS PREENCHIDOS
    public void actionPerformed(ActionEvent e) {
        if(t_user.getText().length() > 0 && t_cc.getText().length() > 0 && t_ip.getText().length() > 0){
            System.out.printf("A FUNCIONAR");
        } else {
            JOptionPane.showMessageDialog(null, "Os campos tem de ser todos preenchidos!");
        }
    }


    //FUNÇÃO PARA CORRER A JANELA
    public SisIdenti(){
        construir();
    }

}