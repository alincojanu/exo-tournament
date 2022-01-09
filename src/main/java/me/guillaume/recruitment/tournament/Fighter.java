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
  private int reducedReceivedDamage = 0;
  private int greatSwordAttackCount = 2;

  static Map<String, Integer> arms = new HashMap<>();

  static {
    arms.put(SWORD, 5);
    arms.put(AXE, 6);
    arms.put(GREAT_SWORD, 12);
  }

  private String weapon;
  private List<String> armors = new ArrayList<>();

  public Fighter() {

  }

  public Fighter(int hitPoints, String weapon) {
    this.hitPoints = hitPoints;
    this.weapon = weapon;
  }

  protected int hitPoints;

  public int hitPoints() {
    return this.hitPoints;
  }

  protected void engage(Fighter fighter) {
    System.out.println("--> " + this.hitPoints);
    if (hitPoints > 0 && fighter.hitPoints() > 0) {
      fighter.injured(weapon, armors);
      fighter.engage(this);
    }
  }

  protected void injured(String weapon, List<String> armors) {
    if (hasProtection()) {
      activateDamage();
      if (hasAxe(weapon)) {
        bucklerDestroyedFromAxeCount--;
        if (bucklerDestroyedFromAxeCount == 0) {
          this.armors.remove(BUCKLER);
        }
      }
    } else {
      if (!weapon.equals(GREAT_SWORD) || canGreatSwordAttack(weapon)) {
        takeHit(weapon, armors);
        cancelDamage();
      }
    }
  }

  private void takeHit(String weapon, List<String> armors) {
    int damage = arms.get(weapon);
    if (canGreatSwordAttack(weapon)) {
      if (this.hitPoints - damage < 0) {
        this.hitPoints = 0;
      } else {
        if (armors.contains(ARMOR)) {
          damage--;
        }
        this.hitPoints -= (damage - this.reducedReceivedDamage);
      }
    }
  }

  private boolean canGreatSwordAttack(String weapon) {
    if (weapon.equals(GREAT_SWORD)) {
      if (this.greatSwordAttackCount % 3 != 0) {
        this.greatSwordAttackCount--;
      } else {
        this.greatSwordAttackCount = 2;
        return false;
      }
    }
    return true;
  }

  private boolean hasProtection() {
    return hasBuckler() && cancelDamage && isBucklerDestroyed();
  }

  private boolean isBucklerDestroyed() {
    return this.bucklerDestroyedFromAxeCount != 0 || !this.armors.contains(BUCKLER);
  }

  protected boolean hasAxe(String weapon) {
    return AXE.equals(weapon);
  }

  private boolean hasBuckler() {
    return this.armors.contains(BUCKLER);
  }

  private void activateDamage() {
    this.cancelDamage = false;
  }

  protected void cancelDamage() {
    this.cancelDamage = true;
  }

  protected Fighter addArmor(String tool) {
    if (tool.equals(BUCKLER)) {
      armors.add(BUCKLER);
      cancelDamage();
    }
    if (tool.equals(ARMOR)) {
      armors.add(ARMOR);
      reduceReceivedDamage(3);
    }
    return this;
  }

  private void reduceReceivedDamage(int i) {
    this.reducedReceivedDamage = i;
  }

}
