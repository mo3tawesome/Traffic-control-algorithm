class Phase(object):
    lightchangetime = 0

    def __init__(self, l1, l2):
        self.L1 = l1
        self.L2 = l2
        self.TPmax = 90
        self.TQx = 0  # time till al queue pass
        self.TPx = 0  # max allowed time for green
        self.Qx = 0  # not used

    def getqx(self):
        if self.L1.Q > self.L2.Q:
            return self.L1.Q
        else:
            return self.L2.Q

    def gettqx(self):
        self.L1.computetq()
        self.L2.computetq()
        if self.L1.TQ > self.L2.TQ:
            return self.L1.TQ
        else:
            return self.L2.TQ

    def gettpx(self):
        if self.TQx < self.TPmax:
            return self.TQx
        else:
            return self.TPmax

    def changelightstatus(self):
        self.L1.lightStatus = not self.L1.lightStatus
        self.L2.lightStatus = not self.L2.lightStatus
        Phase.lightchangetime = self.L1.millis()
        self.Qx = self.getqx()
        self.TQx = self.gettqx()
        self.TPx = self.gettpx()

        if self.L1.lightStatus and self.L2.lightStatus is True:
            return True
        elif self.L1.lightStatus and self.L2.lightStatus is False:
            return True
        return False
