package me.HavocDev.Client.Variables;

public enum Category {
	
	
	Render(0), Player(1), Movement(2), Combat(3), Exploit(4), Fun(5), World(6), Client(7);
	public int id = 0;
	public int numOfCats = 7;
	private Category(int num)
	{
		id = num;
	}

}

