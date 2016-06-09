package parsing;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class XMLLoader {
    private static final String DESTINATION = "src/resources/afisha.xml";
    private static final String SOURCE = "http://kino-teatr.ua/ru/main/bill_export.phtml";
    public static long size = 500;

    public static void loadXML() throws IOException {

        ReadableByteChannel rbc = Channels.newChannel(new URL(SOURCE).openStream());
        FileOutputStream fos = new FileOutputStream(DESTINATION);
        size = fos.getChannel().size();
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        rbc.close();
        fos.close();

    }
}
