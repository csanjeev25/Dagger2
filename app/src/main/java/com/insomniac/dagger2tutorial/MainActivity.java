package com.insomniac.dagger2tutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject ObjectManager mObjectManager;
    @BindView(R.id.image) ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApp.getMyApp().getBasicComponent().inject(this);
        ButterKnife.bind(this);

        String link = mObjectManager.get("link",String.class);
        if(link == null){
            link = "https://img00.deviantart.net/cd33/i/2012/287/b/2/house_stark_by_aprilis420-d5hu0ko.jpg";
            mObjectManager.save("link", link);
        }

        Glide.with(this).load(link).into(mImageView);
    }
}
