import core.data.*;

public class awesomefile {
    public static void main(String[] args) {
        DataSource ds = DataSource.connect("https://www.w3schools.com/xml/note.xml");
        ds.load();
        ds.printUsageString();
    }
}