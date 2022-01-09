package me.guillaume.recruitment.tournament;

import static me.guillaume.recruitment.tournament.Fighter.BUCKLER;

public class Swordsman {

  public static final int HIT_POINTS = 100;
  public static final int DMG = 5;

  private int leftPoints;
  private boolean hasBuckler = false;
  private boolean cancelDamage = false;
  private int bucklerDestroyedFromAxeCount = 3;
  private boolean hasSword = true;
  private boolean hasAxe = false;

  public Swordsman() {
    this.leftPoints = HIT_POINTS;
  }

  public Swordsman(String tool) {
    this();
    if (tool.equals(BUCKLER)) {
      hasBuckler = true;
      cancelDamage = true;
    }
  }

  public void engage(Viking viking) {
    System.out.println("Swordsman " + leftPoints);
    if (leftPoints > 0) {
      viking.injured(DMG, hasAxe);
      viking.engage(this);
    }
  }

  public void engage(Highlander highlander) {

  }

  public int hitPoints() {
    return this.leftPoints;
  }

  public Swordsman equip(String tool) {
    return new Swordsman(tool);
  }

  public void injured(int hitPoints, boolean hasAxe) {
    if (hasBuckler && cancelDamage && bucklerDestroyedFromAxeCount != 0) {
      System.out.println("blocked");
      cancelDamage = false;
      if (hasAxe) {
        bucklerDestroyedFromAxeCount--;
      }
    } else {
      hit(hitPoints);
      cancelDamage = true;
    }
  }

  private void hit(int hitPoints) {
    if (this.leftPoints - hitPoints < 0) {
      this.leftPoints = 0;
    } else {
      this.leftPoints -= hitPoints;
    }
  }

}
