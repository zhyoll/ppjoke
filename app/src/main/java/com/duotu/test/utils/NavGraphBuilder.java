package com.duotu.test.utils;

import android.content.ComponentName;

import com.duotu.test.model.Destination;
import com.duotu.test.navigator.FixFragmentNavigator;

import java.util.HashMap;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavGraphNavigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.fragment.FragmentNavigator;

/**
 * author : zhy
 * date   : 2020/11/1 21:18
 * desc   :
 */
public class NavGraphBuilder {

    public static void build(NavController controller, FragmentActivity activity, int containerId) {
        NavigatorProvider provider = controller.getNavigatorProvider();

        ActivityNavigator activityNavigator = provider.getNavigator(ActivityNavigator.class);
//        FragmentNavigator fragmentNavigator = provider.getNavigator(FragmentNavigator.class);

        FixFragmentNavigator fixFragmentNavigator = new FixFragmentNavigator(activity, activity.getSupportFragmentManager(), containerId);
        provider.addNavigator(fixFragmentNavigator);

        NavGraph navGraph = new NavGraph(new NavGraphNavigator(provider));

        HashMap<String, Destination> destConfig = AppConfig.getDestConfig();
        for (Destination value : destConfig.values()) {
            if (value.isIsFragment()) {
                FragmentNavigator.Destination destination = fixFragmentNavigator.createDestination();
                destination.setClassName(value.getClzName());
                destination.setId(value.getId());
                destination.addDeepLink(value.getPageUrl());
                navGraph.addDestination(destination);
            } else {
                ActivityNavigator.Destination destination = activityNavigator.createDestination();
                destination.setId(value.getId());
                destination.addDeepLink(value.getPageUrl());
                destination.setComponentName(new ComponentName(AppGlobal.getApplication().getPackageName(), value.getClzName()));
                navGraph.addDestination(destination);
            }

            if (value.isAsStarter()){
                navGraph.setStartDestination(value.getId());
            }
        }

        controller.setGraph(navGraph);
    }
}
