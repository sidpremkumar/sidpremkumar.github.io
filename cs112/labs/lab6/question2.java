publicstaticintfindLastOccurance(int[] array, inttargetValue) {
		intans= -1;
		intleftIndex= 0;
		intrightIndex= array.length- 1;
		while(leftIndex<= rightIndex) {
			intmid= leftIndex+ (rightIndex- leftIndex+ 1) / 2;
			intmidVal= array[mid];
			if(midVal< targetValue) {
				leftIndex= mid+ 1;
			} elseif(midVal> targetValue) {
				rightIndex= mid- 1;
			} elseif(midVal== targetValue) {
				ans= mid;
				leftIndex= mid+ 1;
			}
		}
		returnans;
	}

	publicstaticintfindFirstOccurance(int[] array, inttargetValue) {
		intans= -1;
		intleftIndex= 0;
		intrightIndex= array.length- 1;
		while(leftIndex<= rightIndex) {
			intmid= leftIndex+ (rightIndex- leftIndex+ 1) / 2;
			intmidVal= array[mid];
			if(midVal< targetValue) {
				leftIndex= mid+ 1;
			} elseif(midVal> targetValue) {
				rightIndex= mid- 1;
			} elseif(midVal== targetValue) {
				ans= mid;
				rightIndex= mid- 1;
			}
		}
		returnans;
	}
