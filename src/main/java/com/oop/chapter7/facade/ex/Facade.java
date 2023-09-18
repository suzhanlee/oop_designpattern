package com.oop.chapter7.facade.ex;

public class Facade {

    private String beverage_Name;
    private String Movie_Name;

    public Facade(String beverage, String Movie_Name) {
        this.beverage_Name = beverage_Name;
        this.Movie_Name = Movie_Name;
    }

    public void view_Movie() {
        Beverage beverage = new Beverage(beverage_Name);
        Remote_Control remote = new Remote_Control();
        Movie movie = new Movie(Movie_Name);

        beverage.Prepare();
        remote.Turn_On();
        movie.Search_Movie();
        movie.Charge_Movie();
        movie.play_Movie();
    }

    public void view() {
        Facade facade = new Facade("콜라", "어벤져스");
        facade.view_Movie();
    }
}
