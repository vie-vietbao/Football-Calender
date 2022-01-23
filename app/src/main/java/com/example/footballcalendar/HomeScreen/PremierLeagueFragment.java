package com.example.footballcalendar.HomeScreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.footballcalendar.Adapter.ListTournamentAdapter;
import com.example.footballcalendar.Fragment.HomeFragment;
import com.example.footballcalendar.R;
import com.example.footballcalendar.databinding.FragmentPremierLeagueBinding;


public class PremierLeagueFragment extends Fragment {

    FragmentPremierLeagueBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_premier_league, container, false);

        binding = FragmentPremierLeagueBinding.inflate(getLayoutInflater());

        int[] flImg1 = {R.drawable.chelsea, R.drawable.mu, R.drawable.everton};
        int[] flImg2 = {R.drawable.man_city, R.drawable.arsena, R.drawable.norwich_city};
        String[] flNameClub1 = {"Chelsea" , "Manchester United", "Everton"};
        String[] flScore1 = {"0", "4", "2"};
        String[] flNameClub2 = {"Manchester City", "Arsenal", "Norwich City"};
        String[] flScore2 = {"1", "1", "0"};
        String[] flResult = {"End", "End", "End"};

        ListTournamentAdapter listTournamentAdapter = new ListTournamentAdapter(getActivity(),  flNameClub1, flScore1, flNameClub2, flScore2 , flResult ,flImg1 ,flImg2);
        binding.lvPremier.setAdapter(listTournamentAdapter);
        binding.lvPremier.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "You click on " + flResult[position], Toast.LENGTH_SHORT).show();
            }
        });

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment home = new HomeFragment();
                fragmentTransaction.replace(R.id.flFragment, home).commit();
            }
        });


        return binding.getRoot();
    }
}