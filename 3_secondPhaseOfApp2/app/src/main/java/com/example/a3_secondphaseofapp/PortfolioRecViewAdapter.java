
package com.example.a3_secondphaseofapp;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PortfolioRecViewAdapter extends RecyclerView.Adapter<PortfolioRecViewAdapter.ViewHolder> {
    private static final String TAG = "PortfolioViewAdapter";
    private ArrayList<Stock> stocks = new ArrayList<>();
    private Context mContext;

    public PortfolioRecViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_investment, parent,false );
        ViewHolder holder = new ViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: Called");
        holder.txtAmount.setText(stocks.get(position).getAmount());
        Glide.with(mContext)
                .asBitmap()
                .load(stocks.get(position).getImgSymbol())
                .into(holder.imgSymbol);
    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    public void setStocks(ArrayList<Stock> stocks) {
        this.stocks = stocks;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgSymbol;
        private TextView txtAmount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgSymbol = itemView.findViewById(R.id.imgSymbol);
            txtAmount = itemView.findViewById(R.id.txtAmount);
        }
    }

}
