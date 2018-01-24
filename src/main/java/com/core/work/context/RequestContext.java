package com.core.work.context;

import java.util.HashMap;
import java.util.*;

public class RequestContext {
	private ThreadLocal<Map<String,String>> context = new ThreadLocal<Map<String,String>>();
	
	
}
