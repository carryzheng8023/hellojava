import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

/**
 * @author zhengxin
 * @date 2018-07-17 19:53:29
 */
public class NetworkTest {


    public static void main(String[] args) {

        for(;;){

            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                new URL("https://www.baidu.com").openStream();
            } catch (Exception e) {
                e.printStackTrace();

                try (OutputStream os = new FileOutputStream("/Users/zhengxin/Desktop/network_error.log", true)){

                    os.write((new Date().toString() + "\n").getBytes("UTF-8"));

                }catch (Exception ex){
                    ex.printStackTrace();
                }


            }
        }




    }

}
