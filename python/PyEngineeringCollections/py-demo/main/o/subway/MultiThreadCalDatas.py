import requests
import threading
import time
import json

timeList = []
# 线程部分
threadLock = threading.Lock()
threads = []

headers = {
    'User-Agent': 'PostmanRuntime/7.22.0',
    'Accept': '*/*',
    'Cache-Control': 'no-cache',
    'Postman-Token': '12a1e0da-8655-4caa-b9e1-e52d878ae256',
    # 'Host':'api.mgzf.com',
    'Accept-Encoding': 'gzip, deflate, br',
    'Connection': 'keep-alive',
    'Set-Cookie': 'acw_tc=2760829115861608631393981ec12d2d52bae3a303d55234899e359a782480;path=/;HttpOnly;Max-Age=2678401'
}
data = {
    'night': '1',
    'group': '1',
    'pure_walk': '1',
    'date': '2020-2-29',
    'time': '12-04',
    'type': '0',
    'eta': '1',
    'x1': '起点x',
    'y1': '起点y',
    'ad1': '310115',
    'x2': '终点x',
    'y2': '终点y',
    'ad2': '310000'
}


def handle():
    print(5)


def getFileContent(filename):
    content = ''
    with open(filename, encoding='utf-8') as file:
        content = file.read()
    file.close()
    return content


def calTime(point, tPoint):
    time.sleep(0.1)
    print(threading.current_thread().getName() + ' 开始')
    url = 'https://www.amap.com/service/nav/bus?'
    data['x1'] = str(point[0])
    data['y1'] = str(point[1])
    data['x2'] = str(tPoint[0])
    data['y2'] = str(tPoint[1])
    for (k, v) in data.items():
        url += '&' + k + '=' + v
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    resDict = r.json()
    result = 0
    mapP = {'start': point, 'end': tPoint}
    try:
        expensetime = resDict['data']['buslist'][0]['expensetime']
        result = round(float(expensetime) / 60.0)
    except KeyError as e:
        result = 6000000000
        pass
    except ValueError:
        print("expensetime" + str(expensetime))
        result = 6000000000
        print(type(expensetime))
        pass
    mapP['expensetime'] = result
    print(mapP)
    # 写入控制锁
    threadLock.acquire()
    timeList.append(mapP)
    threadLock.release()
    print(threading.current_thread().getName() + ' 结束')
    # return mapP


if __name__ == '__main__':
    print("主线程开始")
    # 获取各个地铁站经纬信息 type list
    content = getFileContent('./subway-all-stations.json')
    stations = json.loads(content)
    # 目标点
    HCpos = ("121.384772", "31.166542", "合川路")
    LZpos = ("121.389969", "31.269020", "李子园")
    JDGpos = ("121.635386", "31.223028", "集电港")
    GLpos = ("121.621072", "31.21105", "广兰路")

    # 遍历地铁站 异步获取目标站点的到各个地铁的时间
    for st in stations:
        if HCpos[2] != st[2]:
            # 创建新线程
            td = threading.Thread(target=calTime, name=HCpos[2] + 'to' + st[2], args=(HCpos, st))
            td.start() # 改进控制并发数量
            threads.append(td)
        # if LZpos[2] != st[2]:
        #     # 创建新线程
        #     td = threading.Thread(target=calTime, name=LZpos[2] + 'to' + st[2], args=(LZpos, st))
        #     # 开启新线程
        #     # td.start() # 改进控制并发数量
        #     # 添加线程到列表
        #     threads.append(td)
        # if GLpos[2] != st[2]:
        #     td = threading.Thread(target=calTime, name=GLpos[2] + 'to' + st[2], args=(GLpos, st))
        #     threads.append(td)
    # 并发控制为50 间隔 0.5s
    maxNum = 1
    for t in threads:
        if maxNum % 50 == 0:
            time.sleep(0.5)
        maxNum += 1
        t.start()

    # 等待所有线程完成
    for t in threads:
        t.join()

    # 保存数据
    filename = "广兰路到各个地铁站的时间.json"
    fop = open(filename, 'w', encoding='utf-8')
    json.dump(timeList, fop, indent=4, ensure_ascii=False)
    fop.close()
    print("退出主线程")
    pass
