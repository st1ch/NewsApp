package inc.itnity.elbilad.domain.interceptors;

import inc.itnity.elbilad.constants.ApiConfig;
import java.io.IOException;
import javax.inject.Inject;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderAuthInterceptor implements Interceptor {

    @Inject
    public HeaderAuthInterceptor() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("authorization", ApiConfig.TOKEN)
                .build();
        return chain.proceed(request);
    }
}
