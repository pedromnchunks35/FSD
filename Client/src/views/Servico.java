package views;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import views.*;
import ops.ServiceSocket;
import ops.Three;
import ops.Midle;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.InputStreamReader;
public class Servico implements ActionListener{
//LABEL IMAGEM
JLabel backb=new JLabel(new ImageIcon("./views/assets/l.png"));
        //Inicializar janela principal  
        JFrame janela=new JFrame();
        //TEXT FIELD USER
        JTextField t_ip=new JTextField();
        //TEXT FIELD CC
        JTextField t_ts=new JTextField();
        //COMBOBOX TIPO DE CONEXAO
        String s1[] = { "SOCKET", "RMI"};
        JComboBox c_tipo=new JComboBox(s1);
        //TEXT FIELD RESPOSTA COM HASH
        JTextArea t_resp = new JTextArea();

    //METODO QUE VAI CONSTRUIR A NOSSA JANELA
    public void construir(){
        //LOAD ICON
        Image icon = Toolkit.getDefaultToolkit().getImage("./views/assets/icon.PNG");
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
        JLabel Titulo = new JLabel("SERVICO");
        //DEFINICAO DO TEXTO
        Titulo.setFont(new Font("Italic",Font.BOLD,20));
        Titulo.setSize(100, 100);

        //Rectangulo
        JPanel borda=new JPanel();
        //SETTAR A BORDA
        borda.setBackground(Color.black);
        //SITIO 
        borda.setBounds(190,40,80,1);

        //Texto op USER
        JLabel j_ip=new JLabel("INTRODUZA O NOME DO SERVICO:");
        //DEF DE TEXTO
        j_ip.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_ip.setBounds(130,70,200,12);

        //TAMANHO DO TEXT FIELD DO IP
        t_ip.setBounds(130,85,210,30);

        //LABEL CC 
        JLabel j_ts=new JLabel("INTRODUZA O TIMESTAMP:");
        //DEF DE TEXTO
        j_ts.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_ts.setBounds(130,135,200,12);
                
        //TAMANHO DO CC
        t_ts.setBounds(130,150,210,30);

        //LABEL CC 
        JLabel j_tipo=new JLabel("TIPO DE CONEXAO:");
        //DEF DE TEXTO
        j_tipo.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_tipo.setBounds(130,200,200,12);

        //TAMANHO DO COMBOBOX
        c_tipo.setBounds(130, 215, 210, 30);


        //BOTAO
        JButton b=new JButton("CONFIRMAR");
        b.setBounds(165, 265, 140, 40);
        b.setBackground(lil);
        //LER O BOTAO
        b.addActionListener(this);

        //LABEL HASH
        JLabel j_resp=new JLabel("RESPOSTA DO SERVIDOR:");
        //DEF DE TEXTO
        j_resp.setFont(new Font("Italic",Font.BOLD,12));
        //POSICAO E TAMANHO DO TEXTO
        j_resp.setBounds(130,330,200,30);

        //TAMANHO
        t_resp.setBounds(130, 360, 210, 30);

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
        janela.add(j_ip);
        janela.add(t_ip);
        janela.add(t_ts);
        janela.add(j_ts);
        janela.add(j_resp);
        janela.add(t_resp); 
        janela.add(j_tipo);
        janela.add(c_tipo);
        janela.add(backb);
        janela.setLayout(null);
        janela.setVisible(true);

    }


