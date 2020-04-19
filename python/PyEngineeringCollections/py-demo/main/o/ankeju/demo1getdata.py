# https://sh.zu.anjuke.com/map/ajax/pclist/Api_get_facet?
# p=1&maxp=3&room_num=0&price_id=0&rent_type=0&price_min=0&price_max=0&lx_id=&tag_id=&orient_id=&order_id=0&lat=31.222315_31.224959&lng=121.452666_121.458325&zoom=19&ib=1&et=Y2M3NW&bst=pzm128

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
    'p': 1,
    'maxp':1,
    'room_num': 3,
    'price_id': 0,
    'rent_type': 1,
    'price_min': 4000,
    'price_max': 6500,
    'order_id': 0,
    'lat': '31.177666_31.18851',
    'lng': '121.486132_121.509398',
    'community_id': 100029196,
    'zoom': 17,
    'ib': 1,
    'et': '8785a2',
    'bst': 'pzm872'
}
# url = 'https://sh.zu.anjuke.com/map/ajax/pclist/Api_get_house_list'
url = 'https://sh.zu.anjuke.com/map/ajax/pclist/Api_get_facet'
unitRect = (-0.022637000000003127, -0.01057400000000186)

alllist = [];


def getDatas(data, headers, i):
    r = requests.post(url, data=data, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    resDict = r.json()
    resList = resDict['val']['community_list']
    if (resList == None or len(resList) < 1):
        print(str(id) + "没有获取到数据")
        return
    alllist.extend(resList)


content = ''
with open('../mogu/中心点坐标.json', encoding='utf-8') as file:
    content = file.read()
file.close()
listpos = json.loads(content)
id = 0
for p in listpos:
    # 'lat': '31.241777_31.252351',
    # 'lng': '121.55605_121.578687',
    data['lng'] = str(float(p[0]) + unitRect[0] * 0.5) + '_' + str(float(p[0]) - unitRect[0] * 0.5);
    data['lat'] = str(float(p[1]) + unitRect[1] * 0.5) + '_' + str(float(p[1]) - unitRect[1] * 0.5);
    getDatas(data, headers, id);
    id += 1

filename = '安居客数据new.json'
fp = open(filename, 'w', encoding='utf-8')
print(json.dump(alllist, fp, indent=4, ensure_ascii=False))
