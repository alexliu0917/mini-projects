public class defangIPAddress {
    public static void main(String[] args) {
        System.out.println(defangIPaddr("192.168.1.1"));
    }

    public static String defangIPaddr(String address) { // takes an IP address (or web address) and inserts brackets around the decimals
        String temp = "";
        int loc = 0;
        for (int i = 0; i < address.length() - 2; i++) { // helps iterate through every character in the string
            if (address.charAt(i+1) == '.') { // if a decimal is detected in the next character
                temp += address.substring(loc, i+1) + "[.]"; //replace it
                loc = i + 2; // the next location will start after the inserted brackets
            }  
        }
        temp += address.substring(loc, address.length()); // append the last couple of digits of the address
        return temp;
    }
}