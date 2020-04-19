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
    content = getFileContent("./subway-stations.json")
    subwayList = json.loads(content)
    allStationsSet=set()
    for subway in subwayList:
        for st in subway['stations']:
            allStationsSet.add(tuple(st))

    saveIntoFileByJson('subway-all-stations.json',list(allStationsSet))