import _thread
import time


def print_time(thread_name, delay):
    count = 0
    while count < 5:
        count += 1
        time.sleep(delay)
        print("%s : %s" % (thread_name, count))


try:
    _thread.start_new_thread(print_time, ('Td-1', 3))
    _thread.start_new_thread(print_time, ('Td-2', 5))
except:
    print("Error 启动线程出错")

while 1:
    pass
