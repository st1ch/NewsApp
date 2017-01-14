package inc.itnity.elbilad.presentation.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import inc.itnity.elbilad.R;

/**
 * Created by st1ch on 14.01.17.
 */

public class HomeScreenFragment extends Fragment {

  public static HomeScreenFragment newInstance() {
    return new HomeScreenFragment();
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    View fragmentView = inflater.inflate(R.layout.fragment_home_screen, container, false);

    return fragmentView;
  }

}
