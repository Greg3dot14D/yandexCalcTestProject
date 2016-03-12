package ru.greg3d.pages;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;

public abstract class AnyPage extends Page  implements ClipboardOwner{

	public AnyPage(PageManager pages) {
		super(pages);
	}
	
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		// TODO Auto-generated method stub
		
	}
}
