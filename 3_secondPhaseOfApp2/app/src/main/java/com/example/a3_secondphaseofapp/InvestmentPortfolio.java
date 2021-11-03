package com.example.a3_secondphaseofapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class InvestmentPortfolio extends AppCompatActivity {
    private RecyclerView portfolioRecView;
    private PortfolioRecViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_portfolio);

        adapter = new PortfolioRecViewAdapter(this);
        portfolioRecView = findViewById(R.id.investRecView);

        portfolioRecView.setAdapter(adapter);
        portfolioRecView.setLayoutManager(new GridLayoutManager(this, 2));

        ArrayList<Stock> stocks = new ArrayList<>();
        stocks.add(new Stock("10%", "https://www.advfn.com/common/images/company/N_FB.png", "Facebook" ));
        stocks.add(new Stock("20%", "https://lh3.googleusercontent.com/proxy/Rl5q4qGlZRmkjA6SCKrsv93aNeOSw_XWjGyEXLHJdzHf4PontPVf6Uj-WLYBR1siUYIbaCLB2KLgN1gACx8rR-gu1k3tZJtK1Hi7VAzvaUPRFJ2kWJ5IOEfNcmdEY-kZblInEXIxir3XspowsCrTCPtIiDhLTqU", "Amazon" ));
        stocks.add(new Stock("10%", "https://g.foolcdn.com/art/companylogos/square/tsla.png", "Tesla" ));
        stocks.add(new Stock("10%", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTqTLM2SFndzzEqFJ4JgHGhMpV-682Nc_Yu-w&usqp=CAU", "GameStop" ));
        stocks.add(new Stock("10%", "https://mma.prnewswire.com/media/844957/Zillow_Group_Logo.jpg?p=facebook", "Zillow" ));
        stocks.add(new Stock("10%", "https://upload.wikimedia.org/wikipedia/en/d/d0/Dogecoin_Logo.png", "Dogecoin" ));
        stocks.add(new Stock("10%", "https://pbs.twimg.com/profile_images/2246877329/RIT-ETC.gif", "Ethereum Classic" ));
        stocks.add(new Stock("10%", "https://pngimg.com/uploads/bitcoin/bitcoin_PNG48.png", "Bitcoin" ));

        adapter.setStocks(stocks);
    }
}