package com.outlook.schooluniformsama.event.basic;

import com.outlook.schooluniformsama.data.recipes.Recipe;
import com.outlook.schooluniformsama.data.timer.Timer;
import com.outlook.schooluniformsama.util.HashMap;

public class TempData {
	public static HashMap<String,Recipe> createRecipeTemp =new HashMap<>();
	public static HashMap<String,String> openingWorkbench=new HashMap<>();
	public static HashMap<String, Timer>createTimerTemp=new HashMap<>();
}
