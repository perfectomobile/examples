import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;




import javax.net.ssl.HttpsURLConnection;

public class executeLowLevelAPI {

                private final String USER_AGENT = "Mozilla/5.0";


                public static void main(String[] args) throws Exception {
                                String device = Constants.PM_DEVICE;
                                executeLowLevelAPI http = new executeLowLevelAPI();
                                http.smsME("hello",device);

                }

                public void smsME(String text,String Device)throws Exception 
                {

                                String execID = getExecID(Constants.PM_CLOUD,Constants.PM_USER,Constants.PM_PASSWORD);
                                String cmd =   "https://"+Constants.PM_CLOUD+"/services/executions/"+execID+"?user="+Constants.PM_USER+"&password="+Constants.PM_PASSWORD+"&operation=command&command=gateway&subcommand=sms&param.body="+text+"&param.to.handset="+Device;
                                String res = htmlcall (cmd);
                                closeSession(execID);
                }


                public void closeSession(String execID)  throws Exception 
                {
                                String closeURL = "https://"+Constants.PM_CLOUD+"/services/executions/"+execID+"?user="+Constants.PM_USER+"&password="+Constants.PM_PASSWORD+"&operation=end";

                                String res = htmlcall (closeURL);

                }

                public String getExecID(String cloud,String user,String Password)  throws Exception 
                {
                                String openurl = "https://"+cloud+"/services/executions?user="+user+"&password="+Password+"&operation=start";

                                String res = htmlcall (openurl);
                                int  start = res.indexOf("\":\"")+3; 
                                int  end =  res.indexOf("\",\""); ; 
                                System.out.println(res);

                                String execID = res.substring(start, end);
                                System.out.println(execID);
                                return execID;

                }


                public String htmlcall(String url) throws Exception 
                {

                                URL obj = new URL(url);
                                HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                                // optional default is GET
                                con.setRequestMethod("GET");

                                //add request header
                                con.setRequestProperty("User-Agent", USER_AGENT);

                                int responseCode = con.getResponseCode();
                                System.out.println("\nSending 'GET' request to URL : " + url);
                                System.out.println("Response Code : " + responseCode);

                                BufferedReader in = new BufferedReader(
                                                                new InputStreamReader(con.getInputStream()));
                                String inputLine;
                                StringBuffer response = new StringBuffer();

                                while ((inputLine = in.readLine()) != null) {
                                                response.append(inputLine);
                                                response.append("\n");

                                }

                                in.close();

                                //print result
                                return response.toString();

                }

}
