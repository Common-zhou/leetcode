## 二分查找

### 三个前置条件

1. 有序。目标函数单调性(单调递增或者递减)
2. 能够通过索引访问 index accessible
3. 有上下界 bounded



### 模板

```java
int left=0,right=nums.length()-1;
while(left <= right){
	int mid = (left+right)/2;
	if(nums[mid] == target){
		return mid;
	}else if(nums[mid] > target){
		right = mid - 1;
	}else{
		left = mid+1;
	}
}
```



如果是一个平移过的数组，是否可以用二分查找呢？

例如[6,7,8,9,0,1,2,3,4,5]

要查找3，可能实现一种logn的算法吗？



```
nums[mid] 有两种可能。要不就是落在左半部分，要不就是落在右半部分。

1.判断mid 和right的大小 。

		如果是递增的。
				左右和target比较。 如果target在里面 就往 右走。
				否则往左走
		如果不是递增的。
			那左侧是递增的。
                左右和target比较。 如果target在里面 就往 左走。
                否则往右走
```

