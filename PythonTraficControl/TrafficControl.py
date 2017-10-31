from random import randint
import Controller
import Recived
import Phase
import Lane


def main():
    Controller.Controller.lanesinit()
    Controller.Controller.casesinit()
    while True:
        # get all the JSONs of the lanes
        # get an array of JSONs

        # *******************************************************
        # for the sake of the trial i'll fill it with dummy numbers
        recivedArray = [[Recived.Recived() for j in range(2)] for i in range(4)]
        for i in range(4):
            for j in range(2):
                recivedArray[i][j] = Recived.Recived()
                recivedArray[i][j].D = i
                recivedArray[i][j].L = j
                recivedArray[i][j].Q = randint(0, 25)
                # ***************************************************
        for i in range(4):
            for j in range(2):
                Controller.Controller.arrayoflanes[i][j].Q = recivedArray[i][j].Q
                if Controller.Controller.arrayoflanes[i][j].Q > Controller.Controller.Qmax:
                    Controller.Controller.Qmax = Controller.Controller.arrayoflanes[i][j].Q
                    Controller.Controller.L1 = Controller.Controller.arrayoflanes[i][j]
        for i in range(4):
            for j in range(2):
                WT = Controller.Controller.arrayoflanes[i][j].computewt()
                if WT > Lane.Lane.Tthreshold:
                    Controller.Controller.L1 = Controller.Controller.arrayoflanes[i][j]

        Controller.Controller.getl2(Controller.Controller.L1)
        p = Phase.Phase(Controller.Controller.L1, Controller.Controller.L2)

        p.changelightstatus()
        print(p.TPx)
        print(p.L1.D)
        print(p.L1.L)
        print(p.L1.Q)
        print(p.L2.D)
        print(p.L2.L)
        print(p.L2.Q)

        # Send P to the server

        while (Lane.Lane.millis() - p.lightchangetime) / 1000 < p.TPx:
            pass
        p.changelightstatus()


if __name__ == '__main__':
    main()
