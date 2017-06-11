package com.lonely.solotalk;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;


import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import static com.lonely.solotalk.R.id.toolbar;


public abstract class DrawerActivityCustom extends AppCompatActivity {
    private Drawer drawer = null;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_custom);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);

//creating the header
        AccountHeader headerResult;
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.color.primaryColor)
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
        //Create the drawer
        drawer = new DrawerBuilder(this)
                //this layout have to contain child layouts
                .withRootView(R.id.drawer_container)
                .withToolbar(toolbar)
                .withDisplayBelowStatusBar(false)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(headerResult)
                .withSliderBackgroundColorRes(R.color.primaryColor)
                .addDrawerItems(
                        new PrimaryDrawerItem().withTextColorRes(R.color.teitaryColor).withName(R.string.menu_listen).withIcon(R.mipmap.listen_icon),
                        new PrimaryDrawerItem().withTextColorRes(R.color.teitaryColor).withName(R.string.menu_record).withIcon(R.mipmap.record_icon),
                        new SectionDrawerItem().withTextColorRes(R.color.teitaryColor).withName(R.string.menu_subtitle),
                        new PrimaryDrawerItem().withTextColorRes(R.color.teitaryColor).withName(R.string.menu_schedule).withIcon(R.mipmap.schedule_icon),
                        new PrimaryDrawerItem().withTextColorRes(R.color.teitaryColor).withName(R.string.menu_history).withIcon(R.mipmap.history_icon),
                        new PrimaryDrawerItem().withTextColorRes(R.color.teitaryColor).withName(R.string.menu_setting).withIcon(R.mipmap.settings_icon)

                )
                .withSavedInstance(savedInstanceState)
                .build();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = drawer.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

}

