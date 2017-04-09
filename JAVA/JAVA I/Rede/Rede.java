import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Rede {

    private String ip;
    private String macAddress;

    public Rede() {}

    public String getIp() {
        return this.ip;
    }

    public String getMacAddress() {
        return this.macAddress;
    }
    
    private void ip() {

        InetAddress InternetProtocol;

        try {
            InternetProtocol = InetAddress.getLocalHost();
            this.ip = InternetProtocol.getHostAddress();

            NetworkInterface network = NetworkInterface.getByInetAddress(InternetProtocol);

            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length -1) ? "-" : ""));
            }

            this.macAddress = sb.toString();
            
        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch(SocketException e) {
            e.printStackTrace();
        }
    }
}