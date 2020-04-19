import json


def getFileContent(filename):
    content = ''
    with open(filename, encoding='utf-8') as file:
        content = file.read()
    file.close()
    return content
    pass

def saveIntoFileByJson(filename,content):
    fp = open(filename, 'w', encoding='utf-8')
    json.dump(content, fp, indent=4, ensure_ascii=False)

if __name__ == '__main__':
    content = getFileContent("./subway.json")
    c_map = json.loads(content)
    subwayList = c_map['l']
    outputList = []
    for subway in subwayList:
        sub = {}
        sub['name'] = subway['kn']
        stations = []
        for st in subway['st']:
            stPos = st['sl'].split(',')
            stPos.append(st['n'])
            stations.append(stPos)
        sub['stations']=stations
        outputList.append(sub)

    saveIntoFileByJson('subway-stations.json',outputList)