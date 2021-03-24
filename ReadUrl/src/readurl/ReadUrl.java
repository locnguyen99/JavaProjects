/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readurl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author LN
 */
public class ReadUrl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            URL url = new URL("https://www.infortlus.com/detail.html?mamon=69#lienhe");
//            System.out.println("URL:" + url.toString());
//            System.out.println("protocol:" + url.getProtocol());
//            System.out.println("authority:" + url.getAuthority());
//            System.out.println("file name:" + url.getFile());
//            System.out.println("host:" + url.getHost());
//            System.out.println("path:" + url.getPath());
//            System.out.println("port" + url.getPort());
//            System.out.println("default port:" + url.getDefaultPort());
//            System.out.println("query:" + url.getQuery());
//            System.out.println("ref:" + url.getRef());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try {
            URL url = new URL("http://tlus.edu.vn/phan-hieu-truong-dai-hoc-thuy-loi-thong-bao-tuyen-sinh-dai-hoc-chinh-quy-nam-2021/");
            URLConnection urlConnection = url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

