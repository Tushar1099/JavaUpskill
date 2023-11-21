package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HashMaping {

	public static void main(String[] args) {
		Map<String, Integer> age = new HashMap<>();
		age.put("alice",20);
		age.put("agatha",19);
		age.put("hasan",30);
		age.put("jawad",7);
		
//		Set<Entry<String, Integer>> entry = age.entrySet();
		for (Entry<String, Integer> entry: age.entrySet()) {
			System.out.println(entry.getKey()+" - "+entry.getValue());
		}		
	}

}
