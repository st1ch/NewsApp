package inc.itnity.elbilad.domain.models.article;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 * Created by st1ch on 15.01.17.
 */

public class Article {

  @SerializedName("id") private int id;
  @SerializedName("titre") private String title;
  @SerializedName("categorie_id") private int categoryId;
  @SerializedName("categorie_titre") private int categoryTitle;
  @SerializedName("date") private Date date;
  @SerializedName("image") private String image;
  @SerializedName("imageText") private String imageText;
  @SerializedName("auteur") private String author;
  @SerializedName("resume") private String preview;
  @SerializedName("text") private String text;
  @SerializedName("youtube_code") private String youtubeCode;
  //@SerializedName("_links") private Links links;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  public int getCategoryTitle() {
    return categoryTitle;
  }

  public void setCategoryTitle(int categoryTitle) {
    this.categoryTitle = categoryTitle;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getImageText() {
    return imageText;
  }

  public void setImageText(String imageText) {
    this.imageText = imageText;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getPreview() {
    return preview;
  }

  public void setPreview(String preview) {
    this.preview = preview;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getYoutubeCode() {
    return youtubeCode;
  }

  public void setYoutubeCode(String youtubeCode) {
    this.youtubeCode = youtubeCode;
  }

  @Override public String toString() {
    return "Article{"
        + "id="
        + id
        + ", title='"
        + title
        + '\''
        + ", categoryId="
        + categoryId
        + ", categoryTitle="
        + categoryTitle
        + ", date="
        + date
        + ", image='"
        + image
        + '\''
        + ", imageText='"
        + imageText
        + '\''
        + ", author='"
        + author
        + '\''
        + ", preview='"
        + preview
        + '\''
        + ", text='"
        + text
        + '\''
        + ", youtubeCode='"
        + youtubeCode
        + '\''
        + '}';
  }
}
