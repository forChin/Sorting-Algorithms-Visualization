import java.util.ArrayList;

public class SortIterator {
	private boolean random, bubble, cocktail, quick, 
						insertion, selection, merge, shell;
	private ArrayList<ArrayList<Pixel>> array;
	
	
	SortIterator() {
		bubble = true;
		merge = false;
		insertion = false;
		quick = false;
		shell = false;
		selection = false;
		cocktail = false;
		random = false;
	}
	
	public void sort(ArrayList<ArrayList<Pixel>> array) {
		this.array = array;
		
		for(int i = 0; i < array.size(); i++) {
			if(bubble) {
				Sorts.bubbleSort(array.get(i));
			} else if(merge) {
				Sorts.mergeSort(array.get(i), 0, array.get(i).size()-1);
			} else if (quick) {
				Sorts.quickSort(0, array.get(i).size()-1, array.get(i));
			} else if(insertion) {
				Sorts.insertionSort(array.get(i));
			} else if(shell) {
				Sorts.shellSort(array.get(i));
			} else if(selection) {
				Sorts.selectionSort(array.get(i));
			} else if(cocktail) {
				Sorts.cocktailSort(array.get(i));
			} else if(random) {
				Sorts.randomSort(array.get(i));
			}
		}
	}
	
	public void setSort(String sortMethod) {
		cocktail = false;
		shell = false;
		bubble = false;
		merge = false;
		insertion = false;
		quick = false;
		selection = false;
		random = false;
		
		if(sortMethod.equals("Bubble sort")) {
			bubble = true;
		} else if (sortMethod.equals("Merge sort")) {
			merge = true;
		} else if (sortMethod.equals("Quick sort")) {
			quick = true;
		} else if (sortMethod.equals("Insertion sort")) {
			insertion = true;
		} else if (sortMethod.equals("Shell sort")) {
			shell = true;
		} else if (sortMethod.equals("Cocktail sort")) {
			cocktail = true;
		} else if(sortMethod.equals("Selection sort")) {
			selection = true;
		} else if(sortMethod.equals("Randomly")) {
			random = true;
		}
	}
	
	public boolean isSorted() {
		for(int i = 0; i < array.size(); i++) {
			for(int j = 1; j < array.get(i).size(); j++) {
				if(array.get(i).get(j-1).getPosition() > array.get(i).get(j).getPosition()) {
					return false;
				}
			}
		}
		
		return true;
	}
}
