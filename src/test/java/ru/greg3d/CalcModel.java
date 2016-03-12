package ru.greg3d;

import java.util.ArrayList;
import java.util.List;

public class CalcModel {

	private StringBuilder clicksSequence;
	private String spliter = "->";
	private List<String> clicksSequenceList;
	
	private CalcModel(){
		clicksSequence = new StringBuilder();
		clicksSequenceList = new ArrayList<String>();
	}
	
	public static CalcModel newSequence(){
		return new CalcModel();
	}
	
	public List<String> getClicksSequenceList(){
		return clicksSequenceList;
	}
	
	private void addThis(String arg){
		clicksSequence.append("click('" + arg +"')" + spliter);
		clicksSequenceList.add(arg);
	}
	
	public CalcModel clickZero(){
		addThis("0");
		return this;
	}	
	
	public CalcModel clickOne(){
		addThis("1");
		return this;
	}
	
	public CalcModel clickTwo(){
		addThis("2");
		return this;
	}	
	
	public CalcModel clickFore(){
		addThis("4");
		return this;
	}
	
	public CalcModel clickFive(){
		addThis("5");
		return this;
	}
	
	public CalcModel clickSqrt(){
		addThis("√");
		return this;
	}
	
	public CalcModel clickCos(){
		addThis("cos");
		return this;
	}
	
	public CalcModel clickPi(){
		addThis("π");
		return this;
	}
	
	public CalcModel clickDiv(){
		addThis("÷");
		return this;
	}
	
	public CalcModel clickMul(){
		addThis("×");
		return this;
	}
	
	public CalcModel clickDot(){
		addThis(",");
		return this;
	}
	
	public String getClicksSequence(){
		return clicksSequence.toString();
	}
	
}
