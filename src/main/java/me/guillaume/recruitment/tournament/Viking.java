package me.guillaume.recruitment.tournament;

public class Viking extends Fighter {

  public static final int HIT_POINTS = 120;

  public Viking() {
    super(HIT_POINTS, AXE);
  }

  public Viking(String armor) {
    this();
    addArmor(armor);
  }

  public Viking equip(String armor) {
    return new Viking(armor);
  }


}
