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
    'Cookie': 'acw_tc=781bad2915827749673887537e0cb91f52f419a3b05810dbc1d6dc11373d9c',
    'Content-Length': '0',
    'Connection': 'keep-alive'
}
data = {
    'cityId': '289',
    'aggregationType': 'community',
    'minPrice': '3500',
    'maxPrice': '5000',
    'rentTypes': '3',
    'houseTypes': '2',
    'lng': '121.5026833931213',
    'lat': '31.164460912251403',
    'distanceMeters': '2000'
}
url = 'https://api.mgzf.com/room-find-web/find/map'

r = requests.post(url, data=data, headers=headers)
r.raise_for_status()
r.encoding = r.apparent_encoding
resDict = r.json()
resList = resDict['content']['list']
filename = 'py-demo/main/o/mogu/蘑菇租房数据.json'
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(resList, fp, indent=4, ensure_ascii=False))
