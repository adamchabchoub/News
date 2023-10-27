package com.example.news;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView newsRecycler;
    private List<News> newsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newsRecycler = findViewById(R.id.newsList);
        newsRecycler.setLayoutManager(new LinearLayoutManager(this));
        newsRecycler.setItemAnimator(new DefaultItemAnimator());
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        newsRecycler.addItemDecoration(dividerItemDecoration);

        Adapter adapter = new Adapter(newsList, this);
        newsRecycler.setAdapter(adapter);

        for(int i= 0;i<5;i++)
        {
            newsList.add(new News(R.drawable.news_image_1, "Israel bombing al Ahly hospital", "On Tuesday, the Israeli military dropped a massive GPS-guided bomb on the Al-Ahli Arab Baptist Hospital in Gaza City, killing more than 500 medical personnel, patients and refugees. The hospital, operated by the Anglican Christian Church, had been sheltering over 1,000 people who were displaced by the bombing. Doctors and medical staff at the hospital had courageously refused Israeli demands that they relocate further south, stating that there were not enough beds in southern Gaza to accommodate their critically wounded patients."));
            newsList.add(new News(R.drawable.news_image_2, "Israel airstrikes Gaza", "Israel escalated airstrikes across the Gaza Strip on Tuesday, crushing families in the rubble of residential buildings, as health officials said hundreds of Palestinians were killed in the past day and medical facilities were shut down because of bomb damage and lack of power."));
            newsList.add(new News(R.drawable.news_image_3, "Hamas releases two hostages", "In a statement on Monday, spokesperson Abu Obeida said on the group’s Telegram channel that the captives had been released for “humanitarian reasons and poor health grounds. The release of the two hostages, 85-year-old Yocheved Lifshitz and 79-year-old Nurit Cooper, was confirmed by the ICRC.\n" +"\n" + "“We hope they will soon be back with their loved ones,” it said on X, formerly Twitter."));
        }

        adapter.notifyDataSetChanged();
    }

}
