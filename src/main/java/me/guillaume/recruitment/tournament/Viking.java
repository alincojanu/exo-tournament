package me.guillaume.recruitment.tournament;

public class Viking extends Fighter {

  public static final int HIT_POINTS = 120;

  public Viking() {
    super(HIT_POINTS, AXE);
  }

  public Viking(String tool) {
    this();
    if (tool.equals(BUCKLER)) {
      activateBuckler();
      cancelDamage();
    }
  }

  public Viking equip(String tool) {
    return new Viking(tool);
  }


}
