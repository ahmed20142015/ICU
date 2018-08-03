package com.marvelwall.ahmedpc.icu.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.marvelwall.ahmedpc.icu.R;
import com.marvelwall.ahmedpc.icu.activities.DoctorHome;

public class MangmentWizard extends Fragment {

    private OnFragmentInteractionListener mListener;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    public MangmentWizard() {
        // Required empty public constructor
    }


    public static MangmentWizard newInstance(String param1, String param2) {
        MangmentWizard fragment = new MangmentWizard();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mangment_wizard, container, false);
        LinearLayout mangment = view.findViewById(R.id.mangment);
        mangment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lood frament
                Fragment fragment = new Report();
                manager = getActivity().getSupportFragmentManager();
                if (manager == null)
                    manager = getActivity().getSupportFragmentManager();
                transaction = manager.beginTransaction();

                transaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                // transaction.replace(R.id.mainContent, fragment, "login").commit();
                transaction.replace(R.id.mainContenttwo, fragment, "Report").addToBackStack("Report").commit();
            }
        });

        DoctorHome.alarm.setVisibility(View.GONE);
        DoctorHome.samaa.setVisibility(View.VISIBLE);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
