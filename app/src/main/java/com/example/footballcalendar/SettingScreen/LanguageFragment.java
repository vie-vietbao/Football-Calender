package com.example.footballcalendar.SettingScreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.footballcalendar.Adapter.ListOptionAdapter;
import com.example.footballcalendar.Fragment.SettingFragment;
import com.example.footballcalendar.R;
import com.example.footballcalendar.databinding.FragmentLanguageBinding;


public class LanguageFragment extends Fragment {

    FragmentLanguageBinding binding;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_language, container, false);

//        view.findViewById(R.id.imgBack).setOnClickListener(v -> getActivity().onBackPressed());


        binding = FragmentLanguageBinding.inflate(getLayoutInflater());

        String[] flName = {"Vietnamese", "English"};
        int[] flImg = {R.drawable.logo_none, R.drawable.ic_done_white};

        ListOptionAdapter listOptionAdapter = new ListOptionAdapter(getActivity(), flName, flImg);
        binding.lvSettingObj.setAdapter(listOptionAdapter);
        binding.lvSettingObj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "You click on " + flName[position], Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    String[] flName = {"Vietnamese", "English"};
                    int[] flImg = {R.drawable.ic_done_white, R.drawable.logo_none};

                    ListOptionAdapter listOptionAdapter = new ListOptionAdapter(getActivity(), flName, flImg);
                    binding.lvSettingObj.setAdapter(listOptionAdapter);
                }else if (position == 1){
                    String[] flName = {"Vietnamese", "English"};
                    int[] flImg = {R.drawable.logo_none, R.drawable.ic_done_white};

                    ListOptionAdapter listOptionAdapter = new ListOptionAdapter(getActivity(), flName, flImg);
                    binding.lvSettingObj.setAdapter(listOptionAdapter);
                }
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment language = new SettingFragment();
                fragmentTransaction.replace(R.id.flFragment, language).commit();
            }
        });

        return binding.getRoot();

//        return view;


    }




}