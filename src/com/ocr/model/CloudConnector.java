package com.ocr.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.AsyncTask;

import com.ocr.LogUtils;
import com.ocr.NetworkUtils;
import com.ocr.SharedPreferencesUtils;

public class CloudConnector implements CloudConstants {

	private final byte CM_URL = 0;
	private final byte CM_PARAM = 1;
	private final byte CM_CALLBACK = 2;

	public static final String DF_WITH_MILL = "yyyy-dd-MMM hh:mm:ss.SSS a";
	private final String PRIVATE_KEY = "825397z079c91";
	private final String ACCESS_VAL = "528374b093f40";

	private final String ACCESS_KEY = "accessKey";
	private final String SIG_KEY = "signature";
	private final String NONCE = "nonce";
	private final String TIMESTAMP = "ts";

	private String API_KEY = "bc30621e-e588-4d0f-965b-67253c09ec47";

	private int mStatusCode = 0;
	private String TAG = "CloudAdapter";
	Context context = null;
	private String KEY_SESSION = "session";

	public CloudConnector(Context context) {
		this.context = context;
	}

	/**
	 * 
	 * callback with jsonobject and errorcode
	 * 
	 */
	public interface JSONCallback {
		public void getJsonData(byte error, JSONObject data);
	}

	public void postMultipart(Context context, String url, MultipartEntity multipartEntity, JSONCallback callback) {
		new postMultipart(context).execute(url, multipartEntity, callback);
	}

	/*
	 * post multipart request
	 */
	private class postMultipart extends AsyncTask<Object, Integer, Byte> {
		private JSONCallback jsonCallback;
		private HttpClient client;
		private HttpPost mHttPost = null;
		private String respData;
		private Context context = null;

		public postMultipart(Context context) {
			this.context = context;
		}

