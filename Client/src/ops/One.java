package ops;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class One {
String ip , hash;
int porta,decisao;
//CONSTRUTOR DA NOSSA THREAD QUE VAI COMUNICAR COM O NOSSO SERVIDOR
public One(String ip , int porta, String hash,int decisao){
//IP DO SERVER
this.ip=ip;
//PORTA DO SERVER
this.porta=porta;
//HASH DO SERVER
this.hash=hash;
//decisao
this.decisao=decisao;
}


public List go()throws IOException{
List<String> lista=new ArrayList<String>();
//CRIAR A SOCKET QUE VAI LIGAR
Socket ligacao=new Socket(ip,porta);
//BUFFER READER
BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
//PrintWriter
PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
//ENVIAR MSG COM O TIPO DE SERVICO
out.println("C");
//ENVIAR HASH
out.println(hash);
//ENVIAR TIPO DE SERVICO
out.println("1");
//ENVIAR TIPO DE SERVICO
if(decisao==1){
out.println("RMI");
}else{
out.println("SOCKET");
}
//PREENCHER BLOCO
out.flush();
//LER A RESPOSTA DO SERVIDOR, CASO O POINTER AVANCE PARA UMA LINHA QUE NAO EXISTE ELE LEVANTA UMA EXCEPTION MAS APENAS DIZ QUE CHEGOU AO FIM
try{
while (true) {
    //LER A LINHA
String msgRecebida=in.readLine();
   //CASO HAJA UMA LINHA NULL DAR BREAK AO WHILE
if(msgRecebida.equals(null)){break;}
   //ESCREVER A MSG NA CONSOLA
lista.add(msgRecebida);
}
}catch(Exception e){
    //CASO DE UM ERRO NO BUFFER
System.out.println("[SERVER]->FIM");
}
//FECHAR O IN
in.close();
//FECHAR O OUT
out.close();
//FECHAR LIGACAO
ligacao.close();
return lista;
}



    
}
