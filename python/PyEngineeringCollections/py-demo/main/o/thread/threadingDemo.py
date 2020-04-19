import threading
import time




class myThread(threading.Thread):
    def __init__(self, threadId, name, delay):
        threading.Thread.__init__(self)
        self.threadId = threadId
        self.name = name
        self.delay = delay

    def run(self) -> None:
        print("开始线程：" + self.name)
        print_time(self.name, self.delay, 6)
        print("终止线程：" + self.name)

def print_time(thread_name, delay, counter):
    while counter:
        time.sleep(delay)
        print("%s : %s" % (thread_name, counter))
        counter -= 1


if __name__ == '__main__':
    print('主线程开始')

    thread1 = myThread(1, "Td-1", 1)
    thread2 = myThread(2, "Td-2", 3)

    thread1.start()
    thread2.start()

    print('主线程结束')