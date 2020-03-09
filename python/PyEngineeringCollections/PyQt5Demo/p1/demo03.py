import sys
from PyQt5.Qt import *
class MyWindow(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MyWindow")
        self.resize(500,500)
        self.setup_ui()
    def setup_ui(self):
        lab = QLabel(self)
        lab.setText("QLabel标签")

if __name__ == '__main__':
    app = QApplication(sys.argv)
    w = MyWindow()
    w.show()
    sys.exit(app.exec_())


