package ru.greg3d.util;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;

public class Tools {

	 public static void setClipboardContents(String text2Copy, ClipboardOwner owner) {  
		  // TODO Auto-generated method stub  
		  StringSelection stringSelection = new StringSelection(text2Copy);  
		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();  
		  clipboard.setContents(stringSelection, owner);  
	 }
}
