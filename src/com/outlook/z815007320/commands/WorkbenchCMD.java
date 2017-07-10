package com.outlook.z815007320.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import com.outlook.z815007320.RealSurvival;
import com.outlook.z815007320.data.Items;
import com.outlook.z815007320.data.PluginRS;
import com.outlook.z815007320.gui.CraftItemGUI;
import com.outlook.z815007320.gui.FireCraftTableGUI;

public class WorkbenchCMD extends PluginRS{
/**
 * ��һ�����Թ���̨
 * @param p ���
 * @param ID ����̨ID
 */
	public static void openTestWorkbench(Player p,String ID){
		if(rs.getWorkbench().containsKey(ID))
			p.openInventory(CraftItemGUI.openWorkbenchGUI(Items.createItemKey(Material.STAINED_GLASS_PANE, (short)15,ID)));
		else
			p.openInventory(CraftItemGUI.createWorkbenchGUI(Items.createItemKey(Material.STAINED_GLASS_PANE, (short)15,ID)));
		return;
	}
	/**
	 * ��һ���䷽�б�
	 * @param p ���
	 */
	public static void openSFList(Player p){
		p.openInventory(new CraftItemGUI().sFList(0,p));
	}
	/**
	 * ����һ���䷽
	 * @param player ���
	 * @param sfName �䷽��
	 * @param time ʱ��
	 * @return �Ƿ�ɹ�
	 */
	public static boolean createSF(Player player,String sfName,String time){
		
		if(new File(rs.getDataFolder()+File.separator+"SyntheticFormula"+File.separator+sfName+".yml").exists()){
			 player.sendMessage("��9[RealSurvival] ��b�ϳɹ�ʽ������...");
			 return false;
		 }
		 long l=-1;
		 try{ l=Long.parseLong(time);}catch(Exception e){}
		 if(l<0){
			 player.sendMessage("��9[RealSurvival] ��b����ʱ�����!...");
			 return false;
		 }
		player.openInventory(CraftItemGUI.createWorkbenchRecipeGUI(Items.createItemKey(Material.STAINED_GLASS_PANE, (short)15,sfName+":"+time)));
		return true;
	}
	/**
	 * ����һ���䷽
	 * @param player ���
	 * @param sfName �䷽��
	 * @param time ʱ��
	 * @return �Ƿ�ɹ�
	 */
	public static boolean createFCTR(Player player,String name,String time,String maxTime,String tem){
		if(new File(rs.getDataFolder()+File.separator+"SyntheticFormula"+File.separator+"FireCraftTable"+File.separator+name+".yml").exists()){
			 player.sendMessage("��9[RealSurvival] ��b�ϳɹ�ʽ������...");
			 return false;
		 }
		 try{
			 Integer.parseInt(time);
			 Integer.parseInt(maxTime);
			 Double.parseDouble(tem);
		 }catch(Exception e){
			 player.sendMessage("��9[RealSurvival] ��b ����ʱ�� | ����ʱ�� | �¶�  ��ĳ�������!...");
			 return false;
		 }
		player.openInventory(FireCraftTableGUI.createFCTPGUI(Items.createItemKey(Material.STAINED_GLASS_PANE, (short)15,name+":"+time+":"+maxTime+":"+tem)));
		return true;
	}
	/**
	 * ���趨һ���䷽
	 * @param player ���
	 * @param sfName �䷽��
	 * @param time ʱ��
	 * @return �Ƿ�ɹ�
	 */
	public static boolean resetSF(Player player,String sfName,String time){
		 if(!new File(rs.getDataFolder()+File.separator+"SyntheticFormula"+sfName+".yml").exists()){
			 player.sendMessage("��9[RealSurvival] ��bû�ҵ�ָ���ĺϳɹ�ʽ...");
			 return false;
		 }
		 long l=-1;
		 try{ l=Long.parseLong(time);}catch(Exception e){}
		 if(l<0){
			 player.sendMessage("��9[RealSurvival] ��b����ʱ�����!...");
			 return false;
		 }
		player.openInventory(CraftItemGUI.resetSF(Items.createItemKey(Material.STAINED_GLASS_PANE, (short)15,sfName+":"+time)));
		return true;
	}
	/**
	 * �趨����̨�����
	 * @param face ����̨���� һ��Ϊ main,up,down,left,right,behind,front
	 * @param blockName ���������
	 * @return ����ɹ�����true,ʧ�ܷ���false
	 */
	public static boolean setWorkbench(String face,String blockName){
		if(!(face.equals("Main")||face.equals("UP")||face.equals("Left")||
				face.equals("Right")||face.equals("Behind")||face.equals("Front")))
			return false;
		
		rs.getConfig().set("workbench."+face, blockName);
		try {
			rs.getConfig().save(rs.getDataFolder()+File.separator+"config.yml");
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	/**
	 * �趨���,
	 * ��Ҫ�������
	 * @param rs ���
	 */
	public static void setrsin(RealSurvival rs){
		WorkbenchCMD.rs=rs;
	}
}
