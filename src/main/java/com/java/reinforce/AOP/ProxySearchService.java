package com.java.reinforce.AOP;

public class ProxySearchService implements SearchService{

	private SearchService searchService;
	public ProxySearchService(
			SearchService searchService) {
		this.searchService=searchService;
	}

	public Object search(String key) {
    	long t1=System.nanoTime();
	    Object result=searchService.search(key);
	    long t2=System.nanoTime();
	    long t=t2-t1;
	    System.out.println("total time "+t);
		return result;
	}
}
