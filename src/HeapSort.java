import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class HeapSort {
	
    static int partition(ArrayList<Pixel> arr, int low, int high) { 
        int pivot = arr.get(high).getPosition(); 
  
        // index of smaller element 
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) { 
            // If current element is smaller than or 
            // equal to pivot 
            if (arr.get(j).getPosition() <= pivot) { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr.get(i).getPosition();
                BufferedImage tempImg = arr.get(i).getSubimage();
                arr.get(i).setPosition(arr.get(j).getPosition()); 
                arr.get(i).setSubimage(arr.get(j).getSubimage()); 
                arr.get(j).setPosition(temp); 
                arr.get(j).setSubimage(tempImg);
                return -1;
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr.get(i + 1).getPosition();
        BufferedImage tempImg = arr.get(i + 1).getSubimage();
        arr.get(i + 1).setPosition(arr.get(high).getPosition());
        arr.get(i + 1).setSubimage(arr.get(high).getSubimage()); 
        arr.get(high).setPosition(temp); 
        arr.get(high).setSubimage(tempImg); 
  
        return i + 1; 
    } 
  
    /* A[] --> Array to be sorted,  
   l  --> Starting index,  
   h  --> Ending index */
    static void quickSortIterative(ArrayList<Pixel> arr, int l, int h) 
    { 
        // Create an auxiliary stack 
        int[] stack = new int[h - l + 1]; 
  
        // initialize top of stack 
        int top = -1; 
  
        // push initial values of l and h to stack 
        stack[++top] = l; 
        stack[++top] = h; 
  
        // Keep popping from stack while is not empt.get(i)y 
        while (top >= 0) { 
            // Pop h and l 
            h = stack[top--]; 
            l = stack[top--]; 
  
            // Set pivot element at its correct position 
            // in sorted array 
            int p = partition(arr, l, h); 
            
            if(p == -1) {
            	return;
            }
  
            // If there are elements on left side of pivot, 
            // then push left side to stack 
            if (p - 1 > l) { 
                stack[++top] = l; 
                stack[++top] = p - 1; 
            } 
  
            // If there are elements on right side of pivot, 
            // then push right side to stack 
            if (p + 1 < h) { 
                stack[++top] = p + 1; 
                stack[++top] = h; 
            } 
        } 
    }
}