package me.guillaume.recruitment.tournament;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fighter {

  public static final String BUCKLER = "buckler";
  public static final String ARMOR = "armor";
  public static final String SWORD = "sword";
  public static final String AXE = "axe";
  public static final String GREAT_SWORD = "great_sword";

  private boolean cancelDamage = false;
  private int bucklerDestroyedFromAxeCount = 3;

  static Map<String, Integer> arms = new HashMap<>();

  static {
    arms.put(SWORD, 5);
    arms.put(AXE, 6);
    arms.put(GREAT_SWORD, 12);
  }

  public String weapon;
  public List<String> armors = new ArrayList<>();

  public Fighter(int hitPoints, String weapon) {
    this.hitPoints = hitPoints;
    this.weapon = weapon;
  }

  protected void engage(Fighter fighter) {
    System.out.println("--> " + fighter.hitPoints);
    if (this.hitPoints > 0 && fighter.hitPoints() > 0) {
      fighter.injured(arms.get(weapon), hasAxe(weapon));
      fighter.engage(this);
    }
  }

  protected int hitPoints;

  public int hitPoints() {
    return this.hitPoints;
  }

  protected void injured(int dmg, boolean hasAxe) {
    if (hasProtection()) {
      System.out.println("blocked");
      activateDamage();
      if (hasAxe) {
        bucklerDestroyedFromAxeCount--;
      }
    } else {
      hit(dmg);
      cancelDamage();
    }
  }

  private boolean hasProtection() {
    return hasBucker() && cancelDamage && bucklerDestroyedFromAxeCount != 0;
  }

  private void hit(int damage) {
    if (this.hitPoints - damage < 0) {
      this.hitPoints = 0;
    } else {
      this.hitPoints -= damage;
    }
  }

  protected boolean hasAxe(String weapon) {
    return AXE.equals(weapon);
  }

  private boolean hasBucker() {
    return this.armors.contains(BUCKLER);
  }


  private void activateDamage() {
    this.cancelDamage = false;
  }

  protected void cancelDamage() {
    this.cancelDamage = true;
  }

  protected void addArmor(String tool) {
    if (tool.equals(BUCKLER)) {
      cancelDamage();
      armors.add(BUCKLER);
    }
  }
}
