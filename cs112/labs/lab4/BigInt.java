public BigInt mul(BigInt other) {

      BigInt BigIntAnswer = new BigInt(-1);
      // Need to check two things before we can start the actual multiplication algorithm
      // First, we must make sure that both BigInts are not NaBI
      // Then, we check to make sure that it is possible for their product to fit as a BigInt
      if (!isNaBI() && !other.isNaBI()){
        int[] B = other.getArray();
        int A_index = this.findFirstNonZero();
        int B_index = other.findFirstNonZero();
        int A_length = SIZE-A_index;
        int B_length = SIZE-B_index;
        if (A_length + B_length - 1 <= SIZE){
          BigIntAnswer = new BigInt(0); // Create our answer BigInt, initialized to 0.
          int rem = 0;
        // Outer For loop: Keeps track of BigInt B (Our Operator)
          for (int i=SIZE-1; i>= B_index; i--){
            int[] temp = new int[SIZE];
            int i_tmp;
            for (i_tmp=0; i_tmp < SIZE; i_tmp++)
              temp[i_tmp] = 0; // Initializes temp
              i_tmp = i;
          // Inner For Loop, keeps track of BigInt A (Our Operand)
            for (int j = SIZE-1; j >= A_index; j--){
              int product = A[j]*B[i] + rem;
              rem = product / 10;
              product %= 10;
              temp[i_tmp--] = product;
            }
            if (i_tmp >= 0)
              temp[i_tmp] = rem; // Add the remainder to the temp (Only if there is an open index in the array)
            if (i_tmp < 0 && rem > 0)
              BigIntAnswer.makeNaBI(); // If this condition holds, then temp is NaBI, so the sum will be NaBI
            else
              BigIntAnswer = BigIntAnswer.add(new BigInt(temp));
            if (BigIntAnswer.isNaBI())
              break;
          }
        }
      }
      return BigIntAnswer;
    }