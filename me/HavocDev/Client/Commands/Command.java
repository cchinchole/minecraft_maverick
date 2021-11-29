package me.HavocDev.Client.Commands;

public class Command {
	
	public String command;
	public String syntax;
	
	public Command(String command, String syntax)
	{
		this.command = command;
		this.syntax = syntax;
	}
	
	public void onCommand(String[] args){}
	

}
