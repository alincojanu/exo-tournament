package me.guillaume.recruitment.tournament;

public class Swordsman extends Fighter {

  public static final int HIT_POINTS = 100;

  public Swordsman() {
     super(HIT_POINTS, SWORD);
  }

  public Swordsman(String tool) {
    this();
    if (tool.equals(BUCKLER)) {
      activateBuckler();
      cancelDamage();
    }
  }

  public Swordsman equip(String tool) {
    return new Swordsman(tool);
  }



}
