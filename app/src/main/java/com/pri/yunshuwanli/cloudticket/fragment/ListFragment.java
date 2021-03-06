package com.pri.yunshuwanli.cloudticket.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pri.yunshuwanli.cloudticket.R;
import com.pri.yunshuwanli.cloudticket.adapter.RecordListAdapter;
import com.pri.yunshuwanli.cloudticket.entry.OrderInfo;
import com.pri.yunshuwanli.cloudticket.entry.PrinterAsyncTask;

import java.util.ArrayList;

import yswl.com.klibrary.base.MFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends MFragment {

    public static ListFragment getInstance(ArrayList<OrderInfo> list) {
        ListFragment fragment = new ListFragment();
        Bundle bundle = getBundle(list);
        fragment.setArguments(bundle);
        return fragment;
    }

    public static Bundle getBundle(ArrayList<OrderInfo> list) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("list", list);
        return bundle;
    }

    public void setList(ArrayList<OrderInfo> list) {
        myAdapter.setList(list);
        myAdapter.notifyDataSetChanged();
    }

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    RecyclerView mRecyclerView;
    RecordListAdapter myAdapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRecyclerView = view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myAdapter = new RecordListAdapter(getActivity(), getData(), R.layout.item_list_record);
        myAdapter.setOnClickListener(new RecordListAdapter.OnClickListener() {
            @Override
            public void onClick(OrderInfo info) {
                new PrinterAsyncTask(ListFragment.this.getMActivity(),null).execute(info);
            }
        });
        mRecyclerView.setAdapter(myAdapter);
    }



    private ArrayList<OrderInfo> getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            return bundle.getParcelableArrayList("list");
        }
        return null;
    }


}



