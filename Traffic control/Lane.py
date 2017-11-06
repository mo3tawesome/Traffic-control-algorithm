import time as time_
import Phase


class Lane(object):
    Tthreshold = 120  # max wait time
    lightStatus = False  # true for green, false for red
    T1 = 6  # duration till first car passes
    t = 1  # time till next car takes the pose of current car

    def __init__(self, d, l):
        self.D = d
        self.L = l
        self.Q = 0  # queue
        self.TQ = 0  # time till all queue passes
        self.WT = 0  # wait time so far
        self.ascl1 = self.__call__(0, 0)
        self.ascl2 = self.__call__(0, 0)
        self.ascl3 = self.__call__(0, 0)
        
    def __call__(self,d,l):
        self.D =d
        self.l = l
    
    

    @staticmethod
    def millis():
        return int(round(time_.time() * 1000))

    def computewt(self):
        if self.lightStatus:
            self.WT = 0
        else:
            self.WT = ((self.millis() - Phase.Phase.lightchangetime) / 1000)
        return self.WT

    def computetq(self):
        self.TQ = self.T1 + (self.t * (self.Q - 1))
