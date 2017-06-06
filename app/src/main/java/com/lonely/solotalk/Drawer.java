package com.lonely.solotalk;

/**
 * Created by turtle on 6/5/2017.
 */
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.materialdrawer.*;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;

public class Drawer {
    public Drawer (AppCompatActivity activity, Toolbar toolbar){
        DrawerBuilder builder = new DrawerBuilder()
                .withActivity(activity)
                .withToolbar(toolbar)
                .addDrawerItems(
                        new SecondaryDrawerItem().withIcon(R.drawable.menu_icon1).withName(R.string.drawer_title1),
                        new SecondaryDrawerItem().withIcon(R.drawable.menu_icon2).withName(R.string.drawer_title2),
                        new SecondaryDrawerItem().withIcon(R.drawable.menu_icon3).withName(R.string.drawer_title3),
                        new SecondaryDrawerItem().withIcon(R.drawable.menu_icon4).withName(R.string.drawer_title4),
                        new SecondaryDrawerItem().withIcon(R.drawable.menu_icon5).withName(R.string.drawer_title5)
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

        Drawer drawer = builder.build();
    }
}
