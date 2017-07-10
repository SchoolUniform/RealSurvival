package com.outlook.z815007320.api;

import org.bukkit.entity.Player;

import com.outlook.z815007320.data.PluginRS;

public interface RealSurvivalAPI {
	/**
	 * �ı�һ����ҵ�����ֵ
	 * ������4��,�ֱ���: 
	 * 	sleep | thiPluginRS.rst | temperature | physical_strength
	 * @param p ���
	 * @param type �ı����ݵ�����
	 * @param number Ҫ ����(+)/����(-) ����ֵ
	 * @return �޸ĳɹ����� true,ʧ�ܷ���false
	 */
	public default boolean changeData(Player p,String type,double number){
		if(p==null)return false;
		//sleep | thiPluginRS.rst | temperature | weight | physical_strength
		switch(type){
		case "sleep":
			PluginRS.rs.getPlayerData(p).changeSleep(number);
			break;
		case "temperature":
			PluginRS.rs.getPlayerData(p).changeTemperature(number);
			break;
		case "thiPluginRS.rst":
			PluginRS.rs.getPlayerData(p).changeThirst(number);
			break;
		case "physical_strength":
			PluginRS.rs.getPlayerData(p).changePS(number);
			break;
		default:
			return false;
		}
		return true;
	}
	/**
	 * ������4��,�ֱ���: 
	 * 	sleep | thiPluginRS.rst | temperature | physical_strength
	 * @param p ���
	 * @param type �鿴���ݵ�����
	 * @return  �ɹ��򷵻����Ӧ������, ʧ���򷵻�-1
	 */
	public default double getData(Player p,String type){
		switch(type){
		case "sleep":
			return PluginRS.rs.getPlayerData(p).getSleep();
		case "temperature":
			return PluginRS.rs.getPlayerData(p).getTemperature();
		case "thiPluginRS.rst":
			return PluginRS.rs.getPlayerData(p).getThirst();
		case "physical_strength":
			return PluginRS.rs.getPlayerData(p).getPhysical_strength();
		default:
			return -1;
		}
	}
	/**
	 * ����Ƿ���˯��
	 * @param p ���
	 * @return ˯��Ϊtrue,����Ϊfalse
	 */
	public default boolean isSleep(Player p){
		return PluginRS.rs.getPlayerData(p).isSleep();
	}
	/**
	 * ����Ƿ�������
	 * @param p ���
	 * @return ����Ϊtrue,����Ϊfalse
	 */
	public default boolean isSick(Player p){
		return PluginRS.rs.getPlayerData(p).isSick();
	}
	/**
	 * ��ȡ��ҵò��б�
	 * @param p ���
	 * @return ��ȡ��������б�,ʧ�ܷ���null
	 */
	public default String[] getSickList(Player p){
		if(!PluginRS.rs.getPlayerData(p).isSick())return null;
		return PluginRS.rs.getPlayerData(p).getSickKind();
	}
	/**
	 * ��ȡ������õ�ĳ�ֲ�����ϸ��Ϣ
	 * @param p ���
	 * @param sickType ��������
	 * @return ����һ��������Ϣ����Ϊ4��Object����,ǰ����Ϊdouble��,��һ��Ϊboolean
	 * ��һ��Ϊ�ò��������̶�,�ڶ���Ϊ�ò���ҩ�����ʱ��,
	 * ������Ϊÿ��ָ��ٷ�֮����,���ĸ�Ϊ�Ƿ����ҩ,����ȡʧ���򷵻�null
	 */
	public default Object[] getSickData(Player p,String sickType){
		if(!PluginRS.rs.getPlayerData(p).isSick())return null;
		return PluginRS.rs.getPlayerData(p).getSickKindMap().get(sickType);
	}
	
	/**
	 * ���������һ�ֲ�
	 * @param p ���
	 * @param sickType ����
	 * @return ���ӳɹ�����true,����ʧ�ܷ���false
	 */
	public default boolean addSick(Player p,String sickType){
		if(!PluginRS.rs.getPlayerData(p).isSick())PluginRS.rs.getPlayerData(p).setSick(true);
		if(PluginRS.rs.getPlayerData(p).getSickKindList().contains(sickType))return false;
		PluginRS.rs.getPlayerData(p).addSickKind(sickType);
		return true;
	}
	/**
	 * ���������һ�ֲ�������
	 * @param p ���
	 * @param sickType ����
	 * @param recovery �������̶�
	 * @param time ҩ�����ʱ��
	 * @param effect ҩ������Ч��
	 * @param isAteMedication �Ƿ����ҩ
	 * @return �ɹ�true,ʧ��false
	 */
	public default boolean setSickKind(Player p,String sickType,double recovery,double time,double effect,boolean isAteMedication) {
		if(!PluginRS.rs.getPlayerData(p).isSick())return false;
		if(!PluginRS.rs.getPlayerData(p).getSickKindList().contains(sickType))return false;
		PluginRS.rs.getPlayerData(p).setDuration(time, sickType);
		PluginRS.rs.getPlayerData(p).settEffect(effect, sickType);
		PluginRS.rs.getPlayerData(p).setMedication(isAteMedication, sickType);
		PluginRS.rs.getPlayerData(p).setRecovery(recovery, sickType);
		return true;
	}
}
