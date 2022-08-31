package com.evanl.springidp;

import java.util.List;


public interface NonFloralService {	
	 List<NonFloral> getAllNonFloral();
	 void saveNonFloral(NonFloral Nonfloral);
	 NonFloral getNonFloralById(long nonFloralId);
	 void deleteNonFloralById(long nonFloralId);
}

