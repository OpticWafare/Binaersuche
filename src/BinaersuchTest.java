public class BinaersuchTest {


	public static int[] arr = new int[101];		

	
	static void arrayfuellen() {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
			//arr[i] = (int) (Math.random() * 101);
			// System.out.println(arr[i]);
		}
	}
	

	static void arrayOrdnen() {

		int temp = 0;

		boolean ordnen = false;
		while (ordnen == false) {	
			ordnen = true;	
			for (int i = 0; i < arr.length - 1; i++) 
			{

				if (arr[i] > (arr[i + 1]))
				{
					temp = arr[i + 1]; // speichert den 2ten Wert im Temp-Zwischenspeicher
					arr[i + 1] = arr[i]; // weist dem 2ten Wert den 1ten Wert zu
					arr[i] = temp; // weist dem 1ten Wert den 2ten Wert zu
					

					ordnen = false;
				}
			}
		}
		// Ordnung ist vorrueber -> Ausgabe aller Zahlen im Array
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	System.out.println(); 
	}

	/** 
	 * Sucht eine bestimmte Zahl in einem Array und
	 * gibt den Index, an dem sich die Zahl befindet, zurueck
	 * Vorraussetzung: Das Array muss der groesse nach aufsteigend sortiert sein
	 * @param arr Das Integer Array, in dem die zu suchende Zahl ist
	 * @param zahl Die Zahl, die gesucht werden soll
	 * @return Der Index an dem sich zahl im Array arr befindet; Falls die Zahl nicht im Array vorkommt, wird -1 zurueckgegeben */
	static int binaersuche(int[] arr, int zahl) {
		/** Der höchste Index des Arrays*/
		int max = arr.length;
		/** Der kleinste Index des Arrays*/
		int min = 0;
		/** Der Index in der Mitte des Arraybereiches*/
		int mitte = 0; 
		/** Zaehler checkt, wie oft schon durchlaufen wurde */
		int zaehlen = 0; 
		while (max-min > 1) {  

			zaehlen++; 
			mitte = (max + min) / 2; // Der Wert in der Mitte berechnen
			if (arr[mitte] == zahl) { // Wenn die Zahl in der Mitte zufaelligerweise die richtige Zahl ist (Endbedingung)
				System.out.println("Die Zahl " + arr[mitte] + " ist enthalten!"); //arr[mitte] == zahl
				System.out.println("Anzahl der Durchläufe: " + zaehlen); 
				System.out.println("Die Zahl befindet sich im Index " + mitte); 
				return mitte;	// index der Zahl zurueckgeben
			}
			// Wenn die gesuchte Zahl kleiner ist als die Zahl in der Mitte
			// -> Arraybereich verkleinern indem der End-Index auf den Index in der Mitte gesetzt wird (alle Zahlen nach der Mitte werden nicht mehr durchsucht)
			else if (arr[mitte] > zahl){
				max = mitte; 
			}
			// Wenn die gesuchte Zahl groessrr ist als die Zahl in der Mitte
			// -> Arraybereich verkleinern indem der Start-Index auf den Index in der Mitte gesetzt wird (alle Zahlen vor der Mitte werden nicht mehr durchsucht)
			else if (arr[mitte] < zahl) { 
				min = mitte; 
			}
		}
		System.out.println("Die Zahl " + zahl + " ist nicht enthalten!");
		System.out.println("Anzahl der Durchläufe: " + zaehlen);
		return -1;
	}

	public static void main(String[] args) {
		arrayfuellen();
		//arrayOrdnen();
		//int[] arr2 = { 1,15,23,45,56,87};
		int[] arr2 = { 1,1,1,2,3,4,4,5,5,5};
		binaersuche(arr2, 27);
	}

}
