import requests
import json
import time

headers = {
    'User-Agent': 'PostmanRuntime/7.22.0',
    'Accept': '*/*',
    'Cache-Control': 'no-cache',
    'Postman-Token': '12a1e0da-8655-4caa-b9e1-e52d878ae256',
    # 'Host':'api.mgzf.com',
    'Accept-Encoding': 'gzip, deflate, br',
    'Connection': 'keep-alive'
}
data = {
    'night': '1',
    'group': '1',
    'pure_walk': '1',
    'date': '2020-2-29',
    'time': '12-04',
    'type': '0',
    'eta': '1',
    'x1': '121.506605',
    'y1': '31.166959',
    'ad1': '310115',
    'x2': '121.384772',
    'y2': '31.166542',
    'ad2': '310000'
}


def calTime(point):
    time.sleep(0.1)
    url = 'https://www.amap.com/service/nav/bus?'
    data['x1'] = str(point['x'])
    data['y1'] = str(point['y'])
    for (k, v) in data.items():
        url += '&' + k + '=' + v
    r = requests.get(url, headers=headers)
    r.raise_for_status()
    r.encoding = r.apparent_encoding
    resDict = r.json()
    expensetime = resDict['data']['buslist'][0]['expensetime']
    point['expensetime'] = float(expensetime) / 60.0
    print(point)
    return point


if __name__ == '__main__':
    content = ''
    with open('蘑菇租房数据.json', encoding='utf-8') as file:
        content = file.read()
        file.close()
    reslist = []
    list = json.loads(content)
    # p = list[0]
    for p in list:
        point = {'y': p['lat'], 'x': p['lng'], 'name': p['name'], 'price': p['minPrice']}
        point = calTime(point)
        rate = 0.7
        point['suggestion'] = 1.0 / (float(point['price']) * rate) / (float(point['expensetime']) * (1 - rate))
        reslist.append(point)
    filename = '距离和价格.json'
    fp = open(filename, 'w', encoding='utf-8')
    print(json.dump(reslist, fp, indent=4, ensure_ascii=False))
