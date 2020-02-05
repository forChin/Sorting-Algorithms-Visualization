import java.awt.image.BufferedImage;
import java.util.ArrayList;

class MergeSort {

	// Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
    void merge(ArrayList<Pixel> arr, int l, int m, int r) { 
    }
  
    // Main function that sorts arr[l..r] using 
    // merge() 
    void sort(ArrayList<Pixel> arr, int l, int r) { 
        if (l < r) { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            sort(arr, l, m);
            sort(arr , m+1, r); 
  
            // Merge the sorted halves 
            int n1 = m - l + 1; 
            int n2 = r - m; 
      
            /* Create temp arrays */
            int L[] = new int [n1];
            ArrayList<BufferedImage> Limg = new ArrayList<>(n1);
            
            int R[] = new int [n2];
            ArrayList<BufferedImage> Rimg = new ArrayList<>(n2);
      
            /*Copy data to temp arrays*/
            for (int i=0; i<n1; ++i) {
                L[i] = arr.get(l + i).getID();
            	Limg.add(i, arr.get(l + i).getSubimage());        	
            }
            
            for (int j=0; j<n2; ++j) {
                R[j] = arr.get(m + 1+ j).getID();         	
            	Rimg.add(j, arr.get(m + 1 + j).getSubimage());        	
            }
      
      
            /* Merge the temp arrays */
      
            // Initial indexes of first and second subarrays 
            int i = 0, j = 0; 
      
            // Initial index of merged subarry array 
            int k = l; 
            while (i < n1 && j < n2) { 
                if (L[i] <= R[j]) { 
                    arr.get(k).setID(L[i]);
                    arr.get(k).setSubimage(Limg.get(i));
                    i++; 
                    k++;
                } else { 
                    arr.get(k).setID(R[j]);
                    arr.get(k).setSubimage(Rimg.get(j));
                    j++;
                    k++;
                    break;
                } 
            } 
      
            /* Copy remaining elements of L[] if any */
            while (i < n1) { 
                arr.get(k).setID(L[i]);
                arr.get(k).setSubimage(Limg.get(i));
                i++;
                k++; 
            } 
      
            /* Copy remaining elements of R[] if any */
            while (j < n2) { 
                arr.get(k).setID(R[j]);
                arr.get(k).setSubimage(Rimg.get(j));
                j++; 
                k++; 
            } 
        }
    }
} 