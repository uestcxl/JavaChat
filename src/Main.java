import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {
            Socket socketClient = new Socket( InetAddress.getLocalHost(), 8888 );
            BufferedReader bufferedReaderIn = new BufferedReader( new InputStreamReader( socketClient.getInputStream() ));
            PrintWriter printWriterOut =  new PrintWriter( socketClient.getOutputStream() );
            BufferedReader userIn = new BufferedReader( new InputStreamReader( System.in ));

            new SendThread( printWriterOut, bufferedReaderIn, false).start();
            new ReceiveThread( socketClient, bufferedReaderIn, printWriterOut, userIn).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
