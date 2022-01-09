package me.guillaume.recruitment.tournament;

public class Swordsman extends Fighter {

  public static final int HIT_POINTS = 100;

  public Swordsman() {
     super(HIT_POINTS, SWORD);
  }

  public Swordsman(String vicious) {
    super();
  }

  public Swordsman equip(String armor) {
    return (Swordsman) addArmor(armor);
  }


}
