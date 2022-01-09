package me.guillaume.recruitment.tournament;

public class Highlander extends Fighter {

  public static final int HIT_POINTS = 150;


  public Highlander() {
    super(HIT_POINTS, GREAT_SWORD);
  }

  public Highlander(String veteran) {
    this();
  }


}
