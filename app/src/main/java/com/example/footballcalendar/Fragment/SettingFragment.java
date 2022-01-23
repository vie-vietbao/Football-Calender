package com.example.footballcalendar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.footballcalendar.SettingScreen.LanguageFragment;
import com.example.footballcalendar.Adapter.ListGroupAdapter;
import com.example.footballcalendar.R;
import com.example.footballcalendar.SettingScreen.ThemeFragment;
import com.example.footballcalendar.databinding.FragmentSettingBinding;


public class SettingFragment extends Fragment {
//
//    private ExpandableListView exListView;
//    private List<GroupObj> ListGroup;
//    private Map<GroupObj, List<ItemObj>> ListItem;
//    private ExListViewAdapter exListViewAdapter;

    FragmentSettingBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

//        ExpandableListView cho list setting
//
//        exListView = view.findViewById(R.id.exListView);
//        ListItem = getListItem();
//        ListGroup = new ArrayList<>(ListItem.keySet());
//
//        exListViewAdapter = new ExListViewAdapter(ListGroup, ListItem);
//        exListView.setAdapter(exListViewAdapter);
//        exListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                if (groupPosition == 0 && childPosition == 0) {
//                    Toast.makeText(getActivity(), "1", Toast.LENGTH_SHORT).show();
//                }else if (groupPosition == 0 && childPosition == 1){
//                    Toast.makeText(getActivity(), "2", Toast.LENGTH_SHORT).show();
//                }else if (groupPosition == 1 && childPosition == 0){
//                    Toast.makeText(getActivity(), "3", Toast.LENGTH_SHORT).show();
//                }else if (groupPosition == 1 && childPosition == 1){
//                    Toast.makeText(getActivity(), "4", Toast.LENGTH_SHORT).show();
//                }
//                return false;
//            }
//        });

        binding = FragmentSettingBinding.inflate(getLayoutInflater());

        String[] flName = {"Language", "Theme"};
        int[] flImg = {R.drawable.ic_arrow_right_white, R.drawable.ic_arrow_right_white};

        ListGroupAdapter listGroupAdapter = new ListGroupAdapter(getActivity(), flName, flImg);
        binding.lvSetting.setAdapter(listGroupAdapter);
        binding.lvSetting.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getActivity(), "You click on " + flName[position], Toast.LENGTH_SHORT).show();
                if (position == 0) {
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment language = new LanguageFragment();
                    fragmentTransaction.replace(R.id.flFragment, language).commit();
                }else if (position == 1){
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    Fragment language = new ThemeFragment();
                    fragmentTransaction.add(R.id.flFragment, language).commit();
                }
            }
        });


        return binding.getRoot();


    }


//    private Map<GroupObj, List<ItemObj>> getListItem () {
//        Map<GroupObj, List<ItemObj>> listMap = new HashMap<>();
//
//        GroupObj groupObj1 = new GroupObj(1, "Language");
//        GroupObj groupObj2 = new GroupObj(2, "Theme");
//
//        List<ItemObj> objList1 = new ArrayList<>();
//        objList1.add(new ItemObj(1, "Vietnamese"));
//        objList1.add(new ItemObj(2, "English"));
//
//        List<ItemObj> objList2 = new ArrayList<>();
//        objList2.add(new ItemObj(3, "Light"));
//        objList2.add(new ItemObj(4, "Dark"));
//
//        listMap.put(groupObj1, objList1);
//        listMap.put(groupObj2, objList2);
//
//        return listMap;
//    }
//
}