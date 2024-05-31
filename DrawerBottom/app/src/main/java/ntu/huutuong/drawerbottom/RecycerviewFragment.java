package ntu.huutuong.drawerbottom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycerviewFragment extends Fragment {

    RecyclerView recyclerView;
    List<Item> itemList;
    String[] newTvName;
    int[] newImageItem;
    public RecycerviewFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_recycerview, container, false);
        itemList = itemListData();
        recyclerView = rootView.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemAdapter itemAdapter = new ItemAdapter((ArrayList<Item>) itemList);
        recyclerView.setAdapter(itemAdapter);
        return  rootView;
    }
    private List<Item> itemListData(){
        List<Item> itemListData = new ArrayList<>();
        itemListData.add(new Item("Item 1", R.drawable.user));
        itemListData.add(new Item("Item 2", R.drawable.user));
        itemListData.add(new Item("Item 3", R.drawable.user));
        itemListData.add(new Item("Item 4", R.drawable.user));
        itemListData.add(new Item("Item 5", R.drawable.user));
        itemListData.add(new Item("Item 6", R.drawable.user));
        itemListData.add(new Item("Item 7", R.drawable.user));
        itemListData.add(new Item("Item 8", R.drawable.user));
        itemListData.add(new Item("Item 9", R.drawable.user));
        itemListData.add(new Item("Item 1", R.drawable.user));
        itemListData.add(new Item("Item 2", R.drawable.user));
        itemListData.add(new Item("Item 3", R.drawable.user));
        itemListData.add(new Item("Item 4", R.drawable.user));
        itemListData.add(new Item("Item 5", R.drawable.user));
        itemListData.add(new Item("Item 6", R.drawable.user));
        itemListData.add(new Item("Item 7", R.drawable.user));
        itemListData.add(new Item("Item 8", R.drawable.user));
        itemListData.add(new Item("Item 9", R.drawable.user));
        itemListData.add(new Item("Item 1", R.drawable.user));
        itemListData.add(new Item("Item 2", R.drawable.user));
        itemListData.add(new Item("Item 3", R.drawable.user));
        itemListData.add(new Item("Item 4", R.drawable.user));
        itemListData.add(new Item("Item 5", R.drawable.user));
        itemListData.add(new Item("Item 6", R.drawable.user));
        itemListData.add(new Item("Item 7", R.drawable.user));
        itemListData.add(new Item("Item 8", R.drawable.user));
        itemListData.add(new Item("Item 9", R.drawable.user));

        return itemListData;
    }
}