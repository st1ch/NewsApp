package inc.itnity.elbilad.di.modules;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import inc.itnity.elbilad.data.repositories.ElbiladRepository;
import inc.itnity.elbilad.data.repositories.ElbiladRepositoryImpl;
import inc.itnity.elbilad.data.repositories.remote.ElbiladRemoteDataSource;
import inc.itnity.elbilad.data.repositories.remote.ElbiladRemoteDataSourceImpl;
import inc.itnity.elbilad.data.rest.ApiManager;
import inc.itnity.elbilad.data.rest.api.ElbiladAPI;
import inc.itnity.elbilad.domain.schedulers.ObserveOn;
import inc.itnity.elbilad.domain.schedulers.SubscribeOn;
import io.reactivecache.ReactiveCache;
import io.victoralbertos.jolyglot.GsonSpeaker;
import javax.inject.Singleton;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by st1ch on 15.01.17.
 */
@Module
public class ApplicationModule {
  private Context mContext;

  public ApplicationModule(Context context) {
    mContext = context;
  }

  @Provides public Context getContext() {
    return mContext;
  }

  @Provides SubscribeOn provideSubscribeOn() {
    return Schedulers::io;
  }

  @Provides ObserveOn provideObserverOn() {
    return AndroidSchedulers::mainThread;
  }

  @Provides @Singleton ReactiveCache provideReactiveCache(Context context) {
    return new ReactiveCache.Builder()
        .using(context.getFilesDir(), new GsonSpeaker());
  }

  @Provides @Singleton Gson provideGson() {
    return new GsonBuilder().serializeNulls().create();
  }

  @Provides @Singleton ApiManager provideApiManager(Gson gson) {
    return new ApiManager(gson);
  }

  @Provides @Singleton ElbiladAPI provideElbiladApi(ApiManager apiManager) {
    return apiManager.getRetrofit().create(ElbiladAPI.class);
  }

  @Provides @Singleton ElbiladRemoteDataSource provideElbiladRemoteDataSource(ElbiladAPI api) {
    return new ElbiladRemoteDataSourceImpl(api);
  }

  @Provides @Singleton ElbiladRepository provideElbiladRepository(
      ElbiladRemoteDataSource elbiladRemoteDataSource, ReactiveCache reactiveCache) {
    return new ElbiladRepositoryImpl(elbiladRemoteDataSource, reactiveCache);
  }
}