    @Override
    //FUNÇÃO PARA VERIFICAR SE OS CAMPOS ESTÃO TODOS PREENCHIDOS
    public void actionPerformed(ActionEvent e) {
        if (t_ip.getText().length() > 0 && t_ts.getText().length() > 0){
            //SACAR VALORES
            String tipoconex = c_tipo.getSelectedItem().toString();
            String ip_porta=t_ip.getText();
            String times=t_ts.getText();
            //type of service
            if(tipoconex.equals("RMI")){
                Three t=new Three("GOAL",ip_porta);
                String ip_TICKET=null;
                try {
                    ip_TICKET = t.go();
                } catch (UnknownHostException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }
                //RMI
                int porta=-1;
                try {
                    //IR BUSCAR A PORTA
                    Integer.valueOf(ip_TICKET.substring(ip_TICKET.lastIndexOf(":")));
                    JOptionPane.showMessageDialog(null, "RMI NAO LEVA PORTA!");
                } catch (Exception exeptionporta) {porta=0;}

                if(ip_TICKET.equals("NOPE")){
                    JOptionPane.showMessageDialog(null, "NAO EXISTE QUALQUER SERVICO COM ESSE NOME");
                    porta=-1;
                }


                //SE NAO TIVER PORTA ENTAO..
                if(porta==0){
                
                //VERIRICAR A TIMESTAMP
                int isitatime=0;
                Instant timestamp_servico=null;
                try{
                    //CONVERSAO DA TIMESTAMPs
                 timestamp_servico = Instant.parse(times);
                isitatime=1;
                }catch(Exception timer){
                    JOptionPane.showMessageDialog(null, "Timestamp nao valida");
                }

                //SE A TIMESTAMP FOR VALIDA
                if(isitatime==1){
                    String ip_txt=null;    
                    //IP A QUE NOS VAMOS CONECT NESTE CASO É O NOSSO SI
                    try {
                      File myObj = new File("ips_list.txt");
                      Scanner myReader = new Scanner(myObj);
                      while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        //IR BUSCAR IP CORRESPONDENTE
                        if(data.substring(0,2).equals("MD")){
                        ip_txt=data.substring(data.lastIndexOf(":")+1);
                        System.out.println(ip_txt);
                        }
                      }
                      myReader.close();
                    } catch (FileNotFoundException ex) {}

                //INVOCAR OBJETO
                Midle m=new Midle(ip_txt,times,ip_TICKET);
                String resp=null;
                try {
                    resp = m.go();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                t_resp.setText(resp); 
                }
            }


            }else{
            

                Three t=new Three("GOAL",ip_porta);
                String ip_TICKET=null;
                try {
                    ip_TICKET = t.go();
                } catch (UnknownHostException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (IOException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                }


            //SOCKET
            int porta_dois=-1;
            int nullable=0;
            //IR BUSCAR A PORTA
            if(ip_TICKET.equals("NOPE")){
                    JOptionPane.showMessageDialog(null, "NAO EXISTE QUALQUER SERVICO COM ESSE NOME");
                    nullable=-1;
                }
            if(nullable==0){
            try {
                //IR BUSCAR A PORTA
                porta_dois=Integer.valueOf(ip_TICKET.substring(ip_TICKET.lastIndexOf(":")+1));
            } catch (Exception exeptionporta) {
                JOptionPane.showMessageDialog(null, "SOCKET TEM QUE TER UMA PORTA!");
            }
        }
            

            //CASO A PORTA SEJA DIFERENTE DE -1
            if(porta_dois!=-1){
                //VERIRICAR A TIMESTAMP
                int isitatime=0;
                Instant timestamp_servico=null;
                try{
                    //CONVERSAO DA TIMESTAMP
                 timestamp_servico = Instant.parse(times);
                isitatime=1;
                }catch(Exception timer){
                    JOptionPane.showMessageDialog(null, "Timestamp nao valida");
                }
                //SE A TIMESTAMP FOR VALIDA
                if(isitatime==1){
                    // FAZER A CONEXAO PARA O SOCKET
                    ServiceSocket S = new ServiceSocket(ip_TICKET.substring(0, ip_TICKET.lastIndexOf(":")), porta_dois, timestamp_servico);
                    try {
                        //REPOSTA
                        List resp=S.go();
                        //SE ENTROU COM SUCESSO ENTAO..
                        if(resp.get(0).equals("200 OK")){
                            //SETTAR O TEXTO COM A RESPOSTA
                            t_resp.setText((String)resp.get(1));
                        }else{
                            //A TIMESTAMP NAO É VALIDA/PASSOU DO TEMPO
                            JOptionPane.showMessageDialog(null, "A sua timestamp passou do tempo");
                        }


                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Algo deu errado..");
                    }
                }

            
            }
        }
            
        } else {
            JOptionPane.showMessageDialog(null, "Os campos tem de ser todos preenchidos!");

        }
    }


    //FUNÇÃO PARA CORRER O PROGRAMA
    public Servico(){
        construir();
    }


}