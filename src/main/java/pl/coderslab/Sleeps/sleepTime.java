package pl.coderslab.Sleeps;

public class sleepTime {
    public static  void sleep(String message, int time, String message2){
        System.out.println(message);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            System.out.println("-0");
            //LOGI
        }
        System.out.println(message2);
        /** Wartość 4000 odpowiada 5s **/
    }
}
