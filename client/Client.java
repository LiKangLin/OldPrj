package com.lkl.wechat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Created by ALKL on 2016/8/31.
 */
public class Client {
    public static void main(String [] args) throws IOException {
        Socket s = new Socket("192.168.253.1",30000);
        new Thread(new ClientThread(s)).start();

        PrintStream ps = new PrintStream(s.getOutputStream());
        String line = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while((line=br.readLine())!=null){
            ps.println(line);
        }

    }


}
