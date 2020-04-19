# https://api.mgzf.com/room-find-web/find/map
# ?cityId=289
# &aggregationType=community
# &minPrice=3500
# &maxPrice=5000
# &rentTypes=3
# &houseTypes=2
# &lng=121.5026833931213
# &lat=31.164460912251403
# &distanceMeters=2000
import requests
import json

headers = {
    'User-Agent': 'PostmanRuntime/7.22.0',
    'Accept': '*/*',
    'Cache-Control': 'no-cache',
    'Postman-Token': '12a1e0da-8655-4caa-b9e1-e52d878ae256',
    # 'Host':'api.mgzf.com',
    'Accept-Encoding': 'gzip, deflate, br',
    'Cookie': 'acw_tc=781bad2815861567768753503e1082dd4012e20d6fdf97c49021dcebe12986',
    'Content-Length': '0',
    'Connection': 'keep-alive'
}
data = {
    'cityId': '289',
    'aggregationType': 'community',
    'minPrice': '5000',
    'maxPrice': '7000',
    'rentTypes': '3',
    'houseTypes': '3',
    'lng': '121.5026833931213',
    'lat': '31.164460912251403',
    'distanceMeters': '2000'
}
url = 'https://api.mgzf.com/room-find-web/find/map'

alllist = [];

def getDatas(data, headers, i):
    r = requests.post(url, data=data, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    resDict = r.json()
    resList = resDict['content']['list']
    # filename = '蘑菇租房数据' + str(id) + '.json'
    if (resList == None or len(resList) < 1):
        print(str(id)+"没有获取到数据")
        return
    alllist.extend(resList)
    # fp = open(filename, 'w', encoding='utf-8')
    # print(json.dump(resList, fp, indent=4, ensure_ascii=False))


content = ''
with open('中心点坐标.json', encoding='utf-8') as file:
    content = file.read()
file.close()
listpos = json.loads(content)
# https://api.mgzf.com/room-find-web/find/map?cityId=289&aggregationType=community
# &lng=121.56181137644916&lat=31.219498252978642&distanceMeters=2000
id = 0
for p in listpos:
    data['lng'] = p[0];
    data['lat'] = p[1];
    getDatas(data, headers, id);
    id +=1


filename = '蘑菇租房数据new.json'
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(alllist, fp, indent=4, ensure_ascii=False))