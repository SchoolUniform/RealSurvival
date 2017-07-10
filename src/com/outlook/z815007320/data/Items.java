package com.outlook.z815007320.data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import com.outlook.z815007320.utils.Utils;

public class Items extends PluginRS{
	/**
	 * l.add("��2��ˮ,����...");
		l.add("��4�������ܽ��,��l���м�������!");
		l.add("��b��Ҫ�þ�ˮװ�����������������!");
	 * @return ��ˮ
	 */
	public static ItemStack getSeaWater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(15, 103, 219));
		im.setDisplayName("��1��l��ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��a��l"+rs.getLoreTabel("Thirst")+": ��b��l-"+Utils.random(2, 20)+"%");
		l.add("��2��l"+rs.getLoreTabel("SickKind")+": ��c��l"+rs.defSick.split(";")[(int)Utils.random(0, rs.defSick.split(";").length)]);
		l.add("��2��l"+rs.getLoreTabel("Sickness")+": ��c��l"+Utils.random(20, 30)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��2��ˮ,����...");
		l.add("��4�������ܽ��,��l���м�������!");
		l.add("��b��Ҫ�þ�ˮװ�����������������!");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	/**
	 * l.add("��2��ˮ,�����ճɿ�ˮ");
		l.add("��4��lֱ�Ӻ��м�������!");
		l.add("��b��Ҫ�á�e��l��ˮװ�á�b���������������!");
	 * @return��ˮ
	 */
	public static ItemStack getLakeWater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(36, 165, 229));
		im.setDisplayName("��2��l��ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��2��l"+rs.getLoreTabel("Thirst")+": ��b��l"+Utils.random(5, 20)+"%");
		l.add("��2��l"+rs.getLoreTabel("SickKind")+": ��c��l"+rs.defSick.split(";")[(int)Utils.random(0, rs.defSick.split(";").length)]);
		l.add("��2��l"+rs.getLoreTabel("Sickness")+": ��c��l"+Utils.random(5, 15)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��4��lֱ�Ӻ��м�������!");
		l.add("��b��Ҫ�á�e��l��ˮװ�á�b���������������!");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	/**
	 * l.add("��2����ֱ������");
		l.add("��a��l���Ի������Ƽ���!");
		l.add("��c������ů����!");
	 * @return ��ˮ
	 */
	public static ItemStack getHotWater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(36, 165, 229));
		im.setDisplayName("��d��l��ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��a��l"+rs.getLoreTabel("Thirst")+": ��b��l"+Utils.random(10, 25)+"%");
		l.add("��c��l"+rs.getLoreTabel("tem")+": ��b��l"+Utils.random(0.1, 1.5));
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��2����ֱ������");
		l.add("��a��l���Ի������Ƽ���!");
		l.add("��c������ů����!");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	/**
	 * l.add("��2����ֱ������");
		l.add("��b��l���Ը����彵��!");
	 * @return ��ˮ
	 */
	public static ItemStack getIceWater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(36, 165, 229));
		im.setDisplayName("��3��l��ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��a��l"+rs.getLoreTabel("Thirst")+": ��b��l"+Utils.random(10, 25)+"%");
		l.add("��3��l"+rs.getLoreTabel("tem")+": ��c��l-"+Utils.random(0.1, 1.5)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��2����ֱ������");
		l.add("��b��l���Ը����彵��!");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	/**
	 * l.add("��2����ֱ������");
	 * @return ��ˮ
	 */
	public static ItemStack getFreshWater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(36, 165, 229));
		im.setDisplayName("��3��l��ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��a��l"+rs.getLoreTabel("Thirst")+": ��b��l"+Utils.random(10, 25)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��2����ֱ������");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
	 *l.add("��2��Ȼ���Խ��,����...");
		l.add("��e�м���������....");
	 * @return ����ˮ
	 */
	public static ItemStack getSwamplandWater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(50, 69, 107));
		im.setDisplayName("��8��l����ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��a��l"+rs.getLoreTabel("Thirst")+": ��b��l"+Utils.random(2, 15)+"%");
		l.add("��2��l"+rs.getLoreTabel("SickKind")+": ��c��l"+rs.defSick.split(";")[(int)Utils.random(0, rs.defSick.split(";").length)]);
		l.add("��2��l"+rs.getLoreTabel("Sickness")+": ��c��l"+Utils.random(30, 50)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��2��Ȼ���Խ��,����...");
		l.add("��e�м���������....");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
		l.add("��2��ˮ�����˵���ǱȽϸɾ���");
		l.add("��b���ǻ����н�С���ʵò�");
	 * @return ��ˮ
	 */
	public static ItemStack getRainwater(){
		ItemStack sw=new ItemStack(Material.POTION);
		PotionMeta im = (PotionMeta) sw.getItemMeta();
		im.setColor(Color.fromRGB(36, 165, 229));
		im.setDisplayName("��b��l��ˮ");
		List<String> l=new LinkedList<String>();
		l.add("��a��l"+rs.getLoreTabel("Thirst")+": ��b��l"+Utils.random(5, 25)+"%");
		l.add("��2��l"+rs.getLoreTabel("SickKind")+": ��c��l"+rs.defSick.split(";")[(int)Utils.random(0, rs.defSick.split(";").length)]);
		l.add("��2��l"+rs.getLoreTabel("Sickness")+": ��c��l"+Utils.random(2, 10)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��2��ˮ�����˵���ǱȽϸɾ���");
		l.add("��b���ǻ����н�С���ʵò�");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
	 * l.add("��2���������Լ��õ����в���ҩ");
		l.add("��eҲ������Ҫע�ⰴʱ��ҩ.");
	 * @return ҩ
	 */
	public static ItemStack getMedicine01(){
		ItemStack sw=new ItemStack(Material.QUARTZ);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��a��lҩ");
		List<String> l=new LinkedList<String>();
		l.add("��2���������Լ��õ����в���ҩ");
		l.add("��2��������Ч���е���...");
		l.add("��eҲ������Ҫע�ⰴʱ��ҩ.");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	/**
	 * 
	 * @return ����
	 */
	public static ItemStack getMedicine02(){
		ItemStack sw=new ItemStack(Material.PAPER);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��a��l����");
		List<String> l=new LinkedList<String>();
		l.add("��2���������Լ��Ĺ���");
		l.add("��eҲ������Ҫע�ⰴʱ��һ��.");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
	 * 
	 * @return ¯��
	 */
	public static ItemStack getJunk(){
		ItemStack sw=new ItemStack(Material.MELON_SEEDS);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��7��l¯��");
		List<String> l=new LinkedList<String>();
		l.add("��7��l"+rs.getLoreTabel("Thirst")+": -"+Utils.random(45,80)+"%");
		l.add("��7��l"+rs.getLoreTabel("SickKind")+": "+rs.defSick.split(";")[(int)Utils.random(0, rs.defSick.split(";").length)]);
		l.add("��7��l"+rs.getLoreTabel("Sickness")+": "+Utils.random(99,101)+"%");
		l.add("");
		l.add("��7��l"+rs.getLoreTabel("weight")+": 1");
		l.add("");
		l.add("��c��l�ն���ʧ�ܺ����Ʒ");
		l.add("��c��l�Ȳ�˵�ڸ���ô��,������ҳ���?");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	public static ItemStack getRainWaterCollector(){
		ItemStack sw=new ItemStack(Material.HOPPER);
		//ItemStack sw=new ItemStack(Material.CAULDRON_ITEM);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��3��l��ˮ�ռ���");
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
	 * l.add("��9���ص��ϸ�����");
	 * @return ����
	 */
	public static ItemStack getPlaceholder6(){
		ItemStack sw=new ItemStack(Material.NETHER_STAR);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��9��l����");
		List<String> l=new LinkedList<String>();
		l.add("��9���ص��ϸ�����");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
	 * l.add("��9��һҳ");
	 * @return ��һҳ
	 */
	public static ItemStack getPlaceholder7(){
		ItemStack sw=new ItemStack(Material.EMERALD);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��9��l��һҳ");
		List<String> l=new LinkedList<String>();
		l.add("��9��һ������");
		im.setLore(l);
		sw.setItemMeta(im);
		return sw;
	}
	
	/**
	 * name=�䷽��
	 *		l.add("��9����鿴��Ӧ�䷽");
	 * @return ����
	 */
	public static ItemStack getPlaceholder9(String name,ItemStack sw1,long time){
		ItemMeta im = sw1.getItemMeta();
		im.setDisplayName("��9��l"+name);
		List<String> l=im.getLore();
		if(l==null)
			l=new LinkedList<String>();
		l.add(0, "��e===============================");
		l.add(0, "��b��������ʱ��: ��3��l"+time+"��b��");
		l.add(0, "��b�䷽��: ��9��l"+name);
		l.add(0, "��e===============================");
		im.setLore(l);
		sw1.setItemMeta(im);
		return sw1;
	}
	
	public static  ItemStack getPlaceholder10(short data,int pass){
		ItemStack sw=new ItemStack(Material.STAINED_GLASS_PANE,1,data);
		ItemMeta im = sw.getItemMeta();
		if(pass>=100)
			im.setDisplayName("��9��l����� - �����ȡ��Ʒ!");
		else
			im.setDisplayName("��9��l����� "+pass+"%");
		sw.setItemMeta(im);
		return sw;
	}

	public static ItemStack getPlaceholder13(){
		ItemStack sw=new ItemStack(Material.STAINED_GLASS_PANE,1,(short)9);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName("��3��l��ˮ");
		sw.setItemMeta(im);
		return sw;
	}

	/**
	 * ����һ�����������ַ��ռλ��
	 * @param x 
	 * @param y
	 * @param z
	 * @param world
	 * @param id
	 * @return
	 */
	public static ItemStack createWorldPlaceholder(int x,int y,int z,String world,short id){
		ItemStack sw=new ItemStack(Material.STAINED_GLASS_PANE,1,id);
		ItemMeta im = sw.getItemMeta();
		im.setDisplayName(world+","+x+","+y+","+z);
		sw.setItemMeta(im);
		return sw;
	}


	public static ItemStack createItemKey(Material type,short damage,String world,int x,int y,int z){
		ItemStack is=new ItemStack(type,1,damage);
		ItemMeta im=is.getItemMeta();
		//set Key
		im.setDisplayName(world+Long.toHexString(Long.parseLong((x+""+y+""+z+"").replace("-", "010"))));
		im.setLore(Arrays.asList(world,x+"",y+"",z+""));
		is.setItemMeta(im);
		return is;
	}
	
	
	public static ItemStack createPItem(short damage,String name){
		ItemStack is=new ItemStack(Material.STAINED_GLASS_PANE,1,damage);
		ItemMeta im=is.getItemMeta();
		im.setDisplayName(name);
		is.setItemMeta(im);
		return is;
	}
	
	public static ItemStack createItemKey(Material type,short damage,String key){
		ItemStack is=new ItemStack(type,1,damage);
		ItemMeta im=is.getItemMeta();
		//set Key
		im.setDisplayName(key);
		is.setItemMeta(im);
		return is;
	}
}
