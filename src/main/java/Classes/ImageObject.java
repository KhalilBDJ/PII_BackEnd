package Classes;

import jakarta.persistence.*;


@Entity
public class ImageObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Lob
    private byte[] image;
    @Column(length = 1000)
    private String text;

    public ImageObject(String name, byte[] image, String text) {
        this.name = name;
        this.image = image;
        this.text = text;
    }

    public ImageObject() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }

    public String getText() {
        return text;
    }
}

