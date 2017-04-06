package inc.itnity.elbilad.domain.usecases;

import inc.itnity.elbilad.data.repositories.ElbiladRepository;
import inc.itnity.elbilad.domain.models.article.ArticleMostRead;
import inc.itnity.elbilad.domain.schedulers.ObserveOn;
import inc.itnity.elbilad.domain.schedulers.SubscribeOn;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by st1ch on 13.02.17.
 */

public class GetMostReadNewsUseCase extends UseCase<List<ArticleMostRead>> {

  private ElbiladRepository elbiladRepository;

  private boolean refresh;

  @Inject GetMostReadNewsUseCase(SubscribeOn subscribeOn, ObserveOn observeOn,
      ElbiladRepository elbiladRepository) {
    super(subscribeOn, observeOn);
    this.elbiladRepository = elbiladRepository;
  }

  public void setRefresh(boolean refresh) {
    this.refresh = refresh;
  }

  @Override protected Observable<List<ArticleMostRead>> getUseCaseObservable() {
    return elbiladRepository.getMostReadArticles(refresh);
  }
}