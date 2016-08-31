package com.lkl.wechat.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ALKL on 2016/8/31.
 */
public class Server {
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket(30000);

        while (true)
        {
            Socket s = ss.accept();
            socketList.add(s);

            new Thread(new ServerThread(s)).start();
        }

    }

}


