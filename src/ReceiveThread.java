import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xl on 15/7/6.
 */
public class ReceiveThread extends Thread{

    BufferedReader bufferedReaderIn;
    BufferedReader userIn;
    PrintWriter printWriterOut;

    ServerSocket serverSocket;
    Socket socket;

    //server接收消息的构造函数
    public ReceiveThread( ServerSocket serverSocket, BufferedReader bufferedReaderIn, PrintWriter printWriterOut, BufferedReader userIn, Socket socket){
        this.bufferedReaderIn = bufferedReaderIn;
        this.userIn = userIn;
        this.printWriterOut = printWriterOut;

        this.serverSocket = serverSocket;
        this.socket = socket;
    }

    //client接收消息的构造函数
    public ReceiveThread( Socket socket, BufferedReader bufferedReaderIn, PrintWriter printWriterOut, BufferedReader userIn ){
        this.printWriterOut = printWriterOut;
        this.bufferedReaderIn = bufferedReaderIn;
        this.socket = socket;
        this.userIn = userIn;
    }

    @Override
    public void run() {
        try {
            while (true){
                String message = bufferedReaderIn.readLine();
                while ( message != null ){
                    System.out.println( message );
                    message = bufferedReaderIn.readLine();
                }
                if ( bufferedReaderIn.readLine().equals("end") ){
                    break;
                }
                bufferedReaderIn.close();
                printWriterOut.close();
                userIn.close();
                if ( socket != null ){
                    socket.close();
                }
                serverSocket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
