import json
content = ''
with open('py-demo/main/o/mogu/蘑菇租房数据.json', encoding='utf-8') as file:
    content = file.read()
    # print(content)
    # print(type(content))
file.close()
list = json.loads(content)
# print(type(list))
# print(list)

for point in list:
    print(point['name'],point['lat'],point['lng'],point['minPrice'])
print(len(list))