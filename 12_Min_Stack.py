class MinStack(object):

    def __init__(self):
        # do some intialize if necessary
        self.Stack = []
        self.minStack = []

    def push(self, number):
        # write yout code here
        self.Stack.append(number)
        if len(self.minStack) == 0 or number <= self.minStack[-1]:
            //It is critical to use <= here, as otherwise minStack could be empty
            self.minStack.append(number)

    def pop(self):
        # pop and return the top item in stack
        if self.Stack[-1] == self.minStack[-1]:
            self.minStack.pop()
        return self.Stack.pop()

    def min(self):
        # return the minimum number in stack
        return self.minStack[-1]
