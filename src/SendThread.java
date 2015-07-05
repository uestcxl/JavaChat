import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Created by xl on 15/7/6.
 */
public class SendThread extends Thread {

    PrintWriter printWriterOut;
    BufferedReader bufferedReaderIn;
    boolean isServer;

    public SendThread( PrintWriter printWriterOut, BufferedReader bufferedReaderIn, boolean isServer ){
        this.bufferedReaderIn = bufferedReaderIn;
        this.printWriterOut = printWriterOut;
        this.isServer = isServer;
    }

    @Override
    public void run() {
        super.run();
    }
}
