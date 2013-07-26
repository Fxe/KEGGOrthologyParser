package de.fxe.parser;

import java.util.ArrayList;
import java.util.List;

public class AuxUtilities {
	
	public static List<List<String>> cartesianProduct(List<List<String>> lists) {
		
	  List<List<String>> resultLists = new ArrayList<List<String>>();
	  if (lists.size() == 0) {
	    resultLists.add(new ArrayList<String>());
	    return resultLists;
	  } else {
	      List<String> prim_list = lists.get(0);
	      List<List<String>> rest = cartesianProduct(lists.subList(1, lists.size()));
	      for(String expr : prim_list)
	      {
	        for(List<String > rest_list : rest)
	        {
	          ArrayList<String> result = new ArrayList<String>();
	          result.add(expr);
	          result.addAll(rest_list);
	          resultLists.add(result);
	        }
	      }
	    }
	    return resultLists;
	 }
	
	public static<T> List<List<T>> cartProd(List < List<List<T>>> listOfList) {
		if (listOfList.size() < 2) return listOfList.get(0);
		
		List< List<T>> r = cartesianProduct_(listOfList.get(0), listOfList.get(1));
		for (int i = 2; i < listOfList.size(); i++) {
			r = cartesianProduct_(r, listOfList.get(i));
		}
		return r;
	}
	
	public static<T> List<List<T>> cartesianProduct_(List<List<T>> set1, List<List<T>> set2) {
		List< List<T>> ret = new ArrayList< List<T>>();
		for ( int i = 0; i < set1.size(); i++) {
			for ( int j = 0; j < set2.size(); j++) {
				List<T> innerSet = new ArrayList<T> ();
				innerSet.addAll( set1.get(i));
				innerSet.addAll( set2.get(j));
				ret.add(innerSet);
			}
		}
		return ret;
	}
	
	public static List<String> cartStringConcatProd(List<List<String>> listOfList) {
		if ( listOfList.size() < 2) return listOfList.get(0);
		
		List< String> r = cartStringConcatProd_(listOfList.get(0), listOfList.get(1));
		for (int i = 2; i < listOfList.size(); i++) {
			r = cartStringConcatProd_(r, listOfList.get(i));
		}
		return r;
	}
	
	public static List<String> cartStringConcatProd_(List<String> set1, List<String> set2) {
		List< String> ret = new ArrayList< String>();
		for ( int i = 0; i < set1.size(); i++) {
			String str_i = set1.get(i);
			for ( int j = 0; j < set2.size(); j++) {
				String str_j = set2.get(j);
				ret.add(str_i + "+" + str_j);
			}
		}
		return ret;
	}
	
	public static List< List<String>> cartStringConcatProd2(List<List< List<String>>> listOfList) {
		if ( listOfList.size() < 2) return listOfList.get(0);
		
		List< List<String>> r = cartStringConcatProd2_(listOfList.get(0), listOfList.get(1));
		for (int i = 2; i < listOfList.size(); i++) {
			r = cartStringConcatProd2_(r, listOfList.get(i));
		}
		return r;
	}
	
	public static List< List<String>> cartStringConcatProd2_(List< List<String>> set1, List< List<String>> set2) {
		List< List<String>> ret = new ArrayList< List<String>>();
		for ( int i = 0; i < set1.size(); i++) {
			List<String> l_i = set1.get(i);
			for ( int j = 0; j < set2.size(); j++) {
				List<String> l_j = set2.get(j);
				ret.add( cartStringConcatProd_(l_i, l_j));
			}
		}
		return ret;
	}
	
	
	public static void main(String args[]) {
		List< List< String>> l1 = new ArrayList< List< String>> ();
		List< String> l1_1 = new ArrayList< String> (); l1_1.add("A"); l1_1.add("B");
		List< String> l1_2 = new ArrayList< String> (); l1_2.add("C"); l1_2.add("D");
		l1.add(l1_1); l1.add(l1_2);
		List< List< String>> l2 = new ArrayList< List< String>> ();
		List< String> l2_1 = new ArrayList< String> (); l2_1.add("Y");
		l2.add(l2_1);
		
		List< List< String>> l3 = new ArrayList< List< String>> ();
		List< String> l3_1 = new ArrayList< String> (); l3_1.add("M"); l3_1.add("N");
		l3.add(l3_1);
		
		System.out.println( l1);
		System.out.println( l2);
		System.out.println( l3);
		
		List< List< List< String>>> l1Xl2 = new ArrayList< List <List< String>>> ();
		l1Xl2.add(l1); l1Xl2.add(l2);
		System.out.println( cartStringConcatProd2(l1Xl2));
		List< List< List< String>>> l3Xl2 = new ArrayList< List <List< String>>> ();
		l3Xl2.add(l3); l3Xl2.add(l2);
		System.out.println( cartStringConcatProd2(l3Xl2));
		List< List< List< String>>> l3Xl1 = new ArrayList< List <List< String>>> ();
		l3Xl1.add(l3); l3Xl1.add(l1);
		System.out.println( cartStringConcatProd2(l3Xl1));
		//l1.add("B");
		//List<String> l2 = new ArrayList<String> ();
		//l2.add("X");
		//l2.add("Y");
		
		//System.out.println( cartStringConcatProd_(l1, l2));
	}
	//sumString(Li)

}
