package me.HavocDev.Client.Gui.Tab;

import java.awt.Color;
import java.math.BigDecimal;

import org.lwjgl.opengl.GL11;

import me.HavocDev.Client.Client.Client;
import me.HavocDev.Client.Mods.Mod;
import me.HavocDev.Client.Setting.Setting;
import me.HavocDev.Client.Utilities.GLUtils;
import me.HavocDev.Client.Variables.Category;
import me.HavocDev.Client.Variables.Colors;
import net.wurstclient.font.Fonts;

public class TabGui extends Mod {

	public TabGui() {
		super("`", "Tab GUI", "gui", Category.Render, -999);
	}

	int scrollIndex = 0;
	int maxIndex = Category.Combat.numOfCats;
	int modCount = -1;
	int subCat = 0;
	Mod selectedMod = null;
	static Category selectedCat = null;
	public boolean isArraylist = false;
	public boolean settingSelected = false;

	public void leftKey() {
		if (selectedCat != null && !settingSelected) {
			if (selectedMod == null) {
				scrollIndex = selectedCat.id;
				selectedCat = null;
				modCount = -1;
				maxIndex = Category.Combat.numOfCats;
			} else {
				maxIndex = modCount;
				scrollIndex = subCat;
				selectedMod = null;
			}
		} else if (selectedCat != null && selectedMod != null && settingSelected) {
			selectedMod.settings.get(scrollIndex).lowerValue();
		}
	}

	public void rightKey() {
		if (selectedCat == null) {
			for (Category c : Category.values()) {
				if (scrollIndex == c.id)
					selectedCat = c;
			}
			if (modCount == -1) {
				for (Mod m : Client.INSTANCE.modManager.mods) {
					if (m.getCategory() == selectedCat) {
						modCount++;
					}
				}
				maxIndex = modCount;
				scrollIndex = 0;
			}


		} else if (selectedCat != null && selectedMod == null && !settingSelected) {
			int zz = 0;
			for (Mod m : Client.INSTANCE.modManager.mods) {
				if (m.getCategory() == selectedCat) {
					if (zz == scrollIndex) {
						if (!m.settings.isEmpty()) {
							subCat = scrollIndex;
							scrollIndex = 0;
							maxIndex = m.settings.size() - 1;
							selectedMod = m;
						}
						break;
					}
					zz++;
				}
			}
		} else if (selectedCat != null && selectedMod != null && settingSelected) {
			selectedMod.settings.get(scrollIndex).addValue();
		}
	}


	public void enterKey() {
		if (selectedCat != null && selectedMod == null) {
			int zz = 0;
			for (Mod m : Client.INSTANCE.modManager.mods) {
				if (m.getCategory() == selectedCat) {
					if (zz == scrollIndex) {
						m.onToggle();
						break;
					}
					zz++;
				}
			}

		} else if (selectedCat != null && selectedMod != null) {
			settingSelected = !settingSelected;
		}

	}

	public void upKey() {
		scrollIndex--;
		if (scrollIndex < 0)
			scrollIndex = maxIndex;
	}

	public void downKey() {
		scrollIndex++;
		if (scrollIndex > maxIndex)
			scrollIndex = 0;
	}


	/*
	private static void drawBox(int x1, int y1, int x2, int y2, float r, float g, float b, float a) {
		// color
		//GL11.glColor4f(0.F, 0.F, 0.F, 0.5F);
		GL11.glColor4f(r, g, b, a);

		// box
		GL11.glBegin(GL11.GL_QUADS);
		{
			GL11.glVertex2i(x1, y1);
			GL11.glVertex2i(x2, y1);
			GL11.glVertex2i(x2, y2);
			GL11.glVertex2i(x1, y2);
		}
		GL11.glEnd();

		// outline positions
		double xi1 = x1 - 0.1;
		double xi2 = x2 + 0.1;
		double yi1 = y1 - 0.1;
		double yi2 = y2 + 0.1;

		// outline
		GL11.glLineWidth(1);
		GL11.glColor4f(0, 0, 0, 0.5F);
		GL11.glBegin(GL11.GL_LINE_LOOP);
		{
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
		}
		GL11.glEnd();

		// shadow positions
		xi1 -= 0.9;
		xi2 += 0.9;
		yi1 -= 0.9;
		yi2 += 0.9;

		float[] shadow;
		shadow = new float[]{0.125F, 0.125F, 0.125F};

		// top left
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glColor4f(shadow[0], shadow[1], shadow[2], 0.75F);
			GL11.glVertex2d(x1, y1);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f(0, 0, 0, 0);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi1, yi1);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f(shadow[0], shadow[1], shadow[2], 0.75F);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();

		// bottom right
		GL11.glBegin(GL11.GL_POLYGON);
		{
			GL11.glVertex2d(x2, y2);
			GL11.glVertex2d(x2, y1);
			GL11.glColor4f(0, 0, 0, 0);
			GL11.glVertex2d(xi2, yi1);
			GL11.glVertex2d(xi2, yi2);
			GL11.glVertex2d(xi1, yi2);
			GL11.glColor4f(shadow[0], shadow[1], shadow[2], 0.75F);
			GL11.glVertex2d(x1, y2);
		}
		GL11.glEnd();
	}

*/
	int map(int x, int in_min, int in_max, int out_min, int out_max) {
		return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
	}

