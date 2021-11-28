import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import javax.lang.model.util.ElementScanner14;

import ops.*;
public class Client {
   
   public static void main(String[] args) throws IOException{
     //CRIAR O SCANNER  
     Scanner scan=new Scanner(System.in);
     //OFERECER AS OPCOES AO CLIENTE
     System.out.println("ESCREVA 1 SE QUISER FAZER REGISTO , ESCREVA 2 SE QUISER SIMPLESMENTE FAZER LOGIN, ESCREVA 3 SE DESEJA SE CONECTAR A UM SERVICO: ");
     //LER A OPCAO QUE ESTE ESCOLHEU
     String decisaostr= scan.nextLine();
     //CONVERTER PARA INT
     int decisao=Integer.valueOf(decisaostr);
      //COLOCAR O QUE SERA EXECUTADO CONSOANTE A DECISAO DO CLIENTE
      switch(decisao){
       case 1://CASO DE QUERER SE REGISTAR
       //INFORMAR AO UTILIZADOR QUE INPUT QUEREMOS DA PARTE DELE E GUARDAR
       System.out.println("Please write your name and press enter: ");
       String nome=scan.nextLine();
       System.out.println("Please Write down your card IDENTIFICATION number: ");
       String bi=scan.nextLine();
       //Extrair IP DATA e passar para uma String e juntar ao nome
       InetAddress ipi=InetAddress.getLocalHost();
       String ip= ipi.toString();
       //Juntar nome+ip
       String msg="["+nome+"/"+ip+"/"+bi+"]";
       Identification I=new Identification(msg);
       I.go();
       break;
       case 2://CASO DE FAZER O LOGIN NUM SERVIDOR
       //PERGUNTAR IP
       System.out.println("Introduza o IP:");
       //RECEBER O IP
       String ip_Server=scan.nextLine();
       //PERGUNTAR PORTA
       System.out.println("Introduza a porta:");
       //receber a porta
       String portastr=scan.nextLine();
       //PERGUNGAR HASH
       System.out.println("Introduza a HASH:");
       //RECEBER A HASH
       String Hash=scan.nextLine();
       //VERIFICAR CONEXAO
       String cod_verificacao;
       //COLOCAR UMA EXEPTION CASO O ERRO NAO SEJA DA HASH MAS SIM DO IP
       try{
       ConVerify cv=new ConVerify(ip_Server,Integer.valueOf(portastr),Hash);
       cod_verificacao=cv.go();
      }catch(Exception e){
         //CATCH NA EXCEPTION , DEVOLVER ERRO
       cod_verificacao="400";
      }
       //SE A CONEXAO FOR INVALIDA ESTE ACABA POR AQUI SENAO CONTINUA O PROCESSO
       if(cod_verificacao.equals("200")){
       //DAR AO CLIENTE AS OPCOES QUE O SERVER TEM
       System.out.println("PRIMA 1 CASO VOCE QUEIRA UMA LISTA DOS SERVICOS DIPONIVEIS, PRIMA 2 CASO QUEIRA CRIAR UM SERVICO,PRIMA 3 CASO QUEIRA SAIR");
       //LER A SUA DECISAO
       String decisao2=scan.nextLine();
       //COLOCAR O QUE SERA EXECUTADO CONSOANTE A DECISAO DO CLIENTE
       switch (Integer.valueOf(decisao2)) {
          //OPCAO PARA TER A LISTA DOS SERVICOS DISPONIVEIS
          case 1:
          //INICIALIZAR O OBJETO QUE CONECTA AO SERVIDOR DE IDENTIFICACAO
          One one=new One(ip_Server,Integer.valueOf(portastr),Hash);
              //INVOCAR O MEOTODO QUE REALMENTE CONECTA E FAZ AS OPERACOES
              one.go();
             break;
          //OPCAO PARA CRIAR UM SERVIDOR
          case 2:
            //PEDIR PARA INTRODUZIR A DESIGNACAO
            System.out.println("INTRODUZA A DESIGNACAO DO SERVICO:");
            //RECEBER DESIGNACAO
            String designacao_servico=scan.nextLine();
            //PEDIR PARA INTRODUZIR O IP
            System.out.println("INTRODUZA O IP:");
            //RECEBER O IP
            String ip_servico=scan.nextLine();
            //OBJETO QUE EXECUTA OS METODOS
            Two two=new Two(ip_Server,Integer.valueOf(portastr),Hash,designacao_servico,ip_servico);
            //METODO EM SI
            two.go();
             break;
            //OPCAO PARA SAIR
           case 3:
           break;
          default:
           System.out.println("VOCE NAO SELECIONOU UMA OPCAO VALIDA");
             break;
       }
      }else{
      //ERRO DA CONEXAO AO SERVIDOR
      System.out.println("Erro na conexao ao servidor");

      }
       

       break;
       case 3:
       break;
       default:
       System.out.println("Erro , voce nao selecionou nenhuma das opcoes dadas.");
       break;
       
      }


   }


}
