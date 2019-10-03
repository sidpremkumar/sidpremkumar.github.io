
def gcd(n, d):
    while(n!=d)
        if n > d:
            n = n -d
        else:
            d = d - n
    return n

class Fraction:
    def __init__(self, n, d):
        self.num = n
        self.denom = d
        if self.denom == 0:
            raise ZeroDivisionError
        self.reduceToLowestTerms()
        self.adjustSigns()

    def adjustSigns(self):
        if (self.num * self.denom < 0):
			self.setSign('-')
        else:
			self.setSign('+')

    def setSign(self, sign):
        self.num = abs(self.num)
        self.denom = abs(self.denom)
        if (sign == '-'):
			self.num = -self.num

    def reduceToLowestTerms(self):
        gcd_var = gcd(abs(self.num), abs(self.denom))
        self.num = int(self.num / gcd_var)
        self.denom = int(self.denom / gcd_var)


    def Add(self, other):
        # a/b + c/d is (ad + cb)/(bd)
        return self.num*other.denom + self.denom*other.num, self.denom*other.denom

    def __str__(self):
        return '%s/%s' %(self.num, self.denom)

    def __cmp__(self, arg):
        pass
        # If we have time: How could we write this?


def main():
    f1 = Fraction(2,-2)
    f2 = Fraction(2,-4)
    f3 = f1.Add(f2)
    print(str(f1), str(f2), f3)

    # f8 = 0
    # print(Fraction.__cmp__(f4,f4),Fraction.__str__(f3),Fraction.__str__(f4),Fraction.__str__(f5),Fraction.__str__(f6), Fraction.__str__(f1), Fraction.__str__(f2))
    # if Fraction.__nonzero__(f8):
    #     print("It is a fraction")
    # else:
    #     print("It is not a fraction")
    # return 0
if __name__ == '__main__':
    main()
