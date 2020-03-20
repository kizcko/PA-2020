import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {

    private static Catalog deserializedCatalog;
    private Object IOException;

    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            objectOutputStream.writeObject(catalog);
        }
    }

    public static Catalog load(String path) throws IOException,ClassNotFoundException {

            try(ObjectInputStream objectInputStream=new ObjectInputStream(new FileInputStream(path))){
                Catalog catalog= (Catalog) objectInputStream.readObject();
                return catalog;
            }
    }


    public static void view(Document document) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        String location = document.getLocation();
        if (location.startsWith("https://")){
            desktop.browse(URI.create(location));
        }
        else{
            File file = new File(location);
            if(file.exists()){
                desktop.open(file);
            }
        }
    }

    public class InvalidCatalogException extends Exception {
        public InvalidCatalogException(Exception ex) {
            super("Invalid catalog file.", ex);
        }
    }


}