		@Override
		protected void onPostExecute(Byte result) {
			super.onPostExecute(result);

			try {
				if (jsonCallback != null) {
					if (respData != null) {
						JSONObject jObj = new JSONObject(respData);
						jsonCallback.getJsonData(result.byteValue(), jObj);
					} else
						jsonCallback.getJsonData(result.byteValue(), null);
				}
			} catch (JSONException e) {
				e.printStackTrace();
				if (jsonCallback != null) {
					jsonCallback.getJsonData(INetworkErrorConstants.HTTP_RESP_JSON_ERROR, null);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		@Override
		protected Byte doInBackground(Object... params) {

			String url = (String) params[CM_URL];
			MultipartEntity multipartEntity = (MultipartEntity) params[CM_PARAM];
			jsonCallback = (JSONCallback) params[CM_CALLBACK];
			if (NetworkUtils.isNetworkAvailable(context)) {
				try {
					if (isSecuredAPICall(url)) {
						client = getSecuredClient();
					} else {
						client = new DefaultHttpClient();
					}
					mHttPost = new HttpPost(url);
					if (multipartEntity != null) {
						multipartEntity.addPart("apikey", new StringBody(API_KEY, "text/plain", Charset.forName("UTF-8")));
						multipartEntity.addPart("mode", new StringBody("scene_photo", "text/plain", Charset.forName("UTF-8")));
						mHttPost.setEntity(multipartEntity);
					}

					HttpResponse response = client.execute(mHttPost);
					mStatusCode = response.getStatusLine().getStatusCode();
					respData = getResponceAsString(response);
					LogUtils.verboseMsg(TAG + "Parsing Result ::: :::: " + respData.toString() + " :::::::: code ::: " + mStatusCode);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					return INetworkErrorConstants.HTTP_ERROR;
				} catch (ClientProtocolException e) {
					e.printStackTrace();
					return INetworkErrorConstants.HTTP_ERROR;
				} catch (IOException e) {
					e.printStackTrace();
					return INetworkErrorConstants.HTTP_ERROR;
				} catch (Exception e) {
					e.printStackTrace();
					return INetworkErrorConstants.HTTP_ERROR;
				}
				return INetworkErrorConstants.HTTP_SUCCESS;
			} else {
				return INetworkErrorConstants.HTTP_NO_NETWORK;
			}

		}
	}

	/*
	 * returns responce as string
	 */
	private String getResponceAsString(HttpResponse response) {
		try {
			if (response != null) {
				InputStream is = response.getEntity().getContent();
				InputStreamReader isr = new InputStreamReader(is, "UTF-8");
				BufferedReader br = new BufferedReader(isr);
				StringBuilder responseStrBuilder = new StringBuilder();
				String inputStr;
				while ((inputStr = br.readLine()) != null) {
					responseStrBuilder.append(inputStr);
				}
				br.close();
				isr.close();
				is.close();
				return responseStrBuilder.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getLinkParams(String key, String value) {
		StringBuilder tag = new StringBuilder();
		tag.append('&');
		tag.append(key);
		tag.append('=');
		tag.append(value);
		return tag.toString();
	}

	public static String getMD5EncryptedString(String encTarget) {
		MessageDigest mdEnc = null;
		try {
			mdEnc = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Exception while encrypting to md5");
			e.printStackTrace();
		} // Encryption algorithm
		mdEnc.update(encTarget.getBytes(), 0, encTarget.length());
		String md5 = new BigInteger(1, mdEnc.digest()).toString(16);
		while (md5.length() < 32) {
			md5 = "0" + md5;
		}
		return md5;
	}

	public String computeMD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		byte[] sha1hash = md.digest();
		return convertToHex(sha1hash);
	}

	private String convertToHex(byte[] data) {
		StringBuilder buf = new StringBuilder();
		for (byte b : data) {
			int halfbyte = (b >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
				halfbyte = b & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	private boolean isSecuredAPICall(String url) {
		String token = url.substring(0, url.indexOf(':'));
		if (token.equalsIgnoreCase("https")) {
			return true;
		}
		return false;
	}

	private HttpClient getSecuredClient() {
		try {
			KeyStore key = KeyStore.getInstance(KeyStore.getDefaultType());
			key.load(null, null);

			SSLSocketFactory sf = new CustomSSLFactory(key);
			sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);

			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpConnectionParams.setConnectionTimeout(params, CONNECTION_TIMEOUT);
			HttpConnectionParams.setSoTimeout(params, CONNECTION_TIMEOUT);

			SchemeRegistry registry = new SchemeRegistry();
			registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), HTTP_PORTNO));
			registry.register(new Scheme("https", sf, HTTPS_PORTNO));

			ClientConnectionManager ccm = new ThreadSafeClientConnManager(params, registry);
			return new DefaultHttpClient(ccm, params);
		} catch (Exception e) {
			return new DefaultHttpClient();
		}
	}

	protected class CustomSSLFactory extends SSLSocketFactory {
		SSLContext sslContext = SSLContext.getInstance("TLS");

		public CustomSSLFactory(KeyStore truststore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
			super(truststore);

			TrustManager tm = new X509TrustManager() {
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

				}

				@Override
				public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {

				}
			};

			sslContext.init(null, new TrustManager[] { tm }, null);
		}

		@Override
		public Socket createSocket() throws IOException {
			return sslContext.getSocketFactory().createSocket();
		}

		@Override
		public Socket createSocket(Socket socket, String host, int port, boolean autoClose) throws IOException, UnknownHostException {
			return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
		}
	}

	public static long getNonceWithMilli(String format) {
		SimpleDateFormat df = new SimpleDateFormat(DF_WITH_MILL);
		df.setTimeZone(TimeZone.getTimeZone("gmt"));
		String gmtTime = df.format(new Date());

		try {
			Date parse = df.parse(gmtTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(parse);
			long timestamp = calendar.getTimeInMillis();
			LogUtils.infoMsg("gmt time is " + timestamp);
			return timestamp;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static long getTsWithMilli() {
		SimpleDateFormat df = new SimpleDateFormat(DF_WITH_MILL);
		df.setTimeZone(TimeZone.getTimeZone("gmt"));
		String gmtTime = df.format(new Date());

		try {
			Date parse = df.parse(gmtTime);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(parse);
			long timestamp = calendar.getTimeInMillis() / 1000;
			return timestamp;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
