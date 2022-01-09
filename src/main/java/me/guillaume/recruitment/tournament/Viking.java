package me.guillaume.recruitment.tournament;

import static me.guillaume.recruitment.tournament.Fighter.BUCKLER;

public class Viking {

  public static final int HIT_POINTS = 120;
  public static final int DMG = 6;

  private int leftPoints;
  private boolean hasBuckler = false;
  private boolean cancelDamage = false;
  private int bucklerDestroyedFromAxeCount = 3;
  private boolean hasAxe = true;

  public Viking() {
    this.leftPoints = HIT_POINTS;
  }

  public Viking(String tool) {
    this();
    if (tool.equals(BUCKLER)) {
      hasBuckler = true;
      cancelDamage = true;
    }
  }

  public void engage(Swordsman swordsman) {
    System.out.println("Viking " + leftPoints);
    if (leftPoints > 0) {
      swordsman.injured(DMG, hasAxe);
      swordsman.engage(this);
    }
  }

  public int hitPoints() {
    return this.leftPoints;
  }

  public Viking equip(String tool) {
    return new Viking(tool);
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
