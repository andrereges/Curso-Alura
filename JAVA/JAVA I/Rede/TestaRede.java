import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

class TestaRede {

    public static void main(String[] args) {
       /* Rede rede = new Rede();
        String ip, macAddress;

        ip = rede.getIp();
        macAddress = rede.getMacAddress();

        System.out.println("Ip: " + ip
                            + "\nMac Address: " + macAddress); */

        InetAddress ip;

        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Host name: " + ip.getHostName());
            System.out.println("IP: " + ip.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length -1) ? "-" : ""));
            }

            System.out.println("Mac Address: " + sb.toString());
       
            
        } catch(UnknownHostException e) {
            e.printStackTrace();
        } catch(SocketException e) {
            e.printStackTrace();
        }
    }
}