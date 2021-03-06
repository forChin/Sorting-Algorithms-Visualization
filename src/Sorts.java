import java.awt.image.BufferedImage;
import java.util.ArrayList;

/* Sorts.java contains sorting methods for 
 * sorting the image by id
 */

public class Sorts {
	
	public static void bubbleSort(ArrayList<Pixel> pixels) {
		for (int i = 0; i < pixels.size(); i++) {
			for (int j = pixels.size()-1; j > i; j--) {
				Pixel left = pixels.get(j-1);
				Pixel right = pixels.get(j);
				
				if (left.getID() > right.getID()) {
					int tempPosition = left.getID();
					BufferedImage subimg = left.getSubimage();
					
					left.setID(right.getID());
					left.setSubimage(right.getSubimage());
					
					right.setID(tempPosition);
					right.setSubimage(subimg);
					
					return;
				}
			}
		}
	}
	
	public static void insertionSort(ArrayList<Pixel> pixels) {		
        for (int i = 1; i < pixels.size(); ++i) { 
            int tempPos = pixels.get(i).getID();
            BufferedImage tempImg = pixels.get(i).getSubimage();
            int j = i - 1;
  
            while (j >= 0 && pixels.get(j).getID() > tempPos) { 
                pixels.get(j + 1).setID(pixels.get(j).getID());
                pixels.get(j + 1).setSubimage(pixels.get(j).getSubimage());                
                j--;
            }
            
            if(i != j + 1) {
                pixels.get(j + 1).setID(tempPos);
                pixels.get(j + 1).setSubimage(tempImg);
                return;
            }
        }
    }

    public static void quickSort(int low, int high, ArrayList<Pixel> numbers) {
        int i = low, j = high;
        int pivot = numbers.get((low + high)/2).getID();

        while (i <= j) {
        	
            while (numbers.get(i).getID() < pivot && i < high) {
                i++;
            }
            
            while (numbers.get(j).getID() > pivot && j > low) {
                j--;
            }

            if (i <= j) {
            	int tempPos = numbers.get(i).getID();
            	BufferedImage tempSubimg = numbers.get(i).getSubimage();
            	
                numbers.get(i).setID(numbers.get(j).getID());
                numbers.get(i).setSubimage(numbers.get(j).getSubimage());
                
                numbers.get(j).setID(tempPos);
                numbers.get(j).setSubimage(tempSubimg);
                i++;
                j--;
                
                if(i<j) {
                    return;                	
                }
            }
        }

        if (low < j) {
            quickSort(low, j, numbers);
        }
        
        if (i < high) {
            quickSort(i, high, numbers);
        }
    }

