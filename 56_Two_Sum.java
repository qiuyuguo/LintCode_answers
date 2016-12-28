public class Solution {
    /*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }    	
    	int[] original = new int[numbers.length];
    	for (int n=0;n<numbers.length;n++){
    		original[n]=numbers[n];
    	}
        Arrays.sort(numbers);
        int num1=-1;
        int num2=-1;
        int i=0;
        int j=numbers.length-1;
        while (i<j){
        	if (numbers[i]+numbers[j]==target){
        		num1 = numbers[i];
        		num2 = numbers[j];
        		break;
        	}
        	else if (numbers[i]+numbers[j]>target){
        		j--;
        	}
        	else if (numbers[i]+numbers[j]<target){
        		i++;
        	}
        }
        
        int[] result = new int[2];
        result[0]=-1;
        result[1]=-1;
        for (int k=0;k<original.length;k++){
        	if (original[k]==num1 || original[k]==num2){
        		if (result[0]==-1) result[0]=k+1;
        		else {
        		    result[1]=k+1;
        		    break;
        		}
        	}
        }
        return result;
    }
}
