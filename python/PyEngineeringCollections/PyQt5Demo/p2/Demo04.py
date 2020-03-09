import sys
from PyQt5.Qt import *


class App(QApplication):
    def notify(self, object, event):
        if event.type() == QEvent.MouseButtonPress:
            print(object, event)
        return super().notify(object, event)


class Btn(QPushButton):
    def mouseDoubleClickEvent(self, *args, **kwargs):
        print('鼠标双击点击')
        super().mouseDoubleClickEvent(*args, **kwargs)


class MyWindow(QWidget):
    def __init__(self):
        super().__init__()
        self.setWindowTitle("MyWindow")
        self.resize(500, 500)
        self.setup_ui()

    def setup_ui(self):
        btn = Btn(self)
        btn.setText('按钮')
        btn.move(100, 100)

        btn.pressed.connect(btn_click)


def btn_click():
    print('点击了按钮')


if __name__ == '__main__':
    app = App(sys.argv)
    w = MyWindow()
    w.show()
    sys.exit(app.exec_())
