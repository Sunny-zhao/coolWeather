package com.coolweather.app.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	public static final String TAG = "qingshan";
	public static void sendHttpRequest(final String address,
			final HttpCallbackListener listener) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				HttpURLConnection connection = null;
                StringBuilder response = new StringBuilder();
				try {
					URL url = new URL(address);
					connection = (HttpURLConnection) url.openConnection();
					connection.setRequestMethod("GET");
					connection.setConnectTimeout(8000);
					connection.setReadTimeout(8000);
					InputStream in = connection.getInputStream();
					BufferedReader reader = new BufferedReader(new InputStreamReader(in));

					String line;
					Log.d(TAG, "run: before read");
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
//					char [] temp=new char[1024];
//					int length=0;
//					while((length=reader.read(temp))>0){
//						response.append(temp,0,length);
//					}

					Log.d(TAG, "run: after read");
					if (listener != null) {
						// 回调onFinish()方法
						listener.onFinish(response.toString());
					}
				} catch (Exception e) {
					Log.d(TAG,"error when read line",e);
					if (listener != null) {
						// 回调onError()方法

                        if (!address.endsWith("html")) {
                            listener.onError(e);

                        }else
                        {
                            listener.onFinish(response.toString());
                        }
					}
				} finally {
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
		}).start();
	}

}