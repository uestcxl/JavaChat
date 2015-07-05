import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xl on 15/7/6.
 */
public class Server {

    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket(7890);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReaderIn = new BufferedReader( new InputStreamReader( socket.getInputStream() ));
            PrintWriter printWriterOut = new PrintWriter( socket.getOutputStream() );
            BufferedReader userIn = new BufferedReader( new InputStreamReader( System.in ));

            new ReceiveThread( serverSocket, bufferedReaderIn, printWriterOut, userIn, socket ).start();
            new SendThread( printWriterOut, bufferedReaderIn, true).start();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
