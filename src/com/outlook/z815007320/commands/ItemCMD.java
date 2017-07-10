package com.outlook.z815007320.commands;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.outlook.z815007320.data.PluginRS;
import com.outlook.z815007320.utils.Util_Colours;
import com.outlook.z815007320.utils.Utils;

public class ItemCMD extends PluginRS{
	private static String getLore(String[] args,int start){
		String lore="";
		for(int i=start;i<args.length;i++) lore+=args[i]+" ";
		lore.substring(0, lore.length()-2);
		return Util_Colours.replaceTooltipColour(lore);
	}
	
	//rs item lore xxx xxx
	public static void addLore(Player p,String[] args){
		if(args.length<3){
			p.sendMessage("��9[RealSurvival] ��4ָ���ʽ����Ŷ,��ȷ��ʽ�ǡ�b��l/rs item lore [lore]");
			return;
		}
		ItemStack item=p.getInventory().getItemInMainHand();
		if(item.getType()==Material.AIR){//����ǿ����򷵻�
			p.sendMessage("��9[RealSurvival] ��4ò��������ʲô��û����.");
			return;
		}
		ItemMeta itemLore=item.getItemMeta();
		List<String> lore=itemLore.getLore();
		if(lore==null)
			lore=new LinkedList<String>();
		lore.add(getLore(args,2));
		itemLore.setLore(lore);
		item.setItemMeta(itemLore);
		p.getInventory().setItemInMainHand(item);
	}
	
	//rs item setlore int xxx xxx
		public static void setLore(Player p,String[] args){
			if(args.length<4){
				p.sendMessage("��9[RealSurvival] ��4ָ���ʽ����Ŷ,��ȷ��ʽ�ǡ�b��l/rs item setlore [line] [lore]");
				return;
			}
			
			ItemStack item=p.getInventory().getItemInMainHand();
			if(item.getType()==Material.AIR){//����ǿ����򷵻�
				p.sendMessage("��9[RealSurvival] ��4ò��������ʲô��û����.");
				return;
			}
			
			int line=-1;
			try{
				 line=Integer.parseInt(args[2]);
			}catch(Exception e){
				
			}
			if(line==-1){
				p.sendMessage("��9[RealSurvival] ��4����Ҫ������Ŷ.��ȷ��ʽ�ǡ�b��l/rs item setlore [line] [lore]");
				return;
			}
			ItemMeta itemLore=item.getItemMeta();
			List<String> lore=itemLore.getLore();
			if(lore==null)
				lore=new LinkedList<String>();
			lore.set(line-1,getLore(args,3) );
			itemLore.setLore(lore);
			item.setItemMeta(itemLore);
			p.getInventory().setItemInMainHand(item);
		}
		
		//rs item setname xxx xxx
		public static void setName(Player p,String[] args){
			if(args.length<3){
				p.sendMessage("��9[RealSurvival] ��4ָ���ʽ����Ŷ,��ȷ��ʽ�ǡ�b��l/rs item setName [name]");
				return;
			}
			ItemStack item=p.getInventory().getItemInMainHand();
			if(item.getType()==Material.AIR){//����ǿ����򷵻�
				p.sendMessage("��9[RealSurvival] ��4ò��������ʲô��û����.");
				return;
			}
			ItemMeta itemLore=item.getItemMeta();
			itemLore.setDisplayName(getLore(args,2));
			item.setItemMeta(itemLore);
			p.getInventory().setItemInMainHand(item);
		}
		
		//rs item removelore line
		public static void removeLore(Player p,String[] args){
			if(args.length!=3){
				p.sendMessage("��9[RealSurvival] ��4ָ���ʽ����Ŷ,��ȷ��ʽ�ǡ�b��l/rs item removelore [line]");
				return;
			}
			
			ItemStack item=p.getInventory().getItemInMainHand();
			if(item.getType()==Material.AIR){//����ǿ����򷵻�
				p.sendMessage("��9[RealSurvival] ��4ò��������ʲô��û����.");
				return;
			}
			
			if(item.getItemMeta()==null||item.getItemMeta().getLore()==null){
				p.sendMessage("��9[RealSurvival] ��4�������õĶ�����Ч.");
				return;
			}
			
			int line=-1;
			try{
				 line=Integer.parseInt(args[2]);
			}catch(Exception e){
				
			}
			if(line==-1){
				p.sendMessage("��9[RealSurvival] ��4����Ҫ������Ŷ.��ȷ��ʽ�ǡ�b��l/rs item removelore [line]");
				return;
			}
			
			ItemMeta itemLore=item.getItemMeta();
			List<String> lore=itemLore.getLore();
			lore.remove(line-1);
			itemLore.setLore(lore);
			item.setItemMeta(itemLore);
			p.getInventory().setItemInMainHand(item);
		}
		
		//rs item save xxx
		public static void saveItem(Player p,String args){
			ItemStack item=p.getInventory().getItemInMainHand();
			if(item.getType()==Material.AIR){//����ǿ����򷵻�
				p.sendMessage("��9[RealSurvival] ��4ò��������ʲô��û����.");
				return;
			}
			try {
				File save=new File(rs.getDataFolder()+File.separator+"Items"+File.separator+args+".yml");
				if(!save.exists())
					save.createNewFile();
				else{
					p.sendMessage("��9[RealSurvival] ��4������ļ�������!");
					return;
				}
				YamlConfiguration temp = YamlConfiguration.loadConfiguration(save);
				temp.set(args, item);//�����ļ�
				try {temp.save(save);} catch (IOException e) {}
			} catch (IOException e) {}
		}
		
		//rs item get xxx
		public static ItemStack getItem(Player p, String args){
			if(Utils.getItem(args)!=null)return Utils.getItem(args);
			File save=new File(rs.getDataFolder()+File.separator+"Items"+File.separator+args+".yml");
			if(!save.exists())
			{
				p.sendMessage("��9[RealSurvival] ��4û�ҵ���Ӧ��Ʒ���ļ�!");
				return null;
			}
			YamlConfiguration temp = YamlConfiguration.loadConfiguration(save);
			//p.getInventory().addItem(temp.getItemStack(args));
			return temp.getItemStack(args);
		}
		
		public static String getItemList(){
			String list="��9��l=====================RealSurvival Itemsl=====================\n";
			File path=new File(rs.getDataFolder()+File.separator+"Items");
			for(File i:path.listFiles()){
				if(!i.isFile())continue;
				String fileName=i.getName();
				if(!fileName.substring(fileName.lastIndexOf(".")).equalsIgnoreCase(".yml"))continue;
				list+="��b"+fileName.substring(0,fileName.lastIndexOf("."))+"��9��l | ";
			}
			list+="��b������9��l |��bҩ��9��l | ��b��ˮ��9��l | ��b��ˮ ��9��l| ��b����ˮ ��9��l| ��b��ˮ��9��l | ��b��ˮ��9��l | ��b��ˮ��9��l | ��b��ˮ\n"
					+ "��9��l=====================RealSurvival Itemsl=====================";
			return list;
		}
}
