import javax.swing.JFrame;
import views.*;

public class Clientview {
    


 public static void main(String[] args) {
   //OBJETO ONDE SE VAI CONSTRUIR
   TipoServico t=new TipoServico();
   //MANDAR CONSTRUIR
   t.construir();

   Login l=new Login();
   l.construir();

   TipoOperacao tip=new TipoOperacao();
   tip.construir();
   
   CriarServicos c=new CriarServicos();
   c.construir();
 }









}
