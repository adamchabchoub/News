package com.example.news;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NewsDetails extends AppCompatActivity {
    private int image;
    private String title;
    private String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_details);

        image = getIntent().getIntExtra("image", 0);
        title = getIntent().getStringExtra("title");
        description = getIntent().getStringExtra("description");

        ImageView newsImage = findViewById(R.id.newsImage);
        TextView newsTitle = findViewById(R.id.newsTitle);
        TextView newsDescription = findViewById(R.id.newsDescription);

        newsImage.setImageResource(image);
        newsTitle.setText(title);
        newsDescription.setText(description);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_share,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected (MenuItem item){
        int id= item.getItemId();
        if(id == R.id.share)
            sendEmail();
        return true;

    }
    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, title);
        emailIntent.putExtra(Intent.EXTRA_TEXT, description);
        startActivity(Intent.createChooser(emailIntent, "Send Email"));
    }
}
