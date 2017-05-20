
import java.util.concurrent.TimeUnit;


public class Radio {
   private int radioProgram;

   public void Radio(){
       radioProgram = 1;
   }

   public int getRadioProgram(){
       return radioProgram;
   }

    public void changeProgram(int nr){
       radioProgram = nr;
    }

}