	public static void selectionSort(ArrayList<Pixel> pixels) {
        int n = pixels.size(); 
  
        for (int i = 0; i < n-1; i++) { 
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (pixels.get(j).getID() < pixels.get(min_idx).getID()) {
                    min_idx = j;                	
                }            	
            }
  
            if(min_idx != i) {
                int tempPos = pixels.get(min_idx).getID();
                BufferedImage tempImg = pixels.get(min_idx).getSubimage();
                
                pixels.get(min_idx).setID(pixels.get(i).getID());
                pixels.get(min_idx).setSubimage(pixels.get(i).getSubimage());
                
                pixels.get(i).setID(tempPos);
                pixels.get(i).setSubimage(tempImg);
            	return;
            }
        } 
	}
	
	public static void shellSort(ArrayList<Pixel> arr) { 
        int n = arr.size(); 
  
        for (int gap = n/2; gap > 0; gap /= 2) { 
            for (int i = gap; i < n; i += 1) { 
                int temp = arr.get(i).getID();
                BufferedImage tempImg = arr.get(i).getSubimage();
  
                int j; 
                for (j = i; j >= gap; j -= gap) {
                	if(arr.get(j - gap).getID() > temp) {
    	                arr.get(j).setSubimage(arr.get(j - gap).getSubimage());
                    	arr.get(j).setID(arr.get(j - gap).getID());
                    	
                        arr.get(j-gap).setID(temp); 
                        arr.get(j-gap).setSubimage(tempImg);
                        
                    	return;
                	}
                	break;
                }
                
                arr.get(j).setID(temp); 
                arr.get(j).setSubimage(tempImg);
            }
        } 
    }
	
	public static void cocktailSort(ArrayList<Pixel> pixels) { 
        int start = 0; 
        int end = pixels.size(); 
  
        for (int i = start; i < end - 1; ++i) { 
            if (pixels.get(i).getID() > pixels.get(i + 1).getID()) { 
                int temp = pixels.get(i).getID(); 
                BufferedImage tempImg = pixels.get(i).getSubimage(); 
                
                pixels.get(i).setID(pixels.get(i + 1).getID()); 
                pixels.get(i).setSubimage(pixels.get(i + 1).getSubimage()); 
                
                pixels.get(i + 1).setID(temp); 
                pixels.get(i + 1).setSubimage(tempImg); 
            }
        }
  
        end--;
  
        for (int i = end - 1; i >= start; i--) { 
            if (pixels.get(i).getID() > pixels.get(i + 1).getID()) {
                int temp = pixels.get(i).getID(); 
                BufferedImage tempImg = pixels.get(i).getSubimage(); 
                
                pixels.get(i).setID(pixels.get(i + 1).getID()); 
                pixels.get(i).setSubimage(pixels.get(i + 1).getSubimage()); 
                
                pixels.get(i + 1).setID(temp); 
                pixels.get(i + 1).setSubimage(tempImg); 
                return;
            }
        }
    }
	
    public static void mergeSort(ArrayList<Pixel> pixels, int l, int r) {
        int m = (l+r)/2; 
        
        if (l < r) {
            mergeSort(pixels, l, m);
            mergeSort(pixels , m+1, r); 
        }
        
        int n1 = m - l + 1; 
        int n2 = r - m; 
  
        int L[] = new int [n1];
        ArrayList<BufferedImage> Limg = new ArrayList<>(n1);
        
        int R[] = new int [n2];
        ArrayList<BufferedImage> Rimg = new ArrayList<>(n2);
  
        for (int i=0; i<n1; ++i) {
            L[i] = pixels.get(l + i).getID();
        	Limg.add(i, pixels.get(l + i).getSubimage());        	
        }
        
        for (int j=0; j<n2; ++j) {
            R[j] = pixels.get(m + 1+ j).getID();         	
        	Rimg.add(j, pixels.get(m + 1 + j).getSubimage());        	
        }
  
  
        int i = 0, j = 0; 
  
        int k = l; 
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) { 
                pixels.get(k).setID(L[i]);
                pixels.get(k).setSubimage(Limg.get(i));
                i++; 
                k++;
            } else { 
                pixels.get(k).setID(R[j]);
                pixels.get(k).setSubimage(Rimg.get(j));
                j++;
                k++;
                break;
            } 
        } 
  
        while (i < n1) { 
            pixels.get(k).setID(L[i]);
            pixels.get(k).setSubimage(Limg.get(i));
            i++;
            k++; 
        } 
  
        while (j < n2) { 
            pixels.get(k).setID(R[j]);
            pixels.get(k).setSubimage(Rimg.get(j));
            j++; 
            k++; 
        }
    }
    
    public static void randomSort(ArrayList<Pixel> pixels) {
		int MAX = 7;
		int MIN = 1;
		
		// Generate random number between 1 and 7
		int b = (int) (Math.random() * ((MAX - MIN) + 1)) + MIN;
		
		if(b == 1) {
			bubbleSort(pixels);
		} else if(b == 2) {
			mergeSort(pixels, 0, pixels.size()-1);
		} else if(b == 3) {
			quickSort(0, pixels.size()-1, pixels);
		} else if(b == 4) {
			insertionSort(pixels);
		} else if(b == 5) {
			shellSort(pixels);
		} else if(b == 6) {
			selectionSort(pixels);
		} else if(b == 7) {
			cocktailSort(pixels);
		}
    }
}