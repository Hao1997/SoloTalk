package com.lonely.solotalk;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import static com.lonely.solotalk.R.id.toolbar;


public abstract class DrawerActivityCustom extends AppCompatActivity {

    @Override
   public void setContentView(View view) {
        super.setContentView(view);

    }

    @Override
    protected void onCreate(Bundle State){
        super.onCreate(State);
    }

    public void setUpNavigationBar(){
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withStatusBarColor(R.color.material_drawer_dark_background)
                .withSliderBackgroundColor(R.color.material_drawer_dark_background)
                .addDrawerItems(
                        new SecondaryDrawerItem().withIcon(R.mipmap.listen_icon).withName(R.string.menu_listen).withTextColor(R.color.md_white_1000),
                        new SecondaryDrawerItem().withIcon(R.mipmap.record_icon).withName(R.string.menu_record).withTextColor(R.color.md_white_1000),
                        new SecondaryDrawerItem().withIcon(R.mipmap.schedule_icon).withName(R.string.menu_schedule).withTextColor(R.color.md_white_1000),
                        new SecondaryDrawerItem().withIcon(R.mipmap.history_icon).withName(R.string.menu_history).withTextColor(R.color.md_white_1000),
                        new SecondaryDrawerItem().withIcon(R.mipmap.settings_icon).withName(R.string.menu_setting).withTextColor(R.color.md_white_1000)
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        if (drawerItem != null) {
                            if (drawerItem instanceof Nameable) {
                                toolbar.setTitle(((Nameable)
                                        drawerItem).getNameRes());
                            }
                        }

                        return false;

                    }
                });

        AccountHeader headerResult;
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.md_black_1000)
                .addProfiles(
                        new ProfileDrawerItem().withName("SoloTalk").withEmail("Solo@gmail.com").withIcon(getResources().getDrawable(R.mipmap.solo_logo))
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        Drawer drawer = builder
                .withAccountHeader(headerResult)
                .build();
    }



}

