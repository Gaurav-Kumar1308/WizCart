//package com.example.ApiGateway.Util;
//
//import com.example.ApiGateway.dto.ProductDTO;
//import com.google.gson.Gson;
//import reactor.netty.http.client.HttpClient;
//
//import java.io.IOException;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//
//
//public class HTTP {
//
//    public static Object post(ProductDTO productDTO) throws IOException {
//        try{
//            URL url = new URL("");
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            httpURLConnection.setRequestMethod("POST");
//            httpURLConnection.setDoOutput(true);
//
//            OutputStream outputStream = httpURLConnection.getOutputStream();
//            outputStream.write(new Gson().toJson(productDTO).getBytes(StandardCharsets.UTF_8));
//            outputStream.flush();
//            String
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
