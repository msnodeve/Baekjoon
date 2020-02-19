package baekjoon.silver5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Person{
	int index;
	int age;
	String name;
	
	public Person(int index, int age, String name) {
		this.index = index;
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [index=" + index + ", age=" + age + ", name=" + name + "]";
	}
	
}
public class Main_10814_나이순정렬 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		ArrayList<Person> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
		}
		
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if(o1.age == o2.age) {
					return o1.index - o2.index;
				}
				return o1.age - o2.age;
			}
		});
		for(Person p : list) {
			System.out.println(p.age + " " + p.name);
		}
	}
}