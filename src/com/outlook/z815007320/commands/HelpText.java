package com.outlook.z815007320.commands;

public class HelpText {
	private static final String helpHead="��9===================��bRealSurvival��9===================\n%text%"
			+ "��9=================================================";
	public static String getMainHelpText(){
		return helpHead.replaceAll("%text%",
				 "��b����: ��3��lSchool_Uniform\n"
				 + "\n"
				+ "��b/rs state - �鿴����״̬\n"
				+ "��b/rs reload - ���ز������\n"
				+ "��b/rs item help - �鿴����Ʒ�йص���ָ��\n"
				+ "��b/rs wb help - �鿴�빤��̨��ص���ָ��\n"
				+ "��b/rs state help - �鿴��״̬��ص���ָ��\n"
				+ "��b/rs setSwitch help - �鿴����������ص���ָ��\n"
				+ "��b/rs test help - �鿴����ָ�����\n");
	}
	
	public static String getWorkbenchHelp(){
		return helpHead.replaceAll("%text%",
				   "��b/rs wb csf <�䷽��> <����ʱ��> - ����һ��ָ������������ʱ����䷽\n"
				+ "��b/rs wb csff <�䷽��> <����ʱ��> <����ʱ��> <�¶�> - ����һ��ָ������������ʱ����ն������䷽\n"
				+ "��b/rs wb resetsf <�䷽��> <����ʱ��> - ��дָ���䷽������ʱ��\n"
				+ "��b/rs wb openwb <ID> - ��һ��ָ��ID�Ĺ���̨\n"
				+ "��b/rs wb openSFList - �������䷽���б�\n"
				+ "��b/rs wb setBlock <��λ> <������> - �趨�������̨���跽���\n"
				+ "��3��: ��λΪ: Main, Right, UP, Down, Front, Behind\n"
				+ "��3    ��������Ҫȫ����д ��Ҫע����Ƿ�λ�Ĵ�Сд\n"
				+ "��c��lע��setBlock�޸������Ҫ���ز������ЧŶ!\n"
				+ "��c��lcsff��,����ʱ��Ҫ��������ʱ��,����...����,�¶ȿ���Ϊһ��ʵ��\n");
	}
	/**
	 * ��ȡSetSwitchָ��İ����ı�
	 * @return SetSwitchָ��İ����ı�
	 */
	public static String getSetSwitchHelp(){
		return helpHead.replaceAll("%text%", 
				"��b/rs setSwitch Sleep <true/false> - ����/�ر�˯������\n"
			+ "��b/rs setSwitch Thirst <true/false> - ����/�رտڿʹ���\n"
			+ "��b/rs setSwitch PhysicalStrength <true/false> - ����/�ر���������\n"
			+ "��b/rs setSwitch Temperature <true/false> - ����/�ر����¹���\n"
			+ "��b/rs setSwitch Weight <true/false> - ����/�رո��ع���\n"
			+ "��b/rs setSwitch Sick <true/false> - ����/�ر���������\n"
			+ "��3 ע���Сд!"
			+ "��c��lע���޸������Ҫ���ز������ЧŶ!\n");
	}
	/**
	 * ��ȡ stateָ��İ����ı�
	 * @return
	 */
	public static String getStateHelp(){
		return helpHead.replaceAll("%text%", 
				"��b/rs state add <����> <�����> <��ֵ> - ����ĳһ���ݢٵ���ֵ\n"
			+ "��b/rs state set <����> <�����> <��ֵ> - �趨ĳһ���ݢٵ���ֵ\n"
			+ "��b/rs state set sick <�����> <true/false> <����> - �趨ĳ��ҵ��������\n"
			+ "��3��: ����Ϊ: sleep, thirst, tem, ps, recovery\n"
			+ "��3   �ֱ���� ˯��, �ڿ�, ����, ����, ����ָ�����\n"
			+ "��3 ��ֵΪ����,����ֻ�ܸ���������޸���ֵ\n");
	}
	
	public static String getItemHelp(){
		return helpHead.replaceAll("%text%", 
			   "��b/rs item lore <����> -  �����ϵ���Ʒ����һ�� <����>\n"
			+ "��b/rs item setlore <����> <����> -  ������ָ���е������޸�Ϊ��<����>\n"
			+ "��b/rs item removelore <����> - �Ƴ�������Ʒָ���е�lore\n"
			+ "��b/rs item setname <name> -  �����ϵ���Ʒ�������޸�Ϊָ��������\n"
			+ "��b/rs item get <��Ʒ��> [����] - ��ȡ�����˵���Ʒ��������Ʒ��  [����] ��ѡ�� \n"
			+ "��b/rs item give  <�����> <��Ʒ��> [����]  -  ��ָ����ұ����˵���Ʒ��������Ʒ ��  [����]��ѡ��\n"
			+ "��b/rs item save <��Ʒ��>  -  �����ϵ���Ʒ����Ϊһ��ָ�����Ƶı����ļ�\n"
			+ "��b/rs item list - �г����е�������Ʒ\n");
	}
	
	public static String getTestHelp(){
		return helpHead.replaceAll("%text%", 
			   "��b/rs test open -  ��������ģʽ\n"
			+ "��b/rs test close -  �رղ���ģʽ\n"
			+ "��b/rs test on - ��������ֵ��ʼ����\n"
			+ "��b/rs test off - ��������ֵֹͣ\n"
			+ "��3��lTips: ��ʹ�� ��copen/on ��3��lָ��ʱ, Ч��һֱ���浽ʹ�� ��cclose/off ��3��l��ֹͣ\n");
	}
}
