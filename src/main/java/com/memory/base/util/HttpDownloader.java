package com.memory.base.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class HttpDownloader {

  public static boolean download(String httpUrl, String file) {

    try {
      URL url = new URL(httpUrl);
      URLConnection conn = url.openConnection();
      InputStream in = conn.getInputStream();
      FileOutputStream fos = new FileOutputStream(file);
      byte[] buffer = new byte[1024];
      int len = 0;
      while ((len = in.read(buffer)) != -1) {
        fos.write(buffer, 0, len);
      }
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }
  
  public static void main(String[] args) {
    download("http://42.121.87.117:8084/voices/download//867600310/luyin/867600310-callback-20150727154708-13121972426-15910562330-1-64-1437983233839.mp3", "D:\\dcp\\record\\867600310-callback-20150727154708-13121972426-15910562330-1-64-1437983233839.mp3");
  }
}
