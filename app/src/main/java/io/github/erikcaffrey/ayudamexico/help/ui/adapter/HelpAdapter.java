package io.github.erikcaffrey.ayudamexico.help.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import io.github.erikcaffrey.ayudamexico.R;
import io.github.erikcaffrey.ayudamexico.help.model.Hospital;
import io.github.erikcaffrey.ayudamexico.help.presenter.HelpPresenter;

/**
 * Created by hackro on 21/09/17.
 */

public class HelpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    private List<Hospital> hospitalList;
    private HelpPresenter presenter;

    public HelpAdapter(HelpPresenter presenter) {
        this.presenter = presenter;
        this.hospitalList = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.help_card,parent,false);
        return new HelpHolder(view, presenter);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HelpHolder helpHolder = (HelpHolder ) holder;
        helpHolder.render(hospitalList.get(position));
    }

    @Override
    public int getItemCount() {
        return hospitalList.size();
    }

    public void setHospitalList(List<Hospital> hospitalList) {
        this.hospitalList = hospitalList;
        notifyDataSetChanged();
    }
}
