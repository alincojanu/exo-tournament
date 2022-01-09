package me.guillaume.recruitment.tournament;

public class Swordsman extends Fighter {

  public static final int HIT_POINTS = 100;

  public Swordsman() {
     super(HIT_POINTS, SWORD);
  }

  public Swordsman(String armor) {
    this();
    addArmor(armor);
  }

  public Swordsman equip(String armor) {
    return new Swordsman(armor);
  }



}
