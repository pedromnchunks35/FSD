package ops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.security.Timestamp;
import java.time.Instant;

import javax.sound.sampled.SourceDataLine;

public class ServiceSocket {
    String ip;
    int porta;
    Instant Timestamp;
    //CONSTRUTOR DA NOSSA THREAD QUE VAI COMUNICAR COM O NOSSO SERVIDOR
    public ServiceSocket (String ip, int porta, Instant Timestamp) {
        //IP DO SERVER
        this.ip = ip;
        //PORTA DO SERVER
        this.porta = porta;
        //TIMESTAMP DO SERVER
        this.Timestamp = Timestamp;
    } 
    
    public void go()throws IOException{

        //CRIAR A SOCKET QUE VAI LIGAR
        Socket ligacao=new Socket(ip,porta);
        //BUFFER READER
        BufferedReader in=new BufferedReader(new InputStreamReader(ligacao.getInputStream()));
        //PrintWriter
        PrintWriter out=new PrintWriter(ligacao.getOutputStream(),true);
        //MENSAGEM 
        out.println(Timestamp);
        //ENCHER BUFFER
        out.flush();
        //RESPOSTA
        String resposta = in.readLine();
        System.out.println(resposta);
        
        //FECHAR O IN
        in.close();
        //FECHAR O OUT
        out.close();
        //FECHAR LIGACAO
        ligacao.close();
        }
}
