package miskyle.realsurvival.data.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;
import miskyle.realsurvival.data.effect.EffectData;
import miskyle.realsurvival.util.RsEntry;

public class DrugData {
  private HashMap<String, Double> getDisease;
  private HashMap<String, RsEntry<Double, Double>> drug;
  private HashMap<String, RsEntry<Integer, Integer>> duration;
  private List<String> wrongDisease;
  private ArrayList<EffectData> eatWrongDrug;
  private ArrayList<EffectData> noNeedDrug;

  public DrugData() {
  }

  /**
   * 获取药物数据.

   * @param config 包含药物数据的文件.
   * @return
   */
  public static DrugData getDrugData(YamlConfiguration config) {
    DrugData drug = new DrugData();
    if (config.contains("disease")) {
      HashMap<String, Double> getDisease = new HashMap<String, Double>();
      config.getStringList("disease").forEach(line -> {
        String[] temp = line.split(":");
        getDisease.put(temp[0], Double.parseDouble(temp[1]));
      });
      drug.setGetDisease(getDisease);
    }
    if (config.contains("enable-disease")) {
      HashMap<String, RsEntry<Double, Double>> drugd = new HashMap<>();
      HashMap<String, RsEntry<Integer, Integer>> duration = new HashMap<>();
      List<String> wrongDisease = null;
      ArrayList<EffectData> eatWrongDrug = new ArrayList<EffectData>();
      ArrayList<EffectData> noNeedDrug = new ArrayList<EffectData>();
      config.getStringList("enable-disease").forEach(line -> {
        String[] temp = line.split(",");
        drugd.put(temp[0], getRsEntryDouble(temp[1]));
        duration.put(temp[0], getRsEntryInt(temp[2]));
      });
      if (drugd.isEmpty()) {
        return drug;
      }
      if (config.contains("eat-wrong-drug") && config.contains("wrong-disease")) {
        wrongDisease = config.getStringList("wrong-disease");
        config.getStringList("eat-wrong-drug").forEach(line -> {
          eatWrongDrug.add(EffectData.loadFromString(line));
        });
      }
      if (config.contains("no-need-drug")) {
        config.getStringList("no-need-drug").forEach(line -> {
          noNeedDrug.add(EffectData.loadFromString(line));
        });
      }
      drug.setDrug(drugd);
      drug.setDuration(duration);
      drug.setWrongDisease(wrongDisease);
      drug.setEatWrongDrug(eatWrongDrug);
      drug.setNoNeedDrug(noNeedDrug);
    }
    return drug;
  }

  public HashMap<String, Double> getGetDisease() {
    return getDisease;
  }

  public void setGetDisease(HashMap<String, Double> getDisease) {
    this.getDisease = getDisease;
  }

  public HashMap<String, RsEntry<Double, Double>> getDrug() {
    return drug;
  }

  public void setDrug(HashMap<String, RsEntry<Double, Double>> drug) {
    this.drug = drug;
  }

  public HashMap<String, RsEntry<Integer, Integer>> getDuration() {
    return duration;
  }

  public void setDuration(HashMap<String, RsEntry<Integer, Integer>> duration) {
    this.duration = duration;
  }

  /**
   * 获取药.

   * @param disease 病.
   * @return
   */
  public RsEntry<Double, Integer> getMedicien(String disease) {
    if (isValidAtDisease(disease)) {
      return new RsEntry<Double, Integer>(
          randomDouble(drug.get(disease)), randomInt(duration.get(disease)));
    } else {
      return new RsEntry<Double, Integer>(0D, 0);
    }
  }

  /**
   * 是否对指定病有效.

   * @param disease 病.
   * @return
   */
  public boolean isValidAtDisease(String disease) {
    if (drug == null || duration == null) {
      return false;
    } else if (drug.containsKey(disease) && duration.containsKey(disease)) {
      return true;
    } else {
      return false;
    }
  }

  public List<String> getWrongDisease() {
    return wrongDisease;
  }

  /**
   * 获取吃错药后的效果.

   * @param disease 病.
   * @return
   */
  public ArrayList<EffectData> getWrongDiseaseEffect(String disease) {
    if (wrongDisease != null && wrongDisease.contains(disease)) {
      return eatWrongDrug;
    } else {
      return new ArrayList<>();
    }
  }

  public void setWrongDisease(List<String> wrongDisease) {
    this.wrongDisease = wrongDisease;
  }

  public ArrayList<EffectData> getEatWrongDrug() {
    return eatWrongDrug;
  }

  public void setEatWrongDrug(ArrayList<EffectData> eatWrongDrug) {
    this.eatWrongDrug = eatWrongDrug;
  }

  public ArrayList<EffectData> getNoNeedDrug() {
    return noNeedDrug;
  }

  public void setNoNeedDrug(ArrayList<EffectData> noNeedDrug) {
    this.noNeedDrug = noNeedDrug;
  }

  /**
   * 是否致病.

   * @return 致病返回true
   */
  public boolean isMakeDisease() {
    return getDisease != null && !getDisease.isEmpty();
  }

  /**
   * 是否能治病.

   * @return 治病返回true
   */
  public boolean isValidDrug() {
    return drug != null && !drug.isEmpty() && duration != null && !duration.isEmpty();
  }

  /**
   * 使用此药时对其他病是否有影响.

   * @return 有影响返回true
   */
  public boolean hasProblemWithOtherDisease() {
    return wrongDisease != null 
        && !wrongDisease.isEmpty() 
        && eatWrongDrug != null 
        && !eatWrongDrug.isEmpty();
  }

  /**
   * 当没病吃药时是否有影响.

   * @return 有影响返回true
   */
  public boolean hasProbleWhenFine() {
    return noNeedDrug != null && !noNeedDrug.isEmpty();
  }

  private static RsEntry<Double, Double> getRsEntryDouble(String str) {
    String[] temp = str.split("/");
    return new RsEntry<Double, Double>(Double.parseDouble(temp[0]), Double.parseDouble(temp[1]));
  }

  private static RsEntry<Integer, Integer> getRsEntryInt(String str) {
    String[] temp = str.split("/");
    return new RsEntry<Integer, Integer>(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
  }

  private double randomDouble(RsEntry<Double, Double> entry) {
    return Math.random() * Math.abs(entry.getLeft() 
        - entry.getRight()) + Math.min(entry.getLeft(), entry.getRight());
  }

  private int randomInt(RsEntry<Integer, Integer> entry) {
    return (int) (Math.random() * Math.abs(entry.getLeft() - entry.getRight())
        + Math.min(entry.getLeft(), entry.getRight()));
  }

}
