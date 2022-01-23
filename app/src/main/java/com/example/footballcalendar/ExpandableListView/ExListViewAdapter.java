package com.example.footballcalendar.ExpandableListView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.footballcalendar.R;

import java.util.List;
import java.util.Map;

public class ExListViewAdapter extends BaseExpandableListAdapter {

    private List<GroupObj> ListGroup;
    private Map<GroupObj, List<ItemObj>> ListItem;

    public ExListViewAdapter(List<GroupObj> listGroup, Map<GroupObj, List<ItemObj>> listItem) {
        ListGroup = listGroup;
        ListItem = listItem;
    }

    @Override
    public int getGroupCount() {
        if (ListGroup != null){
            return ListGroup.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if (ListGroup != null && ListItem != null){
            return ListItem.get(ListGroup.get(groupPosition)).size();
        }
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return ListGroup.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return ListItem.get(ListGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        GroupObj groupObj = ListGroup.get(groupPosition);
        return groupObj.getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        ItemObj itemObj  = ListItem.get(ListGroup.get(groupPosition)).get(childPosition);
        return itemObj.getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_group, parent, false);

        }

        TextView tvGroup = convertView.findViewById(R.id.tv_group);
        GroupObj groupObj = ListGroup.get(groupPosition);
        tvGroup.setText(groupObj.getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);

        }

        TextView tvItem = convertView.findViewById(R.id.tv_item);
        ItemObj itemObj = ListItem.get(ListGroup.get(groupPosition)).get(childPosition);
        tvItem.setText(itemObj.getName());

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
