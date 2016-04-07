package com.melo.weather.weatherlive.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.melo.weather.weatherlive.R;
import com.melo.weather.weatherlive.view.LifeContentView;
import com.melo.weather.weatherlive.vo.Life;
import com.melo.weather.weatherlive.vo.LifeInfo;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LifeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LifeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LifeFragment extends Fragment {

    private static final String LIFE_CONTENT = "life_content";

    private Life life;
    private LifeInfo lifeInfo;
    private LinearLayout mlinearlayout;

    public LifeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment LifeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LifeFragment newInstance(Life life) {
        LifeFragment fragment = new LifeFragment();
        Bundle args = new Bundle();
        args.putSerializable(LIFE_CONTENT,life);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            life = (Life) getArguments().getSerializable(LIFE_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_life, container, false);
        mlinearlayout = (LinearLayout) view.findViewById(R.id.tv_life_content);
        initData();
        LifeContentView lifeContentView = new LifeContentView(getActivity());
        lifeContentView.setText("空调",lifeInfo.getKongtiao().get(0),lifeInfo.getKongtiao().get(1));
        mlinearlayout.addView(lifeContentView);

        LifeContentView lifeContentView1 = new LifeContentView(getActivity());
        lifeContentView1.setText("运动",lifeInfo.getYundong().get(0),lifeInfo.getYundong().get(1));
        mlinearlayout.addView(lifeContentView1);

        LifeContentView lifeContentView2 = new LifeContentView(getActivity());
        lifeContentView2.setText("ziwaixian",lifeInfo.getZiwaixian().get(0),lifeInfo.getZiwaixian().get(1));
        mlinearlayout.addView(lifeContentView2);

        LifeContentView lifeContentView3 = new LifeContentView(getActivity());
        lifeContentView3.setText("ganmao",lifeInfo.getGanmao().get(0),lifeInfo.getGanmao().get(0));
        mlinearlayout.addView(lifeContentView3);

        LifeContentView lifeContentView4 = new LifeContentView(getActivity());
        lifeContentView4.setText("xiche",lifeInfo.getXiche().get(0),lifeInfo.getXiche().get(1));
        mlinearlayout.addView(lifeContentView4);

        LifeContentView lifeContentView5 = new LifeContentView(getActivity());
        lifeContentView5.setText("wuran",lifeInfo.getWuran().get(0),lifeInfo.getWuran().get(1));
        mlinearlayout.addView(lifeContentView5);

        LifeContentView lifeContentView6 = new LifeContentView(getActivity());
        lifeContentView6.setText("chuanyi",lifeInfo.getChuanyi().get(0),lifeInfo.getChuanyi().get(1));
        mlinearlayout.addView(lifeContentView6);
        return view;
    }

    private void initData(){
        lifeInfo = life.getInfo();
    }
    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
