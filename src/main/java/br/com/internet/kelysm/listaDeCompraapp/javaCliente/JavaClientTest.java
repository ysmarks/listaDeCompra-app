package br.com.internet.kelysm.listaDeCompraapp.javaCliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.tomcat.util.http.fileupload.IOUtils;

public class JavaClientTest {

	public static void main(String[] args) {
		HttpURLConnection connection = null;
		BufferedReader bufferedReader = null;
		try {
			URL url = new URL("http://localhost:8080/v1/protected/21");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.addRequestProperty("Authorization", "Basic a2VsbHk6c2VuaGEyMDE3");
			bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder jsonSB = new StringBuilder();
			String linha;
			
			while ((linha = bufferedReader.readLine()) != null) {
				jsonSB.append(linha);
			}
			System.out.println(jsonSB.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			IOUtils.closeQuietly(bufferedReader);
			if(connection != null)
				connection.disconnect();
		}
	}
}
