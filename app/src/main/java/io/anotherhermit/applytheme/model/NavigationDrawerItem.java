package io.anotherhermit.applytheme.model;

import java.util.ArrayList;
import java.util.List;

import io.anotherhermit.applytheme.R;

public class NavigationDrawerItem {
    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> dataList = new ArrayList<>();

        int[] imageIds = getImages();
        String[] titles = getTitles();

        for (int i = 0; i < titles.length; i++) {
            NavigationDrawerItem navItem = new NavigationDrawerItem();
            navItem.setTitle(titles[i]);
            navItem.setImageId(imageIds[i]);
            dataList.add(navItem);
        }
        return dataList;
    }

    private static String[] getTitles() {
        return new String[] {
                "People",
                "Computer",
                "Flower",
                "Traffic",
                "Transport"
        };
    }

    private static int[] getImages() {
        return new int[] {
                R.drawable.ic_people,
                R.drawable.ic_computer,
                R.drawable.ic_flower,
                R.drawable.ic_traffic,
                R.drawable.ic_transport

        };
    }
}
