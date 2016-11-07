/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battlvo;
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
/**
 *
 * @author pas4981
 */
public abstract class NetworkConnection {
    private Consumer<Serializable> onRecieveCallback;
    protected abstract boolean isServer();
    protected abstract String getIP();
    protected abstract int getPort();
    public NetworkConnection(Consumer<Serializable> onRecieveCallback){
        this.onRecieveCallback = onRecieveCallback;
    }
    
    public void start() throws Exception {
        
    }
    
    public void send(Serializable data)throws Exception {
        
    }
    
    public void close() throws Exception{
        
    }
    
    private class connectionThread extends Thread {
        @Override
        public void run(){
            try (ServerSocket server = isServer() ? new ServerSocket(getPort()) : null;
                    Socket socket = isServer() ? server.accept() : new Socket(getIP(), getPort());
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream()))
                    
        }
    }
}
