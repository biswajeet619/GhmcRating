package com.ghmc.biswajeet.ghmcrating;

/**
 * Created by biswajeet on 9/2/17.
 */

public class AreaRatingItem {
    private String area;
    private Double total_rating;
    private Long rating_count;

    public String getArea() {
        return area;
    }

    public Double getTotal_rating() {
        return total_rating;
    }

    public Long getRating_count() {
        return rating_count;
    }

    public AreaRatingItem(String area, Double total_rating, Long rating_count) {
        this.area = area;
        this.total_rating = total_rating;
        this.rating_count = rating_count;
    }
    public void addrating(int r)
    {
           total_rating+=r;
        rating_count++;
    }
}
