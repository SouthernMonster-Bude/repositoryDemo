import sys
from PyQt5.QtWidgets import QApplication, QWidget

if __name__ == '__main__':
    # 创建QApplication实例
    app = QApplication(sys.argv)
    # 创建一个窗口
    w = QWidget()
    # 设置大小
    w.resize(400, 200)
    # 移动窗口
    w.move(300, 300)
    # 设置标题
    w.setWindowTitle('第一个基于PyQt5的左面应用')
    # 显示
    w.show()
    # 进入程序的主循环、并通过exit函数确保主循环安全结束
    sys.exit(app.exec_())
