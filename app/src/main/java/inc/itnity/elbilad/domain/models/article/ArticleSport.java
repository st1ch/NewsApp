package inc.itnity.elbilad.domain.models.article;

/**
 * Created by st1ch on 10.02.17.
 */

public class ArticleSport extends Article {
  @Override
  public int getType() {
    return TYPE.SPORT;
  }
}