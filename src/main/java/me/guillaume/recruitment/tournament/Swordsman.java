package me.guillaume.recruitment.tournament;

public class Swordsman {

  public static final int HIT_POINTS = 100;

  private int leftPoints;

  public Swordsman() {
    this.leftPoints = 120;
  }

  public Swordsman(String vicious) {

  }

  public void engage(Viking viking) {
    viking.injured(HIT_POINTS);
    viking.engage(this);
  }

  public void engage(Highlander highlander) {

  }

  public int hitPoints() {
    return this.leftPoints;
  }

  public Swordsman equip(String buckler) {
    return null;
  }

  public void injured(int hitPoints) {
    this.leftPoints -= hitPoints;
  }

}
