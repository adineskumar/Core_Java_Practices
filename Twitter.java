package SimpleHandsOn.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Twitter {
	
	private Map<String, String> oAuthMap = null;
	final private String BASE_URL = "https://api.twitter.com/1.1/";
	final private String USER_AGENT = "";
	
	private String createOAuthNonce() {
		SecureRandom random = new SecureRandom();
		String OAuthNonce   = new BigInteger(130, random).toString(32) ;
		return OAuthNonce;
	}
	
	private String createOAuthSignature() {
		String OAuthSignature   = null ;
		return OAuthSignature;
	}
	
	private String createOAuthTimeStamp() {
		long OAuthTimestamp = System.currentTimeMillis() / 1000L;
		return Long.toString(OAuthTimestamp);
	}
	
	
	private String getOAuthToken(){
		String OAuthToken = "";
		return OAuthToken;
	}
	
	private void setOAuthMap(Map<String, String> OAuthMap) {
		this.oAuthMap = OAuthMap;
	}
	
	private void constructOAuthMap(String OAuthNonce, String OAuthSignature, String OAuthTimestamp, String OAuthToken)
	{
		this.oAuthMap = new HashMap<String, String>();
		this.oAuthMap.put("oauth_consumer_key", "qKN1wGI2MAzCmdZcUOSXAlt1t");
		this.oAuthMap.put("oauth_nonce", OAuthNonce);
		this.oAuthMap.put("oauth_signature", OAuthSignature);
		this.oAuthMap.put("oauth_signature_method", "HMAC-SHA1");
		this.oAuthMap.put("oauth_timestamp", OAuthTimestamp);
		this.oAuthMap.put("oauth_token", OAuthToken);
		this.oAuthMap.put("oauth_version", "1.0");
	}
	
	private Map<String, String> getOAuthMap(){
		if ( this.oAuthMap == null) {
			this.constructOAuthMap(this.createOAuthNonce(), this.createOAuthSignature(), this.createOAuthTimeStamp(), this.getOAuthToken());
		}
		
		return this.oAuthMap;
	}
	
	private String BuildOAuthHeader() {
		String header = "OAuth ";
		for (Entry<String, String> entry : this.getOAuthMap().entrySet()) {
			String Key = entry.getKey();
			String Value = entry.getValue();
			
			try {
				header += URLEncoder.encode(Key, "UTF-8") + "\\\"" + URLEncoder.encode(Value, "UTF-8") + "\\\",";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			
		}		
		System.out.println(header.substring(0, header.length() - 1 ));
		return header.substring(0, header.length() - 1 );
		
	}
	
	private HttpURLConnection createRequest( String connectURL, String connectMethod) {
		try {
			
			URL obj = new URL(this.BASE_URL + connectURL ) ;
			System.out.println(obj);
			
			HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
			conn.setRequestMethod(connectMethod);
			conn.setRequestProperty("User-Agent", this.USER_AGENT);
			conn.setRequestProperty("X-HostCommonName", "api.twitter.com");
			conn.setRequestProperty("Host", "api.twitter.com");
			conn.setRequestProperty("Authorization", this.BuildOAuthHeader());
			conn.setRequestProperty("X-Target-URI", "https://api.twitter.com");
			conn.setRequestProperty("Connection", "Keep Alive");
			
			return conn;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	private void sendRequest(String resourceURL, String httpMethod) {
		try {
		HttpURLConnection conn  = this.createRequest(resourceURL, httpMethod);
		int responseCode        = conn.getResponseCode();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		
		String line;
		StringBuffer response = new StringBuffer();
		
		while ((line = br.readLine()) != null ) {
			response.append(line.toString());
		}
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		test twitter = new test();
		twitter.sendRequest("statuses/show.json?/id=1026696574280187906", "GET");
		
	}
}
