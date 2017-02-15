package inc.itnity.elbilad.di.modules;

import android.support.v7.app.AppCompatActivity;
import dagger.Module;
import dagger.Provides;
import inc.itnity.elbilad.di.MainActivityScope;
import inc.itnity.elbilad.domain.buses.OpenTabRxBus;
import inc.itnity.elbilad.domain.usecases.AddBookmarkUseCase;
import inc.itnity.elbilad.domain.usecases.GetArticleUseCase;
import inc.itnity.elbilad.domain.usecases.GetBookmarksUseCase;
import inc.itnity.elbilad.domain.usecases.GetCategoriesUseCase;
import inc.itnity.elbilad.domain.usecases.GetCategoryArticlesUseCase;
import inc.itnity.elbilad.domain.usecases.GetHomeArticlesUseCase;
import inc.itnity.elbilad.domain.usecases.GetLastNewsArticlesUseCase;
import inc.itnity.elbilad.domain.usecases.GetLastVideosUseCase;
import inc.itnity.elbilad.domain.usecases.GetPhotosUseCase;
import inc.itnity.elbilad.domain.usecases.GetVideosUseCase;
import inc.itnity.elbilad.presentation.presenters.ArticleDetailsPresenter;
import inc.itnity.elbilad.presentation.presenters.ArticleDetailsPresenterImpl;
import inc.itnity.elbilad.presentation.presenters.BaseHomePresenter;
import inc.itnity.elbilad.presentation.presenters.BaseHomePresenterImpl;
import inc.itnity.elbilad.presentation.presenters.BookmarksPresenter;
import inc.itnity.elbilad.presentation.presenters.BookmarksPresenterImpl;
import inc.itnity.elbilad.presentation.presenters.HomeScreenPresenter;
import inc.itnity.elbilad.presentation.presenters.HomeScreenPresenterImpl;
import inc.itnity.elbilad.presentation.presenters.MainMenuPresenter;
import inc.itnity.elbilad.presentation.presenters.MainMenuPresenterImpl;
import inc.itnity.elbilad.presentation.presenters.PhotoCategoryPresenter;
import inc.itnity.elbilad.presentation.presenters.PhotoCategoryPresenterImpl;
import inc.itnity.elbilad.presentation.presenters.SimpleNewsPresenter;
import inc.itnity.elbilad.presentation.presenters.SimpleNewsPresenterImpl;
import inc.itnity.elbilad.presentation.presenters.VideoCategoryPresenter;
import inc.itnity.elbilad.presentation.presenters.VideoCategoryPresenterImpl;
import inc.itnity.elbilad.utils.DialogHelper;

/**
 * Created by st1ch on 20.01.17.
 */
@Module public class MainActivityModule {

  @Provides @MainActivityScope DialogHelper provideDialogHelper(AppCompatActivity activity) {
    return new DialogHelper(activity);
  }

  @Provides HomeScreenPresenter provideHomeScreenPresenter(
      GetHomeArticlesUseCase getHomeArticlesUseCase) {
    return new HomeScreenPresenterImpl(getHomeArticlesUseCase);
  }

  @Provides MainMenuPresenter provideMainMenuPresenter(GetCategoriesUseCase getCategoriesUseCase,
      OpenTabRxBus openTabRxBus) {
    return new MainMenuPresenterImpl(getCategoriesUseCase, openTabRxBus);
  }

  @Provides BaseHomePresenter provideBaseHomePresenter(GetCategoriesUseCase getCategoriesUseCase) {
    return new BaseHomePresenterImpl(getCategoriesUseCase);
  }

  @Provides SimpleNewsPresenter provideSimpleNewsPresenter(
      GetCategoryArticlesUseCase getCategoryArticlesUseCase) {
    return new SimpleNewsPresenterImpl(getCategoryArticlesUseCase);
  }

  @Provides ArticleDetailsPresenter provideArticleDetailsPresenter(
      GetArticleUseCase getArticleUseCase, GetLastVideosUseCase getLastVideosUseCase,
      GetLastNewsArticlesUseCase getLastNewsArticlesUseCase,
      AddBookmarkUseCase addBookmarkUseCase) {
    return new ArticleDetailsPresenterImpl(getArticleUseCase, getLastVideosUseCase,
        getLastNewsArticlesUseCase, addBookmarkUseCase);
  }

  @Provides VideoCategoryPresenter provideVideoCategoryPresenter(
      GetVideosUseCase getVideosUseCase) {
    return new VideoCategoryPresenterImpl(getVideosUseCase);
  }

  @Provides PhotoCategoryPresenter providePhotoCategoryPresenter(
      GetPhotosUseCase getPhotosUseCase) {
    return new PhotoCategoryPresenterImpl(getPhotosUseCase);
  }

  @Provides BookmarksPresenter provideBookmarksPresenter(GetBookmarksUseCase getBookmarksUseCase) {
    return new BookmarksPresenterImpl(getBookmarksUseCase);
  }
}
