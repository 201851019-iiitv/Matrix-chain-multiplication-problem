package hello;

public class matrix_chain_multiplication2 {
//bottom up memoized approach,.it's time complexity o(n^3);
	static int Matrix_chain_order(int dim[]) 
    { 
		int n=dim.length-1;
        int m[][] = new int[n][n]; 
  
        int i, j, k, l, q; 
        for (i = 1; i < n; i++) 
            m[i][i] = 0; 
        for (l=2; l<n; l++) 
        { 
            for (i=1; i<n-l+1; i++) 
            { 
                j = i+l-1; 
                if(j == n) 
                	continue; 
                m[i][j] = Integer.MAX_VALUE; 
                for (k=i; k<=j-1; k++) 
                { 
                    q = m[i][k] + m[k+1][j] + dim[i-1]*dim[k]*dim[j]; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
  
        return m[1][n-1]; 
    }
	 public static void main(String args[]) 
	    { 
	        int dim[] = new int[] {10, 20, 30, 40, 30};  
	  
	        int n = Matrix_chain_order(dim);
	        System.out.println(n);
	  
	    } 
}
