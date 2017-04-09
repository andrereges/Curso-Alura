import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
class TestaRede2 {
    public static void main(String[] args) {
        String ipStr = "192.168.1.100";
        String maskStr = "255.255.252.0";
        IPAddress ipAddress = new IPAddress(ipStr);
        Netmask netmask = new Netmask(maskStr);
        System.out.println("IP fornecido : " + ipAddress.toString() + "/" + netmask.toString());
        System.out.println("IP da Rede   : " + NetworkUtils.getBaseNetworkIP(ipAddress, netmask));
        System.out.println("IP Broadcast : " + NetworkUtils.getBroadcastIP(ipAddress, netmask));
        /*System.out.println("Listando todos os IPs validos da rede: ");
        for (IPAddress ipp : NetworkUtils.listAvailableIPAddresses(ipAddress, netmask)) {
            System.out.println("- " + ipp);
        }
		*/
    }
}
/**
 * Representacao de um endereco IP, baseado em um conjunto de octetos.
 * 
 * @author Rodrigo
 */
class IPAddress {
    private OctetSet octets;
    IPAddress(OctetSet octetSet) {
        this.octets = octetSet;
    }
    IPAddress(String ipString) {
        this.octets = OctetSet.parse(ipString);
    }
    OctetSet getOctets() {
        return new OctetSet(octets);
    }
    @Override
    public String toString() {
        return octets.format();
    }
}
/**
 * Representacao de um mascara de rede, baseada em um conjunto de octetos.
 * @author Rodrigo
 *
 */
class Netmask {
    private OctetSet octets;
    Netmask(String maskString) {
        this.octets = OctetSet.parse(maskString);
    }
    OctetSet getOctets() {
    	return new OctetSet(octets);
    }
    @Override
    public String toString() {
    	return octets.format();
    }
}
/**
 * Armazena um conjunto de 4 bytes (octetos), apropriado para operações com endereços IP.
 * 
 * @author Rodrigo
 */
