package thi.Tuong_63131631.Dethi1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FamousCityFragment extends Fragment {

    RecyclerView recyclerView;
    List<Item> itemList;
    String[] newTvName;
    int[] newImageItem;
    public FamousCityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_famouscity, container, false);
        itemList = itemListData();
        recyclerView = rootView.findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemAdapter itemAdapter = new ItemAdapter((ArrayList<Item>) itemList);
        recyclerView.setAdapter(itemAdapter);
        return  rootView;
    }
    private List<Item> itemListData(){
        List<Item> itemListData = new ArrayList<>();
        itemListData.add(new Item("Nha Trang", R.drawable.nhatrang, "Việt Nam"));
        itemListData.add(new Item("Đà Nẵng", R.drawable.danang, "Việt Nam"));
        itemListData.add(new Item("Vũng Tàu", R.drawable.vungtau, "Việt Nam"));
        itemListData.add(new Item("Paris", R.drawable.paris, "Pháp"));
        return itemListData;
    }
}