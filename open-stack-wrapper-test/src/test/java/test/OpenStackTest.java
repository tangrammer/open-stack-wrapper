package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONObject;
import org.junit.Test;

import com.enterpriseweb.openstack.OpenStackAPI;

import static org.junit.Assert.*;

public class OpenStackTest {

	
	@Test
	public void testTokens() throws IOException {

		Properties login = loadLoginProperties();
		JSONObject requestTokens = createJSONObject(
				login.getProperty("username"), 
				login.getProperty("password"),
				login.getProperty("url"));

		System.out.println(OpenStackAPI.tokens(requestTokens));
		// {"access":{"token":{"id":"MIIDCwYJKoZIhvcNAQcCoIIC-DCCAvgCAQExCTAHBgUrDgMCGjCCAWEGCSqGSIb3DQEHAaCCAVIEggFOeyJhY2Nlc3MiOiB7InRva2VuIjogeyJpc3N1ZWRfYXQiOiAiMjAxNC0wMy0wNFQwOTo1ODo1Mi41MDY3OTkiLCAiZXhwaXJlcyI6ICIyMDE0LTAzLTA1VDA5OjU4OjUyWiIsICJpZCI6ICJwbGFjZWhvbGRlciJ9LCAic2VydmljZUNhdGFsb2ciOiBbXSwgInVzZXIiOiB7InVzZXJuYW1lIjogImZhY2Vib29rMTQyODQ2Nzg1MCIsICJyb2xlc19saW5rcyI6IFtdLCAiaWQiOiAiMmVhZWRhYzBkY2MwNDM1Y2JmZWM2OWRjYmQzMzkxYjQiLCAicm9sZXMiOiBbXSwgIm5hbWUiOiAiZmFjZWJvb2sxNDI4NDY3ODUwIn0sICJtZXRhZGF0YSI6IHsiaXNfYWRtaW4iOiAwLCAicm9sZXMiOiBbXX19fTGCAYEwggF9AgEBMFwwVzELMAkGA1UEBhMCVVMxDjAMBgNVBAgMBVVuc2V0MQ4wDAYDVQQHDAVVbnNldDEOMAwGA1UECgwFVW5zZXQxGDAWBgNVBAMMD3d3dy5leGFtcGxlLmNvbQIBATAHBgUrDgMCGjANBgkqhkiG9w0BAQEFAASCAQC7jPVaPo0qvPrRjps2kQ+zYPcAwBOgGj90oAog2IMltVBsPCnIpKivcFx+1dNH3rmI1CdoKe2fEt8WUc3muiTTePsJbn4lmMdLz3jb86aWaE06VDxwoBFG0dYZ33H8gDkFM3kbb89k-PxqB7CGHKzQQ5D6uu5wkLFzn2DwUSwWBTJW80JRKSdMbblNnWSOjp4r9c1dLFXOtnQLpD9rlC4yVNVmdAocFRQbCPNLWYbMp+V3MkJtp90KVNWXyFcE9zVS6HqF9XLZTjwbDmP6Z8slBrORus70lGooUJL0DPbEl-+CJ2kFZq2U+7bdhLgLK92fJX5YimC4jQmB7XpySBUI","issued_at":"2014-03-04T09:58:52.506799","expires":"2014-03-05T09:58:52Z"},"serviceCatalog":[],"user":{"id":"2eaedac0dcc0435cbfec69dcbd3391b4","username":"facebook1428467850","name":"facebook1428467850","roles":[],"roles_links":[]},"metadata":{"is_admin":0,"roles":[]}},"success":true}
		assertTrue(true);

	}

	private JSONObject createJSONObject(String username, String password,
			String url) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", username);
		jsonObject.put("password", password);
		jsonObject.put("url", url);
		return jsonObject;
	}
	
	private Properties loadLoginProperties() throws IOException {
		InputStream in = getClass().getResourceAsStream("login.properties");
		Properties prop = new Properties();
		prop.load(in);
		in.close();
		return prop;

	}


}