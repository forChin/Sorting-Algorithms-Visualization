import java.util.ArrayList;

/* SortIterator.java sorts every row of the image
 * by selected sorting method
 */

public class SortIterator {
	private boolean random, bubble, cocktail, quick, 
						insertion, selection, merge, shell;
	private ArrayList<ArrayList<Pixel>> pixels;
	
	
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
	
	public void sort(ArrayList<ArrayList<Pixel>> pixels) {
		this.pixels = pixels;
		
		for(int i = 0; i < pixels.size(); i++) {
			if(bubble) {
				Sorts.bubbleSort(pixels.get(i));
			} else if(merge) {
				Sorts.mergeSort(pixels.get(i), 0, pixels.get(i).size()-1);
			} else if (quick) {
				Sorts.quickSort(0, pixels.get(i).size()-1, pixels.get(i));
			} else if(insertion) {
				Sorts.insertionSort(pixels.get(i));
			} else if(shell) {
				Sorts.shellSort(pixels.get(i));
			} else if(selection) {
				Sorts.selectionSort(pixels.get(i));
			} else if(cocktail) {
				Sorts.cocktailSort(pixels.get(i));
			} else if(random) {
				Sorts.randomSort(pixels.get(i));
			}
		}
	}
	
	public void setSortingMethod(String sortingMethod) {
		cocktail = false;
		shell = false;
		bubble = false;
		merge = false;
		insertion = false;
		quick = false;
		selection = false;
		random = false;
		
		if(sortingMethod.equals("Bubble sort")) {
			bubble = true;
		} else if (sortingMethod.equals("Merge sort")) {
			merge = true;
		} else if (sortingMethod.equals("Quick sort")) {
			quick = true;
		} else if (sortingMethod.equals("Insertion sort")) {
			insertion = true;
		} else if (sortingMethod.equals("Shell sort")) {
			shell = true;
		} else if (sortingMethod.equals("Cocktail sort")) {
			cocktail = true;
		} else if(sortingMethod.equals("Selection sort")) {
			selection = true;
		} else if(sortingMethod.equals("Randomly")) {
			random = true;
		}
	}
	
	public boolean isSorted() {
		for(int i = 0; i < pixels.size(); i++) {
			for(int j = 1; j < pixels.get(i).size(); j++) {
				if(pixels.get(i).get(j-1).getID() > pixels.get(i).get(j).getID()) {
					return false;
				}
			}
		}
		
		return true;
	}
}
