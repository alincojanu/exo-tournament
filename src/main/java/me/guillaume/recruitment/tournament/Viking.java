package me.guillaume.recruitment.tournament;

public class Viking {

  public static final int HIT_POINTS = 120;

  private int leftPoints;

  public Viking() {
    this.leftPoints = 135;
  }

  public int hitPoints() {
    return this.leftPoints;
  }

  public Viking equip(String buckler) {
    return null;
  }

  public void engage(Swordsman swordsman) {
    swordsman.injured(HIT_POINTS);
  }

  public void injured(int hitPoints) {
    this.leftPoints -= hitPoints;
  }
}