	int mapColor(int val, int inLow, int inMax) {
		return ((val - inLow) * (255)) / (inMax - inLow);
	}

	float mapColor(float val, int inLow, int inMax) {
		return ((val - inLow) * (255)) / (inMax - inLow);
	}

	double mapColor(double val, double inLow, double inMax) {
		return ((val - inLow) * (255)) / (inMax - inLow);
	}

	public float round(float d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}


	String clientPrefix = "\2475";
	String activePrefix = "\247a";
	String selPrefix = "\2479";
	String normalPrefix = "\247f";
	String resetColor = "\247r";

	public Object getValue(Setting a) {

		Object out = null;

		switch (a.getValueType()) {
			case INT:
				out = a.getValue();
				break;
			case BOOL:
				out = a.getValue();
				break;
			case FLOAT:
				out = round((float) a.getValue(), 2);
				break;
			case STRING:
				out = a.getValue();
				break;
			default:
				out = a.getValue();
				break;
		}

		return out;
	}



	public void renderT(float partialTicks)
	{
		if(this.getActive())
		{
			GL11.glDisable(GL11.GL_CULL_FACE);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			GL11.glShadeModel(GL11.GL_SMOOTH);
			int margin = 10;
			int distText = 1;
			int distTextX = 6;
			int startX = 15;
			int startY = 15;
			GLUtils.drawBox(startX, startY, startX+(margin*5), (startY+margin)+((Category.Combat.numOfCats+1)*margin), 69, 1, 158, 0.8f);
			Fonts.calibri12.drawString(clientPrefix+Client.INSTANCE.getClientName(), startX+distText+distTextX, startY+distText, Colors.CLIENT_COLOR);
			int y = startY+margin+distText;
			int countY = 0;
			int count = 0;
			for(Category c : Category.values())
			{
			    if(selectedCat == c)
			    {
			        count = 0;
				    countY = startY+margin+distText;
				    GL11.glDisable(GL11.GL_TEXTURE_2D);
				    GLUtils. drawBox(startX+(margin*5)+distText, startY, startX+(margin*10)+distText, countY + ((modCount+1)*margin), 69, 1, 158, .8f);
			    	Fonts.calibri12.drawString(clientPrefix+c.name(), (startX+(margin*(5))+distTextX), startY+distText, Colors.CLIENT_COLOR);
				    for(Mod m : Client.INSTANCE.modManager.mods)
				    {
					    if(m.getCategory() == selectedCat)
					    {
						    int color = m.getActive() ? Colors.CLIENT_COLOR : Colors.WHITE;
						    if(modCount > -1 && scrollIndex == count && selectedMod == null)
						        if(m.getActive())
						            Fonts.calibri12.drawString(clientPrefix+"> "+activePrefix+m.getDisplayName(), (startX+(margin*(5))+distTextX), countY, color);
						        else
						            Fonts.calibri12.drawString(clientPrefix+"> "+selPrefix+m.getDisplayName(), (startX+(margin*(5))+distTextX), countY, color);
								else
									if(selectedMod != null && selectedMod == m)
										if(m.getActive())
											Fonts.calibri12.drawString(clientPrefix+"> "+activePrefix+m.getDisplayName(), (startX+(margin*(5))+distTextX), countY, Colors.CLIENT_COLOR);
										else
											Fonts.calibri12.drawString(clientPrefix+"> "+selPrefix+m.getDisplayName(), (startX+(margin*(5))+distTextX), countY, Colors.CLIENT_COLOR);
									else
										if(m.getActive())
											Fonts.calibri12.drawString(activePrefix+m.getDisplayName(), (startX+(margin*(5))+distTextX), countY, color);
										else
											Fonts.calibri12.drawString(normalPrefix+m.getDisplayName(), (startX+(margin*(5))+distTextX), countY, color);


							if(!m.settings.isEmpty())
							{
								
								GL11.glDisable(GL11.GL_TEXTURE_2D);
								
								if(selectedMod != m)
									GLUtils.drawBox(startX+(margin*10)+(distText*2), countY, startX+(margin*10)+distText, countY+(distText*4), 255f, 0f, 0f, 0.95f);
								else
									GLUtils.drawBox(startX+(margin*10)+(distText*2), countY, startX+(margin*10)+distText, countY+(distText*4), 0f, 255f, 0f, 0.95f);
							}

						countY+=margin;
						count++;
					}

					if(selectedMod != null && m == selectedMod)
					{

						GL11.glDisable(GL11.GL_TEXTURE_2D);
						GLUtils.drawBox(startX+(margin*10)+(distText*2), startY, startX+(margin*15)+distText, (startY+margin)+(selectedMod.settings.size()*margin), 69, 1, 158, 0.8f);
					

						Fonts.calibri12.drawString(clientPrefix+selectedMod.getDisplayName()+" Settings", startX+(margin*10)+distText+distTextX, startY+distText, Colors.CLIENT_COLOR);



						for(int i = 0; i < selectedMod.settings.size(); i++)
						{


							Setting setting = selectedMod.settings.get(i);
							int color;



							switch(setting.getValueType())
							{
							case INT:
								int max = (int) setting.getMax();
								int least = (int) setting.getLeast();
								color = new Color(255 - mapColor((int)setting.getValue(), (int)setting.getLeast(), (int)setting.getMax())  , mapColor((int)setting.getValue(), least, max), 0).getRGB();
							break;
							case FLOAT:
								float max1 = (float) setting.getMax();
								float least1 = (float) setting.getLeast();
								int val = mapColor((int)Math.round((float)setting.getValue()), Math.round(least1), Math.round(max1));
								color = new Color(255 - val, val, 0).getRGB();
							break;
							case BOOL:
								color = (boolean)setting.getValue() ? Colors.GREEN : Colors.RED;
							break;
							default:
								color = Colors.WHITE;
								break;

							}
							//if(setting.getValueType() == ValueType.INT)
							//	Fonts.calibri12.drawString(""+ mapColor( (int)setting.getValue(), (int)setting.getLeast(), (int)setting.getMax()), 170, 56+(i*15), color);


							if(scrollIndex == i)
								if(settingSelected)
									Fonts.calibri12.drawString("\247c"+"> "+selPrefix+setting.getName()+normalPrefix+" - "+resetColor+getValue(setting), startX+(margin*10)+distText+distTextX, startY+margin+(i*margin), color);
								else
									Fonts.calibri12.drawString(clientPrefix+"> "+selPrefix+setting.getName()+normalPrefix+" - "+resetColor+getValue(setting), startX+(margin*10)+distText+distTextX, startY+margin+(i*margin), color);
							else
								Fonts.calibri12.drawString(normalPrefix+setting.getName()+normalPrefix+" - "+resetColor+getValue(setting), startX+(margin*10)+distText+distTextX, startY+margin+(i*margin), color);
						}
					}


				}
				count = 0;
			}
			if(c.name() != "NOTHING" && c.name() != "None" && c.name() != "Value")
			{

				if(scrollIndex == count && (modCount == -1))
				{
					Fonts.calibri12.drawString(clientPrefix+"> "+selPrefix+c.name(), 25, y, Colors.WHITE);
				}
				else
					if(selectedCat != null && c == selectedCat)
						Fonts.calibri12.drawString(clientPrefix+"> "+selPrefix+c.name(), 25, y, Colors.CLIENT_COLOR);
					else
						Fonts.calibri12.drawString(c.name(), 25, y, Colors.WHITE);
				
				y+=margin;
				count++;
			}
			
			
			
		}
		
		if(selectedCat != null)
		{
			y = countY;
		
		}
		
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glDisable(GL11.GL_BLEND);
		//GL11.glEnable(GL11.GL_BLEND);
		//GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		//GL11.glShadeModel(GL11.GL_SMOOTH);

		
		
		}

		
	}
	
	@Override
	public void onToggle()
	{
		this.isActive = !this.isActive;
		if(this.isActive)
			this.onEnable();
		else
			this.onDisable();
		
		
	}
	
}
