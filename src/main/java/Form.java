
  public class Form {
    private int id;
    private String title;
    private String content;

    public Form(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }

    public void displayForm() {
        System.out.println("Form ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
    }

   
}

