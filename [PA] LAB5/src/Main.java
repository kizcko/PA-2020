import java.io.IOException;

public class Main {

    public static void main(String[] args)  {
    Main app = new Main();
        try {
            app.testCreateSave();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            app.testLoadView();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("Java Resources", "/Users/macbook/Desktop/Java res/catalog.ser");
        Document document = new Document("java1","Java Course 1","https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        document.addTag("type","Slides");


        catalog.add(document);
        CatalogUtil.save(catalog);
        System.out.println(catalog);
    }

    private void testLoadView() throws IOException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("/Users/macbook/Desktop/Java res/catalog.ser"); Document document = catalog.findById("java1");
        CatalogUtil.view(document);
    }

}
