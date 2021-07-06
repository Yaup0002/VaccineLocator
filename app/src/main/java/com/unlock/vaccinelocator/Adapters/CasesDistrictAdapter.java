package com.unlock.vaccinelocator.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.unlock.vaccinelocator.Models.CasesDistrict;
import com.unlock.vaccinelocator.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

import java.text.Format;
import java.util.ArrayList;
import java.util.Locale;

public class CasesDistrictAdapter extends RecyclerView.Adapter<CasesDistrictAdapter.MyViewHolder> {
    ArrayList<CasesDistrict> casesDistricts;
    Context mContext;

    public CasesDistrictAdapter(ArrayList<CasesDistrict> casesDistricts, Context mContext) {
        this.casesDistricts = casesDistricts;
        this.mContext = mContext;
    }

    public void filterList(ArrayList<CasesDistrict> filterllist) {
        casesDistricts = filterllist;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public CasesDistrictAdapter.MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_cases,parent,false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull CasesDistrictAdapter.MyViewHolder holder, int position) {
        Format format = NumberFormat.getNumberInstance(new Locale("en","in"));
        holder.t21.setText(casesDistricts.get(position).getDis_name());
        holder.t22.setText(format.format(casesDistricts.get(position).getActive_dis()));
        holder.t23.setText(format.format(casesDistricts.get(position).getConfirmed_dis())+" ( +"+format.format(casesDistricts.get(position).getChng_conf_dis())+")");
        holder.t24.setText(format.format(casesDistricts.get(position).getRec_dis())+" ( +"+format.format(casesDistricts.get(position).getChng_rec_dis())+")");
        holder.t25.setText(format.format(casesDistricts.get(position).getDec_dis())+" ( +"+format.format(casesDistricts.get(position).getChng_dec_dis())+")");
        holder.t26.setText("abc");
    }

    @Override
    public int getItemCount() {
        return casesDistricts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView t21,t22,t23,t24,t25,t26;
        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            t21 = itemView.findViewById(R.id.stateName);
            t22 = itemView.findViewById(R.id.active_val);
            t23 = itemView.findViewById(R.id.conf_value);
            t24 = itemView.findViewById(R.id.recov_val);
            t25 = itemView.findViewById(R.id.dec_val);
            t26 = itemView.findViewById(R.id.date_cases);
        }
    }
}