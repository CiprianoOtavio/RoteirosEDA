package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		// TODO implement your code here
		//throw new UnsupportedOperationException("Not implemented yet!");
		if(array.length > 0 && array != null) {
			quickSortM3(array,0,array.length - 1);
			return recursiveFloor(array,x,null,0,array.length - 1);
		}
		return null;
	}

	private Integer recursiveFloor(Integer[] array, Integer x, Integer floor, int leftIndex, int rightIndex) {
		if(leftIndex <= rightIndex && leftIndex >= 0 && rightIndex < array.length) {
			int middle = (rightIndex + leftIndex)/2;
			if(array[middle].compareTo(x) == 0) {
				return array[middle];
			}
			if(array[middle].compareTo(x) > 0) {
				return recursiveFloor(array,x,floor,leftIndex,middle -1 );
			}
			if(array[middle].compareTo(x) < 0) {
				return recursiveFloor(array,x,array[middle],middle + 1,rightIndex );
			}
		}
		return floor;
	}
	private void quickSortM3(Integer[] array, int leftIndex, int rightIndex) {
		// TODO Auto-generated method stub
		if(leftIndex < 0 || leftIndex >= array.length || rightIndex >= array.length || rightIndex < 0) {
			return;

		}
		if(leftIndex < rightIndex) {
			int pivotPosition = particiona(array,leftIndex,rightIndex);
			quickSortM3(array,leftIndex,pivotPosition - 1);
			quickSortM3(array,pivotPosition + 1,rightIndex);
		}
	}
	private int particiona (Integer [] array, int start, int end) {

		int middle = (start + end)/2;
		mD3Sort(array,start,middle,end);
		Integer pivot = array[middle];
		util.Util.swap(array,middle,end-1);
		int pivotIndex = end - 1;

		for(int j = pivotIndex-1; j > start;j-- ) {
			if(pivot.compareTo(array[j]) < 0) {
				pivotIndex--;
				util.Util.swap(array,pivotIndex,j);
			}
		}
		util.Util.swap(array,end-1,pivotIndex);

		return pivotIndex;
	}

	private void mD3Sort(Integer[] array, int leftIndex, int middle, int rightIndex) {
		if(array[leftIndex].compareTo(array[middle]) > 0) {
			util.Util.swap(array,leftIndex, middle);
		}
		if(array[leftIndex].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array, leftIndex, rightIndex);
		}
		if(array[middle].compareTo(array[rightIndex]) > 0) {
			util.Util.swap(array,middle ,rightIndex );
		}
	}
}