package com.example.footballcalendar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.footballcalendar.HomeScreen.BundesLigaFragment;
import com.example.footballcalendar.HomeScreen.ChampionLeagueFragment;
import com.example.footballcalendar.HomeScreen.LaLigaFragment;
import com.example.footballcalendar.Interface.IClickItemTournamentListener;
import com.example.footballcalendar.SettingScreen.LanguageFragment;
import com.example.footballcalendar.HomeScreen.PremierLeagueFragment;
import com.example.footballcalendar.R;
import com.example.footballcalendar.Adapter.Tournament;
import com.example.footballcalendar.Adapter.TournamentAdapter;
import com.example.footballcalendar.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

//    private RecyclerView rcvTournament;
    private TournamentAdapter tournamentAdapter;

    FragmentHomeBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        tournamentAdapter = new TournamentAdapter(getListTournament(), new IClickItemTournamentListener() {
            @Override
            public void onClickItemTournament(Tournament tournament, int position) {
                onClickerItem(tournament, position);
            }
        });

        binding = FragmentHomeBinding.inflate(getLayoutInflater());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rcvTournament.setLayoutManager(linearLayoutManager);

        tournamentAdapter.setData(getListTournament());
        binding.rcvTournament.setAdapter(tournamentAdapter);
//        binding.rcvTournament.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
//            }
//        });


        return binding.getRoot();
    }

    private List<Tournament> getListTournament() {
        final List<Tournament> list = new ArrayList<>();
        list.add(new Tournament(R.drawable.logo_premier_league, "Premier League"));
        list.add(new Tournament(R.drawable.logo_champions_league, "Champions League"));
        list.add(new Tournament(R.drawable.logo_bundes_liga, "Bundes Liga"));
        list.add(new Tournament(R.drawable.logo_la_liga, "La Liga"));

        return list;
    }

    private void onMoveFragment() {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment language = new LanguageFragment();
        fragmentTransaction.replace(R.id.flFragment, language).commit();
    }

    private void onClickerItem(Tournament tournament, int position) {
//        Toast.makeText(getActivity(), "ok", Toast.LENGTH_SHORT).show();
        if (position == 0){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment premier = new PremierLeagueFragment();
            fragmentTransaction.replace(R.id.flFragment, premier).commit();
        }else if (position == 1){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment champion = new ChampionLeagueFragment();
            fragmentTransaction.replace(R.id.flFragment, champion).commit();
        }else if (position == 2){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment bundes = new BundesLigaFragment();
            fragmentTransaction.replace(R.id.flFragment, bundes).commit();
        }else if (position == 3){
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            Fragment la = new LaLigaFragment();
            fragmentTransaction.replace(R.id.flFragment, la).commit();
        }
//        Intent intent = new Intent(mContext, TestActivity.class);
////        Bundle bundle = new Bundle();
////        bundle.putSerializable("obj_tournament", tournament);
////        intent.putExtra(bundle);
//        mContext.startActivity(intent);
    }




}