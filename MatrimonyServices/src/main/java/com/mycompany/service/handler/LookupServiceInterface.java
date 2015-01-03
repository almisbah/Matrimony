package com.mycompany.service.handler;

import java.util.Map;

import javax.xml.bind.Element;

import org.w3c.dom.Document;

public interface LookupServiceInterface {
	public Element SaveLookup();
	public Map<String,String> SimpleLookup();
	public Map<String,String> regexLookup();
	public Map<String,Document> detailedLookup();
}
