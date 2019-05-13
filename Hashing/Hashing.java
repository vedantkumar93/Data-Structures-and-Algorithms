public class Hashing {

	public static void main(String[] args) {
		String names[] = { "Dallas", "New Delhi", "Houston", "New York", "Rome", "Chennai", "EWR", "Spain", "Newark",
				"El Paso", "Hashing", "Richards", "Pune", "JFK", "abcd", "iPhone 7", "75081", "Best Buy", "static",
				"tijuana" };
		String hashTable[] = new String[31];
		hashTable = hashing(names, hashTable);
		print(hashTable);
		hashTable = resize(hashTable, names);
		System.out.println();
		hashTable = hashing(names, hashTable);
		print(hashTable);
	}

	private static String[] resize(String[] hashTable, String[] names) {
		int newSize = names.length * 2;
		boolean value = false;
		while (value == false) {
			value = isPrime(newSize);
			newSize++;
		}
		String[] newHashTable = new String[newSize];
		return newHashTable;

	}

	private static boolean isPrime(int newSize) {
		if (newSize % 2 == 0)
			return false;
		else {
			for (int i = 3; i < Math.sqrt(newSize); i = i + 2) {
				if (newSize % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static void print(String[] hashTable) {
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null)
				System.out.println(i + "\t" + hashTable[i]);
			else
				System.out.println(i);
		}

	}

	private static String[] hashing(String[] names, String[] hashTable) {
		int sum, probe, collisions = 0, temp;
		for (String s : names) {
			sum = 0;
			probe = 1;
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i);
			}
			if (hashTable[sum % hashTable.length] == null)
				hashTable[sum % hashTable.length] = s;
			else {
				while (true) {
					collisions++;
					temp = sum % hashTable.length + probe * probe;
					while (temp > hashTable.length)
						temp = temp % hashTable.length;

					if (hashTable[temp % hashTable.length] == null) {
						hashTable[temp % hashTable.length] = s;
						break;
					}
					probe++;
				}
			}
		}
		System.out.println("Collisions occured: " + collisions);
		return hashTable;
	}

}