class OctetSet {
    private BitSet[] octets;
    /**
     * Constroi instancia a partir do valor numérico dos bytes.
     * @param octet1
     * @param octet2
     * @param octet3
     * @param octet4
     */
    OctetSet(short octet1, short octet2, short octet3, short octet4) {
        octets = new BitSet[] {
            toBits(octet1),
            toBits(octet2),
            toBits(octet3),
            toBits(octet4),
        };
    }
    /**
     * Clona uma outra instância.
     * @param octetSetToClone
     */
    OctetSet(OctetSet octetSetToClone) {
        this.octets = new BitSet[4];
        for (int i = 0; i < 4; i++) {
        	this.octets[i] = (BitSet) octetSetToClone.octets[i].clone();
        }
    }
    /**
     * Obtem instancia a partir de valores formatados no estilo endereço IP, 
     * por exemplo "111.111.111.111",
	 *
     * @param formattedOctetset
     * @return
     */
    static OctetSet parse(String formattedOctetset) {
    	String[] octetsStr = formattedOctetset.split("\\.");
        if (octetsStr.length != 4) {
            throw new IllegalArgumentException("Octetset deve conter 4 octetos");
        }
        OctetSet octetSet = new OctetSet(
            Short.parseShort(octetsStr[0]),
            Short.parseShort(octetsStr[1]),
            Short.parseShort(octetsStr[2]),
            Short.parseShort(octetsStr[3]));
        return octetSet;
    }
    /**
     * Formata octetset no estilo endereço IP.
     * @return
     */
    String format() {
        String result = fromBits(octets[0])
            + "." + fromBits(octets[1])
            + "." + fromBits(octets[2])
            + "." + fromBits(octets[3]);
        return result;
    }
    /**
     * Aplica operação lógica OR bit a bit.
     * A operação modifica o valor contido nesse objeto.
     * @param operand
     */
    void or(OctetSet operand) {
    	for (int i = 0; i < 4; i++) {
        	this.octets[i].or(operand.octets[i]);
        }
    }
    /**
     * Aplica operação lógica AND bit a bit.
     * A operação modifica o valor contido nesse objeto.
     * @param operand
     */
    void and(OctetSet operand) {
    	for (int i = 0; i < 4; i++) {
        	this.octets[i].and(operand.octets[i]);
        }
    }
    /**
     * Inverte o valor de cada bit contido nesse objeto.
     * @param operand
     */
    void flipAll() {
    	for (int i = 0; i < 4; i++) {
        	this.octets[i].flip(0, 8);
        }
    }
    /**
     * Adiciona "1" ao valor contido nesse objeto.
     * Exemplo:
     * 000.000.000.000 + 1  = 000.000.000.001
     * 000.000.000.254 + 1  = 000.000.000.255
     * 000.000.000.255 + 1  = 000.000.001.000
     * 029.255.255.255 + 1  = 030.000.000.000
     */
    void addOne() {
        final BitSet allOnes = new BitSet(8);
        allOnes.set(0, 8);
        if (octets[0].equals(allOnes)
        		&& octets[1].equals(allOnes)
        		&& octets[2].equals(allOnes)
        		&& octets[3].equals(allOnes)) {
        	// Todos estao no valor maximo (11111111), nada a fazer
        	return;
        }
        // Sera incrementado o ultimo octeto que ainda nao estiver com valor 11111111
        BitSet octetToIncrement = null;
        for (int i = 3; i >= 0; i--) {
            if (!octets[i].equals(allOnes)) {
            	// Este é o que sera incrementado
                octetToIncrement = octets[i];
                break;
            } else {
            	// Caso contrario, zera todas as posicoes para incremento do 
            	// proximo octeto mais significativo.
            	octets[i].clear();
            }
        }
        // Soma 1 ao byte selecionado
        for(int i = 7; i >= 0; i--) {
            if(!octetToIncrement.get(i)) {
                octetToIncrement.set(i);
                octetToIncrement.clear(i + 1, 8);
                break;
            }
        }
    }
    /**
    * Converte para binário o valor fornecido. Este bitset conterá exatamente 1 byte (8 bits),
    * com os bytes menos significativos à direita (indice 7).
    *
    * @param val Valor a ser convertido. Deve estar dentro do range
    * permitido para 1 byte (0-255)
    * @return
    */
    private BitSet toBits(short val) {
        if (val < 0 || val > 255) {
            throw new IllegalArgumentException("Numero invalido");
        }
        BitSet bytte = new BitSet(8);
        bytte.clear();
        final short[] pots = {128,64,32,16,8,4,2,1};
        /*
        * Utilizando algoritmo simplificado de sucessivas subtraçoes pelas potencias de 2
        */
        for (short i = 0; i < 8; i++) {
            if (val >= pots[i]) {
                bytte.set(i);
                val = (short) (val - pots[i]);
            }
        }
        return bytte;
    }
    /**
     * Converte de BitSet (binario) para valor numérico.
     * @param val
     * @return
     */
    private short fromBits(BitSet val) {
        final short[] pots = {128,64,32,16,8,4,2,1};
        short result = 0;
        for (short i = 7; i >= 0; i--) {
            if (val.get(i)) {
                result += pots[i];
            }
        }
        return result;
    }
    @Override
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if (obj.getClass() != this.getClass()) return false;
    	OctetSet other = (OctetSet) obj;
    	for (int i = 0; i < 4; i++) {
        	if(!this.octets[i].equals(other.octets[i])) return false;
        }
    	return true;
    }
}
/**
 * Utilitários para cálculos envolvendo endereços de rede.
 * 
 * @author Rodrigo
 */
class NetworkUtils {
    /**
    * Retorna o IP da rede.
    * @param ipAddress
    * @param netmask
    * @return
    */
    static IPAddress getBaseNetworkIP(IPAddress ipAddress, Netmask netmask) {
        OctetSet ipRedeOctets = ipAddress.getOctets();
        ipRedeOctets.and(netmask.getOctets());        
        return new IPAddress(ipRedeOctets);
    }
    /**
    * Retorna o IP de broadcast para a rede
    * @param ipAddress
    * @param netmask
    * @return
    */
    static IPAddress getBroadcastIP(IPAddress ipAddress, Netmask netmask) {
        OctetSet ipBroadcastOctets = ipAddress.getOctets();
        OctetSet flippedMask = netmask.getOctets();
        flippedMask.flipAll();
        ipBroadcastOctets.or(flippedMask);
        return new IPAddress(ipBroadcastOctets);
    }
    /**
    * Lista os enderecos IP validos na mesma rede do endereco informado
    * @param ipAddress
    * @param netmask
    * @return
    */
    static List<IPAddress> listAvailableIPAddresses(IPAddress ipAddress, Netmask netmask) {
        // Range vai do IP da rede até o IP de broadcast
        OctetSet ip = getBaseNetworkIP(ipAddress, netmask).getOctets();
        OctetSet limit = getBroadcastIP(ipAddress, netmask).getOctets();
        List<IPAddress> ips = new ArrayList<IPAddress>();
        while (true) {
            ip.addOne();
            if (ip.equals(limit)) {
                break;
            }
            ips.add(new IPAddress(new OctetSet(ip)));
        }
        return ips;
    }
}
