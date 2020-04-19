import requests
import threading
import time
import json


def getFileContent(filename):
    content = ''
    with open(filename, encoding='utf-8') as file:
        content = file.read()
    file.close()
    return content


if __name__ == '__main__':
    content = getFileContent('合川路到各个地铁站的时间.json')
    HCToAnyStTimeLs = json.loads(content)
    content = getFileContent('李子园到各个地铁站的时间.json')
    LZToAnyStTimeLs = json.loads(content)
    content = getFileContent('广兰路到各个地铁站的时间.json')
    GLToAnyStTimeLs = json.loads(content)
    content = getFileContent('集电港到各个地铁站的时间.json')
    JDGToAnyStTimeLs = json.loads(content)

    # HCToAnyStTimeLs = sorted(HCToAnyStTimeLs, key=lambda item: item['expensetime'])
    # LZToAnyStTimeLs = sorted(LZToAnyStTimeLs, key=lambda item: item['expensetime'])

    limitTime = 50

    HCToAnyStTimeLs = list(filter(lambda it: it['expensetime'] < limitTime, HCToAnyStTimeLs))
    LZToAnyStTimeLs = list(filter(lambda it: it['expensetime'] < limitTime+20, LZToAnyStTimeLs))
    JDGToAnyStTimeLs = list(filter(lambda it: it['expensetime'] < limitTime, JDGToAnyStTimeLs))
    GLToAnyStTimeLs = list(filter(lambda it: it['expensetime'] < 20, GLToAnyStTimeLs))

    commonEndLs = []

    for i in HCToAnyStTimeLs:
        for j in LZToAnyStTimeLs:
            if (i['end'][2] == j['end'][2]):
                # for k in GLToAnyStTimeLs:
                for k in JDGToAnyStTimeLs:
                    if (i['end'][2] == k['end'][2]):
                        print(i['end'])
                        commonEndLs.append(i['end'])
                pass
                break
            pass
        pass

    for e in commonEndLs:
        e.append('地铁站')

    filename = "合川路和李子园在一个小时内都能到达的地铁站.json"
    fop = open(filename, 'w', encoding='utf-8')
    json.dump(commonEndLs, fop, indent=4, ensure_ascii=False)
    print(len(commonEndLs))
