package com.artsystem.gmailapplocal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.artsystem.gmailapplocal.data.FakeDataSource;
import com.artsystem.gmailapplocal.maillist.MailAdapter;
import com.artsystem.gmailapplocal.maillist.MailDiffUtilCallback;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;



public class MainActivity extends AppCompatActivity {

    private RecyclerView mailRecyclerView,navRecyclerview;
    private MailAdapter mailAdapter;
    private ExtendedFloatingActionButton extFab;
    private ImageView iconDL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int selectedThemeID = R.style.AppTheme;
        setTheme(selectedThemeID);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // if light theme is selected we change to light status bar
        if (selectedThemeID == R.style.AppTheme) {
            setLightStatusBar(getWindow().getDecorView(),this);
        }


        initViews();
        setupFabBehavior();

    }

    private void initViews() {
        extFab = findViewById(R.id.extFab100);
        iconDL = findViewById(R.id.menu_icon);
        mailRecyclerView = findViewById(R.id.recyle_view_mail);
        mailAdapter = new MailAdapter(new MailDiffUtilCallback());
        mailRecyclerView.setHasFixedSize(false);
        mailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mailRecyclerView.setAdapter(mailAdapter);
        mailAdapter.submitList(FakeDataSource.getListMail());
    }


    private void setupFabBehavior() {

        mailRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {

                if (dy > 0) {
                    // Scrolling up
                    extFab.shrink();

                } else {
                    // Scrolling down
                    extFab.extend();

                }
            }
        });
    }


    public static void setLightStatusBar(View view, Activity activity){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            activity.getWindow().setStatusBarColor(Color.WHITE);
        }

    }


}