public class test {
    public static void main(String[] args) {
        String str = "xbadxx";
        if (str.substring(0, 3).equals("bad") || str.substring(str.length() - 3, str.length()).equals("bad")) {
            System.out.println("bad");
        }
        System.out.println("Substring is |" + str.substring(0, 3) + "|");
    }
}