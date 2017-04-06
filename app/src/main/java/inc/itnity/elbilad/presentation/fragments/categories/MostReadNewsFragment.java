package inc.itnity.elbilad.presentation.fragments.categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import inc.itnity.elbilad.R;
import inc.itnity.elbilad.domain.models.article.ArticleMostRead;
import inc.itnity.elbilad.presentation.activities.MainActivity;
import inc.itnity.elbilad.presentation.activities.base.AbstractBaseActivity;
import inc.itnity.elbilad.presentation.adapters.MostReadNewsAdapter;
import inc.itnity.elbilad.presentation.custom.VerticalSpaceItemDecoration;
import inc.itnity.elbilad.presentation.fragments.base.AbstractBaseFragment;
import inc.itnity.elbilad.presentation.presenters.MostReadNewsPresenter;
import inc.itnity.elbilad.presentation.views.MostReadNewsView;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by st1ch on 18.01.17.
 */

public class MostReadNewsFragment extends AbstractBaseFragment implements MostReadNewsView {

  public static MostReadNewsFragment newInstance() {
    return new MostReadNewsFragment();
  }

  @BindView(R.id.rv_news) RecyclerView rvNews;

  @BindView(R.id.swipe_layout) SwipeRefreshLayout swipeRefreshLayout;

  @Inject MostReadNewsPresenter presenter;

  @Inject MostReadNewsAdapter categoryNewsAdapter;

  @Override public int getContentView() {
    return R.layout.fragment_last_news;
  }

  @Override public void injectComponent() {
    MainActivity.getMainActivityComponent().inject(this);
  }

  @Override protected void bindPresenter() {
    presenter.bind(this);
  }

  @Override protected void unbindPresenter() {
    presenter.onDestroy();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    ((AbstractBaseActivity) getActivity()).showHomeToolbar();
    ((AbstractBaseActivity) getActivity()).hideTitleLogo();
    ((AbstractBaseActivity) getActivity()).setTitleToolBar(getString(R.string.news_most_read));

    View rootView = super.onCreateView(inflater, container, savedInstanceState);

    initContent();

    presenter.onCreate();

    return rootView;
  }

  private void initContent() {
    swipeRefreshLayout.setEnabled(false);

    rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
    rvNews.addItemDecoration(new VerticalSpaceItemDecoration());
    rvNews.setAdapter(categoryNewsAdapter);
  }

  @Override public void showArticles(List<ArticleMostRead> articles) {
    categoryNewsAdapter.setArticles(articles);
  }

  @Override public void showProgress() {
    swipeRefreshLayout.setRefreshing(true);
  }

  @Override public void hideProgress() {
    swipeRefreshLayout.setRefreshing(false);
  }
}