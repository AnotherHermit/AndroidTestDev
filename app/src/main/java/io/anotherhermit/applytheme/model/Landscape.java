package io.anotherhermit.applytheme.model;

import java.util.ArrayList;

import io.anotherhermit.applytheme.R;

public class Landscape {
    private int imageID;
    private String title;
    private String description;
    private boolean prime;

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageID() {
        return imageID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setPrime(boolean prime) {
        this.prime = prime;
    }

    public boolean isPrime() {
        return prime;
    }

    public static ArrayList<Landscape> getData() {
        ArrayList<Landscape> dataList = new ArrayList<>();

        int[] images = getImages();

        for (int i = 0; i < images.length; i++) {
            Landscape landscape = new Landscape();
            landscape.setImageID(images[i]);
            landscape.setTitle("Landscape " + i);
            landscape.setDescription("It's a landscape, how nice!");
            landscape.setPrime(checkPrime(i));

            dataList.add(landscape);
        }

        return dataList;
    }

    private static boolean checkPrime(int position) {

        if (position == 0  || position == 1)
            return false;

        for (int i = 2; i <= position / 2; i++){
            if (position % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] getImages () {
        int[] images = {
                R.drawable.thumbs_1_0,
                R.drawable.thumbs_2_0,
                R.drawable.thumbs_3_0,
                R.drawable.thumbs_4_0,
                R.drawable.thumbs_5_0,
                R.drawable.thumbs_6_0,
                R.drawable.thumbs_7_0,
                R.drawable.thumbs_8_0,
                R.drawable.thumbs_1_0,
                R.drawable.thumbs_2_0,
                R.drawable.thumbs_3_0,
                R.drawable.thumbs_4_0,
                R.drawable.thumbs_5_0,
                R.drawable.thumbs_6_0,
                R.drawable.thumbs_7_0,
                R.drawable.thumbs_8_0,
                R.drawable.thumbs_1_0,
                R.drawable.thumbs_2_0,
                R.drawable.thumbs_3_0,
                R.drawable.thumbs_4_0,
                R.drawable.thumbs_5_0,
                R.drawable.thumbs_6_0,
                R.drawable.thumbs_7_0,
                R.drawable.thumbs_8_0
        };
        return images;
    }
}
