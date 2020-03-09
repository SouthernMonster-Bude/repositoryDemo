import sys
from PyQt5.Qt import *


class MyWindow(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MyWindow")
        self.resize(500, 500)
        self.setup_ui()

    def setup_ui(self):
        obj = MyLabel(self)
        pass


class MyLabel(QLabel):
    def __init__(self, *__args):
        super().__init__(*__args)
        self.setText('10')
        self.id = self.startTimer(1000)

    def timerEvent(self, evt):
        cur_sec = int(self.text()) - 1
        if cur_sec < 0:
            self.killTimer(self.id)
            return
        self.setText(str(cur_sec))
        print(evt, cur_sec)


if __name__ == '__main__':
    app = QApplication(sys.argv)
    w = MyWindow()

    w.show()
    sys.exit(app.exec_())
