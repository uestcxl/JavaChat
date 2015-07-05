import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xl on 15/7/6.
 */
public class SendThread extends Thread {

    PrintWriter printWriterOut;
    BufferedReader bufferedReaderIn;
    boolean isServer;

    //构造函数
    public SendThread( PrintWriter printWriterOut, BufferedReader bufferedReaderIn, boolean isServer ){
        this.bufferedReaderIn = bufferedReaderIn;
        this.printWriterOut = printWriterOut;
        this.isServer = isServer;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        try{
            while (true){
                if (isServer){
                    printWriterOut.println("Server : " + simpleDateFormat.format( new Date() ) + "\n" + bufferedReaderIn.readLine());
                }else{
                    printWriterOut.println("Client : " + simpleDateFormat.format( new Date() ) + "\n" + bufferedReaderIn.readLine());
                }
                //清空缓冲区
                printWriterOut.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
