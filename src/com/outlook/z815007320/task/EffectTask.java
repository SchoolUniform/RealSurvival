package com.outlook.z815007320.task;

import java.util.Set;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.outlook.z815007320.commands.TestCMD;
import com.outlook.z815007320.data.PlayerData;
import com.outlook.z815007320.data.PluginRS;
import com.outlook.z815007320.utils.Utils;
/*
 * #SPEED(�ٶ�����),SLOW(����),FAST_DIGGING�����ȣ�,SLOW_DIGGING(�ھ�ƣ��),INCREASE_DAMAGE(�˺�����)
# HEAL(˲������),HARM(˲���˺�),JUMP(��Ծ����),CONFUSION(��θ),REGENERATION�������ָ���
# DAMAGE_RESISTANCE�����ԣ�,FIRE_RESISTANCE(����),WATER_BREATHING��ˮ�º�����,INVISIBILITY������
# BLINDNESS(ʧ��)��NIGHT_VISION��ҹ�ӣ�,HUNGER����������WEAKNESS��������,POISON���ж���
# WITHER�����㣩,HEALTH_BOOST������������,ABSORPTION(�˺�����),SATURATION(����)
 */
public class EffectTask extends PluginRS implements Runnable{
	private double sleep;
	private double thirst;
	private double temperature;
	@Override
	public void run() {
		if(!rs.isOver())return;
		rs.setOver(false);
		Set<UUID> players=rs.getPlayerDatas().keySet();
		for(UUID ps:players){
			Player p = rs.getServer().getPlayer(ps);
			if(p.isDead())continue;
		      if ((p.hasPermission("RealSurvival.unlimited")||p.hasPermission("RealSurvival.Admin"))&&!TestCMD.contains(p)) 
		    	  continue;
		      PlayerData pd=rs.getPlayerData(p);
		      //Sleep
		      sleep=pd.getSleep();
		      if(sleep>=rs.getSleepMax()*0.8)
		    	  Utils.addPotionEffect(p, rs.getEffects("SleepMax"));
		      else if(sleep<=rs.getSleepMin())
		    	  Utils.addPotionEffect(p,rs.getEffects("SleepMin"));
		      
		      //Thirst
		      thirst=pd.getThirst();
		      if(thirst>=rs.getThirstMax()*0.8)
		    	  Utils.addPotionEffect(p, rs.getEffects("ThirstMax"));
		      else if(thirst<=rs.getThirstMin())
		    	  Utils.addPotionEffect(p, rs.getEffects("ThirstMin"));
		      
		      //Temperature
		      temperature=pd.getTemperature();
		      if(temperature>38)
		    	  Utils.addPotionEffect(p, rs.getEffects("Fever"));
		      else if(temperature<36)
		    	  Utils.addPotionEffect(p, rs.getEffects("Cold"));
		      
		      //PhysicalStrength
		      if(pd.getPhysical_strength()==0)
		    	  Utils.addPotionEffect(p, rs.getEffects("PhysicalStrengthMin"));
		      
		      //Sick
		      if(pd.isSick())
		    	  for(String sick:pd.getSickKindList())
		    		  Utils.addPotionEffect(p, rs.getEffects(sick));
		      
		      
		      //weight
		      if(pd.getWeight()>rs.getWeight()){
		    	  Utils.addPotionEffect(p, rs.getEffects("Weight"));
		    	  p.setSprinting(false);
		      }
		}
		rs.setOver(true);
	}
	
}
