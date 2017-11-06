import Lane


class Controller(object):
    arrayoflanes = [[Lane.Lane(0, 0) for j in range(2)] for i in range(4)]
    L1 = Lane.Lane(0, 0)
    L2 = Lane.Lane(0, 0)
    Qmax = 0

    @staticmethod
    def getqmax():
        for i in range(4):
            for j in range(2):
                if Controller.arrayoflanes[i][j].Q > Controller.Qmax:
                    Controller.Qmax = Controller.arrayoflanes[i][j].Q
                    Controller.L1 = Controller.arrayoflanes[i][j]

        return Controller.Qmax

    @staticmethod
    def getl2(l1):

        qlocalmax = 0
        if l1.ascl1.Q > qlocalmax:
            qlocalmax = l1.ascl1.Q
        Controller.L2 = l1.ascl1

        if l1.ascl2.Q > qlocalmax:
            qlocalmax = l1.ascl2.Q
        Controller.L2 = l1.ascl2

        if l1.ascl3.Q > qlocalmax:
            qlocalmax = l1.ascl3.Q
        Controller.L2 = l1.ascl3

        return Controller.L2

    @staticmethod
    def lanesinit():
        for i in range(4):
            for j in range(2):
                Controller.arrayoflanes[i][j] = Lane.Lane(i, j)
                Controller.arrayoflanes[i][j].D = i
                Controller.arrayoflanes[i][j].L = j

    @staticmethod
    def casesinit():
        # N S E w  F R
        # 0 1 2 3  0 1

        # N,F
        Controller.arrayoflanes[0][0].ascl1 = Controller.arrayoflanes[0][1]
        Controller.arrayoflanes[0][0].ascl2 = Controller.arrayoflanes[1][0]
        Controller.arrayoflanes[0][0].ascl3 = Controller.arrayoflanes[3][1]

        # S,F
        Controller.arrayoflanes[1][0].ascl1 = Controller.arrayoflanes[1][1]
        Controller.arrayoflanes[1][0].ascl2 = Controller.arrayoflanes[2][1]
        Controller.arrayoflanes[1][0].ascl3 = Controller.arrayoflanes[0][0]

        # E,F
        Controller.arrayoflanes[2][0].ascl1 = Controller.arrayoflanes[2][1]
        Controller.arrayoflanes[2][0].ascl2 = Controller.arrayoflanes[3][0]
        Controller.arrayoflanes[2][0].ascl3 = Controller.arrayoflanes[0][1]

        # W,F
        Controller.arrayoflanes[3][0].ascl1 = Controller.arrayoflanes[3][1]
        Controller.arrayoflanes[3][0].ascl2 = Controller.arrayoflanes[1][1]
        Controller.arrayoflanes[3][0].ascl3 = Controller.arrayoflanes[2][0]

        # N,R
        Controller.arrayoflanes[0][1].ascl1 = Controller.arrayoflanes[0][0]
        Controller.arrayoflanes[0][1].ascl2 = Controller.arrayoflanes[1][1]
        Controller.arrayoflanes[0][1].ascl3 = Controller.arrayoflanes[2][0]

        # S,R
        Controller.arrayoflanes[1][1].ascl1 = Controller.arrayoflanes[1][0]
        Controller.arrayoflanes[1][1].ascl2 = Controller.arrayoflanes[0][1]
        Controller.arrayoflanes[1][1].ascl3 = Controller.arrayoflanes[3][0]

        # E,R
        Controller.arrayoflanes[2][1].ascl1 = Controller.arrayoflanes[2][0]
        Controller.arrayoflanes[2][1].ascl2 = Controller.arrayoflanes[3][1]
        Controller.arrayoflanes[2][1].ascl3 = Controller.arrayoflanes[1][0]

        # W,R
        Controller.arrayoflanes[3][1].ascl1 = Controller.arrayoflanes[3][0]
        Controller.arrayoflanes[3][1].ascl2 = Controller.arrayoflanes[2][1]
        Controller.arrayoflanes[3][1].ascl3 = Controller.arrayoflanes[0][0]
